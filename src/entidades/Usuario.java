package entidades;

public class Usuario {
	private int IDUsuario;
	private String password;
	private String TipoUsuario; 
	private Boolean estado;
	
	
	public Usuario(int iDUsuario, String password, String tipoUsuario, Boolean estado) {
		
		IDUsuario = iDUsuario;
		this.password = password;
		TipoUsuario = tipoUsuario;
		this.estado = estado;
	}
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
	public String getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	

}
