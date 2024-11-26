package negocio;

import java.util.ArrayList;

import entidades.Movimiento;

public interface negocioMovimiento {
	 boolean AsigarTransaccion(Movimiento movimiento);
	 public ArrayList<Movimiento> getMovimientosUsuario(int id);
}
