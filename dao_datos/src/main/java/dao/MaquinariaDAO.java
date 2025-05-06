/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Maquinaria;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del DAO para gestionar la maquinaria en la base de datos.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class MaquinariaDAO {
    
    /**
     * Instancia única de la clase (patrón Singleton). Garantiza que solo exista
     * una instancia en toda la aplicación.
     */
    public static MaquinariaDAO instance;
    
    /**
     * Lista mock de maquinaria disponible.
     */
    private final List<Maquinaria> maquinarias;

    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    private MaquinariaDAO() {
        this.maquinarias = new ArrayList<>();
        inicializarMaquinariaMock();
    }

    /**
     * Método para obtener la instancia única de MaquinariaDAO (patrón
     * Singleton). Si no existe una instancia, la crea; de lo contrario,
     * devuelve la existente.
     *
     * @return La instancia única de MaquinariaDAO
     */
    public static MaquinariaDAO getInstance() {
        if (instance == null) {
            instance = new MaquinariaDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para simular maquinaria en la base de datos.
     */
    private void inicializarMaquinariaMock() {
        Maquinaria maq1 = new Maquinaria("Excavadora", "Caterpillar", "CAT-320");
        maq1.setId(1L); 

        Maquinaria maq2 = new Maquinaria("Retroexcavadora", "John Deere", "JD-310");
        maq2.setId(2L);

        Maquinaria maq3 = new Maquinaria("Compactadora", "Wacker Neuson", "VPG-155");
        maq3.setId(3L);

        Maquinaria maq4 = new Maquinaria("Generador", "Honda", "EU70is");
        maq4.setId(4L);

        Maquinaria maq5 = new Maquinaria("Planta de luz", "Cummins", "C1500D5");
        maq5.setId(5L);

        Maquinaria maq6 = new Maquinaria("Montacargas", "Toyota", "8FGCU25");
        maq6.setId(6L);

        Maquinaria maq7 = new Maquinaria("Vibrador de concreto", "Wacker", "IREN-38");
        maq7.setId(7L);

        Maquinaria maq8 = new Maquinaria("Cortadora de concreto", "Husqvarna", "K-760");
        maq8.setId(8L);

        maquinarias.add(maq1);
        maquinarias.add(maq2);
        maquinarias.add(maq3);
        maquinarias.add(maq4);
        maquinarias.add(maq5);
        maquinarias.add(maq6);
        maquinarias.add(maq7);
        maquinarias.add(maq8);
    }
    
    /**
     * Obtiene la lista de maquinaria disponible para una obra específica.
     *
     * @param idObra Identificador de la obra para la cual se busca la
     * maquinaria
     * @return Lista de objetos Maquinaria con la maquinaria disponible
     */
    public List<Maquinaria> obtenerMaquinariaObra(Long idObra) {
        // En esta implementación mock, simplemente devolvemos toda la maquinaria disponible
        // En la implementación real tenemos que filtrar por idObra
        return new ArrayList<>(maquinarias);
    }
    
}
