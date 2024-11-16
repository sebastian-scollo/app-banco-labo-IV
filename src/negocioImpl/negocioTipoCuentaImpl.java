package negocioImpl;

import java.util.ArrayList;

import dao.daoTipoCuenta;
import daoImpl.daoTipoCuentaImpl;
import entidades.TipoCuenta;
import negocio.negocioTipoCuenta;

public class negocioTipoCuentaImpl implements negocioTipoCuenta {
	daoTipoCuenta dao = new daoTipoCuentaImpl();

	@Override
	public ArrayList<TipoCuenta> obtenerTiposCuentas() {
		
		return dao.obtenerTiposCuentas();
	}
   

}
