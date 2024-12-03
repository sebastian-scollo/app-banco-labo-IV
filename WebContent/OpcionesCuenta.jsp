<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Cuenta" %>    
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
<% if (session.getAttribute("usuarioLogueado") == null){
		
		response.sendRedirect("Login.jsp");
	} 
	

	
	%>
<%@ include file="MenuCliente.jsp" %>

<div class="contenedor">
  <h1>Bienvenido</h1>
  <h2>Estas son sus cuentas registradas por favor debe Seleccionar una</h2>
</div>

<table class="tabla-centro">
  <thead>
    <tr>
      <th>CBU cuenta</th>
      <th>Tipo de Cuenta</th>
      <th>IdCliente</th>
      <th>Fecha de creación</th>
      <th>Saldo</th>
      <th>Acción</th>
    </tr>
  </thead>
  <tbody>
    <% 
   
      ArrayList<Cuenta> listadoCuenta = (ArrayList<Cuenta>) request.getAttribute("listadoCuenta");

    
      if (listadoCuenta != null && !listadoCuenta.isEmpty()) {
          for (Cuenta cuenta : listadoCuenta) {
    %>
          <tr class="fila">
            <td><%= cuenta.getCBU() %></td>
            <td><%= cuenta.getObjidTipoCuenta().getIdTipoCuenta() %></td>
            <td><%= cuenta.getObjCliente().getIdCliente() %></td>
            <td><%= cuenta.getFechaCreacion() %></td>
            <td><%= cuenta.getSaldo() %></td>
            <td>
              <form action="servletCuentaElegida" method="post">
    <input type="hidden" name="cbu" value="<%= cuenta.getCBU() %>">
    <input type="submit" name="btnCuentaElegido" value="Seleccionar" class="boton-enviar">
</form>
            </td>
          </tr>
    <%
          }
      } else {
    %>
          <tr>
            <td colspan="3" style="text-align: center;">No hay cuentas registradas</td>
          </tr>
    <% 
      }
    %>
  </tbody>
</table>

</body>
</html>
