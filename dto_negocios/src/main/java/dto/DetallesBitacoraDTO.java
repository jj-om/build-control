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
    private List<MaquinariaDTO> maquinarias;
    private List<ActividadDTO> actividades;
    private BitacoraDTO bitacora;

    public DetallesBitacoraDTO() {
    }

    public DetallesBitacoraDTO(ListaAsistenciaDTO listaAsistencia, List<MaterialIngresadoDTO> materialesIngresados, List<HerramientaIngresadaDTO> herramientasIngresadas, List<MaquinariaDTO> maquinarias, List<ActividadDTO> actividades, BitacoraDTO bitacora) {
        this.listaAsistencia = listaAsistencia;
        this.materialesIngresados = materialesIngresados;
        this.herramientasIngresadas = herramientasIngresadas;
        this.maquinarias = maquinarias;
        this.actividades = actividades;
        this.bitacora = bitacora;
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

    public List<MaquinariaDTO> getMaquinarias() {
        return maquinarias;
    }

    public void setMaquinarias(List<MaquinariaDTO> maquinarias) {
        this.maquinarias = maquinarias;
    }

    public List<ActividadDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        return "DetallesBitacoraDTO{" + "listaAsistencia=" + listaAsistencia + ", materialesIngresados=" + materialesIngresados + ", herramientasIngresadas=" + herramientasIngresadas + ", maquinarias=" + maquinarias + ", actividades=" + actividades + ", bitacora=" + bitacora + '}';
    } 
}
