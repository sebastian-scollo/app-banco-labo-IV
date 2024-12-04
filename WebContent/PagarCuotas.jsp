<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<% if (session.getAttribute("usuarioLogueado") == null){
		
		response.sendRedirect("Login.jsp");
	} 

	
	%>
<%@ include file="MenuCliente.jsp" %>
    <div class="form-group-pair">
        <h1>Efectuar Cuotas</h1>
          <c:if test="${not empty mensaje}">
        <div class="mensaje ${mensaje.contains('error') ? 'error' : 'exito'}">
            ${mensaje}
        </div>
    </c:if>
        <form action="servletPagarCuota" method="post">
            <input type="hidden" name="action" value="realizarPago">
            <div class="form-group">
                <label>ID Préstamo:</label>
                <input type="text" name="idPrestamo" value="${idPrestamo}" readonly class="form-input" required>
            </div>
            <div class="form-group">
                <label>Cuotas Pendientes:</label>
                <select name="idCuota" class="form-input" required>
                    <option value="">Seleccione una cuota</option>
                   <c:forEach var="cuota" items="${cuotasPendientes}">
                         <option value="${cuota.idCuota}">
                                       ${cuota.nroCuota}
                          </option>
                   </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Importe Total:</label>
                <input type="text" name="importeTotal" value="${importeTotal}" readonly class="form-input" required>
            </div>
            <div class="form-group">
                <label>Valor de la Cuota:</label>
                <input type="text" value="${valorCuotaIndividual}" readonly class="form-input">
            </div>
            <div class="form-group">
                <label>Importe a Pagar:</label>
                <input type="text" name="importePagar" placeholder="Importe a pagar" class="form-input" required>
            </div>
            <input type="submit" class="submit-btn" value="Realizar Pago">
        </form>
    </div>
</body>
</html>
