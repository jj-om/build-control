/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author alega
 */
public class CoordinadorAplicacion {
    
    // Hacer una instancia ÚNICA 
    private static CoordinadorAplicacion coordinador;
    
    // Forms
    private ObraSeleccionadaForm obraSeleccionadaForm;
    private ActividadesForm actividadesForm;
    private MaterialesForm materialesForm;
    private HerramientasYMaquinariaForm hymForm;
    private PersonalForm personalForm;

    private CoordinadorAplicacion() {
    }
    
    // Método para obtener una única instancia
    public static CoordinadorAplicacion getInstancia() {
        if (coordinador == null) {
            coordinador = new CoordinadorAplicacion();
        }
        return coordinador;
    }
    
    // Métodos para mostrar las pantallas
    public void mostrarObraSeleccionada() {
        if (obraSeleccionadaForm == null) {
            obraSeleccionadaForm = new ObraSeleccionadaForm(this);
        }
        obraSeleccionadaForm.setVisible(true);
    }

    public void mostrarActividades() {
        if (actividadesForm == null) {
            actividadesForm = new ActividadesForm(this);
        }
        actividadesForm.setVisible(true);
    }

    public void mostrarMateriales() {
        if (materialesForm == null) {
            materialesForm = new MaterialesForm(this);
        }
        materialesForm.setVisible(true);
    }

    public void mostrarHerramientasYMaquinaria() {
        if (hymForm == null) {
            hymForm = new HerramientasYMaquinariaForm(this);
        }
        hymForm.setVisible(true);
    }

    public void mostrarPersonal() {
        if (personalForm == null) {
            personalForm = new PersonalForm(this);
        }
        personalForm.setVisible(true);
    }
    
    public void reset() {
        if (actividadesForm != null) actividadesForm = null;
        if (materialesForm != null) materialesForm = null;
        if (hymForm != null) hymForm = null;
        if (personalForm != null) personalForm = null;
    }
}