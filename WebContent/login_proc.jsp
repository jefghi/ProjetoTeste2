
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="connection.ConnectionFactory"%>
<%@page import="java.sql.*"%>
<%@page import="modelo.Usuarios"%>

<%
String redirectURL;

try {
	//System.out.println("1");
	session.removeAttribute("Booksite_user");
	session.removeAttribute("Booksite_nome");
	
	Usuarios user = new Usuarios();
	//System.out.println("2");
	user.setEmail(request.getParameter("email"));	
	user.setSenha(request.getParameter("password"));
	
	
	Connection con = new ConnectionFactory().getConnection(user);
	
	if ( con == null ) {
		out.print("Usuário ou login inválido!");
	} else {
		String sql=" Select * from usuarios where email='"+ user.getEmail() +"' and senha='"+ user.getSenha() +"'";			
		
		Statement stmt = con.createStatement();	
		
		ResultSet res = stmt.executeQuery(sql);	
		while(res.next()){
	         user.setNome(res.getString("nome"));
	         session.setAttribute("Booksite_user", res.getString("login"));
	         session.setAttribute("Booksite_nome", res.getString("nome"));                      
		   //out.println("Usuário Existe no banco! seu nome é:  " + session.getValue("user"));		   		   		  		   
		}    		
		
		stmt.close();
		//con.commit();
		con.close();
		if (user.getNome().equals("")){
			 out.println("Usuário Não existe");		 
			 redirectURL = "index.jsp?loginError=1"; 					
		} else { 		   
			redirectURL = "MyAccount.jsp";		
		}							
		
		response.sendRedirect(redirectURL);		
	}	
			
} catch(NullPointerException nexp) {
	out.print("1 - Erro inexperado!");	
} catch (SQLException ex) {
	out.print("2 - Erro inexperado!");	
	ex.printStackTrace();
	
}

%>



 


