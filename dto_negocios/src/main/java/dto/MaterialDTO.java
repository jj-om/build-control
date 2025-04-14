/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase MaterialDTO
 *
 * Data Transfer Object (DTO) que representa un material de construcción. 
 * Esta clase encapsula la información básica que identifica y caracteriza a un material específico, 
 * facilitando su transporte entre las diferentes capas de la aplicación.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class MaterialDTO {
    
    /**
     * Nombre del material. 
     */
    private String nombre;
    
    /**
     * Peso estándar del material. 
     */
    private Float peso;
    
    /**
     * Marca del material. 
     */
    private String marca;
    
    /**
     * Unidad de medida del peso.
     */
    private String unidadPeso;

    /**
     * Constructor por defecto. 
     * Inicializa una instancia de MaterialDTO sin datos.
     */
    public MaterialDTO() {
    }

    /**
     * Constructor parametrizado. 
     * Crea una instancia de MaterialDTO con todos sus atributos.
     *
     * @param nombre El nombre del material
     * @param peso El peso estándar del material
     * @param marca La marca del material
     * @param unidadPeso La unidad de medida del peso
     */
    public MaterialDTO(String nombre, Float peso, String marca, String unidadPeso) {
        this.nombre = nombre;
        this.peso = peso;
        this.marca = marca;
        this.unidadPeso = unidadPeso;
    }

    /**
     * Obtiene el nombre del material.
     *
     * @return El nombre o tipo del material
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del material.
     *
     * @param nombre El nuevo nombre para el material
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el peso estándar del material.
     *
     * @return El peso de una unidad estándar
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * Establece el peso estándar del material.
     *
     * @param peso El nuevo peso estándar
     */
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    /**
     * Obtiene la marca del material.
     *
     * @return La marca del material
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del material.
     *
     * @param marca La nueva marca para el material
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la unidad de medida del peso.
     *
     * @return La unidad en que se expresa el peso
     */
    public String getUnidadPeso() {
        return unidadPeso;
    }

    /**
     * Establece la unidad de medida del peso.
     *
     * @param unidadPeso La nueva unidad de medida
     */
    public void setUnidadPeso(String unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    /**
     * Genera una representación en cadena de texto del objeto MaterialDTO. 
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "MaterialDTO{" + "nombre=" + nombre + ", peso=" + peso + ", marca=" + marca + ", unidadPeso=" + unidadPeso + '}';
    }
}
