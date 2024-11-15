<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Cliente" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>AdminClientes</title>
    <link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
            display: flex;
        }
        .table-container {
            margin-top: 70px;
            padding: 20px;
            flex-grow: 1;
        }
        .form-input {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: none;
            background-color: transparent;
            outline: none;
            box-sizing: border-box;
            color: #666;
        }
        .search-container {
            display: flex;
            gap: 5px;
            margin-bottom: 15px;
            align-items: center;
        }
        .search-button {
            background-color: #28a745;
            color: white;
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .search-button i {
            margin-right: 3px;
        }
        .search-button:hover {
            background-color: #218838;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        #pagination {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="table-container">
        <%@ include file="BarraMenuAdmin.jsp" %>

        <form action="ServletListarCliente" method="post">
            <input type="submit" value="Mostrar todo" name="btnMostrarTodos" class="search-button">
        </form>

        <form action="ServletListarCliente" method="post">
            <div class="search-container">
                <input type="text" class="form-input" name="txtDni" placeholder="Buscar por DNI">
                <button type="submit" class="search-button" name="btnBuscarDni">
                    <i class="bi bi-search"></i> Buscar DNI
                </button>
            </div>
        </form>

        <form action="ServletListarCliente" method="post">
            <div class="search-container">
                <input type="text" class="form-input" name="txtNombre" placeholder="Buscar por Nombre">
                <button type="submit" name="btnBuscarNombre" class="search-button">
                    <i class="bi bi-search"></i> Buscar Nombre
                </button>
            </div>
        </form>

        <table id="miTabla">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>CUIT</th>
                    <th>Número documento</th>
                    <th>Fecha nacimiento</th>
                    <th>Sexo</th>
                    <th>Número teléfono</th>
                    <th>Nacionalidad</th>
                    <th>Email</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) request.getAttribute("listaClientes");
                    if (listaClientes != null) {
                        for (Cliente cliente : listaClientes) {
                %>
                    <tr>
                        <td><%= cliente.getNombre() %></td>
                        <td><%= cliente.getApellido() %></td>
                        <td><%= cliente.getCuil() %></td>
                        <td><%= cliente.getDni() %></td>
                        <td><%= cliente.getFechaNacimiento() %></td>
                        <td><%= cliente.getSexo() %></td>
                        <td><%= cliente.getTelefono() %></td>
                        <td><%= cliente.getNacionalidad() %></td>
                        <td><%= cliente.getCorreo() %></td>
                        <td>
                            <button onclick="window.location.href='servletEditarCliente?dni=<%= cliente.getDni() %>'">
                                <i class="bi bi-pencil"></i> Editar
                            </button>
                            <button onclick="window.location.href='EliminarCliente.jsp'">
                                <i class="bi bi-trash"></i>
                            </button>
                        </td>
                    </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>

        <div id="pagination">
            <button onclick="changePage(-1)">Anterior</button>
            <span id="pageInfo"></span>
            <button onclick="changePage(1)">Siguiente</button>
        </div>
    </div>

    <script>
        const rowsPerPage = 3; 
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

            document.getElementById('pageInfo').innerText = `Página ${page} de ${totalPages}`;
            currentPage = page;
        }

        function changePage(direction) {
            showPage(currentPage + direction);
        }

        showPage(currentPage);
    </script>
</body>
</html>
