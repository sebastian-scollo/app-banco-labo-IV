package daoImpl;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
public class conexion {
	private String host="jdbc:mysql://localhost:3306/";
	private String user="root";
	private String pass="";
	private String bdname="BancoGestionLab4";
	
	protected Connection cn;
	
	public Statement getStatement() {

		try {
	
	
			cn=obtenerConexion();
			Statement st=cn.createStatement();
			return st;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Connection obtenerConexion() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
            cn= DriverManager.getConnection(host + bdname, user, pass);
            cn.setAutoCommit(false);

            return cn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public PreparedStatement getPreparedStatement(String sql) {
	    try {
	        cn = obtenerConexion();
	        return cn.prepareStatement(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
}
