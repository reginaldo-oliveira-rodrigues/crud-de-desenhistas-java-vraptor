<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Atualiação de Dados de Desenhistas</title>
</head>
<body>
	<form action="atualizar">
		<fieldset>
			<legend>Atualização de Dados</legend>
			<input id="id" type="hidden" name="desenhista.id" value="${desenhista.id}"/>
			
			<label for="nome">Nome:</label> 
			<input id="nome" type="text" name="desenhista.nome" value="${desenhista.nome}"/>
			<br/>
			<label for="email">E-Mail:</label>
			<input id="email" type="text" name="desenhista.email" value="${desenhista.email}"/>
			<br/>
			<label for="site">Site:</label> 
			<input id="site" type="text" name="desenhista.site" value="${desenhista.site}"/>
			<br/>
			<button type="submit">Atualizar</button>
		</fieldset>
	</form>
</body>
</html>