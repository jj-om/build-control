/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admBitacora;

import BOs_negocios.bo_material;
import dto.ActividadDTO;
import dto.AsistenciaPersonalDTO;
import dto.DetallesBitacoraDTO;
import dto.HerramientaDTO;
import dto.HerramientaIngresadaDTO;
import dto.MaquinariaDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.AdmBitacoraException;
import excepciones.BOMaterialException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rocha
 */
public class FAdmBitacora {

    public FAdmBitacora() {
    }
    
    // Métodos para bitácora
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacora) throws AdmBitacoraException {
        // Mock: siempre retorna true
        boolean bitacoraRegistrada = true; // Cambiar a false para probar error
        
        if (!bitacoraRegistrada) {
            throw new AdmBitacoraException("Error al registrar la bitácora");
        }
        
        return true;
    }
    
    public boolean validarBitacoraRegistrada() throws AdmBitacoraException {
        return true;
    }
    
    
    // Métodos para materiales
    public List<RecursoDTO> obtenerRecursosObra() throws AdmBitacoraException {
        return new ArrayList<>();
    }
    
    public boolean validarRecurso(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException {
        // Valida cada material elegido
        for (MaterialIngresadoDTO material : materialIngresado) {
            boolean recursoValido = true; // Cambiar a false para validar que no hay suficientes recursos en la obra
            if (!recursoValido) {
                throw new AdmBitacoraException("Cantidad de material en la obra insuficiente. Favor de registrar manualmente.");
            }
        }
        return true;
    }
    
    // Métodos para herramientas y maquinaria
    public List<HerramientaDTO> obtenerHerramientas() throws AdmBitacoraException {
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
    
    public List<MaquinariaDTO> obtenerMaquinaria() throws AdmBitacoraException {
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
    
    // Métodos para personal    
    public List<String> obtenerPersonal() throws AdmBitacoraException {
        // Lista mock de personal disponible
        List<String> personal = new ArrayList<>();
        
        personal.add("Juan Pérez López");
        personal.add("María García Sánchez");
        personal.add("Carlos Martínez Rodríguez");
        personal.add("Ana López González");
        personal.add("Pedro Hernández Ramírez");
        personal.add("Laura Díaz Fernández");
        personal.add("Jorge Álvarez Gómez");
        personal.add("Sofía Ruiz Jiménez");
        
        return personal;
    }

}
