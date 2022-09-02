package controlador;

import modelo.ModeloUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ControladorUsuarios {

    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();

    public DefaultTableModel vistaUsuarios(String buscar) {
        DefaultTableModel modelo;
        String cabecera[] = {"Nombre", "Apellido", "Tipo Doc.", "Numero Doc.", "Tipo Usuario", "Nombre usuario", "Contraseña", "estado", "#"};
        String registros[] = new String[cabecera.length];
        modelo = new DefaultTableModel(null, cabecera);
        String query = "SELECT * FROM usuarios WHERE CONCAT(nombre) like '%" + buscar + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                registros[0] = rs.getString("nombre");
                registros[1] = rs.getString("apellido");
                registros[2] = rs.getString("tipo_documento");
                registros[3] = rs.getString("numero_documento");
                registros[4] = rs.getString("tipo_usuario");
                registros[5] = rs.getString("nombre_usuario");
                registros[6] = rs.getString("contrasenia_usuario");
                registros[7] = rs.getString("estado");
                registros[8] = rs.getString("id");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean insertarUsuario(ModeloUsuarios dts) {
        String query = "INSERT INTO usuarios (nombre, apellido,tipo_documento,numero_documento,tipo_usuario,nombre_usuario,contrasenia_usuario,estado) "
                + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getTipo_decumento());
            pst.setString(4, dts.getNumero_documento());
            pst.setString(5, dts.getTipo_usuario());
            pst.setString(6, dts.getNommbreUsuario());
            pst.setString(7, dts.getContrasenia());
            pst.setBoolean(8, dts.isEstado());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    //MODIFICAR
    public boolean modificarUsuario(ModeloUsuarios dts) {
        String query = "UPDATE usuarios SET nombre=?, apellido=?,tipo_documento=?,numero_documento=?,tipo_usuario=?,nombre_usuario=?,contrasenia_usuario=?,estado=?"
                + " WHERE id =?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getTipo_decumento());
            pst.setString(4, dts.getNumero_documento());
            pst.setString(5, dts.getTipo_usuario());
            pst.setString(6, dts.getNommbreUsuario());
            pst.setString(7, dts.getContrasenia());
            pst.setBoolean(8, dts.isEstado());
            pst.setInt(9, dts.getId());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    //MODIFICAR
    public boolean eliminarUsuario(ModeloUsuarios dts) {
        String query = "DELETE FROM usuarios WHERE id =?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getId());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList usuarioEncontrado = new ArrayList();
    public int contador = 0;
    public void login(String usuario, String password) {
        String query = "SELECT u.id, u.nombre,u.tipo_usuario "
                + "FROM usuarios u WHERE u.nombre_usuario = '" + usuario + "' "
                + "AND u.contrasenia_usuario = '" + password + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                usuarioEncontrado.add(rs.getString("u.id"));
                usuarioEncontrado.add(rs.getString("u.nombre"));
                usuarioEncontrado.add(rs.getString("u.tipo_usuario"));
                contador++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
