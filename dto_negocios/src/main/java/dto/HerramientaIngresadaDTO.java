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
    private String nombreHerramienta;
    private int cantidad;

    public HerramientaIngresadaDTO() {
    }

    public HerramientaIngresadaDTO(String nombreHerramienta, int cantidad) {
        this.nombreHerramienta = nombreHerramienta;
        this.cantidad = cantidad;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
