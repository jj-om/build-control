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
public class Maquinaria {
    @BsonId
    private ObjectId id;
    private String nombre;
    private String marca;
    private String matricula;

    public Maquinaria() {
    }

    public Maquinaria(String nombre, String marca, String matricula) {
        this.nombre = nombre;
        this.marca = marca;
        this.matricula = matricula;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Maquinaria{" + "id" + id + ", nombre=" + nombre + ", marca=" + marca + ", matricula=" + matricula + '}';
    }

}