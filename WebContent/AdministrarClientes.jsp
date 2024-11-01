<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

</head>
<body>
    <div class="table-container">
    <%@ include file="MenuCliente.jsp" %>
        <table id ="miTabla">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>CUIT</th>
                    <th>Numero documento</th>
                    <th>Fecha nacimiento</th>
                    <th>Sexo</th>
                    <th>Numero telefono</th>
                    <th>Nacionalidad</th>
                    <th>Email</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Dato 1</td>
                    <td>Dato 2</td>
                    <td>Dato 3</td>
                    <td>Dato 4</td>
                    <td>Dato 5</td>
                    <td>Dato 6</td>
                    <td>Dato 7</td>
                    <td>Dato 8</td>
                    <td>Dato 9</td>
                    <td>
                         <button onclick="window.location.href='ClienteAgregar.jsp'">
                        <i class="bi bi">Editar</i>
                    </button>
                    <button onclick="window.location.href='index.html'">
                        <i class="bi bi-trash"></i>
                    </button>
                    </td>
                </tr>
               
            </tbody>
        </table>
        <div id="pagination">
            <button onclick="previousPage()">Anterior</button>
            <button onclick="nextPage()">Siguiente</button>
        </div>
    </div>
    <!-- <script src="eventos.js"></script> -->

</body>
</html>