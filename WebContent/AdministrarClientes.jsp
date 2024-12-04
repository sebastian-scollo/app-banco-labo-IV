<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminCuentas</title>
    <link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
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
        .table-container {
            margin-top: 70px;
            padding: 20px;
        }
        .search-input {
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
            outline: none;
            width: 200px;
        }
        .search-button {
            background-color: #4CAF50;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .search-button:hover {
            background-color: #45a049;
        }
        .action-button {
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            color: white;
        }
        .accept-button {
            background-color: #8bc5ff /* Azul */
        }
        .accept-button:hover {
            background-color: #009999;
        }
        .reject-button {
            background-color: #dc3545; /* Rojo */
        }
        .reject-button:hover {
            background-color: #c82333;
        }
    </style>
    
</head>
<body>
   <%@ include file="BarraMenuAdmin.jsp" %>
   <div>
	   <div>
		    <h2>Prestamos en tramite</h2> <br>
		    <c:if test="${empty prestamosEnTramite}">
		        <p>No se encuentran prestamos pendientes de aprobacion.</p>
		    </c:if>
		    <c:if test="${not empty prestamosEnTramite}">
		    <table border="1">
		    <tr>
		        <th>ID Prestamo</th>
		        <th>ID Cliente</th>
		        <th>Nombre Cliente</th>
		        <th>Apellido Cliente</th>
		        <th>CBU</th>
		        <th>Fecha Solicitado</th>
		        <th>Monto Solicitado</th>
		        <th>Importe a Pagar</th>
		        <th>Plazo</th>
		        <th>Estado</th>
		        <th>Opciones</th>
		    </tr>
		    <c:forEach var="prestamo" items="${prestamosEnTramite}">
		        <tr>
		            <td>${prestamo.idPrestamo}</td>
		            <td>${prestamo.cuenta.objCliente.idCliente}</td>
		            <td>${prestamo.cuenta.objCliente.nombre}</td>
		            <td>${prestamo.cuenta.objCliente.apellido}</td>
		            <td>${prestamo.cuenta.CBU}</td>
		          	<td>
		            	<fmt:formatDate value="${prestamo.fechaSolicitado}" pattern="dd/MM/yyyy" />
		       		</td>
		            <td>${prestamo.montoSolicitado}</td>
		            <td>${prestamo.importeApagar}</td>
		            <td>${prestamo.plazo}</td>
		            <td>${prestamo.estado}</td>
		            <td>
		                <form action="ServletProcesarPrestamo" method="post">
		                    <input type="hidden" name="idPrestamo" value="${prestamo.idPrestamo}" />
		                    <button type="submit" class="action-button accept-button" name="btnAprobar" value="aprobar">Aprobar</button>
		                    <button type="submit" class="action-button reject-button" name="btnRechazar" value="rechazar">Rechazar</button>
		                </form>
		            </td>
		        </tr>
		    </c:forEach>
			</table>
		    </c:if>
		</div>
		
		<div>
		    <h2>Prestamos aprobados</h2> <br>
		    <c:if test="${empty prestamosAprobados}">
		        <p>No se encuentran prestamos aprobados.</p>
		    </c:if>
		    <c:if test="${not empty prestamosAprobados}">
		        <table id="miTabla" border="1">
		            <tr>
		                <th>ID Prestamo</th>
		                <th>ID Cliente</th>
		                <th>Nombre Cliente</th>
		                <th>Apellido Cliente</th>
		                <th>CBU</th>
		                <th>Fecha Solicitado</th>
		                <th>Monto Solicitado</th>
		                <th>Importe a Pagar</th>
		                <th>Plazo</th>
		            </tr>
		            <c:forEach var="prestamo" items="${prestamosAprobados}">
		                <tr>
		                    <td>${prestamo.idPrestamo}</td>
		                    <td>${prestamo.cuenta.objCliente.idCliente}</td>
		                    <td>${prestamo.cuenta.objCliente.nombre}</td>
		                    <td>${prestamo.cuenta.objCliente.apellido}</td>
		                    <td>${prestamo.cuenta.CBU}</td>
		                    <td>
		                        <fmt:formatDate value="${prestamo.fechaSolicitado}" pattern="dd/MM/yyyy" />
		                    </td>
		                    <td>${prestamo.montoSolicitado}</td>
		                    <td>${prestamo.importeApagar}</td>
		                    <td>${prestamo.plazo}</td>
		                </tr>
		            </c:forEach>
		        </table>
		        <div id="pagination">
		            <button onclick="changePage(-1)">Anterior</button>
		            <span id="pageInfo"></span>
		            <button onclick="changePage(1)">Siguiente</button>
		        </div>
		    </c:if>
		</div>
	
		<div>
		    <h2>Prestamos rechazados</h2> <br>
		    <c:if test="${empty prestamosRechazados}">
		        <p>No se encuentran prestamos rechazados.</p>
		    </c:if>
		    <c:if test="${not empty prestamosRechazados}">
		        <table border="1">
		            <tr>
		                <th>ID Prestamo</th>
		                <th>ID Cliente</th>
		                <th>Nombre Cliente</th>
		                <th>Apellido Cliente</th>
		                <th>CBU</th>
		                <th>Fecha Solicitado</th>
		                <th>Monto Solicitado</th>
		                <th>Importe a Pagar</th>
		                <th>Plazo</th>
		            </tr>
		            <c:forEach var="prestamo" items="${prestamosRechazados}">
		                <tr>
		                    <td>${prestamo.idPrestamo}</td>
		                    <td>${prestamo.cuenta.objCliente.idCliente}</td>
		                    <td>${prestamo.cuenta.objCliente.nombre}</td>
		                    <td>${prestamo.cuenta.objCliente.apellido}</td>
		                    <td>${prestamo.cuenta.CBU}</td>
		                    <td>
		                        <fmt:formatDate value="${prestamo.fechaSolicitado}" pattern="dd/MM/yyyy" />
		                    </td>
		                    <td>${prestamo.montoSolicitado}</td>
		                    <td>${prestamo.importeApagar}</td>
		                    <td>${prestamo.plazo}</td>
		                </tr>
		            </c:forEach>
		        </table>
		    </c:if>
		</div>
	</div>
		<script>
        const rowsPerPage = 3; 
        let currentPage = 1;
        function showPage(page) {
            const table = document.getElementById('miTabla');
            const rows = table.getElementsByTagName('tbody')[0].getElementsByTagName('tr');
            const totalPages = Math.ceil(rows.length / rowsPerPage);
            if (page < 1) page = 1;
            if (page > totalPages) page = totalPages;
            for (let i = 0; i < rows.length; i++) {
                rows[i].style.display = 'none';
            }
            for (let i = (page - 1) * rowsPerPage; i < (page * rowsPerPage) && i < rows.length; i++) {
                rows[i].style.display = '';
            }
            document.getElementById('pageInfo').innerText = `Pagina ${page} de ${totalPages}`;
            currentPage = page;
        }
        function changePage(direction) {
            showPage(currentPage + direction);
        }
        showPage(currentPage);
    </script>
</body>
</html>