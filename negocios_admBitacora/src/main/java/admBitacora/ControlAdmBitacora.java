/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admBitacora;

import BOs_negocios.bo_material;
import BOs_negocios.bo_recurso;
import dto.DetallesBitacoraDTO;
import dto.HerramientaDTO;
import dto.MaquinariaDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.BOMaterialException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ximena
 */
public class ControlAdmBitacora {
    private bo_material boMaterial;
    private bo_recurso boRecurso;

    public ControlAdmBitacora() {
        this.boMaterial = new bo_material();
        this.boRecurso = new bo_recurso();
    }
    
    // Métodos para bitácora
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacoraDTO, Long idObra) {
        return true;
    }
    
    public boolean validarDatosBitacora(DetallesBitacoraDTO detallesBitacoraDTO, Long idObra) {
        return true;
    }
    
    public boolean validarBitacoraRegistrada() {
        return true;
    }
    
    // Métodos para materiales
    public List<RecursoDTO> obtenerRecursosObra() throws BOMaterialException {
        return boMaterial.obtenerRecursosObra();
    }
    
    public boolean validarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws BOMaterialException {
        // Valida cada material elegido
        for (MaterialIngresadoDTO material : materialIngresado) {
            if (material.getCantidad() > materialIngresado.size()) { 
                throw new BOMaterialException("Cantidad de material en la obra insuficiente. Favor de registrar manualmente.");
            }
        }
        return true;
    }
    
    public void restarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws BOMaterialException {
        // Obtener lista de los recursos de la obra
        List<RecursoDTO> recursosObra = obtenerRecursosObra();
        // Para cada material ingresado para usarse, revisar los recursos dentro de la obra
        for (MaterialIngresadoDTO material : materialIngresado) {
            for (RecursoDTO recurso : recursosObra) {
                // Si el nombre del material dentro del recurso y del recurso ingresado coindide, restarle la cantidad
                if (recurso.getMaterial().getNombre().equals(material.getRecurso().getMaterial().getNombre())) {
                    // Si la cantidad que hay en los recursos es mayor o igual a la cantidad ingresada, se le resta y actualiza la cantidad de recursos
                    if (recurso.getCantidad() >= material.getCantidad()) {
                        Integer nuevoStock = recurso.getCantidad() - material.getCantidad();
                        boolean actualizado = boRecurso.actualizarCantidadRecurso(recurso.getMaterial().getNombre(), recurso.getMaterial().getUnidadPeso(), nuevoStock);
                        if (actualizado) {
                            return;
                        }
                        // Imprimir para probar si funciona
                        // System.out.println("Material: " + recurso.getMaterial().getNombre() + ", Cantidad restante: " + nuevoStock);
                    } else { // Sino se lanza excepción de que no hay stock
                        throw new BOMaterialException("No hay suficiente stock de " + recurso.getMaterial().getNombre() + " . Favor de registrar manualmente");
                    }
                }
            }
        }
    }
    
    public boolean actualizarCantidadRecurso(String nombreMaterial, Integer restante) {
        return true;
    }
    
    // Métodos para herramientas y maquinaria
    public List<HerramientaDTO> obtenerHerramientasObra() {
        return new ArrayList<>();
    }
    
    public List<MaquinariaDTO> obtenerMaquinariaObra() {
        return new ArrayList<>();
    }
    
    // Métodos para personal
    public List<String> obtenerPersonal() {
        return new ArrayList<>();
    }
}
