/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Material;
import dominio.Obra;
import dominio.Recurso;
import dominio.UnidadContenido;
import dominio_enums.TipoMaterialDatos;
import dominio_enums.UnidadBaseDatos;
import dominio_enums.UnidadPresentacionDatos;
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
     * Lista de recursos disponibles en el sistema. Almacena los materiales con
     * sus cantidades correspondientes.
     */
    private final List<Recurso> recursos;
    
    /**
     * Constructor privado (patrón Singleton). Inicializa la lista de recursos y
     * previene la creación de múltiples instancias desde fuera de la clase.
     */
    public RecursoDAO() {
        this.recursos = new ArrayList<>();
        inicializarRecursosMock();
    }
  
    /**
     * Inicializa datos de prueba para simular recursos en la base de datos.
     */
    private void inicializarRecursosMock() {
        // Crear algunos materiales de ejemplo
        // Unidades de presentación
        UnidadContenido unidadCemento = new UnidadContenido(UnidadPresentacionDatos.SACO, UnidadBaseDatos.KILOGRAMO, 50);
        UnidadContenido unidadArena = new UnidadContenido(UnidadPresentacionDatos.CAMION, UnidadBaseDatos.METRO_CUBICO, 6);
        UnidadContenido unidadLadrillo = new UnidadContenido(UnidadPresentacionDatos.CAJA, UnidadBaseDatos.PIEZA, 100);
        UnidadContenido unidadPintura = new UnidadContenido(UnidadPresentacionDatos.BOTE, UnidadBaseDatos.LITRO, 19);
        UnidadContenido unidadClavos = new UnidadContenido(UnidadPresentacionDatos.CAJA, UnidadBaseDatos.KILOGRAMO, 5);
        UnidadContenido unidadMadera = new UnidadContenido(UnidadPresentacionDatos.PAQUETE, UnidadBaseDatos.METRO, 30);
        UnidadContenido unidadResina = new UnidadContenido(UnidadPresentacionDatos.GARRAFA, UnidadBaseDatos.LITRO, 10);

        // Lista de materiales
        Material material1 = new Material("M001", "Cemento gris", "APC", TipoMaterialDatos.CEMENTO, unidadCemento);
        material1.setIdMaterial(1L);
        
        Material material2 = new Material("M002", "Arena fina de río", "Constructo", TipoMaterialDatos.ARENA, unidadArena);
        material2.setIdMaterial(2L);
        
        Material material3 = new Material("M003", "Ladrillo rojo común", "Ladrimex", TipoMaterialDatos.LADRILLO, unidadLadrillo);
        material3.setIdMaterial(3L);
        
        Material material4 = new Material("M004", "Pintura blanca vinílica", "Pinturas del Norte", TipoMaterialDatos.PINTURA, unidadPintura);
        material4.setIdMaterial(4L);
        
        Material material5 = new Material("M005", "Clavo acerado 2\"", "Ferrerías MX", TipoMaterialDatos.CLAVO, unidadClavos);
        material5.setIdMaterial(5L);
        
        Material material6 = new Material("M006", "Tabla de pino 3m", "Maderas del Sur", TipoMaterialDatos.MADERA, unidadMadera);
        material6.setIdMaterial(6L);
        
        Material material7 = new Material("M007", "Resina epóxica transparente", "Resincol", TipoMaterialDatos.RESINA, unidadResina);
        material7.setIdMaterial(7L);

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
        try {
            // Filtrar los recursos que pertenecen a la obra específica
            return recursos.stream()
                    .filter(recurso -> recurso.getIdObra().equals(numero))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DAOException("Error al obtener los recursos de la obra.");
        }
    }
    
    /**
     * Actualiza la cantidad disponible de un recurso específico.
     *
     * @param idObra Identificador de la obra
     * @param codigo
     * @param cantidad Nueva cantidad disponible
     * @return true si la actualización fue exitosa, false en caso contrario
     * @throws DAOException Si ocurre un error durante la actualización
     */
    public boolean actualizarCantidadRecurso(Long idObra, String codigo, Integer cantidad) throws DAOException {
        try {
            // Buscar el recurso que coincida con los criterios
            for (Recurso recurso : recursos) {
                if (recurso.getIdObra().equals(idObra) && recurso.getMaterial().getCodigo().equals(codigo)) {
                    // Actualizar la cantidad
                    recurso.setCantidad(cantidad);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new DAOException("Error al actualizar la cantidad de recursos de la obra.");
        }
    }
}
