/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admBitacora;

import dto.DetallesBitacoraDTO;
import dto.HerramientaDTO;
import dto.MaquinariaDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.AdmBitacoraException;
import java.util.List;

/**
 * Clase FAdmBitacora
 *
 * Fábrica (Factory) para la creación de instancias del administrador de
 * bitácoras en el sistema. Esta clase implementa el patrón de diseño Factory
 * para proporcionar una forma centralizada de obtener implementaciones del
 * administrador de bitácoras.
 *
 * Es parte fundamental del subsistema admBitacora, permitiendo desacoplar la
 * creación de implementaciones específicas de la interfaz IAdmBitacora de su
 * uso en otras partes del sistema.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class FAdmBitacora implements IAdmBitacora {

    /**
     * Controlador que implementa la lógica del subsistema de administración de
     * bitácoras. Esta referencia maneja todas las operaciones reales sobre
     * bitácoras y sus componentes.
     */
    private ControlAdmBitacora controlAdmBitacora;

    /**
     * Constructor de la fábrica. Inicializa el controlador específico para la
     * administración de bitácoras.
     */
    public FAdmBitacora() {
        this.controlAdmBitacora = new ControlAdmBitacora();
    }

    // Métodos para bitácora
    /**
     * Registra una nueva bitácora completa en el sistema. Delega la operación
     * al controlador especializado.
     *
     * @param detallesBitacora Objeto con todos los componentes de la bitácora a
     * registrar
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws AdmBitacoraException Si ocurre un error durante el proceso de
     * registro
     */
    @Override
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacora) throws AdmBitacoraException {
        return controlAdmBitacora.registrarBitacora(detallesBitacora);
    }

    /**
     * Verifica si ya existe una bitácora registrada para la obra seleccionada
     * en la fecha actual. Delega la operación al controlador especializado.
     *
     * @return true si ya existe una bitácora, false en caso contrario
     * @throws AdmBitacoraException Si ocurre un error durante la verificación
     */
    @Override
    public boolean validarBitacoraRegistrada() throws AdmBitacoraException {
        return controlAdmBitacora.validarBitacoraRegistrada();
    }

    // Métodos para materiales
    /**
     * Obtiene la lista de recursos (materiales) disponibles para la obra
     * seleccionada. Delega la operación al controlador especializado.
     *
     * @return Lista de objetos RecursoDTO con los materiales disponibles y sus
     * cantidades
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    @Override
    public List<RecursoDTO> obtenerRecursosObra() throws AdmBitacoraException {
        return controlAdmBitacora.obtenerRecursosObra();
    }

    /**
     * Valida que los materiales seleccionados para registrar en la bitácora
     * estén disponibles en las cantidades requeridas. Delega la operación al
     * controlador especializado.
     *
     * @param materialIngresado Lista de materiales a validar con sus cantidades
     * @return true si todos los materiales están disponibles, false en caso
     * contrario
     * @throws AdmBitacoraException Si ocurre un error durante la validación
     */
    @Override
    public boolean validarRecurso(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException {
        // Valida cada material elegido
        return controlAdmBitacora.validarRecursos(materialIngresado);

    }

    // Métodos para herramientas y maquinaria
    /**
     * Obtiene la lista de herramientas disponibles para la obra seleccionada.
     * Delega la operación al controlador especializado.
     *
     * @return Lista de objetos HerramientaDTO con las herramientas disponibles
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    @Override
    public List<HerramientaDTO> obtenerHerramientasObra() throws AdmBitacoraException {
        return controlAdmBitacora.obtenerHerramientasObra();
    }

    /**
     * Obtiene la lista de maquinaria disponible para la obra seleccionada.
     * Delega la operación al controlador especializado.
     *
     * @return Lista de objetos MaquinariaDTO con la maquinaria disponible
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    @Override
    public List<MaquinariaDTO> obtenerMaquinariaObra() throws AdmBitacoraException {
        return controlAdmBitacora.obtenerMaquinariaObra();
    }

    // Métodos para personal  
    /**
     * Obtiene la lista de personal asignado a la obra seleccionada. Delega la
     * operación al controlador especializado.
     *
     * @return Lista con los nombres del personal asignado
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    @Override
    public List<String> obtenerPersonalObra() throws AdmBitacoraException {
        return controlAdmBitacora.obtenerPersonalObra();
    }

}
