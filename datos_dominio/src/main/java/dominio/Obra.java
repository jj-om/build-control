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
public class Obra {
    @BsonId
    private ObjectId idObra;
    private Long numero;
    private String direccion;
    private Double metrosCubicos;

    public Obra() {
    }

    public Obra(Long numero, String direccion, Double metrosCubicos) {
        this.numero = numero;
        this.direccion = direccion;
        this.metrosCubicos = metrosCubicos;
    }

    public ObjectId getIdObra() {
        return idObra;
    }

    public void setIdObra(ObjectId idObra) {
        this.idObra = idObra;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getMetrosCubicos() {
        return metrosCubicos;
    }

    public void setMetrosCubicos(Double metrosCubicos) {
        this.metrosCubicos = metrosCubicos;
    }

    @Override
    public String toString() {
        return "Obra{" + "idObra=" + idObra + ", numero=" + numero + ", direccion=" + direccion + ", metrosCubicos=" + metrosCubicos + '}';
    }

}