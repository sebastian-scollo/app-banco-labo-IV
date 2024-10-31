<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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

 <div class="form-container">
        <div class="header">
            <h1>Login</h1>
            <p>Ingrese su usario y contraseña.</p>
        </div>
        
        <div class="form-group-pair">
            <div class="form-group">
                <input type="text" id="usuario" name="txtUsuario" placeholder="Usuario" class="form-input">
            </div>
            <div class="form-group">
                <input type="password" id="contraseña" txt="txtContraseña" placeholder="Contraseña" class="form-input">
            </div>
        </div>
        
        <button type="submit" class="submit-btn">Ingresar</button>
 </div>

</body>
</html>