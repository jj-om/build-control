/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultListModel;
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
 *
 * @author rocha
 */
public class Utilities {

    public static void buscadorLista(JTextField txtBuscador, DefaultListModel<String> listModel, JScrollPane scrollPane, List<String> elementosLista, JList<String> list) {
        String textoBuscador = txtBuscador.getText().trim(); // Obtener el texto sin espacios al inicio y al final

        // Siempre actualizar la lista, mostrando todos los elementos si el campo está vacío
        actualizarLista(list, listModel, elementosLista, textoBuscador, scrollPane);
    }

    // Método generalizado para actualizar la lista de cualquier tipo de elemento (herramientas, maquinaria, materiales)
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
     * Cambia las fuentes de cada panel.
     * Hace que el aspecto sea uniforme con respecto al resto de la presentación.
     * 
     * @param panel Panel a editar el aspecto.
     * @param fuente Fuente para editar el panel.
     */
    public static void cambiarFuente(JPanel panel, Font fuente) {
        for (Component componente : panel.getComponents()) {
            componente.setFont(fuente);
        }
    }
}
