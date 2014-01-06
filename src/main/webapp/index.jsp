<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Título de página JSP de exemplo!</title>
    </head>
    <body>
        <div id="desenhistas"></div>
        <br/>
        <br/>
        <form action="desenhistas/formulario" method="POST">
        	<input type="submit" value="Cadastrar"/>
        </form>
        
        <form action="desenhistas/listar" method="POST">
        	<input type="submit" value="Ver Desenhistas"/>
        </form>
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>
        var data_type = "html";
        var url = "desenhistas/listar";
        $(document).ready(function(){
        	/*
        	$.ajax({
    			dataType : data_type,
    			url : url,
    			success : mostrar_dados,
    			error : avisarDeErro
    		});
        	*/
        	
        });
        
        function mostrar_dados(data){
        	$("#desenhistas").html(data);
        };
        
        function avisarDeErro(){
        	
        };
        
        </script>
        
    </body>
</html>