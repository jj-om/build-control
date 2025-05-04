/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author Ximena
 */
public class HerramientaIngresada {
    @BsonId
    private ObjectId id;
    private Herramienta herramienta;
    private Integer cantidad;

    public HerramientaIngresada() {
    }

    public HerramientaIngresada(Herramienta herramienta, Integer cantidad) {
        this.herramienta = herramienta;
        this.cantidad = cantidad;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "HerramientaIngresada{" + "id=" + id + ", herramienta=" + herramienta + ", cantidad=" + cantidad + '}';
    }

}