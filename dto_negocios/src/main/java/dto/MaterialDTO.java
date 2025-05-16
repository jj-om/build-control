/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import negocio_enums.TipoMaterialNegocio;

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
    
    private String codigo;
    
    /**
     * Nombre del material. 
     */
    private String nombre;
    
    /**
     * Marca del material. 
     */
    private String marca;
    
    private TipoMaterialNegocio tipo;
    private UnidadContenidoNegocioDTO unidadPresentacion;

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
     * @param codigo
     * @param nombre El nombre del material
     * @param marca La marca del material
     * @param tipo
     * @param unidadPresentacion
     */
    public MaterialDTO(String codigo, String nombre, String marca, TipoMaterialNegocio tipo, UnidadContenidoNegocioDTO unidadPresentacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.unidadPresentacion = unidadPresentacion;
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

    public TipoMaterialNegocio getTipo() {
        return tipo;
    }

    public void setTipo(TipoMaterialNegocio tipo) {
        this.tipo = tipo;
    }

    public UnidadContenidoNegocioDTO getUnidadPresentacion() {
        return unidadPresentacion;
    }

    public void setUnidadPresentacion(UnidadContenidoNegocioDTO unidadPresentacion) {
        this.unidadPresentacion = unidadPresentacion;
    }
    
    /**
     * Genera una representación en cadena de texto del objeto MaterialDTO.
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "MaterialDTO{" + "codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", tipo=" + tipo + ", unidadPresentacion=" + unidadPresentacion + '}';
    }
}
