package bo;

import dao.HerramientaDAO;
import dto.HerramientaDTO;
import java.util.List;
import java.util.stream.Collectors;
import mappers.HerramientaMapper;

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
     * DAO para herramientas. Gestiona el acceso a los datos de
     * herramientas en la persistencia.
     */
    private HerramientaDAO herramientaDAO;

    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    private HerramientaBO() {
        this.herramientaDAO = HerramientaDAO.getInstance();
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
        // Obtener las herramientas y convertirlas a DTOs
        return herramientaDAO.obtenerHerramientasObra(idObra).stream()
                .map(HerramientaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
