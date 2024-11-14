package entidades;

public class Usuario {
	private int IDUsuario;
	private String nombreUsuario;
	private String password;
	private int TipoUsuario; 
	private Boolean estado;
	
	
	public Usuario(int iDUsuario,String nombreUsuario, String password, int tipoUsuario, Boolean estado) {
		
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
	

}
