<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminación Cuenta</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f8e6e6;
    color: #333;
  }
  h1 {
    color: #b30000;
    text-align: center;
    margin-top: 40px;
  }
  form {
    background-color: #fff;
    padding: 10px;
    border-radius: 4px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    width: 100%;
    margin: auto;
    margin-top: 20px;
  }
  label {
    display: block;
    margin-bottom: 8px;
    color: #b30000;
    font-weight: bold;
  }
  input[type="text"] {
    width: calc(100% - 20px);
    padding: 10px;
    margin-bottom: 16px;
    border: 1px solid #b30000;
    border-radius: 4px;
  }
  input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #b30000;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
  }
  input[type="submit"]:hover {
    background-color: #8c0000;
  }
  .navbar {
    padding-top: 5px;
    padding-bottom: 5px;
  }
</style>
<script>
    function confirmarEliminacion() {
        return confirm("¿Está seguro de que desea eliminar esta cuenta?");
    }
</script>
</head>
<body>
<% if (session.getAttribute("usuarioLogueado") == null){
		
		response.sendRedirect("Login.jsp");
	} 
	
else if ((int)session.getAttribute("tipoUsuario") != 1) {
	response.sendRedirect("MenuCliente.jsp");
}%>
    <%@ include file="BarraMenuAdmin.jsp" %>
    <h1>Eliminar Cuenta</h1>

    <form action="servletEliminarCuenta" method="post" onsubmit="return confirmarEliminacion();">
        <label for="idCuenta">Ingresar ID Cuenta:</label>
        <input type="text" id="idCuenta" name="idCuenta" placeholder="Ingrese el ID de la Cuenta" required>
        <input type="submit" value="Aceptar">
    </form>
</body>
</html>
