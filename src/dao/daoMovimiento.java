package dao;
import java.util.ArrayList;

import entidades.Cuenta;
import entidades.Movimiento;
public interface daoMovimiento {
	
  boolean AsigarTransaccion(Movimiento movimiento);
  public ArrayList<Movimiento> getMovimientosUsuario(int id);
  
}
