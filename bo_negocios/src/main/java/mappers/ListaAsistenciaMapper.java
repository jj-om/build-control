package mappers;

import dominio.Asistencia;
import dominio.AsistenciaPersonal;
import dto.AsistenciaPersonalDTO;
import dto.ListaAsistenciaDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class ListaAsistenciaMapper {

    public static ListaAsistenciaDTO toDTO(Asistencia listaAsistencia) {
        LocalDate fecha = listaAsistencia.getFecha() != null
                ? listaAsistencia.getFecha().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                : null;

        List<AsistenciaPersonalDTO> asistenciaDTOs = listaAsistencia.getAsistenciaPersonal() != null
                ? listaAsistencia.getAsistenciaPersonal().stream()
                        .map(AsistenciaPersonalMapper::toDTO)
                        .collect(Collectors.toList())
                : Collections.emptyList();

        return new ListaAsistenciaDTO(
                fecha,
                asistenciaDTOs
        );
    }

    public static Asistencia toEntity(ListaAsistenciaDTO listaAsistencia) {
        Date fecha = listaAsistencia.getFecha() != null
                ? Date.from(listaAsistencia.getFecha()
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant())
                : null;

        List<AsistenciaPersonal> asistencias = listaAsistencia.getAsistencias() != null
                ? listaAsistencia.getAsistencias().stream()
                        .map(AsistenciaPersonalMapper::toEntity)
                        .collect(Collectors.toList())
                : Collections.emptyList();

        return new Asistencia(
                fecha,
                asistencias
        );
    }

}
