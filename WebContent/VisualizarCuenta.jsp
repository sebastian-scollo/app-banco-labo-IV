<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
            justify-content: center;
            width: 100%;
            background-color: #ecf0f1;
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

        .user-info {
            font-size: 16px;
        }

        .contenedor {
            background-color: #ffffff;
            padding: 20px;
            max-width: 500px;
            width: 90%;
            text-align: left;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 100px; /* Ajustado para evitar solapamiento con el encabezado */
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
    </style>
</head>
<body>
   <%@ include file="MenuCliente.jsp" %>
   

    <div class="contenedor">
        <div class="titulo">Cuenta (CBU de la cuenta)</div>

        <div class="seccion">
            <h2>Saldo</h2>
            <p class="saldo">Valor Saldo</p>
        </div>

        <div class="seccion">
            <h2>Tipo de cuenta</h2>
            <p>(Tipo de cuenta)</p>
        </div>
    </div>
</body>
</html>
