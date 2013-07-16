package connection;

import java.sql.Connection;
import java.sql.SQLException;

import modelo.Usuarios;

public class testaConnectionFactory {
	
	public static void main(String[] args) {
		Usuarios usuario = new Usuarios();
		
		usuario.setEmail("jeferson.ghisio@gmail.com");
		usuario.setSenha("12345");
				
		Connection con = new ConnectionFactory().getConnection(usuario);
		if (con == null) {
			System.out.println("NÃO Passou");
		} else {
			System.out.println("Passou");			
		}	
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
