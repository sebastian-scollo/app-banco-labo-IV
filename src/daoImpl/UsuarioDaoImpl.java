package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}