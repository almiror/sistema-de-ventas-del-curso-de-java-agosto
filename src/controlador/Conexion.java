package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    public Conexion(){}
    
    String dominio = "localhost";
    String nombreDb = "sistema_de_ventas";
    String usuario = "root";
    String password = "123456";
    String url = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //ZONA HORARIA
    
    private static Connection conectar = null;
    
    public Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://"+dominio+"/"+nombreDb+"?"+url,usuario,password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null," ERROR AL CONECTAR A LA BASE DE DATOS"+ e);
        }
        return conectar;
    }
    
    public void cerrarConexion(){
        try {
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL CERRAR LA CONEXION"+ e);
        }
    }
    
}
