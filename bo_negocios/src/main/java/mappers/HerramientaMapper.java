package mappers;

import dominio.Herramienta;
import dto.HerramientaDTO;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class HerramientaMapper {
    
    public static HerramientaDTO toDTO(Herramienta herramienta){
        return new HerramientaDTO(
                herramienta.getNombre(),
                herramienta.getMarca(),
                herramienta.getModelo()
        );
    }
    
    public static Herramienta toEntity(HerramientaDTO herramientaDTO){
        return new Herramienta(
                herramientaDTO.getNombre(),
                herramientaDTO.getMarca(),
                herramientaDTO.getModelo());
    }
    
}
