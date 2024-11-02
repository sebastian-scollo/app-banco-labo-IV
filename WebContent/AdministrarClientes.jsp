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
                    <th>Numero documento</th>
                    <th>Fecha nacimiento</th>
                    <th>Sexo</th>
                    <th>Numero telefono</th>
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
                            <i class="bi bi-pencil">Editar</i>
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
