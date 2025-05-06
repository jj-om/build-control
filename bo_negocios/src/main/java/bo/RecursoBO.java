package bo;

import dto.MaterialDTO;
import dto.RecursoDTO;
import excepciones.BOException;
import java.util.ArrayList;
import java.util.List;

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
     * Lista de recursos disponibles en el sistema. Almacena los materiales con
     * sus cantidades correspondientes.
     */
    private List<RecursoDTO> recursos;

    /**
     * Constructor privado (patrón Singleton). Inicializa la lista de recursos y
     * previene la creación de múltiples instancias desde fuera de la clase.
     */
    private RecursoBO() {
        this.recursos = new ArrayList<>();
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
        MaterialDTO material1 = new MaterialDTO("Cemento", 50.0f, "Holcim", "kg");
        MaterialDTO material2 = new MaterialDTO("Arena", 100.0f, "Cemex", "kg");
        MaterialDTO material3 = new MaterialDTO("Varilla", 20.5f, "Ternium", "kg");
        MaterialDTO material4 = new MaterialDTO("Pintura Blanca", 4.0f, "Comex", "litros");
        MaterialDTO material5 = new MaterialDTO("Yeso", 25.0f, "Knauf", "kg");
        MaterialDTO material6 = new MaterialDTO("Clavos", 2.0f, "Truper", "kg");
        MaterialDTO material7 = new MaterialDTO("Madera", 30.0f, "Finsa", "kg");
        MaterialDTO material8 = new MaterialDTO("Adhesivo", 1.5f, "Resistol", "litros");
        
        // Instancias de RecursoDTO y añadiéndolas a la lista
        recursos.add(new RecursoDTO(material1, 100, 1L));  // 100 unidades de cemento
        recursos.add(new RecursoDTO(material2, 50, 1L));   // 50 unidades de arena
        recursos.add(new RecursoDTO(material3, 200, 1L));  // 200 unidades de varilla
        recursos.add(new RecursoDTO(material4, 10, 1L));   // 10 unidades de pintura blanca
        recursos.add(new RecursoDTO(material5, 75, 1L));   // 75 unidades de yeso
        recursos.add(new RecursoDTO(material6, 500, 1L));  // 500 unidades de clavos
        recursos.add(new RecursoDTO(material7, 150, 1L));  // 150 unidades de madera
        recursos.add(new RecursoDTO(material8, 25, 1L));   // 25 unidades de adhesivo
        
        return recursos;
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
        List<RecursoDTO> recursosObra = obtenerRecursosObra(idObra);
        // Si el material se encuentra registrado, se actualiza la cantidad de stock
        for (RecursoDTO recurso : recursosObra) {
            if (recurso.getMaterial().getNombre().equals(nombreMaterial) || recurso.getMaterial().getUnidadPeso().equals(unidadPeso)) {
                recurso.setCantidad(cantidad);
            }
        }
        return true;
    }
    
}
