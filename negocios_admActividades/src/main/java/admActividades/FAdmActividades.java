package admActividades;

import dto.ActividadDTO;
import excepciones.AdmActividadesException;
import java.util.HashMap;
import java.util.List;

/**
 * Fachada para la gestión de actividades.
 * 
 * Esta clase actúa como una interfaz simplificada para la administración de actividades,
 * delegando la implementación a la clase {@code AdmActividades}.
 * Los desarrolladores pueden usar esta fachada en lugar de interactuar directamente con
 * {@code AdmActividades}, lo que mejora la modularidad y el mantenimiento del código.
 * 
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class FAdmActividades implements IAdmActividades {


    /**
     * Constructor vacío de la entidad.
     */
    public FAdmActividades() {
        
    }

    /**
     * Registra un conjunto de actividades en el sistema.
     * 
     * @param actividades Una lista que contiene las actividades a registrar.
     * @return 
     * @throws AdmActividadesException Si ocurre un error durante el registro de actividades.
     */
    @Override
    public boolean registrarActividades(List<ActividadDTO> actividades) throws AdmActividadesException {
        return true;
    }
}
