<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="MenuCliente.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EditarContrase�a</title>
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
            margin-bottom: 20px; /* Ajusta este valor para m�s o menos espacio */
        }
        .menu-image {
            
            padding-top: 10px;
            height: 150px; /* Tama�o de la imagen */
    
            
            margin-right: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); /* Borde esfumado */
            border-radius: 5px; /* Suaviza las esquinas */
        }

    </style>
</head>
<script>
    function confirmarEliminacion() {
        return confirm("�Estas seguro de que desea editar esta cuenta?");
    }
</script>
<body>

<%
    String nombreUsuario = (String) session.getAttribute("nombreUsuario");
    
%>
   
      
    <div class="form-container">
        
     
        <form action="ServletEditarPassword" method="post" onsubmit="return confirmarEliminacion();" >
        <input type="hidden" name="nombreUsuario" value="<%= nombreUsuario %>">
        <div class="form-group-pair">
            <div class="form-group">
                <input type="password" id="contrasena" name="contrasena" placeholder="Ingrese su contrase�a" class="form-input"  >
            </div>
             <div class="form-group">
                <input type="password" id="nuevaContrasena" name="nuevaContrasena" placeholder="Ingrese su nuevo contrase�a" class="form-input"  >
            </div>
            <div class="form-group">
                <input type="password" id="repContrasena" name="repContrasena" placeholder="Repita su contrase�a" class="form-input">
            </div>
        </div>

         
      
        <input type="submit" class="submit-btn" value="Actualizar contrase�a">
       </form> 
    </div>
      <% 
          
            String error = (String) request.getAttribute("error");
            String success = (String) request.getAttribute("success");
         
            if (error != null) {
        %>
                <p style="color: red;"><%= error %></p>
        <% } %>

        // Si existe un mensaje de �xito, mostrarlo
        <% if (success != null) { %>
                <p style="color: green;"><%= success %></p>
        <% } %>
  
</body>
</html>