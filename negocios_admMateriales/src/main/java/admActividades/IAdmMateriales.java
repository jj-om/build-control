package admActividades;

import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.AdmMaterialesException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jesús Osuna 240549
 */

public interface IAdmMateriales {

    /**
     * Registra el material dentro de la obra.
     * 
     * @param materialIngresado Lista que contiene el material ingresado.
     * @return Verdadero si se registra con éxito, falso en caso contrario.
     * @throws AdmMaterialesException Si ocurre un error al registrar el material.
     */
    public boolean registrarMateriales(List<MaterialIngresadoDTO> materialIngresado) throws AdmMaterialesException;
    
    /**
     * Obtiene la lista de recursos disponibles en la obra.
     * 
     * @return Lista de los recursos con los que cuenta la obra.
     */
    public List<RecursoDTO> obtenerRecursosObra();
    
    /**
     * Valida que los recursos asignados a la obra y las cantidades ingresadas
     * sean coherentes.
     * 
     * @param materialIngresado Lista de materiales para validar cada cantidad
     * elegida para cada material.
     * @throws AdmMaterialesException Si ocurre un error al comparar el
     * material.
     */
    public void validarRecurso(List<MaterialIngresadoDTO> materialIngresado) throws AdmMaterialesException;
    
}
