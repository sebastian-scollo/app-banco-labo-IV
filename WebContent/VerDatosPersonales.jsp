<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Personales</title>
<link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

</head>
<body>
    <%@ include file="MenuCliente.jsp" %>
    
    <div class="table-container">
        <table id ="miTabla">
            <thead>
                <tr>
                    <th>Dni cliente</th>
                    <th>telefono</th>
                    <th>apellido</th>
                    <th>sexo</th>
                    <th>fecha nacimiento</th>
                    <th>nacionalidad</th>
                    <th>correo</th>
                    <th>Nacionalidad</th>
                    <th>nombre</th>
                    <th>cuil</th>
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
                    <td>Dato 9</td>
                       <!-- <button onclick="editarFila(this)">Editar</button>-->
                       
                       
                    </td>
                </tr>
               
            </tbody>
        </table>
        
    </div>
    <script src="eventos.js"></script>
</body>
</html>