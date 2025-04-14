/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;

/**
 * Clase BitacoraDTO
 *
 * Data Transfer Object (DTO) que encapsula la información básica de la bitácora
 * de obra. Esta clase se utiliza para transportar los datos fundamentales que
 * identifican una entrada de bitácora entre las diferentes capas de la
 * aplicación.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class BitacoraDTO {

    /**
     * Fecha del registro de la bitácora.
     */
    private LocalDate fecha;

    /**
     * Identificador único de la obra asociada a esta bitácora.
     */
    private Long idObra;

    /**
     * Constructor por defecto. Inicializa una instancia de BitacoraDTO sin
     * datos.
     */
    public BitacoraDTO() {
    }

    /**
     * Constructor parametrizado. Crea una instancia de BitacoraDTO con sus dos
     * atributos.
     *
     * @param fecha Fecha del registro de bitácora
     * @param idObra Identificador de la obra asociada
     */
    public BitacoraDTO(LocalDate fecha, Long idObra) {
        this.fecha = fecha;
        this.idObra = idObra;
    }

    /**
     * Obtiene la fecha de la bitácora.
     *
     * @return La fecha del registro
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la bitácora.
     *
     * @param fecha La nueva fecha para el registro
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el identificador de la obra asociada.
     *
     * @return El identificador único de la obra
     */
    public Long getIdObra() {
        return idObra;
    }

    /**
     * Establece el identificador de la obra asociada.
     *
     * @param idObra El nuevo identificador de obra
     */
    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    /**
     * Genera una representación en cadena de texto del objeto BitacoraDTO.
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "BitacoraDTO{" + "fecha=" + fecha + ", idObra=" + idObra + '}';
    }

}
