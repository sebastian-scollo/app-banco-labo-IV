package dao;
import entidades.Cuenta;
import entidades.Movimiento;
public interface daoMovimiento {
	
  boolean AsigarTransaccion(Movimiento movimiento);
  
}
