/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 * Clase CoordinadorAplicacion
 *
 * Coordinador central de la capa de presentación del sistema. Implementa el
 * patrón Singleton para garantizar una única instancia en toda la aplicación y
 * el patrón Mediator para gestionar la comunicación entre los diferentes
 * formularios.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class CoordinadorAplicacion {

    /**
     * Instancia única del coordinador de aplicación (patrón Singleton).
     * Garantiza que solo exista una instancia en toda la aplicación.
     */
    private static CoordinadorAplicacion coordinador;

    // Forms
    /**
     * Formulario de selección de obra.
     */
    private ObraSeleccionadaForm obraSeleccionadaForm;

    /**
     * Formulario de registro de actividades.
     */
    private ActividadesForm actividadesForm;

    /**
     * Formulario de registro de materiales.
     */
    private MaterialesForm materialesForm;

    /**
     * Formulario de registro de herramientas y maquinaria.
     */
    private HerramientasYMaquinariaForm hymForm;

    /**
     * Formulario de registro de personal.
     */
    private PersonalForm personalForm;

    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    private CoordinadorAplicacion() {
    }

    // Método para obtener una única instancia
    /**
     * Obtiene la instancia única del coordinador de aplicación (patrón
     * Singleton). Si no existe una instancia, la crea, de lo contrario,
     * devuelve la existente.
     *
     * @return La instancia única del CoordinadorAplicacion
     */
    public static CoordinadorAplicacion getInstancia() {
        if (coordinador == null) {
            coordinador = new CoordinadorAplicacion();
        }
        return coordinador;
    }

    // Métodos para mostrar las pantallas
    /**
     * Muestra el formulario de selección de obra. Si el formulario no ha sido
     * creado previamente, lo instancia.
     */
    public void mostrarObraSeleccionada() {
        if (obraSeleccionadaForm == null) {
            obraSeleccionadaForm = new ObraSeleccionadaForm(this);
        }
        obraSeleccionadaForm.setVisible(true);
    }

    /**
     * Muestra el formulario de registro de actividades. Si el formulario no ha
     * sido creado previamente, lo instancia.
     */
    public void mostrarActividades() {
        if (actividadesForm == null) {
            actividadesForm = new ActividadesForm(this);
        }
        actividadesForm.setVisible(true);
    }

    /**
     * Muestra el formulario de registro de materiales. Si el formulario no ha
     * sido creado previamente, lo instancia.
     */
    public void mostrarMateriales() {
        if (materialesForm == null) {
            materialesForm = new MaterialesForm(this);
        }
        materialesForm.setVisible(true);
    }

    /**
     * Muestra el formulario de registro de herramientas y maquinaria. Si el
     * formulario no ha sido creado previamente, lo instancia.
     */
    public void mostrarHerramientasYMaquinaria() {
        if (hymForm == null) {
            hymForm = new HerramientasYMaquinariaForm(this);
        }
        hymForm.setVisible(true);
    }

    /**
     * Muestra el formulario de registro de personal. Si el formulario no ha
     * sido creado previamente, lo instancia.
     */
    public void mostrarPersonal() {
        if (personalForm == null) {
            personalForm = new PersonalForm(this);
        }
        personalForm.setVisible(true);
    }

    /**
     * Reinicia el estado del coordinador, liberando las referencias a los
     * formularios. Útil para limpiar recursos y preparar el sistema para un
     * nuevo ciclo de registro.
     */
    public void reset() {
        if (actividadesForm != null) {
            actividadesForm = null;
        }
        if (materialesForm != null) {
            materialesForm = null;
        }
        if (hymForm != null) {
            hymForm = null;
        }
        if (personalForm != null) {
            personalForm = null;
        }
    }
}
