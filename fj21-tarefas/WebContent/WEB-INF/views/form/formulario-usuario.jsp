<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Novo usuario</title>
	</head>
	<body>
		<form action="/usuario/criar" method="post">
			
			Insira seu login:
			<input type="text" name="login"> <br/>
			
			Insira sua senha:
			<input type="password" name="senha"> <br/>	
		
			<button>Criar</button>
		</form>
		
	</body>
</html>