<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.TipoCuenta, java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
            content: '+';
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
<script>
    function confirmarEliminacion() {
        return confirm("¿Estas seguro de que desea agregar esta nueva cuenta?");
    }
</script>
<body>
<% if (session.getAttribute("usuarioLogueado") == null){
		
		response.sendRedirect("Login.jsp");
	} 
	
else if ((int)session.getAttribute("tipoUsuario") != 1) {
	response.sendRedirect("MenuCliente.jsp");
}%>
    <%@ include file="BarraMenuAdmin.jsp" %>
    
    <div class="form-container">
      <% 
        String mensajeErrorCuentas = (String) request.getAttribute("mensajeErrorCuentas");
        String mensajeErrorCliente = (String) request.getAttribute("mensajeErrorCliente");
        String mensajeErrorNroCuenta = (String) request.getAttribute("mensajeErrorNroCuenta");
        String mensajeErrorCBU = (String) request.getAttribute("mensajeErrorCBU");
        String mensajeExito = (String) request.getAttribute("mensajeExito");
        
        ArrayList<TipoCuenta> cuentas = (ArrayList<TipoCuenta>) request.getAttribute("listTipo");
      %>
    
      <% if (mensajeErrorCuentas != null && !mensajeErrorCuentas.isEmpty()) { %>
        <div class="alert alert-danger">
            <%= mensajeErrorCuentas %>
        </div>
      <% } %>
    
      <% if (mensajeErrorCliente != null && !mensajeErrorCliente.isEmpty()) { %>
        <div class="alert alert-danger">
            <%= mensajeErrorCliente %>
        </div>
      <% } %>

      <% if (mensajeErrorNroCuenta != null && !mensajeErrorNroCuenta.isEmpty()) { %>
        <div class="alert alert-danger">
            <%= mensajeErrorNroCuenta %>
        </div>
      <% } %>

      <% if (mensajeErrorCBU != null && !mensajeErrorCBU.isEmpty()) { %>
        <div class="alert alert-danger">
            <%= mensajeErrorCBU %>
        </div>
      <% } %>
    
      <% if (mensajeExito != null && !mensajeExito.isEmpty()) { %>
        <div class="alert alert-success">
            <%= mensajeExito %>
        </div>
      <% } %>
        
        <h2>INGRESE DATOS DE CUENTA</h2>

        <form action="ServletAgregarCuenta" method="post" onsubmit="return confirmarEliminacion();" >
            <div class="form-group-pair">
                <div class="form-group">
                    <label for="TipoCuenta" class="form-label">Tipo de Cuenta:</label>
                   
                    <select name="TipoCuenta" class="form-input" required>
                        <c:forEach var="tipo" items="${listTipo}">
                        <option value="${tipo.idTipoCuenta}">
                            ${ tipo.descripcion}
                        </option>
                    </c:forEach>
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
                           placeholder="Numero de cuenta" class="form-input" 
                           pattern="^\d{1,20}$" 
                           title="El número de cuenta debe contener entre 1 y 20 dígitos." 
                           required>
                </div>
            </div>

            <div class="form-group">
                <input type="text" id="Saldo" name="Saldo" 
                       placeholder="Saldo" class="form-input" 
                       pattern="^\d+(\.\d{1,2})?$" 
                       title="El saldo debe ser un numero positivo." 
                       required>
            </div>

            <input type="submit" class="submit-btn" name="btnAceptar" value="Agregar Cuenta">
        </form>
    </div>
</body>
</html>
