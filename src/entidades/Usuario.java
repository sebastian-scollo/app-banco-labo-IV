package entidades;

public class Usuario {
	private int IDUsuario;
<<<<<<< HEAD
	private String NombreUsuario;
=======
	private String nombreUsuario;
>>>>>>> 6ee51c63d636acecd76034c40579d86d02e722c1
	private String password;
	private int TipoUsuario; 
	private Boolean estado;
	
	
<<<<<<< HEAD

	public Usuario(int iDUsuario, String password, int tipoUsuario, Boolean estado) {
=======
	public Usuario(int iDUsuario,String nombreUsuario, String password, int tipoUsuario, Boolean estado) {
>>>>>>> 6ee51c63d636acecd76034c40579d86d02e722c1
		
		IDUsuario = iDUsuario;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		TipoUsuario = tipoUsuario;
		this.estado = estado;
	}
	public Usuario() {};
	
	public int getIDUsuario() {
		return IDUsuario;
	}
	public void setIDUsuario(int iDUsuario) {
		IDUsuario = iDUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	public void setTipoUsuario(int tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}
	

}
