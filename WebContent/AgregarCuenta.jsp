<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.TipoCuenta, java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Cuenta</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
        }

        .header {
            background-color: #1464a5; /* Color del encabezado */
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            width: 100%;
            position: fixed; /* Mantener el encabezado fijo */
            top: 0;
            left: 0;
            z-index: 1000; /* Para que esté sobre otros elementos */
        }

        .header img {
            height: 60px; /* Ajusta el tamaño según sea necesario */
        }

        .header h1 {
            margin: 0;
            font-size: 24px;
        }

        .user-info {
            font-size: 16px;
        }

        .form-container {
            max-width: 700px;
            margin: 100px auto; /* Espacio superior para el header */
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: white; /* Fondo blanco para el formulario */
        }

        .form-group-pair {
            display: flex;
            gap: 20px;
            margin-bottom: 15px;
        }

        .form-group {
            position: relative;
            flex: 1;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            padding: 10px;
            border-radius: 4px;
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
            width: 100%;
            padding: 10px;
            background-color: #1464a5;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-bottom: 15px;
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
            content: '▾';
            position: absolute;
            right: 10px;
            top: 50%;
            color: #007bff;
            pointer-events: none;
        }

        .form-group:not(:has(select))::after {
            content: ''; /* Eliminar la flecha si no es un select */
        }
    </style>
</head>

<body>
    <%@ include file="BarraMenuAdmin.jsp" %>
    <%                 String listaTiposCuenta = (String) request.getAttribute("listaTiposCuenta");
 %>
    <div class="form-container">
        <h2>INGRESE DATOS DE CUENTA</h2>

        <form action="ServletAgregarCuenta" method="post">
            <div class="form-group-pair">
                <div class="form-group">
                    <select name="TipoCuenta">
			            
                      	<c:out value="${listaTiposCuenta}"/>
                      
                       
			        </select>
                </div>
                <div class="form-group">
                    <input type="text" id="IdCliente" name="IdCliente" 
                           placeholder="ID Cliente" class="form-input" 
                           pattern="^[A-Za-z0-9]{1,10}$" 
                           title="El ID del cliente debe contener entre 1 y 10 caracteres alfanuméricos." 
                           required>
                </div>
            </div>
            
            <div class="form-group-pair">
                <div class="form-group">
                    <input type="text" id="CBU" name="CBU" 
                           placeholder="CBU" class="form-input" 
                           pattern="^\d{22}$" 
                           title="El CBU debe contener exactamente 22 dígitos." 
                           required>
                </div>
                <div class="form-group">
                    <input type="text" id="NumCuenta" name="NumCuenta" 
                           placeholder="Número de cuenta" class="form-input" 
                           pattern="^\d{1,20}$" 
                           title="El número de cuenta debe contener entre 1 y 20 dígitos." 
                           required>
                </div>
            </div>

            <div class="form-group">
                <input type="text" id="Saldo" name="Saldo" 
                       placeholder="Saldo" class="form-input" 
                       pattern="^\d+(\.\d{1,2})?$" 
                       title="El saldo debe ser un número positivo con hasta dos decimales." 
                       required>
            </div>

            <input type="submit" class="submit-btn" name="btnAceptar" value="Agregar Cuenta">
        </form>
    </div>
</body>
</html>

