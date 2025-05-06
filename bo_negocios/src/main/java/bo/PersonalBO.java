/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import excepciones.BOException;
import excepciones.InfraestructuraEmpleadosException;
import excepciones.ObraSinPersonalException;
import infraestructura.FEmpleados;
import infraestructura.IEmpleados;
import java.util.List;

/**
 * Clase PersonalBO
 *
 * Objeto de negocio (Business Object) que gestiona la lógica relacionada con el
 * personal en el sistema. Esta clase implementa el patrón
 * Singleton para garantizar una única instancia en toda la aplicación.
 * 
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class PersonalBO {
    
    /**
     * Instancia única de la clase (patrón Singleton). Garantiza que solo exista
     * una instancia en toda la aplicación.
     */
    private static PersonalBO instance;
    private IEmpleados sistemaEmpleados;

    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    private PersonalBO() {
        this.sistemaEmpleados = new FEmpleados();
    }

    /**
     * Método para obtener la instancia única de PersonalBO (patrón Singleton).
     * Si no existe una instancia, la crea; de lo contrario, devuelve la
     * existente.
     *
     * @return La instancia única de PersonalBO
     */
    public static PersonalBO getInstance() {
        if (instance == null) {
            instance = new PersonalBO();
        }
        return instance;
    }

    /**
     * Obtiene la lista de personal asignado a una obra específica.
     *
     * En la implementación actual, retorna una lista de prueba con nombres
     * predefinidos, pero en una versión completa debería consultar la base de
     * datos para obtener el personal realmente asignado a la obra.
     *
     * @param idObra Identificador de la obra para la cual se busca el personal
     * @return Lista de nombres del personal asignado a la obra
     * @throws BOException Si ocurre un error durante la obtención de datos del
     * personal
     * @throws excepciones.ObraSinPersonalException
     */
    public List<String> obtenerPersonalObra(Long idObra) throws BOException, ObraSinPersonalException {
        try {
            return sistemaEmpleados.obtenerPersonalObra(idObra);
        } catch (InfraestructuraEmpleadosException e) {
            throw new BOException("Error al intentar obtener el personal de la obra.", e);
        }
    }
}
