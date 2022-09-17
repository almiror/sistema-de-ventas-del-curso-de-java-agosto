package vista;

import controlador.CbxComprobante;
import controlador.ControladorVentas;
import controlador.TraerDetalleComprobante;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloComprobante;
import modelo.ModeloDetalleVentas;
import modelo.ModeloVentas;
import reporte.Ticket80MM;

public class Ventas extends javax.swing.JInternalFrame {

    public static DefaultTableModel modelo;
    public static String cabecera[] = {"ID", "PRODUCTO", "PRECIO DE VENTA", "CANTIDAD", "U.M", "SUBTOTAL", "ITBIS", "TOTAL"}; // LONGITUD

    public Ventas() {
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int ancho = (int) d.getWidth();
        int alto = (int) d.getHeight() - 100;
        setSize(ancho, alto);
        setTitle("SISTEMA DE VENTAS");
        txtCliente.setEnabled(false);
        modelo = new DefaultTableModel(null, cabecera);
        listaProducto.setModel(modelo);
        listaProducto.getColumnModel().getColumn(0).setMaxWidth(0);
        listaProducto.getColumnModel().getColumn(0).setMinWidth(0);
        listaProducto.getColumnModel().getColumn(0).setPreferredWidth(0);
        listaProducto.getColumnModel().getColumn(1).setMaxWidth(300);
        listaProducto.getColumnModel().getColumn(1).setMinWidth(300);
        listaProducto.getColumnModel().getColumn(1).setPreferredWidth(300);
        CbxComprobante comprobante = new CbxComprobante();
        comprobante.vistaCombo(cbxComprobantes);
        idCliente.setVisible(false);
        idComprobante.setVisible(false);
    }

    void calcular() {
        double total = 0;
        for (int i = 0; i < listaProducto.getRowCount(); i++) {
            total = total + Double.parseDouble(listaProducto.getValueAt(i, 7).toString());
        }
        double subtotal = total / 1.18;
        double itbis = total * 0.18;
        lblTotal.setText(String.valueOf(Math.round(total * 100) / 100d));
        lblSubTotal.setText(String.valueOf(Math.round(subtotal * 100) / 100d));
        lblITBIS.setText(String.valueOf(Math.round(itbis * 100) / 100d));

    }

    void calcularFila(int fila) {
        double total = Integer.parseInt(listaProducto.getValueAt(fila, 3).toString()) * Double.parseDouble(listaProducto.getValueAt(fila, 2).toString());
        double subtotal = total / 1.18;
        double itbis = total * 0.18;
        listaProducto.setValueAt(Math.round(total * 100) / 100d, fila, 7);//total
        listaProducto.setValueAt(Math.round(subtotal * 100) / 100d, fila, 5);//subtotal
        listaProducto.setValueAt(Math.round(itbis * 100) / 100d, fila, 6);//itbis        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        idCliente = new javax.swing.JLabel();
        cbxComprobantes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSerie = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProducto = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        lblITBIS = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnBuscarProducto = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        idComprobante = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtCliente.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cliente");

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        idCliente.setText("0");

        cbxComprobantes.setBackground(new java.awt.Color(255, 255, 255));
        cbxComprobantes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxComprobantesItemStateChanged(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Comprobantes");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("NUMERO COMPROBANTE");

        lblSerie.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSerie.setForeground(new java.awt.Color(51, 51, 51));
        lblSerie.setText("B02");

        lblNumero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNumero.setForeground(new java.awt.Color(51, 51, 51));
        lblNumero.setText("00000000");

        listaProducto.setBackground(new java.awt.Color(255, 255, 255));
        listaProducto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        listaProducto.setForeground(new java.awt.Color(73, 75, 76));
        listaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listaProducto.setRowHeight(35);
        listaProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaProductoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listaProducto);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("SUB TOTAL");

        lblSubTotal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(78, 78, 78));
        lblSubTotal.setText("0.00");

