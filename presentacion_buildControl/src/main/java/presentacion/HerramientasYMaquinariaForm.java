/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.HerramientaDTO;
import utilities.Utilities;
import dto.HerramientaIngresadaDTO;
import dto.MaquinariaDTO;
import exception.PresentacionException;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Clase HerramientasYMaquinariaForm
 *
 * Formulario de la capa de presentación para el registro de herramientas y
 * maquinaria en el sistema BuildControl. 
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class HerramientasYMaquinariaForm extends javax.swing.JFrame {
    
    /**
     * Referencia al coordinador de aplicación. Permite la navegación entre los
     * distintos formularios del sistema.
     */
    private CoordinadorAplicacion coordinador;
    
    /**
     * Referencia al coordinador de negocio. Proporciona acceso a la lógica de
     * negocio para el registro de herramientas y maquinaria.
     */
    private CoordinadorNegocio coordinadorNegocio;
    
    /**
     * Modelo de tabla para la gestión de herramientas. Almacena las
     * herramientas seleccionadas y sus cantidades.
     */
    private DefaultTableModel tableModelHerramienta;
    
    /**
     * Ordenador de filas para la tabla de herramientas. Proporciona capacidades
     * de filtrado para la tabla.
     */
    private TableRowSorter<DefaultTableModel> tableSorterHerramienta; // Filtro para la tabla
    
    /**
     * Modelo de lista para la búsqueda de herramientas. Gestiona la lista
     * desplegable con las herramientas disponibles.
     */
    private DefaultListModel<String> listModelHerramienta; // Modelo para la lista
    
    /**
     * Modelo de tabla para la gestión de maquinaria. Almacena la maquinaria
     * seleccionada y su estado.
     */
    private DefaultTableModel tableModelMaquinaria;
    
    /**
     * Ordenador de filas para la tabla de maquinaria. Proporciona capacidades
     * de filtrado para la tabla.
     */
    private TableRowSorter<DefaultTableModel> tableSorterMaquinaria; // Filtro para la tabla
    
    /**
     * Modelo de lista para la búsqueda de maquinaria. Gestiona la lista
     * desplegable con la maquinaria disponible.
     */
    private DefaultListModel<String> listModelMaquinaria; // Modelo para la lista
    
    /**
     * Lista de todas las herramientas disponibles en el sistema. Catálogo
     * completo obtenido del coordinador de negocio.
     */
    List<HerramientaDTO> herramientas;
    
    /**
     * Lista con los nombres de todas las herramientas disponibles. Facilita la
     * búsqueda por nombre en la interfaz.
     */
    List<String> nombresHerramientas; // Obtiene el nombre de las herramientas
    
    /**
     * Lista de toda la maquinaria disponible en el sistema. Catálogo completo
     * obtenido del coordinador de negocio.
     */
    List<MaquinariaDTO> maquinarias;
    
    /**
     * Lista con los nombres de toda la maquinaria disponible. Facilita la
     * búsqueda por nombre en la interfaz.
     */
    List<String> nombresMaquinarias;

    /**
     * Constructor del formulario de herramientas y maquinaria.
     *
     * Inicializa los componentes gráficos, configura las tablas, listas y
     * modelo de datos, y establece la conexión con los coordinadores de la
     * aplicación.
     */
    public HerramientasYMaquinariaForm() {
        initComponents();
        getContentPane().setBackground(java.awt.Color.WHITE);
        this.setLocationRelativeTo(null);
        this.coordinador = CoordinadorAplicacion.getInstancia();
        this.coordinadorNegocio = CoordinadorNegocio.getInstance();

        listModelHerramienta = new DefaultListModel<>();
        listBuscadorH.setModel(listModelHerramienta);

        tableModelHerramienta = new DefaultTableModel(new Object[]{"Herramienta", "-", "Cantidad", "+"}, 0);
        tblHerramientas.setModel(tableModelHerramienta);
        tblHerramientas.setDefaultEditor(Object.class, null);
        tableSorterHerramienta = new TableRowSorter<>(tableModelHerramienta);
        tblHerramientas.setRowSorter(tableSorterHerramienta);
        tblHerramientas.getColumnModel().getColumn(1).setCellRenderer(new HerramientasYMaquinariaForm.ButtonRenderer());
        tblHerramientas.getColumnModel().getColumn(3).setCellRenderer(new HerramientasYMaquinariaForm.ButtonRenderer());
        tblHerramientas.getColumnModel().getColumn(1).setCellEditor(new HerramientasYMaquinariaForm.ButtonEditor(new JCheckBox(), false, tableModelHerramienta, true));
        tblHerramientas.getColumnModel().getColumn(3).setCellEditor(new HerramientasYMaquinariaForm.ButtonEditor(new JCheckBox(), true, tableModelHerramienta, true));

        listModelMaquinaria = new DefaultListModel<>();
        listBuscadorM.setModel(listModelMaquinaria);

        tableModelMaquinaria = new DefaultTableModel(new Object[]{"Maquinaria", "-", "Status"}, 0);
        tblMaquinaria.setModel(tableModelMaquinaria);
        tblMaquinaria.setDefaultEditor(Object.class, null);
        tableSorterMaquinaria = new TableRowSorter<>(tableModelMaquinaria);
        tblMaquinaria.setRowSorter(tableSorterMaquinaria);
        tblMaquinaria.getColumnModel().getColumn(1).setCellRenderer(new HerramientasYMaquinariaForm.ButtonRenderer());
        tblMaquinaria.getColumnModel().getColumn(1).setCellEditor(new HerramientasYMaquinariaForm.ButtonEditor(new JCheckBox(), false, tableModelMaquinaria, false));
        campoNombreObra.setText(coordinadorNegocio.obtenerDireccionObra());

        cargarListas();
        buscadorListaHerramientas();
        buscadorListaMaquinaria();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreEmpresa = new javax.swing.JLabel();
        registraHyM = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMaquinaria = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHerramientas = new javax.swing.JTable();
        registraHyM1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscadorListaH = new javax.swing.JTextField();
        jScrollPaneH = new javax.swing.JScrollPane();
        listBuscadorH = new javax.swing.JList<>();
        txtBuscadorListaM = new javax.swing.JTextField();
        jScrollPaneM = new javax.swing.JScrollPane();
        listBuscadorM = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        txtFiltroTablaH = new javax.swing.JTextField();
        txtFiltroTablaM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoNombreObra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        nombreEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        nombreEmpresa.setText("BuildControl");

        registraHyM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registraHyM.setText("Registrar Herramientas");

        btnAtras.setBackground(new java.awt.Color(95, 168, 211));
        btnAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atrás");
        btnAtras.setBorderPainted(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnSiguiente.setBackground(new java.awt.Color(95, 168, 211));
        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        tblMaquinaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Maquinaria", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMaquinaria.setRowSelectionAllowed(false);
        tblMaquinaria.getTableHeader().setResizingAllowed(false);
        tblMaquinaria.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblMaquinaria);

        tblHerramientas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Herramienta ", "-", "Cantidad", "+"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHerramientas.setRowSelectionAllowed(false);
        tblHerramientas.getTableHeader().setResizingAllowed(false);
        tblHerramientas.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblHerramientas);

        registraHyM1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registraHyM1.setText("Registrar Maquinaria");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ingresa el nombre de la herramienta:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ingresa el nombre de la maquinaria:");

        txtBuscadorListaH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscadorListaH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorListaHKeyReleased(evt);
            }
        });

        listBuscadorH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listBuscadorH.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listBuscadorH.setVisibleRowCount(5);
        listBuscadorH.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listBuscadorHValueChanged(evt);
            }
        });
        jScrollPaneH.setViewportView(listBuscadorH);

        txtBuscadorListaM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscadorListaM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorListaMKeyReleased(evt);
            }
        });

        listBuscadorM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listBuscadorM.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listBuscadorM.setVisibleRowCount(5);
        listBuscadorM.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listBuscadorMValueChanged(evt);
            }
        });
        jScrollPaneM.setViewportView(listBuscadorM);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Filtrar por nombre de herramienta:");

        txtFiltroTablaH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFiltroTablaH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroTablaHKeyReleased(evt);
            }
        });

        txtFiltroTablaM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFiltroTablaM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroTablaMKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Filtrar por nombre de maquinaria:");

        campoNombreObra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        campoNombreObra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoNombreObra.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneM, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneH, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registraHyM)
                    .addComponent(txtBuscadorListaM, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(registraHyM1)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscadorListaH, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtFiltroTablaH, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFiltroTablaM, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(campoNombreObra, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreEmpresa)
                    .addComponent(campoNombreObra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(registraHyM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorListaH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroTablaH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registraHyM1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroTablaM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscadorListaM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Atrás". Regresa al formulario
     * anterior del flujo de trabajo.
     *
     * @param evt Evento de acción que desencadenó este método
     */
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
            atras();
    }//GEN-LAST:event_btnAtrasActionPerformed

    /**
     * Maneja el evento de clic en el botón "Siguiente". Avanza al siguiente
     * formulario del flujo de trabajo.
     *
     * @param evt Evento de acción que desencadenó este método
     */
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguiente();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    /**
     * Maneja el evento de liberación de tecla en el campo de búsqueda de
     * herramientas. Actualiza la lista de herramientas según el texto
     * ingresado.
     *
     * @param evt Evento de teclado que desencadenó este método
     */
    private void txtBuscadorListaHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorListaHKeyReleased
        buscadorListaHerramientas();
    }//GEN-LAST:event_txtBuscadorListaHKeyReleased

    /**
     * Maneja el evento de cambio de selección en la lista de herramientas.
     * Agrega la herramienta seleccionada a la tabla.
     *
     * @param evt Evento de selección que desencadenó este método
     */
    private void listBuscadorHValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listBuscadorHValueChanged
        seleccionarHerramientaLista(evt);
    }//GEN-LAST:event_listBuscadorHValueChanged

    /**
     * Maneja el evento de liberación de tecla en el campo de búsqueda de
     * maquinaria. Actualiza la lista de maquinaria según el texto ingresado.
     *
     * @param evt Evento de teclado que desencadenó este método
     */
    private void txtBuscadorListaMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorListaMKeyReleased
        buscadorListaMaquinaria();
    }//GEN-LAST:event_txtBuscadorListaMKeyReleased

    /**
     * Maneja el evento de cambio de selección en la lista de maquinaria. Agrega
     * la maquinaria seleccionada a la tabla.
     *
     * @param evt Evento de selección que desencadenó este método
     */
    private void listBuscadorMValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listBuscadorMValueChanged
        seleccionarMaquinariaLista(evt);
    }//GEN-LAST:event_listBuscadorMValueChanged

    /**
     * Maneja el evento de liberación de tecla en el campo de filtro de tabla de
     * herramientas. Filtra las filas de la tabla según el texto ingresado.
     *
     * @param evt Evento de teclado que desencadenó este método
     */
    private void txtFiltroTablaHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroTablaHKeyReleased
        filtrarTablaHerramientas();
    }//GEN-LAST:event_txtFiltroTablaHKeyReleased

    /**
     * Maneja el evento de liberación de tecla en el campo de filtro de tabla de
     * maquinaria. Filtra las filas de la tabla según el texto ingresado.
     *
     * @param evt Evento de teclado que desencadenó este método
     */
    private void txtFiltroTablaMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroTablaMKeyReleased
        filtrarTablaMaquinaria();
    }//GEN-LAST:event_txtFiltroTablaMKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    /**
     * Clase interna que implementa un renderizador personalizado para los
     * botones en las tablas. Permite mostrar botones dentro de las celdas de
     * tabla para incrementar o decrementar cantidades.
     */
    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {

        /**
         * Constructor del renderizador de botones. Configura las propiedades
         * básicas del componente.
         */
        public ButtonRenderer() {
            setOpaque(true); // que no sea transparente
        }

        /**
         * Implementación del método de la interfaz TableCellRenderer. Configura
         * y devuelve el componente que se mostrará en la celda.
         *
         * @return El botón configurado para mostrarse en la celda
         */
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Asigna el texto del botón, si es null asigna un texto vacío
            setText((value == null) ? "" : value.toString());
            // Devuelve el botón para mostrarlo en la celda
            return this;
        }
    }
    
    /**
     * Clase interna que implementa un editor personalizado para los botones en
     * las tablas. Gestiona la interacción con los botones de
     * incremento/decremento y eliminación.
     */
    class ButtonEditor extends DefaultCellEditor {

        
        /**
         * Botón que se mostrará en la celda.
         */
        private JButton button;

        /**
         * Indica si el botón es para incrementar (true) o decrementar/eliminar
         * (false).
         */
        private boolean isIncrement;

        /**
         * Índice de la fila que contiene el botón.
         */
        private int row;

        /**
         * Modelo de tabla al que pertenece el botón.
         */
        private DefaultTableModel tableModel;

        /**
         * Indica si el botón pertenece a la tabla de herramientas (true) o
         * maquinaria (false).
         */
        private boolean esHerramienta;  // Para determinar qué lista actualizar

        /**
         * Constructor del editor de botones.
         *
         * @param checkBox Componente base para el editor (requerido por
         * DefaultCellEditor)
         * @param isIncrement Indica si el botón incrementa (true) o
         * decrementa/elimina (false)
         * @param tableModel Modelo de tabla al que pertenece
         * @param esHerramienta Indica si es para tabla de herramientas o
         * maquinaria
         */
        public ButtonEditor(JCheckBox checkBox, boolean isIncrement, DefaultTableModel tableModel, boolean esHerramienta) {
            super(checkBox);
            this.isIncrement = isIncrement;
            this.tableModel = tableModel;
            this.esHerramienta = esHerramienta; // Guardamos si es para herramientas o maquinaria

            // Crear el botón con el texto "+" o "-" dependiendo del tipo
            this.button = new JButton(isIncrement ? "+" : "-");
            button.setOpaque(true);

            // Acción al hacer clic en el botón
            button.addActionListener(e -> {
                if (esHerramienta) {
                    // Si es herramienta, manejamos las cantidades
                    int cantidad = (int) tableModel.getValueAt(row, 2);
                    if (isIncrement) {
                        // Incrementar la cantidad
                        tableModel.setValueAt(cantidad + 1, row, 2);
                    } else if (cantidad > 1) {
                        // Decrementar la cantidad
                        tableModel.setValueAt(cantidad - 1, row, 2);
                    } else {
                        // Eliminarlo si llega a 0
                        tableModel.removeRow(row);
                        actualizarListaHerramientas(txtBuscadorListaH.getText().trim());
                    }
                } else {
                    // Si es maquinaria, solo eliminamos la fila
                    tableModel.removeRow(row);
                    actualizarListaMaquinaria(txtBuscadorListaM.getText().trim());
                }
            });

        }

        /**
         * Implementación del método para obtener el componente de edición.
         *
         * @return El botón configurado como componente de edición
         */
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            return button; // Mostrar el JButton como el componente de edición
        }

        /**
         * Implementación del método para obtener el valor de la celda.
         *
         * @return El símbolo correspondiente al tipo de botón
         */
        @Override
        public Object getCellEditorValue() {
            return isIncrement ? "+" : "-"; // Retornar el símbolo correcto
        }
    }

    // Comportamiento del buscador de herramientas
    /**
     * Actualiza la lista de herramientas según el texto en el buscador. Utiliza
     * la clase utilitaria para gestionar el filtrado.
     */
    private void buscadorListaHerramientas() {
        Utilities.buscadorLista(txtBuscadorListaH, listModelHerramienta, jScrollPaneH, nombresHerramientas, listBuscadorH);
    }

    // Filtrar y actualizar la lista de materiales
    /**
     * Actualiza la lista de herramientas disponibles para la selección.
     *
     * @param textoBuscador Texto para filtrar la lista
     */
    private void actualizarListaHerramientas(String textoBuscador) {
        Utilities.actualizarLista(listBuscadorH, listModelHerramienta, nombresHerramientas, textoBuscador, jScrollPaneH);
    }
    
    /**
     * Procesa la selección de una herramienta en la lista.
     *
     * @param evt Evento de selección que contiene la información de la
     * herramienta seleccionada
     */
    private void seleccionarHerramientaLista(ListSelectionEvent evt) {
        Utilities.seleccionarElementoLista(evt, listBuscadorH, tableModelHerramienta, false);
    }
    
    /**
     * Aplica un filtro a la tabla de herramientas. Muestra solo las filas que
     * coinciden con el texto ingresado.
     */
    private void filtrarTablaHerramientas() {
        Utilities.filtrarTabla(tblHerramientas, tableSorterHerramienta, txtFiltroTablaH);
    }
    
    /**
     * Actualiza la lista de maquinaria según el texto en el buscador. Utiliza
     * la clase utilitaria para gestionar el filtrado.
     */
    private void buscadorListaMaquinaria() {
        Utilities.buscadorLista(txtBuscadorListaM, listModelMaquinaria, jScrollPaneM, nombresMaquinarias, listBuscadorM);
    }

    // Filtrar y actualizar la lista de materiales
    /**
     * Actualiza la lista de maquinaria disponible para la selección.
     *
     * @param textoBuscador Texto para filtrar la lista
     */
    private void actualizarListaMaquinaria(String textoBuscador) {
        Utilities.actualizarLista(listBuscadorM, listModelMaquinaria, nombresMaquinarias, textoBuscador, jScrollPaneM);
    }
    
    /**
     * Procesa la selección de una maquinaria en la lista.
     *
     * @param evt Evento de selección que contiene la información de la
     * maquinaria seleccionada
     */
    private void seleccionarMaquinariaLista(ListSelectionEvent evt) {
        Utilities.seleccionarElementoLista(evt, listBuscadorM, tableModelMaquinaria, true);
    }
    
    /**
     * Aplica un filtro a la tabla de maquinaria. Muestra solo las filas que
     * coinciden con el texto ingresado.
     */
    private void filtrarTablaMaquinaria() {
        Utilities.filtrarTabla(tblMaquinaria, tableSorterMaquinaria, txtFiltroTablaM);
    }
    
    /**
     * Recopila las herramientas seleccionadas en la tabla y crea los DTOs
     * correspondientes.
     *
     * @return Lista de HerramientaIngresadaDTO con las herramientas y sus
     * cantidades
     */
    private List<HerramientaIngresadaDTO> obtenerHerramientasIngresadas() {
        List<HerramientaIngresadaDTO> herramientasIngresadas = null;

        // Recorrer las filas de la tabla
        for (int i = 0; i < tableModelHerramienta.getRowCount(); i++) {
            herramientasIngresadas = new ArrayList<>();
            String nombreHerramienta = (String) tableModelHerramienta.getValueAt(i, 0); // Nombre de la herramienta
            Integer cantidad = (Integer) tableModelHerramienta.getValueAt(i, 2);
            // Buscar el objeto HerramientaDTO correspondiente al nombre
            HerramientaDTO herramientaDTO = buscarHerramientaPorNombre(nombreHerramienta);

            if (herramientaDTO != null) {
                // Crear el DTO con la herramienta y la cantidad
                HerramientaIngresadaDTO herramientaIngresadaDTO = new HerramientaIngresadaDTO(herramientaDTO, cantidad);
                herramientasIngresadas.add(herramientaIngresadaDTO);
            }
        }

        return herramientasIngresadas;
    }
    
    /**
     * Busca una herramienta en el catálogo por su nombre.
     *
     * @param nombre Nombre de la herramienta a buscar
     * @return Objeto HerramientaDTO correspondiente o null si no se encuentra
     */
    private HerramientaDTO buscarHerramientaPorNombre(String nombre) {
        for (HerramientaDTO herramienta : herramientas) {
            if (herramienta.getNombre().equalsIgnoreCase(nombre)) {
                return herramienta;
            }
        }
        return null; // Si no se encuentra, retorna null
    }
    
    /**
     * Recopila la maquinaria seleccionada en la tabla y crea los DTOs
     * correspondientes.
     *
     * @return Lista de MaquinariaDTO con la maquinaria seleccionada
     */
    private List<MaquinariaDTO> obtenerMaquinariaSeleccionada() {
        List<MaquinariaDTO> maquinariaIngresada = null;

        for (int i = 0; i < tableModelMaquinaria.getRowCount(); i++) {
            maquinariaIngresada = new ArrayList<>();
            String nombreMaquinaria = (String) tableModelMaquinaria.getValueAt(i, 0);

            MaquinariaDTO maquinariaDTO = buscarMaquinariaPorNombre(nombreMaquinaria);
            if (maquinariaDTO != null) {
                maquinariaIngresada.add(maquinariaDTO);
            }
        }

        return maquinariaIngresada;
    }
    
    /**
     * Busca una maquinaria en el catálogo por su nombre.
     *
     * @param nombre Nombre de la maquinaria a buscar
     * @return Objeto MaquinariaDTO correspondiente o null si no se encuentra
     */
    private MaquinariaDTO buscarMaquinariaPorNombre(String nombre) {
        for (MaquinariaDTO maquinaria : maquinarias) {
            if (maquinaria.getNombre().equalsIgnoreCase(nombre)) {
                return maquinaria;
            }
        }
        return null; // Si no se encuentra, retorna null
    }
    
    /**
     * Extrae los nombres de todas las herramientas disponibles.
     *
     * @return Lista con los nombres de las herramientas
     */
    private List<String> obtenerNombresHerramientas() {
        List<String> nombres = new ArrayList<>();
        for (HerramientaDTO herramienta : herramientas) {
            nombres.add(herramienta.getNombre());
        }

        return nombres;
    }
    
    /**
     * Extrae los nombres de toda la maquinaria disponible.
     *
     * @return Lista con los nombres de la maquinaria
     */
    private List<String> obtenerNombresMaquinarias() {
        List<String> nombres = new ArrayList<>();
        for (MaquinariaDTO maquinaria : maquinarias) {
            nombres.add(maquinaria.getNombre());
        }

        return nombres;
    }
    
    /**
     * Carga las listas de herramientas y maquinaria desde el coordinador de
     * negocio. Inicializa las listas de nombres para la búsqueda.
     */
    private void cargarListas() {
        try {
            this.herramientas = coordinadorNegocio.obtenerHerramientas();
            this.maquinarias = coordinadorNegocio.obtenerMaquinaria();
            this.nombresHerramientas = obtenerNombresHerramientas();
            this.nombresMaquinarias = obtenerNombresMaquinarias();
        } catch (PresentacionException ex) {
            Logger.getLogger(HerramientasYMaquinariaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gestiona la transición al siguiente formulario en el flujo de trabajo.
     *
     * Verifica que se haya seleccionado al menos una herramienta o maquinaria,
     * registra formalmente las selecciones en el sistema y avanza al formulario
     * de personal.
     */
    private void siguiente() {
        if (tblHerramientas.getRowCount() == 0 || tblMaquinaria.getRowCount() == 0) {
            int opcion = JOptionPane.showConfirmDialog(this,
                    "No se han registrado herramientas o maquinaria, ¿Seguro que desea continuar?",
                    "Confirmar salida", JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) {
                return;
            }
        } else {
            try {
                List<HerramientaIngresadaDTO> herramientaIngresada = obtenerHerramientasIngresadas();
                List<MaquinariaDTO> maquinariaIngresada = obtenerMaquinariaSeleccionada();
                coordinadorNegocio.registrarHerramientas(herramientaIngresada);
                coordinadorNegocio.registrarMaquinaria(maquinariaIngresada);
            } catch (PresentacionException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
                coordinadorNegocio.reset();
                coordinador.mostrarObraSeleccionada();
                coordinador.reset();
                return;
            }
        }

        this.dispose();
        coordinador.mostrarPersonal();
    }
    
    /**
     * Gestiona el retorno al formulario anterior en el flujo de trabajo. Cierra
     * este formulario y muestra el de materiales.
     */

    private void atras(){
        this.dispose();
        coordinador.mostrarMateriales();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JTextField campoNombreObra;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPaneH;
    private javax.swing.JScrollPane jScrollPaneM;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> listBuscadorH;
    private javax.swing.JList<String> listBuscadorM;
    private javax.swing.JLabel nombreEmpresa;
    private javax.swing.JLabel registraHyM;
    private javax.swing.JLabel registraHyM1;
    private javax.swing.JTable tblHerramientas;
    private javax.swing.JTable tblMaquinaria;
    private javax.swing.JTextField txtBuscadorListaH;
    private javax.swing.JTextField txtBuscadorListaM;
    private javax.swing.JTextField txtFiltroTablaH;
    private javax.swing.JTextField txtFiltroTablaM;
    // End of variables declaration//GEN-END:variables
}
