package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.daoCuota;
public class daoCuotaImpl implements daoCuota{

	@Override
	public Double ValorCuotaIndividual(int idPrestamo) {
		 String consulta = "SELECT ROUND(ImporteAPagar / Plazo, 2) AS ValorCuota FROM Prestamos WHERE IDPrestamo = ?";
		    Double valorCuota = null;
             conexion bd = new conexion();
             Connection conn=null;
             try {
            	 conn =  bd.obtenerConexion();
             }
             catch(Exception ex) {
            	 ex.printStackTrace();
            	 System.out.println("OH NO MI COMPA"+ex.getMessage());
             }
		    try 
		          {
		    	PreparedStatement ps = conn.prepareStatement(consulta);
		        ps.setInt(1, idPrestamo);
		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                valorCuota = rs.getDouble("ValorCuota");
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		     
		    }

		    return valorCuota;
	}

}
