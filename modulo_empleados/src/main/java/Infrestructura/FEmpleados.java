/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infrestructura;

import java.util.List;

/**
 *
 * @author dario
 */
public class FEmpleados implements IEmpleados {

    private ControlEmpleados control;

    public FEmpleados() {
        this.control = new ControlEmpleados();
    }

    @Override
    public List<String> obtenerPersonalObra(Long idObra) {
        return control.obtenerPersonalObra(idObra);
    }
}
