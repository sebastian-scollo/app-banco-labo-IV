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

}