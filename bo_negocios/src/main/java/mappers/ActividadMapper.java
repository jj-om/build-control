package mappers;

import dominio.Actividad;
import dto.ActividadDTO;

/**
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class ActividadMapper {

    public static ActividadDTO toDTO(Actividad actividad){
        return new ActividadDTO(
                actividad.getTitulo(), 
                actividad.getDescripcion());
    }
    
    public static Actividad toEntity(ActividadDTO actividadDTO){
        return new Actividad(
                actividadDTO.getTituloActividad(),
                actividadDTO.getDescripcionActividad());
    }
    
}
