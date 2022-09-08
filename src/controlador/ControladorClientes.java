package controlador;
import java.sql.Connection;
import modelo.ModeloCliente;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ControladorClientes {
    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();
    
    // LISTANDO TODOS LOS REGISTROS DE LA BASE DE DATOS Y PASANDOLE A UN MODELO DE NUESTRA TABLA
    public DefaultTableModel vistaCliente(String buscar){
        DefaultTableModel modelo;
        String cabecera[] = {"id","NOMBRES","APELLIDOS","TIPO DOC","N° DOCUMENTO","ESTADO"};
        String registros[] = new String[cabecera.length];
        modelo = new DefaultTableModel(null,cabecera);
        String query = "SELECT IF(c.estado = 1,'ACTIVO','INACTIVO') AS estado,  c.id, c.nombre,c.apellido, c.tipo_documento,c.numero_documento "
                + " FROM clientes c WHERE CONCAT(c.nombre) LIKE '%"+buscar+"%'";
        try {
            Statement st = cn.createStatement(); // INSTANCIAMOS LA CONEXCION
            ResultSet rs = st.executeQuery(query); // RESULTSET PARA EJECUTAR LA CONSULTA
            while(rs.next()){
                registros[0] = rs.getString("c.id");
                registros[1] = rs.getString("c.nombre");
                registros[2] = rs.getString("c.apellido");
                registros[3] = rs.getString("c.tipo_documento");
                registros[4] = rs.getString("c.numero_documento");
                registros[5] = rs.getString("estado");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    // INSERTA LOS DATOS A LA BASE DE DATOS
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
