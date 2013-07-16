<!doctype html>
<html>
<head>
    <meta charset="utf8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Ghisius Web System - Alpha Version</title>
    <link rel="stylesheet" href="css/style.css" />        
    <script src="js/jquery-2.0.1.min.js"></script>
    <script>
    $(function() {    	
        var button = $('#loginButton');
        var box = $('#loginBox');
        var form = $('#loginForm');
        button.removeAttr('href');
        button.mouseup(function(login) {
            box.toggle();
            button.toggleClass('active');
        });
        form.mouseup(function() { 
            return false;
        });
        $(this).mouseup(function(login) {
            if(!($(login.target).parent('#loginButton').length > 0)) {
                button.removeClass('active');
                box.hide();
            }
        });
    });
    
 $('#login').click(function() {
		
		//$('#cadastro').hide();
   		//$('#Loading').show();	
   		var email = $('#email').val(); 
   		var senha = $('#senha').val();      		
				
		var validado = true;
		var msg = "";
		var campo_foco = "";
	   
	   if(email == ""){
			msg = "Campo EMAIL é obrigatório.";
			campo_foco = "email";
    		validado = false;	    		
		}else if(nome == ""){
			msg = "Campo SENHA é obrigatório.";
			campo_foco = "nome";
    		validado = false;	    		
		}
		
		if(validado){
			$.post("TelaInicialServlet",{		
				action: 'salvaSolicitacao',
				loginGerente: login_gerente,
				cargo: cargo,
				login: login,
				nome: nome,
				data_nascimento: data_nascimento,
				cargo: cargo,
				cpf: cpf,
				rg: rg,
				nome_mae: nome_mae,
				email: email,					
				sap: sap,
				matricula: matricula,
				gerente: gerente,
				unidade: unidade,
				celular: celular,
				email_gerente: email_gerente,
				limite: limite,
				banco: banco,
				justificativa: justificativa
	        },function(retorno){		        
	        	var pos = retorno.indexOf(":");
	        	var tam = retorno.length;     	
	        	var msg = retorno.substring(pos+1, tam);
	        	alert(msg);
	        	if(retorno.indexOf("S:") != -1){
	        		limpaFormulario();
	        	}
	        	$('#cadastro').show();
   		    	$('#cadastro_loading').hide();
	       	});				
		}else{
			alert(msg);
			$('#cadastro').show();
   		    $('#cadastro_loading').hide();
			$('#'+campo_foco+'').focus();
		}
		
	});
    
    </script>
    <script type="text/JavaScript">
		// prepare the form when the DOM is ready 
		$(document).ready(function() { 
				
				$('#login').click(function() {  
						
						$(".error").hide();
						var hasError = false;
						var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
						
																		
						
						var emailaddressVal = $("#email").val();
						if(emailaddressVal == '') {
							$("#email").after('<span class="error">Por favor, entre com um e-mail válido.</span>');
							hasError = true;
						} else if(!emailReg.test(emailaddressVal)) {	
							$("#email").after('<span class="error">Por favor, entre com um e-mail válido.</span>');
							hasError = true;
						}  else if(request.getParameter("loginError") == "1") {	
							$("#email").after('<span class="error">Por favor, entre com um e-mail válido.</span>');
							hasError = true;
						}  
				
						if(hasError == true) { return false; }
						else {							
							return true;
						}
			});	
		});
		
	</script>
   
</head>
<body> 
    <div id="bar">
        <div id="container">                            
            <div id="loginContainer">
                <a href="#" id="loginButton"><span>Login</span><em></em></a>
                <div style="clear:both"></div>
                <div id="loginBox">                
                    <form method="post" id="loginForm" action="login_proc.jsp">
                        <fieldset id="body">
                            <fieldset>
                                <label for="email">Email Address</label>
                                <input type="text" name="email" id="email" />
                            </fieldset>
                            <fieldset>
                                <label for="senha">Password</label>
                                <input type="password" name="password" id="senha" />
                            </fieldset>
                            <input type="submit" id="login" value="Sign in" />
                            <label for="checkbox"><input type="checkbox" id="checkbox" /> Remember me </label>
                        </fieldset>
                        <span><a href="#">Forgot your password?</a></span>
                    </form>
                </div>
            </div>
        </div>        
    </div>
    <div id="Titulo">Sistema Ghisius
    </div>
</body>
</html>