package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuarios;

public class ConnectionFactory {
    
	private Connection con;
	
	public Connection getConnection() {
		String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String dbUser = "booksite";
		String dbPassword = "booksite";		
		try {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
			
			return DriverManager.getConnection( dbUrl , dbUser, dbPassword );					
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 	   
    }
	
	public Connection getConnection(Usuarios usuario) {
		String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String dbUser = "booksite";
		String dbPassword = "booksite";		
		try {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
			
			con = DriverManager.getConnection( dbUrl , dbUser, dbPassword );
			System.out.println("CHEGOU AQUI");
			try {				
				ResultSet res = validateUserAndPassword(usuario);			
				if( res.next() ) {
					System.out.println("Retorna Con");
					return con;
				}
					
				
													
				//System.out.println("Retornou NULL");
				return null;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 	   
    }
	
	public ResultSet validateUserAndPassword(Usuarios usuario) {
		String sql = "select 1 from USUARIOS " +  
					 " where ( upper(login) = upper('" + usuario.getLogin() + "') or " +
					 "       ( upper(email) = upper('" + usuario.getEmail() + "') ) ) " +
					 " and senha = '" + usuario.getSenha() +"'";		
		System.out.println(sql);
	    try {
	    	PreparedStatement stmt = con.prepareStatement(sql);	    		    	
			
			ResultSet res = stmt.executeQuery(sql);
			
			return res;		
	    } catch (SQLException e) {
	    	throw new RuntimeException(e);
	    }	    
    }

}
