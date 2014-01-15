<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Atualiação de Dados de Desenhistas</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/commons/header.jspf" %>
	<br/>
	<h1>Atualiação de Dados de Desenhistas</h1>
	<br/>
	<a href=${pageContext.request.contextPath} >Início</a>
	<a href="<c:url value="/desenhistas"/>" >Listar</a>
	<br/>
	<form action="<c:url value="/desenhista/${desenhista.id}"/>" method="POST">
		<fieldset>
			<legend>Atualização de Dados</legend>
			<label for="nome">Nome:</label> 
			<input id="nome" type="text" name="desenhista.nome" value="${desenhista.nome}"/>
			<br/>
			<label for="email">E-Mail:</label>
			<input id="email" type="text" name="desenhista.email" value="${desenhista.email}"/>
			<br/>
			<label for="site">Site:</label> 
			<input id="site" type="text" name="desenhista.site" value="${desenhista.site}"/>
			<br/>
			<button type="submit" name="_method" value="PUT">Atualizar</button>
		</fieldset>
	</form>
</body>
</html>