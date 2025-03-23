package BOs_negocios;

import dto.MaterialDTO;
import dto.RecursoDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class bo_material {

    public bo_material() {
    }
    
    // El tipo retorno se va a cambiar por List<RecursoDTO>
    public List<RecursoDTO> obtenerRecursosObra() {
        // Crear lista para guardar los materiales
        List<RecursoDTO> recursos = new ArrayList<>();
        
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
}
