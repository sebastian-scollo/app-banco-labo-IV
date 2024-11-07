<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registro alta Cliente</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .form-container {
            max-width: 700px;
            width: 100%;
            background-color: #ffffff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 100px; /* Ajustar si es necesario */
        }

        .header {
            background-color: #1464a5;
            color: white;
            display: flex;
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
            flex-grow: 1;
            text-align: center;
            font-size: 24px;
        }

        .user-info {
            font-size: 16px;
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
            padding-right: 20px;
        }

        .form-group.email-group {
            margin-bottom: 20px;
        }

        .footer {
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <%@ include file="BarraMenuAdmin.jsp" %>

    <div class="form-container">
        <p>Complete los siguientes campos</p>
        <div class="form-group-pair">
            <div class="form-group">
                <input type="text" id="nombres" name="txtNombre" placeholder="Nombre" class="form-input">
            </div>
            <div class="form-group">
                <input type="text" id="apellidos" name="txtApellido" placeholder="Apellido" class="form-input">
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
        <div class="footer">
            <span>¿Ya estás registrado? <a href="Login.jsp">Inicia Sesión</a></span>
        </div>
    </div>
</body>
</html>