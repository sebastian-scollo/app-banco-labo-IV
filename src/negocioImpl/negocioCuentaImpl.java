package negocioImpl;
import java.util.ArrayList;

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

}