package negocio;

import java.util.ArrayList;

import entidades.Cuenta;

public interface negocioCuenta {
	
	public ArrayList<Cuenta>ListarCuenta();
	  public ArrayList<Cuenta>ListarXtipoCuenta(int paramTipoCuenta);
	  public ArrayList<Cuenta>ListarXidCl(int idCliente);
	
	
}
