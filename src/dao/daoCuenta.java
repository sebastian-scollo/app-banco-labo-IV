package dao;
import entidades.Cuenta;
import java.util.ArrayList;

import entidades.Cuenta;

public interface daoCuenta {
  public ArrayList<Cuenta>ListarCuenta();
  public ArrayList<Cuenta>ListarXtipoCuenta(int paramTipoCuenta);
  public ArrayList<Cuenta>ListarXidCl(int idCliente);
  public int NuevaId();
  public boolean AgregarCuenta(Cuenta cuenta);
  public boolean eliminarCuenta(int idCuenta);
  public boolean ModificarCuenta(Cuenta cuenta);

  
}
