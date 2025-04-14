/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadores;

import exception.DatosInvalidosException;
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
     * @throws exception.DatosInvalidosException Excepción si algo sale mal.
     */
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
     * @throws exception.DatosInvalidosException Excepción si algo sale mal.
     */
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
