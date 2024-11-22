package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.daoLocalidad;
import entidades.Localidad;

public class daoLocalidadImpl implements daoLocalidad{

	
	@Override
    public ArrayList<Localidad> listarLocalidadPorProvincia(int IDProvincia) {
        ArrayList<Localidad> localidades = new ArrayList<>();
        conexion cn = new conexion();
        Connection connection = cn.obtenerConexion();
        
        String consulta = "SELECT * FROM Localidades WHERE ProvinciaID = ?";
        try {
            PreparedStatement pst = cn.getPreparedStatement(consulta);
            pst.setInt(1, IDProvincia);
            ResultSet rs = pst.executeQuery();
            
          
            while (rs.next()) {
                int id = rs.getInt("IDLocalidad"); 
                String nombre = rs.getString("Nombre");
                Localidad localidad = new Localidad(id, nombre, IDProvincia);
                localidades.add(localidad);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return localidades;
    }
	
}
