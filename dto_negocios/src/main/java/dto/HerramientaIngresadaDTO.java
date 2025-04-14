/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase HerramientaIngresadaDTO
 *
 * Data Transfer Object (DTO) que representa la asociación entre una herramienta
 * específica y la cantidad utilizada de la misma en una bitácora de obra. 
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class HerramientaIngresadaDTO {
    
    /**
     * Información básica de la herramienta. 
     * Contiene los datos que identifican a la herramienta específica. 
     */
    private HerramientaDTO herramienta;
    
    /**
     * Cantidad de unidades de esta herramienta utilizadas. Representa el número
     * de herramientas de este tipo que se emplearon.
     */
    private Integer cantidad;

    /**
     * Constructor por defecto. 
     * Inicializa una instancia de HerramientaIngresadaDTO sin datos.
     */
    public HerramientaIngresadaDTO() {
    }

    /**
     * Constructor parametrizado. 
     * Crea una instancia de HerramientaIngresadaDTO con todos sus atributos.
     *
     * @param herramienta La herramienta utilizada (objeto HerramientaDTO)
     * @param cantidad La cantidad de unidades utilizadas
     */
    public HerramientaIngresadaDTO(HerramientaDTO herramienta, Integer cantidad) {
        this.herramienta = herramienta;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la información de la herramienta.
     *
     * @return El objeto HerramientaDTO con los datos de la herramienta
     */
    public HerramientaDTO getHerramienta() {
        return herramienta;
    }

    /**
     * Establece la información de la herramienta.
     *
     * @param herramienta El nuevo objeto HerramientaDTO
     */
    public void setHerramienta(HerramientaDTO herramienta) {
        this.herramienta = herramienta;
    }

    /**
     * Obtiene la cantidad de unidades utilizadas.
     *
     * @return El número de herramientas de este tipo empleadas
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de unidades utilizadas.
     *
     * @param cantidad La nueva cantidad de herramientas
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Genera una representación en cadena de texto del objeto HerramientaIngresadaDTO. 
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "HerramientaIngresadaDTO{" + "herramienta=" + herramienta + ", cantidad=" + cantidad + '}';
    }
}