/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase HerramientaDTO
 *
 * Data Transfer Object (DTO) que representa una herramienta. 
 * Esta clase encapsula la información básica que identifica a una
 * herramienta específica y se utiliza para transportar estos datos entre las
 * diferentes capas de la aplicación.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class HerramientaDTO {
    
    /**
     * Nombre de la herramienta. 
     */
    private String nombre;
    
    /**
     * Marca de la herramienta. 
     */
    private String marca;
    
    /**
     * Modelo de la herramienta. 
     */
    private String modelo;

    /**
     * Constructor por defecto. 
     * Inicializa una instancia de HerramientaDTO sin datos.
     */
    public HerramientaDTO() {
    }

    /**
     * Constructor parametrizado. 
     * Crea una instancia de HerramientaDTO con todos sus atributos.
     *
     * @param nombre El nombre o tipo de la herramienta
     * @param marca La marca de la herramienta
     * @param modelo El modelo específico de la herramienta
     */
    public HerramientaDTO(String nombre, String marca, String modelo) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Obtiene el nombre de la herramienta.
     *
     * @return El nombre o tipo de la herramienta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la herramienta.
     *
     * @param nombre El nuevo nombre para la herramienta
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la marca de la herramienta.
     *
     * @return La marca de la herramienta
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca de la herramienta.
     *
     * @param marca La nueva marca para la herramienta
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo de la herramienta.
     *
     * @return El modelo de la herramienta
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo de la herramienta.
     *
     * @param modelo El nuevo modelo para la herramienta
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Genera una representación en cadena de texto del objeto HerramientaDTO.
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "HerramientaDTO{" + "nombre=" + nombre + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
}