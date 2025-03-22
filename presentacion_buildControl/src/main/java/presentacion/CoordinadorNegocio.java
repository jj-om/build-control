/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dto.ActividadDTO;
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

    public CoordinadorNegocio() {
    }
    
    // Método para obtener la instancia
    public static CoordinadorNegocio getInstance() {
        if (coordinadorNegocio == null) {
            coordinadorNegocio = new CoordinadorNegocio();
        }
        return coordinadorNegocio;
    }
    
    // Método para registrar una actividad
    public void registrarActividad(String titulo, String descripcion) {
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
    
    // OTROS MÉTODOS QUE ESTÁN EN COORDINADOR. Faltarían los DTO para poder inicializarlos
    public void registrarBitacora() {
    }
    
    public void registrarHerramientasyMaquinaria() {   
    }
    
   public void registrarAsistencia() {
   }
   
   public void registrarMateriales() {
   }
   
   public void listarRecursos() {
   }
   
   public void obtenerMaquinaria() {
   }
   
   public void obtenerPersonal() {
   }
}
