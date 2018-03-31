<%@page import="br.com.caelum.jdbc.dao.ContatoDAO"%>
<%@page import="br.com.caelum.model.Contato"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista Contato</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	<body>
	<main class="container">
	<% 
		ContatoDAO dao = new ContatoDAO(); 
		List<Contato> contatos = dao.getList();
	%>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Endereco</th>
					<th>Data Nascimento</th>
				</tr>
			</thead>
			<tbody>
				<% for(Contato contato : contatos){ %>
				<tr>
					<td><%= contato.getId() %></td>
					<td><%= contato.getNome() %></td>
					<td><%= contato.getEmail() %></td>
					<td><%= contato.getEndereco() %></td>
					<td><%= contato.getDataNascimento().getTime() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</main>
	</body>
</html>