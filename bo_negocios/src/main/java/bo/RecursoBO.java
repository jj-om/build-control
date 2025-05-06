package bo;

import dao.RecursoDAO;
import dto.RecursoDTO;
import excepciones.BOException;
import excepciones.DAOException;
import java.util.List;
import java.util.stream.Collectors;
import mappers.RecursoMapper;

/**
 * Clase RecursoBO
 *
 * Objeto de negocio (Business Object) que gestiona la lógica relacionada con
 * los recursos materiales en el sistema. Esta clase implementa el
 * patrón Singleton para garantizar una única instancia en toda la aplicación.
 * 
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class RecursoBO {
    
    /**
     * Instancia única de la clase (patrón Singleton). Garantiza que solo exista
     * una instancia en toda la aplicación.
     */
    public static RecursoBO instance;
    
    /**
     * DAO para acceder a los datos de los recursos.
     */
    private RecursoDAO recursoDAO;

    /**
     * Constructor privado (patrón Singleton). Inicializa la lista de recursos y
     * previene la creación de múltiples instancias desde fuera de la clase.
     */
    private RecursoBO() {
        this.recursoDAO = RecursoDAO.getInstance();
    }

    /**
     * Método para obtener la instancia única de RecursoBO (patrón Singleton).
     * Si no existe una instancia, la crea; de lo contrario, devuelve la
     * existente.
     *
     * @return La instancia única de RecursoBO
     */
    public static RecursoBO getInstance() {
        if (instance == null) {
            instance = new RecursoBO();
        }
        return instance;
    }

    /**
     * Obtiene la lista de recursos disponibles para una obra específica.
     *
     * En la implementación actual, crea y retorna una lista de prueba con
     * materiales predefinidos, pero en una versión completa debería consultar
     * la base de datos para obtener los recursos realmente asignados a la obra.
     *
     * @param idObra Identificador de la obra para la cual se buscan los
     * recursos
     * @return Lista de objetos RecursoDTO con los materiales disponibles y sus
     * cantidades
     * @throws BOException Si ocurre un error durante la obtención de datos de
     * recursos
     */
    public List<RecursoDTO> obtenerRecursosObra(Long idObra) throws BOException {
        try {
            // Obtener los recursos de la capa de persistencia
            return recursoDAO.obtenerRecursosObra(idObra).stream()
                    .map(RecursoMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (DAOException ex) {
            throw new BOException("Error al obtener los recursos de la obra: " + ex.getMessage());
        }
    }
    
    // Checar con el que esta en coordinador negocio en presentacion
    /**
     * Actualiza la cantidad disponible de un recurso específico para una obra.
     *
     * Busca el material indicado dentro de los recursos asignados a la obra y
     * actualiza su cantidad según el valor proporcionado. Esta operación se
     * utiliza típicamente después de registrar el uso de materiales en una
     * bitácora, para ajustar el inventario disponible.
     *
     * @param idObra Identificador de la obra a la que pertenece el recurso
     * @param nombreMaterial Nombre del material a actualizar
     * @param unidadPeso Unidad de medida del material
     * @param cantidad Nueva cantidad disponible del recurso
     * @return true si la actualización fue exitosa, false en caso contrario
     * @throws BOException Si ocurre un error durante la actualización
     */
    public boolean actualizarCantidadRecurso(Long idObra, String nombreMaterial, String unidadPeso, Integer cantidad) throws BOException {
        try {
            return recursoDAO.actualizarCantidadRecurso(idObra, nombreMaterial, unidadPeso, cantidad);
        } catch (DAOException ex) {
            throw new BOException("Error al actualizar la cantidad del recurso: " + ex.getMessage());
        }
    }
    
}
