/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdmHerramientasYMaquinaria;

import dto.HerramientaDTO;
import dto.HerramientaIngresadaDTO;
import dto.MaquinariaDTO;
import excepciones.AdmHerramientasyMaquinariaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dario
 */
public class FAdmHerramientasYMaquinaria implements IAdmHerramientasYMaquinaria {
    
    public FAdmHerramientasYMaquinaria() {
    }

    @Override
    public boolean registrarHerramientas(List<HerramientaIngresadaDTO> herramientasIngresadas) throws AdmHerramientasyMaquinariaException {
        return true; // Mock: siempre retorna true
    }

    @Override
    public boolean registrarMaquinaria(List<MaquinariaDTO> maquinariaIngresada) throws AdmHerramientasyMaquinariaException {
        return true; // Mock: siempre retorna true
    }

    @Override
    public List<HerramientaDTO> obtenerHerramientas() {
        // Lista mock de herramientas disponibles
        List<HerramientaDTO> herramientas = new ArrayList<>();
        
        herramientas.add(new HerramientaDTO("Martillo", "Truper", "M-20"));
        herramientas.add(new HerramientaDTO("Desarmador", "Stanley", "Phillips #2"));
        herramientas.add(new HerramientaDTO("Pinzas", "DeWalt", "Corte diagonal"));
        herramientas.add(new HerramientaDTO("Llave inglesa", "Irwin", "Ajustable 10\""));
        herramientas.add(new HerramientaDTO("Nivel", "Stabila", "Láser 360°"));
        herramientas.add(new HerramientaDTO("Cinta métrica", "Milwaukee", "25 pies"));
        herramientas.add(new HerramientaDTO("Serrucho", "Bahco", "Dientes finos"));
        herramientas.add(new HerramientaDTO("Taladro", "Bosch", "PSB 1800"));
        
        return herramientas;
    }

    @Override
    public List<MaquinariaDTO> obtenerMaquinaria() {
        // Lista mock de maquinaria disponible
        List<MaquinariaDTO> maquinaria = new ArrayList<>();
        
        maquinaria.add(new MaquinariaDTO("Excavadora", "Caterpillar", "CAT-320"));
        maquinaria.add(new MaquinariaDTO("Retroexcavadora", "John Deere", "JD-310"));
        maquinaria.add(new MaquinariaDTO("Compactadora", "Wacker Neuson", "VPG-155"));
        maquinaria.add(new MaquinariaDTO("Generador", "Honda", "EU70is"));
        maquinaria.add(new MaquinariaDTO("Planta de luz", "Cummins", "C1500D5"));
        maquinaria.add(new MaquinariaDTO("Montacargas", "Toyota", "8FGCU25"));
        maquinaria.add(new MaquinariaDTO("Vibrador de concreto", "Wacker", "IREN-38"));
        maquinaria.add(new MaquinariaDTO("Cortadora de concreto", "Husqvarna", "K-760"));
        
        return maquinaria;
    }

    @Override
    public void validarHerramientas(List<HerramientaIngresadaDTO> herramientasIngresadas) throws AdmHerramientasyMaquinariaException {
        // Mock: siempre pasa la validación
        boolean herramientasValidas = true; // Cambiar a false para probar validación fallida
        
        if (!herramientasValidas) { throw new AdmHerramientasyMaquinariaException("Cantidad de herramientas insuficiente o no disponibles");
        }
    }

    @Override
    public void validarMaquinaria(List<MaquinariaDTO> maquinariaIngresada) throws AdmHerramientasyMaquinariaException {
        // Mock: siempre pasa la validación
        boolean maquinariaValida = true; // Cambiar a false para probar validación fallida
        
        if (!maquinariaValida) { throw new AdmHerramientasyMaquinariaException("Maquinaria no disponible o en mantenimiento");
        }
    }
}
