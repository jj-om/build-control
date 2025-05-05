/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;

/**
 * Clase AsistenciaPersonal
 * 
 * Clase constructora de un objecto asistenciaPersonal dentro del sistema. Clase
 * que representa la asistencia registrada de un empleado en un día determinado,
 * contiene la información del nombre, hora de entrada y salida, así como notas
 * adicionales.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class AsistenciaPersonal {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    private Long id;
    
    /**
     * Nombre del empleado.
     */
    private String nombreEmpleado;
    
    /**
     * Fecha y hora de entrada.
     */
    private Date horaEntrada;
    
    /**
     * Fecha y hora de salida.
     */
    private Date horaSalida;
    
    /**
     * Notas adicionales.
     */
    private String notas;

    /**
     * Constructor vacío requerido para frameworks de persistencia.
     */
    public AsistenciaPersonal() {
    }

    /**
     * Constructor completo para crear un registro de asistencia personal.
     * 
     * @param nombreEmpleado nombre del empleado
     * @param horaEntrada hora de entrada
     * @param horaSalida hora de salida
     * @param notas notas adicionales
     */
    public AsistenciaPersonal(String nombreEmpleado, Date horaEntrada, Date horaSalida, String notas) {
        this.nombreEmpleado = nombreEmpleado;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.notas = notas;
    }

    /**
     * Obtiene el ID del registro.
     * 
     * @return ID del registro.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del registro.
     * 
     * @param id ID a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del empleado.
     * 
     * @return Nombre del empleado.
     */
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * Establece el nombre del empleado.
     * 
     * @param nombreEmpleado Nombre del empleado.
     */
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    /**
     * Obtiene la hora de entrada.
     * 
     * @return Hora de entrada.
     */
    public Date getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Establece la hora de entrada.
     * 
     * @param horaEntrada Hora de entrada.
     */
    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Obtiene la hora de salida.
     * 
     * @return Hora de salida.
     */
    public Date getHoraSalida() {
        return horaSalida;
    }

    /**
     * Establece la hora de salida.
     * 
     * @param horaSalida Hora de salida.
     */
    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * Obtiene las notas adicionales del registro.
     * 
     * @return Notas del registro.
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Establece las notas del registro.
     * 
     * @param notas Notas adicionales.
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * Devuelve una representación en forma de cadena de AsistenciaPersonal.
     *
     * @return Cadena con los atributos del objeto asistenciaPersonal.
     */
    @Override
    public String toString() {
        return "AsistenciaPersonal{" +
                "id=" + id +
                ", nombreEmpleado=" + nombreEmpleado + 
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", notas=" + notas +
                '}';
    }

}