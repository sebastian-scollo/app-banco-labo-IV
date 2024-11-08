package entidades;

public class Cuota {
	
	private int idCuota;
	private String fechaAbonada;
	private double importeAbonado;
	private boolean estado;
	private int prestamoId;
	public Cuota(int idCuota, String fechaAbonada, double importeAbonado, boolean estado, int prestamoId) {
		
		this.idCuota = idCuota;
		this.fechaAbonada = fechaAbonada;
		this.importeAbonado = importeAbonado;
		this.estado = estado;
		this.prestamoId = prestamoId;
	}
	public int getIdCuota() {
		return idCuota;
	}
	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}
	public String getFechaAbonada() {
		return fechaAbonada;
	}
	public void setFechaAbonada(String fechaAbonada) {
		this.fechaAbonada = fechaAbonada;
	}
	public double getImporteAbonado() {
		return importeAbonado;
	}
	public void setImporteAbonado(double importeAbonado) {
		this.importeAbonado = importeAbonado;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getPrestamoId() {
		return prestamoId;
	}
	public void setPrestamoId(int prestamoId) {
		this.prestamoId = prestamoId;
	}

	
}
