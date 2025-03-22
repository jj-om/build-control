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
public class BitacoraDTO {
    private String titulo;
    private List<ListaAsistenciaDTO> listaAsistencias;
    private List<MaterialIngresadoDTO> materialesIngresados;
    private List<HerramientaIngresadaDTO> herramientasIngresadas;
    private List<ActividadDTO> actividades;

    public BitacoraDTO() {
    }

    public BitacoraDTO(String titulo, List<ListaAsistenciaDTO> listaAsistencias, List<MaterialIngresadoDTO> materialesIngresados, List<HerramientaIngresadaDTO> herramientasIngresadas, List<ActividadDTO> actividades) {
        this.titulo = titulo;
        this.listaAsistencias = listaAsistencias;
        this.materialesIngresados = materialesIngresados;
        this.herramientasIngresadas = herramientasIngresadas;
        this.actividades = actividades;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<ListaAsistenciaDTO> getListaAsistencias() {
        return listaAsistencias;
    }

    public void setListaAsistencias(List<ListaAsistenciaDTO> listaAsistencias) {
        this.listaAsistencias = listaAsistencias;
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
