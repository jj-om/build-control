/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admObraSeleccionada;

import excepciones.AdmObraSeleccionadaException;

/**
 * Fachada del subsistema de administración de obra seleccionada. Esta clase
 * proporciona una interfaz simplificada para gestionar la sesión de una obra,
 * delegando la lógica de almacenamiento a la clase SesionObraManager
 * (Singleton).
 *
 * Implementa la interfaz IAdmObraSeleccionada para garantizar un contrato de
 * uso uniforme dentro del sistema.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class FAdmObraSeleccionada implements IAdmObraSeleccionada {

    // Instancia única del gestor de sesión de obra (Singleton).
    private SesionObraManager sesionObra;

    /**
     * Constructor de la fachada. Inicializa la instancia de SesionObraManager
     * obteniéndola del Singleton.
     */
    public FAdmObraSeleccionada() {
        this.sesionObra = SesionObraManager.getInstance();
    }

    /**
     * Activa la sesión de una obra en el sistema. Si no hay una obra en sesión,
     * se establece la nueva obra con su identificador.
     *
     * @param idObra Identificador único de la obra a activar.
     * @throws AdmObraSeleccionadaException Si ocurre un error al activar la
     * sesión.
     */
    @Override
    public void activarSesionObra(Long idObra) throws AdmObraSeleccionadaException {
        try {
            if (obtenerIdObra() == null) {
                sesionObra.iniciarSesion(idObra);
            }
        } catch (Exception e) {
            throw new AdmObraSeleccionadaException("No se pudo activar la sesión de la obra.", e);
        }
    }

    /**
     * Cierra la sesión de la obra actual. Si hay una sesión activa, la finaliza
     * eliminando el identificador de la obra en sesión.
     *
     * @throws AdmObraSeleccionadaException Si ocurre un error al cerrar la
     * sesión.
     */
    @Override
    public void cerrarSesionObra() throws AdmObraSeleccionadaException {
        try {
            if (obtenerIdObra() != null) {
                sesionObra.cerrarSesion();
            }
        } catch (Exception e) {
            throw new AdmObraSeleccionadaException("No se pudo cerrar la sesión de la obra.", e);
        }
    }

    /**
     * Obtiene el identificador de la obra cuya sesión está activa.
     *
     * @return El ID de la obra en sesión o null si no hay ninguna.
     * @throws AdmObraSeleccionadaException Si ocurre un error al obtener el ID
     * de la obra.
     */
    @Override
    public Long obtenerIdObra() throws AdmObraSeleccionadaException {
        return sesionObra.getIdObra();
    }
}
