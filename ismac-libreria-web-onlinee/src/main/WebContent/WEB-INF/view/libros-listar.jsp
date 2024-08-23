<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sistema Libreria</title>
	<link rel= "stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" />
	<link rel= "stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap-table.min.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	
</head>
<body>


<nav></nav>

<section class="px-5 py-5">
	
	<div class="container" >
	<h1>Libros</h1>
			<div class="container" style="text-align: center;" >
				<button class="btn btn-primary" onclick="window.location.href='/ismac-libreria-web-onlinee/libros/findOne?opcion=1'; return false;">
					<i class="fa-solid fa-address-book"></i>
					<!-- Agregar -->
	  		 </button>
		</div>
		<div class="table-responsive">
					<table id="tabla1"
							name="tabla1"
							data-height="600"
							data-search="true"
							data-pagination="true"
							data-toogle="tabla1"
							data-tollbar=".toolbar"
							class="table table-striped table-sm"
							>
						<thead>
							<tr>
								<th>idLibros</th>
								<th data-field="Título" data-sortable="true" >titulo</th>
								<th data-field="Editorial" data-sortable="true">editorial</th>
								<th data-field="N° Páginas" data-sortable="true">numPaginas</th>
								<th data-field="Edición" data-sortable="true">edicion</th>
								<th data-field="Idioma" data-sortable="true">idioma</th>
								<th data-field="Fecha de Publicación" data-sortable="true">fechaPublicacion</th>
								<th data-field="Descripción" data-sortable="true">descripcion</th>
								<th data-field="Tipo de Pasta" data-sortable="true">tipoPasta</th>
								<th data-field="ISBM" data-sortable="true">ISBN</th>
								<th data-field="Número de ejemplares" data-sortable="true">numEjemplares</th>
								<th data-field="Portada" data-sortable="true">portada</th>
								<th data-field="Presentación" data-sortable="true">presentacion</th>
								<th data-field="Precio" data-sortable="true">precio</th>
								<th data-field="Categoría" data-sortable="true">categoria</th>
								<th data-field="Autor" data-sortable="true">autor</th>
								<th >Acciones</th>
								
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
									<td>${fn:substring(item.fechaPublicacion,0,10)}</td>
									<td>${item.descripcion}</td>
									<td>${item.tipoPasta}</td>
									<td>${item.ISBN}</td>
									<td>${item.numEjemplares}</td>
									<td>
										<img alt="Portada de libro" width="100" height="100" src="${pageContext.request.contextPath}/resources/img/${item.portada}"/>
									</td>
									<td>${item.presentacion}</td>
									<td>${item.precio}</td>
									<td>${item.categoria.categoria}</td>
									<td>${item.autor.nombre}${item.autor.apellido}</td>
						
									<td>
				                  <button class="btn btn-success"  onclick="window.location.href='/ismac-libreria-web-onlinee/libros/findOne?idLibro=${item.idLibro}&opcion=1'; return false;">
									<i class="fa-solid fa-arrow-rotate-right"></i> 		
									 		<!-- Actualizar -->
									 	</button>
				                 <button class="btn btn-danger" onclick="window.location.href='/ismac-libreria-web-onlinee/libros/findOne?idLibro=${item.idLibro}&opcion=2'; return false;">
									 <i class="fa-solid fa-trash"></i>		
									 		<!-- Eliminar -->
									 	</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	
		</div>
	</div>

</section>

<footer></footer>
		

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-table.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-table-es-MX.min.js"></script>
	
	<script type="text/javascript">
	
	
		var $tabla1 = $('#tabla1')
		
		
		$(function (){

				$tabla1.bootstrapTable({ sortResert: true })
		 }	
		)
	
	</script>
	
	
	
</body>
</html>



























