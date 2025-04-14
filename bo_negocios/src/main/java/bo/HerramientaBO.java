package bo;

import dto.HerramientaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase HerramientaBO
 *
 * Objeto de negocio (Business Object) que gestiona la lógica relacionada con
 * las herramientas en el sistema. Esta clase implementa el patrón
 * Singleton para garantizar una única instancia en toda la aplicación.
 * 
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class HerramientaBO {
    
    /**
     * Instancia única de la clase (patrón Singleton). Garantiza que solo exista
     * una instancia en toda la aplicación.
     */
    public static HerramientaBO instance;

    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    private HerramientaBO() {
    }

    /**
     * Método para obtener la instancia única de HerramientaBO (patrón
     * Singleton). Si no existe una instancia, la crea; de lo contrario,
     * devuelve la existente.
     *
     * @return La instancia única de HerramientaBO
     */
    public static HerramientaBO getInstance() {
        if (instance == null) {
            instance = new HerramientaBO();
        }
        return instance;
    }

    /**
     * Obtiene la lista de herramientas disponibles para una obra específica.
     *
     * En la implementación actual, retorna una lista de prueba con herramientas
     * predefinidas, pero en una versión completa debería consultar la base de
     * datos para obtener las herramientas realmente asignadas a la obra.
     *
     * @param idObra Identificador de la obra para la cual se buscan las
     * herramientas
     * @return Lista de objetos HerramientaDTO con las herramientas disponibles
     */
    public List<HerramientaDTO> obtenerHerramientasObra(Long idObra) {
        // Lista mock de herramientas disponibles
        List<HerramientaDTO> herramientas = new ArrayList<>();
        
        herramientas.add(new HerramientaDTO("Martillo", "Truper", "M-20"));
        herramientas.add(new HerramientaDTO("Desarmador", "Stanley", "Phillips #2"));
        herramientas.add(new HerramientaDTO("Pinzas", "DeWalt", "Corte diagonal"));
        herramientas.add(new HerramientaDTO("Llave inglesa", "Irwin", "Ajustable 10\""));
        herramientas.add(new HerramientaDTO("Nivel", "Stabila", "Láser 360°"));
        herramientas.add(new HerramientaDTO("Cinta métrica", "Milwaukee", "25 pies"));
        herramientas.add(new HerramientaDTO("Serrucho", "Bahco", "Dientes finos"));
        herramientas.add(new HerramientaDTO("Taladro", "Bosch", "PSB 1800"));
        
        return herramientas;
    }
}
