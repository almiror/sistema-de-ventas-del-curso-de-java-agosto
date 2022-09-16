package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloDetalleVentas;
import modelo.ModeloVentas;

public class ControladorVentas {

    //llamada a la conexion
    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();

    public boolean insertarVenta(ModeloVentas attr) {
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
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN " + e);
            return false;
        }
    }

    public boolean insertarDetalleDeVenta(ModeloDetalleVentas attr) {
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
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN " + e);
            return false;
        }
    }
    public double total = 0;
    public double subtotal = 0;
    public double itbis = 0;
    public DefaultTableModel vistaVentas(String buscar) {
        DefaultTableModel modelo;
        String cabecera[] = {"ID", "CLIENTE", "COMPROBANTE", "N° COMPROBANTE", "SUBTOTAL", "ITBIS", "TOTAL", "FECHA EMITIDA"};
        String registros[] = new String[cabecera.length];
        modelo = new DefaultTableModel(null, cabecera);
        String query = "SELECT CONCAT(c.nombre,' ',c.apellido) AS cliente, cv.descripcion, "
                        + "v.numero_comprante,v.subtotal,v.itbis,v.total,v.fecha_emision, v.id "
                        + "FROM ventas v "
                        + "INNER JOIN clientes c ON "
                        + "c.id = v.idcliente "
                        + "INNER JOIN comprobantes cv ON "
                        + "cv.id = v.idcomprobante "
                        + "WHERE CONCAT(c.nombre,' ',v.numero_comprante,' ',v.fecha_emision) LIKE '%"+buscar+"%'"
                        + "ORDER BY v.id DESC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                registros[0] = rs.getString("v.id");
                registros[1] = rs.getString("cliente");
                registros[2] = rs.getString("cv.descripcion");
                registros[3] = rs.getString("v.numero_comprante");
                registros[4] = rs.getString("v.subtotal");
                registros[5] = rs.getString("v.itbis");
                registros[6] = rs.getString("v.total");
                registros[7] = rs.getString("v.fecha_emision");
                itbis +=  Double.parseDouble(rs.getString("v.itbis"));
                subtotal += Double.parseDouble(rs.getString("v.subtotal"));
                total += Double.parseDouble(rs.getString("v.total"));
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
    }
    
    
    public String obtenerID() {
        String query = "SELECT MAX(id) AS idventa FROM ventas";
        String id = null;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getString("idventa");
            }
            return id;

        } catch (Exception e) {
            return null;
        }
    }
}
