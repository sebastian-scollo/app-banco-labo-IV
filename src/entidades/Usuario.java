package entidades;

public class Usuario {
    private int IDUsuario;
    private String NombreUsuario;
    private String password;
    private int TipoUsuario; 
    private Boolean estado;

   
    public Usuario(int IDUsuario, String NombreUsuario, String password, int TipoUsuario, Boolean estado) {
        this.IDUsuario = IDUsuario;
        this.NombreUsuario = NombreUsuario;
        this.password = password;
        this.TipoUsuario = TipoUsuario;
        this.estado = estado;
    }

    
    public Usuario(int IDUsuario, String password, int TipoUsuario, Boolean estado) {
        this.IDUsuario = IDUsuario;
        this.password = password;
        this.TipoUsuario = TipoUsuario;
        this.estado = estado;
    }

    // Constructor vacío
    public Usuario() {}

    // Getters y setters
    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(int TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}