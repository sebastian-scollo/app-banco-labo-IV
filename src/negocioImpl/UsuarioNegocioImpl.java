package negocioImpl;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidades.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio {
    private UsuarioDao usuarioDao = new UsuarioDaoImpl();

    @Override
    public Usuario autenticarUsuario(String usuario, String password) {
        Usuario user = usuarioDao.obtenerUsuarioPorNombre(usuario);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}