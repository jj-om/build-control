/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;

/**
 * Clase DetallesBitacora
 * 
 * Clase constructora de los detalles de una bitácora dentro del sistema. Clase
 * que representa los detalles de una bitácora diaria de obra. Contiene
 * actividades, materiales, herramientas, maquinaria, asistencia y la bitácora
 * principal.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class DetallesBitacora {
    
    /**
     * Identificador único de la actividad (clave primaria en MongoDB).
     */
    private Long id;
    
    /**
     * Lista de actividades.
     */
    private List<Actividad> actividades;
    
    /**
     * Lista de materiales ingresados.
     */
    private List<MaterialIngresado> materialesIngresados;
    
    /**
     * Lista de herramientas ingresadas.
     */
    private List<HerramientaIngresada> herramientasIngresadas;
    
    /**
     * Lista de maquinarias.
     */
    private List<Maquinaria> maquinarias;
    
    /**
     * Objeto asistencia con asistencias individuales.
     */
    private Asistencia asistencia;
    
    /**
     * Objeto bitacora para los detalles.
     */
    private Bitacora bitacora;

    /**
     * Constructor vacío requerido para frameworks de persistencia.
     */
    public DetallesBitacora() {
    }

    /**
     * Crea un nuevo detalle de bitácora con todos sus componentes.
     *
     * @param actividades Actividades realizadas.
     * @param materialesIngresados Materiales utilizados en la jornada.
     * @param herramientasIngresadas Herramientas registradas.
     * @param maquinarias Maquinaria utilizada.
     * @param asistencia Registro de asistencia.
     * @param bitacora Bitácora principal a la que pertenece este detalle.
     */
    public DetallesBitacora(List<Actividad> actividades, List<MaterialIngresado> materialesIngresados, List<HerramientaIngresada> herramientasIngresadas, List<Maquinaria> maquinarias, Asistencia asistencia, Bitacora bitacora) {
        this.actividades = actividades;
        this.materialesIngresados = materialesIngresados;
        this.herramientasIngresadas = herramientasIngresadas;
        this.maquinarias = maquinarias;
        this.asistencia = asistencia;
        this.bitacora = bitacora;
    }

    /**
     * Obtiene el ID del detalle de bitácora.
     * 
     * @return ID del detalle.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del detalle.
     * 
     * @param id ID del detalle.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la lista de actividades.
     * 
     * @return Lista de actividades realizadas.
     */
    public List<Actividad> getActividades() {
        return actividades;
    }

    /**
     * Establece la lista de actividades.
     * 
     * @param actividades Actividades realizadas.
     */
    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    /**
     * Obtiene la lista de materiales ingresados.
     * 
     * @return Lista de materiales.
     */
    public List<MaterialIngresado> getMaterialesIngresados() {
        return materialesIngresados;
    }

    /**
     * Establece la lista de materiales ingresados.
     * 
     * @param materialesIngresados Lista de materiales.
     */
    public void setMaterialesIngresados(List<MaterialIngresado> materialesIngresados) {
        this.materialesIngresados = materialesIngresados;
    }

    /**
     * Obtiene la lista de herramientas ingresadas.
     * 
     * @return Lista de herramientas.
     */
    public List<HerramientaIngresada> getHerramientasIngresadas() {
        return herramientasIngresadas;
    }

    /**
     * Establece la lista de herramientas ingresadas.
     * 
     * @param herramientasIngresadas Lista de herramientas.
     */
    public void setHerramientasIngresadas(List<HerramientaIngresada> herramientasIngresadas) {
        this.herramientasIngresadas = herramientasIngresadas;
    }

    /**
     * Obtiene la lista de maquinaria utilizada.
     * 
     * @return Lista de maquinaria.
     */
    public List<Maquinaria> getMaquinarias() {
        return maquinarias;
    }

    /**
     * Establece la lista de maquinaria utilizada.
     * 
     * @param maquinarias Lista de maquinaria.
     */
    public void setMaquinarias(List<Maquinaria> maquinarias) {
        this.maquinarias = maquinarias;
    }

    /**
     * Obtiene el registro de asistencia.
     * 
     * @return Registro de {@link Asistencia}.
     */
    public Asistencia getAsistencia() {
        return asistencia;
    }

    /**
     * Establece el registro de asistencia.
     * 
     * @param asistencia Registro de asistencia.
     */
    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    /**
     * Obtiene la bitácora principal.
     * 
     * @return Bitácora a la que pertenece.
     */
    public Bitacora getBitacora() {
        return bitacora;
    }

    /**
     * Establece la bitácora principal.
     * 
     * @param bitacora Bitácora a establecer.
     */
    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    /**
     * Devuelve una representación en forma de cadena de DetallesBitacora.
     *
     * @return Cadena con los atributos de los detalles de una bitácora..
     */
    @Override
    public String toString() {
        return "DetallesBitacora{" +
                "id=" + id +
                ", actividades=" + actividades +
                ", materialesIngresados=" + materialesIngresados +
                ", herramientasIngresadas=" + herramientasIngresadas +
                ", maquinarias=" + maquinarias +
                ", asistencia=" + asistencia +
                ", bitacora=" + bitacora +
                '}';
    }

}