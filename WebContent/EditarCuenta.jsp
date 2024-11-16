<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EdicionCuenta</title>
    <style>
        /* Agregar margen superior al cuerpo para espacio entre menú y formulario */
        body {
            margin-top: 120px; /* Ajusta según la altura de BarraMenuAdmin.jsp */
        }

        .form-container {
            max-width: 500px;
            margin: 150px auto; /* Agregar espacio adicional en la parte superior */
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            font-family: Arial, Helvetica, sans-serif;
        }

        .form-group-pair {
            display: flex;
            gap: 20px;
            margin-bottom: 15px;
        }

        .form-group {
            position: relative;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 15px; /* Espaciado entre los campos */
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
            width: 50%;
            padding: 10px;
            background-color: #1464a5;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-bottom: 15px;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }

        .submit-btn:hover {
            background-color: #246da8;
        }

        /* Estilo para la flecha del select */
        .form-group select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            padding-right: 20px;
        }

        .form-group::after {
            content: '+';
            position: absolute;
            right: 10px;
            top: 50%;
            color: #007bff;
            pointer-events: none;
        }

        .form-group:not(:has(select))::after {
            content: ''; 
        }

        .form-group.email-group {
            margin-bottom: 20px; 
        }
        .form-group select {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ddd;
    background-color: #f5f5f5;
    border-radius: 4px;
    outline: none;
    box-sizing: border-box;
    color: #666;
}

.form-group select:focus {
    border-color: #007bff;
}

.form-group::after {
    content: '+';
    position: absolute;
    right: 10px;
    top: 50%;
    transform: translateY(-50%);
    color: #666;
    pointer-events: none;
}
        
    </style>
</head>
<%@ include file="BarraMenuAdmin.jsp" %>
<script>
    function confirmarEliminacion() {
        return confirm("¿Estas seguro de que desea editar esta cuenta?");
    }
</script>
<body>
    <div class="form-container">
        <form action="ServletModificarCuenta" method="post" onsubmit="return confirmarEliminacion();" >
       
       
            <div class="form-group">
                <label for="txtSaldo" class="form-label">Saldo:</label>
                <input type="text" id="txtSaldo" name="txtSaldo" placeholder="Ingrese el saldo" class="form-input" required />
            </div>

            <div class="form-group">
                <label for="txtClienteId" class="form-label">ID Cliente:</label>
                <input type="text" id="txtClienteId" name="txtClienteId" placeholder="Ingrese el ID del cliente" class="form-input" required />
            </div>
<div class="form-group">
    <label for="txtIdCuenta" class="form-label">ID Cuenta:</label>
    <input type="text" id="txtIdCuenta" name="txtIdCuenta" placeholder="Ingrese el ID de la cuenta a editar" class="form-input" required />
</div>


          <div class="form-group">
    <label for="selectTipoCuenta" class="form-label">Tipo de Cuenta:</label>
    <select id="selectTipoCuenta" name="selectTipoCuenta" class="form-input" required>
        <option value="1">Ahorro</option>
        <option value="2">Corriente</option>
        <option value="3">Plazo fijo</option>
    </select>
</div>
            <input type="submit" class="submit-btn" value="Aceptar" />
        </form>
    </div>
</body>
</html>