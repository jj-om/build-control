/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author dario
 */
public class HerramientaIngresadaDTO {
    private HerramientaDTO herramienta;
    private Integer cantidad;

    public HerramientaIngresadaDTO() {
    }

    public HerramientaIngresadaDTO(HerramientaDTO herramienta, Integer cantidad) {
        this.herramienta = herramienta;
        this.cantidad = cantidad;
    }

    public HerramientaDTO getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(HerramientaDTO herramienta) {
        this.herramienta = herramienta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "HerramientaIngresadaDTO{" + "herramienta=" + herramienta + ", cantidad=" + cantidad + '}';
    }
}