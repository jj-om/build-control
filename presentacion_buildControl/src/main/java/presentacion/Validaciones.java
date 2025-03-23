/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

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
}
