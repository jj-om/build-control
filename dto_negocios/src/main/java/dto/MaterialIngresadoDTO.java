/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase MaterialIngresadoDTO
 *
 * Data Transfer Object (DTO) que representa la asociación entre un recurso
 * (material o insumo) específico y la cantidad utilizada del mismo en una
 * bitácora de obra. Este DTO combina la información del recurso con el
 * componente cuantitativo para el registro diario.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class MaterialIngresadoDTO {
    
    /**
     * Información del recurso utilizado. 
     * Contiene los datos que identifican al recurso específico. 
     */
    private RecursoDTO recurso;
    
    /**
     * Cantidad del recurso utilizada.
     */
    private Integer cantidad;

    /**
     * Constructor por defecto. 
     * Inicializa una instancia de MaterialIngresadoDTO sin datos.
     */
    public MaterialIngresadoDTO() {
    }

    /**
     * Constructor parametrizado. Crea una instancia de MaterialIngresadoDTO con
     * todos sus atributos.
     *
     * @param recurso El recurso utilizado (objeto RecursoDTO)
     * @param cantidad La cantidad de unidades o medida utilizada
     */
    public MaterialIngresadoDTO(RecursoDTO recurso, Integer cantidad) {
        this.recurso = recurso;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la información del recurso.
     *
     * @return El objeto RecursoDTO con los datos del recurso
     */
    public RecursoDTO getRecurso() {
        return recurso;
    }

    /**
     * Establece la información del recurso.
     *
     * @param recurso El nuevo objeto RecursoDTO
     */
    public void setRecurso(RecursoDTO recurso) {
        this.recurso = recurso;
    }

    /**
     * Obtiene la cantidad utilizada.
     *
     * @return El número de unidades o medida del recurso empleado
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad utilizada.
     *
     * @param cantidad La nueva cantidad de recurso
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Genera una representación en cadena de texto del objeto MaterialIngresadoDTO. 
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "MaterialIngresadoDTO{" + "recurso=" + recurso + ", cantidad=" + cantidad + '}';
    }
}
