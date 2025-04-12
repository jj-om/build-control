/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import BOs_negocios.bo_material;
import validadores.Validaciones;
import admActividades.FAdmActividades;
import admActividades.FAdmMateriales;
import admActividades.IAdmActividades;
import admActividades.IAdmMateriales;
import admObraSeleccionada.FAdmObraSeleccionada;
import admObraSeleccionada.IAdmObraSeleccionada;
import dto.ActividadDTO;
import dto.AsistenciaPersonalDTO;
import dto.BitacoraDTO;
import dto.DetallesBitacoraDTO;
import dto.HerramientaDTO;
import dto.HerramientaIngresadaDTO;
import dto.ListaAsistenciaDTO;
import dto.MaquinariaDTO;
import dto.MaterialDTO;
import dto.MaterialIngresadoDTO;
import dto.ObraDTO;
import dto.RecursoDTO;
import excepciones.AdmActividadesException;
import excepciones.AdmMaterialesException;
import excepciones.AdmObraSeleccionadaException;
import exception.PresentacionException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ximena
 */
public class CoordinadorNegocio {
    private static CoordinadorNegocio coordinadorNegocio;
    
    // Crear lista para guardar las actividades
    private List<ActividadDTO> actividades;
    // Crear lista para guardar los recursos con los que cuenta la obra
    private List<RecursoDTO> recursos;
    // Crear lista de los materiales dentro del coordinador
    private List<MaterialIngresadoDTO> materialesIngresados;
    // Crear lista para guardar las herramientas dentro de la obra
    private List<HerramientaDTO> herramientas;
    // Crear lista para guardar las herramientas
    private List<HerramientaIngresadaDTO> herramientasIngresadas;
    // Crear lista para guardar la maquinaria
    private List<MaquinariaDTO> maquinaria;
    // Crear lista para guardar la maquinaria que se ingresó
    private List<MaquinariaDTO> maquinariaIngresada;
    // Objeto para guardar la lista de asistencia
    private ListaAsistenciaDTO asistencia;
    // private DetallesBitacoraDTO detallesBitacora;
    
    //TEMPORAL LISTA DE OBRAS
    private List<ObraDTO> obras;
    // Instancia del subsistema de obra seleccionada
    private IAdmObraSeleccionada admObraSeleccionada;
    // Instancia del subsistema de actividades
    private IAdmActividades admActividades;
    // Instancia del subsistema de materiales
    private IAdmMateriales admMateriales;
    

    private CoordinadorNegocio() {
        // Inicializar fachada desde el coordinador
        this.admActividades = new FAdmActividades();
        this.admObraSeleccionada = new FAdmObraSeleccionada();
        this.admMateriales = new FAdmMateriales();
        
        // Iniciar listas
        this.actividades = new ArrayList<>();
        this.recursos = new ArrayList<>();
        this.materialesIngresados = new ArrayList<>();
        this.herramientas = new ArrayList<>();
        this.herramientasIngresadas = new ArrayList<>();
        this.maquinaria = new ArrayList<>();
        this.maquinariaIngresada = new ArrayList<>();
        this.obras = new ArrayList<>();
        
        this.asistencia = new ListaAsistenciaDTO();
        
    }
    
    // Método para obtener la instancia
    public static CoordinadorNegocio getInstance() {
        if (coordinadorNegocio == null) {
            coordinadorNegocio = new CoordinadorNegocio();
        }
        return coordinadorNegocio;
    }
    
    // MÉTODOS PARA EL FORMULARIO DE ACTIVIDADES
    // Método para registrar una actividad en la lista
    public void registrarActividad(String titulo, String descripcion) throws PresentacionException {
        // Validar antes de agregar la actividad
        String mensajeError = Validaciones.validarActividad(titulo, descripcion);
        
        if (mensajeError != null) {
            throw new PresentacionException(mensajeError);
        }
        
        // Agregar actividad después de validar
        actividades.add(new ActividadDTO(titulo, descripcion));
    }
    
    // Devuelve la lista de actividades
    public List<ActividadDTO> obtenerActividades() {
        return actividades;
    }
    
    // Elimina las actividades dentro de la lista
    public void cancelarActividades() {
        actividades.clear();
    }
    
