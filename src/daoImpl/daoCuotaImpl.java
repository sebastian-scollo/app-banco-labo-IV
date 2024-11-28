package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoCuota;
import entidades.Cuenta;
import entidades.Cuota;
import entidades.Prestamo;
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

	@Override
	public ArrayList<Prestamo> ListarPrestamos(String cbu) {
	  ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
	  Connection cnn = null;
	  conexion bd = new conexion();
	  String sql ="SELECT IDPrestamo,ImporteAPagar,Plazo,CBU,IDCuenta,Saldo FROM Prestamos INNER JOIN Cuentas oN Prestamos.CuentaID = Cuentas.IDCuenta WHERE Cuentas.CBU = ?";
	  try {cnn = bd.obtenerConexion();}catch(Exception ex) {System.out.println("F mi compa"+ex.getMessage());}
		try {
			 PreparedStatement ps = cnn.prepareStatement(sql);
		            ps.setString(1, cbu); 
		            ResultSet rs = ps.executeQuery();
		            while (rs.next()) {
	                   
	                    Prestamo prestamo = new Prestamo();
	                    prestamo.setIdPrestamo(rs.getInt("IDPrestamo"));
	                    prestamo.setImporteApagar(rs.getDouble("ImporteAPagar"));
	                    prestamo.setPlazo(rs.getInt("Plazo"));
                        
	                    Cuenta cuenta = new Cuenta();
	                    cuenta.setCBU(rs.getString("CBU"));
	                    cuenta.setIdCuenta(rs.getInt("IDCuenta"));
	                    cuenta.setSaldo(rs.getDouble("Saldo"));
	                    prestamo.setCuenta(cuenta); 

	                    lista.add(prestamo); 
	                }
		}catch(Exception ex){ex.printStackTrace();}
	  return lista;
	}

	@Override
	public ArrayList<Cuota> getCuotaPendiente(int idPrestamo) {
		 ArrayList<Cuota> lista = new ArrayList<>();
		    Connection cnn = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    
		    try {
		        conexion bd = new conexion();
		        cnn = bd.obtenerConexion();
		        
		        String sql = "SELECT IDCuota, NumeroCuota, ImporteAbonado " +
		                     "FROM Cuotas " +
		                     "WHERE PrestamoID = ? AND Estado = 0"; 
		        
		        ps = cnn.prepareStatement(sql);
		        ps.setInt(1, idPrestamo);
		        
		        rs = ps.executeQuery();
		        
		        while (rs.next()) {
		            Cuota cuota = new Cuota();
		            cuota.setIdCuota(rs.getInt("IDCuota"));
		            cuota.setNroCuota(rs.getInt("NumeroCuota"));
		            cuota.setImporteAbonado(rs.getDouble("ImporteAbonado"));
		            lista.add(cuota);
		        }
		    } catch(SQLException ex) {ex.printStackTrace(); }
		    return lista;
}

	@Override
	public boolean pagarCuota(int idCuota, double importe) {
	    String sql = "UPDATE Cuotas SET ImporteAbonado = ?, Estado = 1 WHERE IDCuota = ?";
	    conexion bd = new conexion(); 
	    boolean resultado = false;

	    try (Connection conn = bd.obtenerConexion();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setDouble(1, importe);
	        ps.setInt(2, idCuota);
	        
	       
	        int filasActualizadas = ps.executeUpdate();
	        if (filasActualizadas > 0) {
	            resultado = true; 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultado; 
	}

	@Override
	public double obtenerSaldoCuentaPorPrestamo(int idPrestamo) {
		 String sql = "SELECT c.Saldo " +
                 "FROM Cuentas c " +
                 "INNER JOIN Prestamos p ON c.IDCuenta = p.CuentaID " +
                 "WHERE p.IDPrestamo = ?";
    conexion bd = new conexion();
    double saldo = 0;

    try (Connection conn = bd.obtenerConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idPrestamo);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                saldo = rs.getDouble("Saldo");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return saldo;
	}
}
