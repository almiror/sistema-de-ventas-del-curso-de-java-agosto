package modelo;

public class ModeloVentas {
    private int id;
    private int idCliente;
    private int idComprobante;
    private int idUsuario;
    private String numeroComprobante;
    private double subTotal;
    private double itbis;
    private double total;
    private String fecha;
    private String estado;
    
    public ModeloVentas(){}

    public ModeloVentas(int id, int idCliente, int idComprobante, int idUsuario, String numeroComprobante, double subTotal, double itbis, double total, String fecha, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.idComprobante = idComprobante;
        this.idUsuario = idUsuario;
        this.numeroComprobante = numeroComprobante;
        this.subTotal = subTotal;
        this.itbis = itbis;
        this.total = total;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getItbis() {
        return itbis;
    }

    public void setItbis(double itbis) {
        this.itbis = itbis;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
//    
}
