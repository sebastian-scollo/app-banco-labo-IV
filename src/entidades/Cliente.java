package entidades;

import java.util.Date;

public class Cliente extends Usuario {
	private int idCliente;
	private String dni;
	private String cuil;
	private String nombre;
	private String apellido;
	private String sexo;
	private String nacionalidad;
	private Date fechaNacimiento;
	private String telefono;
	private String correo;
	private int idUsuario;
	private boolean activo;
	private Provincia provincia;
	
	
	 public Provincia getProvincia() {
	        return provincia;
	    }

	 public void setProvincia(Provincia provincia) {
	        this.provincia = provincia;
	    }
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNac) {
		this.fechaNacimiento = fechaNac;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Cliente(int id,String dni, String cuil, String nombre, String apellido, String sexo, String nacionalidad,
			
			String correo,String _telefono ,Integer idUsurio,Date fNacimiento) {
		
		super();
		this.idCliente=id;
		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento= fNacimiento;
		this.correo = correo;
		this.telefono= _telefono;
		this.idUsuario = idUsurio;
	}
	public Cliente() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getIdUsurio() {
		return idUsuario;
	}
	public void setIdUsurio(Integer idUsurio) {
		this.idUsuario = idUsurio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
 /*IDCliente int auto_increment,
    DNI varchar(8) unique not null,
    CUIL varchar(13) unique not null,
    Nombre varchar(50) not null,
    Apellido varchar(50) not null,
    Sexo ENUM('Masculino', 'Femenino', 'No binario') not null,
    Nacionalidad varchar(50) not null,
    FechaNacimiento date not null,
    Telefono varchar(20),
    CorreoElectronico varchar(254) not null,
    UsuarioID int unique not null,
    activo boolean not null default 1,
    constraint pk_cliente primary key(IDCliente),
   constraint fk_clienteUsuario foreign key (UsuarioID) references Usuarios (IDUsuario)
   */
	
}
