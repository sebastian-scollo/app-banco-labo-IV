<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entidades.Cuenta" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cuentas Creadas</title>
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

<%@ include file="BarraMenuAdmin.jsp" %>

<div class="search-container">
    <h1>Cuentas Creadas</h1>
   <form action="servletReporte" method="post">
    <div style="display: flex; align-items: center; gap: 10px;">
        <div>
            <label for="txtFechaInicio" style="display: block;">Fecha Inicio:</label>
            <input type="date" id="txtFechaInicio" name="txtFechaInicio" class="form-input" placeholder="Fecha inicio">
        </div>
        <div>
            <label for="txtFechaFinal" style="display: block;">Fecha Final:</label>
            <input type="date" id="txtFechaFinal" name="txtFechaFinal" class="form-input" placeholder="Fecha Final">
        </div>
        <div>
            <button type="submit" name="btnBuscarIntervalo" class="search-button">
                <i class="bi bi-search"></i> Ingrese el intervalo de Fechas
            </button>
        </div>
    </div>
</form>
<% 
  String error = (String) request.getAttribute("error");
  if (error != null) {
  %>
  <div class="alert alert-danger">
    <%= error %>
  </div>
  <% } %>
    <div class="table-container">
        <table id="miTabla" border="1">
            <thead>
                <tr>
                    <th>CBU</th>
                    <th>ClienteID</th>
                    <th>Saldo</th>
                    <th>Fecha de Creación</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Cuenta> listaCuentas = (List<Cuenta>) request.getAttribute("listaCuentas");
                if (listaCuentas != null) {
                    for (Cuenta cuenta : listaCuentas) {
                %>
                    <tr>
                        <td><%= cuenta.getCBU()%></td>
                        <td><%= cuenta.getClienteId() %></td>
                        <td><%= cuenta.getSaldo() %></td>
                        <td><%= cuenta.getFechaCreacion() %></td>
                    </tr>
                <% 
                    }
                } else {
                %>
                    <tr>
                        <td colspan="4">No se encontraron resultados.</td>
                    </tr>
                <% 
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
