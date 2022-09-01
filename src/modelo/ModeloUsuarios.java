package modelo;

public class ModeloUsuarios {
    private int idusuario;
    private String nombre;
    private String apellido;
    private String tipo_decumento;
    private String numero_documento;
    private String tipo_usuario;
    private String nommbreUsuario;
    private String contrasenia;
    private boolean estado;
    
    public ModeloUsuarios(){}

    public ModeloUsuarios(int idusuario, String nombre, String apellido, String tipo_decumento, String numero_documento, String tipo_usuario, String nommbreUsuario, String contrasenia, boolean estado) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_decumento = tipo_decumento;
        this.numero_documento = numero_documento;
        this.tipo_usuario = tipo_usuario;
        this.nommbreUsuario = nommbreUsuario;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public int getId() {
        return idusuario;
    }

    public void setId(int id) {
        this.idusuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo_decumento() {
        return tipo_decumento;
    }

    public void setTipo_decumento(String tipo_decumento) {
        this.tipo_decumento = tipo_decumento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getNommbreUsuario() {
        return nommbreUsuario;
    }

    public void setNommbreUsuario(String nommbreUsuario) {
        this.nommbreUsuario = nommbreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
