/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Bitacora;
import dominio.DetallesBitacora;
import excepciones.DAOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementación del DAO para gestionar las bitácoras en la base de datos.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class BitacoraDAO {
    
    /**
     * Instancia única de la clase (patrón Singleton). Garantiza que solo exista
     * una instancia en toda la aplicación.
     */
    private static BitacoraDAO instance;
    
    /**
     * Lista mock de bitácoras.
     */
    private final List<Bitacora> bitacoras;
    
    /**
     * Lista mock de detalles bitácora.
     */
    private final List<DetallesBitacora> detallesBitacoras;

    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    private BitacoraDAO() {
        this.bitacoras = new ArrayList<>();
        this.detallesBitacoras = new ArrayList<>();
    }

    /**
     * Método para obtener la instancia única de BitacoraDAO (patrón Singleton).
     * Si no existe una instancia, la crea; de lo contrario, devuelve la
     * existente.
     *
     * @return La instancia única de BitacoraDAO
     */
    public static BitacoraDAO getInstance() {
        if (instance == null) {
            instance = new BitacoraDAO();
        }
        return instance;
    }
    
    /**
     * Registra una nueva bitácora en el sistema.
     *
     * @param detallesBitacora Objeto que contiene todos los componentes de la
     * bitácora
     * @return El objeto Bitacora con la información básica de la bitácora
     * registrada
     * @throws DAOException Si ocurre un error durante el registro
     */
    public Bitacora registrarBitacora(DetallesBitacora detallesBitacora) throws DAOException {
        // Asignar ID a la bitácora y a detalles bitácora
        Bitacora bitacora = detallesBitacora.getBitacora();

        // Generar IDs
        Long sigIdBitacora = (long) (bitacoras.size() + 1);
        Long sigIdDetalle = (long) (detallesBitacoras.size() + 1);

        bitacora.setId(sigIdBitacora);
        detallesBitacora.setId(sigIdDetalle);

        // Agregar a  las listas
        bitacoras.add(bitacora);
        detallesBitacoras.add(detallesBitacora);

        return bitacora;
    }
    
    /**
     * Verifica si ya existe una bitácora registrada para una obra en la fecha
     * actual.
     *
     * @param idObra Identificador de la obra a verificar
     * @return true si ya existe una bitácora para hoy, false en caso contrario
     */
    public boolean validarBitacoraRegistrada(Long idObra) {
        // Convertir LocalDate a Date 
        Date fechaActual = new Date(); // Fecha actual

        // Verificar si existe una bitácora para la obra en la fecha actual
        for (Bitacora bitacora : bitacoras) {
            if (bitacora.getIdObra().equals(idObra) && validarFecha(bitacora.getFecha(), fechaActual)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método auxiliar para comparar fechas.
     *
     * @param fecha1 Primera fecha a comparar
     * @param fecha2 Segunda fecha a comparar
     * @return true si las fechas corresponden al mismo día, false en caso
     * contrario
     */
    private boolean validarFecha(Date fecha1, Date fecha2) {
        return fecha1.getDate() == fecha2.getDate()
                && fecha1.getMonth() == fecha2.getMonth()
                && fecha1.getYear() == fecha2.getYear();
    }
    
}
