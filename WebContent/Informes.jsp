<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<style>
 
    
    .form-input {
        width: 200px; /* Ajuste el ancho fijo */
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
</style>
   
</head>
<body>
<%@ include file="BarraMenuAdmin.jsp" %>


    <div class="search-container">
        <input type="text" class="form-input" placeholder="Buscar por Id Provincia">
        <button class="search-button">
            <i class="bi bi-search"></i> Buscar por Id Provincia
        </button>
 


      <div class="table-container">
        <table id ="miTabla">
            <thead>
                <tr>
                    <th>Dni cliente</th>
                    <th>telefono</th>
                    <th>apellido</th>
                    <th>sexo</th>
                    <th>fecha nacimiento</th>
                    <th>nacionalidad</th>
                    <th>correo</th>
                    <th>Nacionalidad</th>
                    <th>nombre</th>
                    <th>cuil</th>
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
                    <td>Dato 7</td>
                    <td>Dato 8</td>
              
                  
                </tr>
               
            </tbody>
        </table>



        <div id="pagination">
            <button onclick="previousPage()">Anterior</button>
            <button onclick="nextPage()">Siguiente</button>
        </div>
    </div>
</div>

</body>
</html>