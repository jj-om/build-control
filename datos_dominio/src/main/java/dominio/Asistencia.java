/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;
import java.util.List;

/**
 * Clase Asistencia
 * 
 * Clase constructora de una asistencia dentro del sistema. Clase que representa
 * la asistencia general en una fecha determinada, contiene una lista de
 * registros individuales de asistencia y la fecha de asistencia.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Asistencia {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    private Long id;
    
    /**
     * Fecha de la asistencia.
     */
    private Date fecha;
    
    /**
     * Lista de asistencia general.
     */
    private List<AsistenciaPersonal> asistenciaPersonal;

    /**
     * Constructor vacío requerido para frameworks de persistencia.
     */
    public Asistencia() {
    }

    /**
     * Crea un nuevo registro de asistencia para una fecha.
     *
     * @param fecha Fecha de la asistencia.
     * @param asistenciaPersonal Lista de asistencias personales.
     */
    public Asistencia(Date fecha, List<AsistenciaPersonal> asistenciaPersonal) {
        this.fecha = fecha;
        this.asistenciaPersonal = asistenciaPersonal;
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
     * Obtiene la fecha del registro de asistencia.
     * 
     * @return Fecha del registro.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del registro de asistencia.
     * 
     * @param fecha Fecha a establecer.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la lista de asistencias personales.
     * 
     * @return Lista de {@link AsistenciaPersonal}.
     */
    public List<AsistenciaPersonal> getAsistenciaPersonal() {
        return asistenciaPersonal;
    }

    /**
     * Establece la lista de asistencias personales.
     * 
     * @param asistenciaPersonal Lista de asistencias personales.
     */
    public void setAsistenciaPersonal(List<AsistenciaPersonal> asistenciaPersonal) {
        this.asistenciaPersonal = asistenciaPersonal;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Asistencia.
     *
     * @return Cadena con los atributos de la asistencia.
     */
    @Override
    public String toString() {
        return "Asistencia{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", asistenciaPersonal=" + asistenciaPersonal +
                '}';
    }

}