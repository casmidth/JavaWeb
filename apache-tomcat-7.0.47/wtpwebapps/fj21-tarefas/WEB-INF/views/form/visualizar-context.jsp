<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Alterar Tarefas</title>
</head>
<body>
	<c:import url="../header.jsp" />
	
	<h3>Altere a tarefa</h3>
	
	<form:errors path="tarefa.descricao" cssStyle="color:red"/>
	<form action="/tarefa/alterar" method="post">
		
		<input type="hidden" name="id" value="${ tarefa.id }"></input>
		
		Descricao tarefa <br />
		<textarea name="descricao" rows="5" cols="100">
			<%-- --%>${ tarefa.descricao }<%-- --%>
		</textarea>
		<br />
		
		Tarefa finalizada
		<input type="checkbox" name="finalizado" value="true" ${ tarefa.finalizado ? 'checked' : '' }></input>
		<br />
						
		Data de finalizacao<br />
		<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${ tarefa.dataFinalizacao.time }" pattern="dd/MM/yyyy" /> " />
		<br />
				
		<button>Alterar</button>
	</form>
	
	<c:import url="../footer.jsp" />	
</body>

</html>