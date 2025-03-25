/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AdmHerramientasYMaquinaria;

import dto.HerramientaDTO;
import dto.HerramientaIngresadaDTO;
import dto.MaquinariaDTO;
import excepciones.AdmHerramientasyMaquinariaException;
import java.util.List;

/**
 *
 * @author dario
 */
public interface IAdmHerramientasYMaquinaria {
     
    /**
     * Registra las herramientas dentro de la obra.
     * 
     * @param herramientasIngresadas Lista de herramientas a registrar
     * @return Verdadero si se registra con éxito, falso en caso contrario
     * @throws AdmHerramientasYMaquinariaException Si ocurre un error al registrar
     */
    boolean registrarHerramientas(List<HerramientaIngresadaDTO> herramientasIngresadas) throws AdmHerramientasyMaquinariaException;
    
    /**
     * Registra la maquinaria dentro de la obra.
     * 
     * @param maquinariaIngresada Lista de maquinaria a registrar
     * @return Verdadero si se registra con éxito, falso en caso contrario
     * @throws AdmHerramientasYMaquinariaException Si ocurre un error al registrar
     */
    boolean registrarMaquinaria(List<MaquinariaDTO> maquinariaIngresada)  throws AdmHerramientasyMaquinariaException;
    
    /**
     * Obtiene la lista de herramientas disponibles.
     * 
     * @return Lista de herramientas disponibles
     */
    List<HerramientaDTO> obtenerHerramientas();
    
    /**
     * Obtiene la lista de maquinaria disponible.
     * 
     * @return Lista de maquinaria disponible
     */
    List<MaquinariaDTO> obtenerMaquinaria();
    
    /**
     * Valida que las herramientas ingresadas sean válidas.
     * 
     * @param herramientasIngresadas Lista de herramientas a validar
     * @throws AdmHerramientasYMaquinariaException Si alguna herramienta no es válida
     */
    void validarHerramientas(List<HerramientaIngresadaDTO> herramientasIngresadas) throws AdmHerramientasyMaquinariaException;
    
    /**
     * Valida que la maquinaria ingresada sea válida.
     * 
     * @param maquinariaIngresada Lista de maquinaria a validar
     * @throws AdmHerramientasYMaquinariaException Si alguna maquinaria no es válida
     */
    void validarMaquinaria(List<MaquinariaDTO> maquinariaIngresada) throws AdmHerramientasyMaquinariaException;
}
