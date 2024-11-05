<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Movimientos</title>
    <link rel="stylesheet" href="EstiloGrid.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
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
        .table-container {
            margin-top: 70px; /* Para que el contenido no quede debajo del header */
            padding: 20px;
            flex-grow: 1; /* Para que el contenido ocupe el espacio restante */
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
    <div class="header">
        <img src="SLOGAN.png" alt="Logo">
        <h1>HISTORIAL DE MOVIMIENTOS</h1>
        <div class="user-info">Usuario: <strong>acá va el usuario logueado</strong></div>
    </div>

    <div class="table-container">
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
