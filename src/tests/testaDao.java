package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Materiais;
import connection.ConnectionFactory;
import dao.MaterialDao;

public class testaDao {
	
	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		try {
		    			
			MaterialDao dao = new MaterialDao();
			List<Materiais> materiais = dao.getList();
			
			for (Materiais material : materiais) {				
				  System.out.println("Codigo do Material: " + material.getCodMaterial());
				  System.out.println("Código do Idioma: " + material.getCodIdioma());
				  System.out.println("Código do Tipo do Material: " + material.getCodTipoMaterial());
				  System.out.println("Título: " + material.getTitulo());
				  System.out.println("Subtítulo: " + material.getSubtitulo());
				  System.out.println("Descricao: " + material.getDescricao());
		    }			
			
		    con.close();
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		} 						
	}
}
