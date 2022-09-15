package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import modelo.ModeloComprobante;

public class TraerDetalleComprobante {

    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();
    
    public String serie = null;
    public void tipoComprobante(String idComprobante) {
        serie = "";
        try {
            String query = "SELECT * FROM comprobantes WHERE id = " + idComprobante; // SERIE // NUMERO
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                serie = rs.getString("serie");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN "+ e);
        }
    }
    
    public String vistaNumero(String idVenta) {
        String  query = "SELECT n.numero FROM comprobantes n WHERE id = " + idVenta;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            DecimalFormat formateador = new DecimalFormat("00000000");
            String numeroOrig = "00000000";
            String registro[] = new String[1];
            while (rs.next()) {
                if (rs.getString("n.numero").equals("00000000")) {
                    numeroOrig = "0";
                } else {
                    numeroOrig = registro[0] = rs.getString("n.numero").replaceAll("^0+", "");
                }
            }

            rs.first();
            String format = formateador.format(Integer.parseInt(numeroOrig) + 1);
            return format;
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUEDE FORMATEAR EL NÚMERO DE REFERENCIA" + e);
            return null;
        }
    }
    
     public boolean cambiarNumero(ModeloComprobante dts) {
        String query = "UPDATE comprobantes SET "
                + "numero=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getNumero());
            pst.setInt(2, dts.getId());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
