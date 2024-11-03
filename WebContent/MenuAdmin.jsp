<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Menú Administrador</title>
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
        .menu-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 20px;
        }
        .menu-container a {
            margin: 5px 0;
            width: 200px; /* Ancho uniforme para los enlaces */
            text-align: center;
            border-radius: 5px;
            background-color: #4CAF50; /* Color de fondo para los botones */
            padding: 12px;
            color: white;
            text-decoration: none;
            transition: background-color 0.3s, transform 0.3s;
        }
        .menu-container a:hover {
            background-color: #45a049; /* Color de fondo al pasar el mouse */
            transform: scale(1.05);
        }
    </style>
</head>
<body>

    <div class="header">
        <img src="SLOGAN.png" alt="Logo">
        <h1>Menú Administrador</h1>
        <div class="user-info">Usuario: <strong>acá va el usuario logueado</strong></div>
    </div>
    
    <div class="menu-container">
        <a href="home.jsp">Administrar Cuenta</a>
        <a href="CuentaElegida.jsp">Administrar Clientes</a>
        <a href="services.jsp">Reportes de cuentas</a>
        <a href="contact.jsp">Solicitudes de prestamos</a>
        <a href="contact.jsp">Informes de prestamos</a>
         
    </div>
    
</body>
</html>