package negocioImpl;
import java.util.ArrayList;
import java.util.Date;

import Excepciones.LimiteCuentaPorCliente;
import dao.daoCliente;
import dao.daoCuenta;
import daoImpl.daoClienteImpl;
import daoImpl.daoCuentaImpl;
import entidades.Cuenta;
import negocio.negocioCuenta;
public class negocioCuentaImpl implements negocioCuenta {

	private daoCuenta dao = new daoCuentaImpl();
	private daoCuentaImpl cuentaDao;
	@Override
	public ArrayList<Cuenta> ListarCuenta() {
		
		
		return dao.ListarCuenta();
	}

	@Override
	public ArrayList<Cuenta> ListarXtipoCuenta(int paramTipoCuenta) {
		
		return dao.ListarXtipoCuenta(paramTipoCuenta);
	}

	@Override
	public ArrayList<Cuenta> ListarXidCl(int idCliente) {
		// TODO Auto-generated method stub
		return dao.ListarXidCl(idCliente);
	}
	
	public int NuevaId() {
		return dao.NuevaId();
	}

	public boolean AgregarCuenta(Cuenta cuenta) {
		return dao.AgregarCuenta(cuenta);
	}

	@Override
	public boolean eliminarCuenta(int iDcuenta) {
		return dao.eliminarCuenta(iDcuenta);
	}
	
	public boolean ModificarCuenta(Cuenta cuenta) {
		return dao.ModificarCuenta(cuenta);
	}

	@Override
	public boolean CantidadCuenta(int idCleinte, int idCuenta) {
	
		 return  dao.CantidadCuenta(idCleinte, idCuenta);
	}

	@Override
	public boolean repiteNroCuenta(String nroCuenta) {
		return dao.repiteNroCuenta(nroCuenta);
	}

	@Override
	public boolean repiteCbu(String cbu) {

			return dao.repiteCbu(cbu);
	}

	@Override
	public Cuenta cuentaXcbu(String cbu) {
		return dao.cuentaXcbu(cbu);
	}

	
}
