/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admBitacora;

import BOs_negocios.bo_asistencia;
import BOs_negocios.bo_bitacora;
import BOs_negocios.bo_herramienta;
import BOs_negocios.bo_maquinaria;
import BOs_negocios.bo_material;
import BOs_negocios.bo_personal;
import BOs_negocios.bo_recurso;
import admObraSeleccionada.FAdmObraSeleccionada;
import admObraSeleccionada.IAdmObraSeleccionada;
import dto.DetallesBitacoraDTO;
import dto.HerramientaDTO;
import dto.MaquinariaDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.AdmBitacoraException;
import excepciones.AdmObraSeleccionadaException;
import excepciones.BOException;
import excepciones.BOMaterialException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ximena
 */
public class ControlAdmBitacora {
    private IAdmObraSeleccionada admObraSeleccionada;
    
    // BOs
    private bo_bitacora boBitacora;
    private bo_herramienta boHerramienta;
    private bo_maquinaria boMaquinaria;
    private bo_personal boPersonal;
    private bo_recurso boRecurso;

    public ControlAdmBitacora() {
        this.admObraSeleccionada = new FAdmObraSeleccionada();
        
        this.boBitacora = bo_bitacora.getInstance();
        this.boHerramienta = bo_herramienta.getInstance();
        this.boMaquinaria = bo_maquinaria.getInstance();
        this.boPersonal = bo_personal.getInstance();
        this.boRecurso = bo_recurso.getInstance();
    }
    
    // Métodos para bitácora
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacoraDTO, Long idObra) throws AdmBitacoraException {
        try {
            // Validar que la bitácora no esté ya registrada para esta obra/fecha
            if (validarBitacoraRegistrada()) {
                throw new AdmBitacoraException("Ya existe una bitácora registrada para esta obra hoy");
            }

            // Validar estructura de datos
            if (!validarDatosBitacora(detallesBitacoraDTO, idObra)) {
                throw new AdmBitacoraException("Datos de bitácora incompletos o inválidos");
            }

            // Validar materiales (si hay)
            if (detallesBitacoraDTO.getMaterialesIngresados() != null && !detallesBitacoraDTO.getMaterialesIngresados().isEmpty()) {
                validarRecursos(detallesBitacoraDTO.getMaterialesIngresados());
            }

            // Registrar en el BO
            boolean exito = boBitacora.registrarBitacora(detallesBitacoraDTO, idObra);

            if (!exito) {
                throw new AdmBitacoraException("Error al guardar la bitácora");
            }

            //Actualizar inventario (si hay materiales)
            if (detallesBitacoraDTO.getMaterialesIngresados() != null && !detallesBitacoraDTO.getMaterialesIngresados().isEmpty()) {
                restarRecursos(detallesBitacoraDTO.getMaterialesIngresados());
            }

            return true;
        } catch (BOException | BOMaterialException e) {
            throw new AdmBitacoraException("Error en sistema: " + e.getMessage());
        }
    }
    
    public boolean validarDatosBitacora(DetallesBitacoraDTO detallesBitacoraDTO, Long idObra) {
    return detallesBitacoraDTO != null &&
           detallesBitacoraDTO.getBitacora() != null &&
           detallesBitacoraDTO.getBitacora().getIdObra() != null &&
           detallesBitacoraDTO.getBitacora().getIdObra().equals(idObra) &&
           detallesBitacoraDTO.getActividades() != null && !detallesBitacoraDTO.getActividades().isEmpty() &&
           detallesBitacoraDTO.getListaAsistencia() != null && !detallesBitacoraDTO.getListaAsistencia().getAsistencias().isEmpty();
}
    
    public boolean validarBitacoraRegistrada() {
        return true;
    }
    
    // Métodos para materiales
    public List<RecursoDTO> obtenerRecursosObra() throws AdmBitacoraException {
        try {
            // Obtiene el id mediante el subsistema
            Long idObra = admObraSeleccionada.obtenerIdObra();
            
            // Obtiene el recurso de la obra mediante el BO
            List<RecursoDTO> recursos = boRecurso.obtenerRecursosObra(idObra);
            
            // Valida la lista de personal
            if (recursos == null || recursos.isEmpty()) {
                throw new AdmBitacoraException("No hay recursos asignados a la obra.");
            }
            
            return recursos;
        } catch (BOException | AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("No se pudo obtener el personal de la obra.");
        }
    }
    
    public boolean validarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws BOMaterialException {
        // Valida cada material elegido
        for (MaterialIngresadoDTO material : materialIngresado) {
            if (material.getCantidad() > material.getRecurso().getCantidad()) { 
                throw new BOMaterialException("Cantidad de material en la obra insuficiente. Favor de registrar manualmente.");
            }
        }
        return true;
    }
    
    public void restarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException {
        try {
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
                            throw new AdmBitacoraException("No hay suficiente stock de " + recurso.getMaterial().getNombre() + " . Favor de registrar manualmente");
                        }
                    }
                }
            }
        } catch (BOException e) {
            
        }
    }
    
    public boolean actualizarCantidadRecurso(String nombreMaterial, Integer restante) {
        return true;
    }
    
    // Métodos para herramientas y maquinaria
    // Falta que le llamen al subsistema para obtener id,  llamen al BO y validen
        public List<HerramientaDTO> obtenerHerramientasObra() throws AdmBitacoraException {
        try {
            Long idObra = admObraSeleccionada.obtenerIdObra();
            List<HerramientaDTO> herramientas = boHerramienta.obtenerHerramientas(idObra);
            
            if (herramientas == null || herramientas.isEmpty()) {
                throw new AdmBitacoraException("No hay herramientas asignadas a esta obra");
            }
            
            return herramientas;
        } catch (AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("Error al obtener obra: " + e.getMessage());
        }
    }
    
     public List<MaquinariaDTO> obtenerMaquinariaObra() throws AdmBitacoraException {
        try {
            Long idObra = admObraSeleccionada.obtenerIdObra();
            List<MaquinariaDTO> maquinaria = boMaquinaria.obtenerMaquinaria(idObra);
            
            if (maquinaria == null || maquinaria.isEmpty()) {
                throw new AdmBitacoraException("No hay maquinaria asignada a esta obra");
            }
            
            return maquinaria;
        } catch (AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("Error al obtener obra: " + e.getMessage());
        }
    }
    
    // Métodos para personal
    public List<String> obtenerPersonalObra() throws AdmBitacoraException {
        try {
            // Obtiene el id mediante el subsistema
            Long idObra = admObraSeleccionada.obtenerIdObra();
            
            // Obtiene el personal de la obra mediante el BO
            List<String> listaPersonal = boPersonal.obtenerPersonal(idObra);
            
            // Valida la lista de personal
            if (listaPersonal == null || listaPersonal.isEmpty()) {
                throw new AdmBitacoraException("No hay personal asignado a la obra.");
            }
            
            return listaPersonal;
        } catch (BOException | AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("No se pudo obtener el personal de la obra.");
        }
    }
}
