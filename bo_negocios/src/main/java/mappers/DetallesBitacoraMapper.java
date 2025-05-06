package mappers;

import dominio.DetallesBitacora;
import dto.DetallesBitacoraDTO;
import java.util.stream.Collectors;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class DetallesBitacoraMapper {

    public static DetallesBitacoraDTO toDTO(DetallesBitacora detallesBitacora) {
        return new DetallesBitacoraDTO(
                ListaAsistenciaMapper.toDTO(detallesBitacora.getAsistencia()),
                detallesBitacora.getMaterialesIngresados().stream()
                        .map(MaterialIngresadoMapper::toDTO)
                        .collect(Collectors.toList()),
                detallesBitacora.getHerramientasIngresadas().stream()
                        .map(HerramientaIngresadaMapper::toDTO)
                        .collect(Collectors.toList()),
                detallesBitacora.getMaquinarias().stream()
                        .map(MaquinariaMapper::toDTO)
                        .collect(Collectors.toList()),
                detallesBitacora.getActividades().stream()
                        .map(ActividadMapper::toDTO)
                        .collect(Collectors.toList()),
                BitacoraMapper.toDTO(detallesBitacora.getBitacora())
        );
    }

    public static DetallesBitacora toEntity(DetallesBitacoraDTO detallesBitacoraDTO) {
        return new DetallesBitacora(
                detallesBitacoraDTO.getActividades().stream()
                        .map(ActividadMapper::toEntity)
                        .collect(Collectors.toList()),
                detallesBitacoraDTO.getMaterialesIngresados().stream()
                        .map(MaterialIngresadoMapper::toEntity)
                        .collect(Collectors.toList()),
                detallesBitacoraDTO.getHerramientasIngresadas().stream()
                        .map(HerramientaIngresadaMapper::toEntity)
                        .collect(Collectors.toList()),
                detallesBitacoraDTO.getMaquinarias().stream()
                        .map(MaquinariaMapper::toEntity)
                        .collect(Collectors.toList()),
                ListaAsistenciaMapper.toEntity(detallesBitacoraDTO.getListaAsistencia()),
                BitacoraMapper.toEntity(detallesBitacoraDTO.getBitacora())
        );
    }
}
