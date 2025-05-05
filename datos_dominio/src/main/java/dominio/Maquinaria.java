/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Clase Maquinaria
 * 
 * Clase constructora de una maquinaria dentro del sistema. Clase que representa
 * una maquinaria utilizada en la obra, contiene información sobre el nombre,
 * marca y matrícula de la máquina.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Maquinaria {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    @BsonId
    private ObjectId id;
    
    /**
     * Nombre de la maquinaria.
     */
    private String nombre;
    
    /**
     * Marca de la maquinaria.
     */
    private String marca;
    
    /**
     * Matrícula de la maquinaria.
     */
    private String matricula;

    /**
     * Constructor vacío requerido para frameworks de persistencia.
     */
    public Maquinaria() {
    }

    /**
     * Crea una nueva maquinaria con los datos especificados.
     *
     * @param nombre Nombre de la maquinaria.
     * @param marca Marca de la maquinaria.
     * @param matricula Matrícula de la maquinaria.
     */
    public Maquinaria(String nombre, String marca, String matricula) {
        this.nombre = nombre;
        this.marca = marca;
        this.matricula = matricula;
    }

    /**
     * Obtiene el ID de la maquinaria.
     *
     * @return El identificador de la maquinaria.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID de la maquinaria.
     *
     * @param id El nuevo identificador.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la maquinaria.
     *
     * @return El nombre de la maquinaria.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la maquinaria.
     *
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la marca de la maquinaria.
     *
     * @return La marca de la maquinaria.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca de la maquinaria.
     *
     * @param marca La nueva marca.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la matrícula de la maquinaria.
     *
     * @return La matrícula de la maquinaria.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula de la maquinaria.
     *
     * @param matricula La nueva matrícula.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Maquinaria.
     *
     * @return Cadena con los atributos de la maquinaria.
     */
    @Override
    public String toString() {
        return "Maquinaria{" +
                "id" + id +
                ", nombre=" + nombre +
                ", marca=" + marca +
                ", matricula=" + matricula +
                '}';
    }

}