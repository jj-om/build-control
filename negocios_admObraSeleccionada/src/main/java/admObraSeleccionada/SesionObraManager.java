/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admObraSeleccionada;

/**
 * Clase que maneja la sesión de una obra en el sistema. Implementa el patrón
 * Singleton con la variante de Holder para garantizar una única instancia.
 *
 * @author rocha
 */
public class SesionObraManager {

    // Identificador único de la obra en sesión.
    private Long idObra;

    /**
     * Constructor privado para evitar instanciación directa.
     */
    private SesionObraManager() {
    }

    /**
     * Método para obtener la instancia única de SesionObraManager. Se utiliza
     * el patrón Singleton con el Holder para garantizar la inicialización
     * segura en entornos concurrentes.
     *
     * @return la única instancia de SesionObraManager.
     */
    public static SesionObraManager getInstance() {
        return SesionObraManagerHolder.INSTANCE;
    }

    /**
     * Clase estática interna que contiene la única instancia de
     * SesionObraManager. Esta estrategia garantiza la carga perezosa y la
     * seguridad en entornos multi-hilo.
     */
    private static class SesionObraManagerHolder {

        private static final SesionObraManager INSTANCE = new SesionObraManager();
    }

    /**
     * Obtiene el identificador de la obra en sesión.
     *
     * @return el ID de la obra actual, o null si no hay sesión activa.
     */
    public Long getIdObra() {
        return idObra;
    }

    /**
     * Inicia sesión con la obra especificada, almacenando su identificador.
     *
     * @param idObra Identificador de la obra que se quiere establecer en la
     * sesión.
     */
    public boolean iniciarSesion(Long idObra) {
        if (this.idObra == null) {
            this.idObra = idObra;
            return true;
        }
        return false; 
    }

    /**
     * Cierra la sesión actual, eliminando el identificador de la obra.
     */
    public void cerrarSesion() {
        this.idObra = null;
    }
}
