package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloDetalleVentas;
import modelo.ModeloVentas;

public class ControladorVentas {

    //llamada a la conexion
    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();
    
    public boolean insertarVenta(ModeloVentas attr){
        String query = "INSERT INTO ventas "
                + "(idcliente,idcomprobante,idusuario,numero_comprante,subtotal,itbis,total,fecha_emision,estado) "
                + " VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, attr.getIdCliente()); // 1
            pst.setInt(2, attr.getIdComprobante());
            pst.setInt(3, attr.getIdUsuario());
            pst.setString(4, attr.getNumeroComprobante());
            pst.setDouble(5, attr.getSubTotal());
            pst.setDouble(6, attr.getItbis());
            pst.setDouble(7, attr.getTotal());
            pst.setString(8, attr.getFecha());
            pst.setString(9, attr.getEstado());
            
            int n = pst.executeUpdate();
            if(n != 0) {
                return true;
            } else {
                return false;
            }               
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR EN " + e);
            return false;
        }
    }
    
     public boolean insertarDetalleDeVenta(ModeloDetalleVentas attr){
        String query = "INSERT INTO detalle_ventas "
                + "(idventa,idproducto,cantidad,precio_unitario,subtotal,itbis,total) "
                + " VALUES((SELECT MAX(id) FROM ventas),?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, attr.getIdProducto());
            pst.setInt(2, attr.getCantidad());
            pst.setDouble(3, attr.getPrecioUnitario());
            pst.setDouble(4, attr.getSubTotal());
            pst.setDouble(5, attr.getItbis());
            pst.setDouble(6, attr.getTotal());
            
            int n = pst.executeUpdate();
            if(n != 0) {
                return true;
            } else {
                return false;
            }               
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR EN " + e);
            return false;
        }
    }
}
