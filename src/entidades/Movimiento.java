package entidades;

public class Movimiento {

	private int idMovimiento;
	private String detalle;
	private double importe;
	private Cuenta cuentaEmisor;
	private Cuenta cuentaReceptor;
	private TipoMovimiento tipomovimiento;
      
	

	


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






	public Cuenta getCuentaEmisor() {
		return cuentaEmisor;
	}






	public void setCuentaEmisor(Cuenta cuentaEmisor) {
		this.cuentaEmisor = cuentaEmisor;
	}






	public Cuenta getCuentaReceptor() {
		return cuentaReceptor;
	}






	public void setCuentaReceptor(Cuenta cuentaReceptor) {
		this.cuentaReceptor = cuentaReceptor;
	}






	public TipoMovimiento getTipomovimiento() {
		return tipomovimiento;
	}






	public void setTipomovimiento(TipoMovimiento tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}






	public Movimiento() {
		
	}
	
	
	
	
	
}