    // Guarda la lista de actividades, enviando la lista a la fachada admActividades en la capa de negocio
    public boolean registrarActividades() throws PresentacionException {
        try {
            return admActividades.registrarActividades(actividades);
        } catch (AdmActividadesException e) {
            throw new PresentacionException("Error al registrar actividad: " + e.getMessage());
        }
    }
    
    // MÉTODOS PARA EL FORMULARIO DE MATERIALES
    // Regresa la lista de materiales
    public List<RecursoDTO> obtenerMateriales() throws AdmMaterialesException {
        return admMateriales.obtenerRecursosObra();
    }
    
    // Registrar los materiales mediante el subsistema
    public boolean registrarMateriales(List<MaterialIngresadoDTO> materialIngresado) throws PresentacionException, AdmMaterialesException {
        try {
            // Validar que el recurso sea suficiente
            validarRecursos(materialIngresado);
            
//            // Prueba para forzar a que lance la excepción.
//            this.materialesIngresados = null;
//            throw new AdmMaterialesException("Error de al registrar materiales en bitácora.");
            
            // Asignarlo a la lista
            this.materialesIngresados = materialIngresado;
            // Registrar los materiales
            return admMateriales.registrarMateriales(materialIngresado);
        } catch (PresentacionException e) {
            throw new PresentacionException("Error al registrar materiales en la bitácora.", e);
        }
    }
    
    // Valida que los recursos asignados a la obra y las cantidades ingresadas sean coherentes (no se haya excedido de material)
    private void validarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws PresentacionException {
        try {
            admMateriales.validarRecurso(materialIngresado);
        } catch (Exception e) { // Cambiar a AdmMaterialesException
            // Si al menos un material no fue válido
            throw new PresentacionException(e.getMessage(), e);
        }
    }
    
    // Restar material ingresado de los recursos. Cambiar a subsistema de AdmMateriales
    public void restarMaterial() throws PresentacionException, AdmMaterialesException {
        // Obtener lista de los recursos de la obra
        List<RecursoDTO> recursosObra = admMateriales.obtenerRecursosObra();
        // Para cada material ingresado para usarse, revisar los recursos dentro de la obra
        for (MaterialIngresadoDTO materialIngresado : materialesIngresados) {
            for (RecursoDTO recurso : recursosObra) {
                // Si el nombre del material dentro del recurso y del recurso ingresado coindide, restarle la cantidad
                if (recurso.getMaterial().getNombre().equals(materialIngresado.getRecurso().getMaterial().getNombre())) {
                    // Si la cantidad que hay en los recursos es mayor o igual a la cantidad ingresada, se le resta y actualiza la cantidad de recursos
                    if (recurso.getCantidad() >= materialIngresado.getCantidad()) {
                        Integer nuevoStock = recurso.getCantidad() - materialIngresado.getCantidad();
                        actualizarCantidadRecursos(recurso.getMaterial().getNombre(), nuevoStock);
                        // Imprimir para probar si funciona
                        // System.out.println("Material: " + recurso.getMaterial().getNombre() + ", Cantidad restante: " + nuevoStock);
                    } else { // Sino se lanza excepción de que no hay stock
                        throw new PresentacionException("No hay suficiente stock de " + recurso.getMaterial().getNombre() + " . Favor de registrar manualmente");
                    }
                }
            }
        }
    }
    
    // Método privado para actualizar la cantidad de recursos en la obra. Cambiar a subsistema de AdmMateriales
    private void actualizarCantidadRecursos(String nombreMaterial, Integer restante) throws AdmMaterialesException {
        List<RecursoDTO> recursosObra = admMateriales.obtenerRecursosObra();
            // Si el material se encuentra registrado, se actualiza la cantidad de stock
            for (RecursoDTO recurso : recursosObra) {
                if (recurso.getMaterial().getNombre().equals(nombreMaterial)) {
                    recurso.setCantidad(restante);
                    // Imprimir para probar si funciona
                    // System.out.println("Cantidad actualizada");
                    return;
                }
            }
    }
    
