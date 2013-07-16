<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ghisius Web System - Alpha Version</title>
<link rel="stylesheet" href="css/style.css" /> 
</head>
<script>

<%
  String nome = "Bem vindo " + session.getAttribute("Booksite_nome");
  
%>

</script>

<body>
 <div id="bar">
   <div id="container">
      <div id="UserNameHeader" >
		<font><%=nome%></font>			
      </div>      
   </div>
 </div> 
 <div id="BookLinks"> 
	<a href="MyAccount.jsp">Cadastro de Materiais</a>
	<a href="listaMateriais.jsp">Listagem de Material</a>
 </div>
 <form  method="post" id="loginForm" action="cadastroMaterial_proc.jsp">
 <div id="CadastroMaterial">      		
   Titulo: <input name="titulo" type="text"> <br>
   Substítulo: <input name="subtitulo" type="text"> <br>
   Descrição: <input name="descricao" type="text" > <br>
   Idioma: <select id="idioma" name="idioma" class="idiomaCombo">
                            	<option value="1" selected="selected">Português</option>                                    	                    	                            	                     
   			</select><br>
   Tipo de Material: <select id="tipoMaterial" name="tipoMaterial" class="tipoMaterialCombo">
                        <option value="1" >Links</option>
                        <option value="2" >Vídeos</option>
                        <option value="3" >Exercícios</option>
                        <option value="4" >Áudios</option>
                        <option value="5" >Arquivos</option>                        
   				     </select>
	<input type="submit" value="Cadastrar">   
 </div>
 </form>
</body>
</html>