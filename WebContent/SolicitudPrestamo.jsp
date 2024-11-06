<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solicitud de Préstamo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #e9ecef;
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
        .form-container {
            margin-top: 100px;
            padding: 25px;
            background-color: #ffffff;
            max-width: 800px;
            margin-left: auto;
            margin-right: auto;
            border-radius: 12px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 6px;
            outline: none;
            transition: border-color 0.3s;
        }
        .form-group input:focus, .form-group select:focus {
            border-color: #1464a5;
        }
        .button-group {
            display: flex;
            justify-content: space-between;
            gap: 10px;
        }
        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
            flex: 1;
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .btn-secondary {
            background-color: #1464a5;
        }
        .btn-secondary:hover {
            background-color: #125890;
        }
    </style>
</head>
<body>
     <%@ include file="MenuCliente.jsp" %>

    <div class="form-container">
        <form action="ProcesarPrestamo.jsp" method="post">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre" required>
            </div>
            <div class="form-group">
                <label for="apellido">Apellido</label>
                <input type="text" id="apellido" name="apellido" placeholder="Ingrese su apellido" required>
            </div>
            <div class="form-group">
                <label for="idCliente">Id Cliente</label>
                <input type="text" id="idCliente" name="idCliente" placeholder="Ingrese su ID de cliente" required>
            </div>
            <div class="form-group">
                <label for="cuit">CUIT</label>
                <input type="text" id="cuit" name="cuit" placeholder="Ingrese su CUIT" required>
            </div>
            <div class="form-group">
                <label for="monto">Monto del préstamo</label>
                <input type="number" id="monto" name="monto" placeholder="Ingrese el monto" required min="1" step="0.01">
            </div>
            <div class="form-group">
                <label for="cuotas">Cantidad de cuotas</label>
                <select id="cuotas" name="cuotas" required>
                    <option value="12">12 meses</option>
                    <option value="24">24 meses</option>
                    <option value="36">36 meses</option>
                    <option value="48">48 meses</option>
                </select>
            </div>
            <div class="form-group">
                <label for="interes">Tasa de interés (%)</label>
                <input type="number" id="interes" name="interes" placeholder="Ingrese la tasa de interés" required min="0" step="0.1">
            </div>
            <div class="button-group">
                <button type="submit" name="action" value="simular" class="btn">Simular Préstamo</button>
                <button type="submit" name="action" value="solicitar" class="btn btn-secondary">Solicitar Préstamo</button>
            </div>
        </form>
    </div>
</body>
</html>