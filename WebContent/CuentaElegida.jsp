<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Cuenta" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cuenta Actual</title>
    <style>
    

    
        body {
            font-family: 'Roboto', sans-serif;
            color: #ff6633;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            width: 100%;
            background-color: #ecf0f1;
            padding-top: 100px;
        }

        .header {
            background-color: #1464a5;
            color: white;
            display: flex;
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
            flex-grow: 1;
            text-align: center;
            font-size: 24px;
        }

        .contenedor {
            background-color: #ffffff;
            padding: 20px;
            max-width: 600px;
            width: 90%;
            text-align: left;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        .titulo {
            color: #2980b9;
            font-size: 2rem;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .seccion {
            margin: 15px 0;
        }

        .seccion h2 {
            color: #2980b9;
            font-size: 1.5rem;
            font-weight: 500;
            margin-bottom: 5px;
        }

        .seccion p {
            color: #7f8c8d;
            font-size: 1.25rem;
            margin: 5px 0;
        }

        .saldo {
            font-size: 2rem;
            font-weight: bold;
            color: #27ae60;
        }

        /* Estilo para la tabla con 4 columnas */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #2980b9;
            color: white;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1c40f;
        }

        td {
            background-color: #ffffff;
        }

        td, th {
            font-size: 1rem;
            color: #34495e;
        }

       
        th, td {
            width: 25%; 
        }

     
        .tabla-container {
            width: 80%; 
            margin-top: 40px; 
        }

    </style>
</head>
<body>
<%@ include file="MenuCliente.jsp" %>

<div class="tabla-container">
    <h1>Bienvienido a ver Cuenta, esta es la elegida</h1>

    <%
        Cuenta cuenta = (Cuenta) session.getAttribute("cuentaElegida");

        if (cuenta != null) {
    %>
        <table>
            <tr>
                <th>CBU</th>
                <td><%= cuenta.getCBU() %></td>
                <th>IdCuenta</th>
                <td><%= cuenta.getIdCuenta() %></td>
            </tr>
            <tr>
                <th>Saldo</th>
                <td><%= cuenta.getSaldo() %></td>
                <th>Fecha de Creación</th>
                <td><%= cuenta.getFechaCreacion() %></td>
            </tr>
        </table>
    <%
        } else {
    %>
        <p>No se encontraron detalles de la cuenta.</p>
    <%
        }
    %>
</div>

</body>
</html>
