<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="del" method="get">

	<input type="hidden" id="idLibro" name="idLibro" value="${libro.idLibro}">
 
    <strong>¿Deseas Borrar esta Clientes?</strong>
    <br/>
    
    <button type="submit">BORRAR</button>
    
</form>

       <button onclick="window.location.href='/ismac-libreria-web-onlinee/libros/findOne?idLibro=${item.idLibro}&opcion=2'; return false;">
        CANCELAR
    </button>
</body>
</html>