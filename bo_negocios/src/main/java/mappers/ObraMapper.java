package mappers;

import dominio.Obra;
import dto.ObraDTO;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class ObraMapper {

    public static ObraDTO toDTO(Obra obra){
        return new ObraDTO(
                obra.getNumero(),
                obra.getDireccion(), 
                obra.getMetrosCubicos());
    }
    
    public static Obra toEntity(ObraDTO obraDTO){
        return new Obra(
                obraDTO.getNumero(),
                obraDTO.getDireccion(),
                obraDTO.getMetrosCubicos()
        );
    }
    
}
