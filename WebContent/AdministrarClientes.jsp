<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>AdminClientes</title>
    <link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
            display: flex;
        }
        
        
        .user-info {
            font-size: 16px;
        }
        .table-container {
            margin-top: 70px;
            padding: 20px;
            flex-grow: 1;
        }
        .form-input {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: none;
            background-color: transparent;
            outline: none;
            box-sizing: border-box;
            color: #666;
        }
        .search-container {
            display: flex;
            gap: 5px;
            margin-bottom: 15px;
            align-items: center;
        }
        .search-button {
            background-color: #28a745;
            color: white;
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .search-button i {
            margin-right: 3px;
        }
        .search-button:hover {
            background-color: #218838;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        #pagination {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="table-container">
        <%@ include file="BarraMenuAdmin.jsp" %>
        
        <!-- Botón "Mostrar todo" -->
        <form action="MostrarTodo" method="post">
            <input type="submit" value="Mostrar todo" class="search-button">
        </form>
        
        <!-- Campo de búsqueda por DNI -->
        <div class="search-container">
            <input type="text" class="form-input" placeholder="Buscar por DNI">
            <button class="search-button">
                <i class="bi bi-search"></i> Buscar DNI
            </button>
        </div>
        
        <!-- Campo de búsqueda por Nombre -->
        <div class="search-container">
            <input type="text" class="form-input" placeholder="Buscar por Nombre">
            <button class="search-button">
                <i class="bi bi-search"></i> Buscar Nombre
            </button>
        </div>

        <table id="miTabla">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>CUIT</th>
                    <th>Número documento</th>
                    <th>Fecha nacimiento</th>
                    <th>Sexo</th>
                    <th>Número teléfono</th>
                    <th>Nacionalidad</th>
                    <th>Email</th>
                    <th>Acciones</th>
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
                    <td>Dato 9</td>
                    <td>
                        <button onclick="window.location.href='ClienteAgregar.jsp'">
                            <i class="bi bi-pencil"></i> Editar
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
