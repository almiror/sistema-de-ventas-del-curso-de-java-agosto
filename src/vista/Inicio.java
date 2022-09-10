
package vista;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
//        setExtendedState(MAXIMIZED_BOTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        lblIDUsuario = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuInicio = new javax.swing.JMenu();
        subMenuCerrarSesion = new javax.swing.JMenuItem();
        subMenuCerrarSistema = new javax.swing.JMenuItem();
        mnuProductos = new javax.swing.JMenu();
        subMenuMantenimientoProductos = new javax.swing.JMenuItem();
        subMenuReporteProductos = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenu();
        subMenuMantenimientoClientes = new javax.swing.JMenuItem();
        subMenuReporteClientes = new javax.swing.JMenuItem();
        mnuUsuarios = new javax.swing.JMenu();
        subMenuMantenimientoUsuarios = new javax.swing.JMenuItem();
        subMenuReporteUsuarios = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        subMenuVentas = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuConfiguraciones = new javax.swing.JMenu();
        subMenuConfiguracionComprobantes = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblIDUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblIDUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblIDUsuario.setText("0");

        lblNombreUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("---");

        lblTipoUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoUsuario.setText("---");

        escritorio.setLayer(lblIDUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblNombreUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblTipoUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIDUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIDUsuario)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblTipoUsuario))
                .addGap(0, 379, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        mnuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio.png"))); // NOI18N
        mnuInicio.setText("Inicio");

        subMenuCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        subMenuCerrarSesion.setText("Cerrar Sesión");
        subMenuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCerrarSesionActionPerformed(evt);
            }
        });
        mnuInicio.add(subMenuCerrarSesion);

        subMenuCerrarSistema.setText("Cerrar sistema");
        subMenuCerrarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCerrarSistemaActionPerformed(evt);
            }
        });
        mnuInicio.add(subMenuCerrarSistema);

        jMenuBar1.add(mnuInicio);

        mnuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos.png"))); // NOI18N
        mnuProductos.setText("Productos");

        subMenuMantenimientoProductos.setText("Mantenimiento de productos");
        subMenuMantenimientoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuMantenimientoProductosActionPerformed(evt);
            }
        });
        mnuProductos.add(subMenuMantenimientoProductos);

        subMenuReporteProductos.setText("Reportes");
        mnuProductos.add(subMenuReporteProductos);

        jMenuBar1.add(mnuProductos);

        mnuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cientes.png"))); // NOI18N
        mnuClientes.setText("Clientes");

        subMenuMantenimientoClientes.setText("Mantenimiento de Clientes");
        subMenuMantenimientoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuMantenimientoClientesActionPerformed(evt);
            }
        });
        mnuClientes.add(subMenuMantenimientoClientes);

        subMenuReporteClientes.setText("ReporteClientes");
        mnuClientes.add(subMenuReporteClientes);

        jMenuBar1.add(mnuClientes);

        mnuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png"))); // NOI18N
        mnuUsuarios.setText("Usuarios");

        subMenuMantenimientoUsuarios.setText("Mantenimiento de Usuarios");
        subMenuMantenimientoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuMantenimientoUsuariosActionPerformed(evt);
            }
        });
        mnuUsuarios.add(subMenuMantenimientoUsuarios);

        subMenuReporteUsuarios.setText("Reporte de Usuarios");
        mnuUsuarios.add(subMenuReporteUsuarios);

        jMenuBar1.add(mnuUsuarios);

        mnuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas.png"))); // NOI18N
        mnuVentas.setText("Ventas");

        subMenuVentas.setText("Nueva Venta");
        subMenuVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuVentasActionPerformed(evt);
            }
        });
        mnuVentas.add(subMenuVentas);

        jMenuItem1.setText("subMenuReporteVentas");
        mnuVentas.add(jMenuItem1);

        jMenuBar1.add(mnuVentas);

        mnuConfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuraciones.png"))); // NOI18N
        mnuConfiguraciones.setText("Configuraciones");

        subMenuConfiguracionComprobantes.setText("Comprobantes");
        subMenuConfiguracionComprobantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuConfiguracionComprobantesActionPerformed(evt);
            }
        });
        mnuConfiguraciones.add(subMenuConfiguracionComprobantes);

        jMenuBar1.add(mnuConfiguraciones);

        setJMenuBar(jMenuBar1);

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

    private void subMenuMantenimientoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuMantenimientoProductosActionPerformed
       Productos u = new Productos();
        escritorio.add(u);
        u.toFront();
        u.setVisible(true); 
    }//GEN-LAST:event_subMenuMantenimientoProductosActionPerformed

    private void subMenuMantenimientoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuMantenimientoUsuariosActionPerformed
       Usuarios formUsuario = new Usuarios();
       escritorio.add(formUsuario);
       formUsuario.toFront();
       formUsuario.setVisible(true);
    }//GEN-LAST:event_subMenuMantenimientoUsuariosActionPerformed

    private void subMenuMantenimientoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuMantenimientoClientesActionPerformed
        Clientes form = new Clientes();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_subMenuMantenimientoClientesActionPerformed

    private void subMenuConfiguracionComprobantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuConfiguracionComprobantesActionPerformed
      Comprobantes comprobante = new Comprobantes();
      escritorio.add(comprobante);
      comprobante.toFront();
      comprobante.setVisible(true);
    }//GEN-LAST:event_subMenuConfiguracionComprobantesActionPerformed

    private void subMenuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCerrarSesionActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_subMenuCerrarSesionActionPerformed

    private void subMenuCerrarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCerrarSistemaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_subMenuCerrarSistemaActionPerformed

    private void subMenuVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuVentasActionPerformed
        Ventas v  = new Ventas();
        escritorio.add(v);
        v.toFront();
        v.setVisible(true);
    }//GEN-LAST:event_subMenuVentasActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblIDUsuario;
    public static javax.swing.JLabel lblNombreUsuario;
    public static javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JMenu mnuClientes;
    private javax.swing.JMenu mnuConfiguraciones;
    private javax.swing.JMenu mnuInicio;
    private javax.swing.JMenu mnuProductos;
    private javax.swing.JMenu mnuUsuarios;
    private javax.swing.JMenu mnuVentas;
    private javax.swing.JMenuItem subMenuCerrarSesion;
    private javax.swing.JMenuItem subMenuCerrarSistema;
    private javax.swing.JMenuItem subMenuConfiguracionComprobantes;
    private javax.swing.JMenuItem subMenuMantenimientoClientes;
    private javax.swing.JMenuItem subMenuMantenimientoProductos;
    private javax.swing.JMenuItem subMenuMantenimientoUsuarios;
    private javax.swing.JMenuItem subMenuReporteClientes;
    private javax.swing.JMenuItem subMenuReporteProductos;
    private javax.swing.JMenuItem subMenuReporteUsuarios;
    private javax.swing.JMenuItem subMenuVentas;
    // End of variables declaration//GEN-END:variables
}
