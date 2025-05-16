/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dominio_enums.UnidadBaseDatos;
import dominio_enums.UnidadPresentacionDatos;
import java.util.Objects;

/**
 *
 * @author rocha
 */
public class UnidadContenido {
    private UnidadPresentacionDatos unidad;          // Ej: "saco", "m³", "paquete"
    private UnidadBaseDatos unidadBase;      // Ej: "kg", "m³", "pieza", "L"
    private double equivalencia;    // Ej: 1 saco = 50 kg → equivalencia = 50

    public UnidadContenido() {
    }

    public UnidadContenido(UnidadPresentacionDatos unidad, UnidadBaseDatos unidadBase, double equivalencia) {
        this.unidad = unidad;
        this.unidadBase = unidadBase;
        this.equivalencia = equivalencia;
    }

    public UnidadPresentacionDatos getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadPresentacionDatos unidad) {
        this.unidad = unidad;
    }

    public UnidadBaseDatos getUnidadBase() {
        return unidadBase;
    }

    public void setUnidadBase(UnidadBaseDatos unidadBase) {
        this.unidadBase = unidadBase;
    }

    public double getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(double equivalencia) {
        this.equivalencia = equivalencia;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UnidadContenido that = (UnidadContenido) o;
        return Double.compare(that.equivalencia, equivalencia) == 0
                && unidad == that.unidad
                && unidadBase == that.unidadBase;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.unidad);
        hash = 67 * hash + Objects.hashCode(this.unidadBase);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.equivalencia) ^ (Double.doubleToLongBits(this.equivalencia) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "UnidadContenido{" + "unidad=" + unidad + ", unidadBase=" + unidadBase + ", equivalencia=" + equivalencia + '}';
    }
    
    
}
