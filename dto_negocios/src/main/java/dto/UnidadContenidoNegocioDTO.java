/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import negocio_enums.UnidadBaseNegocio;
import negocio_enums.UnidadPresentacionNegocio;

/**
 *
 * @author rocha
 */
public class UnidadContenidoNegocioDTO {
    private UnidadPresentacionNegocio unidad;          // Ej: "saco", "m³", "paquete"
    private UnidadBaseNegocio unidadBase;      // Ej: "kg", "m³", "pieza", "L"
    private double equivalencia;

    public UnidadContenidoNegocioDTO() {
    }

    public UnidadContenidoNegocioDTO(UnidadPresentacionNegocio unidad, UnidadBaseNegocio unidadBase, double equivalencia) {
        this.unidad = unidad;
        this.unidadBase = unidadBase;
        this.equivalencia = equivalencia;
    }

    public UnidadPresentacionNegocio getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadPresentacionNegocio unidad) {
        this.unidad = unidad;
    }

    public UnidadBaseNegocio getUnidadBase() {
        return unidadBase;
    }

    public void setUnidadBase(UnidadBaseNegocio unidadBase) {
        this.unidadBase = unidadBase;
    }

    public double getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(double equivalencia) {
        this.equivalencia = equivalencia;
    }

    @Override
    public String toString() {
        return "UnidadContenidoNegocioDTO{" + "unidad=" + unidad + ", unidadBase=" + unidadBase + ", equivalencia=" + equivalencia + '}';
    }
    
    
}
