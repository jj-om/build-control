/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadores;

import java.time.LocalTime;

/**
 *
 * @author rocha
 */
public class Validaciones {
    // Expresión regular para validar que el texto contenga al menos una letra
    private static final String REGEX_VALIDO = ".*[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ].*";

    public static String validarActividad(String titulo, String descripcion) {
        if (titulo == null || titulo.trim().isBlank()) {
            return "El título de la actividad no puede estar vacío.";
        }
        
        if (!titulo.matches(REGEX_VALIDO)) {
            return "El título debe contener al menos una letra.";
        }
        
        if (descripcion == null || descripcion.trim().isBlank()) {
            return "La descripción de la actividad no puede estar vacía.";
        }
        
        if (!descripcion.matches(REGEX_VALIDO)) {
            return "La descripción debe contener al menos una letra.";
        }
                
        return null; // Retorna null si la validación es correcta
    }
    
    public static String validarHorasPersonal(LocalTime horaEntrada, LocalTime horaSalida, String nombre) {
        if (horaEntrada == null || horaSalida == null) {
            return "Falta llenar la hora de entrada o salida para " + (nombre != null ? nombre : "desconocido");
        }

        // Validar que la hora de salida no sea antes que la hora de entrada
        if (horaSalida.isBefore(horaEntrada)) {
            return "La hora de salida no puede ser antes de la hora de entrada para " + (nombre != null ? nombre : "desconocido");
        }

        return null; // Si todo es correcto, retornar null
    }
}
