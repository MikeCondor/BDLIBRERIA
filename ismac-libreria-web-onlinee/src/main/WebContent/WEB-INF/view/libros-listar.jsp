<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Libros</h1>
	
	<button onclick="window.location.href='/ismac-libreria-web-onlinee/libros/findOne?opcion=1'; return false;">
		Agregar
    </button>
 
	<table>
		<thead>
			<tr>
				<th>idLibros</th>
				<th>titulo</th>
				<th>editorial</th>
				<th>numPaginas</th>
				<th>edicion</th>
				<th>idioma</th>
				<th>fechaPublicacion</th>
				<th>descripcion</th>
				<th>tipoPasta</th>
				<th>ISBN</th>
				<th>numEjemplares</th>
				<th>portada</th>
				<th>presentacion</th>
				<th>precio</th>
				<th>categoria</th>
				<th>autor</th>
				<th>Acciones</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${libros}">
				<tr>
					<td>${item.idLibro}</td>
					<td>${item.titulo}</td>
					<td>${item.editorial}</td>
					<td>${item.numPaginas}</td>
					<td>${item.edicion}</td>
					<td>${item.idioma}</td>
					<td>${item.fechaPublicacion}</td>
					<td>${item.descripcion}</td>
					<td>${item.tipoPasta}</td>
					<td>${item.ISBN}</td>
					<td>${item.numEjemplares}</td>
					<td><img alt="Portada de libro" width="100" height="100" src="${pagecontext.request.contextPath}/resources/img/${item.portada}"/>
					</td>
					<td>${item.presentacion}</td>
					<td>${item.precio}</td>
					<td>${item.categoria}</td>
					<td>${item.autor}</td>
		
					<td>
					  <button onclick="window.location.href='/ismac-libreria-web-onlinee/libros/findOne?idlibro=${item.idLibro}&opcion=1'; return false;">
					 		Actualizar
					 	</button>
					 	<button onclick="window.location.href='/ismac-libreria-web-onlinee/libros/findOne?idlibro=${item.idLibro}&opcion=2'; return false;">
					 		Eliminar
					 	</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
 
 
 
</body>
</html>