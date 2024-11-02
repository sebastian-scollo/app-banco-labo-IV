<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Formulario para registrar nuevo Clientes</title>

    <style>
       
        .form-container {
            max-width: 700px;
            margin: 100px auto;
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

        .form-group::after {
            position: absolute;
            right: 10px;
            top: 50%;
            color: #007bff;
            pointer-events: none;
        }

        .form-group:not(:has(select))::after {
            content: ''; 
        }

        .form-group.email-group {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <%@ include file="MenuCliente.jsp" %>
    <div class="form-container">
        <div class="header">
            <h1>Registrar Cliente</h1>
            <p>Complete los siguiente campos</p>
        </div>

       
        <div class="form-group-pair">
            <div class="form-group">
                <input type="text" id="nombres" name="txtNombre" placeholder="Nombre" class="form-input">
            </div>
            <div class="form-group">
                <input type="text" id="apellidos" txt="txtApellido" placeholder="Apellido" class="form-input">
            </div>
        </div>

        <div class="form-group-pair">
            <div class="form-group">
                <label for="txtCuit" class="form-label">CUIT</label>
                <input type="number" id="txtCuit" name="txtCuil" placeholder="CUIT" required min="0" step="1" class="form-input">
            </div>
            <div class="form-group">
                <input type="number" id="numero-documento" name="txtDni" placeholder="Numero de documento" required min="0" step="1" class="form-input">
            </div>
        </div>

        <div class="form-group-pair">
            <div class="form-group">
                <label for="fecha-nacimiento" class="form-label">Fecha de nacimiento</label>
                <input type="date" id="fecha-nacimiento" name="txtFechaNacimiento" class="form-input">
            </div>
            <div class="form-group">
                <label for="sexo-dni" class="form-label">Sexo segun tu DNI</label>
                <select id="sexo-dni" class="form-input">
                    <option value="femenino">Femenino</option>
                    <option value="masculino">Masculino</option>
                </select>
            </div>
        </div>

        
        <div class="form-group-pair">
            <div class="form-group">
                <input type="text" id="numero-telefono" name="txtTelefono" placeholder="Numero Telefono" class="form-input">
            </div>
            <div class="form-group">
                <input type="text" id="nombre-nacionalidad" name="txtNacionalidad" placeholder="Nacionalidad" class="form-input">
            </div>
        </div>

        
        <div class="form-group email-group">
            <input type="email" id="email" placeholder="Email" class="form-input">
        </div>

       
        <button type="submit" class="submit-btn">Registrar</button>
    </div>
    <span>Ya estabas registrado? <a href="Login.jsp">Inicia Sesion</a></span>
</body>
</html>
