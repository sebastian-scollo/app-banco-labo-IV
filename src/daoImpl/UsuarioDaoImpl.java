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
  	
  	  String consulta = "update usuario Set Contrasenia = ? WHERE NombreUsuario=? AND Contrasenia=?";
  	  conexion cn = new conexion();
  	    Connection connection = cn.obtenerConexion();
  	    if (connection == null) {
  	        return false;
  	    }
  	    try {
  	    	PreparedStatement statement = connection.prepareStatement(consulta);
  	    	
  	    	statement.setString(1,newPassword);
  	    	statement.setString(2,usuario);
  	    	statement.setString(3,newPassword);
              int actualizado = statement.executeUpdate();
              return actualizado >0;
  	    }catch(Exception ex) {
  	    	ex.printStackTrace();
  	    	return false;
  	    }
    }
}