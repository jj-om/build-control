/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Clase HerramientaIngresada
 * 
 * Clase constructora de un objeto herramientaIngresada dentro del sistema.
 * Clase que representa un ingreso de herramientas a la obra, contiene
 * información como una herramienta y la cantidad ingresada.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class HerramientaIngresada {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    @BsonId
    private ObjectId id;
    
    /**
     * Herramienta a la que pertenece el ingreso.
     */
    private Herramienta herramienta;
    
    /**
     * Cantidad de herramienta que fue ingresada.
     */
    private Integer cantidad;

    /**
     * Constructor vacío requerido para frameworks de persistencia.
     */
    public HerramientaIngresada() {
    }

    /**
     * Crea un nuevo ingreso de herramienta.
     *
     * @param herramienta Herramienta ingresada.
     * @param cantidad Cantidad ingresada.
     */
    public HerramientaIngresada(Herramienta herramienta, Integer cantidad) {
        this.herramienta = herramienta;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el ID del registro de herramienta ingresada.
     *
     * @return El identificador.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del registro de herramienta ingresada.
     *
     * @param id El nuevo identificador.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene la herramienta asociada a este ingreso.
     *
     * @return La herramienta ingresada.
     */
    public Herramienta getHerramienta() {
        return herramienta;
    }

    /**
     * Establece la herramienta para este ingreso.
     *
     * @param herramienta La nueva herramienta.
     */
    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    /**
     * Obtiene la cantidad de herramientas ingresadas.
     *
     * @return La cantidad ingresada.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de herramientas ingresadas.
     *
     * @param cantidad La nueva cantidad.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve una representación en forma de cadena de HerramientaIngresada.
     *
     * @return Cadena con los atributos de la herramienta ingresada.
     */
    @Override
    public String toString() {
        return "HerramientaIngresada{" +
                "id=" + id +
                ", herramienta=" + herramienta +
                ", cantidad=" + cantidad +
                '}';
    }

}