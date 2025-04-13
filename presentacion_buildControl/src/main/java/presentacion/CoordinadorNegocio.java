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
import exception.PresentacionException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    // Instancia del subsistema de bitacora
    private IAdmBitacora admBitacora;

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

    // Método para obtener la instancia
    public static CoordinadorNegocio getInstance() {
        if (coordinadorNegocio == null) {
            coordinadorNegocio = new CoordinadorNegocio();
        }
        return coordinadorNegocio;
    }

    // MÉTODOS PARA EL FORMULARIO DE ACTIVIDADES
    // Método para registrar una actividad en la lista interna
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

    // MÉTODOS PARA EL FORMULARIO DE MATERIALES
    // Regresa la lista de materiales
    public List<RecursoDTO> obtenerMateriales() throws AdmBitacoraException {
        return admBitacora.obtenerRecursosObra();
    }

    // Registrar los materiales mediante el subsistema
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

    // Valida que los recursos asignados a la obra y las cantidades ingresadas sean coherentes (no se haya excedido de material)
    private void validarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws PresentacionException {
        try {
            admBitacora.validarRecurso(materialIngresado);
        } catch (Exception e) { // Cambiar a AdmMaterialesException
            // Si al menos un material no fue válido
            throw new PresentacionException(e.getMessage(), e);
        }
    }

    // MÉTODOS PARA EL FORMULARIO DE HERRAMIENTAS Y MAQUINARIA
    // Regresar lista de las herramientas
    public List<HerramientaDTO> obtenerHerramientas() throws PresentacionException {
        try {
            return admBitacora.obtenerHerramientasObra();
        } catch (AdmBitacoraException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }

    // Guardar herramientas dentro de la lista del coordinador
    public void registrarHerramientas(List<HerramientaIngresadaDTO> herramientasIngresadas) throws PresentacionException {
        this.herramientasIngresadas = herramientasIngresadas;
    }

    public List<MaquinariaDTO> obtenerMaquinaria() throws PresentacionException {
        try {
            return admBitacora.obtenerMaquinariaObra();
        } catch (AdmBitacoraException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }

    // Guardar la maquinaria ingresada
    public void registrarMaquinaria(List<MaquinariaDTO> maquinarias) throws PresentacionException {
        this.maquinariaIngresada = maquinarias;
    }

    // MÉTODOS PARA LA ASISTENCIA DEL PERSONAL. Aún no se manejan porque aún no se ha registrado personal
    // Método para guardar la lista de asistencias personal a asistencia
    public void registrarAsistencia(List<AsistenciaPersonalDTO> asistenciaPersonal) {
        this.asistencia.setFecha(LocalDate.now());
        this.asistencia.setAsistencias(asistenciaPersonal);
    }

    /**
     * Obtiene la lista de personal mediante el subsistema.
     *
     * @return Lista con los nombres del personal de la obra.
     * @throws PresentacionException Si hubo un error al obtener el personal.
     */
    public List<String> obtenerPersonal() throws PresentacionException {
        try {
            return admBitacora.obtenerPersonalObra();
        } catch (AdmBitacoraException e) {
            throw new PresentacionException(e.getMessage(), e);
        }
    }

    public void validarHoras(LocalTime horaEntrada, LocalTime horaSalida, String nombre) throws PresentacionException {
        // Validar antes de agregar la asistencia
        String mensajeError = Validaciones.validarHorasPersonal(horaEntrada, horaSalida, nombre);

        if (mensajeError != null) {
            throw new PresentacionException("Error: " + mensajeError);
        }
    }

    // Para saber si la obra ya tiene una bitácora
    public boolean validarBitacoraRegistrada() throws PresentacionException {
        try {
            return admBitacora.validarBitacoraRegistrada(); // Cambiar para pruebas
        } catch (AdmBitacoraException ex) {
            throw new PresentacionException("Fallo al validar la bitacora: " + ex.getMessage());
        }
    }

    // Método para agregar la bitácora. Da error porque no la estoy guardando en ningún lado, debe de tener el subsistema de bitácora
    public boolean registrarBitacora() throws PresentacionException {
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

    public boolean iniciarSesion(Long idObra) {
        try {
            admObraSeleccionada.activarSesionObra(idObra);
        } catch (AdmObraSeleccionadaException ex) {
            return false;
        }
        return true;
    }

    public boolean cerrarSesion() {
        try {
            admObraSeleccionada.cerrarSesionObra();
        } catch (AdmObraSeleccionadaException ex) {
            return false;
        }
        return true;
    }

    public String obtenerDireccionObra() {
        try {
            return admObraSeleccionada.obtenerDireccionObra();
        } catch (AdmObraSeleccionadaException ex) {
            return null;
        }
    }

}
