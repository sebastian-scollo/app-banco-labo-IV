<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="MenuCliente.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EditarContraseña</title>
    <style>
        


    
        
       .form-container {
    max-width: 700px;
    margin: auto;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 5px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    font-family: Arial, Helvetica, sans-serif;
    margin-top: 200px; 
}

        .header {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group-pair {
            display: flex;
            gap: 20px;
            margin-bottom: 15px;
        }

        .form-group {
            position: relative;
            flex: 1;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            padding: 10px;
            border-radius: 4px;
           
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

            width: 50%;
            padding: 10px;
            background-color: #1464a5;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-bottom: 15px;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
        .submit-btn:hover {
            background-color: #246da8;
           
        }

        /* Estilo para la flecha del select */
        .form-group select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            padding-right: 20px;

            
        }
        .form-group {
            flex: 1; /* Las columnas ocupan el mismo espacio */
            margin-right: 10px; /* Espacio entre columnas */
        }
        .form-group-pair {
            display: flex; /* Usar flexbox para dos columnas */
            justify-content: space-between; /* Espaciado entre columnas */
        }

        .form-group::after {
            content: '^';
            position: absolute;
            right: 10px;
            top: 50%;
            color: #007bff;
            pointer-events: none;
        }

     
        .form-group:not(:has(select))::after {
            content: ''; /* Esto elimina el contenido, es decir, la flecha */
        }
        .form-group.email-group {
            margin-bottom: 20px; /* Ajusta este valor para más o menos espacio */
        }
        .menu-image {
            
            padding-top: 10px;
            height: 150px; /* Tamaño de la imagen */
    
            
            margin-right: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); /* Borde esfumado */
            border-radius: 5px; /* Suaviza las esquinas */
        }

    </style>
</head>
<body>
    <div class="form-container">
        
        <!-- Campos en dos columnas -->
        <form action="submitForm" method="post">
        <div class="form-group-pair">
            <div class="form-group">
                <input type="password" id="contraseña" placeholder="Ingrese su contraseña" class="form-input"  >
            </div>
            <div class="form-group">
                <input type="password" id="repContraseña" placeholder="Repita su contraseña" class="form-input">
            </div>
        </div>


        <!-- Boton de envio -->
        <input type="submit" class="submit-btn" value="Actualizar contraseña">
       </form> 
    </div>
</body>
</html>