/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Clase Material
 * 
 * Clase constructora de un material dentro del sistema. Esta clase representa
 * un material utilizado en la obra, contiene información sobre su nombre, peso,
 * marca y la unidad de medida del peso.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Material {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    @BsonId
    private ObjectId id;
    
    /**
     * Nombre del material.
     */
    private String nombre;
    
    /**
     * Peso del material.
     */
    private Float peso;
    
    /**
     * Marca del material.
     */
    private String marca;
    
    /**
     * Unidad de medida del peso del material.
     */
    private String unidadPeso;

    /** 
     * Constructor vacío requerido para frameworks de persistencia. 
     */
    public Material() {
    }

    /**
     * Constructor que inicializa todos los atributos del material.
     *
     * @param nombre Nombre del material.
     * @param peso Peso del material.
     * @param marca Marca del material.
     * @param unidadPeso Unidad de medida del peso.
     */
    public Material(String nombre, Float peso, String marca, String unidadPeso) {
        this.nombre = nombre;
        this.peso = peso;
        this.marca = marca;
        this.unidadPeso = unidadPeso;
    }

    /**
     * Obtiene el ID del material.
     *
     * @return El identificador único del material.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del material.
     *
     * @param id El nuevo identificador del material.
     */
    public void setIdMaterial(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del material.
     *
     * @return El nombre del material.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del material.
     *
     * @param nombre El nuevo nombre del material.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el peso del material.
     *
     * @return El peso del material.
     */
    public float getPeso() {
        return peso;
    }

    /**
     * Establece el peso del material.
     *
     * @param peso El nuevo peso del material.
     */
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    /**
     * Obtiene la marca del material.
     *
     * @return La marca del material.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del material.
     *
     * @param marca La nueva marca del material.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la unidad de peso del material.
     *
     * @return La unidad de peso (ej. "kg", "g").
     */
    public String getUnidadPeso() {
        return unidadPeso;
    }

    /**
     * Establece la unidad de peso del material.
     *
     * @param unidadPeso La nueva unidad de peso.
     */
    public void setUnidadPeso(String unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Material.
     *
     * @return Cadena con los atributos del material.
     */
    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", peso=" + peso +
                ", marca=" + marca +
                ", unidadPeso=" + unidadPeso +
                '}';
    }
 
}