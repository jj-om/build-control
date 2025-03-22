package excepciones;

/**
 * Excepción personalizada para errores relacionados con la administración de actividades.
 * 
 * Esta excepción se lanza cuando ocurre un problema en el registro o gestión de actividades
 * dentro del sistema. Puede ser utilizada para manejar errores específicos en la lógica
 * de administración de actividades.
 *
 * @author Alejandra Garcia (252444)
 * @author Isabel Valenzuela (253301)
 * @author Ximena Rosales (253088)
 * @author Dario Cortez (252267)
 * @author Jesús Osuna (240549)
 */
public class AdmActividadesException extends Exception {

    /**
     * Constructor por defecto de la excepción.
     */
    public AdmActividadesException() {
    }

    /**
     * Constructor que permite especificar un mensaje de error.
     *
     * @param message Mensaje descriptivo del error ocurrido.
     */
    public AdmActividadesException(String message) {
        super(message);
    }

    /**
     * Constructor que permite especificar un mensaje y una causa del error.
     *
     * @param message Mensaje descriptivo del error ocurrido.
     * @param cause   Causa original del error (otra excepción).
     */
    public AdmActividadesException(String message, Throwable cause) {
        super(message, cause);
    }
}
