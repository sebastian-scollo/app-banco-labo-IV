package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date ;
import dao.daoPrestamo;
import entidades.Cliente;
import entidades.Cuenta;
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

	@Override
	public List<Prestamo> obtenerPorEstado(String estado) {
		
		List<Prestamo> prestamos = new ArrayList<>();
		conexion con = new conexion();
        String sql = "SELECT p.*, c.CBU, c.ClienteID, cl.Nombre, cl.Apellido FROM Prestamos p JOIN Cuentas c ON p.CuentaID = c.IDCuenta JOIN  Clientes cl ON c.ClienteID = cl.IDCliente WHERE p.Estado = ?";
        
        
        
        
        try {
            PreparedStatement ps = con.getPreparedStatement(sql);
            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Prestamo prestamo = new Prestamo();
        		Cuenta cuentaPrestamo = new Cuenta();
        		Cliente clientePrestamo = new Cliente();
                prestamo.setIdPrestamo(rs.getInt("IDPrestamo"));
                prestamo.setMontoSolicitado(rs.getDouble("MontoSolitado"));
                prestamo.setImporteApagar(rs.getDouble("ImporteAPagar"));
                prestamo.setPlazo(rs.getInt("Plazo"));
                prestamo.setEstado(rs.getString("Estado"));
                prestamo.setFechaSolicitado(rs.getTimestamp("FechaSolicitado") != null 
                        ? new Date(rs.getTimestamp("FechaSolicitado").getTime()) 
                        : null);
                prestamo.setFechaRespuesta(rs.getTimestamp("FechaRespuesta") != null ? new Date(rs.getTimestamp("FechaRespuesta").getTime()) : null);
                cuentaPrestamo.setIdCuenta(rs.getInt("CuentaID"));
                cuentaPrestamo.setCBU(rs.getString("CBU"));
                clientePrestamo.setIdCliente(rs.getInt("ClienteID"));
                clientePrestamo.setNombre(rs.getString("Nombre"));
                clientePrestamo.setApellido(rs.getString("Apellido"));
                cuentaPrestamo.setObjCliente(clientePrestamo);
                prestamo.setCuenta(cuentaPrestamo);
           
                prestamos.add(prestamo);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return prestamos;
	}
	@Override
	public Prestamo obtenerPorId(int IDPrestamo) {
		
        Prestamo prestamo = new Prestamo();
		conexion con = new conexion();
        String sql = "SELECT p.*, c.CBU, c.ClienteID, cl.Nombre, cl.Apellido FROM Prestamos p JOIN Cuentas c ON p.CuentaID = c.IDCuenta JOIN  Clientes cl ON c.ClienteID = cl.IDCliente WHERE p.IDPrestamo = ?";
        
        try {
            PreparedStatement ps = con.getPreparedStatement(sql);
            ps.setInt(1, IDPrestamo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
        		Cuenta cuentaPrestamo = new Cuenta();
        		Cliente clientePrestamo = new Cliente();
                prestamo.setIdPrestamo(rs.getInt("IDPrestamo"));
                prestamo.setMontoSolicitado(rs.getDouble("MontoSolitado"));
                prestamo.setImporteApagar(rs.getDouble("ImporteAPagar"));
                prestamo.setPlazo(rs.getInt("Plazo"));
                prestamo.setEstado(rs.getString("Estado"));
                prestamo.setFechaSolicitado(rs.getTimestamp("FechaSolicitado") != null 
                        ? new Date(rs.getTimestamp("FechaSolicitado").getTime()) 
                        : null);
                prestamo.setFechaRespuesta(rs.getTimestamp("FechaRespuesta") != null ? new Date(rs.getTimestamp("FechaRespuesta").getTime()) : null);
                cuentaPrestamo.setIdCuenta(rs.getInt("CuentaID"));
                cuentaPrestamo.setCBU(rs.getString("CBU"));
                clientePrestamo.setIdCliente(rs.getInt("ClienteID"));
                clientePrestamo.setNombre(rs.getString("Nombre"));
                clientePrestamo.setApellido(rs.getString("Apellido"));
                cuentaPrestamo.setObjCliente(clientePrestamo);
                prestamo.setCuenta(cuentaPrestamo);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return prestamo;
	}
	@Override
	public boolean actualizarEstado(Prestamo prestamo) {
        String sql = "UPDATE Prestamos SET Estado = ?, FechaRespuesta = CURRENT_TIMESTAMP  WHERE IDPrestamo = ?";
        PreparedStatement ps = null;
        conexion con = new conexion();
        
        try {
        	
            ps = con.getPreparedStatement(sql);
            
            // Asignar parámetros
            ps.setString(1, prestamo.getEstado()); // Estado
            ps.setInt(2, prestamo.getIdPrestamo()); // IDPrestamo
            // Ejecutar actualización
            int filasActualizadas = ps.executeUpdate();
            // Retorna true si se actualizó al menos una fila
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                con.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	


}
