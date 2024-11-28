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
import entidades.TipoCuenta;
public class daoCuentaImpl implements daoCuenta {
	
	public daoCuentaImpl() {};
	@Override
	public ArrayList<Cuenta> ListarCuenta() {
     
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error mi compa");
	        e.printStackTrace();
	    }

		
		conexion bd = new conexion();
		Connection cnn = bd.obtenerConexion();
		if(cnn==null) {
			  System.out.println("Conexion fallida: la cone es null.");
		        
		}
		
        String consulta= "SELECT IDCuenta, NumeroCuenta, CBU, Saldo, ClienteID,TipoCuentaID, FechaCreacion FROM Cuentas INNER JOIN TipoCuentas ON Cuentas.TipoCuentaID = TipoCuentas.IDTipoCuenta WHERE Estado=1";
        ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		try {
		
		
			Statement st=cnn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while(rs.next()) {
			     Cuenta cuenta = new Cuenta();
		            Cliente cliente = new Cliente();
		         cliente.setIdCliente(rs.getInt("TipoCuentaID"));//OJO
			     cuenta.setObjCliente(cliente);
		            cuenta.setIdCuenta(rs.getInt("IDCuenta"));
		            cuenta.setNroCuenta(rs.getString("NumeroCuenta"));
		            cuenta.setCBU(rs.getString("CBU"));
		            cuenta.setSaldo(rs.getDouble("Saldo"));
		            cuenta.setClienteId(rs.getInt("ClienteID"));
		            cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));

		            
		            TipoCuenta tipoCuenta = new TipoCuenta();
		            tipoCuenta.setIdTipoCuenta(rs.getInt("TipoCuentaID"));
		      
		            cuenta.setObjidTipoCuenta(tipoCuenta);

