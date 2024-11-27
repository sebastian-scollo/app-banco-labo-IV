package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.daoOpcionCuenta;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.TipoCuenta;
public class daoOpcionCuentaImpl implements daoOpcionCuenta {

	/**/
	
	@Override
	public ArrayList<Cuenta> OpcionCuentas(int idUsuario) {
		
		 ArrayList<Cuenta> lista = new ArrayList<>();
		    conexion bd = new conexion();
		    
		    String consulta = "SELECT ClienteID, CBU, Saldo, TipoCuentaID, FechaCreacion " +
		                      "FROM Cuentas " +
		                      "INNER JOIN Clientes ON Clientes.IDCliente = Cuentas.ClienteID " +
		                      "INNER JOIN Usuarios ON Usuarios.IDUsuario = Clientes.UsuarioID " +
		                      "WHERE Cuentas.Estado = 1 AND Usuarios.IDUsuario = ?";
		    
		        
		    try  {
		    	Connection connection = bd.obtenerConexion();
	    		PreparedStatement pstmt = connection.prepareStatement(consulta);
		        
		        pstmt.setInt(1, idUsuario);
		        
		        try (ResultSet rs = pstmt.executeQuery()) {
		            while (rs.next()) {
		                Cuenta cuenta = new Cuenta();
		                
		                Cliente cliente = new Cliente();
		                cliente.setIdCliente(rs.getInt("ClienteID"));
		                cuenta.setObjCliente(cliente);
		
		                cuenta.setCBU(rs.getString("CBU"));
		                cuenta.setSaldo(rs.getDouble("Saldo"));
		                cuenta.setClienteId(rs.getInt("ClienteID"));
		                cuenta.setFechaCreacion(rs.getDate("FechaCreacion"));

		                TipoCuenta tipoCuenta = new TipoCuenta();
		                tipoCuenta.setIdTipoCuenta(rs.getInt("TipoCuentaID"));
		                cuenta.setObjidTipoCuenta(tipoCuenta);

		                lista.add(cuenta);
		            }
		        }
		    } catch (Exception ex) {
		        System.out.println("Error en OpcionCuentas: " + ex.getMessage());
		    }
		    
		    return lista;
	}




}
