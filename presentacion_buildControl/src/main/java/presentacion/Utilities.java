/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.Color;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
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
    public static void buscadorGanarFoco(JTextField textField, String placeholder) {
        if (textField.getText().equals(placeholder)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    public static void buscadorPerderFoco(JTextField textField, String placeholder) {
        if (textField.getText().isEmpty()) {
            textField.setText(placeholder);
            textField.setForeground(Color.GRAY);
        }
    }

    public static void buscadorLista(JTextField txtBuscador, DefaultListModel<String> listModel, JScrollPane scrollPane, List<String> elementosLista, JList<String> list) {
        String textoBuscador = txtBuscador.getText().trim(); // Obtener el texto sin espacios al inicio y al final

        // Siempre actualizar la lista, mostrando todos los elementos si el campo está vacío
        actualizarLista(list, listModel, elementosLista, textoBuscador);

    }

    // Método generalizado para actualizar la lista de cualquier tipo de elemento (herramientas, maquinaria, materiales)
    public static void actualizarLista(JList<String> list, DefaultListModel<String> listModel, List<String> elementos, String textoBuscador) {
        listModel.clear(); // Limpiar la lista

        // Variable estática para controlar si es la primera vez
        if (listModel.getSize() > 0) { // Comprobar si la lista está vacía
            // Solo agregar los elementos una vez
            elementos.forEach(listModel::addElement);
        }
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

        // Si no existe, agregar una nueva fila para maquinaria con el estatus "En uso" y un botón "-"
        if (esMaquinaria) {
            tableModel.addRow(new Object[]{elementoSeleccionado, "-", "En uso"});
        } else {
            // Si es herramienta, agregar el comportamiento que desees (por ejemplo, el botón "+")
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
}
