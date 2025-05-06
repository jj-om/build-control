package mappers;

import dominio.Material;
import dto.MaterialDTO;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class MaterialMapper {

    public static MaterialDTO toDTO(Material material){
        return new MaterialDTO(
                material.getNombre(),
                material.getPeso(),
                material.getMarca(),
                material.getUnidadPeso());
    }
    
    public static Material toEntity(MaterialDTO materialDTO){
        return new Material(
                materialDTO.getNombre(),
                materialDTO.getPeso(),
                materialDTO.getMarca(),
                materialDTO.getUnidadPeso()
        );
    }
    
}
