package negocioImpl;

import daoImpl.daoMovimientoImpl;
import entidades.Movimiento;
import negocio.negocioMovimiento;
import dao.daoMovimiento;
public class negocioMovimientoImpl implements negocioMovimiento{
   daoMovimiento daoMovimiento = new daoMovimientoImpl();
    
	public boolean AsigarTransaccion(Movimiento movimiento) {
		return daoMovimiento.AsigarTransaccion(movimiento);
	}
	

}
