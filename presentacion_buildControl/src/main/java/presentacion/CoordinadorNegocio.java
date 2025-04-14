/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import validadores.Validaciones;
import admActividades.*;
import admObraSeleccionada.*;
import dto.*;
import excepciones.AdmActividadesException;
import excepciones.AdmMaterialesException;
import excepciones.AdmObraSeleccionadaException;
import exception.PresentacionException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase CoordinadorNegocio
 *
 * Coordina la lógica de negocio del sistema, actuando como intermediario entre
 * la capa de presentación y los subsistemas especializados. Implementa el
 * patrón Singleton para garantizar una única instancia en toda la aplicación.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class CoordinadorNegocio {

    /**
     * Instancia única del coordinador de negocio (patrón Singleton).
     */
    private static CoordinadorNegocio coordinadorNegocio;

    /**
     * Lista de actividades registradas para la bitácora actual.
     */
    private List<ActividadDTO> actividades;

    /**
     * Lista de recursos disponibles para la obra seleccionada.
     */
    private List<RecursoDTO> recursos;

    /**
     * Lista de materiales ingresados en la bitácora actual. Almacena los
     * materiales que se han registrado como utilizados.
     */
    private List<MaterialIngresadoDTO> materialesIngresados;

    /**
     * Lista de herramientas disponibles para la obra. Catálogo de todas las
     * herramientas que pueden ser asignadas.
     */
    private List<HerramientaDTO> herramientas;

    /**
     * Lista de herramientas ingresadas en la bitácora actual. Almacena las
     * herramientas que se han registrado como utilizadas.
     */
    private List<HerramientaIngresadaDTO> herramientasIngresadas;

    /**
     * Lista de maquinaria disponible para la empresa. Catálogo de toda la
     * maquinaria que puede ser asignada a los proyectos.
     */
    private List<MaquinariaDTO> maquinaria;

    /**
     * Lista de maquinaria ingresada en la bitácora actual. Almacena la
     * maquinaria que se ha registrado como utilizada.
     */
    private List<MaquinariaDTO> maquinariaIngresada;

    /**
     * Registro de asistencia del personal para la bitácora actual. 
     */
    private ListaAsistenciaDTO asistencia;
    // private DetallesBitacoraDTO detallesBitacora;

    /**
     * Lista temporal de obras disponibles en el sistema. 
     */
    private List<ObraDTO> obras;

    /**
     * Interfaz del subsistema de administración de obra seleccionada. Gestiona
     * la sesión activa y la información de la obra actual.
     */
    private IAdmObraSeleccionada admObraSeleccionada;

    /**
     * Interfaz del subsistema de administración de actividades. Gestiona las
     * operaciones relacionadas con las actividades de obra.
     */
    private IAdmActividades admActividades;

    /**
     * Interfaz del subsistema de administración de materiales. Gestiona las
     * operaciones relacionadas con los materiales de obra.
     */
    private IAdmMateriales admMateriales;

    /**
     * Constructor privado (patrón Singleton). Inicializa los subsistemas y las
     * estructuras de datos necesarias.
     */
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

    /**
     * Obtiene la instancia única del coordinador de negocio (patrón Singleton).
     *
     * @return La instancia del CoordinadorNegocio
     */
    public static CoordinadorNegocio getInstance() {
        if (coordinadorNegocio == null) {
            coordinadorNegocio = new CoordinadorNegocio();
        }
        return coordinadorNegocio;
    }

    /**
     * Registra una actividad en la bitácora actual. Valida los datos de la
     * actividad antes de agregarla a la lista.
     *
     * @param titulo Título de la actividad a registrar
     * @param descripcion Descripción detallada de la actividad
     * @throws PresentacionException Si los datos de la actividad no son válidos
     */
    public void registrarActividad(String titulo, String descripcion) throws PresentacionException {
        // Validar antes de agregar la actividad
        String mensajeError = Validaciones.validarActividad(titulo, descripcion);

        if (mensajeError != null) {
            throw new PresentacionException(mensajeError);
        }

        // Agregar actividad después de validar
        actividades.add(new ActividadDTO(titulo, descripcion));
    }

    /**
     * Obtiene la lista de actividades registradas en la bitácora actual.
     *
     * @return Lista de actividades registradas
     */
    public List<ActividadDTO> obtenerActividades() {
        return actividades;
    }

    /**
     * Cancela el registro de actividades, eliminando todas las actividades de
     * la bitácora en proceso.
     */
    public void cancelarActividades() {
        actividades.clear();
    }

    /**
     * Registra formalmente las actividades en el subsistema correspondiente.
     *
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws PresentacionException Si ocurre un error durante el registro
     */
    public boolean registrarActividades() throws PresentacionException {
        try {
            return admActividades.registrarActividades(actividades);
        } catch (AdmActividadesException e) {
            throw new PresentacionException("Error al registrar actividad: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de materiales disponibles para la obra seleccionada.
     *
     * @return Lista de recursos (materiales) asignados a la obra
     */
    public List<RecursoDTO> obtenerMateriales() {
        return admMateriales.obtenerRecursosObra();
    }

    /**
     * Registra los materiales utilizados en la bitácora actual. Valida que las
     * cantidades sean coherentes con el inventario disponible.
     *
     * @param materialIngresado Lista de materiales a registrar con sus
     * cantidades
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws PresentacionException Si ocurre un error durante el registro o
     * validación
     * @throws AdmMaterialesException Si ocurre un error en el subsistema de
     * materiales
     */
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

    /**
     * Valida que los recursos asignados a la obra sean suficientes para las
     * cantidades ingresadas.
     *
     * @param materialIngresado Lista de materiales a validar
     * @throws PresentacionException Si algún material excede la cantidad
     * disponible
     */
    private void validarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws PresentacionException {
        try {
            admMateriales.validarRecurso(materialIngresado);
        } catch (Exception e) { // Cambiar a AdmMaterialesException
            // Si al menos un material no fue válido
            throw new PresentacionException(e.getMessage(), e);
        }
    }

    /**
     * Obtiene la lista de herramientas disponibles para la obra.
     *
     * @return Lista de herramientas que pueden ser asignadas al proyecto
     */
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

    /**
     * Registra las herramientas utilizadas en la bitácora actual.
     *
     * @param herramientasIngresadas Lista de herramientas a registrar con sus
     * cantidades
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws PresentacionException Si ocurre un error durante el registro
     */
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

    /**
     * Obtiene la lista de maquinaria disponible para la empresa.
     *
     * @return Lista de maquinaria que puede ser asignada a los proyectos
     */
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

    /**
     * Registra la maquinaria utilizada en la bitácora actual.
     *
     * @param maquinarias Lista de maquinaria a registrar
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws PresentacionException Si ocurre un error durante el registro
     */
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
    /**
     * Registra la asistencia del personal en la bitácora actual.
     *
     * @param asistenciaPersonal Lista de registros de asistencia individual
     * @return true si el registro fue exitoso, false en caso contrario
     */
    public boolean registrarAsistencia(List<AsistenciaPersonalDTO> asistenciaPersonal) {
        if (asistenciaPersonal != null) {
            this.asistencia.setFecha(LocalDate.now());
            this.asistencia.setAsistencias(asistenciaPersonal);
        }

        return true;
    }

    /**
     * Obtiene la lista del personal disponible para la obra.
     *
     * @return Lista con los nombres del personal asignado al proyecto
     */
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

    /**
     * Valida las horas de entrada y salida del personal.
     *
     * @param horaEntrada Hora de entrada del trabajador
     * @param horaSalida Hora de salida del trabajador
     * @param nombre Nombre del trabajador
     * @throws PresentacionException Si las horas no son válidas
     */
    public void validarHoras(LocalTime horaEntrada, LocalTime horaSalida, String nombre) throws PresentacionException {
        // Validar antes de agregar la asistencia
        String mensajeError = Validaciones.validarHorasPersonal(horaEntrada, horaSalida, nombre);

        if (mensajeError != null) {
            throw new PresentacionException("Error: " + mensajeError);
        }
    }

    /**
     * Verifica si la obra ya tiene una bitácora registrada para la fecha
     * actual.
     *
     * @return true si ya existe una bitácora, false en caso contrario
     */
    public boolean validarBitacoraRegistrada() {
        return false; // Cambiar para pruebas
    }

    /**
     * Registra formalmente la bitácora completa con todos sus componentes.
     *
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws PresentacionException Si ocurre un error durante el registro
     */
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

    /**
     * Reinicia el estado del coordinador, limpiando todas las listas y
     * registros temporales de la bitácora en proceso.
     */
    public void reset() {
        if (actividades != null) {
            actividades.clear();
        }
        if (recursos != null) {
            recursos.clear();
        }
        if (herramientas != null) {
            herramientas.clear();
        }
        if (maquinaria != null) {
            maquinaria.clear();
        }
        if (asistencia != null) {
            asistencia.setAsistencias(null);
        }
        if (asistencia != null) {
            asistencia.setFecha(null);
        }
        if (materialesIngresados != null) {
            materialesIngresados.clear();
        }
        if (herramientasIngresadas != null) {
            herramientasIngresadas.clear();
        }
        if (maquinariaIngresada != null) {
            maquinariaIngresada.clear();
        }
    }

    /**
     * Inicia una sesión con la obra especificada.
     *
     * @param idObra Identificador de la obra a seleccionar
     * @return true si la sesión se inició correctamente, false en caso
     * contrario
     */
    public boolean iniciarSesion(Long idObra) {
        try {
            admObraSeleccionada.activarSesionObra(idObra);
        } catch (AdmObraSeleccionadaException ex) {
            return false;
        }
        return true;
    }

    /**
     * Cierra la sesión activa de la obra.
     *
     * @return true si la sesión se cerró correctamente, false en caso contrario
     */
    public boolean cerrarSesion() {
        try {
            admObraSeleccionada.cerrarSesionObra();
        } catch (AdmObraSeleccionadaException ex) {
            return false;
        }
        return true;
    }

    /**
     * Obtiene el identificador de la obra actualmente seleccionada.
     *
     * @return El ID de la obra actual
     * @throws PresentacionException Si no hay una sesión activa
     */
    public Long obtenerIdObra() throws PresentacionException {
        try {
            return admObraSeleccionada.obtenerIdObra();
        } catch (AdmObraSeleccionadaException ex) {
            throw new PresentacionException(ex.getMessage());
        }
    }

    /**
     * Obtiene la información completa de la obra actualmente seleccionada.
     *
     * @return Objeto ObraDTO con los datos de la obra, o null si no hay sesión
     * activa
     */
    public ObraDTO obtenerObraSeleccionada() {
        try {
            return obtenerObraPorId(admObraSeleccionada.obtenerIdObra());
        } catch (AdmObraSeleccionadaException ex) {
            return null;
        }
    }

    //SIMULACION DE BASE DE DATOS
    /**
     * Obtiene información de una obra específica por su identificador.
     * Simulación de consulta a base de datos.
     *
     * @param idObra Identificador de la obra a buscar
     * @return Objeto ObraDTO con los datos de la obra, o null si no se
     * encuentra
     */
    public ObraDTO obtenerObraPorId(Long idObra) {
        for (ObraDTO obra : obras) {
            if (Objects.equals(obra.getIdObra(), idObra)) {
                return obra;
            }
        }
        return null;
    }

    /**
     * Carga datos de prueba de obras. Simulación de obtención de datos de la
     * base de datos.
     */
    public void obtenerObra() {
        ObraDTO obra = new ObraDTO(1L, "Camino de los Mayos #716 ", 20L);
        this.obras.add(obra);
    }
}
