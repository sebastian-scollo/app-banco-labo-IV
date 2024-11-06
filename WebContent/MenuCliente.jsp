<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
</head>
<body>
    <div class="header">
        <img src="SLOGAN.png" alt="Logo">
        <div class="menu">
            <a href="OpcionesCuenta.jsp">Eleccion Cuentas</a>
            <a href="CuentaElegida.jsp">Ver Cuenta</a>
            <a href="SolicitudPrestamo.jsp">Solicitud Prestamo</a>
            <a href="Transferencias.jsp">Transacciones</a>
            <a href="contact.jsp">Realizar pago de Cuotas</a>
            <a href="EditarPassword.jsp">Cambiar Contrasenia</a> 
            <a href="contact.jsp">Datos Personales</a> 
            <a href="contact.jsp">Historial de movimientos</a> 
        </div>
        <div class="user-info">Usuario: <strong>acá va el usuario Cliente</strong></div>
    </div>
</body>
</html>
