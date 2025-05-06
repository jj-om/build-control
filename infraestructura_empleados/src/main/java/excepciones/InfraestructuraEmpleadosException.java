/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Excepción que indica un problema al comunicarse con el servicio externo de empleados.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class InfraestructuraEmpleadosException extends Exception {
    
    /**
     * Constructor por defecto sin mensaje.
     */
    public InfraestructuraEmpleadosException() {
    }
    
    /**
     * Constructor que recibe un mensaje descriptivo del error.
     *
     * @param message Mensaje que explica el motivo de la excepción.
     */
    public InfraestructuraEmpleadosException(String message) {
        super(message);
    }
    
    /**
     * Constructor que recibe un mensaje y una causa original.
     *
     * @param message Mensaje explicativo del error.
     * @param cause Causa original de la excepción (por ejemplo, una excepción
     * interna).
     */
    public InfraestructuraEmpleadosException(String message, Throwable cause) {
        super(message, cause);
    }
}
