package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.daoReporte;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Provincia;
import entidades.TipoMovimiento;

public class daoReporteImpl implements daoReporte {
	public List<Cliente> obtenerClientesPorProvincia(int provinciaID){
		 List<Cliente> clientes = new ArrayList<>();
	        
	        String query = "SELECT c.IDCliente, c.DNI, c.Nombre, c.Apellido, c.Sexo, c.Nacionalidad, c.FechaNacimiento, "
	                     + "c.Telefono, c.CorreoElectronico, c.CUIL "
	                     + "FROM Clientes c "
	                     + "INNER JOIN Direcciones d ON c.IDCliente = d.ClienteID "
	                     + "INNER JOIN Localidades l ON d.LocalidadID = l.IDLocalidad "
	                     + "WHERE l.ProvinciaID = ?";

	        try {
	     	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("Driver MySQL cargado correctamente.");

	            conexion bd = new conexion();
	            Connection conn = bd.obtenerConexion();

	            try (PreparedStatement stmt = conn.prepareStatement(query)) {
	                stmt.setInt(1, provinciaID); 

	                try (ResultSet rs = stmt.executeQuery()) {
	                    while (rs.next()) {
	                        Cliente cliente = new Cliente();
	                        cliente.setIdCliente(rs.getInt("IDCliente"));
	                        cliente.setDni(rs.getString("DNI"));
	                        cliente.setNombre(rs.getString("Nombre"));
	                        cliente.setApellido(rs.getString("Apellido"));
	                        cliente.setSexo(rs.getString("Sexo"));
	                        cliente.setNacionalidad(rs.getString("Nacionalidad"));
	                        cliente.setFechaNacimiento(rs.getDate("FechaNacimiento"));
	                        cliente.setTelefono(rs.getString("Telefono"));
	                        cliente.setCorreo(rs.getString("CorreoElectronico"));   
	                        cliente.setCuil(rs.getString("CUIL"));
	                        clientes.add(cliente);
	                    }
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            System.out.println("Error al cargar el driver MySQL.");
	            e.printStackTrace();
	        }

	        Provincia provincia = obtenerProvinciaPorID(provinciaID);
	        for (Cliente cliente : clientes) {
	            cliente.setProvincia(provincia); 
	        }
	        return clientes;
		
	}
	  private Provincia obtenerProvinciaPorID(int provinciaID) {
		  
	        String consulta = "SELECT IDProvincia, Nombre FROM Provincias WHERE IDProvincia = ?";
	        Provincia provincia = null;

	        try {
	            
	            conexion bd = new conexion();
	            Connection conn = bd.obtenerConexion();

	            try (PreparedStatement stmt = conn.prepareStatement(consulta)) {
	                stmt.setInt(1, provinciaID);
	                try (ResultSet rs = stmt.executeQuery()) {
	                    if (rs.next()) {
	                        provincia = new Provincia(rs.getInt("IDProvincia"), rs.getString("Nombre"));
	                    }
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return provincia;
	    }
	  @Override
		public ArrayList<Cuenta> BusquedaIntervaloFecha(Date fechaInicio, Date fechaFinal) {
		    try {
		        Class.forName("com.mysql.jdbc.Driver"); 
		        System.out.println("Driver MySQL cargado correctamente.");
		    } catch (ClassNotFoundException e) {
		        System.out.println("Error mi compa");
		        e.printStackTrace();
		    }

		    String consulta = "SELECT CBU, Saldo, ClienteID, FechaCreacion FROM Cuentas WHERE FechaCreacion >= ? AND FechaCreacion <= ?";
		    conexion cn = new conexion();
		    Connection connection = cn.obtenerConexion();
		    ArrayList<Cuenta> lista = new ArrayList<>();

		    try (PreparedStatement ps = connection.prepareStatement(consulta)) {
		      
		        ps.setDate(1, (java.sql.Date) fechaInicio);
		        ps.setDate(2, (java.sql.Date) fechaFinal);

		       
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Cuenta cuenta = new Cuenta();
		            cuenta.setCBU(rs.getString("CBU"));
		            cuenta.setClienteId(rs.getInt("ClienteID"));
		            cuenta.setSaldo(rs.getDouble("Saldo"));
		            cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));
		            lista.add(cuenta);
		        }

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }

		    return lista;

		}
		
		public ArrayList<Cuenta> BusquedaIntervaloSaldo(int saldoInicio, int saldoFinal) {
		    try {
		        Class.forName("com.mysql.jdbc.Driver"); 
		        System.out.println("Driver MySQL cargado correctamente.");
		    } catch (ClassNotFoundException e) {
		        System.out.println("Error mi compa");
		        e.printStackTrace();
		    }
		    
		    String consulta = "SELECT CBU, ClienteID, Saldo, FechaCreacion FROM Cuentas WHERE Saldo BETWEEN ? And ? ORDER BY SALDO";
		    conexion cn = new conexion();
		    Connection connection = cn.obtenerConexion();
		    ArrayList<Cuenta> lista = new ArrayList<>();

		    try (PreparedStatement ps = connection.prepareStatement(consulta)) {
		      
		    	ps.setInt(1, saldoInicio); 
		    	ps.setInt(2, saldoFinal); 

		       
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Cuenta cuenta = new Cuenta();
		            cuenta.setCBU(rs.getString("CBU"));
		            cuenta.setClienteId(rs.getInt("ClienteID"));
		            cuenta.setSaldo(rs.getDouble("Saldo"));
		            cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));
		            lista.add(cuenta);
		        }

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }

		    return lista;

		}
		@Override
		public ArrayList<Object> TotalYPorcentaje(int idTipoMovimiento) {
			 ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
			 ArrayList<Double> listaPorcentaje = new ArrayList<>();

			    String sql = "SELECT tm.Descripcion AS TipoMovimiento,SUM(m.Importe) AS TotalMovimiento,(SUM(m.Importe) / (SELECT SUM(Importe) FROM Movimientos) * 100) AS Porcentaje FROM Movimientos m JOIN TipoMovimientos tm ON m.TipoMovimientoID = tm.IDTipoMovimiento WHERE m.TipoMovimientoID = ? GROUP BY tm.Descripcion";
			       
                conexion bd = new conexion();
			    try (Connection conn = bd.obtenerConexion();
			         PreparedStatement ps = conn.prepareStatement(sql)) {

			        ps.setInt(1, idTipoMovimiento);
			   
			        try (ResultSet rs = ps.executeQuery()) {
			            while (rs.next()) {
			                TipoMovimiento tipoMovimiento = new TipoMovimiento(
			                    idTipoMovimiento,
			                    rs.getString("TipoMovimiento")
			                );

			                Movimiento movimiento = new Movimiento();
			                movimiento.setTipomovimiento(tipoMovimiento);
			                movimiento.setImporte(rs.getDouble("TotalMovimiento"));

			              
			                listaMovimientos.add(movimiento);
			                if (listaPorcentaje.isEmpty()) {
			                    listaPorcentaje.add(rs.getDouble("Porcentaje"));
			                }
			            }
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }

			    ArrayList<Object> resultado = new ArrayList<>();
			    resultado.add(listaMovimientos); 
			    resultado.add(listaPorcentaje);  

			    return resultado;
		}
	
}
