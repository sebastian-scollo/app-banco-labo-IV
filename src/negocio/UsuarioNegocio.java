package negocio;

import entidades.Usuario;
import entidades.Cliente;
public interface UsuarioNegocio {
    Usuario autenticarUsuario(String usuario, String password);
    public boolean editarPassword(String usuario, String password, String newPassword);
     Cliente DatosPersonal(int idUsuario); 
}