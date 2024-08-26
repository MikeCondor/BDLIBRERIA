<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Eliminar Libro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-table.min.css" />
    <style>
        body {
            padding: 20px;
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 500px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        .form-container strong {
            display: block;
            margin-bottom: 15px;
            font-size: 1.2em;
        }
        .btn-group {
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <form action="del" method="get">
            <input type="hidden" id="idLibro" name="idLibro" value="${libro.idLibro}">
            <strong>¿Desea eliminar este dato?</strong>
            <div class="mb-3">
                <label for="titulo" class="form-label">Título</label>
                <input type="text" class="form-control" id="titulo" name="titulo" value="${libro.titulo}" required readonly>
            </div>
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción</label>
                <input type="text" class="form-control" id="descripcion" name="descripcion" value="${libro.descripcion}" required readonly>
            </div>
            <div class="btn-group">
                <button type="submit" class="btn btn-danger">Eliminar</button>
                <button type="button" class="btn btn-secondary" onclick="window.location.href='/ismac-libreria-web-online/libros/findAll'; return false;">Cancelar</button>
            </div>
        </form>
    </div>
</body>
</html>
 	