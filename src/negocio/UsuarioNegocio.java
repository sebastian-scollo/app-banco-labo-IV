package negocio;

import entidades.Usuario;

public interface UsuarioNegocio {
    Usuario autenticarUsuario(String usuario, String password);
}