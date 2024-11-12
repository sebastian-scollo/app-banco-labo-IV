package dao;

import java.util.ArrayList;

import entidades.Cuenta;

public interface daoCuenta {
  public ArrayList<Cuenta>ListarCuenta();
  public ArrayList<Cuenta>ListarXtipoCuenta(int paramTipoCuenta);
  public ArrayList<Cuenta>ListarXidCl(int idCliente);
}
