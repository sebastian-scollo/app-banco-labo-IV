package dao;

import entidades.Usuario;

public interface UsuarioDao {
    Usuario obtenerUsuarioPorNombre(String nombreUsuario);
    public boolean EditarContrase�aUsuario(String usuario, String password, String newPassword);
}
