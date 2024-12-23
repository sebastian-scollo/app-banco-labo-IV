package entidades;

import java.sql.Date;

public class Prestamo {
	
	/*private int idPrestamo;
	private double montoSolicitado;
    private double importeApagar;
    private int plazo;
    private boolean estado;
    private String fechaSolicitado;
    private String fechaRespuesta;
    private Cuenta cuenta;*/
	private int idPrestamo;
	private double montoSolicitado;
    private double importeApagar;
    private int plazo;
    private String estado;
    public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaSolicitado() {
		return fechaSolicitado;
	}
	public void setFechaSolicitado(Date fechaSolicitado) {
		this.fechaSolicitado = fechaSolicitado;
	}
	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}
	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}
	private Date fechaSolicitado;
    private Date fechaRespuesta;
    private Cuenta cuenta;
    public Prestamo(int idPrestamo, double montoSolicitado, double importeApagar, int plazo, String estado, Date fechaSolicitado,
			Date fechaRespuesta, Cuenta cuenta) {
		
		this.idPrestamo = idPrestamo;
		this.montoSolicitado = montoSolicitado;
		this.importeApagar = importeApagar;
		this.plazo = plazo;
		this.estado = estado;
		this.fechaSolicitado = fechaSolicitado;
		this.fechaRespuesta = fechaRespuesta;
		this.cuenta = cuenta;
	}
	public Prestamo() {}
	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public double getImporteApagar() {
		return importeApagar;
	}
	public void setImporteApagar(double importeApagar) {
		this.importeApagar = importeApagar;
	}
	public int getPlazo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	
	
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public double getMontoSolicitado() {
		return montoSolicitado;
	}
	public void setMontoSolicitado(double importeSolicitado) {
		this.montoSolicitado = importeSolicitado;
	}
	
	public double obtenerTNA() {
        if (plazo >= 1 && plazo <= 12) {
            return 0.40; // TNA 40%
        } else if (plazo >= 13 && plazo <= 24) {
            return 0.45; // TNA 45%
        } else if (plazo >= 25 && plazo <= 36) {
            return 0.50; // TNA 50%
        } else if (plazo >= 37 && plazo <= 48) {
        	return 0.55; // TNA 55%
        } else {
            throw new IllegalArgumentException("Plazo no v�lido");
        }
    }
    public void calcularImporteApagar() {
        double tna = obtenerTNA();
        this.importeApagar = montoSolicitado * (1 + (tna * plazo / 12));
    }
    
}
