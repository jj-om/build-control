/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infrestructura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dario
 */
public class ControlEmpleados {
    // Simulación de base de datos
    private static final Map<Long, List<String>> datosObra;

    static {
        datosObra = new HashMap<>();
        datosObra.put(1L, List.of("Carlos López", "Ana Torres"));
        datosObra.put(2L, List.of("Mario Pérez", "Lucía Ramírez"));
        datosObra.put(3L, List.of("Sandra Díaz"));
    }

    public List<String> obtenerPersonalObra(Long idObra) {
        // Aquí se simula que "se agrega en la URL el idObra que manden como parámetro" y se devuelve la lista correspondiente
        return datosObra.getOrDefault(idObra, new ArrayList<>());
    }
}
