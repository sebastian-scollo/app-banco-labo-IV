<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Prestamo" %>
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
        .action-button {
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            color: white;
        }
        .accept-button {
            background-color: #8bc5ff /* Azul */
        }
        .accept-button:hover {
            background-color: #009999;
        }
        .reject-button {
            background-color: #dc3545; /* Rojo */
        }
        .reject-button:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
	<% if (session.getAttribute("usuarioLogueado") == null){
		
		response.sendRedirect("Login.jsp");
	} 
	
	else if ((int)session.getAttribute("tipoUsuario") != 1) {
		response.sendRedirect("MenuCliente.jsp");
	}%>
   <%@ include file="BarraMenuAdmin.jsp" %>
      
    <div class="table-container">
        <div class="search-container">
    <h1>Solicitudes de Prestamo</h1>
            
          
        </div>

        <table id="miTabla">
            <thead>
                <tr>
                    <th>CBU</th>
                    <th>Monto Pedido</th>
                    <th>Cantidad Cuotas</th>
                    <th>Fecha</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
              <%
            ArrayList<Prestamo> listadoCuenta = (ArrayList<Prestamo>) request.getAttribute("prestamosEnTramite");
            if (listadoCuenta != null && !listadoCuenta.isEmpty()) {
                for (Prestamo prestamo : listadoCuenta) {
        %>
                <tr>
                    <td><%= prestamo.getCuenta().getCBU()%></td>
                    <td><%= prestamo.getMontoSolicitado() %></td>
                    <td><%= prestamo.getPlazo()%></td>     
                    <td><%=prestamo.getFechaSolicitado() %></td>
                    
                    <td>
                     <form action="ServletProcesarPrestamo?idPrestamo=<%= prestamo.getIdPrestamo()%>" method="post">
                        <button class="action-button accept-button" name="btnAprobar" >
                            
                            <i class="btn btn-success"></i> Aceptar
                        </button>
                        </form>
                        <form action="ServletProcesarPrestamo" method="post">
                        <button class="action-button reject-button" name="btnRechazar">
                            <i class="bi bi-x-circle"></i> Rechazar
                        </button>
                        </form>
                    </td>
                </tr>
                <%}%>
                 <%}%>
            </tbody>
        </table>

        <div id="pagination">
            <button onclick="previousPage()">Anterior</button>
            <button onclick="nextPage()">Siguiente</button>
        </div>
    </div>
</body>
</html>
