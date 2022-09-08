
package controlador;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloComprobante;

public class ControladorComprobante {
    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();
    
    public DefaultTableModel vistaComprobante(String buscar){
        DefaultTableModel tablaModelo;
        String cabecera[] = {"ID","DESCRIPCION","NUMERO","SERIE"};
        String registros[] = new String[cabecera.length];
        tablaModelo = new DefaultTableModel(null,cabecera);
        String query = "SELECT * FROM comprobantes WHERE descripcion LIKE '%"+buscar+"%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("descripcion");
                registros[2] = rs.getString("serie");
                registros[3] = rs.getString("numero");
                tablaModelo.addRow(registros);
            }
            return tablaModelo;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean insertarComprobante(ModeloComprobante dts){
        String query = "INSERT INTO comprobantes (descripcion,serie, numero) VALUES(?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getDescripcion());
            pst.setString(2, dts.getSerie());
            pst.setString(3, dts.getNumero());
            int n = pst.executeUpdate();
            if(n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean modificarComprobante(ModeloComprobante dts){
        String query = "UPDATE comprobantes SET descripcion=?,serie=?, numero=? WHERE id=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getDescripcion());
            pst.setString(2, dts.getSerie());
            pst.setString(3, dts.getNumero());
            pst.setInt(4, dts.getId());
            int n = pst.executeUpdate();
            if(n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
}
