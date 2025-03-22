/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalTime;

/**
 *
 * @author dario
 */
public class AsistenciaPersonalDTO {
    private String nombre;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private String notas;

    public AsistenciaPersonalDTO() {
    }

    public AsistenciaPersonalDTO(String nombre, LocalTime horaEntrada, LocalTime horaSalida, String notas) {
        this.nombre = nombre;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    
}
