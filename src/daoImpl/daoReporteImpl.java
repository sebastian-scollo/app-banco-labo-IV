package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.daoReporte;
import entidades.Cliente;
import entidades.Provincia;

public class daoReporteImpl implements daoReporte {
	public List<Cliente> obtenerClientesPorProvincia(int provinciaID){
		 List<Cliente> clientes = new ArrayList<>();
	        
	        String query = "SELECT c.IDCliente, c.DNI, c.Nombre, c.Apellido, c.Sexo, c.Nacionalidad, c.FechaNacimiento, "
	                     + "c.Telefono, c.CorreoElectronico "
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
	
	
}
