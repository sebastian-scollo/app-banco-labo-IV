package entidades;

public class Movimiento {

	private int idMovimiento;
	private String detalle;
	private double importe;
	private int idCuentaEmisor; 
	private int idCuentaReceptor;
	private int tipoMovimiento;
	public Movimiento(int idMovimiento, String detalle, double importe, int idCuentaEmisor, int idCuentaReceptor,
			int tipoMovimiento) {
		this.idMovimiento = idMovimiento;
		this.detalle = detalle;
		this.importe = importe;
		this.idCuentaEmisor = idCuentaEmisor;
		this.idCuentaReceptor = idCuentaReceptor;
		this.tipoMovimiento = tipoMovimiento;
	}
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public int getIdCuentaEmisor() {
		return idCuentaEmisor;
	}
	public void setIdCuentaEmisor(int idCuentaEmisor) {
		this.idCuentaEmisor = idCuentaEmisor;
	}
	public int getIdCuentaReceptor() {
		return idCuentaReceptor;
	}
	public void setIdCuentaReceptor(int idCuentaReceptor) {
		this.idCuentaReceptor = idCuentaReceptor;
	}
	public int getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
	
	
	
}
