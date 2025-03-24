/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;

/**
 *
 * @author rocha
 */
public class BitacoraDTO {
    LocalDate fecha;
    Long idObra;

    public BitacoraDTO() {
    }
    
    public BitacoraDTO(LocalDate fecha, Long idObra) {
        this.fecha = fecha;
        this.idObra = idObra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getIdObra() {
        return idObra;
    }

    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    @Override
    public String toString() {
        return "BitacoraDTO{" + "fecha=" + fecha + ", idObra=" + idObra + '}';
    }

}
