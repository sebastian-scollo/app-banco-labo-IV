package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.daoPrestamo;
import entidades.Prestamo;

public class daoPrestamoImpl implements daoPrestamo{

	@Override
	public boolean solicitarPrestamo(Prestamo prestamo) {
	    String insertPrestamo = "INSERT INTO Prestamos (MontoSolitado, ImporteAPagar, Plazo, CuentaID) VALUES (?, ?, ?, ?)";
	    try (Connection cn = new conexion().obtenerConexion();
	        PreparedStatement stmt = cn.prepareStatement(insertPrestamo)) {
	         
	        stmt.setDouble(1, prestamo.getMontoSolicitado());
	        stmt.setDouble(2, prestamo.getImporteApagar());
	        stmt.setInt(3, prestamo.getPlazo());
	        stmt.setInt(4, prestamo.getCuenta().getIdCuenta());

	        return stmt.executeUpdate() > 0; // Retorna true si se insertó una fila
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	


}
