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
        .table-container {
            margin-top: 70px; /* Para que el contenido no quede debajo del header */
            padding: 20px;
            flex-grow: 1; /* Para que el contenido ocupe el espacio restante */
        }
        /* Estilo para los campos de entrada */
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

        /* Contenedor de búsqueda */
        .search-container {
            display: flex;
            gap: 5px;
            margin-bottom: 15px;
            align-items: center;
        }

        /* Estilo para el botón verde */
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

        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        #pagination {
            margin-top: 20px;
        }
    </style>
</head>
<body>

    
    
    <div class="table-container">
    <%@ include file="BarraMenuAdmin.jsp" %>
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