<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Movimiento" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Informe Tipo Movimiento</title>
    <link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <style>
        .form-input {
            width: 200px;
            padding: 8px;
            font-size: 14px;
            border: 1px solid #666;
            border-radius: 4px;
            color: #666;
        }
        
        .search-button {
            padding: 8px 12px;
            background-color: #1464a5;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        
        .search-button:hover {
            background-color: #0b4d94;
        }
        
        .table-container {
            margin-top: 20px;
        }
        
        #miTabla {
            width: 100%;
            border-collapse: collapse;
        }
        
        #miTabla th, #miTabla td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }
        
        #miTabla th {
            background-color: #1464a5;
            color: white;
        }
    </style>
</head>
<body>
<% if (session.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect("Login.jsp");
    } else if ((int) session.getAttribute("tipoUsuario") != 1) {
        response.sendRedirect("MenuCliente.jsp");
    }
%>
<%@ include file="BarraMenuAdmin.jsp" %>

<div class="search-container">
    <h1>Informe Tipo Movimiento</h1>
    <form action="servletReporteTotalYporcentaje" method="post">
        <input type="text" name="txtIdTipoMovimiento" class="form-input" placeholder="Ingrese Id Tipo Movimiento">
        <button type="submit" name="btnBuscarMovimiento" class="search-button">
            <i class="bi bi-search"></i> Buscar
        </button>
    </form>

    <div class="table-container">
        <table id="miTabla" border="1">
            <thead>
                <tr>
                    <th>Detalle</th>
                    <th>Importe Total</th>
                    <th>Porcentaje</th>
                </tr>
            </thead>
            <tbody>
                <% 
              
                ArrayList<Movimiento> listaMovimientos = (ArrayList<Movimiento>) request.getAttribute("listaMovimientos");
                ArrayList<Double> listaPorcentaje = (ArrayList<Double>) request.getAttribute("listaPorcentaje");

                if (listaMovimientos != null && !listaMovimientos.isEmpty()) {
                    double porcentaje = listaPorcentaje.isEmpty() ? 0 : listaPorcentaje.get(0);  // Obtener el porcentaje
                    for (Movimiento movimiento : listaMovimientos) {
                %>
                    <tr>
                        <td><%= movimiento.getTipomovimiento().getDescripcion() %></td>
                        <td><%= String.format("%.2f", movimiento.getImporte()) %></td>
                        <td><%= String.format("%.2f", porcentaje) %>%</td>  <!-- Mostrar porcentaje -->
                    </tr>
                <% 
                    }
                } else {
                %>
                    <tr>
                        <td colspan="3">No se encontraron resultados.</td>
                    </tr>
                <% 
                }
                %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