        lblITBIS.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblITBIS.setForeground(new java.awt.Color(78, 78, 78));
        lblITBIS.setText("0.00");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("ITBIS");

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(78, 78, 78));
        lblTotal.setText("0.00");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("TOTAL");

        btnRegistrar.setBackground(new java.awt.Color(5, 143, 235));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("GENERAR VENTA");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 127, 199));
        jLabel14.setText("PANTALLA DE VENTAS");

        btnEliminar.setBackground(new java.awt.Color(222, 92, 92));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        txtProducto.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Producto");

        idComprobante.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarCliente))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarProducto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminar)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxComprobantes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(6, 6, 6)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblITBIS, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(idComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idCliente)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(cbxComprobantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblITBIS, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        ListaClientes lCliente = new ListaClientes();
        lCliente.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        VistaProductos vista = new VistaProductos();
        vista.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = listaProducto.getSelectedRow();
        if (fila >= 0) {
            modelo.removeRow(fila); //ELIMINO
            calcular();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void listaProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaProductoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = listaProducto.getSelectedRow();
            calcularFila(fila);
            calcular();
        }
    }//GEN-LAST:event_listaProductoKeyPressed

    private void cbxComprobantesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxComprobantesItemStateChanged
        idComprobante.setText(cbxComprobantes.getItemAt(cbxComprobantes.getSelectedIndex()).getId());
        TraerDetalleComprobante cComprobantes = new TraerDetalleComprobante();
        cComprobantes.tipoComprobante(idComprobante.getText());
        lblSerie.setText(cComprobantes.serie);
        lblNumero.setText(cComprobantes.vistaNumero(idComprobante.getText()));
    }//GEN-LAST:event_cbxComprobantesItemStateChanged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(idCliente.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "SELECCIONA UN CLIENTE");
            ListaClientes form = new ListaClientes();
            form.setVisible(true);
            return;
        }
        if(listaProducto.getRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESA LOS PRODUCTOS A VENDER");
            VistaProductos vP = new VistaProductos();
            vP.setVisible(true);
            return;
        }
        
        ModeloVentas mVentas = new ModeloVentas();
        ControladorVentas cVentas = new ControladorVentas();
        
        mVentas.setIdCliente(Integer.parseInt(idCliente.getText()));
        mVentas.setIdComprobante(Integer.parseInt(idComprobante.getText()));
        mVentas.setIdUsuario(Integer.parseInt(Inicio.lblIDUsuario.getText())); // 50
        mVentas.setNumeroComprobante(lblSerie.getText()+ " "+lblNumero.getText());
        mVentas.setSubTotal(Double.parseDouble(lblSubTotal.getText()));
        mVentas.setItbis(Double.parseDouble(lblITBIS.getText()));
        mVentas.setTotal(Double.parseDouble(lblTotal.getText()));
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        mVentas.setFecha(formatoFecha.format(LocalDateTime.now()));
        mVentas.setEstado("EFECTUADA");
        if(cVentas.insertarVenta(mVentas)) {
            ModeloDetalleVentas mDetalleVenta = new ModeloDetalleVentas();
            for (int i = 0; i < listaProducto.getRowCount(); i++) {
                mDetalleVenta.setIdProducto(Integer.parseInt(listaProducto.getValueAt(i, 0).toString()));
                mDetalleVenta.setCantidad(Integer.parseInt(listaProducto.getValueAt(i, 3).toString()));
                mDetalleVenta.setPrecioUnitario(Double.parseDouble(listaProducto.getValueAt(i, 2).toString()));
                mDetalleVenta.setSubTotal(Double.parseDouble(listaProducto.getValueAt(i, 5).toString()));
                mDetalleVenta.setItbis(Double.parseDouble(listaProducto.getValueAt(i, 6).toString()));
                mDetalleVenta.setTotal(Double.parseDouble(listaProducto.getValueAt(i, 7).toString()));
                cVentas.insertarDetalleDeVenta(mDetalleVenta);
            }
            
            TraerDetalleComprobante comprobante = new TraerDetalleComprobante();
            ModeloComprobante mcomprobante = new ModeloComprobante();
            mcomprobante.setId(Integer.parseInt(idComprobante.getText()));
            mcomprobante.setNumero(lblNumero.getText());
            comprobante.cambiarNumero(mcomprobante);
            JOptionPane.showMessageDialog(null, "SE INSERTO UNA NUEVA VENTA");
            
            Ticket80MM ticket = new Ticket80MM();
            ticket.ticket(cVentas.obtenerID());
            
            this.dispose();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<CbxComprobante> cbxComprobantes;
    public static javax.swing.JLabel idCliente;
    private javax.swing.JLabel idComprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblITBIS;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSerie;
    public static javax.swing.JLabel lblSubTotal;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable listaProducto;
    public static javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
