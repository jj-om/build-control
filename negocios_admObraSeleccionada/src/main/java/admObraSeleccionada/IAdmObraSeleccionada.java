/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package admObraSeleccionada;

import excepciones.AdmObraSeleccionadaException;

/**
 * Interfaz que define el contrato para la administración de la obra
 * seleccionada. Encapsula la lógica de gestión de sesiones dentro del
 * subsistema.
 *
 * @author rocha
 */
public interface IAdmObraSeleccionada {

    /**
     * Activa la sesión de una obra en el sistema. Si no hay una obra en sesión,
     * se establece la nueva obra con su identificador.
     *
     * @param idObra Identificador único de la obra a activar.
     * @throws AdmObraSeleccionadaException Si ocurre un error al activar la
     * sesión.
     */
    public boolean activarSesionObra(Long idObra) throws AdmObraSeleccionadaException;

    /**
     * Cierra la sesión de la obra actual. Si hay una sesión activa, la finaliza
     * eliminando el identificador de la obra en sesión.
     *
     * @throws AdmObraSeleccionadaException Si ocurre un error al cerrar la
     * sesión.
     */
    public void cerrarSesionObra() throws AdmObraSeleccionadaException;

    /**
     * Obtiene el identificador de la obra cuya sesión está activa.
     *
     * @return El ID de la obra en sesión o null si no hay ninguna.
     * @throws AdmObraSeleccionadaException Si ocurre un error al obtener el ID
     * de la obra.
     */
    public Long obtenerIdObra() throws AdmObraSeleccionadaException;
}
