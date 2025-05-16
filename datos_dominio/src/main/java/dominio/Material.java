/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dominio_enums.TipoMaterialDatos;

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
    private Long id;
    
    private String codigo;
    
    /**
     * Nombre del material.
     */
    private String nombre;
    
    /**
     * Marca del material.
     */
    private String marca;
    
    private TipoMaterialDatos tipo;
    private UnidadContenido unidadPresentacion;

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
    public Material(String codigo, String nombre, String marca, TipoMaterialDatos tipo, UnidadContenido unidadPresentacion) {    
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.unidadPresentacion = unidadPresentacion;
    }

    /**
     * Obtiene el ID del material.
     *
     * @return El identificador único del material.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del material.
     *
     * @param id El nuevo identificador del material.
     */
    public void setIdMaterial(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public TipoMaterialDatos getTipo() {
        return tipo;
    }

    public void setTipo(TipoMaterialDatos tipo) {
        this.tipo = tipo;
    }

    public UnidadContenido getUnidadPresentacion() {
        return unidadPresentacion;
    }

    public void setUnidadPresentacion(UnidadContenido unidadPresentacion) {
        this.unidadPresentacion = unidadPresentacion;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Material.
     *
     * @return Cadena con los atributos del material.
     */
    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", tipo=" + tipo + ", unidadPresentacion=" + unidadPresentacion + '}';
    }
}