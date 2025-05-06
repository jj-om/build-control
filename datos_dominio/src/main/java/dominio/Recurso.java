/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 * Clase Recurso 
 * 
 * Clase constructora de un recurso dentro del sistema. Esta clase representa un
 * recurso necesario para una obra, compuesto por un material, una cantidad y
 * una obra asociada.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Recurso {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    private Long id;
    
    /**
     * Material utilizado como parte del recurso.
     */
    private Material material;
    
    /**
     * Cantidad del material requerida.
     */
    private Integer cantidad;
    
    /**
     * Obra en la cual se utilizará el recurso.
     */
    private Long idObra;

    /**
     * Constructor vacío para fines de deserialización.
     */
    public Recurso() {
    }

    /**
     * Constructor que inicializa el material, cantidad y obra del recurso.
     *
     * @param material Material del recurso.
     * @param cantidad Cantidad requerida del material.
     * @param obra Obra asociada al recurso.
     */
    public Recurso(Material material, Integer cantidad, Long idObra) {
        this.material = material;
        this.cantidad = cantidad;
        this.idObra = idObra;
    }

    /**
     * Obtiene el ID del recurso.
     *
     * @return El identificador único del recurso.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del recurso.
     *
     * @param id El nuevo identificador del recurso.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el material del recurso.
     *
     * @return El material utilizado.
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Establece el material del recurso.
     *
     * @param material El nuevo material.
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Obtiene la cantidad del material requerido.
     *
     * @return La cantidad de material.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de material requerida.
     *
     * @param cantidad La nueva cantidad.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la obra asociada al recurso.
     *
     * @return La obra correspondiente.
     */
    public Long getIdObra() {
        return idObra;
    }

    /**
     * Establece la obra asociada al recurso.
     *
     * @param obra La nueva obra.
     */
    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Recurso.
     *
     * @return Cadena con los atributos del recurso.
     */
    @Override
    public String toString() {
        return "Recurso{" +
                "id=" + id +
                ", material=" + material + 
                ", cantidad=" + cantidad +
                ", idObra=" + idObra +
                '}';
    }
 
}