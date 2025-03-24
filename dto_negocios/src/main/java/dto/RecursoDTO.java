/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author rocha
 */
public class RecursoDTO {
    private MaterialDTO material;
    private Integer cantidad;

    public RecursoDTO() {
    }

    public RecursoDTO(MaterialDTO material, Integer cantidad) {
        this.material = material;
        this.cantidad = cantidad;
    }

    public MaterialDTO getMaterial() {
        return material;
    }

    public void setMaterial(MaterialDTO material) {
        this.material = material;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "RecursoDTO{" + "material=" + material + ", cantidad=" + cantidad + '}';
    }
}
