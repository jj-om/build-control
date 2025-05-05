/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Clase MaterialIngresado 
 * 
 * Clase constructora de un objeto materialIngresado dentro del sistema. Esta
 * clase representa un registro de materiales que han sido ingresados a una
 * obra, contiene el recurso (material y obra) y la cantidad efectivamente 
 * ingresada.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class MaterialIngresado {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    @BsonId
    private ObjectId id;
    
    /**
     * Recurso al que pertenece el ingreso.
     */
    private Recurso recurso;
    
    /**
     * Cantidad de material que fue ingresada.
     */
    private Integer cantidad;

    /**
     * Constructor vacío requerido para frameworks de persistencia.
     */
    public MaterialIngresado() {
    }

    /**
     * Constructor que inicializa el recurso y la cantidad ingresada.
     *
     * @param recurso Recurso (material y obra) al que corresponde el ingreso.
     * @param cantidad Cantidad de material ingresado.
     */
    public MaterialIngresado(Recurso recurso, Integer cantidad) {
        this.recurso = recurso;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el ID del material ingresado.
     *
     * @return El identificador único del material ingresado.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del material ingresado.
     *
     * @param id El nuevo identificador del material ingresado.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el recurso relacionado con este ingreso.
     *
     * @return El recurso correspondiente.
     */
    public Recurso getRecurso() {
        return recurso;
    }

    /**
     * Establece el recurso para este ingreso.
     *
     * @param recurso El nuevo recurso.
     */
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    /**
     * Obtiene la cantidad de material ingresada.
     *
     * @return La cantidad ingresada.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de material ingresada.
     *
     * @param cantidad La nueva cantidad.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve una representación en forma de cadena de MaterialIngresado.
     *
     * @return Cadena con los atributos del material ingresado.
     */
    @Override
    public String toString() {
        return "MaterialIngresado{" + 
                "id=" + id +
                ", recurso=" + recurso +
                ", cantidad=" + cantidad +
                '}';
    }

}