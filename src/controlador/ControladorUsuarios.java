
package controlador;

import modelo.ModeloUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ControladorUsuarios {
    
    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();
    
    public boolean insertarUsuario(ModeloUsuarios dts){
        String query = "INSERT INTO usuarios (nombre, apellido,tipo_documento,numero_documento, tipo_usuario,nombre_usuario,contrasenia_usuario,estado) "
                + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst  = cn.prepareStatement(query);
            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getApellido());
            pst.setString(3,dts.getTipo_decumento());
            pst.setString(4,dts.getNumero_documento());
            pst.setString(5,dts.getTipo_usuario());
            pst.setString(6,dts.getNommbreUsuario());
            pst.setString(7,dts.getContrasenia());
            pst.setBoolean(8,dts.isEstado());
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
