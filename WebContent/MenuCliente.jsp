<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
    String mensajeExito = (String) session.getAttribute("mensajeExito");
    String mensajeError = (String) session.getAttribute("mensajeError");

    // Limpiar los mensajes después de mostrarlos
    session.removeAttribute("mensajeExito");
    session.removeAttribute("mensajeError");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <style>
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
        .header .menu {
            display: flex;
            gap: 10px; 
        }
        .header a {
            color: white;
            padding: 14px 20px; 
            text-decoration: none;
            display: inline-block;
        }
        .header a:hover {
            background-color: #1b2025;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <!-- Mostrar mensaje de éxito -->
    <% if (mensajeExito != null) { %>
        <div class="toast-container position-fixed bottom-0 end-0 p-3">
            <div class="toast show align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="d-flex">
                    <div class="toast-body">
                        <%= mensajeExito %>
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
            </div>
        </div>
    <% } %>

    <!-- Mostrar mensaje de error -->
    <% if (mensajeError != null) { %>
        <div class="toast-container position-fixed bottom-0 end-0 p-3">
            <div class="toast show align-items-center text-bg-danger border-0" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="d-flex">
                    <div class="toast-body">
                        <%= mensajeError %>
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
            </div>
        </div>
    <% } %>
		<%
		    String usuarioLogueado = (String) session.getAttribute("usuarioLogueado");
		 
		    
		%>

    <div class="header">
        <img src="SLOGAN.png" alt="Logo" class="rounded-circle">
        <div class="menu">
            <a href="OpcionesCuenta.jsp">Eleccion Cuentas</a>
            <a href="CuentaElegida.jsp">Ver Cuenta</a>
            <a href="ServletSolicitudPrestamo?Param=1">Solicitud Prestamo</a>
            <a href="Transferencias.jsp">Transacciones</a>
            <a href="PagarCuotas.jsp">Realizar pago de Cuotas</a>
            <a href="EditarPassword.jsp?nombreUsuario=<%= usuarioLogueado %>">Cambiar Contrasenia</a> 
            <a href="servletDatosPersonales">Datos Personales</a> 
            <a href="contact.jsp">Historial de movimientos</a> 
        </div>
        
        
        
        <div class="user-info">Usuario: <strong><%= usuarioLogueado %></strong></div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
