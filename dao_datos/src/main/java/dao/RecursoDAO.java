/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Material;
import dominio.Obra;
import dominio.Recurso;
import excepciones.DAOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del DAO para gestionar los recursos en la base de datos.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class RecursoDAO {
    
    /**
     * Instancia única de la clase (patrón Singleton). Garantiza que solo exista
     * una instancia en toda la aplicación.
     */
    public static RecursoDAO instance;

    /**
     * Lista de recursos disponibles en el sistema. Almacena los materiales con
     * sus cantidades correspondientes.
     */
    private final List<Recurso> recursos;
    
    /**
     * Constructor privado (patrón Singleton). Inicializa la lista de recursos y
     * previene la creación de múltiples instancias desde fuera de la clase.
     */
    private RecursoDAO() {
        this.recursos = new ArrayList<>();
        inicializarRecursosMock();
    }
    
    /**
     * Método para obtener la instancia única de RecursoDAO (patrón Singleton).
     * Si no existe una instancia, la crea, de lo contrario, devuelve la
     * existente.
     *
     * @return La instancia única de RecursoDAO
     */
    public static RecursoDAO getInstance() {
        if (instance == null) {
            instance = new RecursoDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para simular recursos en la base de datos.
     */
    private void inicializarRecursosMock() {
        // Crear algunos materiales de ejemplo
        Material material1 = new Material("Cemento", 50.0f, "Holcim", "kg");
        material1.setIdMaterial(1L); 

        Material material2 = new Material("Arena", 100.0f, "Cemex", "kg");
        material2.setIdMaterial(2L);

        Material material3 = new Material("Varilla", 20.5f, "Ternium", "kg");
        material3.setIdMaterial(3L);

        Material material4 = new Material("Pintura Blanca", 4.0f, "Comex", "litros");
        material4.setIdMaterial(4L);

        Material material5 = new Material("Yeso", 25.0f, "Knauf", "kg");
        material5.setIdMaterial(5L);

        Material material6 = new Material("Clavos", 2.0f, "Truper", "kg");
        material6.setIdMaterial(6L);

        Material material7 = new Material("Madera", 30.0f, "Finsa", "kg");
        material7.setIdMaterial(7L);

        Material material8 = new Material("Adhesivo", 1.5f, "Resistol", "litros");
        material8.setIdMaterial(8L);

        // Crear una obra ejemplo
        Obra obra = new Obra(1L, "Camino de los Mayos #716", 500.0);
        obra.setIdObra(1L); 

        // Crear recursos y asignarles los materiales y la obra
        Recurso recurso1 = new Recurso(material1, 100, obra.getIdObra());
        recurso1.setId(1L);
        recursos.add(recurso1);

        Recurso recurso2 = new Recurso(material2, 50, obra.getIdObra());
        recurso2.setId(2L);
        recursos.add(recurso2);

        Recurso recurso3 = new Recurso(material3, 200, obra.getIdObra());
        recurso3.setId(3L);
        recursos.add(recurso3);

        Recurso recurso4 = new Recurso(material4, 10, obra.getIdObra());
        recurso4.setId(4L);
        recursos.add(recurso4);

        Recurso recurso5 = new Recurso(material5, 75, obra.getIdObra());
        recurso5.setId(5L);
        recursos.add(recurso5);

        Recurso recurso6 = new Recurso(material6, 500, obra.getIdObra());
        recurso6.setId(6L);
        recursos.add(recurso6);

        Recurso recurso7 = new Recurso(material7, 150, obra.getIdObra());
        recurso7.setId(7L);
        recursos.add(recurso7);

        Recurso recurso8 = new Recurso(material8, 25, obra.getIdObra());
        recurso8.setId(8L);
        recursos.add(recurso8);
    }
    
    /**
     * Obtiene la lista de recursos disponibles para una obra específica.
     *
     * @param numero Identificador de la obra para la cual se buscan los
     * recursos
     * @return Lista de objetos Recurso con los materiales disponibles, sus
     * cantidades y la obra
     * @throws DAOException Si ocurre un error durante la operación
     */
    public List<Recurso> obtenerRecursosObra(Long numero) throws DAOException {
        // Filtrar los recursos que pertenecen a la obra específica
        return recursos.stream()
                .filter(recurso -> recurso.getIdObra().equals(numero))
                .collect(Collectors.toList());
    }
    
    /**
     * Actualiza la cantidad disponible de un recurso específico.
     *
     * @param idObra Identificador de la obra
     * @param nombreMaterial Nombre del material
     * @param unidadPeso Unidad de medida del peso
     * @param cantidad Nueva cantidad disponible
     * @return true si la actualización fue exitosa, false en caso contrario
     * @throws DAOException Si ocurre un error durante la actualización
     */
    public boolean actualizarCantidadRecurso(Long idObra, String nombreMaterial, String unidadPeso, Integer cantidad) throws DAOException {
        // Buscar el recurso que coincida con los criterios
        for (Recurso recurso : recursos) {
            if (recurso.getIdObra().equals(idObra)
                    && recurso.getMaterial().getNombre().equals(nombreMaterial)
                    && recurso.getMaterial().getUnidadPeso().equals(unidadPeso)) {

                // Actualizar la cantidad
                recurso.setCantidad(cantidad);
                return true;
            }
        }
        return false;
    }
    
}
