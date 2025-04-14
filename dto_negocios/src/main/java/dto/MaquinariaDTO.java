/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase MaquinariaDTO
 *
 * Data Transfer Object (DTO) que representa una maquinaria o equipo pesado
 * utilizado en las obras de construcción. Esta clase encapsula la información
 * básica que identifica a una maquinaria específica y facilita su transporte
 * entre las diferentes capas de la aplicación.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class MaquinariaDTO {

    /**
     * Nombre o tipo de la maquinaria.
     */
    private String nombre;

    /**
     * Marca de la maquinaria.
     */
    private String marca;

    /**
     * Matrícula o número de identificación único.
     */
    private String matricula;

    /**
     * Constructor por defecto. Inicializa una instancia de MaquinariaDTO sin
     * datos.
     */
    public MaquinariaDTO() {
    }

    /**
     * Constructor parametrizado. Crea una instancia de MaquinariaDTO con todos
     * sus atributos.
     *
     * @param nombre El nombre o tipo de la maquinaria
     * @param marca La marca del equipo
     * @param matricula La matrícula o identificador único
     */
    public MaquinariaDTO(String nombre, String marca, String matricula) {
        this.nombre = nombre;
        this.marca = marca;
        this.matricula = matricula;
    }

    /**
     * Obtiene el nombre de la maquinaria.
     *
     * @return El nombre o tipo del equipo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la maquinaria.
     *
     * @param nombre El nuevo nombre para el equipo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la marca de la maquinaria.
     *
     * @return La marca del equipo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca de la maquinaria.
     *
     * @param marca La nueva marca para el equipo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la matrícula de la maquinaria.
     *
     * @return La matrícula o identificador único del equipo
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula de la maquinaria.
     *
     * @param matricula La nueva matrícula para el equipo
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Genera una representación en cadena de texto del objeto MaquinariaDTO.
     *
     * @return Una cadena representando los atributos del objeto
     */
    @Override
    public String toString() {
        return "MaquinariaDTO{" + "nombre=" + nombre + ", marca=" + marca + ", matricula=" + matricula + '}';
    }
}
