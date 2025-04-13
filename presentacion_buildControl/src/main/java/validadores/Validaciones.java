/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadores;

import exception.DatosInvalidosException;
import java.time.LocalTime;

/**
 *
 * @author rocha
 */
public class Validaciones {
    // Expresión regular para validar que el texto contenga al menos una letra
    private static final String REGEX_VALIDO = ".*[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ].*";

    public static void validarActividad(String titulo, String descripcion) throws DatosInvalidosException {
        if (titulo == null || titulo.trim().isBlank()) {
            throw new DatosInvalidosException("El título de la actividad no puede estar vacío.");
        }
        
        if (!titulo.matches(REGEX_VALIDO)) {
            throw new DatosInvalidosException("El título debe contener al menos una letra.");
        }
        
        if (descripcion == null || descripcion.trim().isBlank()) {
            throw new DatosInvalidosException("La descripción de la actividad no puede estar vacía.");
        }
        
        if (!descripcion.matches(REGEX_VALIDO)) {
            throw new DatosInvalidosException("La descripción debe contener al menos una letra.");
        }
    }
    
    public static void validarHorasPersonal(LocalTime horaEntrada, LocalTime horaSalida, String nombre) throws DatosInvalidosException {
        if (horaEntrada == null || horaSalida == null) {
            throw new DatosInvalidosException("Falta llenar la hora de entrada o salida para " + (nombre != null ? nombre : "desconocido"));
        }

        // Validar que la hora de salida no sea antes que la hora de entrada
        if (horaSalida.isBefore(horaEntrada)) {
            throw new DatosInvalidosException("La hora de salida no puede ser antes de la hora de entrada para " + (nombre != null ? nombre : "desconocido"));
        }
    }
}
