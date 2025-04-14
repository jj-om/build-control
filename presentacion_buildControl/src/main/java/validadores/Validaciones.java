/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadores;

import java.time.LocalTime;

/**
 * Clase Validaciones
 *
 * Clase utilitaria que proporciona métodos estáticos para validar diferentes
 * tipos de datos en la capa de presentación.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Validaciones {

    /**
     * Expresión regular que verifica que un texto contenga al menos una letra.
     * Acepta letras incluyendo acentos, diéresis y ñ. Se utiliza para
     * garantizar que los campos de texto no estén compuestos únicamente de
     * números o caracteres especiales.
     */
    private static final String REGEX_VALIDO = ".*[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ].*";

    /**
     * Valida los datos de una actividad.
     *
     * Verifica que tanto el título como la descripción de una actividad no
     * estén vacíos y contengan al menos una letra.
     *
     * @param titulo El título de la actividad a validar
     * @param descripcion La descripción de la actividad a validar
     * @return Un mensaje de error si la validación falla, o null si es correcta
     */
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

    /**
     * Valida los horarios de entrada y salida del personal.
     *
     * Verifica que las horas de entrada y salida estén presentes y que la hora
     * de salida sea posterior a la hora de entrada, garantizando la integridad
     * temporal de los registros de asistencia.
     *
     * @param horaEntrada La hora de entrada a validar
     * @param horaSalida La hora de salida a validar
     * @param nombre El nombre del trabajador
     * @return Un mensaje de error si la validación falla, o null si es correcta
     */
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
