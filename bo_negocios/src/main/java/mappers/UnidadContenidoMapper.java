/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

//import DTO_infraestructura.UnidadContenidoInfraDTO;

import dominio.UnidadContenido;
import dominio_enums.UnidadBaseDatos;
import dominio_enums.UnidadPresentacionDatos;
//import infraestructura_enums.UnidadBaseInfra;
//import infraestructura_enums.UnidadPresentacionInfra;
import dto.UnidadContenidoNegocioDTO;
import negocio_enums.UnidadBaseNegocio;
import negocio_enums.UnidadPresentacionNegocio;

/**
 *
 * @author rocha
 */
public class UnidadContenidoMapper {
    
    public static UnidadContenidoNegocioDTO toDTO(UnidadContenido unidadContenido) {
        return new UnidadContenidoNegocioDTO(
                UnidadPresentacionNegocio.valueOf(unidadContenido.getUnidad().name()),
                UnidadBaseNegocio.valueOf(unidadContenido.getUnidadBase().name()),
                unidadContenido.getEquivalencia()
        );
    }
    
//    public static UnidadContenidoNegocioDTO toDTO(UnidadContenidoInfraDTO unidadContenidoDTO) {
//        return new UnidadContenidoNegocioDTO(
//                UnidadPresentacionNegocio.valueOf(unidadContenidoDTO.getUnidad().name()),
//                UnidadBaseNegocio.valueOf(unidadContenidoDTO.getUnidadBase().name()),
//                unidadContenidoDTO.getEquivalencia()
//        );
//    }
    
//    public static UnidadContenidoInfraDTO toDTO(UnidadContenidoNegocioDTO unidadContenidoDTO) {
//        return new UnidadContenidoInfraDTO(
//                UnidadPresentacionInfra.valueOf(unidadContenidoDTO.getUnidad().name()),
//                UnidadBaseInfra.valueOf(unidadContenidoDTO.getUnidadBase().name()),
//                unidadContenidoDTO.getEquivalencia()
//        );
//    }
    
    public static UnidadContenido toEntity(UnidadContenidoNegocioDTO unidadContenidoDTO) {
        return new UnidadContenido(
                UnidadPresentacionDatos.valueOf(unidadContenidoDTO.getUnidad().name()),
                UnidadBaseDatos.valueOf(unidadContenidoDTO.getUnidadBase().name()),
                unidadContenidoDTO.getEquivalencia()
        );
    }
}
