package negocio;

import java.util.ArrayList;
import java.util.Date;

import entidades.Cuenta;

public interface negocioCuenta {
	
	public ArrayList<Cuenta>ListarCuenta();
	  public ArrayList<Cuenta>ListarXtipoCuenta(int paramTipoCuenta);
	  public ArrayList<Cuenta>ListarXidCl(int idCliente);
	public int NuevaId();
	public boolean AgregarCuenta(Cuenta cuenta);
	public boolean eliminarCuenta(int iDcuenta);
	public boolean ModificarCuenta(Cuenta cuenta);
	public boolean CantidadCuenta(int idCleinte);
	  public boolean repiteNroCuenta(String nroCuenta);
	  public boolean repiteCbu(String cbu);

}
