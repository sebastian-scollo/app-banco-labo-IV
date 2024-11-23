<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Personales</title>
<link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

</head>
<body>
    <%@ include file="MenuCliente.jsp" %> <!-- Incluir el menú -->

    <div class="table-container">
        <h2>Datos Personales del Cliente</h2>
        <table id="miTabla" border="1">
            <thead>
                <tr>
                    <th>DNI Cliente</th>
                    <th>Teléfono</th>
                    <th>Apellido</th>
                    <th>Sexo</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Nacionalidad</th>
                    <th>Correo</th>
                    <th>Nombre</th>
                    <th>CUIL</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <% 
                        // Obtener el objeto 'cliente' desde el request
                        Cliente cliente = (Cliente) request.getAttribute("cliente");

                        if (cliente != null) {
                    %>
                    <td><%= cliente.getDni() %></td>
                    <td><%= cliente.getTelefono() %></td>
                    <td><%= cliente.getApellido() %></td>
                    <td><%= cliente.getSexo() %></td>
                    <td><%= cliente.getFechaNacimiento() %></td>
                    <td><%= cliente.getNacionalidad() %></td>
                    <td><%= cliente.getCorreo() %></td>
                    <td><%= cliente.getNombre() %></td>
                    <td><%= cliente.getCuil() %></td>
                    <% 
                        } else {
                    %>
                    <td colspan="9">No se encontraron datos personales para este cliente.</td>
                    <% 
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </div>

    <script src="eventos.js"></script> <!-- Si tienes un archivo de JavaScript -->
</body>
</html>