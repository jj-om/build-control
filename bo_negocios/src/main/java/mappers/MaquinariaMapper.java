package mappers;

import dominio.Maquinaria;
import dto.MaquinariaDTO;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class MaquinariaMapper {
    
    public static MaquinariaDTO toDTO(Maquinaria maquinaria){
        return new MaquinariaDTO(
                maquinaria.getNombre(),
                maquinaria.getMarca(),
                maquinaria.getMatricula()
        );
    }
    
    public static Maquinaria toEntity(MaquinariaDTO maquinariaDTO){
        return new Maquinaria(
                maquinariaDTO.getNombre(),
                maquinariaDTO.getMarca(),
                maquinariaDTO.getMatricula()
        );
    }
    
}
