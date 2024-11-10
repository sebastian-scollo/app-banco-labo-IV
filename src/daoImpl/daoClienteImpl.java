package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import dao.daoCliente;
import entidades.Cliente;

public class daoClienteImpl implements daoCliente{
 /**/
	
	@Override
	public ArrayList<Cliente> ListarCl() {
		  ArrayList<Cliente> ListaCliente = new ArrayList<>();
		    
		    try {
		        Class.forName("com.mysql.jdbc.Driver"); // Asegúrate de que el controlador esté cargando
		        System.out.println("Driver MySQL cargado correctamente.");
		    } catch(ClassNotFoundException e) {
		        System.out.println("Error al cargar el driver MySQL.");
		        e.printStackTrace();
		        return ListaCliente; // Devuelve una lista vacía en caso de error en el driver
		    }
		    
		    conexion ruta = new conexion();
		    Connection cn = ruta.obtenerConexion();

		    if (cn == null) {
		        System.out.println("Conexión fallida: la conexión es null.");
		        return ListaCliente; // Salir si la conexión es null
		    }

		    String consulta = "SELECT IDCliente, DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, Telefono, CorreoElectronico, UsuarioID "
		                    + "FROM Clientes WHERE activo=1";

		    try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(consulta)) {
		        while (rs.next()) {
		            Cliente cliente = new Cliente();
		            
		            cliente.setIdCliente(rs.getInt("IDCliente"));
		            cliente.setDni(rs.getString("DNI"));
		            cliente.setCuil(rs.getString("CUIL"));
		            cliente.setNombre(rs.getString("Nombre"));
		            cliente.setApellido(rs.getString("Apellido"));
		            cliente.setSexo(rs.getString("Sexo"));
		            cliente.setNacionalidad(rs.getString("Nacionalidad"));
		            
		            // Convertir FechaNacimiento a Date en Java
		            Date fechaNac = rs.getDate("FechaNacimiento");
		            cliente.setFechaNacimiento(fechaNac); // Asegúrate de que el setter sea tipo `Date`
		            
		            cliente.setTelefono(rs.getString("Telefono"));
		            cliente.setCorreo(rs.getString("CorreoElectronico"));
		            cliente.setIdUsuario(rs.getInt("UsuarioID"));
		            
		            ListaCliente.add(cliente); // Agregar cliente a la lista
		        }
		        System.out.println("Clientes cargados correctamente.");
		        
		    } catch (SQLException ex) {
		        System.out.println("ERROR en setteo de Cliente: " + ex.getMessage());
		        ex.printStackTrace();
		    }
		    
		    return ListaCliente;
    
	
	}
}
