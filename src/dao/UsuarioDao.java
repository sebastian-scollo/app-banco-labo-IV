package dao;

import entidades.Cliente;
import entidades.Usuario;

public interface UsuarioDao {
    Usuario obtenerUsuarioPorNombre(String nombreUsuario);
    public boolean EditarContrasenaUsuario(String usuario, String password, String newPassword);
    public Cliente DatosPersonal(int idUsuario);
    
}
