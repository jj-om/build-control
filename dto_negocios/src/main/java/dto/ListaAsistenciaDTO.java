/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author dario
 */
public class ListaAsistenciaDTO {
    private LocalDate fecha;
    private List<AsistenciaPersonalDTO> asistencias;

    public ListaAsistenciaDTO() {
    }

    public ListaAsistenciaDTO(LocalDate fecha, List<AsistenciaPersonalDTO> asistencias) {
        this.fecha = fecha;
        this.asistencias = asistencias;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<AsistenciaPersonalDTO> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<AsistenciaPersonalDTO> asistencias) {
        this.asistencias = asistencias;
    }

    @Override
    public String toString() {
        return "ListaAsistenciaDTO{" + "fecha=" + fecha + ", asistencias=" + asistencias + '}';
    }
}
