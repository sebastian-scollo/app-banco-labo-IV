package negocioImpl;

import daoImpl.daoMovimientoImpl;
import entidades.Movimiento;
import entidades.Prestamo;
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

	public ArrayList<Movimiento> getMovimientosUsuarioPorCBU(int id, String cbu) { 
		return daoMovimiento.getMovimientosUsuarioPorCBU(id, cbu);
	}
	
	@Override
	public boolean registrarMovimiento(Movimiento movimiento) {
		return daoMovimiento.registrarMovimiento(movimiento);
	}

	@Override
	public boolean altaPrestamo(Prestamo prestamo) {
		return daoMovimiento.altaPrestamo(prestamo);
	}
}
