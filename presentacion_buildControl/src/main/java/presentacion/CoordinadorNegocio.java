/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import validadores.Validaciones;
import admActividades.FAdmActividades;
import admActividades.IAdmActividades;
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
import dto.RecursoDTO;
import excepciones.AdmActividadesException;
import exception.PresentacionException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
    
    // Instancia del subsistema de obra seleccionada
    private IAdmObraSeleccionada admObraSeleccionada;
    // Instancia del subsistema de actividades
    private IAdmActividades admActividades;

    private CoordinadorNegocio() {
        // Inicializar fachada desde el coordinador
        this.admActividades = new FAdmActividades();
        this.admObraSeleccionada = new FAdmObraSeleccionada();
        
        // Iniciar listas
        this.actividades = new ArrayList<>();
        this.recursos = new ArrayList<>();
        this.materialesIngresados = new ArrayList<>();
        this.herramientas = new ArrayList<>();
        this.herramientasIngresadas = new ArrayList<>();
        this.maquinaria = new ArrayList<>();
        this.maquinariaIngresada = new ArrayList<>();
        
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
    public List<RecursoDTO> obtenerMateriales() {
        // Crear lista para guardar los materiales
        List<RecursoDTO> listaRecursos = new ArrayList<>();
        
        MaterialDTO material1 = new MaterialDTO("Cemento", 50.0f, "Holcim", "kg");
        MaterialDTO material2 = new MaterialDTO("Arena", 100.0f, "Cemex", "kg");
        MaterialDTO material3 = new MaterialDTO("Varilla", 20.5f, "Ternium", "kg");
        MaterialDTO material4 = new MaterialDTO("Pintura Blanca", 4.0f, "Comex", "litros");
        MaterialDTO material5 = new MaterialDTO("Yeso", 25.0f, "Knauf", "kg");
        MaterialDTO material6 = new MaterialDTO("Clavos", 2.0f, "Truper", "kg");
        MaterialDTO material7 = new MaterialDTO("Madera", 30.0f, "Finsa", "kg");
        MaterialDTO material8 = new MaterialDTO("Adhesivo", 1.5f, "Resistol", "litros");
        
        // Instancias de RecursoDTO y añadiéndolas a la lista
        listaRecursos.add(new RecursoDTO(material1, 1));  // 100 unidades de cemento
        listaRecursos.add(new RecursoDTO(material2, 50));   // 50 unidades de arena
        listaRecursos.add(new RecursoDTO(material3, 200));  // 200 unidades de varilla
        listaRecursos.add(new RecursoDTO(material4, 10));   // 10 unidades de pintura blanca
        listaRecursos.add(new RecursoDTO(material5, 75));   // 75 unidades de yeso
        listaRecursos.add(new RecursoDTO(material6, 500));  // 500 unidades de clavos
        listaRecursos.add(new RecursoDTO(material7, 150));  // 150 unidades de madera
        listaRecursos.add(new RecursoDTO(material8, 25));   // 25 unidades de adhesivo
        
        return listaRecursos;
    }
    
    // Registrar los materiales mediante el subsistema
    public boolean registrarMateriales(List<MaterialIngresadoDTO> materialIngresado) throws PresentacionException {
        try {
            // Validar que el recurso sea suficiente
            validarRecursos(materialIngresado);
            
            // Registrar los materiales
            //admMateriales.registrarMateriales(materialIngresado);
            
            // Asignarlo a la lista
            this.materialesIngresados = materialIngresado;
            return true;
        } catch (PresentacionException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }
    
    // Valida que los recursos asignados a la obra y las cantidades ingresadas sean coherentes (no se haya excedido de material)
    private void validarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws PresentacionException {
        try {
            // Valida cada material elegido. Estará en subsistema
            for (MaterialIngresadoDTO material : materialIngresado) {
//                boolean recursoValido = admMateriales.validarRecurso(material.getRecurso(), material.getCantidad());
                boolean recursoValido = true; // 
                if (!recursoValido) {
                    throw new PresentacionException("Cantidad de material en la obra insuficiente. Favor de registrar manualmente.");
                }
            }
        } catch (Exception e) { // Cambiar a AdmMaterialesException
            // Si al menos un material no fue válido
            throw new PresentacionException(e.getMessage(), e);
        }
    }
    
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
    public boolean registrarHerramientas(List<HerramientaIngresadaDTO> herramientasIngresadas) {
        if (herramientasIngresadas != null) {
            this.herramientasIngresadas = herramientasIngresadas;
        }
        
        return true;
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
    public boolean registrarMaquinaria(List<MaquinariaDTO> maquinarias) {
        if (maquinarias != null) {
            this.maquinariaIngresada = maquinarias;
        }
        
        return true;
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
    
    private void limpiarListas() {
        this.actividades.clear();
        this.recursos.clear();
        this.herramientas.clear();
        this.maquinaria.clear();
        this.asistencia.setAsistencias(null);
        this.asistencia.setFecha(null);
        
        this.materialesIngresados.clear();
        this.herramientasIngresadas.clear();
        this.maquinariaIngresada.clear();
    } 
}
