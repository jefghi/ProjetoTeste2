package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Usuarios;
import connection.ConnectionFactory;

public class UsuarioDao {

	private Connection con;
	
	public UsuarioDao(Usuarios usuario) throws SQLException {
		this.con = new ConnectionFactory().getConnection();
		//System.out.println("Funcionou!!!!!");
	}
	
	public void insere(Usuarios usuario) throws SQLException {
		String sql = "insert into USUARIOS (" +
					                       "data_cadastro, " +
					                       "resposta_secreta, " +
					                       "pergunta_secreta, " +
					                       "nome, " +
					                       "senha, " +
					                       "login, " + 
					                       "email, " +
					                       "cod_usuario " +
					                       ") " +					                        
					               "values (?,?,?,?,?,?,?,seq_usuarios.nextval)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setDate( 1, new java.sql.Date( new java.util.Date().getDate() ) );
			stmt.setString( 2, usuario.getRespostaSecreta() );
			stmt.setString( 3, usuario.getPerguntaSecreta() );
			stmt.setString( 4, usuario.getNome() );
			stmt.setString( 5, usuario.getSenha() );
			stmt.setString( 6, usuario.getEmail() );		

			stmt.execute();
			stmt.close();
			
			System.out.println("Gravado!");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
	}
	
//	public List<Usuarios> getLista() {
//		try {
//			List<Usuarios> usuarios = new ArrayList<Usuarios>();
//			Connection con = new ConnectionFactory().getConnection();
//			
//			String sql = "select * from MATERIAIS";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			ResultSet res = stmt.executeQuery();
//			
//			while (res.next()){
//				Usuarios usuario = new Usuarios();
//				usuario.setCodUsuario(res.getString(""));
//				
//			}
//			
//		} catch (SQLException e) { 
//			throw new RuntimeException(e);
//		}		  
//	}
	
}
