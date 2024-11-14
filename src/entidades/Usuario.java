package entidades;

public class Usuario {
	private int IDUsuario;
	private String NombreUsuario;
	private String password;
	private int TipoUsuario; 
	private Boolean estado;
	
	

	public Usuario(int iDUsuario, String password, int tipoUsuario, Boolean estado) {
		
		IDUsuario = iDUsuario;
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
