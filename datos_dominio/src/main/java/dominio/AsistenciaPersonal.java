/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author Ximena
 */
public class AsistenciaPersonal {
    @BsonId
    private ObjectId id;
    private String nombreEmpleado;
    private Date horaEntrada;
    private Date horaSalida;
    private String notas;

    public AsistenciaPersonal() {
    }

    public AsistenciaPersonal(String nombreEmpleado, Date horaEntrada, Date horaSalida, String notas) {
        this.nombreEmpleado = nombreEmpleado;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.notas = notas;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "AsistenciaPersonal{" + "id=" + id + ", nombreEmpleado=" + nombreEmpleado + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", notas=" + notas + '}';
    }

}