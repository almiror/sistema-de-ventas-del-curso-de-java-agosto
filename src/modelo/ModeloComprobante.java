
package modelo;

public class ModeloComprobante {
    private int id;
    private String descripcion;
    private String serie;
    private String numero;
    
    public ModeloComprobante(){}

    public ModeloComprobante(int id, String descripcion, String serie, String numero) {
        this.id = id;
        this.descripcion = descripcion;
        this.serie = serie;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
}
