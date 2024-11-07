<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>pagoCuotas</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            height: 100vh; /* Asegura que el body ocupe toda la altura de la ventana */
            display: flex;
            justify-content: center; /* Centra horizontalmente */
            align-items: center; /* Centra verticalmente */
            background-color: #f0f0f0; /* Un color de fondo suave */
        }

        .form-group-pair {
            display: flex;
            flex-direction: column; /* Apila los inputs verticalmente */
            gap: 15px; /* Espaciado entre los inputs */
        }

        .form-group {
            position: relative;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            padding: 10px;
            border-radius: 4px;
            max-width: 300px;
            width: 100%; /* Asegura que los inputs no se expandan m�s all� del contenedor */
        }

        .form-label {
            position: absolute;
            top: 6px;
            left: 10px;
            font-size: 12px;
            color: #666;
            pointer-events: none;
        }

        .form-input {
            width: 100%;
            padding: 20px 10px 6px;
            font-size: 16px;
            border: none;
            background-color: transparent;
            outline: none;
            box-sizing: border-box;
            color: #666;
        }

        .submit-btn {
            width: 100%; /* Ajusta el ancho del bot�n al contenedor */
            padding: 10px;
            background-color: #1464a5;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .submit-btn:hover {
            background-color: #246da8;
        }
    </style>
</head>
<body>
<%@ include file="MenuCliente.jsp" %>
    <div class="form-group-pair">
    <h1>Efectuar Cuotas</h1>
        <div class="form-group">
            <input type="text" id="codigo de Prestamo" placeholder="codigo de Prestamo" class="form-input" required>
        </div>
        <div class="form-group">
            <input type="text" id="codigo cuota" placeholder="codigo cuota" class="form-input" required>
        </div>
        <div class="form-group">
            <input type="text" id="importe" placeholder="importe" class="form-input" required>
        </div>
        <input type="submit" class="submit-btn" value="Realizar">
    </div>
</body>
</html>
