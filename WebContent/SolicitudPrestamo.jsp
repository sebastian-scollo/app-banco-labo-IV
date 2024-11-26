<%@ page import="java.util.ArrayList"%>
<%@ page import="entidades.Cuenta" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
     <%@ include file="MenuCliente.jsp" %>
<div class="form-container">
    <form action="ServletSolicitudPrestamo" method="post">
        <div class="form-group">
            <label for="cuenta">Cuenta para el depósito</label>
            <select id="cuenta" name="cuenta" required>
                <option value="">Seleccione una cuenta</option>
                <c:if test="${not empty cuentas}">
				    <c:forEach var="cuenta" items="${cuentas}">
				        <option value="${cuenta.idCuenta}">${cuenta.CBU}</option>
				    </c:forEach>
				</c:if>
				<c:if test="${empty cuentas}">
    				<option value="">No hay cuentas disponibles</option>
				</c:if>
            </select>
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
        <div class="button-group">
            <button type="button" id="btnSimularPrestamo" class="btn btn-primary flex-fill">Simular Préstamo</button>
			<button type="button" id="btnSolicitarPrestamo" value="solicitar" class="btn btn-secondary">Solicitar Préstamo</button>
        </div>
    </form>
</div>

    
    <!-- Modal para mostrar el préstamo simulado -->
	<div class="modal fade" id="simularPrestamoModal" tabindex="-1" aria-labelledby="simularPrestamoLabel" aria-hidden="true">
	    <div class="modal-dialog modal-dialog-centered">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="simularPrestamoLabel">Simulación de Préstamo</h5>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
	            </div>
	            <div class="modal-body">
	                <!-- Aquí se mostrarán los datos del préstamo simulado -->
	                <p><strong>Monto solicitado:</strong> $<span id="simularMonto"></span></p>
	                <p><strong>Cuotas:</strong> <span id="simularCuotas"></span> meses</p>
	                <p><strong>TNA:</strong> <span id="simularInteres"></span>%</p>
	                <p><strong>Importe total a pagar:</strong> $<span id="simularTotal"></span></p>
	                <p><strong>Importe por cuota:</strong> $<span id="simularPorCuota"></span></p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
	            </div>
	        </div>
	    </div>
	</div>
	
	<div class="modal fade" id="confirmarPrestamoModal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="modalLabel">Confirmar Solicitud de Préstamo</h5>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	            </div>
				<div class="modal-body">
				    <p><strong>Monto solicitado:</strong> $<span id="confirmarMonto"></span></p>
				    <p><strong>Cuotas:</strong> <span id="confirmarCuotas"></span> meses</p>
				    <p><strong>TNA:</strong> <span id="confirmarInteres"></span>%</p>
				    <p><strong>Importe total a pagar:</strong> $<span id="confirmarTotal"></span></p>
				    <p><strong>Importe por cuota:</strong> $<span id="confirmarPorCuota"></span></p>
				    <p><strong>Cuenta para depósito:</strong> <span id="confirmarCuenta"></span></p>
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	                <button id="btnConfirmar" type="button" class="btn btn-primary">Confirmar</button>
	            </div>
	        </div>
	    </div>
	</div>
	
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="js/prestamos.js"></script>
</body>
</html>