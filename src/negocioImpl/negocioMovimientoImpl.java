package negocioImpl;

import daoImpl.daoMovimientoImpl;
import entidades.Movimiento;
import negocio.negocioMovimiento;

import java.util.ArrayList;

import dao.daoMovimiento;
public class negocioMovimientoImpl implements negocioMovimiento{
   daoMovimiento daoMovimiento = new daoMovimientoImpl();
    
	public boolean AsigarTransaccion(Movimiento movimiento) {
		return daoMovimiento.AsigarTransaccion(movimiento);
	}
	
	public ArrayList<Movimiento> getMovimientosUsuario(int id) {
		return daoMovimiento.getMovimientosUsuario(id);
	}
}
