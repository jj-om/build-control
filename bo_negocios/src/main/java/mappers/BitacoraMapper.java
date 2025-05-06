package mappers;

import dominio.Bitacora;
import dto.BitacoraDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 *
 */
public class BitacoraMapper {

    public static BitacoraDTO toDTO(Bitacora bitacora) {
        LocalDate fecha = bitacora.getFecha() != null
                ? bitacora.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                : null;

        return new BitacoraDTO(
                fecha,
                bitacora.getIdObra()
        );
    }

    public static Bitacora toEntity(BitacoraDTO bitacoraDTO) {
        Date fecha = bitacoraDTO.getFecha() != null
                ? Date.from(bitacoraDTO.getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant())
                : null;

        return new Bitacora(
                fecha,
                bitacoraDTO.getIdObra()
        );
    }
}
