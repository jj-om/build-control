/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Clase Utilities
 *
 * Clase utilitaria que proporciona métodos estáticos para facilitar operaciones
 * comunes en la interfaz de usuario del sistema. Centraliza funcionalidades
 * reutilizables relacionadas con componentes gráficos Swing.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class Utilities {

    /**
     * Actualiza una lista de elementos según el texto introducido en un
     * buscador.
     *
     * Este método filtra y muestra los elementos de una lista que coinciden con
     * el texto ingresado en un campo de búsqueda, actualizando la visibilidad
     * del componente según haya o no resultados.
     *
     * @param txtBuscador Campo de texto donde el usuario ingresa el criterio de
     * búsqueda
     * @param listModel Modelo de lista que contiene los elementos a mostrar
     * @param scrollPane Panel de desplazamiento que contiene la lista
     * @param elementosLista Lista completa de elementos disponibles para
     * filtrar
     * @param list Componente JList que muestra los elementos
     */
    public static void buscadorLista(JTextField txtBuscador, DefaultListModel<String> listModel, JScrollPane scrollPane, List<String> elementosLista, JList<String> list) {
        String textoBuscador = txtBuscador.getText().trim(); // Obtener el texto sin espacios al inicio y al final

        // Siempre actualizar la lista, mostrando todos los elementos si el campo está vacío
        actualizarLista(list, listModel, elementosLista, textoBuscador, scrollPane);
    }

    /**
     * Actualiza una lista de elementos basado en un criterio de búsqueda.
     *
     * Método generalizado que puede ser utilizado para filtrar cualquier tipo
     * de lista (herramientas, maquinaria, materiales) según un texto de
     * búsqueda, controlando también la visibilidad del componente contenedor.
     *
     * @param list Componente JList que muestra los elementos
     * @param listModel Modelo de lista a actualizar
     * @param elementos Lista completa de elementos disponibles para filtrar
     * @param textoBuscador Texto ingresado como criterio de búsqueda
     * @param scrollPane Panel de desplazamiento cuya visibilidad será
     * controlada
     */
    public static void actualizarLista(JList<String> list, DefaultListModel<String> listModel, List<String> elementos, String textoBuscador, JScrollPane scrollPane) {
        listModel.clear(); // Limpiar la lista

        // Filtrar y agregar solo los elementos que coinciden con el texto de búsqueda
        if (textoBuscador.isBlank()) {
            // Si el texto está vacío, mostrar todos los elementos
            elementos.forEach(listModel::addElement);
        } else {
            // Filtrar y agregar solo los que coinciden con el texto de búsqueda
            elementos.stream()
                    .filter(elemento -> elemento.toLowerCase().contains(textoBuscador.toLowerCase()))
                    .forEach(listModel::addElement);
        }

        list.setModel(listModel); // Actualizar el modelo de la lista

        // Verificar si hay elementos en la lista
        if (listModel.getSize() > 0) {
            // Si hay resultados, mostrar el JScrollPane
            scrollPane.setVisible(true);
        } else {
            // Si no hay resultados, ocultar el JScrollPane
            scrollPane.setVisible(false);
        }
    }

    /**
     * Gestiona la selección de un elemento en una lista para agregarlo a una
     * tabla.
     *
     * Este método se utiliza cuando el usuario selecciona un elemento de una
     * lista desplegable (como herramientas, materiales o maquinaria) para
     * agregarlo a la tabla de elementos seleccionados, verificando que no
     * exista duplicidad.
     *
     * @param evt Evento de selección en la lista
     * @param lista Lista donde se realiza la selección
     * @param tableModel Modelo de tabla donde se agregará el elemento
     * seleccionado
     * @param esMaquinaria Bandera que indica si se trata de maquinaria (con
     * comportamiento específico)
     */
    public static void seleccionarElementoLista(ListSelectionEvent evt, JList<String> lista, DefaultTableModel tableModel, boolean esMaquinaria) {
        if (evt.getValueIsAdjusting()) {
            return;
        }

        String elementoSeleccionado = lista.getSelectedValue();
        if (elementoSeleccionado == null || elementoSeleccionado.isEmpty()) {
            return;
        }

        // Buscar el elemento en la tabla y actualizar
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(elementoSeleccionado)) {
                return;
            }
        }

        // Si es maquinaria, agregar una nueva fila con el estatus "En uso" y un botón "-"
        if (esMaquinaria) {
            tableModel.addRow(new Object[]{elementoSeleccionado, "-", "En uso"});
        } else {
            // Si es material o herramienta
            tableModel.addRow(new Object[]{elementoSeleccionado, "-", 1, "+"});
        }
    }

    /**
     * Filtra las filas de una tabla según el texto ingresado en un campo de
     * búsqueda.
     *
     * Este método aplica un filtro de expresión regular a las filas de una
     * tabla, mostrando solo aquellas que coinciden con el criterio de búsqueda
     * en la primera columna.
     *
     * @param tabla Tabla a filtrar
     * @param tableSorter Ordenador de filas de la tabla que aplicará el filtro
     * @param txtFiltro Campo de texto con el criterio de filtrado
     */
    public static void filtrarTabla(JTable tabla, TableRowSorter tableSorter, JTextField txtFiltro) {
        String texto = txtFiltro.getText().trim();  // Obtener el texto del filtro

        // Comprobar si el campo de texto está vacío
        if (texto.isEmpty()) {
            tableSorter.setRowFilter(null);  // Mostrar todas las filas si no hay texto
        } else {
            // Aplicar el filtro con expresión regular, considerando la columna seleccionada
            tableSorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 0));
        }
    }

    /**
     * Cambia las fuentes de todos los componentes dentro del panel especificado.
     * Se aplica de forma recursiva a subcomponentes anidados para garantizar
     * uniformidad visual.
     *
     * @param componente Componente raíz (por ejemplo, un JPanel) al que se le
     *                   desea cambiar la fuente.
     * @param fuente     Fuente a aplicar.
     */
    public static void cambiarFuente(JComponent componente, Font fuente) {
        componente.setFont(fuente);
        for (Component hijo : componente.getComponents()) {
            if (hijo instanceof JComponent jComponent) {
                cambiarFuente(jComponent, fuente);
            } else {
                hijo.setFont(fuente);
            }
        }
    }
}
