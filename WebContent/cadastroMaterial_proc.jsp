<%@page import="java.util.Date" session="true"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="connection.ConnectionFactory" %>

<% 

String titulo = request.getParameter("titulo");
String subtitulo = request.getParameter("subtitulo");
String descricaoMaterial = request.getParameter("descricao");
int codIdioma = Integer.parseInt(request.getParameter("idioma"));
int tipoMaterial = Integer.parseInt(request.getParameter("tipoMaterial"));

try {    			
	String redirectURL = "";
	Connection con = new ConnectionFactory().getConnection();
	
	
	String sql ="insert into materiais (COD_MATERIAL, " +
					   "COD_IDIOMA, 					" +
					   "COD_TIPO_MATERIAL, " +
					   "TITULO, " + 
					   "SUBTÍTULO, " + 
					   "DESCRICAO) VALUES " + 
					   "(SEQ_MATERIAL.NEXTVAL,?,?,?,?,?)";
	                                   
	System.out.println(sql);
	PreparedStatement stmt = con.prepareStatement(sql);
	
	stmt.setInt(1, codIdioma);
	stmt.setInt(2, tipoMaterial);
	stmt.setString(3, titulo);
	stmt.setString(4, subtitulo);
	stmt.setString(5, descricaoMaterial);
	
	try {				
		stmt.executeUpdate(sql);				   		    
				 		  
		redirectURL = "MyAccount.jsp?ok=1"; 																		
		response.sendRedirect(redirectURL);
	
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {		
		stmt.close();
		con.rollback();
		con.close();
	}
	
} catch(NullPointerException nexp) {
	out.print("Erro!");
}


%>