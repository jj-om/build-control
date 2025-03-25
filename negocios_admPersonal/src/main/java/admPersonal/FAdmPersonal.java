/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admPersonal;

import dto.AsistenciaPersonalDTO;
import excepciones.AdmPersonalException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dario
 */
public class FAdmPersonal implements IAdmPersonal {

    public FAdmPersonal() {
    }

    @Override
    public boolean registrarAsistencia(List<AsistenciaPersonalDTO> listaAsistencia) 
            throws AdmPersonalException {
        // Mock: siempre retorna true
        boolean registroExitoso = true; // Cambiar a false para probar error
        
        if (!registroExitoso) {
            throw new AdmPersonalException("Error al registrar la asistencia del personal");
        }
        
        return true;
    }

    @Override
    public List<String> obtenerPersonal() {
        // Lista mock de personal disponible
        List<String> personal = new ArrayList<>();
        
        personal.add("Juan Pérez López");
        personal.add("María García Sánchez");
        personal.add("Carlos Martínez Rodríguez");
        personal.add("Ana López González");
        personal.add("Pedro Hernández Ramírez");
        personal.add("Laura Díaz Fernández");
        personal.add("Jorge Álvarez Gómez");
        personal.add("Sofía Ruiz Jiménez");
        
        return personal;
    }

    @Override
    public void validarHoras(LocalTime horaEntrada, LocalTime horaSalida, String nombre) 
            throws AdmPersonalException {
        // Mock: validación básica de horas
        boolean horasValidas = true; // Cambiar a false para probar validación fallida
        
        if (horaEntrada == null || horaSalida == null) {
            horasValidas = false;
        } else if (horaSalida.isBefore(horaEntrada)) {
            horasValidas = false;
        }
        
        if (!horasValidas) {
            throw new AdmPersonalException("Horas inválidas para " + nombre + 
                    ". La hora de salida debe ser posterior a la de entrada.");
        }
    }

    @Override
    public boolean registrarBitacora() throws AdmPersonalException {
        // Mock: siempre retorna true
        boolean bitacoraRegistrada = true; // Cambiar a false para probar error
        
        if (!bitacoraRegistrada) {
            throw new AdmPersonalException("Error al registrar la bitácora");
        }
        
        return true;
    }
}