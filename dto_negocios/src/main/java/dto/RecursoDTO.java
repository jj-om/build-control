/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase RecursoDTO
 *
 * Data Transfer Object (DTO) que representa un recurso material específico
 * junto con su cantidad disponible o asignada. 
 * Esta clase combina la información detallada de un material con su componente
 * cuantitativo, facilitando su gestión en el inventario.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class RecursoDTO {
    
    /**
     * Información del material. 
     * Contiene los datos que identifican y caracterizan al material específico. 
     */
    private MaterialDTO material;
    
    /**
     * Cantidad del material. 
     */
    private Integer cantidad;

    /**
     * Constructor por defecto. 
     * Inicializa una instancia de RecursoDTO sin datos.
     */
    public RecursoDTO() {
    }

    /**
     * Constructor parametrizado. Crea una instancia de RecursoDTO con sus dos atributos.
     *
     * @param material El material específico (objeto MaterialDTO)
     * @param cantidad La cantidad de unidades o medida
     */
    public RecursoDTO(MaterialDTO material, Integer cantidad) {
        this.material = material;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la información del material.
     *
     * @return El objeto MaterialDTO con los datos del material
     */
    public MaterialDTO getMaterial() {
        return material;
    }

    /**
     * Establece la información del material.
     *
     * @param material El nuevo objeto MaterialDTO
     */
    public void setMaterial(MaterialDTO material) {
        this.material = material;
    }

    /**
     * Obtiene la cantidad del material.
     *
     * @return El número de unidades o medida del material
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del material.
     *
     * @param cantidad La nueva cantidad de material
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Genera una representación en cadena de texto del objeto RecursoDTO. 
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "RecursoDTO{" + "material=" + material + ", cantidad=" + cantidad + '}';
    }
}
