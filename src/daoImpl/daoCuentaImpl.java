package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import dao.daoCuenta;
import entidades.Cliente;
import entidades.Cuenta;
public class daoCuentaImpl implements daoCuenta {

	@Override
	public ArrayList<Cuenta> ListarCuenta() {
       
		  try {
		        Class.forName("com.mysql.jdbc.Driver"); 
		        System.out.println("Driver MySQL cargado correctamente.");
		    } catch(ClassNotFoundException e) {
		        System.out.println("Error al cargar el driver MySQL.");
		        e.printStackTrace();
		     
		    }
		conexion bd = new conexion();
		Connection cnn = bd.obtenerConexion();
		if(cnn==null) {
			  System.out.println("Conexi�n fallida: la conexi�n es null.");
		        
		}
		
        String consulta= "SELECT IDCuenta,NumeroCuenta,CBU,Saldo,ClienteID,TipoCuentaID,FechaCreacion FROM Cuentas WHERE Estado=1   ";
        ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		try {
			//esta parte la llamo SETTEO:
		
			Statement st=cnn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setIdCuenta(rs.getInt("IDCuenta"));
				cuenta.setNroCuenta(rs.getString("NumeroCuenta"));
				cuenta.setCBU(rs.getString("CBU"));
				cuenta.setSaldo(rs.getDouble("Saldo"));
				cuenta.setClienteId(rs.getInt("ClienteID"));
				cuenta.setTipoCuentaId(rs.getInt("TipoCuentaID"));
				cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));
			    lista.add(cuenta);
			}
			/*SELECT IDCuenta,NumeroCuenta,CBU,Saldo,ClienteID,TipoCuentaID,FechaCreacion*/
		}catch(Exception ex){
			 System.out.println("OH NO! TP NO COMPILA EN CATCH SETTEO" + ex.getMessage());
		        ex.printStackTrace();
		}
        return lista;
	}
		
		
	

	@Override
	public ArrayList<Cuenta> ListarXidCl(int idCliente) {
		try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch(ClassNotFoundException e) {
	        System.out.println("Error al cargar el driver MySQL.");
	        e.printStackTrace();
	     
	    }
		 ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		 conexion bd = new conexion();
		 Connection cnn = bd.obtenerConexion();
		 if(cnn==null) {
			  System.out.println("Conexi�n fallida: la conexi�n es null.");
		        
		}
		 String consulta="SELECT IDCuenta,NumeroCuenta,CBU,Saldo,ClienteID,TipoCuentaID,FechaCreacion FROM Cuentas WHERE Estado=1 AND IDCuenta="+idCliente;
		try {
			Statement st=cnn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setIdCuenta(rs.getInt("IDCuenta"));
				cuenta.setNroCuenta(rs.getString("NumeroCuenta"));
				cuenta.setCBU(rs.getString("CBU"));
				cuenta.setSaldo(rs.getDouble("Saldo"));
				cuenta.setClienteId(rs.getInt("ClienteID"));
				cuenta.setTipoCuentaId(rs.getInt("TipoCuentaID"));
				cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));
			    lista.add(cuenta);
			}
		}catch(Exception ex) {
			System.out.println("Error al cargar el driver MySQL.");
	        ex.printStackTrace();
		}
		return lista;
	}
	@Override
	public ArrayList<Cuenta> ListarXtipoCuenta(int paramTipoCuenta) {
		ArrayList<Cuenta> listado = new ArrayList<Cuenta>();
		 try {
		        Class.forName("com.mysql.jdbc.Driver");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }
	        
		try {
			
			conexion bd = new conexion();
			Connection connection =bd.obtenerConexion();
			String consulta = "SELECT IDCuenta,NumeroCuenta,CBU,Saldo,ClienteID,TipoCuentaID,FechaCreacion FROM Cuentas WHERE Estado=1 AND TipoCuentaID="+paramTipoCuenta;
			PreparedStatement mtt = connection.prepareStatement(consulta);
			
			ResultSet rs = mtt.executeQuery(consulta);
			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setIdCuenta(rs.getInt("IDCuenta"));
				cuenta.setNroCuenta(rs.getString("NumeroCuenta"));
				cuenta.setCBU(rs.getString("CBU"));
				cuenta.setSaldo(rs.getDouble("Saldo"));
				cuenta.setClienteId(rs.getInt("ClienteID"));
				cuenta.setTipoCuentaId(rs.getInt("TipoCuentaID"));
				cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));
			    listado.add(cuenta);
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
	        System.out.println("falla en buscar por Nombre." + ex);
		}
		return listado;
	}
	
	public int NuevaId() {
		int id = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conexion bd = new conexion();
			Connection connection = bd.obtenerConexion();
			
			String query = "SELECT MAX(IDCuenta) + 1 FROM Cuentas";
			PreparedStatement mtt = connection.prepareStatement(query);
			
			ResultSet rs = mtt.executeQuery(query);
			rs.next();
			
			id = rs.getInt("IDCuenta");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	public boolean AgregarCuenta(Cuenta cuenta) {
		 boolean exito = true;

		    try {
		       
		        Class.forName("com.mysql.jdbc.Driver");
		    } catch (ClassNotFoundException e) {
		        exito = false;
		        e.printStackTrace();
		    }

		    try {
		      
		        conexion bd = new conexion();
		        Connection connection = bd.obtenerConexion();

		      
		        String query = "INSERT INTO Cuentas (NumeroCuenta, CBU, Saldo, ClienteID, TipoCuentaID) " +
		                       "VALUES (?, ?, ?, ?, ?)";

		       
		        PreparedStatement mtt = connection.prepareStatement(query);
		        mtt.setString(1, cuenta.getNroCuenta());    
		        mtt.setString(2, cuenta.getCBU());     
		        mtt.setDouble(3, cuenta.getSaldo());    
		        mtt.setInt(4, cuenta.getClienteId());    
		        mtt.setInt(5, cuenta.getTipoCuentaId());
		        mtt.executeUpdate();

		    } catch (Exception e) {
		        exito = false;
		        e.printStackTrace();
		    }

		    return exito;
	}



	@Override
	public boolean eliminarCuenta(int idCuenta) {
		  try {
		        Class.forName("com.mysql.jdbc.Driver"); 
		        System.out.println("Driver MySQL cargado correctamente.");
		    } catch(ClassNotFoundException e) {
		        System.out.println("Error al cargar el driver MySQL.");
		        e.printStackTrace();
		     
		   }
		try {
			conexion bd = new conexion();
			Connection cnn = bd.obtenerConexion();
			String consulta = "update Cuentas SET Estado = 0 WHERE IDCuenta=?";
		         PreparedStatement ps = cnn.prepareStatement(consulta);
		         ps.setInt(1,idCuenta);
		         int actualizado = ps.executeUpdate();
		         return actualizado>0;
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	
	public boolean ModificarCuenta(Cuenta cuenta) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		conexion bd = new conexion();
		Connection connection = bd.obtenerConexion();
		
		String query = "update Cuentas SET Saldo=?,TipoCuentaID=?,ClienteID=? WHERE IDCuenta=?";
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setDouble(1,cuenta.getSaldo());
			statement.setInt(2, cuenta.getTipoCuentaId());
	    	statement.setInt(3,cuenta.getClienteId());
	    	statement.setInt(4,cuenta.getIdCuenta());
			int actualizado = statement.executeUpdate();
			return actualizado >0;
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}




	@Override
	public boolean CantidadCuenta(int idCliente) {
		 
		    boolean limite = false;

		    
		    
		    conexion bd = new conexion();
			Connection connection = bd.obtenerConexion();
		    try {
		      

		        String consultaCantidadCuentas = "SELECT COUNT(*) AS total FROM Cuentas c INNER JOIN Clientes cl ON c.ClienteID = cl.IDCliente WHERE cl.IDCliente =?"; 

		        PreparedStatement statement = connection.prepareStatement(consultaCantidadCuentas);
		        statement.setInt(1, idCliente);

		        ResultSet resultSet = statement.executeQuery();
		        if (resultSet.next()) {
		            int cantidad = resultSet.getInt("total");
		            System.out.println("cantidad de cuenta del cliente: " + cantidad);
		            limite = cantidad >= 3; 
		        }

		        connection.commit();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        try {
		            if (connection != null) {
		            	connection.rollback(); 
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }

		    return limite;
	}
}
