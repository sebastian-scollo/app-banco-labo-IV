package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Cliente;
import entidades.Usuario;
import dao.UsuarioDao;

public class UsuarioDaoImpl implements UsuarioDao {
    private conexion con = new conexion(); 

    @Override
    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE NombreUsuario = ? AND Estado = 1";

       
        PreparedStatement ps = con.getPreparedStatement(query);

        try {
            if (ps != null) {
                
                ps.setString(1, nombreUsuario);
                ResultSet rs = ps.executeQuery();

                // Procesamos el resultado
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIDUsuario(rs.getInt("IDUsuario"));
                    usuario.setPassword(rs.getString("Contrasenia")); 
                    usuario.setTipoUsuario(rs.getInt("TipoUsuario"));
                    usuario.setEstado(rs.getBoolean("Estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
         
            try {
                if (ps != null) ps.close();
                if (con.cn != null) con.cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
    
    public boolean EditarContrasenaUsuario(String usuario, String password, String newPassword) {
  	  try {
  	        Class.forName("com.mysql.jdbc.Driver"); 
  	        System.out.println("Driver MySQL cargado correctamente.");
  	    } catch(ClassNotFoundException e) {
  	        System.out.println("Error al cargar el driver MySQL.");
  	        e.printStackTrace();
  	     
  	    }
  	
  	  String consulta = "update Usuarios Set Contrasenia = ? WHERE  NombreUsuario=? AND Contrasenia=?";
  	  conexion cn = new conexion();
  	    Connection connection = cn.obtenerConexion();
  	    if (connection == null) {
  	        return false;
  	    }
  	    try {
  	    	PreparedStatement statement = connection.prepareStatement(consulta);
  	    	
  	    	statement.setString(1,newPassword);
  	    	statement.setString(2,usuario);
  	    	statement.setString(3,password);
              int actualizado = statement.executeUpdate();
              return actualizado >0;
  	    }catch(Exception ex) {
  	    	ex.printStackTrace();
  	    	return false;
  	    }
    }

	@Override
	public Cliente DatosPersonal(int idUsuario) {
	    conexion bd = new conexion();
	    Cliente cliente = null; 
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = bd.obtenerConexion();
	        String query = "SELECT * FROM Clientes WHERE UsuarioID=?";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, idUsuario);
	        rs = ps.executeQuery();
	        
	        if(rs.next()) {
	            cliente = new Cliente(); 
	            cliente.setDni(rs.getString("DNI"));
	            cliente.setCuil(rs.getString("CUIL"));
	            cliente.setNombre(rs.getString("Nombre"));
	            cliente.setApellido(rs.getString("Apellido"));
	            cliente.setSexo(rs.getString("Sexo"));
	            cliente.setNacionalidad(rs.getString("Nacionalidad"));
	            cliente.setFechaNacimiento(rs.getDate("FechaNacimiento"));
	            cliente.setTelefono(rs.getString("Telefono"));
	            cliente.setCorreo(rs.getString("CorreoElectronico"));
	        }
	        
	       
	        System.out.println("Buscando usuario con ID: " + idUsuario);
	        
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        try {
	            if(rs != null) rs.close();
	            if(ps != null) ps.close();
	            if(conn != null) conn.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return cliente;
	}

	@Override
	public int buscarXid(String nombreUsuario) {
		  Connection conexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    int idUsuario = -1; 
            conexion bd = new conexion();
		    try {
		        
		        conexion = bd.obtenerConexion();

		        String sql = "SELECT IDUsuario FROM Usuarios WHERE NombreUsuario = ?";
		        preparedStatement = conexion.prepareStatement(sql);
		        preparedStatement.setString(1, nombreUsuario);

		        resultSet = preparedStatement.executeQuery();

		        if (resultSet.next()) {
		            idUsuario = resultSet.getInt("IDUsuario"); 
		        }
		    } catch (SQLException e) {
		        e.printStackTrace(); 
		    } finally {
		    
		        try {
		            if (resultSet != null) resultSet.close();
		            if (preparedStatement != null) preparedStatement.close();
		            if (conexion != null) conexion.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		    return idUsuario; 
	}
}