/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.modulo_empleados;

import Infrestructura.FEmpleados;
import Infrestructura.IEmpleados;
import java.util.List;

/**
 *
 * @author dario
 */
public class Modulo_empleados {

    public static void main(String[] args) {
        IEmpleados fachada = new FEmpleados();
        List<String> empleados = fachada.obtenerPersonalObra(1L);

        System.out.println("Empleados en la obra 1:");
        for (String nombre : empleados) {
            System.out.println("- " + nombre);
        }
    }
}
