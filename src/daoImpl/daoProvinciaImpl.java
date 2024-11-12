package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.daoProvincia;
import entidades.Provincia;

public class daoProvinciaImpl implements daoProvincia {

	@Override
    public ArrayList<Provincia> listarProvincias() {
        ArrayList<Provincia> provincias = new ArrayList<>();
        conexion cn = new conexion();
        Connection connection = cn.obtenerConexion();
        
        String consulta = "SELECT IDProvincia, Nombre FROM Provincias";
        try {
            // Usamos un PreparedStatement para mayor seguridad y flexibilidad
            PreparedStatement pst = connection.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();

            // Recorre el resultado y crea un objeto Provincia por cada registro
            while (rs.next()) {
                int id = rs.getInt("IDProvincia");
                String nombre = rs.getString("Nombre");
                Provincia provincia = new Provincia(id, nombre);
                provincias.add(provincia);
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
        if (provincias.isEmpty()) {
            System.out.println("No se encontraron provincias.");
        } else {
            System.out.println("Provincias: " + provincias);
        }

        return provincias;
    }

}
