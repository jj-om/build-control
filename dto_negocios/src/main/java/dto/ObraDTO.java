package dto;

/**
 * Clase ObraDTO
 *
 * Data Transfer Object (DTO) que representa un proyecto de construcción u obra. 
 * Esta clase encapsula la información básica que identifica y caracteriza a una obra específica, 
 * facilitando su transporte entre las diferentes capas de la aplicación.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class ObraDTO {

    /**
     * Identificador único de la obra. 
     */
    private Long numero;
    
    /**
     * Dirección física donde se ubica la obra. 
     */
    private String direccion;
    
    /**
     * Volumen de construcción en metros cúbicos. 
     */
    private Double metrosCubicos;

    /**
     * Constructor por defecto. 
     * Inicializa una instancia de ObraDTO sin datos.
     */
    public ObraDTO() {
    }
    
    /**
     * Constructor parametrizado completo. Crea una instancia de ObraDTO con
     * todos sus atributos.
     *
     * @param idObra El identificador único de la obra
     * @param direccion La dirección física de la obra
     * @param metrosCubicos El volumen en metros cúbicos
     */
    public ObraDTO(Long idObra, String direccion, Double metrosCubicos) {
        this.numero = idObra;
        this.direccion = direccion;
        this.metrosCubicos = metrosCubicos;
    }
    
    /**
     * Constructor parametrizado sin identificador. 
     *
     * @param direccion La dirección física de la obra
     * @param metrosCubicos El volumen en metros cúbicos
     */
    public ObraDTO(String direccion, Double metrosCubicos) {
        this.direccion = direccion;
        this.metrosCubicos = metrosCubicos;
    }

    /**
     * Obtiene el identificador de la obra.
     *
     * @return El ID único de la obra
     */
    public Long getNumero() {
        return numero;
    }

    /**
     * Establece el identificador de la obra.
     *
     * @param numero El nuevo ID para la obra
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la dirección de la obra.
     *
     * @return La dirección física donde se ubica
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la obra.
     *
     * @param direccion La nueva dirección para la obra
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el volumen de la obra en metros cúbicos.
     *
     * @return El tamaño de la obra en metros cúbicos
     */
    public Double getMetrosCubicos() {
        return metrosCubicos;
    }
    
    /**
     * Establece el volumen de la obra en metros cúbicos.
     *
     * @param metrosCubicos El nuevo volumen para la obra
     */
    public void setMetrosCubicos(Double metrosCubicos) {
        this.metrosCubicos = metrosCubicos;
    }

    /**
     * Genera una representación en cadena de texto del objeto ObraDTO.
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "ObraDTO{" + "idObra=" + numero + ", direccion=" + direccion + ", metrosCubicos=" + metrosCubicos + '}';
    }
    
}
