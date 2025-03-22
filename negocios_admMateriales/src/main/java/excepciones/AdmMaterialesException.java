package excepciones;

/**
 * Excepción personalizada para el manejo de errores relacionados con la 
 * administración de materiales en el sistema. Esta clase extiende de la 
 * clase {@link Exception} y permite gestionar de manera específica las 
 * situaciones excepcionales que puedan ocurrir durante la manipulación de 
 * materiales.
 * 
 * La clase ofrece dos constructores para crear instancias de la excepción 
 * con o sin una causa adicional.
 * 
 * Esta excepción es útil para identificar y manejar errores específicos 
 * de la lógica de negocio de la administración de materiales, como puede ser 
 * la falta de materiales, errores en la actualización, o fallos de comunicación 
 * con una base de datos.
 * 
 * @author Jesús Osuna 240549
 */
public class AdmMaterialesException extends Exception {

    /**
     * Constructor que crea una nueva instancia de la excepción con un mensaje 
     * de error específico.
     * 
     * @param message El mensaje que describe el error.
     */
    public AdmMaterialesException(String message) {
        super(message);
    }

    /**
     * Constructor que crea una nueva instancia de la excepción con un mensaje 
     * de error específico y una causa que explica el motivo original de la excepción.
     * 
     * @param message El mensaje que describe el error.
     * @param cause La causa que originó la excepción.
     */
    public AdmMaterialesException(String message, Throwable cause) {
        super(message, cause);
    }
}
