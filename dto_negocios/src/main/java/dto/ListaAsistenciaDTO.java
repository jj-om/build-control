/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase ListaAsistenciaDTO
 *
 * Data Transfer Object (DTO) que encapsula la lista completa de asistencias del
 * personal para una fecha específica. 
 * Esta clase agrupa todas las asistencias individuales registradas para una jornada
 * laboral determinada.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class ListaAsistenciaDTO {
    
    /**
     * Fecha del registro de asistencia. 
     */
    private LocalDate fecha;
    
    /**
     * Colección de registros de asistencia individual. 
     */
    private List<AsistenciaPersonalDTO> asistencias;

    /**
     * Constructor por defecto. 
     * Inicializa una instancia de ListaAsistenciaDTO sin datos.
     */
    public ListaAsistenciaDTO() {
    }

    /**
     * Constructor parametrizado. Crea una instancia de ListaAsistenciaDTO con
     * todos sus atributos.
     *
     * @param fecha La fecha del registro de asistencia
     * @param asistencias La lista de asistencias individuales
     */
    public ListaAsistenciaDTO(LocalDate fecha, List<AsistenciaPersonalDTO> asistencias) {
        this.fecha = fecha;
        this.asistencias = asistencias;
    }

    /**
     * Obtiene la fecha del registro de asistencia.
     *
     * @return La fecha para la cual se han registrado las asistencias
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del registro de asistencia.
     *
     * @param fecha La nueva fecha para el registro
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la lista de asistencias individuales.
     *
     * @return La colección de registros de asistencia para esta fecha
     */
    public List<AsistenciaPersonalDTO> getAsistencias() {
        return asistencias;
    }

    /**
     * Establece la lista de asistencias individuales.
     *
     * @param asistencias La nueva colección de registros de asistencia
     */
    public void setAsistencias(List<AsistenciaPersonalDTO> asistencias) {
        this.asistencias = asistencias;
    }

    /**
     * Genera una representación en cadena de texto del objeto ListaAsistenciaDTO. 
     *
     * @return Una cadena representando la fecha y el conjunto de asistencias
     */
    @Override
    public String toString() {
        return "ListaAsistenciaDTO{" + "fecha=" + fecha + ", asistencias=" + asistencias + '}';
    }
}
