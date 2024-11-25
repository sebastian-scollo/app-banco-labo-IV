package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.daoMovimiento;
import entidades.Movimiento;

public class daoMovimientoImpl implements daoMovimiento{

	
	@Override
	public boolean AsigarTransaccion(Movimiento movimiento) {
	    Connection conn = null;
	    PreparedStatement ps = null;

	    try {
	        conexion bd = new conexion();
	        conn = bd.obtenerConexion();
	        conn.setAutoCommit(false); 
	        
	        System.out.println("Iniciando transacción con importe: " + movimiento.getImporte());
	        System.out.println("CBU Emisor: " + movimiento.getCuentaEmisor().getCBU());
	        System.out.println("CBU Receptor: " + movimiento.getCuentaReceptor().getCBU());
	        System.out.println("Tipo de Movimiento: " + movimiento.getTipomovimiento().getDescripcion());

	        
	        String sql = "UPDATE Cuentas SET Saldo = Saldo - ? WHERE CBU = ? AND Saldo >= ?";
	        ps = conn.prepareStatement(sql);
	        ps.setDouble(1, movimiento.getImporte());
	        ps.setString(2, movimiento.getCuentaEmisor().getCBU()); 
	        ps.setDouble(3, movimiento.getImporte());
	        int filasAfectadas = ps.executeUpdate();
	        
	        System.out.println("Filas afectadas al actualizar cuenta emisora: " + filasAfectadas);
	        
	        if (filasAfectadas == 0) {
	            System.out.println("Error: El saldo de la cuenta emisora es insuficiente.");
	            conn.rollback();
	            return false;
	        }

	        
	        sql = "UPDATE Cuentas SET Saldo = Saldo + ? WHERE CBU = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setDouble(1, movimiento.getImporte());
	        ps.setString(2, movimiento.getCuentaReceptor().getCBU());
	        ps.executeUpdate();

	        System.out.println("Actualizando cuenta receptor: " + movimiento.getCuentaReceptor().getCBU());
	        System.out.println("Saldo a agregar: " + movimiento.getImporte());

	       
	        sql = "INSERT INTO Movimientos (Detalle, Importe, cbuEmisor, cbuReceptor, TipoMovimientoID) " +
	              "VALUES (?, ?, ?, ?, ?)";
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, movimiento.getDetalle());
	        ps.setDouble(2, movimiento.getImporte());
	        ps.setString(3, movimiento.getCuentaEmisor().getCBU()); 
	        ps.setString(4, movimiento.getCuentaReceptor().getCBU()); 
	        ps.setInt(5, movimiento.getTipomovimiento().getIdTipoMovimiento()); 

	        System.out.println("Insertando movimiento con detalle: " + movimiento.getDetalle());
	        System.out.println("Importe: " + movimiento.getImporte());
	        System.out.println("CBU Emisor: " + movimiento.getCuentaEmisor().getCBU());
	        System.out.println("CBU Receptor: " + movimiento.getCuentaReceptor().getCBU());
	        System.out.println("TipoMovimientoID: " + movimiento.getTipomovimiento().getIdTipoMovimiento());

	        ps.executeUpdate();

	        System.out.println("Movimiento insertado exitosamente.");
	        
	        conn.commit(); 
	        System.out.println("Transacción completada con éxito.");
	        return true;

	    } catch (Exception e) {
	        if (conn != null) {
	            try {
	                conn.rollback(); 
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	        System.out.println("Error durante la transacción: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        
	        if (ps != null) {
	            try {
	                ps.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return false; 
	}



}
