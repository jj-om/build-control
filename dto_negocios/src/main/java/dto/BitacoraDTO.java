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
    Integer idObra;

    public BitacoraDTO() {
    }
    
    public BitacoraDTO(LocalDate fecha, Integer idObra) {
        this.fecha = fecha;
        this.idObra = idObra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getIdObra() {
        return idObra;
    }

    public void setIdObra(Integer idObra) {
        this.idObra = idObra;
    }
}
