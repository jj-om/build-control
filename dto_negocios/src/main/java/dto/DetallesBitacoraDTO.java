/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 *
 * @author dario
 */
public class DetallesBitacoraDTO {
    private ListaAsistenciaDTO listaAsistencia;
    private List<MaterialIngresadoDTO> materialesIngresados;
    private List<HerramientaIngresadaDTO> herramientasIngresadas;
    private List<ActividadDTO> actividades;
    private BitacoraDTO bitacora;

    public DetallesBitacoraDTO() {
    }

    public DetallesBitacoraDTO(ListaAsistenciaDTO listaAsistencia, List<MaterialIngresadoDTO> materialesIngresados, List<HerramientaIngresadaDTO> herramientasIngresadas, List<ActividadDTO> actividades) {
        this.listaAsistencia = listaAsistencia;
        this.materialesIngresados = materialesIngresados;
        this.herramientasIngresadas = herramientasIngresadas;
        this.actividades = actividades;
        this.bitacora = null;
    }

    public BitacoraDTO getBitacora() {
        return bitacora;
    }

    public void setBitacora(BitacoraDTO bitacora) {
        this.bitacora = bitacora;
    }

    public ListaAsistenciaDTO getListaAsistencia() {
        return listaAsistencia;
    }

    public void setListaAsistencia(ListaAsistenciaDTO listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    public List<MaterialIngresadoDTO> getMaterialesIngresados() {
        return materialesIngresados;
    }

    public void setMaterialesIngresados(List<MaterialIngresadoDTO> materialesIngresados) {
        this.materialesIngresados = materialesIngresados;
    }

    public List<HerramientaIngresadaDTO> getHerramientasIngresadas() {
        return herramientasIngresadas;
    }

    public void setHerramientasIngresadas(List<HerramientaIngresadaDTO> herramientasIngresadas) {
        this.herramientasIngresadas = herramientasIngresadas;
    }

    public List<ActividadDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }
    
    
    
            
            
}
