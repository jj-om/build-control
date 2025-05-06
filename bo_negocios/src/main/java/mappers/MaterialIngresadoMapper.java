package mappers;

import dominio.MaterialIngresado;
import dto.MaterialIngresadoDTO;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class MaterialIngresadoMapper {

    public static MaterialIngresadoDTO toDTO(MaterialIngresado materialIngresado){
        return new MaterialIngresadoDTO(
                RecursoMapper.toDTO(materialIngresado.getRecurso()),
                materialIngresado.getCantidad());
    }
    
    public static MaterialIngresado toEntity(MaterialIngresadoDTO materialIngresadoDTO){
        return new MaterialIngresado(
                RecursoMapper.toEntity(materialIngresadoDTO.getRecurso()), 
                materialIngresadoDTO.getCantidad());
    }
    
}
