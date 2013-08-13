package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Materiais;
import connection.ConnectionFactory;

public class MaterialDao {
	private Connection con;
	
	public MaterialDao() throws SQLException {
		this.con = (Connection) new ConnectionFactory();		
	}	
	
	public List<Materiais> getList() {								
		try{
			List<Materiais> materiais = new ArrayList<Materiais>();
			//
			//Connection con = new ConnectionFactory().getConnection();
						
			String sql = "select * from MATERIAIS";
			
			PreparedStatement stmt = this.con.prepareStatement(sql);
			
			ResultSet res = stmt.executeQuery();
			
			while (res.next()){
				//System.out.println(res.getString("COD_TIPO_MATERIAL"));
				
				Materiais material = new Materiais();
				
				material.setCodIdioma(res.getInt("COD_IDIOMA"));
				material.setCodMaterial(res.getInt("COD_MATERIAL"));
				material.setCodTipoMaterial(res.getInt("COD_TIPO_MATERIAL"));
				material.setTitulo(res.getString("TITULO"));
				material.setSubtitulo(res.getString("SUBTÍTULO"));
				material.setDescricao(res.getString("DESCRICAO"));
				
				materiais.add(material);
			}
			
			res.close();
			stmt.close();
			return materiais;
			
		} catch (SQLException e) {
		  //System.out.println("Erro em MaterialDao");		
		  throw new RuntimeException(e);
		}	
		
		 
	}	
}
