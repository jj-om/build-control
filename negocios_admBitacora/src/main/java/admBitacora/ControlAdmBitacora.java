/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admBitacora;

import bo.BitacoraBO;
import bo.HerramientaBO;
import bo.MaquinariaBO;
import bo.PersonalBO;
import bo.RecursoBO;
import admObraSeleccionada.FAdmObraSeleccionada;
import admObraSeleccionada.IAdmObraSeleccionada;
import dto.BitacoraDTO;
import dto.DetallesBitacoraDTO;
import dto.HerramientaDTO;
import dto.MaquinariaDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.AdmBitacoraException;
import excepciones.AdmObraSeleccionadaException;
import excepciones.BOException;
import excepciones.ObraSinPersonalException;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase ControlAdmBitacora
 *
 * Controlador principal del subsistema de administración de bitácoras en el
 * sistema. Esta clase implementa la lógica central para gestionar
 * todas las operaciones relacionadas con las bitácoras de obra.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class ControlAdmBitacora {
    
    /**
     * Referencia al subsistema de administración de obra seleccionada. Permite
     * obtener información sobre la obra actualmente en sesión.
     */
    private IAdmObraSeleccionada admObraSeleccionada;
    
    // BOs
    /**
     * Objeto de negocio para la gestión de bitácoras. Maneja las operaciones
     * específicas relacionadas con bitácoras.
     */
    private BitacoraBO boBitacora;

    /**
     * Objeto de negocio para la gestión de herramientas. Maneja las operaciones
     * específicas relacionadas con herramientas.
     */
    private HerramientaBO boHerramienta;

    /**
     * Objeto de negocio para la gestión de maquinaria. Maneja las operaciones
     * específicas relacionadas con maquinaria.
     */
    private MaquinariaBO boMaquinaria;

    /**
     * Objeto de negocio para la gestión de personal. Maneja las operaciones
     * específicas relacionadas con trabajadores.
     */
    private PersonalBO boPersonal;

    /**
     * Objeto de negocio para la gestión de recursos. Maneja las operaciones
     * específicas relacionadas con materiales.
     */
    private RecursoBO boRecurso;

    /**
     * Constructor del controlador. Inicializa las referencias a los subsistemas
     * y objetos de negocio necesarios.
     */
    public ControlAdmBitacora() {
        this.admObraSeleccionada = new FAdmObraSeleccionada();
        
        this.boBitacora = BitacoraBO.getInstance();
        this.boHerramienta = HerramientaBO.getInstance();
        this.boMaquinaria = MaquinariaBO.getInstance();
        this.boPersonal = PersonalBO.getInstance();
        this.boRecurso = RecursoBO.getInstance();
    }
    
    // Métodos para bitácora
    /**
     * Registra una nueva bitácora completa en el sistema.
     *
     * @param detallesBitacoraDTO Objeto que contiene todos los componentes de
     * la bitácora a registrar
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws AdmBitacoraException Si ocurre un error durante el proceso de
     * registro
     */
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacoraDTO) throws AdmBitacoraException, Exception {
        try {
            Long idObra = null;
            
            try {
                idObra = admObraSeleccionada.obtenerSesion();
            } catch (AdmObraSeleccionadaException ex) {
                throw new AdmBitacoraException(ex.getMessage(), ex);
            }
            
            if (!validarDatosBitacora(detallesBitacoraDTO, idObra)) {
                throw new AdmBitacoraException("Datos de bitácora incompletos o inválidos");
            }

            // Validar materiales (si hay)
            if (detallesBitacoraDTO.getMaterialesIngresados() != null && !detallesBitacoraDTO.getMaterialesIngresados().isEmpty()) {
                validarRecursos(detallesBitacoraDTO.getMaterialesIngresados());
            }

            // Registrar en el BO
            BitacoraDTO bitacoraDTO = new BitacoraDTO(LocalDate.now(), idObra);
            detallesBitacoraDTO.setBitacora(bitacoraDTO);
            BitacoraDTO bitacoraRegistrada = boBitacora.registrarBitacora(detallesBitacoraDTO);
            
            if (bitacoraRegistrada == null) {
                throw new AdmBitacoraException("Error al guardar la bitácora");
            }

            //Actualizar inventario (si hay materiales)
            if (detallesBitacoraDTO.getMaterialesIngresados() != null && !detallesBitacoraDTO.getMaterialesIngresados().isEmpty()) {
                restarRecursos(detallesBitacoraDTO.getMaterialesIngresados());
            }

            return true;
        } catch (AdmBitacoraException | BOException e) {
            throw new AdmBitacoraException("Error en sistema: " + e.getMessage());
        }
    }

    /**
     * Valida que los datos básicos de la bitácora sean correctos y completos.
     *
     * Verifica que el objeto contenga la información mínima necesaria para
     * registrar una bitácora válida, como el ID de obra y al menos una
     * actividad.
     *
     * @param detallesBitacoraDTO Objeto a validar
     * @param idObra Identificador de la obra asociada
     * @return true si los datos son válidos, false en caso contrario
     */
    private boolean validarDatosBitacora(DetallesBitacoraDTO detallesBitacoraDTO, Long idObra) {
        return detallesBitacoraDTO != null
                && idObra != null
                && detallesBitacoraDTO.getActividades() != null
                && !detallesBitacoraDTO.getActividades().isEmpty();
    }

    /**
     * Verifica si ya existe una bitácora registrada para la obra seleccionada
     * en la fecha actual.
     *
     * @return true si ya existe una bitácora, false en caso contrario
     * @throws AdmBitacoraException Si ocurre un error durante la verificación
     */
    public boolean validarBitacoraRegistrada() throws AdmBitacoraException {
        try {
            Long idObra = admObraSeleccionada.obtenerSesion();
            return boBitacora.validarBitacoraRegistrada(idObra);
        } catch (AdmObraSeleccionadaException ex) {
            throw new AdmBitacoraException("Fallo al validar la bitacora.");
        }
    }

    // Métodos para materiales
    /**
     * Obtiene la lista de recursos (materiales) disponibles para la obra
     * seleccionada.
     *
     * @return Lista de objetos RecursoDTO con los materiales disponibles y sus
     * cantidades
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    public List<RecursoDTO> obtenerRecursosObra() throws AdmBitacoraException, Exception {
        try {
            // Obtiene el id mediante el subsistema
            Long idObra = admObraSeleccionada.obtenerSesion();

            // Obtiene el recurso de la obra mediante el BO
            List<RecursoDTO> recursos = boRecurso.obtenerRecursosObra(idObra);

            // Valida la lista de personal
            if (recursos == null || recursos.isEmpty()) {
                throw new AdmBitacoraException("No hay recursos asignados a la obra.");
            }

            return recursos;
        } catch (BOException | AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("No se pudo obtener el personal de la obra.");
        }
    }

    /**
     * Valida que los materiales seleccionados para registrar en la bitácora
     * estén disponibles en las cantidades requeridas.
     *
     * @param materialIngresado Lista de materiales a validar con sus cantidades
     * @return true si todos los materiales están disponibles, false en caso
     * contrario
     * @throws AdmBitacoraException Si algún material excede la cantidad
     * disponible
     */
    public boolean validarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException {
        // Valida cada material elegido
        for (MaterialIngresadoDTO material : materialIngresado) {
            if (material.getCantidad() > material.getRecurso().getCantidad()) {
                throw new AdmBitacoraException("Cantidad de material en la obra insuficiente. Favor de registrar manualmente.");
            }
        }
        return true;
    }

    /**
     * Actualiza el inventario de recursos, restando las cantidades utilizadas
     * según lo registrado en la bitácora.
     *
     * @param materialIngresado Lista de materiales utilizados con sus
     * cantidades
     * @throws AdmBitacoraException Si ocurre un error durante la actualización
     */
    private void restarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException, Exception {
        try {
            // Obtener lista de los recursos de la obra
            List<RecursoDTO> recursosObra = obtenerRecursosObra();
            Long idObra;
            try {
                idObra = admObraSeleccionada.obtenerSesion();
            } catch (AdmObraSeleccionadaException ex) {
                throw new AdmBitacoraException("Fallo al obtener el id de la obra.");
            }
            // Para cada material ingresado para usarse, revisar los recursos dentro de la obra
            for (MaterialIngresadoDTO material : materialIngresado) {
                for (RecursoDTO recurso : recursosObra) {
                    // Si el nombre del material dentro del recurso y del recurso ingresado coindide, restarle la cantidad
                    if (recurso.getMaterial().getNombre().equals(material.getRecurso().getMaterial().getNombre())) {
                        // Si la cantidad que hay en los recursos es mayor o igual a la cantidad ingresada, se le resta y actualiza la cantidad de recursos
                        if (recurso.getCantidad() >= material.getCantidad()) {
                            Integer nuevoStock = recurso.getCantidad() - material.getCantidad();
                            boolean actualizado = boRecurso.actualizarCantidadRecurso(idObra, recurso.getMaterial().getNombre(), recurso.getMaterial().getUnidadPeso(), nuevoStock);
                            if (actualizado) {
                                return;
                            }
                        } else { // Sino se lanza excepción de que no hay stock
                            throw new AdmBitacoraException("No hay suficiente stock de " + recurso.getMaterial().getNombre() + " . Favor de registrar manualmente");
                        }
                    }
                }
            }
        } catch (BOException e) {
            throw new AdmBitacoraException("Fallo al restar los recursos de la obra.");
        }
    }

    // Métodos para herramientas y maquinaria
    // Falta que le llamen al subsistema para obtener id,  llamen al BO y validen
    /**
     * Obtiene la lista de herramientas disponibles para la obra seleccionada.
     *
     * @return Lista de objetos HerramientaDTO con las herramientas disponibles
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    public List<HerramientaDTO> obtenerHerramientasObra() throws AdmBitacoraException {
        try {
            Long idObra = admObraSeleccionada.obtenerSesion();
            List<HerramientaDTO> herramientas = boHerramienta.obtenerHerramientasObra(idObra);

            if (herramientas == null || herramientas.isEmpty()) {
                throw new AdmBitacoraException("No hay herramientas asignadas a esta obra");
            }

            return herramientas;
        } catch (AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("Error al obtener obra: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de maquinaria disponible para la obra seleccionada.
     *
     * @return Lista de objetos MaquinariaDTO con la maquinaria disponible
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    public List<MaquinariaDTO> obtenerMaquinariaObra() throws AdmBitacoraException {
        try {
            Long idObra = admObraSeleccionada.obtenerSesion();
            List<MaquinariaDTO> maquinaria = boMaquinaria.obtenerMaquinariaObra(idObra);

            if (maquinaria == null || maquinaria.isEmpty()) {
                throw new AdmBitacoraException("No hay maquinaria asignada a esta obra");
            }

            return maquinaria;
        } catch (AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("Error al obtener obra: " + e.getMessage());
        }
    }

    // Métodos para personal
    /**
     * Obtiene la lista de personal asignado a la obra seleccionada.
     *
     * @return Lista con los nombres del personal asignado
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     * @throws excepciones.ObraSinPersonalException
     */
    public List<String> obtenerPersonalObra() throws AdmBitacoraException, ObraSinPersonalException {
        try {
            // Obtiene el id mediante el subsistema
            Long idObra = admObraSeleccionada.obtenerSesion();

            // Obtiene el personal de la obra mediante el BO
            List<String> listaPersonal = boPersonal.obtenerPersonalObra(idObra);

            // Valida la lista de personal
            if (listaPersonal == null || listaPersonal.isEmpty()) {
                throw new AdmBitacoraException("No hay personal asignado a la obra.");
            }

            return listaPersonal;
        } catch (BOException | AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("No se pudo obtener el personal de la obra.");
        }
    }
}
