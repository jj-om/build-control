/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admObraSeleccionada;

import BOs_negocios.bo_obra;

/**
 *
 * @author dario
 */
public class ControlAdmObraSeleccionada {
    
    private final SesionObraManager sesionManager;
    private final bo_obra obraBO;

    public ControlAdmObraSeleccionada() {
        this.sesionManager = SesionObraManager.getInstance();
        this.obraBO = bo_obra.getInstance();
    }

    public boolean iniciarSesion(Long numero) {
        if (obraBO.validarObraExiste(numero)) {
            Long idObra = obraBO.obtenerIdPorNumero(numero);
            return sesionManager.iniciarSesion(idObra);
        }
        return false;
    }

    public void cerrarSesion() {
        sesionManager.cerrarSesion();
    }

    public Long obtenerIdObra() {
        return sesionManager.getIdObra();
    }

    public boolean validarObraExiste(Long numero) {
        return obraBO.validarObraExiste(numero);
    }

    public Long obtenerIdPorNumero(Long numero) {
        return obraBO.obtenerIdPorNumero(numero);
    }
}