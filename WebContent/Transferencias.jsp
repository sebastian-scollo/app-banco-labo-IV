<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="entidades.Cuenta" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transferencias</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column; /* Para evitar solapamiento */
        }
        .header {
            background-color: #1464a5;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            width: 100%; /* Asegura que el header ocupe todo el ancho */
            position: fixed; /* Mantener el encabezado fijo en la parte superior */
            top: 0;
            left: 0;
            z-index: 1000; /* Para que esté sobre otros elementos */
        }
        .header img {
            height: 60px; /* Ajusta el tamaño según sea necesario */
        }
        .header h1 {
            margin: 0;
            font-size: 24px;
        }
        .user-info {
            font-size: 16px;
        }
        .form-container {
            max-width: 400px;
            margin: 100px auto 20px; /* Ajusta el margen superior para evitar solapamiento */
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
            position: relative;
        }
        .form-label {
            font-size: 12px;
            color: #666;
            margin-bottom: 5px;
            display: block;
        }
        .form-input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            outline: none;
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
            margin-top: 10px;
        }
        .submit-btn:hover {
            background-color: #246da8;
        }
    </style>
</head>
<%
    Cuenta cuentaElegida = (Cuenta) session.getAttribute("cuentaElegida");
    if (cuentaElegida == null) {
    	System.out.println("Entramos la if null");
      
        response.sendRedirect("servletOpcionCuenta?Param=1");
        return;
    }
%>
<script>
    function confirmarEliminacion() {
        return confirm("¿Estimado seguro de realizar la siguiente transaccion?");
    }
</script>
<body>
<% if (session.getAttribute("usuarioLogueado") == null){
		
		response.sendRedirect("Login.jsp");
	} 
	
	
	%>
    <%@ include file="MenuCliente.jsp" %>

    <div class="form-container">
        <form action="servletMovimientoTransferencia" method="post" onsubmit="return confirmarEliminacion();">
          <div class="form-group">
    <label for="cbuOrigen" class="form-label">CBU de tu Cuenta</label>
    <input type="text" id="cbuOrigen" name="txtCbuEmisor" class="form-input" 
           value="<%= ((Cuenta) session.getAttribute("cuentaElegida")).getCBU() %>" 
           readonly>
</div>
          
          <!--   <div class="form-group">
                <label for="cbuOrigen" class="form-label">CBU de tu Cuenta</label>
                <input type="text" id="cbuOrigen" name="txtCbuEmisor" class="form-input" required>
            </div>  -->

            <div class="form-group">
                <label for="cbuDestino" class="form-label">CBU de Cuenta a transferir</label>
                <input type="text" id="cbuDestino" name="txtCbuReceptor" class="form-input" required>
            </div>

            <div class="form-group">
                <label for="monto" class="form-label">Monto</label>
                <input type="text" id="monto" name="txtMonto" class="form-input" required>
            </div>

            <div class="form-group">
                <label for="descripcion" class="form-label">Deje alguna descripción</label>
                <input type="text" id="descripcion" name="txtDescripcion" class="form-input" required>
            </div>

            <input type="submit" class="submit-btn" value="Aceptar">
        </form>

        <% 
            String mensaje = (String) request.getAttribute("mensaje");
            if (mensaje != null) {
        %>
            <div class="alert">
                <p><%= mensaje %></p>
            </div>
        <% } %>
    </div>

    <script>
     
        function confirmarEliminacion() {
            var cbuEmisor = document.getElementById('cbuOrigen').value;
            var cbuReceptor = document.getElementById('cbuDestino').value;
            var monto = document.getElementById('monto').value;
            var regexCbu = /^\d{22}$/; 
            var regexMonto = /^(?!0(\.0+)?$)(\d+(\.\d+)?|\.\d+)$/;

            if (!regexCbu.test(cbuEmisor)) {
                alert('El CBU de la cuenta a transferir debe tener 22 digitos y solo nuemero.');
                return false;
            }

          
            if (!regexCbu.test(cbuReceptor)) {
                alert('El CBU de la cuenta a transferir debe tener 22 digitos y solo nuemero.');
                return false;
            }

          
            if (!regexMonto.test(monto)) {
                alert('Solo se admiten montos de dinero positivos estimado.');
                return false;
            }

            return true;
        }
    </script>
</body>

</html>