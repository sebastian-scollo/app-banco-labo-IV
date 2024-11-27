package negocioImpl;

import java.util.ArrayList;

import dao.daoOpcionCuenta;
import daoImpl.daoOpcionCuentaImpl;
import entidades.Cuenta;
import negocio.negocioOpcionCuenta;

public class negocioOpcionCuentaImpl implements negocioOpcionCuenta {
        daoOpcionCuenta dao = new daoOpcionCuentaImpl();
	@Override
	public ArrayList<Cuenta> OpcionCuentas(int idUsuario) {
	   return dao.OpcionCuentas(idUsuario);
	}

}
