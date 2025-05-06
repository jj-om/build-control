/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import validadores.Validaciones;
import admBitacora.FAdmBitacora;
import admBitacora.IAdmBitacora;
import admObraSeleccionada.FAdmObraSeleccionada;
import admObraSeleccionada.IAdmObraSeleccionada;
import dto.ActividadDTO;
import dto.AsistenciaPersonalDTO;
import dto.DetallesBitacoraDTO;
import dto.HerramientaDTO;
import dto.HerramientaIngresadaDTO;
import dto.ListaAsistenciaDTO;
import dto.MaquinariaDTO;
import dto.MaterialIngresadoDTO;
import dto.ObraDTO;
import dto.RecursoDTO;
import excepciones.AdmBitacoraException;
import excepciones.AdmObraSeleccionadaException;
import excepciones.ObraSinPersonalException;
import exception.DatosInvalidosException;
import exception.PresentacionException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
    // Crear lista para guardar las actividades
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
    //TEMPORAL LISTA DE OBRAS
    private List<ObraDTO> obras;

    /**
     * Interfaz del subsistema de administración de obra seleccionada. Gestiona
     * la sesión activa y la información de la obra actual.
     */
    private IAdmObraSeleccionada admObraSeleccionada;
    
    // Instancia del subsistema de bitacora
    /**
     * Interfaz del subsistema de bitácora. 
     */
    private IAdmBitacora admBitacora;

    /**
     * Constructor privado (patrón Singleton). Inicializa los subsistemas y las
     * estructuras de datos necesarias.
     */
    private CoordinadorNegocio() {
        // Inicializar fachada desde el coordinador
        this.admBitacora = new FAdmBitacora();
        this.admObraSeleccionada = new FAdmObraSeleccionada();

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
     * @throws exception.DatosInvalidosException
     */
    public void registrarActividad(String titulo, String descripcion) throws PresentacionException, DatosInvalidosException {
        // Validar antes de agregar la actividad
        Validaciones.validarActividad(titulo, descripcion);

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

    // MÉTODOS PARA EL FORMULARIO DE MATERIALES
    // Regresa la lista de materiales
    /**
     * Obtiene la lista de materiales disponibles para la obra seleccionada.
     *
     * @return Lista de recursos (materiales) asignados a la obra
     * @throws exception.PresentacionException
     */
    public List<RecursoDTO> obtenerMateriales() throws PresentacionException {
        try {
            return admBitacora.obtenerRecursosObra();
        } catch (Exception e) {
            throw new PresentacionException("Error al obtener los recursos de la obra.", e);
        }   
    }

    /**
     * Registra los materiales utilizados en la bitácora actual. Valida que las
     * cantidades sean coherentes con el inventario disponible.
     *
     * @param materialIngresado Lista de materiales a registrar con sus
     * cantidades
     * @throws PresentacionException Si ocurre un error durante el registro o
     * validación
     */
    public void registrarMateriales(List<MaterialIngresadoDTO> materialIngresado) throws PresentacionException {
        try {
            // Validar que el recurso sea suficiente
            validarRecursos(materialIngresado);
            // Asignarlo a la lista
            this.materialesIngresados = materialIngresado;
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
            admBitacora.validarRecurso(materialIngresado);
        } catch (AdmBitacoraException e) { // Cambiar a AdmMaterialesException
            // Si al menos un material no fue válido
            throw new PresentacionException(e.getMessage(), e);
        }
    }
    
    // MÉTODOS PARA EL FORMULARIO DE HERRAMIENTAS Y MAQUINARIA
    // Regresar lista de las herramientas
    /**
     * Obtiene la lista de herramientas disponibles para la obra.
     *
     * @return Lista de herramientas que pueden ser asignadas al proyecto
     * @throws exception.PresentacionException
     */
    public List<HerramientaDTO> obtenerHerramientas() throws PresentacionException {
        try {
            return admBitacora.obtenerHerramientasObra();
        } catch (AdmBitacoraException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }

    /**
     * Registra las herramientas utilizadas en la bitácora actual.
     *
     * @param herramientasIngresadas Lista de herramientas a registrar con sus
     * cantidades
     * @throws PresentacionException Si ocurre un error durante el registro
     */
    public void registrarHerramientas(List<HerramientaIngresadaDTO> herramientasIngresadas) throws PresentacionException {
        this.herramientasIngresadas = herramientasIngresadas;
    }

    /**
     * Obtiene la lista de maquinaria disponible para la empresa.
     *
     * @return Lista de maquinaria que puede ser asignada a los proyectos
     * @throws exception.PresentacionException
     */
    public List<MaquinariaDTO> obtenerMaquinaria() throws PresentacionException {
        try {
            return admBitacora.obtenerMaquinariaObra();
        } catch (AdmBitacoraException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }

    /**
     * Registra la maquinaria utilizada en la bitácora actual.
     *
     * @param maquinarias Lista de maquinaria a registrar
     * @throws PresentacionException Si ocurre un error durante el registro
     */
    public void registrarMaquinaria(List<MaquinariaDTO> maquinarias) throws PresentacionException {
        this.maquinariaIngresada = maquinarias;
    }

    // MÉTODOS PARA LA ASISTENCIA DEL PERSONAL. Aún no se manejan porque aún no se ha registrado personal
    /**
     * Registra la asistencia del personal en la bitácora actual.
     *
     * @param asistenciaPersonal Lista de registros de asistencia individual
     */
    public void registrarAsistencia(List<AsistenciaPersonalDTO> asistenciaPersonal) {
        this.asistencia.setFecha(LocalDate.now());
        this.asistencia.setAsistencias(asistenciaPersonal);
    }

    /**
     * Obtiene la lista de personal mediante el subsistema.
     *
     * @return Lista con los nombres del personal de la obra.
     * @throws PresentacionException Si hubo un error al obtener el personal.
     * @throws excepciones.ObraSinPersonalException
     */
    public List<String> obtenerPersonal() throws PresentacionException, ObraSinPersonalException {
        try {
            return admBitacora.obtenerPersonalObra();
        } catch (AdmBitacoraException e) {
            throw new PresentacionException(e.getMessage(), e);
        } 
    }

    /**
     * Valida las horas de entrada y salida del personal.
     *
     * @param horaEntrada Hora de entrada del trabajador
     * @param horaSalida Hora de salida del trabajador
     * @param nombre Nombre del trabajador
     * @throws exception.DatosInvalidosException
     */
    public void validarHoras(LocalTime horaEntrada, LocalTime horaSalida, String nombre) throws DatosInvalidosException {
        // Validar antes de agregar la asistencia
        Validaciones.validarHorasPersonal(horaEntrada, horaSalida, nombre);
    }

    // Para saber si la obra ya tiene una bitácora
    /**
     * Validación para saber si la obra ya tiene una bitácora
     *
     * @return 
     * @throws exception.PresentacionException
     */
    public boolean validarBitacoraRegistrada() throws PresentacionException {
        try {
            return admBitacora.validarBitacoraRegistrada(); // Cambiar para pruebas
        } catch (AdmBitacoraException ex) {
            throw new PresentacionException("Fallo al validar la bitacora: " + ex.getMessage());
        }
    }

    // Método para agregar la bitácora. Da error porque no la estoy guardando en ningún lado, debe de tener el subsistema de bitácora
    /**
     * Registra formalmente la bitácora completa con todos sus componentes.
     *
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws PresentacionException Si ocurre un error durante el registro
     */
    public boolean registrarBitacora() throws PresentacionException, Exception {
        try {
            DetallesBitacoraDTO detallesBitacora = new DetallesBitacoraDTO();

            detallesBitacora.setActividades(actividades);
            detallesBitacora.setMaterialesIngresados(materialesIngresados);
            detallesBitacora.setHerramientasIngresadas(herramientasIngresadas);
            detallesBitacora.setMaquinarias(maquinariaIngresada);
            detallesBitacora.setListaAsistencia(asistencia);
            validarBitacoraRegistrada();
            return admBitacora.registrarBitacora(detallesBitacora);
        } catch (PresentacionException | AdmBitacoraException e) {
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
    public boolean iniciarSesion(Long idObra) throws Exception {
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
     * Obtiene la dirección de la obra.
     *
     * @return La dirección de la obra.
     */
    public String obtenerDireccionObra() {
        try {
            return admObraSeleccionada.obtenerDireccionObra();
        } catch (AdmObraSeleccionadaException ex) {
            return null;
        }
    }
    
}
