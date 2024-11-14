package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Usuario;
import dao.UsuarioDao;

public class UsuarioDaoImpl implements UsuarioDao {
    private conexion con = new conexion(); // Usamos tu clase conexion

    @Override
    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE NombreUsuario = ? AND Estado = 1";

        // Obtenemos un PreparedStatement utilizando tu método de la clase conexion
        PreparedStatement ps = con.getPreparedStatement(query);

        try {
            if (ps != null) {
                // Establecemos el parámetro del PreparedStatement
                ps.setString(1, nombreUsuario);
                ResultSet rs = ps.executeQuery();

                // Procesamos el resultado
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIDUsuario(rs.getInt("IDUsuario"));
                    usuario.setPassword(rs.getString("Contrasenia")); // Ajustado a tu tabla
                    usuario.setTipoUsuario(rs.getInt("TipoUsuario"));
                    usuario.setEstado(rs.getBoolean("Estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerramos el PreparedStatement y la conexión para evitar fugas
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