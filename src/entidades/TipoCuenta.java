package entidades;

public class TipoCuenta {

	private Integer idTipoCuenta;
	private String descripcion;
	
	public int getIdTipoCuenta() {
		return idTipoCuenta;
	}
	public void setIdTipoCuenta(Integer idTipoCuenta) {
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

	public TipoCuenta(Integer idTipoCuenta, String descripcion) {
		super();
		this.idTipoCuenta = idTipoCuenta;
		this.descripcion = descripcion;
	}
	public TipoCuenta() {}
	
}
