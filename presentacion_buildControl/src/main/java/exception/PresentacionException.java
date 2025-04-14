/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * Excepción personalizada para manejar errores específicos que ocurren en la
 * capa de presentación.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class PresentacionException extends Exception {

    /**
     * Constructor con mensaje de error.
     *
     * Crea una nueva excepción de presentación con un mensaje descriptivo del
     * problema ocurrido en la capa de presentación.
     *
     * @param message Mensaje que describe la causa de la excepción
     */
    public PresentacionException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa raíz.
     *
     * Crea una nueva excepción de presentación con un mensaje descriptivo y la
     * excepción original que causó el problema.
     *
     * @param message Mensaje que describe la causa de la excepción
     * @param cause Excepción original que provocó este error
     */
    public PresentacionException(String message, Throwable cause) {
        super(message, cause);
    }

}
