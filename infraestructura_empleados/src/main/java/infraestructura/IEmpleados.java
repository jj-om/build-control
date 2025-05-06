/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura;

import excepciones.InfraestructuraEmpleadosException;
import excepciones.ObraSinPersonalException;
import java.util.List;

/**
 * Interfaz que define el contrato para la administración del personal mediante
 * el sistema externo.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public interface IEmpleados {

    /**
     * Obtiene una lista con los nombres del personal asignado a una obra.
     *
     * @param idObra ID de la obra cuya información de personal se desea
     * consultar.
     * @return Lista de nombres de empleados asignados a la obra.
     * @throws InfraestructuraEmpleadosException Si ocurre un problema al
     * acceder al servicio externo.
     * @throws ObraSinPersonalException Si no hay personal asignado a la obra
     * (por ejemplo, error 404).
     */
    public List<String> obtenerPersonalObra(Long idObra) throws InfraestructuraEmpleadosException, ObraSinPersonalException;
}
