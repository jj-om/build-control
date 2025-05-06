package bo;

import dao.MaquinariaDAO;
import dto.MaquinariaDTO;
import java.util.List;
import java.util.stream.Collectors;
import mappers.MaquinariaMapper;

/**
 * Clase MaquinariaBO
 *
 * Objeto de negocio (Business Object) que gestiona la lógica relacionada con la
 * maquinaria en el sistema. Esta clase implementa el patrón
 * Singleton para garantizar una única instancia en toda la aplicación.
 * 
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class MaquinariaBO {
    
    /**
     * Instancia única de la clase (patrón Singleton). Garantiza que solo exista
     * una instancia en toda la aplicación.
     */
    public static MaquinariaBO instance;
    
    /**
     * DAO para maquinaria. Gestiona el acceso a los datos de
     * maquinaria en la persistencia.
     */
    private MaquinariaDAO maquinariaDAO;


    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    private MaquinariaBO() {
        this.maquinariaDAO = MaquinariaDAO.getInstance();
    }

    /**
     * Método para obtener la instancia única de MaquinariaBO (patrón
     * Singleton). Si no existe una instancia, la crea; de lo contrario,
     * devuelve la existente.
     *
     * @return La instancia única de MaquinariaBO
     */
    public static MaquinariaBO getInstance() {
        if (instance == null) {
            instance = new MaquinariaBO();
        }
        return instance;
    }

    /**
     * Obtiene la lista de maquinaria disponible para una obra específica.
     *
     * En la implementación actual, retorna una lista de prueba con maquinaria
     * predefinida, pero en una versión completa debería consultar la base de
     * datos para obtener la maquinaria realmente asignada a la obra.
     *
     * @param idObra Identificador de la obra para la cual se busca la
     * maquinaria
     * @return Lista de objetos MaquinariaDTO con la maquinaria disponible
     */
    public List<MaquinariaDTO> obtenerMaquinariaObra(Long idObra) {
        // Obtener la maquinaria de la capa de persistencia y convertirla a DTOs
        return maquinariaDAO.obtenerMaquinariaObra(idObra).stream()
                .map(MaquinariaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
