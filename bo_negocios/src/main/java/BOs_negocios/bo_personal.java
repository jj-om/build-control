/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs_negocios;

import excepciones.BOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class bo_personal {
    private static bo_personal instance;

    private bo_personal() {
    }

    public static bo_personal getInstance() {
        if (instance == null) {
            instance = new bo_personal();
        }
        return instance;
    }
    
    public List<String> obtenerPersonal(Long idObra) throws BOException { // Cuando esté infraestructura va a tirar la excepckión
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
