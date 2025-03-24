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
    private RecursoDTO recurso;
    private Integer cantidad;

    public MaterialIngresadoDTO() {
    }

    public MaterialIngresadoDTO(RecursoDTO recurso, Integer cantidad) {
        this.recurso = recurso;
        this.cantidad = cantidad;
    }

    public RecursoDTO getRecurso() {
        return recurso;
    }

    public void setRecurso(RecursoDTO recurso) {
        this.recurso = recurso;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "MaterialIngresadoDTO{" + "recurso=" + recurso + ", cantidad=" + cantidad + '}';
    }
}
