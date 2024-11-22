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

	@Override
	public ArrayList<Cuenta> ListarCuenta() {
       
		conexion bd = new conexion();
		Connection cnn = bd.obtenerConexion();
		if(cnn==null) {
			  System.out.println("Conexion fallida: la cone es null.");
		        
		}
		
        String consulta= "SELECT IDCuenta, NumeroCuenta, CBU, Saldo, ClienteID,TipoCuentaID, FechaCreacion FROM Cuentas INNER JOIN TipoCuentas ON Cuentas.TipoCuentaID = TipoCuentas.IDTipoCuenta WHERE Estado=1";
        ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		try {
			//esta parte la llamo SETTEO:
		
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
			/*SELECT IDCuenta,NumeroCuenta,CBU,Saldo,ClienteID,TipoCuentaID,FechaCreacion*/
		}catch(Exception ex){
			 System.out.println("OH NO! TP NO COMPILA EN CATCH SETTEO" + ex.getMessage());
		        ex.printStackTrace();
		}
        return lista;
	}
		
		
	

	@Override
	public ArrayList<Cuenta> ListarXidCl(int idCliente) {

		    ArrayList<Cuenta> lista = new ArrayList<>();
		    conexion bd = new conexion();
		    Connection cnn = bd.obtenerConexion();
		    if (cnn == null) {
		        System.out.println("Conexi�n fallida: la conexi�n es null.");
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




	

}
