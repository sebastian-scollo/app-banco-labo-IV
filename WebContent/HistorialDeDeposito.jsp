<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Historial de Transacciones</title>
    <link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <style>
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
    </style>
</head>
<body>
    <div class="table-container">
        <%@ include file="MenuCliente.jsp" %>
        
        <!-- Campo de búsqueda por CBU -->
        <div class="search-container">
            <input type="text" class="form-input" placeholder="Buscar por CBU">
            <button class="search-button">
                <i class="bi bi-search"></i> Buscar CBU
            </button>
        </div>
        
        <!-- Campo de búsqueda por Fecha -->
        <div class="search-container">
            <input type="date" class="form-input" placeholder="Buscar por Fecha">
            <button class="search-button">
                <i class="bi bi-search"></i> Buscar Fecha
            </button>
        </div>

        <!-- Tabla con las columnas modificadas sin botones de acciones -->
        <table id="miTabla">
            <thead>
                <tr>
                    <th>CBU Cuenta Destinataria</th>
                    <th>Importe</th>
                    <th>Fecha</th>
                    <th>Tipo de Movimiento</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>nulo</td>
                    <td>nulo</td>
                    <td>nulo</td>
                    <td>nulo</td>
                </tr>
            </tbody>
        </table>

        <!-- Paginación -->
        <div id="pagination">
            <button onclick="previousPage()">Anterior</button>
            <button onclick="nextPage()">Siguiente</button>
        </div>
    </div>
</body>
</html>
