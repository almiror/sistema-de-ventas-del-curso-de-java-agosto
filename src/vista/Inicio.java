
package vista;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
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

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
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

        subMenuCerrarSesion.setText("Cerrar Sesión");
        mnuInicio.add(subMenuCerrarSesion);

        subMenuCerrarSistema.setText("Cerrar sistema");
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
        mnuVentas.add(subMenuVentas);

        jMenuItem1.setText("subMenuReporteVentas");
        mnuVentas.add(jMenuItem1);

        jMenuBar1.add(mnuVentas);

        mnuConfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuraciones.png"))); // NOI18N
        mnuConfiguraciones.setText("Configuraciones");

        subMenuConfiguracionComprobantes.setText("Comprobantes");
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
       Usuarios u = new Usuarios();
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
