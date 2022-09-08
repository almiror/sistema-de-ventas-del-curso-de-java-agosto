package controlador;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloProductos;

public class ControladorProductos {
    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();
    
    public DefaultTableModel vistaProducto(String buscar){
        DefaultTableModel modelo;
        String cabecera[] = {"ID","DESCRIPCION","P. COMPRA","P. VENTA","STOCK","UNIDAD MEDIDA","ESTADO"};
        String registros[] = new String[cabecera.length];
        modelo = new DefaultTableModel(null,cabecera);
        
        String query  = "SELECT * FROM productos WHERE CONCAT(descripcion) LIKE '%"+buscar+"%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("descripcion");
                registros[2] = rs.getString("precio_compra");
                registros[3] = rs.getString("precio_venta");
                registros[4] = rs.getString("stock");
                registros[5] = rs.getString("unidad_medida");
                registros[6] = rs.getString("estado");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public boolean insertarProductos(ModeloProductos dts){
        String query = "INSERT INTO productos (descripcion,precio_compra,precio_venta,stock,"
                + "unidad_medida,estado) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getDescripcion());
            pst.setDouble(2, dts.getPrecioCompra());
            pst.setDouble(3, dts.getPrecioVenta());
            pst.setDouble(4, dts.getStock());
            pst.setString(5, dts.getUnidadMedida());
            pst.setBoolean(6, dts.isEstado());
            
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
    
    public boolean modificarProductos(ModeloProductos dts){
        String query = "UPDATE productos SET descripcion=?,precio_compra=?,precio_venta=?,stock=?,"
                + "unidad_medida=?,estado=? WHERE id=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getDescripcion());
            pst.setDouble(2, dts.getPrecioCompra());
            pst.setDouble(3, dts.getPrecioVenta());
            pst.setDouble(4, dts.getStock());
            pst.setString(5, dts.getUnidadMedida());
            pst.setBoolean(6, dts.isEstado());
            pst.setInt(7, dts.getId());
            
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
    
    public boolean eliminarProductos(ModeloProductos dts){
        String query = "DELETE FROM productos WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getId());
            
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
