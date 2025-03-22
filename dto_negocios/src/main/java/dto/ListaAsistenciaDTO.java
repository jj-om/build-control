/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 *
 * @author dario
 */
public class ListaAsistenciaDTO {
    private String fecha;
    private List<AsistenciaPersonalDTO> asistencias;

    public ListaAsistenciaDTO() {
    }

    public ListaAsistenciaDTO(String fecha, List<AsistenciaPersonalDTO> asistencias) {
        this.fecha = fecha;
        this.asistencias = asistencias;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<AsistenciaPersonalDTO> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<AsistenciaPersonalDTO> asistencias) {
        this.asistencias = asistencias;
    }
    
    
}
