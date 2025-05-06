/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Herramienta;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del DAO para gestionar las herramientas en la base de datos.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class HerramientaDAO {
    
    /**
     * Instancia única de la clase (patrón Singleton). Garantiza que solo exista
     * una instancia en toda la aplicación.
     */
    public static HerramientaDAO instance;
    
    /**
     * Lista mock de herramientas disponibles.
     */
    private final List<Herramienta> herramientas;

    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    private HerramientaDAO() {
        this.herramientas = new ArrayList<>();
        inicializarHerramientasMock();
    }

    /**
     * Método para obtener la instancia única de HerramientaDAO (patrón
     * Singleton). Si no existe una instancia, la crea; de lo contrario,
     * devuelve la existente.
     *
     * @return La instancia única de HerramientaDAO
     */
    public static HerramientaDAO getInstance() {
        if (instance == null) {
            instance = new HerramientaDAO();
        }
        return instance;
    }
    
    /**
     * Inicializa datos de prueba para simular herramientas en la base de datos.
     */
    private void inicializarHerramientasMock() {
        Herramienta h1 = new Herramienta("Martillo", "Truper", "M-20");
        h1.setId(1L); 

        Herramienta h2 = new Herramienta("Desarmador", "Stanley", "Phillips #2");
        h2.setId(2L);

        Herramienta h3 = new Herramienta("Pinzas", "DeWalt", "Corte diagonal");
        h3.setId(3L);

        Herramienta h4 = new Herramienta("Llave inglesa", "Irwin", "Ajustable 10\"");
        h4.setId(4L);

        Herramienta h5 = new Herramienta("Nivel", "Stabila", "Láser 360°");
        h5.setId(5L);

        Herramienta h6 = new Herramienta("Cinta métrica", "Milwaukee", "25 pies");
        h6.setId(6L);

        Herramienta h7 = new Herramienta("Serrucho", "Bahco", "Dientes finos");
        h7.setId(7L);

        Herramienta h8 = new Herramienta("Taladro", "Bosch", "PSB 1800");
        h8.setId(8L);

        herramientas.add(h1);
        herramientas.add(h2);
        herramientas.add(h3);
        herramientas.add(h4);
        herramientas.add(h5);
        herramientas.add(h6);
        herramientas.add(h7);
        herramientas.add(h8);
    }
    
    public List<Herramienta> obtenerHerramientasObra(Long idObra) {
        // En esta implementación mock, simplemente devolvemos toda las herramientas disponible
        // En la implementación real tenemos que filtrar por idObra
        return new ArrayList<>(herramientas);
    } 
    
}
