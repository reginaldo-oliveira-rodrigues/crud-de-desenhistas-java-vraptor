<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulário</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/commons/header.jspf" %>
	<br/>
	<a href=${pageContext.request.contextPath} >Início</a>
	<a href="listar" >Listar</a>
	<br/>
	<form action="adiciona">
		<fieldset>
			<legend>Adicionar Desenhista</legend>

			<label for="nome">Nome:</label> 
			<input id="nome" type="text" name="desenhista.nome" />
			<br/>
			<label for="email">E-Mail:</label>
			<input id="email" type="text" name="desenhista.email" />
			<br/>
			<label for="site">Site:</label> 
			<input id="site" type="text" name="desenhista.site" />
			<br/>
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
</body>
</html>