<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
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
    min-height: calc(100vh - 70px); /* Asegúrate de que el contenido ocupe el espacio restante */
    padding-top: 70px; /* Añade espacio superior para evitar que la imagen sea cubierta por la cabecera */


    </style>
</head>
<body>

    <div class="header">
        <img src="SLOGAN.png" alt="Logo">
        <h1>  MENU ADMINISTRADOR</h1>
        <div class="user-info">Usuario: <strong>acá va el usuario logueado</strong></div>
    </div>
    
    <div class="menu-container">
        <a href="AdministrarCuenta.jsp">Administrar Cuenta</a>
        <a href="AdministrarClientes.jsp">Administrar Clientes</a>
        <a href="services.jsp">Reportes de Clientes</a>
        <a href="contact.jsp">Ver Solicitudes de préstamos</a>
        <a href="contact.jsp">Agregar Cliente</a>
        <a href="contact.jsp">Agregar Cuenta</a>
    </div>
    
    <div class="content">
        
        <p> </p>
        
        <h1></h1>
    </div>
    
</body>
</html>