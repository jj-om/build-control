package mappers;

import dominio.Material;
import dominio_enums.TipoMaterialDatos;
import dto.MaterialDTO;
import negocio_enums.TipoMaterialNegocio;

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
                material.getCodigo(),
                material.getNombre(),
                material.getMarca(),
                TipoMaterialNegocio.valueOf(material.getTipo().name()),
                UnidadContenidoMapper.toDTO(material.getUnidadPresentacion())
        );
    }
    
    public static Material toEntity(MaterialDTO materialDTO){
        return new Material(
                materialDTO.getCodigo(),
                materialDTO.getNombre(),
                materialDTO.getMarca(),
                TipoMaterialDatos.valueOf(materialDTO.getTipo().name()),
                UnidadContenidoMapper.toEntity(materialDTO.getUnidadPresentacion())
        );
    }
    
}
