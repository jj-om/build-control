/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admBitacora;

import dto.DetallesBitacoraDTO;
import dto.HerramientaDTO;
import dto.MaquinariaDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.AdmBitacoraException;
import java.util.List;

/**
 *
 * @author rocha
 */
public class FAdmBitacora implements IAdmBitacora {

    private ControlAdmBitacora controlAdmBitacora;

    public FAdmBitacora() {
        this.controlAdmBitacora = new ControlAdmBitacora();
    }

    // Métodos para bitácora
    @Override
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacora) throws AdmBitacoraException {
        return controlAdmBitacora.registrarBitacora(detallesBitacora);
    }

    @Override
    public boolean validarBitacoraRegistrada() throws AdmBitacoraException {
        return controlAdmBitacora.validarBitacoraRegistrada();
    }

    // Métodos para materiales
    @Override
    public List<RecursoDTO> obtenerRecursosObra() throws AdmBitacoraException {
        return controlAdmBitacora.obtenerRecursosObra();
    }

    @Override
    public boolean validarRecurso(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException {
        // Valida cada material elegido
        return controlAdmBitacora.validarRecursos(materialIngresado);

    }

    // Métodos para herramientas y maquinaria
    @Override
    public List<HerramientaDTO> obtenerHerramientasObra() throws AdmBitacoraException {
        return controlAdmBitacora.obtenerHerramientasObra();
    }

    @Override
    public List<MaquinariaDTO> obtenerMaquinariaObra() throws AdmBitacoraException {
        return controlAdmBitacora.obtenerMaquinariaObra();
    }

    // Métodos para personal    
    @Override
    public List<String> obtenerPersonalObra() throws AdmBitacoraException {
        return controlAdmBitacora.obtenerPersonalObra();
    }

}
