package BOs_negocios;

import dto.MaterialDTO;
import dto.MaterialIngresadoDTO;
import dto.ObraDTO;
import dto.RecursoDTO;
import excepciones.BOException;
import excepciones.BOMaterialException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class bo_recurso {
    public static bo_recurso recursoBO;
    // Crear lista para guardar los materiales
    private List<RecursoDTO> recursos = new ArrayList<>();
    // Crear lista para los materiales ingresados
    private List<MaterialIngresadoDTO> materialesIngresados = new ArrayList<>();
    //TEMPORAL objeto obra
    private ObraDTO obra;
    
    public static bo_recurso getInstance() {
        if (recursoBO == null) {
            recursoBO = new bo_recurso();
        }
        return recursoBO;
    }
    
    public List<RecursoDTO> obtenerRecursosObra(Long idObra) throws BOException {
        MaterialDTO material1 = new MaterialDTO("Cemento", 50.0f, "Holcim", "kg");
        MaterialDTO material2 = new MaterialDTO("Arena", 100.0f, "Cemex", "kg");
        MaterialDTO material3 = new MaterialDTO("Varilla", 20.5f, "Ternium", "kg");
        MaterialDTO material4 = new MaterialDTO("Pintura Blanca", 4.0f, "Comex", "litros");
        MaterialDTO material5 = new MaterialDTO("Yeso", 25.0f, "Knauf", "kg");
        MaterialDTO material6 = new MaterialDTO("Clavos", 2.0f, "Truper", "kg");
        MaterialDTO material7 = new MaterialDTO("Madera", 30.0f, "Finsa", "kg");
        MaterialDTO material8 = new MaterialDTO("Adhesivo", 1.5f, "Resistol", "litros");
        
        // Instancias de RecursoDTO y añadiéndolas a la lista
        recursos.add(new RecursoDTO(material1, 100));  // 100 unidades de cemento
        recursos.add(new RecursoDTO(material2, 50));   // 50 unidades de arena
        recursos.add(new RecursoDTO(material3, 200));  // 200 unidades de varilla
        recursos.add(new RecursoDTO(material4, 10));   // 10 unidades de pintura blanca
        recursos.add(new RecursoDTO(material5, 75));   // 75 unidades de yeso
        recursos.add(new RecursoDTO(material6, 500));  // 500 unidades de clavos
        recursos.add(new RecursoDTO(material7, 150));  // 150 unidades de madera
        recursos.add(new RecursoDTO(material8, 25));   // 25 unidades de adhesivo
        
        return recursos;
    }
    
    // Checar con el que esta en coordinador negocio en presentacion
    public boolean actualizarCantidadRecurso(String nombreMaterial, String unidadPeso, Integer cantidad) throws BOException {
        for (RecursoDTO recurso : recursos) {
            if (recurso.getMaterial().getNombre().equals(nombreMaterial) && 
                recurso.getMaterial().getUnidadPeso().equals(unidadPeso)) {

                if (cantidad < 0) {
                    throw new BOException("No puede haber cantidad negativa");
                }

                recurso.setCantidad(cantidad);
                return true;
            }
        }
        throw new BOException("Material no encontrado: " + nombreMaterial);
    }
    
}
