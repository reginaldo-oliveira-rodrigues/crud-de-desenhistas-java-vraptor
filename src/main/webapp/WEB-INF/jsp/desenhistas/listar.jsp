<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<h1>Desenhistas</h1>
	<a href=${pageContext.request.contextPath} >Início</a>
	<a href="formulario" >Cadastrar</a>
	<br/>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>E-Mail</th>
				<th>Site</th>
				<th></th>
			</tr>
		</thead>
		
		<!-- elementos desta List veja br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista -->
		<c:forEach items="${desenhistaList}" var="desenhista">
			<tr>
				<td>${desenhista.nome}</td>
				<td>${desenhista.email}</td>
				<td>${desenhista.site}</td>
				<td><a href="editar?id=${desenhista.id}">Editar</a></td>
				<td><a href="remover?id=${desenhista.id }">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>