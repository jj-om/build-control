/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase ActividadDTO
 * 
 * Data Transfer Object (DTO) que representa una actividad.
 * Esta clase se utiliza para transportar información de actividades entre las diferentes
 * capas de la aplicación sin exponer los detalles de implementación del modelo de negocio.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class ActividadDTO {
    
    /**
     * Título o nombre de la actividad registrada.
     */
    private String tituloActividad;
    
    /**
     * Descripción detallada de la actividad.
     */
    private String descripcionActividad;

    /**
     * Constructor por defecto.
     * Inicializa una instancia de ActividadDTO sin datos.
     */
    public ActividadDTO() {
    }

    /**
     * Constructor parametrizado.
     * Crea una instancia de ActividadDTO con los valores especificados.
     * 
     * @param tituloActividad El nombre de la actividad
     * @param descripcionActividad La descripción de la actividad
     */
    public ActividadDTO(String tituloActividad, String descripcionActividad) {
        this.tituloActividad = tituloActividad;
        this.descripcionActividad = descripcionActividad;
    }

    /**
     * Obtiene el título de la actividad.
     * 
     * @return El título de la actividad
     */
    public String getTituloActividad() {
        return tituloActividad;
    }

    /**
     * Establece el título de la actividad.
     * 
     * @param tituloActividad El nuevo título para la actividad
     */
    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    /**
     * Obtiene la descripción de la actividad.
     * 
     * @return La descripción detallada de la actividad
     */
    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    /**
     * Establece la descripción de la actividad.
     * 
     * @param descripcionActividad La nueva descripción para la actividad
     */
    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    /**
     * Genera una representación en cadena de texto del objeto ActividadDTO.
     * 
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "ActividadDTO{" + "tituloActividad=" + tituloActividad + ", descripcionActividad=" + descripcionActividad + '}';
    }
}
