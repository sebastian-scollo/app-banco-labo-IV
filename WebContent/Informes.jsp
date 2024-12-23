<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Cliente" %>
<%@ page import="entidades.Provincia" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Informe de Clientes</title>
    <link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <style>
        .form-input {
            width: 200px;
            padding: 8px;
            font-size: 14px;
            border: 1px solid #666;
            border-radius: 4px;
            color: #666;
        }
        
        .search-button {
            padding: 8px 12px;
            background-color: #1464a5;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        
        .search-button:hover {
            background-color: #0b4d94;
        }
    </style>
</head>
<body>
<% if (session.getAttribute("usuarioLogueado") == null){
		
		response.sendRedirect("Login.jsp");
	} 
	
else if ((int)session.getAttribute("tipoUsuario") != 1) {
	response.sendRedirect("MenuCliente.jsp");
}
	
	%>
<%@ include file="BarraMenuAdmin.jsp" %>

<div class="search-container">
    <h1>INFORMES</h1>
    <form action="servletReporte" method="post">
        <input type="text" name="txtBuscarIdProvincia" class="form-input" placeholder="Buscar por Id Provincia">
        <button type="submit" name="btnBuscarIdp" class="search-button">
            <i class="bi bi-search"></i> Buscar por Id Provincia
        </button>
    </form>

    <div class="table-container">
        <table id="miTabla" border="1">
            <thead>
                <tr>
                    <th>Dni cliente</th>
                    <th>Tel�fono</th>
                    <th>Apellido</th>
                    <th>Sexo</th>
                    <th>Fecha Nacimiento</th>
                    <th>Nacionalidad</th>
                    <th>Correo</th>
                    <th>Nombre</th>
                    <th>Provincia</th>
                    <th>CUIL</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
                if (listaClientes != null) {
                    for (Cliente cliente : listaClientes) {
                %>
                    <tr>
                        <td><%= cliente.getDni() %></td>
                        <td><%= cliente.getTelefono() %></td>
                        <td><%= cliente.getApellido() %></td>
                        <td><%= cliente.getSexo() %></td>
                        <td><%= cliente.getFechaNacimiento() %></td>
                        <td><%= cliente.getNacionalidad() %></td>
                        <td><%= cliente.getCorreo() %></td>
                        <td><%= cliente.getNombre() %></td>
                        <td><%= cliente.getProvincia().getNombre() %></td>
                        <td><%= cliente.getCuil() %></td>
                    </tr>
                <% 
                    }
                } else {
                %>
                    <tr>
                        <td colspan="10">No se encontraron resultados.</td>
                    </tr>
                <% 
                }
                %>
            </tbody>
        </table>

        <!-- Controles de Paginaci�n -->
        <div id="pagination">
            <button onclick="changePage(-1)">Anterior</button>
            <span id="pageInfo"></span>
            <button onclick="changePage(1)">Siguiente</button>
        </div>
    </div>
</div>

<script>
    const rowsPerPage = 2; 
    let currentPage = 1;

    function showPage(page) {
        const table = document.getElementById('miTabla');
        const rows = table.getElementsByTagName('tbody')[0].getElementsByTagName('tr');
        const totalPages = Math.ceil(rows.length / rowsPerPage);

        if (page < 1) page = 1;
        if (page > totalPages) page = totalPages;

       
        for (let i = 0; i < rows.length; i++) {
            rows[i].style.display = 'none';
        }

       
        for (let i = (page - 1) * rowsPerPage; i < (page * rowsPerPage) && i < rows.length; i++) {
            rows[i].style.display = '';
        }

       
        document.getElementById('pageInfo').innerText = `P�gina ${page} de ${totalPages}`;
        currentPage = page;
    }

    function changePage(direction) {
        showPage(currentPage + direction);
    }

    showPage(currentPage);
</script>

</body>
</html>
