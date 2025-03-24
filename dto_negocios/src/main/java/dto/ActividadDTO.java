/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author alega
 */
public class ActividadDTO {
    
    private String tituloActividad;
    private String descripcionActividad;

    public ActividadDTO() {
    }

    public ActividadDTO(String tituloActividad, String descripcionActividad) {
        this.tituloActividad = tituloActividad;
        this.descripcionActividad = descripcionActividad;
    }

    public String getTituloActividad() {
        return tituloActividad;
    }

    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    @Override
    public String toString() {
        return "ActividadDTO{" + "tituloActividad=" + tituloActividad + ", descripcionActividad=" + descripcionActividad + '}';
    }
}
