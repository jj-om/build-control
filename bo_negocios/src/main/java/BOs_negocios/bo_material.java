package BOs_negocios;

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
    public List<String> obtenerRecursosObra() {
        List<String> materiales = Arrays.asList("Cemento Portland", "Yeso", "Ladrillo", "Madera", "Acero"); // Ejemplo de materiales precargados
        
        return materiales;
    }
}
