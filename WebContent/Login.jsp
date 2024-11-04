<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
        /* Estilos generales */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
            background: url(BancoNejo.png) no-repeat center center fixed; /* Agrega la imagen de fondo */
            background-size: cover; /* Asegura que la imagen cubra todo el fondo */
            margin: 0;
        }
            
        /* Contenedor del formulario de login */
        .login-container {
            width: 350px;
            padding: 30px;
            background-color: rgba(255, 255, 255, 0.9); /* Fondo blanco con transparencia */
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            border-radius: 10px;
            text-align: center;
            backdrop-filter: blur(10px); /* Desenfoque del fondo */
        }

        .login-container h2 {
            font-size: 24px;
            margin-bottom: 20px; /* Mayor espacio entre el título y el contenido */
            color: #333;
        }

        /* Estilos de los inputs */
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0; /* Mayor separación entre inputs */
            border: none;
            border-bottom: 2px solid #ccc;
            outline: none;
            font-size: 16px;
        }

        .login-container input[type="text"]:focus,
        .login-container input[type="password"]:focus {
            border-bottom-color: #043263;
        }

        /* Botón de iniciar sesión */
        .login-container .btn-login {
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background: linear-gradient(135deg, #246da8, #043263);
            color: #fff;
            border: none;
            border-radius: 25px;
            font-size: 16px;
            cursor: pointer;
        }

        .login-container .btn-login:hover {
            opacity: 0.9;
        }
        
        .login-container img {
            width: 200px; /* Ajusta el tamaño según sea necesario */
            margin-bottom: 20px; /* Mayor espacio debajo del logo */
        }
    </style>
</head>

<body>
<div class="login-container">
        
        <h2>Bienvenido a Banca Online</h2>
        <input name="txtContrasenia1" type="text" placeholder="Usuario">
        <input name="txtContrasenia2" type="password" placeholder="Contraseña">
        
        <button name="btnIniciarSesion" class="btn-login">Ingresar</button>
    </div>
</body>
</html>