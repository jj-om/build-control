/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 * Clase DetallesBitacoraDTO
 *
 * Data Transfer Object (DTO) que consolida todos los elementos componentes de
 * una bitácora de obra completa. Actúa como contenedor principal que agrupa 
 * todos los registros relacionados con la bitácora diaria.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class DetallesBitacoraDTO {
    
    /**
     * Lista de asistencia del personal para esta bitácora. 
     */
    private ListaAsistenciaDTO listaAsistencia;
    
    /**
     * Lista de materiales utilizados en la obra para este día. 
     */
    private List<MaterialIngresadoDTO> materialesIngresados;
    
    /**
     * Lista de herramientas utilizadas en la obra para este día. 
     */
    private List<HerramientaIngresadaDTO> herramientasIngresadas;
    
    /**
     * Lista de maquinaria utilizada en la obra para este día. 
     */
    private List<MaquinariaDTO> maquinarias;
    
    /**
     * Lista de actividades realizadas durante el día. 
     */
    private List<ActividadDTO> actividades;
    
    /**
     * Información básica de la bitácora. 
     * Contiene los datos fundamentales como fecha y obra asociada.
     */
    private BitacoraDTO bitacora;

    /**
     * Constructor por defecto. 
     * Inicializa una instancia de DetallesBitacoraDTO sin datos.
     */
    public DetallesBitacoraDTO() {
    }

    /**
     * Constructor parametrizado. Crea una instancia de DetallesBitacoraDTO con todos sus atributos.
     *
     * @param listaAsistencia Lista de asistencia del personal
     * @param materialesIngresados Lista de materiales utilizados
     * @param herramientasIngresadas Lista de herramientas empleadas
     * @param maquinarias Lista de maquinaria utilizada
     * @param actividades Lista de actividades realizadas
     * @param bitacora Información básica de la bitácora
     */
    public DetallesBitacoraDTO(ListaAsistenciaDTO listaAsistencia, List<MaterialIngresadoDTO> materialesIngresados, List<HerramientaIngresadaDTO> herramientasIngresadas, List<MaquinariaDTO> maquinarias, List<ActividadDTO> actividades, BitacoraDTO bitacora) {
        this.listaAsistencia = listaAsistencia;
        this.materialesIngresados = materialesIngresados;
        this.herramientasIngresadas = herramientasIngresadas;
        this.maquinarias = maquinarias;
        this.actividades = actividades;
        this.bitacora = bitacora;
    }

    /**
     * Obtiene la información básica de la bitácora.
     *
     * @return El objeto BitacoraDTO con los datos fundamentales
     */
    public BitacoraDTO getBitacora() {
        return bitacora;
    }

    /**
     * Establece la información básica de la bitácora.
     *
     * @param bitacora El nuevo objeto BitacoraDTO
     */
    public void setBitacora(BitacoraDTO bitacora) {
        this.bitacora = bitacora;
    }

    /**
     * Obtiene la lista de asistencia del personal.
     *
     * @return El objeto ListaAsistenciaDTO con los registros de asistencia
     */
    public ListaAsistenciaDTO getListaAsistencia() {
        return listaAsistencia;
    }

    /**
     * Establece la lista de asistencia del personal.
     *
     * @param listaAsistencia La nueva lista de asistencia
     */
    public void setListaAsistencia(ListaAsistenciaDTO listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    /**
     * Obtiene la lista de materiales utilizados.
     *
     * @return Lista de MaterialIngresadoDTO con los materiales registrados
     */
    public List<MaterialIngresadoDTO> getMaterialesIngresados() {
        return materialesIngresados;
    }

    /**
     * Establece la lista de materiales utilizados.
     *
     * @param materialesIngresados La nueva lista de materiales
     */
    public void setMaterialesIngresados(List<MaterialIngresadoDTO> materialesIngresados) {
        this.materialesIngresados = materialesIngresados;
    }

    /**
     * Obtiene la lista de herramientas empleadas.
     *
     * @return Lista de HerramientaIngresadaDTO con las herramientas registradas
     */
    public List<HerramientaIngresadaDTO> getHerramientasIngresadas() {
        return herramientasIngresadas;
    }

    /**
     * Establece la lista de herramientas empleadas.
     *
     * @param herramientasIngresadas La nueva lista de herramientas
     */
    public void setHerramientasIngresadas(List<HerramientaIngresadaDTO> herramientasIngresadas) {
        this.herramientasIngresadas = herramientasIngresadas;
    }

    /**
     * Obtiene la lista de maquinaria utilizada.
     *
     * @return Lista de MaquinariaDTO con la maquinaria registrada
     */
    public List<MaquinariaDTO> getMaquinarias() {
        return maquinarias;
    }

    /**
     * Establece la lista de maquinaria utilizada.
     *
     * @param maquinarias La nueva lista de maquinaria
     */
    public void setMaquinarias(List<MaquinariaDTO> maquinarias) {
        this.maquinarias = maquinarias;
    }

    /**
     * Obtiene la lista de actividades realizadas.
     *
     * @return Lista de ActividadDTO con las actividades registradas
     */
    public List<ActividadDTO> getActividades() {
        return actividades;
    }

    /**
     * Establece la lista de actividades realizadas.
     *
     * @param actividades La nueva lista de actividades
     */
    public void setActividades(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }

    /**
     * Genera una representación en cadena de texto del objeto DetallesBitacoraDTO. 
     *
     * @return Una cadena representando todos los componentes de la bitácora
     */
    @Override
    public String toString() {
        return "DetallesBitacoraDTO{" + "listaAsistencia=" + listaAsistencia + ", materialesIngresados=" + materialesIngresados + ", herramientasIngresadas=" + herramientasIngresadas + ", maquinarias=" + maquinarias + ", actividades=" + actividades + ", bitacora=" + bitacora + '}';
    } 
}
