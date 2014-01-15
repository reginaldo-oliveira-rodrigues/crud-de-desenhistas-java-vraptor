<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<style type="text/css">
			.link {
			  	text-decoration: underline;
			  	border: none;
			  	background: none;
			  	color: blue;
			  	cursor: pointer;
			}
		</style>
	</head>
<body>
	<a href=${pageContext.request.contextPath} >Início</a>
	<a href="<c:url value="/desenhista/novo"/>" >Cadastrar</a>
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
				<td>
					<a href="<c:url value="/desenhista/${desenhista.id}"/>" >Editar</a>
				</td>
				<td>
					<form action="<c:url value="/desenhista/${desenhista.id}"/>" method="POST">
				    	<button class="link" name="_method" value="DELETE">Remover</button>
				  	</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>