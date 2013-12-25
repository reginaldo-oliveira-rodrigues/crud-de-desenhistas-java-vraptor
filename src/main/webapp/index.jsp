<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Título de página JSP de exemplo!</title>
    </head>
    <body>
        <h1>Desenhistas Cadastrados</h1>
        <br/>
        <div id="desenhistas"></div>
        
        
        
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>
        var data_type = "html";
        var url = ${pageContext.request.contextPath} + "/desenhistas/listar";
        $(document).ready(function(){
        	
        	$.ajax({
    			dataType : data_type,
    			data: numeros,
    			url : url,
    			success : mostrar_dados
    		});
        });
        
        function mostrar_dados(data){
        	$("#desenhistas").html(data);
        }
        
        </script>
        
    </body>
</html>