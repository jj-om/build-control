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
import java.util.ArrayList;
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
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacora) throws AdmBitacoraException {
        // Mock: siempre retorna true
        boolean bitacoraRegistrada = true; // Cambiar a false para probar error
        
        if (!bitacoraRegistrada) {
            throw new AdmBitacoraException("Error al registrar la bitácora");
        }
        
        return true;
    }
    
    public boolean validarBitacoraRegistrada() throws AdmBitacoraException {
        return true;
    }
    
    
    // Métodos para materiales
    public List<RecursoDTO> obtenerRecursosObra() throws AdmBitacoraException {
        return new ArrayList<>();
    }
    
    public boolean validarRecurso(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException {
        // Valida cada material elegido
        for (MaterialIngresadoDTO material : materialIngresado) {
            boolean recursoValido = true; // Cambiar a false para validar que no hay suficientes recursos en la obra
            if (!recursoValido) {
                throw new AdmBitacoraException("Cantidad de material en la obra insuficiente. Favor de registrar manualmente.");
            }
        }
        return true;
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
