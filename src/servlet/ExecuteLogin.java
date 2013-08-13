package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuarios;
import connection.ConnectionFactory;

public class ExecuteLogin extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
	  response.setContentType("text/html");
	  PrintWriter out = response.getWriter();
	  
	  Usuarios usuarioLogin = new Usuarios();
	  
	  usuarioLogin.setEmail(request.getParameter("email"));
	  usuarioLogin.setSenha(request.getParameter("password"));		  				  		 
	  
	  ConnectionFactory conFact = new ConnectionFactory(usuarioLogin);		  		  		  
	  Connection con = conFact.getConnection();
	  
	  if (con == null) {
		  request.setAttribute("errorMessage", "invalid Login");
		  RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	  } else {			  
		  RequestDispatcher rd = request.getRequestDispatcher("paginaInicial.jsp");
	  }
	  
	  try {
		rd.forward(request,response);
   	  } catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
  }
			  				
}