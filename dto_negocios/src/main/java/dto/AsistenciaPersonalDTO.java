/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalTime;

/**
 * Clase AsistenciaPersonalDTO
 *
 * Data Transfer Object (DTO) que encapsula la información de asistencia del
 * personal en una obra. Esta clase transporta datos relacionados con el
 * registro de entrada y salida de los trabajadores entre las diferentes capas
 * de la aplicación.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class AsistenciaPersonalDTO {

    /**
     * Nombre del trabajador o empleado.
     */
    private String nombre;

    /**
     * Hora de entrada del trabajador a la obra. Registra el momento en que el
     * empleado inicia sus labores.
     */
    private LocalTime horaEntrada;

    /**
     * Hora de salida del trabajador de la obra. Registra el momento en que el
     * empleado finaliza sus labores.
     */
    private LocalTime horaSalida;

    /**
     * Notas u observaciones adicionales sobre la asistencia.
     */
    private String notas;

    /**
     * Constructor por defecto. Inicializa una instancia de
     * AsistenciaPersonalDTO sin datos.
     */
    public AsistenciaPersonalDTO() {
    }

    /**
     * Constructor parametrizado. Crea una instancia de AsistenciaPersonalDTO
     * con todos sus atributos.
     *
     * @param nombre Nombre del trabajador
     * @param horaEntrada Hora de entrada del trabajador
     * @param horaSalida Hora de salida del trabajador
     * @param notas Notas adicionales sobre la asistencia
     */
    public AsistenciaPersonalDTO(String nombre, LocalTime horaEntrada, LocalTime horaSalida, String notas) {
        this.nombre = nombre;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.notas = notas;
    }

    /**
     * Obtiene el nombre del trabajador.
     *
     * @return El nombre del trabajador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del trabajador.
     *
     * @param nombre El nuevo nombre del trabajador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la hora de entrada del trabajador.
     *
     * @return La hora de entrada registrada
     */
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Establece la hora de entrada del trabajador.
     *
     * @param horaEntrada La nueva hora de entrada
     */
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Obtiene la hora de salida del trabajador.
     *
     * @return La hora de salida registrada
     */
    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    /**
     * Establece la hora de salida del trabajador.
     *
     * @param horaSalida La nueva hora de salida
     */
    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * Obtiene las notas sobre la asistencia.
     *
     * @return Las notas registradas
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Establece las notas sobre la asistencia.
     *
     * @param notas Las nuevas notas a registrar
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * Genera una representación en cadena de texto del objeto
     * AsistenciaPersonalDTO.
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "AsistenciaPersonalDTO{" + "nombre=" + nombre + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", notas=" + notas + '}';
    }
}
