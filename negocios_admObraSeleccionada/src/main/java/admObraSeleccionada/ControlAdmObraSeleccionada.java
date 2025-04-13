/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admObraSeleccionada;

import bo.ObraBO;
import excepciones.AdmObraSeleccionadaException;
import excepciones.BOException;

/**
 *
 * @author dario
 */
public class ControlAdmObraSeleccionada {
    
    private final SesionObraManager sesionManager;
    private final ObraBO obraBO;

    public ControlAdmObraSeleccionada() {
        this.sesionManager = SesionObraManager.getInstance();
        this.obraBO = ObraBO.getInstance();
    }

    public boolean iniciarSesion(Long numero) throws AdmObraSeleccionadaException {
        try {
            if (!obraBO.validarObraExiste(numero)) {
                throw new AdmObraSeleccionadaException("No se encontró obra con número " + numero + ".");
            }
            
            Long idObra = obtenerIdPorNumero(numero);
            
            return sesionManager.iniciarSesion(idObra);
        } catch (BOException e) {
            throw new AdmObraSeleccionadaException("No se pudo iniciar la sesión de la obra.", e);
        }
    }

    public void cerrarSesion() {
        sesionManager.cerrarSesion();
    }

    public Long obtenerIdObra() {
        return sesionManager.getIdObra();
    }

    public boolean validarObraExiste(Long numero) throws AdmObraSeleccionadaException {
        try {
            return obraBO.validarObraExiste(numero);
        } catch (BOException e) {
            throw new AdmObraSeleccionadaException("No se pudo verificar si la obra existe.", e);
        }
    }

    private Long obtenerIdPorNumero(Long numero) throws AdmObraSeleccionadaException {
        try {
            return obraBO.obtenerIdPorNumero(numero);
        } catch (Exception e) {
            throw new AdmObraSeleccionadaException("No se pudo obtener el id de la obra.", e);
        }
    }
    
    public String obtenerDireccionObra() throws AdmObraSeleccionadaException{
        try {
            Long idObra = obtenerIdPorNumero(sesionManager.getIdObra());
            return obraBO.obtenerDireccionObra(idObra);
        } catch (Exception e) {
            throw new AdmObraSeleccionadaException("No se pudo obtener la direccion de la obra.", e);
        }
    }
    
}