/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author Ximena
 */
public class Asistencia {
    @BsonId
    private ObjectId id;
    private Date fecha;
    private List<AsistenciaPersonal> asistenciaPersonal;

    public Asistencia() {
    }

    public Asistencia(Date fecha, List<AsistenciaPersonal> asistenciaPersonal) {
        this.fecha = fecha;
        this.asistenciaPersonal = asistenciaPersonal;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<AsistenciaPersonal> getAsistenciaPersonal() {
        return asistenciaPersonal;
    }

    public void setAsistenciaPersonal(List<AsistenciaPersonal> asistenciaPersonal) {
        this.asistenciaPersonal = asistenciaPersonal;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "id=" + id + ", fecha=" + fecha + ", asistenciaPersonal=" + asistenciaPersonal + '}';
    }

}