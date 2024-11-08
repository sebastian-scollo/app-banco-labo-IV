<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
        body{
            font-family: Arial, Helvetica, sans-serif;
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

.header .menu {
    display: flex;
    gap: 1px; 
}

.header a {
    color: white;
    padding: 5px 8px; 
    text-decoration: none;
    display: inline-block;
}

.header a:hover {
    background-color: #0b4d94;
}
  </style>
</head>
<body>
<div class="header">
        <img src="images/sinfondo.png" alt="Logo">
        <h1>ADMINISTRADOR</h1> 
        <div class="menu">
            <a href="AdministrarClientes.jsp">Administrar Clientes</a>
            <a href="AdministrarCuenta.jsp">Administrar Cuentas</a>
            <a href="AceptarPrestamo.jsp">Ver solicitud Prestamo</a>
            <a href="Informes.jsp">Informes</a>
            <a href="Agregar Cliente.jsp">Agregar Cliente</a>
            <a href="Agregar Cuenta.jsp">Agregar Cuenta</a>
        </div>
        <div class="user-info">Usuario: <strong>acá va el usuario logueado</strong></div>
    </div>
</body>
</html>