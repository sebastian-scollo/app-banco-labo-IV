package dao;
import entidades.Cuenta;
import java.util.ArrayList;
import java.util.Date;
import entidades.Cuenta;

public interface daoCuenta {
  public ArrayList<Cuenta>ListarCuenta();
  public ArrayList<Cuenta>ListarXtipoCuenta(int paramTipoCuenta);
  public ArrayList<Cuenta>ListarXidCl(int idCliente);
  public int NuevaId();
  public boolean AgregarCuenta(Cuenta cuenta);
  public boolean eliminarCuenta(int idCuenta);
  public boolean ModificarCuenta(Cuenta cuenta);
  public boolean CantidadCuenta(int idCliente, int idCuenta);
  public boolean repiteNroCuenta(String nroCuenta);
  public boolean repiteCbu(String cbu);
 Cuenta cuentaXcbu(String cbu);
 
}
