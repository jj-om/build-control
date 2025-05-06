/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Excepción que indica que una obra no tiene personal asignado.
 *
 * Esta excepción se lanza típicamente cuando el servicio externo responde con
 * un código 404, lo que implica que no se encontró información de empleados
 * asociados a la obra consultada.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class ObraSinPersonalException extends Exception {

    /**
     * Constructor por defecto sin mensaje.
     */
    public ObraSinPersonalException() {
    }

    /**
     * Constructor que recibe un mensaje descriptivo del error.
     *
     * @param message Mensaje que explica el motivo de la excepción.
     */
    public ObraSinPersonalException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y una causa original.
     *
     * @param message Mensaje explicativo del error.
     * @param cause Causa original de la excepción (por ejemplo, una excepción
     * interna).
     */
    public ObraSinPersonalException(String message, Throwable cause) {
        super(message, cause);
    }
}
