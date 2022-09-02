package controlador;
import java.sql.Connection;
import modelo.ModeloCliente;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ControladorClientes {
    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();
    
    public boolean insertarClientes(ModeloCliente datos){
        String query = "INSERT INTO clientes (nombre, apellido, tipo_documento, numero_documento,estado) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1,datos.getNombre());
            pst.setString(2,datos.getApellido());
            pst.setString(3,datos.getTipoDocumento());
            pst.setString(4,datos.getNumeroDocumento());
            pst.setBoolean(5,datos.isEstado());
            int consulta = pst.executeUpdate();
            if(consulta != 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    public boolean modificarClientes(ModeloCliente datos){
        String query = "UPDATE clientes SET nombre=?, apellido=?, tipo_documento=?, numero_documento=?,estado=? "
                + "WHERE id=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1,datos.getNombre());
            pst.setString(2,datos.getApellido());
            pst.setString(3,datos.getTipoDocumento());
            pst.setString(4,datos.getNumeroDocumento());
            pst.setBoolean(5,datos.isEstado());
            pst.setInt(6,datos.getId());
            int consulta = pst.executeUpdate();
            if(consulta != 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    public boolean eliminarClientes(ModeloCliente datos){
        String query = "DELETE FROM clientes WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1,datos.getId());
            int consulta = pst.executeUpdate();
            if(consulta != 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
