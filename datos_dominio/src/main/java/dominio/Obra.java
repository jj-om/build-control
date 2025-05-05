/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Clase Obra
 * 
 * Clase constructora de una obra de construcción o proyecto. Esta clase está
 * diseñada para ser almacenada en una base de datos MongoDB, contiene
 * información como su identificador, número, dirección y volumen total de
 * metros cúbicos.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Obra {
    
    /**
     * Identificador único de la obra (clave primaria en MongoDB).
     */
    @BsonId
    private ObjectId idObra;
    
    /**
     * Número de la obra.
     */
    private Long numero;
    
    /**
     * Dirección física donde se localiza la obra.
     */
    private String direccion;
    
    /**
     * Cantidad total de metros cúbicos asignados a la obra.
     */
    private Double metrosCubicos;

    /**
     * Constructor vacío requerido para la deserialización y frameworks
     * como MongoDB POJO codec.
     */
    public Obra() {
    }

    /**
     * Constructor que inicializa los atributos principales de la obra.
     *
     * @param numero Número de la obra.
     * @param direccion Dirección física de la obra.
     * @param metrosCubicos Volumen en metros cúbicos asignado a la obra.
     */
    public Obra(Long numero, String direccion, Double metrosCubicos) {
        this.numero = numero;
        this.direccion = direccion;
        this.metrosCubicos = metrosCubicos;
    }

    /**
     * Obtiene el identificador único de la obra.
     *
     * @return El {@code ObjectId} de la obra.
     */
    public ObjectId getIdObra() {
        return idObra;
    }

    /**
     * Establece el identificador único de la obra.
     *
     * @param idObra El {@code ObjectId} que se asignará.
     */
    public void setIdObra(ObjectId idObra) {
        this.idObra = idObra;
    }

    /**
     * Obtiene el número de la obra.
     *
     * @return El número de la obra.
     */
    public Long getNumero() {
        return numero;
    }

    /**
     * Establece el número de la obra.
     *
     * @param numero El número a asignar.
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la dirección de la obra.
     *
     * @return La dirección de la obra.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la obra.
     *
     * @param direccion La dirección a asignar.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el volumen de metros cúbicos de la obra.
     *
     * @return Metros cúbicos de la obra.
     */
    public double getMetrosCubicos() {
        return metrosCubicos;
    }

    /**
     * Establece el volumen de metros cúbicos de la obra.
     *
     * @param metrosCubicos Metros cúbicos a asignar.
     */
    public void setMetrosCubicos(Double metrosCubicos) {
        this.metrosCubicos = metrosCubicos;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Obra.
     *
     * @return Cadena con los atributos de la obra.
     */
    @Override
    public String toString() {
        return "Obra{" +
                "idObra=" + idObra + 
                ", numero=" + numero +
                ", direccion=" + direccion + 
                ", metrosCubicos=" + metrosCubicos + 
                '}';
    }

}