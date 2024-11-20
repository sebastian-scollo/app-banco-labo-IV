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


@Override
public boolean RegistrarCliente(Cliente cliente) {
    PreparedStatement pstUsuario = null;
    PreparedStatement pstCliente = null;
    PreparedStatement pstDireccion = null;
    conexion cn = new conexion();
    Connection connection = cn.obtenerConexion();

    ResultSet rs = null;
    int usuarioID = 0;
    int clienteID = 0;

    try {
        if(cliente == null) {
            System.out.println("Se ha detectado un error al querer registrar al cliente.");
            return false;
        }

        connection.setAutoCommit(false); 

       
        String insertUsuario = "INSERT INTO Usuarios (NombreUsuario, Contrasenia, TipoUsuario, Estado) VALUES (?, ?, ?, ?)";
        pstUsuario = connection.prepareStatement(insertUsuario, Statement.RETURN_GENERATED_KEYS); 
        pstUsuario.setString(1, cliente.getNombreUsuario());
        pstUsuario.setString(2, cliente.getPassword());
        pstUsuario.setInt(3, 2);
        pstUsuario.setBoolean(4, true);  
        pstUsuario.executeUpdate();
        
      
        rs = pstUsuario.getGeneratedKeys();
        if (rs.next()) {
            usuarioID = rs.getInt(1); 
        }
        rs.close();

     
        String insertCliente = "INSERT INTO Clientes (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, Telefono, CorreoElectronico, UsuarioID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pstCliente = connection.prepareStatement(insertCliente, Statement.RETURN_GENERATED_KEYS); // Agregar RETURN_GENERATED_KEYS aquí
        pstCliente.setString(1, cliente.getDni());
        pstCliente.setString(2, cliente.getCuil());
        pstCliente.setString(3, cliente.getNombre());
        pstCliente.setString(4, cliente.getApellido());
        pstCliente.setString(5, cliente.getSexo());
        pstCliente.setString(6, cliente.getNacionalidad());
        pstCliente.setDate(7, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
        pstCliente.setString(8, cliente.getTelefono());
        pstCliente.setString(9, cliente.getCorreo());
        pstCliente.setInt(10, usuarioID); 
        pstCliente.executeUpdate();
        
        
        rs = pstCliente.getGeneratedKeys();
        if (rs.next()) {
            clienteID = rs.getInt(1);
        }
        rs.close();

    
        String sqlDireccion = "INSERT INTO Direcciones (Calle, Numero, Piso, Departamento, LocalidadID, ClienteID) VALUES (?, ?, ?, ?, ?, ?)";
        pstDireccion = connection.prepareStatement(sqlDireccion);
        pstDireccion.setString(1, cliente.getDireccion().getNombrecalle());
        pstDireccion.setInt(2, cliente.getDireccion().getNumerCalle());
        if (cliente.getDireccion().getPiso() >= 0) {
            pstDireccion.setInt(3, cliente.getDireccion().getPiso());
        } else {
            pstDireccion.setNull(3, java.sql.Types.INTEGER);
        }
        if (cliente.getDireccion().getDepartamento() != null) {
            pstDireccion.setString(4, cliente.getDireccion().getDepartamento());
        } else {
            pstDireccion.setNull(4, java.sql.Types.VARCHAR);
        }
        pstDireccion.setInt(5, cliente.getDireccion().getNroLocalidad());
        pstDireccion.setInt(6, clienteID); 
        pstDireccion.executeUpdate();

        connection.commit();
        return true;

    } catch (SQLException e) {
        System.err.println("Error en la inserción del cliente: " + e.getMessage());
        e.printStackTrace();
        try {
            if (connection != null) connection.rollback(); // Deshace todas las inserciones en caso de error
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        return false;

    } finally {
        // Cierra los recursos
        try {
            if (rs != null) rs.close();
            if (pstUsuario != null) pstUsuario.close();
            if (pstCliente != null) pstCliente.close();
            if (pstDireccion != null) pstDireccion.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

@Override
public boolean verificarDNI(String DNI) {
	boolean existe = false;
	try {
		conexion cn = new conexion();
	    Connection connection = cn.obtenerConexion();
	    String consulta = "select *  from clientes where DNI = ?";
	    PreparedStatement pst = cn.getPreparedStatement(consulta);
        pst.setString(1, DNI);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            existe = true; 
        }
        rs.close();
        pst.close();
        connection.close();
	   
	    
	}catch (Exception e)
	{
		e.printStackTrace();
	}
	return existe;
}

@Override
public boolean verificarCUIL(String CUIL) {
	boolean existe = false;
	try {
		conexion cn = new conexion();
	    Connection connection = cn.obtenerConexion();
	    String consulta = "select *  from clientes where CUIL = ?";
	    PreparedStatement pst = cn.getPreparedStatement(consulta);
        pst.setString(1, CUIL);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            existe = true; 
        }
        rs.close();
        pst.close();
        connection.close();
	   
	    
	}catch (Exception e)
	{
		e.printStackTrace();
	}
	return existe;
}

@Override
public boolean EditarCliente(Cliente cliente) {
	  try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch(ClassNotFoundException e) {
	        System.out.println("Error al cargar el driver MySQL.");
	        e.printStackTrace();
	     
	    }
	
	  String consulta = "update Clientes Set Nombre = ?, Apellido=?,Sexo=?,Telefono=?,CorreoElectronico=? WHERE DNI=?";
	  conexion cn = new conexion();
	    Connection connection = cn.obtenerConexion();
	    if (connection == null) {
	        return false;
	    }
	    try {
	    	PreparedStatement statement = connection.prepareStatement(consulta);
	    	
	    	statement.setString(1,cliente.getNombre());
	    	statement.setString(2,cliente.getApellido());
	    	statement.setString(3,cliente.getSexo());
	    	statement.setString(4,cliente.getTelefono());
	    	statement.setString(5,cliente.getCorreo());
	    	statement.setString(6,cliente.getDni());
            int actualizado = statement.executeUpdate();
            return actualizado >0;
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    	return false;
	    }
  }
@Override
public boolean ExisteIdCliente(int idCliente) {
	boolean existencia = false;
	try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch(ClassNotFoundException e) {
	        System.out.println("Error al cargar el driver MySQL F compa.");
	        e.printStackTrace();
	     
	    }
	  
	  String consulta = "SELECT IDCliente FROM Clientes WHERE IDCliente=?";
	  conexion cn = new conexion();
	    Connection connection = cn.obtenerConexion();
	 try {
		 PreparedStatement pst = cn.getPreparedStatement(consulta);
	        pst.setInt(1, idCliente);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	existencia = true; 
	        }
	        rs.close();
	        pst.close();
	        connection.close();
		 
	 }catch(Exception ex) {
		 ex.printStackTrace();
	 }
	return existencia;
}




}
