<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="../resources/js/jquery.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lista Tarefas</title>
	
</head>
<body>
	<c:import url="header.jsp" />
	<h3>Lista de Tarefas</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>Descricao</th>
			<th>Finalizado</th>
			<th>Data de Finalizacao</th>
			<th>Alterar</th>
			<th>Remover</th>
		</tr>
		<c:forEach var="tarefa" items="${ listaTarefas }">
		 <tr>
		 	<td>${ tarefa.id }</td>
		 	<td>${ tarefa.descricao }</td>
		 	
		 	<c:if test="${not tarefa.finalizado }">
		 		<td id="statusTarefa_${ tarefa.id }">
		 		<a href="#" onclick="finalizarAgora(${ tarefa.id })">Finalizar</a>
		 		</td>
		 	</c:if>
		 	<c:if test="${ tarefa.finalizado }">
		 		<td> Finalizada </td>
		 	</c:if>
		 	
		 	<td><fmt:formatDate value="${ tarefa.dataFinalizacao.time }" pattern="dd/MM/yyyy" /></td>
		 	
		 	<td>
		 		<a href="context?id=${ tarefa.id }">Alterar</a>
		 	</td>
		 	<td id="removerTarefa_${ tarefa.id }">
		 		<a href="#" onclick="remover(${ tarefa.id})">Remover</a>
		 	</td>
		 </tr>
		</c:forEach>
	</table>
	<c:import url="footer.jsp" />
	
	<!-- JavaScript functions -->
	<script>
		function finalizarAgora(id){
			$.post("finalizar", {'id': id}, function(){
				$("#statusTarefa_" + id).html("Finalizada");
			});
		}
		
		function remover(id){
			$.post("remover", {'id' : id}, function(){
				$("#removerTarefa_" + id).closest("tr").hide();	
			});
		} 
		
	</script>
</body>
</html>