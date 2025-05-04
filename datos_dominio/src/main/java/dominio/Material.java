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
public class Material {
    @BsonId
    private ObjectId id;
    private String nombre;
    private Float peso;
    private String marca;
    private String unidadPeso;

    public Material() {
    }

    public Material(String nombre, Float peso, String marca, String unidadPeso) {
        this.nombre = nombre;
        this.peso = peso;
        this.marca = marca;
        this.unidadPeso = unidadPeso;
    }

    public ObjectId getId() {
        return id;
    }

    public void setIdMaterial(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidadPeso() {
        return unidadPeso;
    }

    public void setUnidadPeso(String unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", nombre=" + nombre + ", peso=" + peso + ", marca=" + marca + ", unidadPeso=" + unidadPeso + '}';
    }
 
}