    // MÉTODOS PARA EL FORMULARIO DE HERRAMIENTAS Y MAQUINARIA
    // Regresar lista de las herramientas    
    // MÉTODOS PARA EL FORMULARIO DE HERRAMIENTAS Y MAQUINARIA
    // Regresar lista de las herramientas
    public List<HerramientaDTO> obtenerHerramientas() {
        // Crear lista y agregar herramientas directamente en la inicialización
        return new ArrayList<>(List.of(
                new HerramientaDTO("Llave Inglesa", "Stanley", "87-367"),
                new HerramientaDTO("Sierra Circular", "Makita", "HS7601"),
                new HerramientaDTO("Taladro Percutor", "DeWalt", "DWD024"),
                new HerramientaDTO("Llave de Impacto", "Milwaukee", "M18 FUEL"),
                new HerramientaDTO("Esmeril Angular", "Bosch", "GWS 750-115"),
                new HerramientaDTO("Lijadora Orbital", "Black+Decker", "BDEQS300"),
                new HerramientaDTO("Destornillador Eléctrico", "Einhell", "TC-SD 3.6 Li"),
                new HerramientaDTO("Clavadora Neumática", "Stanley", "TRE650"),
                new HerramientaDTO("Pistola de Calor", "Wagner", "FURNO 500"),
                new HerramientaDTO("Compresor de Aire", "Kobalt", "XC802000")
        ));
    }
    
    // Guardar herramientas dentro de la lista del coordinador
    public boolean registrarHerramientas(List<HerramientaIngresadaDTO> herramientasIngresadas) throws PresentacionException {
        if (herramientasIngresadas != null) {
            this.herramientasIngresadas = herramientasIngresadas;
        }
        return true;
        // Pruebas para mostrar una excepción forzada
//        this.herramientasIngresadas = null;
//        herramientasIngresadas.isEmpty();
//        return true;
    }
    
    public List<MaquinariaDTO> obtenerMaquinaria() {
        // Crear instancias de maquinarias
        MaquinariaDTO maquinaria1 = new MaquinariaDTO("Excavadora", "Caterpillar", "CAT-EXC-001");
        MaquinariaDTO maquinaria2 = new MaquinariaDTO("Bulldozer", "Komatsu", "KOM-BLD-002");
        MaquinariaDTO maquinaria3 = new MaquinariaDTO("Retroexcavadora", "JCB", "JCB-RETRO-003");
        MaquinariaDTO maquinaria4 = new MaquinariaDTO("Grúa Torre", "Liebherr", "LIEB-GRU-004");
        MaquinariaDTO maquinaria5 = new MaquinariaDTO("Compactadora", "Bomag", "BOM-COMP-005");
        MaquinariaDTO maquinaria6 = new MaquinariaDTO("Motoniveladora", "John Deere", "JD-MOTONIV-006");
        MaquinariaDTO maquinaria7 = new MaquinariaDTO("Cargador Frontal", "Volvo", "VOL-CARG-007");
        MaquinariaDTO maquinaria8 = new MaquinariaDTO("Perforadora", "Atlas Copco", "ATLAS-PERF-008");
        MaquinariaDTO maquinaria9 = new MaquinariaDTO("Trituradora", "Metso", "METSO-TRIT-009");
        MaquinariaDTO maquinaria10 = new MaquinariaDTO("Mezcladora de Concreto", "CemenTech", "CEM-MEZC-010");
        // Añadir maquinaria a la lista
        maquinaria.add(maquinaria1);
        maquinaria.add(maquinaria2);
        maquinaria.add(maquinaria3);
        maquinaria.add(maquinaria4);
        maquinaria.add(maquinaria5);
        maquinaria.add(maquinaria6);
        maquinaria.add(maquinaria7);
        maquinaria.add(maquinaria8);
        maquinaria.add(maquinaria9);
        maquinaria.add(maquinaria10);
        
        return maquinaria;
    }
    
    // Guardar la maquinaria ingresada
    public boolean registrarMaquinaria(List<MaquinariaDTO> maquinarias) throws PresentacionException {
        if (maquinarias != null) {
            this.maquinariaIngresada = maquinarias;
        }
        return true;
        // Prueba para excepción forzada
//        this.maquinariaIngresada = null;
//        maquinariaIngresada.isEmpty();
//        return true;
    }
   
    // MÉTODOS PARA LA ASISTENCIA DEL PERSONAL. Aún no se manejan porque aún no se ha registrado personal
    
