package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuarios;

public class ConnectionFactory {
    
	private Connection con;
	
	static final String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static final String dbUser = "booksite";
	static final String dbPassword = "booksite";
    static final String oracleDriver = "oracle.jdbc.OracleDriver";
        
	
    public ConnectionFactory()  {
    	this.con = startConnection();
    }     
    
    public ConnectionFactory(Usuarios Usuario) {
    	this.con = startConnection(Usuario);
    }
    
    public Connection getConnection() {
    	return con;
    }
    
    private void loadOracleDriver() {
    	try {
			Class.forName(oracleDriver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);				
		}
    }              
    
	private Connection startConnection() {
		loadOracleDriver();			
			
		try {
			return DriverManager.getConnection( dbUrl , dbUser, dbPassword );
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}					
		
    }
	
	private Connection startConnection(Usuarios usuario) {									
		con = startConnection();
		if ( checkValidUser(usuario).equals("True") )  {					
				return con;					
		} 	   
		return null;
    }
	
	private String checkValidUser(Usuarios usuario){
		ResultSet res = validateUserAndPassword(usuario);			
		try {
			if( res.next() ) {			
				return "True";
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "False";
	}
		
	private ResultSet validateUserAndPassword(Usuarios usuario) {
		String sql = "select 1 from USUARIOS " +  
					 " where ( upper(login) = upper(?) or " +
					 "       ( upper(email) = upper(?) ) ) " +
					 " and senha = ?";		
		
	    return ExecuteQueryUsuarios(usuario, sql);	    
    }

	private ResultSet ExecuteQueryUsuarios(Usuarios usuario, String sql) {
		try {
	    	PreparedStatement stmt = con.prepareStatement(sql);	    		    	
			
	    	stmt.setString( 1, usuario.getLogin() );
			stmt.setString( 2, usuario.getEmail() );
			stmt.setString( 3, usuario.getSenha() );
			
			ResultSet res = stmt.executeQuery(sql);
			
			return res;		
	    } catch (SQLException e) {
	    	throw new RuntimeException(e);
	    }
	}

}