		            lista.add(cuenta);
			}
		
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
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error mi compa");
	        e.printStackTrace();
	    }

		
		
		ArrayList<Cuenta> lista = new ArrayList<>();
		    conexion bd = new conexion();
		    Connection cnn = bd.obtenerConexion();
		    if (cnn == null) {
		        System.out.println("Conexion fallida: la conexion es null.");
		        return lista; 
		    }

		    String consulta = "SELECT c.IDCuenta, c.NumeroCuenta, c.CBU, c.Saldo, c.ClienteID, c.TipoCuentaID, c.FechaCreacion, " +
		                      "tc.Descripcion " +
		                      "FROM Cuentas c " +
		                      "INNER JOIN TipoCuentas tc ON c.TipoCuentaID = tc.IDTipoCuenta " +
		                      "WHERE c.Estado = 1 AND c.ClienteID = ?";

		    try {
		        PreparedStatement ps = cnn.prepareStatement(consulta);
		        ps.setInt(1, idCliente); 
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            Cuenta cuenta = new Cuenta();
		            Cliente cliente = new Cliente();
			         cliente.setIdCliente(rs.getInt("ClienteID"));//OJO
				     cuenta.setObjCliente(cliente);//aca detalle composicion
		            cuenta.setIdCuenta(rs.getInt("ClienteID"));
		            cuenta.setNroCuenta(rs.getString("NumeroCuenta"));
		            cuenta.setCBU(rs.getString("CBU"));
		            cuenta.setSaldo(rs.getDouble("Saldo"));
		          //  cuenta.setClienteId(rs.getInt("ClienteID"));
		            cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));

		            TipoCuenta tipoCuenta = new TipoCuenta();
		           tipoCuenta.setIdTipoCuenta(rs.getInt("TipoCuentaID"));
		            cuenta.setObjidTipoCuenta(tipoCuenta);
                     
		            lista.add(cuenta);
		        }
		    } catch (Exception ex) {
		        System.out.println("Error al obtener las cuentas por cliente: " + ex.getMessage());
		        ex.printStackTrace();
		    }
		    return lista;
	}
	@Override
	public ArrayList<Cuenta> ListarXtipoCuenta(int paramTipoCuenta) {
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error mi compa");
	        e.printStackTrace();
	    }

		
		ArrayList<Cuenta> listado = new ArrayList<Cuenta>();
		
		try {
			
			conexion bd = new conexion();
			Connection connection =bd.obtenerConexion();
			String consulta = "SELECT IDCuenta,NumeroCuenta,CBU,Saldo,ClienteID,TipoCuentaID,FechaCreacion FROM Cuentas INNER JOIN TipoCuentas  ON Cuentas.TipoCuentaID = TipoCuentas.IDTipoCuenta  WHERE Estado=1 AND TipoCuentaID="+paramTipoCuenta;
			PreparedStatement mtt = connection.prepareStatement(consulta);
			
			ResultSet rs = mtt.executeQuery(consulta);
			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				
				cuenta.setIdCuenta(rs.getInt("IDCuenta"));
				cuenta.setNroCuenta(rs.getString("NumeroCuenta"));
				cuenta.setCBU(rs.getString("CBU"));
				cuenta.setSaldo(rs.getDouble("Saldo"));
				 Cliente cliente = new Cliente();
		         cliente.setIdCliente(rs.getInt("ClienteID"));//OJO
		         cuenta.setObjCliente(cliente);//aca detalle composicion Adaptacion
		         TipoCuenta tipoCuenta = new TipoCuenta();
		           tipoCuenta.setIdTipoCuenta(rs.getInt("TipoCuentaID"));
		           cuenta.setObjidTipoCuenta(tipoCuenta);  
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
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error mi compa");
	        e.printStackTrace();
	    }

		
		boolean exito = true;

		    try {
		      
		        conexion bd = new conexion();
		        Connection connection = bd.obtenerConexion();

		      
		        String query = "INSERT INTO Cuentas (NumeroCuenta, CBU, Saldo, ClienteID, TipoCuentaID) " +
		                       "VALUES (?, ?, ?, ?, ?)";

		       
		        PreparedStatement mtt = connection.prepareStatement(query);
		        mtt.setString(1, cuenta.getNroCuenta());    
		        mtt.setString(2, cuenta.getCBU());     
		        mtt.setDouble(3, cuenta.getSaldo());    
		        mtt.setInt(4, cuenta.getObjCliente().getIdCliente());    
		       // TipoCuenta tipoCuenta = new TipoCuenta();
		        /*tipoCuenta.setIdTipoCuenta(5);
		        cuenta.setObjidTipoCuenta(tipoCuenta);  */
		        mtt.setInt(5, cuenta.getObjidTipoCuenta().getIdTipoCuenta());
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
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error mi compa");
	        e.printStackTrace();
	    }

		
		
		
		conexion bd = new conexion();
		Connection connection = bd.obtenerConexion();

		String query = "update Cuentas SET Saldo=?,TipoCuentaID=?,ClienteID=? WHERE IDCuenta=? AND Estado=1";
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(query);
			

	        statement.setDouble(1, cuenta.getSaldo());
	        statement.setInt(2, cuenta.getObjidTipoCuenta().getIdTipoCuenta()); 
	        statement.setInt(3, cuenta.getObjCliente().getIdCliente());        
	        statement.setInt(4, cuenta.getIdCuenta());  
		
			int actualizado = statement.executeUpdate();
			System.out.println("asdaafklfdnlafdlnlfdlnkafdlnkfnlalnkfnlk");
			return actualizado >0;
			 
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
			
	}
	


	

	@Override
	public boolean CantidadCuenta(int idCliente, int idCuenta) {
		 
		    boolean limite = false;
		    try {
		        Class.forName("com.mysql.jdbc.Driver"); 
		        System.out.println("Driver MySQL cargado correctamente.");
		    } catch (ClassNotFoundException e) {
		        System.out.println("Error mi compa");
		        e.printStackTrace();
		    }

		    
		    conexion bd = new conexion();
			Connection connection = bd.obtenerConexion();
		    try {
		    	
		    	String consultaidactual =  "SELECT idcuenta from Cuentas WHERE clienteid = ?";
		    	
		    	PreparedStatement st = connection.prepareStatement(consultaidactual);
		    	st.setInt(1, idCliente);
		    	ResultSet rs = st.executeQuery();
		    	
		    	if (rs.next()) {
		    		int idc = rs.getInt("idcuenta");
		    		if (idc == idCuenta) {
		    			return false;
		    		}
		    	}
		    	
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




	@Override
	public boolean repiteNroCuenta(String nroCuenta) {
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error mi compa");
	        e.printStackTrace();
	    }

		boolean existencia = false;

		  String consulta = "SELECT NumeroCuenta FROM Cuentas WHERE NumeroCuenta=?";
		  conexion cn = new conexion();
		    Connection connection = cn.obtenerConexion();
		 try {
			 PreparedStatement pst = cn.getPreparedStatement(consulta);
		        pst.setString(1, nroCuenta);
		        ResultSet rs = pst.executeQuery();
		        if (rs.next()) {
		        	existencia = true; 
		        }
		        rs.close();
		        pst.close();
		        connection.close();
			 
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		return existencia;
	}




	@Override
	public boolean repiteCbu(String cbu) {
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); 
	        System.out.println("Driver MySQL cargado correctamente.");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error mi compa");
	        e.printStackTrace();
	    }

		
		boolean existencia = false;

		  String consulta = "SELECT CBU FROM Cuentas WHERE CBU=?";
		  conexion cn = new conexion();
		    Connection connection = cn.obtenerConexion();
		 try {
			 PreparedStatement pst = cn.getPreparedStatement(consulta);
		        pst.setString(1, cbu);
		        ResultSet rs = pst.executeQuery();
		        if (rs.next()) {
		        	existencia = true; 
		        }
		        rs.close();
		        pst.close();
		        connection.close();
			 
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		return existencia;
	}




	@Override
	public Cuenta cuentaXcbu(String cbu) {
		 
	        Connection con = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        Cuenta cuenta = null;
	        try {
		        Class.forName("com.mysql.jdbc.Driver"); 
		        System.out.println("Driver MySQL cargado correctamente.");
		    } catch (ClassNotFoundException e) {
		        System.out.println("Error mi compa");
		        e.printStackTrace();
		    }
              conexion cn = new conexion();
	        try {
	        	con = cn.obtenerConexion();
	        	
	            String sql = "SELECT * FROM cuentas WHERE cbu = ?";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, cbu);

	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                cuenta = new Cuenta();
	                cuenta.setCBU(rs.getString("cbu"));
	                cuenta.setIdCuenta(rs.getInt("idCuenta"));
	                cuenta.setSaldo(rs.getDouble("saldo"));
	                cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	       
	        } finally {
	      
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return cuenta;
	    }
	@Override
	public boolean actualizarSaldoCuenta(int idPrestamo, double monto) {
		String sql = "UPDATE Cuentas " +
                "SET Saldo = Saldo - ? " +
                "WHERE IDCuenta = (SELECT CuentaID FROM Prestamos WHERE IDPrestamo = ?)";
   conexion bd = new conexion();
   boolean resultado = false;

   try (Connection conn = bd.obtenerConexion();
        PreparedStatement ps = conn.prepareStatement(sql)) {
       ps.setDouble(1, monto);
       ps.setInt(2, idPrestamo);

       int filasActualizadas = ps.executeUpdate();
       if (filasActualizadas > 0) {
           resultado = true;
       }
   } catch (SQLException e) {
       e.printStackTrace();
   }

   return resultado;
	}
	
	


}
