package dto;

/**
 * @author Jesús Osuna 240549
 */

public class ObraDTO {

    private Long idObra;
    private String direccion;
    private Long metrosCubicos;

    public ObraDTO() {
        
    }
    
    public ObraDTO(Long idObra, String direccion, Long metrosCubicos) {
        this.idObra = idObra;
        this.direccion = direccion;
        this.metrosCubicos = metrosCubicos;
    }

    public ObraDTO(String direccion, Long metrosCubicos) {
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

    public Long getMetrosCubicos() {
        return metrosCubicos;
    }

    public void setMetrosCubicos(Long metrosCubicos) {
        this.metrosCubicos = metrosCubicos;
    }

    @Override
    public String toString() {
        return "ObraDTO{" + "idObra=" + idObra + ", direccion=" + direccion + ", metrosCubicos=" + metrosCubicos + '}';
    }
    
}