    // Método para guardar la lista de asistencias personal a asistencia
    public boolean registrarAsistencia(List<AsistenciaPersonalDTO> asistenciaPersonal) {
        if (asistenciaPersonal != null) {
            this.asistencia.setFecha(LocalDate.now());
            this.asistencia.setAsistencias(asistenciaPersonal);
        }
        
        return true;
    }
    
    // Método para obtener la lista de asistencia del personal
    public List<String> obtenerPersonal() {
        List<String> personal = new ArrayList<>();

        // Agregar nombres a la lista
        personal.add("Juan Pérez");
        personal.add("Ana Gómez");
        personal.add("Carlos Rodríguez");
        personal.add("María Fernández");
        personal.add("Luis Martínez");

        // Retornar la lista de nombres
        return personal;
    }

    public void validarHoras(LocalTime horaEntrada, LocalTime horaSalida, String nombre) throws PresentacionException {
        // Validar antes de agregar la asistencia
        String mensajeError = Validaciones.validarHorasPersonal(horaEntrada, horaSalida, nombre);
        
        if (mensajeError != null) {
            throw new PresentacionException("Error: " + mensajeError);
        }
    }
    
    // Para saber si la obra ya tiene una bitácora
    public boolean validarBitacoraRegistrada() {
        return false; // Cambiar para pruebas
    }
    
    // Método para agregar la bitácora. Da error porque no la estoy guardando en ningún lado, debe de tener el subsistema de bitácora
    public boolean registrarBitacora() throws PresentacionException {
        try {
            DetallesBitacoraDTO detallesBitacora = new DetallesBitacoraDTO();
            //Crear una bitacora, hablarle al subsistema obraSeleccionada y obtener el id
            BitacoraDTO bitacora = new BitacoraDTO(LocalDate.now(), admObraSeleccionada.obtenerIdObra());

            detallesBitacora.setActividades(actividades);
            detallesBitacora.setMaterialesIngresados(materialesIngresados);
            detallesBitacora.setHerramientasIngresadas(herramientasIngresadas);
            detallesBitacora.setMaquinarias(maquinariaIngresada);
            detallesBitacora.setListaAsistencia(asistencia);
            detallesBitacora.setBitacora(bitacora);
            
            

            System.out.println(bitacora);
            System.out.println(detallesBitacora);
            return true;
        } catch (Exception e) { //Cambiar por personalizadas
            throw new PresentacionException(e.getMessage(), e);
        }
    }
    
    public void reset() {
        if (actividades != null) actividades.clear();
        if (recursos != null) recursos.clear();
        if (herramientas != null) herramientas.clear();
        if (maquinaria != null) maquinaria.clear();
        if (asistencia != null) asistencia.setAsistencias(null);
        if (asistencia != null) asistencia.setFecha(null);
        if (materialesIngresados != null) materialesIngresados.clear();
        if (herramientasIngresadas != null) herramientasIngresadas.clear();
        if (maquinariaIngresada != null) maquinariaIngresada.clear();
    } 
    
    public boolean iniciarSesion(Long idObra){
        try {
            admObraSeleccionada.activarSesionObra(idObra);
        } catch (AdmObraSeleccionadaException ex) {
            return false;
        }
        return true;
    }
    
    public boolean cerrarSesion(){
        try {
            admObraSeleccionada.cerrarSesionObra();
        } catch (AdmObraSeleccionadaException ex) {
            return false;
        }
        return true;
    }
    
    public Long obtenerIdObra() throws PresentacionException {
        try {
            return admObraSeleccionada.obtenerIdObra();
        } catch (AdmObraSeleccionadaException ex) {
            throw new PresentacionException(ex.getMessage());
        }
    }
    
    public ObraDTO obtenerObraSeleccionada(){
        try {
            return obtenerObraPorId(admObraSeleccionada.obtenerIdObra());
        } catch (AdmObraSeleccionadaException ex) {
            return null;
        }
    }
    
    //SIMULACION DE BASE DE DATOS
    public ObraDTO obtenerObraPorId(Long idObra){
        for (ObraDTO obra : obras) {
            if (Objects.equals(obra.getIdObra(), idObra)) {
                return obra;
            }
        }
        return null;
    }
    
    public void obtenerObra(){
        ObraDTO obra = new ObraDTO(1L, "Camino de los Mayos #716 ", 20L);
        this.obras.add(obra);
    }    
}
