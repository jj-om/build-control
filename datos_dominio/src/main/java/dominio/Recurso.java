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
public class Recurso {
    @BsonId
    private ObjectId id;
    private Material material;
    private Integer cantidad;
    private Obra obra;

    public Recurso() {
    }

    public Recurso(Material material, Integer cantidad, Obra obra) {
        this.material = material;
        this.cantidad = cantidad;
        this.obra = obra;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    @Override
    public String toString() {
        return "Recurso{" + "id=" + id + ", material=" + material + ", cantidad=" + cantidad + ", obra=" + obra + '}';
    }
 
}