package BOs_negocios;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
// SE VA A QUITAR
public class bo_asistencia {
    public static bo_asistencia personalBO;
    
    public static bo_asistencia getInstance() {
        if (personalBO == null) {
            personalBO = new bo_asistencia();
        }
        return personalBO;
    }
    
    public List<String> obtenerPersonalObra(Long idObra) {
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
