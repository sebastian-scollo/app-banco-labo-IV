package entidades;

public class Direccion {
	private int idDireccion;
	private String nombrecalle;
	private int numerCalle;
	private Integer piso;
	private String departamento;
	private int nroLocalidad;
	private int IdCliente;
	public Direccion() {};
	public Direccion(int idDireccion, String nombrecalle, int numerCalle, int piso, String departamento, int nroLocalidad,
			int idCliente) {
		this.idDireccion = idDireccion;
		this.nombrecalle = nombrecalle;
		this.numerCalle = numerCalle;
		this.piso = piso;
		this.departamento = departamento;
		this.nroLocalidad = nroLocalidad;
		IdCliente = idCliente;
	}
	public int getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getNombrecalle() {
		return nombrecalle;
	}
	public void setNombrecalle(String nombrecalle) {
		this.nombrecalle = nombrecalle;
	}
	public int getNumerCalle() {
		return numerCalle;
	}
	public void setNumerCalle(int numerCalle) {
		this.numerCalle = numerCalle;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public int getNroLocalidad() {
		return nroLocalidad;
	}
	public void setNroLocalidad(int nroLocalidad) {
		this.nroLocalidad = nroLocalidad;
	}
	public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}
	
}
