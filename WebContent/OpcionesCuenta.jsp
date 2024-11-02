<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elegir Cuenta</title>
<style>
  body {
    font-family: Arial, sans-serif;
    color: #333;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 100%;
    background-color: #f7f3f3;
  }

  .contenedor {
    padding: 20px;
    max-width: 600px;
    width: 100%;
    text-align: center;
  }

  .contenedor h1, .contenedor h2 {
    color: #800020; /* Color bordó */
    font-weight: bold;
    text-align: center;
    margin-top: 20px;
  }

  .contenedor p {
    color: #555;
    margin: 10px 0;
    font-size: 1.5rem;
  }

  .tabla-centro {
    border-collapse: collapse;
    width: 30%;
    margin-top: 20px;
  }

  .tabla-centro th, .tabla-centro td {
    padding: 8px;
    text-align: center;
    border-bottom: 1px solid #ddd;
  }

  .boton-enviar {
    width: 100%;
    padding: 10px;
    background-color: #800020; /* Color bordó */
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
  }

  .boton-enviar:hover {
    background-color: #660017; /* Color bordó más oscuro */
  }

  .fila:hover {
    background-color: #f4e4e6;
  }
</style>
</head>
<body>
<%@ include file="MenuCliente.jsp" %>

<div class="contenedor">
  <h1>Bienvenido</h1>
  <h2>Tiene para elegir una cuenta</h2>
</div>

<table class="tabla-centro">
  <tr>
    <th>CBU cuenta</th>
    <th>Tipo de Cuenta</th>
    <th>IdCliente</th>
      <th>Fecha de creacion</th>
    <th>Saldo</th>
    <th></th>
  </tr>
  <tr class="fila">
    <td>NULL</td>
    <td>NULL</td>
    <td>NULL</td>
    <td>NULL</td>
    <td><input type="submit" name="btnCuentaElegido" value="Seleccionar" class="boton-enviar"></td>
  </tr>
</table>

</body>
</html>
