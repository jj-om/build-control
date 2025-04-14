/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * Excepción personalizada para manejar errores específicos que ocurren en la
 * capa de presentación relacionados al ingreso de datos.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class DatosInvalidosException extends Exception {

    /**
     * Constructor vacío.
     */
    public DatosInvalidosException() {
    }

    /**
     * Constructor con mensaje de error.
     *
     * @param message Mensaje que describe la causa de la excepción
     */
    public DatosInvalidosException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa raíz.
     *
     * @param message Mensaje que describe la causa de la excepción
     * @param cause Excepción original que provocó este error
     */
    public DatosInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
