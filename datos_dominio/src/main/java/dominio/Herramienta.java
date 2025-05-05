/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 * Clase Herramienta
 * 
 * Clase constructora de una herramienta dentro del sistema. Clase que
 * representa una herramienta utilizada en la obra, contiene información como
 * nombre, marca y modelo.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Herramienta {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    private Long id;
    
    /**
     * Nombre de la herramienta.
     */
    private String nombre;
    
    /**
     * Marca de la herramienta.
     */
    private String marca;
    
    /**
     * Modelo de la herramienta.
     */
    private String modelo;

    /**
     * Constructor vacío requerido para frameworks de persistencia.
     */
    public Herramienta() {
    }

    /**
     * Crea una nueva herramienta con los datos proporcionados.
     *
     * @param nombre Nombre de la herramienta.
     * @param marca Marca de la herramienta.
     * @param modelo Modelo de la herramienta.
     */
    public Herramienta(String nombre, String marca, String modelo) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Obtiene el ID de la herramienta.
     *
     * @return El identificador único de la herramienta.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la herramienta.
     *
     * @param id El nuevo identificador de la herramienta.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la herramienta.
     *
     * @return El nombre de la herramienta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la herramienta.
     *
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la marca de la herramienta.
     *
     * @return La marca de la herramienta.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca de la herramienta.
     *
     * @param marca La nueva marca.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo de la herramienta.
     *
     * @return El modelo de la herramienta.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo de la herramienta.
     *
     * @param modelo El nuevo modelo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Herramienta.
     *
     * @return Cadena con los atributos de la herramienta.
     */
    @Override
    public String toString() {
        return "Herramienta{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", marca=" + marca +
                ", modelo=" + modelo +
                '}';
    }
  
}