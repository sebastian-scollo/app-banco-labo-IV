package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.daoTipoCuenta;
import entidades.TipoCuenta;

public class daoTipoCuentaImpl implements daoTipoCuenta{

	@Override
	public ArrayList<TipoCuenta> obtenerTiposCuentas() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<TipoCuenta> listado = new ArrayList<TipoCuenta>();
		String consulta = "SELECT * FROM TipoCuentas";
		try {
			conexion cn= new conexion();
			Connection cnn=cn.obtenerConexion();
			PreparedStatement psta=cnn.prepareStatement(consulta);
	  ResultSet rs = psta.executeQuery();
			
			while(rs.next()){
				
				TipoCuenta tipoCuenta = new TipoCuenta();
				tipoCuenta.setIdTipoCuenta(rs.getInt("IDTipoCuenta"));
				tipoCuenta.setDescripcion(rs.getString("Descripcion"));
				listado.add(tipoCuenta);
			}
			 System.out.println("Tipos de Cuenta encontrados: " + listado.size());
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return listado;
	}

	
	public String obtenerOpcionesDDL() {
		
		String options = "";
				
		ArrayList<TipoCuenta> l = obtenerTiposCuentas();
		
		for (TipoCuenta tp : l) {
			options += "<option value='" + tp.getIdTipoCuenta() + "'> " + tp.getDescripcion() + "</option> "; 
		}
		
		return options;
		
	}
}
