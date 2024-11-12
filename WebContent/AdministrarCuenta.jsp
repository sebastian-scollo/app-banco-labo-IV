<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Cuenta" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminCuentas</title>
    <link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
        }
        .header {
            background-color: #1464a5;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 1000;
        }
        .header img {
            height: 60px;
        }
        .header h1 {
            margin: 0;
            font-size: 24px;
        }
        .user-info {
            font-size: 16px;
        }
        .table-container {
            margin-top: 70px;
            padding: 20px;
        }
        .search-input {
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
            outline: none;
            width: 200px;
        }
        .search-button {
            background-color: #4CAF50;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .search-button:hover {
            background-color: #45a049;
        }
        .show-all-button {
            background-color: #4CAF50; /* Verde */
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            margin-bottom: 10px;
        }
        .show-all-button:hover {
            background-color: #45a049; /* Un tono más oscuro de verde */
        }
    </style>
</head>
<body>
  <%@ include file="BarraMenuAdmin.jsp" %>
    
    <div class="table-container">
       <form action="servletCuenta" method="post">
        	<button class="show-all-button" name="btnMostrarTodo" type="submit">
            	<i class="bi bi-eye"></i> Mostrar todo
        	</button>
       </form> 
       
        <div class="search-container">
        <form action="servletCuenta" method="post" >
            <input type="text" name="txtBuscarIdCliente" class="search-input" placeholder="Buscar por ID cliente">
            <button class="search-button" name="btnBuscarID" >
                <i class="bi bi-search"></i> Aplicar
            </button>
            </form>
            <form action="servletCuenta" method="post"  >
            <input type="text" name="txtBuscarTipoCuenta" class="search-input" placeholder="Búsqueda por tipo de cuenta">
            <button class="search-button" name="btnBuscarTipoCuenta" type="submit" >
                <i class="bi bi-search"></i> Aplicar
            </button>
            </form>
        </div>
<table id="miTabla">
    <thead>
        <tr>
            <th>ID Cuenta</th>
            <th>Número de Cuenta</th>
            <th>CBU</th>
            <th>Saldo</th>
            <th>Cliente ID</th>
            <th>Tipo Cuenta ID</th>
            <th>Fecha Creación</th>
            <th>Opciones</th>
        </tr>
    </thead>
    <tbody>
      
        <%
            ArrayList<Cuenta> listadoCuenta = (ArrayList<Cuenta>) request.getAttribute("listadoCuenta");
            if (listadoCuenta != null && !listadoCuenta.isEmpty()) {
                for (Cuenta cuenta : listadoCuenta) {
        %>
        <tr>
            <td><%= cuenta.getIdCuenta()%></td>
            <td><%= cuenta.getNroCuenta() %></td>
            <td><%= cuenta.getCBU() %></td>
            <td><%= cuenta.getSaldo() %></td>
            <td><%= cuenta.getClienteId() %></td>
            <td><%= cuenta.getTipoCuentaId() %></td>
            <td><%= cuenta.getFechaCreacion() %></td>
            <td>
                <button onclick="window.location.href='EditarCuenta.jsp?id=<%= cuenta.getIdCuenta()%>'">
                    <i class="bi bi-pencil"></i> Editar
                </button>
                <button onclick="window.location.href='EliminarCuenta.jsp?id=<%= cuenta.getIdCuenta()%>'">
                    <i class="bi bi-trash"></i>
                </button>
            </td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr>
            <td colspan="8">No se encontraron cuentas.</td>
        </tr>
        <% } %>
    </tbody>
</table>
        
        <div id="pagination">
            <button onclick="previousPage()">Anterior</button>
            <button onclick="nextPage()">Siguiente</button>
        </div>
    </div>
</body>

</html>
