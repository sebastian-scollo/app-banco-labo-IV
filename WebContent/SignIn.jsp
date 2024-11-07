<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.5/font/bootstrap-icons.min.css">
	<link rel="stylesheet" type="text/css" href="css/custom.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<title>Registrarse</title>
</head>
<body>
	<header>
	    <jsp:include page="componentes/navbar-home.jsp"></jsp:include>
	</header>

        <div id="datosPersonales" class="card p-5 mx-auto col-4" >
        <h3 class="card-title text-center mb-4">Datos personales</h3>
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>
                <div class="col-md-6">
                    <label for="apellido" class="form-label">Apellido</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="dni" class="form-label">DNI</label>
                    <input type="text" class="form-control" id="dni" name="dni" required>
                </div>
                <div class="col-md-6">
                    <label for="cuil" class="form-label">CUIL</label>
                    <input type="text" class="form-control" id="cuil" name="cuil" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="genero" class="form-label">Género</label>
                    <select class="form-select" id="genero" name="genero" required>
                        <option selected disabled value="">Seleccione</option>
                        <option value="Masculino">Masculino</option>
                        <option value="Femenino">Femenino</option>
                        <option value="Otro">Otro</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="nacionalidad" class="form-label">Nacionalidad</label>
                    <select class="form-control" name="nacionalidad" id="nacionalidad" required>
                        <option value="">Seleccione</option>
                        <option value="Argentina">Argentina</option>
                        <option value="Argentina">Argentina</option>
	                    <option value="Australia">Australia</option>
	                    <option value="Alemania">Alemania</option>
	                    <option value="Austria">Austria</option>
	                    <option value="Bélgica">Bélgica</option>
	                    <option value="Brasil">Brasil</option>
	                    <option value="Canadá">Canadá</option>
	                    <option value="Chile">Chile</option>
	                    <option value="China">China</option>
	                    <option value="Colombia">Colombia</option>
	                    <option value="Corea del Sur">Corea del Sur</option>
	                    <option value="Dinamarca">Dinamarca</option>
	                    <option value="Egipto">Egipto</option>
	                    <option value="Emiratos Árabes Unidos">Emiratos Árabes Unidos</option>
	                    <option value="España">España</option>
	                    <option value="Estados Unidos">Estados Unidos</option>
	                    <option value="Filipinas">Filipinas</option>
	                    <option value="Finlandia">Finlandia</option>
	                    <option value="Francia">Francia</option>
	                    <option value="Grecia">Grecia</option>
	                    <option value="India">India</option>
	                    <option value="Indonesia">Indonesia</option>
	                    <option value="Irlanda">Irlanda</option>
	                    <option value="Israel">Israel</option>
	                    <option value="Italia">Italia</option>
	                    <option value="Japón">Japón</option>
	                    <option value="Malasia">Malasia</option>
	                    <option value="México">México</option>
	                    <option value="Noruega">Noruega</option>
	                    <option value="Nueva Zelanda">Nueva Zelanda</option>
	                    <option value="Países Bajos">Países Bajos</option>
	                    <option value="Pakistán">Pakistán</option>
	                    <option value="Perú">Perú</option>
	                    <option value="Polonia">Polonia</option>
	                    <option value="Portugal">Portugal</option>
	                    <option value="Reino Unido">Reino Unido</option>
	                    <option value="República Checa">República Checa</option>
	                    <option value="Rusia">Rusia</option>
	                    <option value="Singapur">Singapur</option>
	                    <option value="Sudáfrica">Sudáfrica</option>
	                    <option value="Suecia">Suecia</option>
	                    <option value="Suiza">Suiza</option>
	                    <option value="Tailandia">Tailandia</option>
	                    <option value="Turquía">Turquía</option>
	                    <option value="Ucrania">Ucrania</option>
	                    <option value="Uruguay">Uruguay</option>
	                    <option value="Venezuela">Venezuela</option>
	                    <option value="Vietnam">Vietnam</option>
                    </select>
                </div>
                <div class="row mb-3">
			        <div class="col-md-6">
			            <label for="telefono" class="form-label">Teléfono</label>
			            <input type="text" class="form-control" id="telefono" name="telefono" required>
			        </div>
			        <div class="col-md-6">
			            <label for="correo" class="form-label">Correo Electrónico</label>
			            <input type="email" class="form-control" id="correo" name="correo" required>
			        </div>
  			    </div>
            </div>
            <h3>Dirección</h3>
	        <div class="row mb-3">
	            <div class="col-md-6">
	                <label for="calle" class="form-label">Calle</label>
	                <input type="text" class="form-control" id="calle" name="calle" required>
	            </div>
	            <div class="col-md-3">
	                <label for="numero" class="form-label">Número</label>
	                <input type="text" class="form-control" id="numero" name="numero" required>
	            </div>
	        </div>
	
	        <div class="row mb-3">
	            <div class="col-md-3">
	                <label for="piso" class="form-label">Piso</label>
	                <input type="text" class="form-control" id="piso" name="piso">
	            </div>
	            <div class="col-md-3">
	                <label for="departamento" class="form-label">Departamento</label>
	                <input type="text" class="form-control" id="departamento" name="departamento">
	            </div>
	        </div>
	
	        <div class="row mb-3">
	            <div class="col-md-6">
	                <label for="localidad" class="form-label">Localidad</label>
	                <input type="text" class="form-control" id="localidad" name="localidad" required>
	            </div>
	            <div class="col-md-6">
	                <label for="provincia" class="form-label">Provincia</label>
	                <input type="text" class="form-control" id="provincia" name="provincia" required>
	            </div>
	        </div>

            <button type="button" class="btn btn-primary" onclick="mostrarSeccionUsuario()">Continuar</button>
        </div>
		
       <div id="crearUsuario" style="display: none;" class="card p-4 mx-auto col-4" style="max-width: 300px; width: 100%; border-radius: 10px;">
    <h3 class="card-title text-center mb-4">Crear Usuario</h3>
    <div class="mb-3">
        <label for="usuario" class="form-label">Usuario</label>
        <input type="text" class="form-control" id="usuario" name="usuario" required>
    </div>
    <div class="mb-3">
        <label for="contrasena" class="form-label">Contraseña</label>
        <input type="password" class="form-control" id="contrasena" name="contrasena" required>
    </div>
    <div class="mb-3">
        <label for="confirmarContrasena" class="form-label">Confirmar Contraseña</label>
        <input type="password" class="form-control" id="confirmarContrasena" name="confirmarContrasena" required>
    </div>
    <button type="submit" class="btn btn-primary w-100">Registrarse</button>
	</div>

	<jsp:include page="componentes/footer.jsp" />

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>