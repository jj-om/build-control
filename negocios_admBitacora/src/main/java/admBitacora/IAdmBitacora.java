/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public interface IAdmBitacora {
    
    public List<HerramientaDTO> obtenerHerramientasObra() throws AdmBitacoraException;
    
    public List<MaquinariaDTO> obtenerMaquinariaObra() throws AdmBitacoraException;
    
    public List<String> obtenerPersonalObra() throws AdmBitacoraException;
    
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacora) throws AdmBitacoraException;
    
    public boolean validarBitacoraRegistrada() throws AdmBitacoraException;
    
    public List<RecursoDTO> obtenerRecursosObra() throws AdmBitacoraException;
    
    public boolean validarRecurso(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException;
}
