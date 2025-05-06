package mappers;

import dominio.HerramientaIngresada;
import dto.HerramientaIngresadaDTO;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class HerramientaIngresadaMapper {

    public static HerramientaIngresadaDTO toDTO(HerramientaIngresada herramientaIngresada){
        return new HerramientaIngresadaDTO(
                HerramientaMapper.toDTO(herramientaIngresada.getHerramienta()), 
                herramientaIngresada.getCantidad());
    }
    
    public static HerramientaIngresada toEntity(HerramientaIngresadaDTO herramientaIngresadaDTO){
        return new HerramientaIngresada(
                HerramientaMapper.toEntity(herramientaIngresadaDTO.getHerramienta()), 
                herramientaIngresadaDTO.getCantidad());
    }
    
}
