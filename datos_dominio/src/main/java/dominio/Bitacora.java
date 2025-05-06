/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;

/**
 * Clase Bitacora
 * 
 * Clase constructora de una bitácora asociada a una obra de construcción. Esta
 * clase está diseñada para ser almacenada en una base de datos MongoDB,
 * contiene información sobre una fecha específica y la obra correspondiente.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Bitacora {
    
    /**
     * Identificador único de la bitácora (clave primaria en MongoDB).
     */
    private Long id;
    
    /**
     * Fecha en la que se registró la bitácora.
     */
    private Date fecha;
    
    /**
     * Obra a la que está asociada la bitácora.
     */
    private Long idObra;

    /**
     * Constructor vacío requerido para deserialización o frameworks como
     * MongoDB POJO codec.
     */
    public Bitacora() {
    }

    /**
     * Constructor que inicializa la fecha y la obra asociada a la bitácora.
     *
     * @param fecha Fecha del registro de la bitácora.
     * @param obra Obra a la que pertenece la bitácora.
     */
    public Bitacora(Date fecha, Long idObra) {
        this.fecha = fecha;
        this.idObra = idObra;
    }

    /**
     * Obtiene el identificador único de la bitácora.
     *
     * @return El ID de la bitácora.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la bitácora.
     *
     * @param id El ID que se asignará.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de la bitácora.
     *
     * @return La fecha registrada en la bitácora.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la bitácora.
     *
     * @param fecha La fecha a asignar.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la obra asociada a la bitácora.
     *
     * @return La obra correspondiente a esta bitácora.
     */
    public Long getIdObra() {
        return idObra;
    }

    /**
     * Establece la obra asociada a la bitácora.
     *
     * @param obra La obra a asignar.
     */
    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Bitacora.
     *
     * @return Cadena con los atributos de la bitácora.
     */
    @Override
    public String toString() {
        return "Bitacora{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", idObra=" + idObra +
                '}';
    }

}