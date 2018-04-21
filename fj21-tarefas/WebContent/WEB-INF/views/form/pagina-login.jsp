<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	
	<body>
		<h1>Faca o login</h1>
		<p>${ param.error }</p>
		<p>${ param.goodbye }</p>
		<p>${ param.newUser }</p>
		<form action="/usuario/autenticado" method="post">
			
			Login:
			<input type="text" name="login"/><br/>
			
			Senha:
			<input type="password" name="senha"/><br/> 
			
			<button>Entrar</button>
		</form>
		<a href="/usuario/novo">Criar novo usuario</a>
		
	</body>
</html>