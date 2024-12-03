<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<%@ page import="entidades.Usuario" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="ISO-8859-1">
    <title>MenuAdmin</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
            display: flex; 
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
        .menu-container {
            background-color: #333; 
            height: 100vh;
            width: 200px; 
            padding-top: 70px; 
            position: fixed; 
            overflow-y: auto; 
        }
        .menu-container a {
            display: block; 
            margin: 5px 0;
            text-align: center;
            border-radius: 5px;
            background-color: #4CAF50; 
            padding: 12px;
            color: white;
            text-decoration: none;
            transition: background-color 0.3s, transform 0.3s;
        }
        .menu-container a:hover {
            background-color: #45a049; 
            transform: scale(1.05);
        }
      .content {
    margin-left: 220px; 
    padding: 20px; 
    flex-grow: 1; 
    background-image: url(BancoNejo.png); 
    background-size: cover; /* Asegura que la imagen cubra todo el contenedor */
    background-repeat: no-repeat; /* Evita que se repita la imagen */
    background-position: center; /* Centra la imagen en el contenedor */
    min-height: calc(100vh - 70px); /* Aseg�rate de que el contenido ocupe el espacio restante */
    padding-top: 70px; /* A�ade espacio superior para evitar que la imagen sea cubierta por la cabecera */


    </style>
</head>
<body>
<% if (session.getAttribute("usuarioLogueado") == null){
		
		response.sendRedirect("Login.jsp");
	} 
	
else if ((int)session.getAttribute("tipoUsuario") != 1) {
	response.sendRedirect("MenuCliente.jsp");
}
	
	%>
<% 
    String usuario = (String) session.getAttribute("usuarioLogueado");
	int tipo = (int) session.getAttribute("tipoUsuario");
    if (usuario == null || tipo != 1) {
        response.sendRedirect("Login.jsp");
        return;
    }
%>
    <div class="header">
        <img src="SLOGAN.png" alt="Logo" class="rounded-circle">
        <h1>  MENU ADMINISTRADOR</h1>
        <div class="user-info">Usuario: <strong><c:out value="${usuario}"></c:out></strong></div>
    </div>
    
    <div class="menu-container">
        <a href="servletCuenta?Param=1">Administrar Cuenta</a>
        <a href="ServletListarCliente?Param=1">Administrar Clientes</a>lo
        <a href="Informes.jsp">Reportes de Clientes</a>
        <a href="TipoMovimientoTotalconPorcentaje.jsp">Informe TipoMovimiento</a>
        <a href="InformeCuentaCreadas.jsp">Informe Cuenta</a>
        <a href="contact.jsp">Ver Solicitudes de pr�stamos</a>
        <a href="ServletAgregarCuenta?Param=1">Agregar Cuenta</a>
        
    </div>
    
    <div class="content">
        
        <p> </p>
        
        <h1></h1>
    </div>
    
</body>
</html>