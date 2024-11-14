package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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
		        Class.forName("com.mysql.jdbc.Driver"); 
		        System.out.println("Driver MySQL cargado correctamente.");
		    } catch(ClassNotFoundException e) {
		        System.out.println("Error al cargar el driver MySQL.");
		        e.printStackTrace();
		        return ListaCliente; 
		    }
		    
		    conexion ruta = new conexion();
		    Connection cn = ruta.obtenerConexion();

		    if (cn == null) {
		        System.out.println("Conexión fallida: la conexión es null.");
		        return ListaCliente; 
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
		            
		           
		            Date fechaNac = rs.getDate("FechaNacimiento");
		            cliente.setFechaNacimiento(fechaNac); 
		            
		            cliente.setTelefono(rs.getString("Telefono"));
		            cliente.setCorreo(rs.getString("CorreoElectronico"));
		            cliente.setIdUsuario(rs.getInt("UsuarioID"));
		            
		            ListaCliente.add(cliente); 
		        }
		        System.out.println("Clientes cargados correctamente.");
		        
		    } catch (SQLException ex) {
		        System.out.println("ERROR en setteo de Cliente: " + ex.getMessage());
		        ex.printStackTrace();
		    }
		    
		    return ListaCliente;
	}
	//filtro/busquedas etc no se

@Override
public ArrayList<Cliente> ListarDni(String paramDni) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	conexion cn = new conexion();
	Connection connnection = cn.obtenerConexion();
	
	
	String consulta = "SELECT IDCliente, DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, Telefono, CorreoElectronico, UsuarioID FROM Clientes WHERE activo=1" 
            + (paramDni != null ? " AND DNI=" + paramDni : "");

	
	ArrayList<Cliente> resultado=new ArrayList<Cliente>() ;
	try {
		Statement st = connnection.createStatement();
		ResultSet rs = st.executeQuery(consulta);
		while(rs.next()) {
			 Cliente cliente = new Cliente();
	            
	            cliente.setIdCliente(rs.getInt("IDCliente"));
	            cliente.setDni(rs.getString("DNI"));
	            cliente.setCuil(rs.getString("CUIL"));
	            cliente.setNombre(rs.getString("Nombre"));
	            cliente.setApellido(rs.getString("Apellido"));
	            cliente.setSexo(rs.getString("Sexo"));
	            cliente.setNacionalidad(rs.getString("Nacionalidad"));
	            
	           
	            Date fechaNac = rs.getDate("FechaNacimiento");
	            cliente.setFechaNacimiento(fechaNac); 
	            
	            cliente.setTelefono(rs.getString("Telefono"));
	            cliente.setCorreo(rs.getString("CorreoElectronico"));
	            cliente.setIdUsuario(rs.getInt("UsuarioID"));
	            resultado.add(cliente);
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
		System.out.println("falla en buscar param."+ex);
	}
   
	
	return resultado;
}

@Override
public ArrayList<Cliente> ListarNombre(String paramNombre) {
	  ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	    
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    try {
	        conexion cn = new conexion();
	        Connection connection = cn.obtenerConexion();
	        String consulta = "SELECT IDCliente, DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, Telefono, CorreoElectronico, UsuarioID " +
	                          "FROM Clientes " +
	                          "WHERE activo = 1 AND Nombre LIKE ?";

	        PreparedStatement mtt = connection.prepareStatement(consulta);

	        mtt.setString(1, "%" + paramNombre + "%");

	        ResultSet rs = mtt.executeQuery();

	        while (rs.next()) {
	            Cliente cliente = new Cliente();
	            cliente.setIdCliente(rs.getInt("IDCliente"));
	            cliente.setDni(rs.getString("DNI"));
	            cliente.setCuil(rs.getString("CUIL"));
	            cliente.setNombre(rs.getString("Nombre"));
	            cliente.setApellido(rs.getString("Apellido"));
	            cliente.setSexo(rs.getString("Sexo"));
	            cliente.setNacionalidad(rs.getString("Nacionalidad"));
	            cliente.setFechaNacimiento(rs.getDate("FechaNacimiento"));
	            cliente.setTelefono(rs.getString("Telefono"));
	            cliente.setCorreo(rs.getString("CorreoElectronico"));
	            cliente.setIdUsuario(rs.getInt("UsuarioID"));
	            
	            listaClientes.add(cliente);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("falla en buscar por Nombre." + e);
	    }
	    return listaClientes;
}

@Override
public boolean eliminarCliente(int paraIdcliente) {
	  try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch(ClassNotFoundException e) {
	        System.out.println("Error al cargar el driver MySQL.");
	        e.printStackTrace();
	     
	    }
	  String consulta = "update Clientes set activo = 0 WHERE IDCliente = ?";
	  try {
		  conexion bd = new conexion();
		  Connection cnn = bd.obtenerConexion();
		  PreparedStatement ps = cnn.prepareStatement(consulta);
		  ps.setInt(1, paraIdcliente);
		  int actualizado = ps.executeUpdate();
		  return actualizado>0;
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }
	  return false;
}
	

}
