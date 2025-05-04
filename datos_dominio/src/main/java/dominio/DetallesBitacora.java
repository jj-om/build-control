/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author Ximena
 */
public class DetallesBitacora {
    @BsonId
    private ObjectId id;
    private List<Actividad> actividades;
    private List<MaterialIngresado> materialesIngresados;
    private List<HerramientaIngresada> herramientasIngresadas;
    private List<Maquinaria> maquinarias;
    private Asistencia asistencia;
    private Bitacora bitacora;

    public DetallesBitacora() {
    }

    public DetallesBitacora(List<Actividad> actividades, List<MaterialIngresado> materialesIngresados, List<HerramientaIngresada> herramientasIngresadas, List<Maquinaria> maquinarias, Asistencia asistencia, Bitacora bitacora) {
        this.actividades = actividades;
        this.materialesIngresados = materialesIngresados;
        this.herramientasIngresadas = herramientasIngresadas;
        this.maquinarias = maquinarias;
        this.asistencia = asistencia;
        this.bitacora = bitacora;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<MaterialIngresado> getMaterialesIngresados() {
        return materialesIngresados;
    }

    public void setMaterialesIngresados(List<MaterialIngresado> materialesIngresados) {
        this.materialesIngresados = materialesIngresados;
    }

    public List<HerramientaIngresada> getHerramientasIngresadas() {
        return herramientasIngresadas;
    }

    public void setHerramientasIngresadas(List<HerramientaIngresada> herramientasIngresadas) {
        this.herramientasIngresadas = herramientasIngresadas;
    }

    public List<Maquinaria> getMaquinarias() {
        return maquinarias;
    }

    public void setMaquinarias(List<Maquinaria> maquinarias) {
        this.maquinarias = maquinarias;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    @Override
    public String toString() {
        return "DetallesBitacora{" + "id=" + id + ", actividades=" + actividades + ", materialesIngresados=" + materialesIngresados + ", herramientasIngresadas=" + herramientasIngresadas + ", maquinarias=" + maquinarias + ", asistencia=" + asistencia + ", bitacora=" + bitacora + '}';
    }

}