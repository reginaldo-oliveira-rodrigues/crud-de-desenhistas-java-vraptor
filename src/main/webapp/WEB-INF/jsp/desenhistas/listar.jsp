<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<h1>Desenhistas</h1>
	<ul>
		<c:forEach items="${desenhistas}" var="desenhista">
			<li>${desenhista.nome} - ${desenhista.email}</li>
		</c:forEach>
	</ul>
</body>
</html>