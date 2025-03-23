package admActividades;

import dto.ActividadDTO;
import excepciones.AdmActividadesException;
import java.util.HashMap;
import java.util.List;

/**
 * Interfaz que define la funcionalidad para administrar actividades.
 * Permite registrar actividades mediante un conjunto de pares clave-valor.
 *
 * Cada actividad se almacena en un {@code HashMap<String, String>} donde:
 * -La clave representa un identificador único de la actividad.
 * -El valor contiene la descripción o detalles de la actividad.
 *
 * En caso de que ocurra un error al registrar actividades, se lanza una excepción
 * {@code AdmActividadesException} para su manejo.
 *
 * @author Alejandra Garcia (252444)
 * @author Isabel Valenzuela (253301)
 * @author Ximena Rosales (253088)
 * @author Dario Cortez (252267)
 * @author Jesús Osuna (240549)
 */
public interface IAdmActividades {

    /**
     * Registra un conjunto de actividades en el sistema.
     *
     * @param actividades Un mapa donde las claves representan los identificadores de las actividades
     * y los valores contienen sus descripciones o detalles.
     * @return 
     * @throws AdmActividadesException Si ocurre un error durante el registro de las actividades.
     */
    public boolean registrarActividades(List<ActividadDTO> actividades) throws AdmActividadesException;
}