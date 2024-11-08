package entidades;

public class Localidad {

   private int idLocalidad;
   private String nombre;
   private int provinciaID;
   
public Localidad(int idLocalidad, String nombre, int provinciaID) {
	
	this.idLocalidad = idLocalidad;
	this.nombre = nombre;
	this.provinciaID = provinciaID;
}

public int getIdLocalidad() {
	return idLocalidad;
}

public void setIdLocalidad(int idLocalidad) {
	this.idLocalidad = idLocalidad;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getProvinciaID() {
	return provinciaID;
}

public void setProvinciaID(int provinciaID) {
	this.provinciaID = provinciaID;
}
   
}
