/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package admPersonal;

import dto.AsistenciaPersonalDTO;
import excepciones.AdmPersonalException;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author dario 
 */
public interface IAdmPersonal {    
    /**
     * Registra la asistencia del personal en la obra.
     * 
     * @param listaAsistencia Lista de asistencia a registrar
     * @return Verdadero si se registra con éxito, falso en caso contrario
     * @throws AdmPersonalException Si ocurre un error al registrar la asistencia
     */
    boolean registrarAsistencia(List<AsistenciaPersonalDTO> listaAsistencia) throws AdmPersonalException;
    
    /**
     * Obtiene la lista de personal disponible.
     * 
     * @return Lista de nombres del personal disponible
     */
    List<String> obtenerPersonal();
    
    /**
     * Valida que las horas de entrada y salida sean coherentes.
     * 
     * @param horaEntrada Hora de entrada
     * @param horaSalida Hora de salida
     * @param nombre Nombre del empleado para mensajes de error
     * @throws AdmPersonalException Si las horas no son válidas
     */
    void validarHoras(LocalTime horaEntrada, LocalTime horaSalida, String nombre) throws AdmPersonalException;
    
    /**
     * Genera y registra la bitácora de la obra.
     * 
     * @return Verdadero si se registra con éxito, falso en caso contrario
     * @throws AdmPersonalException Si ocurre un error al generar la bitácora
     */
    boolean registrarBitacora() throws AdmPersonalException;
}