<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movimientos</title>
    <style>
        .form-container {
            max-width: 400px;
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            font-family: Arial, Helvetica, sans-serif;
        }

        .header {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
            position: relative;
        }

        .form-label {
            font-size: 12px;
            color: #666;
            margin-bottom: 5px;
            display: block;
        }

        .form-input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            outline: none;
            color: #666;
        }

        .submit-btn {
            width: 100%;
            padding: 10px;
            background-color: #1464a5;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 10px;
        }
        .submit-btn:hover {
            background-color: #246da8;
        }
    </style>
</head>

<body>
<%@ include file="MenuCliente.jsp" %>
    <div class="form-container">
        <div class="header">
            <h1>Movimientos</h1>
        </div>

        <!-- Formulario simplificado en diseño vertical -->
        <form action="submitForm" method="post">
            <div class="form-group">
                <label for="cbuOrigen" class="form-label">CBU Origen</label>
                <input type="text" id="cbuOrigen" name="cbuOrigen" class="form-input" required>
            </div>

            <div class="form-group">
                <label for="cbuDestino" class="form-label">CBU Destino</label>
                <input type="text" id="cbuDestino" name="cbuDestino" class="form-input" required>
            </div>

            <div class="form-group">
                <label for="monto" class="form-label">Monto</label>
                <input type="number" id="monto" name="monto" class="form-input" required>
            </div>

            <input type="submit" class="submit-btn" value="Aceptar">
        </form>
    </div>
</body>
</html>
