/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dto.ActividadDTO;
import dto.AsistenciaPersonalDTO;
import dto.BitacoraDTO;
import dto.HerramientaIngresadaDTO;
import dto.ListaAsistenciaDTO;
import dto.MaterialIngresadoDTO;
import exception.PresentacionException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ximena
 */
public class CoordinadorNegocio {
    private static CoordinadorNegocio coordinadorNegocio;
    // Crear lista para guardar las actividades
    private List<ActividadDTO> actividades = new ArrayList<>();
    // Crear lista para guardar los materiales
    private List<MaterialIngresadoDTO> materiales = new ArrayList<>();
    // Crear lista para guardar las herramientas
    private List<HerramientaIngresadaDTO> herramientas = new ArrayList<>();
    // Crear lista para guardar la asistencia de los empleados
    private List<AsistenciaPersonalDTO> asistenciaPersonal = new ArrayList<>();
    // Objeto para guardar la lista de asistencia
    private ListaAsistenciaDTO asistencias;
    // Crear objeto bitacora para guardar la bitacora creada
    private BitacoraDTO bitacora;

    private CoordinadorNegocio() {
    }
    
    // Método para obtener la instancia
    public static CoordinadorNegocio getInstance() {
        if (coordinadorNegocio == null) {
            coordinadorNegocio = new CoordinadorNegocio();
        }
        return coordinadorNegocio;
    }
    
    // MÉTODOS PARA EL FORMULARIO DE ACTIVIDADES
    // Método para registrar una actividad en la lista
    public void agregarActividad(String titulo, String descripcion) throws PresentacionException {
        // Validar antes de agregar la actividad
        String mensajeError = Validaciones.validarActividad(titulo, descripcion);
        if (mensajeError != null) {
            throw new PresentacionException(mensajeError);
        }
        // Agregar actividad después de validar
        actividades.add(new ActividadDTO(titulo, descripcion));
    }
    // Devuelve la lista de actividades
    public List<ActividadDTO> obtenerActividades() {
        return actividades;
    }
    // Elimina las actividades dentro de la lista
    public void cancelarActividades() {
        actividades.clear();
    }
    
    // MÉTODOS PARA EL FORMULARIO DE MATERIALES
    // Agrega un material a la tabla
    public void registrarMateriales(String nombre, int cantidad) {
        materiales.add(new MaterialIngresadoDTO(nombre, cantidad));
    }
    // Actualiza la cantidad de material que se utilizó
    public void actualizarCantidadMaterial(int rowIndex, int cantidad) {
        // Validar que la cantidad ingresada es mayor o igual a cero y que no sea mayor que la cantidad que ya se encuentra cargada
        if (rowIndex >= 0 && rowIndex < materiales.size()) {
            materiales.get(rowIndex).setCantidad(cantidad);
        }
    }
    // Elimina un material de la tabla
    public void eliminarMaterial(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < materiales.size()) {
            materiales.remove(rowIndex);
        }
    }
    // Regresa la lista de materiales
    public List<MaterialIngresadoDTO> obtenerMateriales() {
        return materiales;
    }
    
    // MÉTODOS PARA EL FORMULARIO DE HERRAMIENTAS Y MAQUINARIA
    // Método para agregar una herramienta
    public void registrarHerramientas(String nombre, int cantidad) {
        herramientas.add(new HerramientaIngresadaDTO(nombre, cantidad));
    }
    // Actualizar las herramientas que se utilizaron
    public void actualizarCantidadHerramienta(int rowIndex, int cantidad) {
        if (rowIndex >= 0 && rowIndex < herramientas.size()) {
            herramientas.get(rowIndex).setCantidad(cantidad);
        }
    }
    // Quitar una herramienta de la lista
    public void eliminarHerramienta(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < herramientas.size()) {
            
        }
    }
    
    // Método para agregar la bitácora
    public void registrarBitacora() {
        bitacora.setTitulo("Nueva bitácora"); // Ejemplo de título
        bitacora.setActividades(actividades);
        bitacora.setMaterialesIngresados(materiales);
        bitacora.setHerramientasIngresadas(herramientas);
        // bitacora.setListaAsistencias(asistencias); No recibe el mismo objeto de asistencias
    }
    
    // MÉTODOS PARA LA ASISTENCIA DEL PERSONAL. Aún no se manejan porque aún no se ha registrado personal
    // Método para agregar una nueva asistencia
    public void registrarAsistencia(String nombre, LocalTime horaEntrada, LocalTime horaSalida, String notas) {
       asistenciaPersonal.add(new AsistenciaPersonalDTO(nombre, horaEntrada, horaSalida, notas));
    }
    // Método para obtener la lista de asistencia del personal
    public List<AsistenciaPersonalDTO> obtenerPersonal() {
        return asistenciaPersonal;
    }

}
