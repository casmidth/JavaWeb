<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Tarefas</title>
</head>
<body>
	<c:import url="header.jsp" />
	<h3>Adicionar tarefas</h3>
	<form:errors path="tarefa.descricao" cssStyle="color:red"/>
	<form action="/tarefa/adicionar" method="post">
		Descricao tarefa <br />
		<textarea name="descricao" rows="5" cols="100"></textarea><br />
		
		<input type="checkbox" name="finalizado">Tarefa finalizada</input><br />
		
		<button>Adiciona</button>
	</form>
	<c:import url="footer.jsp" />	
</body>

</html>