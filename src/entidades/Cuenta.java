package entidades;

import java.util.Date;

public class Cuenta {
	private int idCuenta;
	
	private String NroCuenta;
	private double saldo;
	private int clienteId;
	private int tipoCuentaId;
	private Date fechaCreacion;
	private String CBU;
	private TipoCuenta objidTipoCuenta;
	
	public TipoCuenta getObjidTipoCuenta() {
		return objidTipoCuenta;
	}
	public void setObjidTipoCuenta(TipoCuenta objidTipoCuenta) {
		this.objidTipoCuenta = objidTipoCuenta;
	}
	private boolean estado;
	
	public String getCBU() {
		return CBU;
	}
	public void setCBU(String cBU) {
		CBU = cBU;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getNroCuenta() {
		return NroCuenta;
	}
	public void setNroCuenta(String nroCuenta) {
		NroCuenta = nroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public int getTipoCuentaId() {
		return tipoCuentaId;
	}
	public void setTipoCuentaId(int tipoCuentaId) {
		this.tipoCuentaId = tipoCuentaId;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Cuenta(int idCuenta, String nroCuenta, double saldo, int clienteId, int tipoCuentaId, Date fechaCreacion,
			boolean estado) {
		this.idCuenta = idCuenta;
		NroCuenta = nroCuenta;
		this.saldo = saldo;
		this.clienteId = clienteId;
		this.tipoCuentaId = tipoCuentaId;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}
	public Cuenta() {
		
	}
	

}
