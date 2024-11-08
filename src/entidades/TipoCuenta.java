package entidades;

public class TipoCuenta {

	private int idTipoCuenta;
	private String descripcion;
	
	public int getIdTipoCuenta() {
		return idTipoCuenta;
	}
	public void setIdTipoCuenta(int idTipoCuenta) {
		this.idTipoCuenta = idTipoCuenta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoCuenta(int idTipoCuenta, String descripcion) {
		
		this.idTipoCuenta = idTipoCuenta;
		this.descripcion = descripcion;
	}
	
	
}
