package dao;

import entidades.Usuario;

public interface UsuarioDao {
    Usuario obtenerUsuarioPorNombre(String nombreUsuario);
}