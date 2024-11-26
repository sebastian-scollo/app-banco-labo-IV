package entidades;

public class Cuota {
	
	private int idCuota;
	private String fechaAbonada;
	private double importeAbonado;
	private boolean estado;
	//private int prestamoId;
	private Prestamo prestamo;

	
	public Prestamo getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
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

	
}
