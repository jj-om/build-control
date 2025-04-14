/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Clase BOException
 *
 * Excepción personalizada para manejar errores específicos que ocurren en la
 * capa de negocio (Business Objects) del sistema.
 * 
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class BOException extends Exception {

    /**
     * Constructor por defecto. Crea una nueva excepción de negocio sin mensaje
     * específico.
     */
    public BOException() {
    }

    /**
     * Constructor con mensaje de error.
     *
     * Crea una nueva excepción de negocio con un mensaje descriptivo del
     * problema ocurrido en la capa de negocio.
     *
     * @param message Mensaje que describe la causa de la excepción
     */
    public BOException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa raíz.
     *
     * Crea una nueva excepción de negocio con un mensaje descriptivo y la
     * excepción original que causó el problema, permitiendo mantener la traza
     * completa del error desde su origen.
     *
     * @param message Mensaje que describe la causa de la excepción
     * @param cause Excepción original que provocó este error
     */
    public BOException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
