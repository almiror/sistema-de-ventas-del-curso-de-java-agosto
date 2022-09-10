package vista;

import controlador.ControladorProductos;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

public class VistaProductos extends javax.swing.JFrame {

    ControladorProductos cProducto = new ControladorProductos();

    public VistaProductos() {
        initComponents();
        setLocationRelativeTo(this);
        vistaProducto("");
    }

    void vistaProducto(String buscar) {
        DefaultTableModel modelo;
        modelo = cProducto.vistaProducto(buscar);
        listaProductos.setModel(modelo);
    }

    void calcular() {
        double total = 0;
        for (int i = 0; i < Ventas.listaProducto.getRowCount(); i++) {
            total = total + Double.parseDouble(Ventas.listaProducto.getValueAt(i, 7).toString());
        }
        double subtotal = total / 1.18;
        double itbis = total * 0.18;
        Ventas.lblTotal.setText(String.valueOf(Math.round(total * 100) / 100d));
        Ventas.lblSubTotal.setText(String.valueOf(Math.round(subtotal * 100) / 100d));
        Ventas.lblITBIS.setText(String.valueOf(Math.round(itbis * 100) / 100d));

    }

    void calcularFila(int fila, int cantidad) {
        double total = Integer.parseInt(Ventas.listaProducto.getValueAt(fila, 3).toString()) * Double.parseDouble(Ventas.listaProducto.getValueAt(fila, 2).toString());
        double subtotal = total / 1.18;
        double itbis = total * 0.18;
        Ventas.listaProducto.setValueAt(cantidad, fila, 3);
        Ventas.listaProducto.setValueAt(Math.round(total * 100) / 100d, fila, 7);//total
        Ventas.listaProducto.setValueAt(Math.round(subtotal * 100) / 100d, fila, 5);//subtotal
        Ventas.listaProducto.setValueAt(Math.round(itbis * 100) / 100d, fila, 6);//itbis        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        listaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        listaProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaProductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listaProductos);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Buscar productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtBuscar))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
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

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        vistaProducto(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void listaProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaProductosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = listaProductos.getSelectedRow(); // FILA DE LA TABLA EN CUAL ESTOY POSICIONADO
            double subtotal = Double.parseDouble(listaProductos.getValueAt(fila, 3).toString()) / 1.18;
            double itbis = Double.parseDouble(listaProductos.getValueAt(fila, 3).toString()) - subtotal;
            String data[] = new String[Ventas.cabecera.length];
            data[0] = listaProductos.getValueAt(fila, 0).toString();
            data[1] = listaProductos.getValueAt(fila, 1).toString();
            data[2] = listaProductos.getValueAt(fila, 3).toString(); //PRECIO 50
            data[3] = "1";
            data[4] = listaProductos.getValueAt(fila, 5).toString();
            data[5] = String.valueOf(Math.round(subtotal * 100) / 100d);//SUBTOTAL 1.64
            data[6] = String.valueOf(Math.round(itbis * 100) / 100d); //ITBIS
            data[7] = listaProductos.getValueAt(fila, 3).toString();//TOTAL

            int cantidad = 1;
            if (Ventas.listaProducto.getRowCount() > 0) { // VALIDANDO SI HAY DATOS EN LA TABLA
                for (int i = 0; i < Ventas.listaProducto.getRowCount(); i++) { //recorremos
                    System.out.println(i);
                    System.out.println("ID " + Ventas.listaProducto.getValueAt(i, 0).toString()); // 1
                    if (Ventas.listaProducto.getValueAt(i, 0).toString().equals(listaProductos.getValueAt(fila, 0).toString())) { //comparamos s hay un id en ventas
                        cantidad = Integer.parseInt(Ventas.listaProducto.getValueAt(i, 3).toString()) + 1;
                        calcularFila(i, cantidad);
                        calcular();
                        System.out.println("AQUI SOLO INGRESO SI EXISTE EL PRODUCTO AÑADIDO EN LA VENTA ");
                        System.out.println(Ventas.listaProducto.getValueAt(i, 0).toString());
                    } else {
                        Ventas.modelo.addRow(data);
                        calcular();
                        System.out.println("AQUI AGREGO OTRO PRODUCTO");
                        break;
                    }
                    Ventas.modelo.addRow(data);
                    calcular();
                }
            } else {
                Ventas.modelo.addRow(data);
                calcular();
            }

        }
    }//GEN-LAST:event_listaProductosKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
