/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
 * Interface IAdmBitacora
 *
 * Esta interfaz establece los métodos que deben implementar las clases que
 * gestionan las bitácoras de seguimiento diario de los proyectos de
 * construcción.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public interface IAdmBitacora {
    
    /**
     * Obtiene la lista de herramientas disponibles para la obra seleccionada.
     *
     * @return Lista de objetos HerramientaDTO con las herramientas disponibles
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    public List<HerramientaDTO> obtenerHerramientasObra() throws AdmBitacoraException;

    /**
     * Obtiene la lista de maquinaria disponible para la obra seleccionada.
     *
     * @return Lista de objetos MaquinariaDTO con la maquinaria disponible
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    public List<MaquinariaDTO> obtenerMaquinariaObra() throws AdmBitacoraException;

    /**
     * Obtiene la lista de personal asignado a la obra seleccionada.
     *
     * @return Lista con los nombres del personal asignado
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    public List<String> obtenerPersonalObra() throws AdmBitacoraException;

    /**
     * Registra una nueva bitácora completa en el sistema.
     *
     * @param detallesBitacora Objeto con todos los componentes de la bitácora a
     * registrar
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws AdmBitacoraException Si ocurre un error durante el proceso de
     * registro
     */
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacora) throws AdmBitacoraException;

    /**
     * Verifica si ya existe una bitácora registrada para la obra seleccionada
     * en la fecha actual.
     *
     * @return true si ya existe una bitácora, false en caso contrario
     * @throws AdmBitacoraException Si ocurre un error durante la verificación
     */
    public boolean validarBitacoraRegistrada() throws AdmBitacoraException;

    /**
     * Obtiene la lista de recursos (materiales) disponibles para la obra
     * seleccionada.
     *
     * @return Lista de objetos RecursoDTO con los materiales disponibles y sus
     * cantidades
     * @throws AdmBitacoraException Si ocurre un error durante la obtención de
     * los datos
     */
    public List<RecursoDTO> obtenerRecursosObra() throws AdmBitacoraException;

    /**
     * Valida que los materiales seleccionados para registrar en la bitácora
     * estén disponibles en las cantidades requeridas.
     *
     * @param materialIngresado Lista de materiales a validar con sus cantidades
     * @return true si todos los materiales están disponibles, false en caso
     * contrario
     * @throws AdmBitacoraException Si ocurre un error durante la validación
     */
    public boolean validarRecurso(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException;
    
}
