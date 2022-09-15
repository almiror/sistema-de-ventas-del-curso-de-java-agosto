package controlador;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CbxComprobante {
    private String id;
    private String descripcion;
    public CbxComprobante(){}

    public CbxComprobante(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();
    
    public void vistaCombo(JComboBox<CbxComprobante> tipocomprobante){
        try {
            String query = "SELECT * FROM comprobantes";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                tipocomprobante.addItem(new CbxComprobante(
                        rs.getString("id"),
                        rs.getString("descripcion")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR EN " +e);
        }
    }
    
    @Override
    public String toString(){
        return descripcion;
    }
    
    
}
