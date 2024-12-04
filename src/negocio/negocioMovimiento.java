package negocio;

import java.util.ArrayList;

import entidades.Movimiento;
import entidades.Prestamo;

public interface negocioMovimiento {
	 boolean AsigarTransaccion(Movimiento movimiento);
	 public ArrayList<Movimiento> getMovimientosUsuario(int id);
	 public ArrayList<Movimiento> getMovimientosUsuarioPorCBU(int id, String cbu);
	 public boolean registrarMovimiento(Movimiento movimiento);
	 public boolean altaPrestamo(Prestamo prestamo);
}
