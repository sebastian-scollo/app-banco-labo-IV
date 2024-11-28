<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="entidades.Prestamo" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ver y elegir Prestamo</title>
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
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 1000;
        }

        .header img {
            height: 60px;
        }

        .header h1 {
            margin: 0;
            font-size: 24px;
        }

        .table-container {
            margin: 90px auto;
            padding: 20px;
            max-width: 1200px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            text-align: left;
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
        }

        th {
            background-color: #1464a5;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .btn-select {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 8px 12px;
            font-size: 14px;
            cursor: pointer;
            display: inline-flex;
            align-items: center;
            gap: 5px;
        }

        .btn-select:hover {
            background-color: #45a049;
        }

        #pagination {
            text-align: center;
            margin-top: 20px;
        }

        #pagination button {
            background-color: #1464a5;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 8px 16px;
            font-size: 14px;
            cursor: pointer;
            margin: 0 5px;
        }

        #pagination button:hover {
            background-color: #0f4a7b;
        }

        @media (max-width: 768px) {
            .table-container {
                padding: 10px;
            }

            table {
                font-size: 14px;
            }
        }
    </style>
</head>

<body>
    <%@ include file="MenuCliente.jsp" %>

    <div class="table-container">
        <h1>Listado de Préstamos</h1>

        <table id="miTabla">
            <thead>
                <tr>
                    <th>CBU</th>
                    <th>IDCuenta</th>
                    <th>Importe Total</th>
                    <th>Plazo</th>
                    <th>Saldo</th>
                    <th>IDPrestamo</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Prestamo> listadoPrestamos = (ArrayList<Prestamo>) request.getAttribute("listadoPrestamos");

                    if (listadoPrestamos != null && !listadoPrestamos.isEmpty()) {
                        for (Prestamo prestamo : listadoPrestamos) {
                %>
                <tr>
                    <td><%= prestamo.getCuenta().getCBU() %></td>
                    <td><%= prestamo.getCuenta().getIdCuenta() %></td>
                    <td><%= prestamo.getImporteApagar() %></td>
                    <td><%= prestamo.getPlazo() %></td>
                    <td><%= prestamo.getCuenta().getSaldo() %></td>
                    <td><%= prestamo.getIdPrestamo() %></td>
                  <td>
    <form action="servletPagarCuota" method="post">
        <input type="hidden" name="idPrestamo" value="<%= prestamo.getIdPrestamo() %>">
        <input type="hidden" name="importeTotal" value="<%= prestamo.getImporteApagar() %>">
        <button type="submit" class="btn-select">
            <i class="bi bi-pencil"></i> Seleccionar
        </button>
    </form>
</td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="7" style="text-align: center;">No se encontraron préstamos para esta cuenta</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <div id="pagination">
            <button onclick="previousPage()">Anterior</button>
            <button onclick="nextPage()">Siguiente</button>
        </div>
    </div>
</body>

</html>
