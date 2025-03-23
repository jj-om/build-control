/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dto.ActividadDTO;
import dto.AsistenciaPersonalDTO;
import dto.DetallesBitacoraDTO;
import dto.HerramientaIngresadaDTO;
import dto.ListaAsistenciaDTO;
import dto.MaterialDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import exception.PresentacionException;
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
    private List<RecursoDTO> recursos = new ArrayList<>();
    // Crear lista para guardar las herramientas
    private List<HerramientaIngresadaDTO> herramientas = new ArrayList<>();
    // Crear lista para guardar la asistencia de los empleados
    private List<AsistenciaPersonalDTO> asistenciaPersonal = new ArrayList<>();
    private List<MaterialIngresadoDTO> materialesIngresados = new ArrayList<>();
    // Objeto para guardar la lista de asistencia
    private ListaAsistenciaDTO asistencias;
    // Crear objeto bitacora para guardar la bitacora creada
    private DetallesBitacoraDTO detallesBitacora;

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
    
    public boolean guardarActividades() {
        return true;
    }
    
    // MÉTODOS PARA EL FORMULARIO DE MATERIALES

    // Regresa la lista de materiales
    public List<RecursoDTO> obtenerMateriales() {
        // Crear lista para guardar los materiales
        List<RecursoDTO> listaRecursos = new ArrayList<>();
        
        MaterialDTO material1 = new MaterialDTO("Cemento", 50.0f, "Holcim", "kg");
        MaterialDTO material2 = new MaterialDTO("Arena", 100.0f, "Cemex", "kg");
        MaterialDTO material3 = new MaterialDTO("Varilla", 20.5f, "Ternium", "kg");
        MaterialDTO material4 = new MaterialDTO("Pintura Blanca", 4.0f, "Comex", "litros");
        MaterialDTO material5 = new MaterialDTO("Yeso", 25.0f, "Knauf", "kg");
        MaterialDTO material6 = new MaterialDTO("Clavos", 2.0f, "Truper", "kg");
        MaterialDTO material7 = new MaterialDTO("Madera", 30.0f, "Finsa", "kg");
        MaterialDTO material8 = new MaterialDTO("Adhesivo", 1.5f, "Resistol", "litros");
        
        // Instancias de RecursoDTO y añadiéndolas a la lista
        listaRecursos.add(new RecursoDTO(material1, 100));  // 100 unidades de cemento
        listaRecursos.add(new RecursoDTO(material2, 50));   // 50 unidades de arena
        listaRecursos.add(new RecursoDTO(material3, 200));  // 200 unidades de varilla
        listaRecursos.add(new RecursoDTO(material4, 10));   // 10 unidades de pintura blanca
        listaRecursos.add(new RecursoDTO(material5, 75));   // 75 unidades de yeso
        listaRecursos.add(new RecursoDTO(material6, 500));  // 500 unidades de clavos
        listaRecursos.add(new RecursoDTO(material7, 150));  // 150 unidades de madera
        listaRecursos.add(new RecursoDTO(material8, 25));   // 25 unidades de adhesivo
        
        return listaRecursos;
    }
    
    public boolean guardarMateriales(List<MaterialIngresadoDTO> materialIngresado) {
        return true;
    }
    
    // MÉTODOS PARA EL FORMULARIO DE HERRAMIENTAS Y MAQUINARIA
    // Método para agregar una herramienta
    public void registrarHerramientas(String nombre, int cantidad) {
        herramientas.add(new HerramientaIngresadaDTO(nombre, cantidad));
    }
    
    // Método para agregar la bitácora
    public boolean registrarBitacora() {
        //Crear una bitacora, hablarle al subsistema obraSeleccionada y obtener el id
        
        detallesBitacora.setActividades(actividades);
        detallesBitacora.setMaterialesIngresados(materialesIngresados);
        detallesBitacora.setHerramientasIngresadas(herramientas);
        detallesBitacora.setListaAsistencia(asistencias); 
        //Settearle la bitacora
        
        return true;
    }
    
    // MÉTODOS PARA LA ASISTENCIA DEL PERSONAL. Aún no se manejan porque aún no se ha registrado personal
    // Método para agregar una nueva asistencia en la lista de asistencia
    public void registrarAsistencia(AsistenciaPersonalDTO asistencia) {
       asistenciaPersonal.add(asistencia);
    }
    
    // Guarda la lista de asistencia
    public boolean guardarListaAsistencia() {
        
        return true;
    }
    
    // Método para obtener la lista de asistencia del personal
    public List<String> obtenerPersonal() {
        return null; // Cambiar por strings
    }
}
