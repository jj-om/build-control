/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package admObraSeleccionada;

import excepciones.AdmObraSeleccionadaException;

/**
 *
 * @author rocha
 */
public class Pruebas {

    public static void main(String[] args) {
        try {
            IAdmObraSeleccionada admObraSeleccionada = new FAdmObraSeleccionada();

            admObraSeleccionada.activarSesionObra(1L);
            
            System.out.println(admObraSeleccionada.obtenerIdObra());
            
            admObraSeleccionada.cerrarSesionObra();
            
            System.out.println(admObraSeleccionada.obtenerIdObra());
        } catch (AdmObraSeleccionadaException e) {
            System.err.println(e.getMessage());
        }
    }
}
