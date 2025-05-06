package mappers;

import dominio.AsistenciaPersonal;
import dto.AsistenciaPersonalDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class AsistenciaPersonalMapper {

    public static AsistenciaPersonalDTO toDTO(AsistenciaPersonal asistenciaPersonal) {
        LocalTime horaEntrada = asistenciaPersonal.getHoraEntrada() != null
                ? asistenciaPersonal.getHoraEntrada().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalTime()
                : null;

        LocalTime horaSalida = asistenciaPersonal.getHoraSalida() != null
                ? asistenciaPersonal.getHoraSalida().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalTime()
                : null;

        return new AsistenciaPersonalDTO(
                asistenciaPersonal.getNombreEmpleado(),
                horaEntrada,
                horaSalida,
                asistenciaPersonal.getNotas()
        );
    }

    public static AsistenciaPersonal toEntity(AsistenciaPersonalDTO asistenciaPersonalDTO) {
        Date horaEntrada = asistenciaPersonalDTO.getHoraEntrada() != null
                ? Date.from(asistenciaPersonalDTO.getHoraEntrada()
                        .atDate(LocalDate.now())
                        .atZone(ZoneId.systemDefault())
                        .toInstant())
                : null;

        Date horaSalida = asistenciaPersonalDTO.getHoraSalida() != null
                ? Date.from(asistenciaPersonalDTO.getHoraSalida()
                        .atDate(LocalDate.now())
                        .atZone(ZoneId.systemDefault())
                        .toInstant())
                : null;

        return new AsistenciaPersonal(
                asistenciaPersonalDTO.getNombre(),
                horaEntrada,
                horaSalida,
                asistenciaPersonalDTO.getNotas()
        );
    }
}
