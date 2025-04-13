package dto;

/**
 * @author Jesús Osuna 240549
 */

public class ObraDTO {

    private Long idObra;
    private String direccion;
    private Double metrosCubicos;

    public ObraDTO() {
        
    }
    
    public ObraDTO(Long idObra, String direccion, Double metrosCubicos) {
        this.idObra = idObra;
        this.direccion = direccion;
        this.metrosCubicos = metrosCubicos;
    }

    public ObraDTO(String direccion, Double metrosCubicos) {
        this.direccion = direccion;
        this.metrosCubicos = metrosCubicos;
    }

    public Long getIdObra() {
        return idObra;
    }

    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getMetrosCubicos() {
        return metrosCubicos;
    }

    public void setMetrosCubicos(Double metrosCubicos) {
        this.metrosCubicos = metrosCubicos;
    }

    @Override
    public String toString() {
        return "ObraDTO{" + "idObra=" + idObra + ", direccion=" + direccion + ", metrosCubicos=" + metrosCubicos + '}';
    }
    
}
