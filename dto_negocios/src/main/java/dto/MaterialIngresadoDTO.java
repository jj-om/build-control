/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author dario
 */
public class MaterialIngresadoDTO {
    private String nombreMaterial;
    private int cantidad;

    public MaterialIngresadoDTO() {
    }

    public MaterialIngresadoDTO(String nombreMaterial, int cantidad) {
        this.nombreMaterial = nombreMaterial;
        this.cantidad = cantidad;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
