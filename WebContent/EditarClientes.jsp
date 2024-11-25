<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Cliente</title>
    <style>
       
        body {
            margin-top: 120px; 
        }


        .form-container {
            max-width: 700px;
            margin:  auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            font-family: Arial, Helvetica, sans-serif;
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
            
            width: 100%;
            padding: 10px;
            background-color: #1464a5;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-bottom: 15px;
        }
        .submit-btn:hover {
            background-color: #246da8;
           
        }
        .form-group select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            padding-right: 20px;

            
        }
        .form-group {
            flex: 1;
            margin-right: 10px;
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
<script>
    function confirmarEliminacion() {
        return confirm("¿Seguro de querer aplicar los nuevos cambios?");
    }
</script>
<body>

    <%@ include file="BarraMenuAdmin.jsp" %>
    

       <%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
    if (cliente == null) {
        cliente = new Cliente(); 
    }
%>

<form action="servletEditarCliente" method="post" onsubmit="return confirmarEliminacion();" >
    <div class="form-group-pair">
        <div class="form-group">
            <input type="text" name="nombre" id="nombres" placeholder="Nombre" required
                   value="<%= cliente.getNombre() %>" class="form-input">
        </div>
        <div class="form-group">
            <input type="text" name="apellido" id="apellidos" placeholder="Apellido" required
                   value="<%= cliente.getApellido() %>" class="form-input">
        </div>
    </div>

    <div class="form-group-pair">
        <div class="form-group">
            <input type="text" name="telefono" placeholder="Teléfono" required
                   value="<%= cliente.getTelefono() %>" class="form-input">
        </div>
        <div class="form-group">
            <select name="sexo" id="sexo-dni" class="form-input">
                <option value="femenino" <%= "femenino".equals(cliente.getSexo()) ? "selected" : "" %>>Femenino</option>
                <option value="masculino" <%= "masculino".equals(cliente.getSexo()) ? "selected" : "" %>>Masculino</option>
            </select>
        </div>
    </div>

    <div class="form-group email-group">
        <input type="email" name="email" placeholder="Email" required
               value="<%= cliente.getCorreo() %>" class="form-input">
    </div>

    <input type="hidden" name="dni" value="<%= cliente.getDni() %>">
    <input type="submit" class="submit-btn" name="btnAceptar" value="Aceptar">
</form>
</body>
</html>