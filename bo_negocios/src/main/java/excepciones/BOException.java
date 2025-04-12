/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author rocha
 */
public class BOException extends Exception {

    public BOException() {
    }
    

    public BOException(String message) {
        super(message);
    }

    public BOException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
