/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Clase Atividad
 * 
 * Clase constructora de una actividad dentro del sistema. Esta clase está
 * diseñada para ser almacenada en una base de datos MongoDB, cada actividad
 * contiene un título y una descripción.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Actividad {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    @BsonId
    private ObjectId id;
    
    /**
     * Título o nombre breve que describe la actividad.
     */
    private String titulo;
    
    /**
     * Descripción detallada de la actividad.
     */
    private String descripcion;

    /**
     * Constructor vacío requerido para deserialización o frameworks como
     * MongoDB POJO codec.
     */
    public Actividad() {
    }

    /**
     * Constructor que inicializa el título y la descripción de la actividad.
     *
     * @param titulo Título de la actividad.
     * @param descripcion Descripción detallada de la actividad.
     */
    public Actividad(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador único de la actividad.
     *
     * @return El {@code ObjectId} de la actividad.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la actividad.
     *
     * @param id El {@code ObjectId} que se asignará.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el título de la actividad.
     *
     * @return El título de la actividad.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la actividad.
     *
     * @param titulo El título a asignar.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción de la actividad.
     *
     * @return La descripción de la actividad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la actividad.
     *
     * @param descripcion La descripción a asignar.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Actividad.
     *
     * @return Cadena con los atributos de la actividad.
     */
    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", titulo=" + titulo +
                ", descripcion=" + descripcion +
                '}';
    }
 
}