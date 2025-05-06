package mappers;

import dominio.Recurso;
import dto.RecursoDTO;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class RecursoMapper {

    public static RecursoDTO toDTO(Recurso recurso){
        return new RecursoDTO(
                MaterialMapper.toDTO(recurso.getMaterial()), 
                recurso.getCantidad(),
                recurso.getIdObra()
        );
    }
    
    public static Recurso toEntity(RecursoDTO recursoDTO){
        return new Recurso(
                MaterialMapper.toEntity(recursoDTO.getMaterial()), 
                recursoDTO.getCantidad(), 
                recursoDTO.getIdObra()
        );
    }
    
}
