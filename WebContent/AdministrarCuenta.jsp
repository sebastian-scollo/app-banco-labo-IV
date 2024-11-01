<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Grid</title>
    <link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

</head>
<body>
    
    <div class="table-container">
<%@ include file="MenuCliente.jsp" %>
        <table id ="miTabla">
            <thead>
                <tr>
                    
                    <th>CBU</th>
                    <th>CUIT</th>
                    <th>Codigo TipoCuenta documento</th>
                    <th>IdCliente</th>
                    <th>fecha Creacion</th>
                    <th>saldo</th>
                    <th>activo</th>
                    <th>apciones</th>
                 
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Dato 1</td>
                    <td>Dato 2</td>
                    <td>Dato 3</td>
                    <td>Dato 4</td>
                    <td>Dato 5</td>
                    <td>Dato 6</td>
                    <td>Dato 7</td>
                    <td>Dato 8</td>
              
                    <td>
                       <!-- <button onclick="editarFila(this)">Editar</button>-->
                       <button onclick="window.location.href='index.html'">
                        <i class="bi bi">Editar</i>  
                    </button>
                    <button onclick="window.location.href='index.html'">
                        <i class="bi bi-trash"></i>  
                    </button>
                       
                    </td>
                </tr>
               
            </tbody>
        </table>
        <div id="pagination">
            <button onclick="previousPage()">Anterior</button>
            <button onclick="nextPage()">Siguiente</button>
        </div>
    </div>
   
</body>
</html>