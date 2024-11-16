    function mostrarSeccionUsuario() {
        const datosPersonales = document.getElementById('datosPersonales');
        const crearUsuario = document.getElementById('crearUsuario');
        
        const formElements = datosPersonales.querySelectorAll('input, select');
        let formValido = true;

        formElements.forEach(function(element) {
            if (!element.checkValidity()) {
                formValido = false;
            }
        });

        if (formValido) {
            datosPersonales.style.display = 'none';
            crearUsuario.style.display = 'flex';
        } else {
            document.getElementById("registroForm").reportValidity();
        }
    }
    document.getElementById('dni').addEventListener('input', function(e) {
        e.target.value = e.target.value.replace(/[^0-9]/g, ''); // Elimina cualquier carácter no numérico
    });
    document.getElementById('fechaNacimiento').addEventListener('change', function () {
        const fechaInput = new Date(this.value);
        if (!esMayorDeEdad(fechaInput)) {
            alert('Debes tener al menos 18 años para registrarte.');
            this.value = ''; // Limpia el campo si la fecha es inválida
            this.focus();
        }
    });

    function esMayorDeEdad(fechaNacimiento) {
        const hoy = new Date();
        const edad = hoy.getFullYear() - fechaNacimiento.getFullYear();
        const mes = hoy.getMonth() - fechaNacimiento.getMonth();
        const dia = hoy.getDate() - fechaNacimiento.getDate();
        
        // Verifica si el mes o día actual está antes del cumpleaños
        if (mes < 0 || (mes === 0 && dia < 0)) {
            return edad - 1 >= 18;
        }
        return edad >= 18;
    }
    // Validación de coincidencia entre contraseñas
    document.querySelector("form").addEventListener("submit", function (event) {
        const contrasena = document.getElementById("contrasena").value;
        const confirmarContrasena = document.getElementById("confirmarContrasena").value;

        if (contrasena !== confirmarContrasena) {
            event.preventDefault(); // Evita el envío del formulario
            alert("Las contraseñas no coinciden.");
        }
    });
 //// Función para cargar las provincias
    function cargarProvincias() {
        fetch('/app-banco-labo-IV/ObtenerProvinciasServlet')  // Llamada al servlet de provincias
            .then(response => {
                console.log("Respuesta del servidor:", response);  // Verifica el contenido de la respuesta
                if (!response.ok) {
                    throw new Error('Error en la solicitud: ' + response.status);
                }
                return response.text();  // Obtén la respuesta como texto
            })
            .then(data => {
                try {
                    const provincias = JSON.parse(data);  // Intenta convertir el texto a JSON
                    let provinciaSelect = document.getElementById('provincia');
                    provinciaSelect.innerHTML = '<option value="">Seleccione una provincia</option>';  // Limpiar opciones previas

                    provincias.forEach(provincia => {
                        let option = document.createElement('option');
                        option.value = provincia.idProvincia;
                        option.textContent = provincia.nombre;
                        provinciaSelect.appendChild(option);
                    });
                } catch (error) {
                    console.error('Error al convertir la respuesta a JSON:', error);
                }
            })
            .catch(error => console.error('Error al cargar provincias:', error));  // Manejo de errores
    }


    // Función para cargar las localidades según la provincia seleccionada
    function cargarLocalidades() {
        let provinciaId = document.getElementById('provincia').value;
        if (provinciaId) {
            fetch('/app-banco-labo-IV/ObtenerLocalidadesServlet?provinciaID=' + provinciaId)  // Llamada al servlet de localidades
                .then(response => response.json())
                .then(localidades => {
                    let localidadSelect = document.getElementById('localidad');
                    localidadSelect.innerHTML = '<option value="">Seleccione una localidad</option>';  // Limpiar opciones previas
                    localidades.forEach(localidad => {
                        let option = document.createElement('option');
                        option.value = localidad.idLocalidad;
                        option.textContent = localidad.nombre;
                        localidadSelect.appendChild(option);
                    });
                })
                .catch(error => console.error('Error al cargar localidades:', error));
        } else {
            document.getElementById('localidad').innerHTML = '<option value="">Seleccione una localidad</option>';  // Limpiar si no hay provincia seleccionada
        }
    }

    // Llamar a cargarProvincias al cargar la página
    document.addEventListener('DOMContentLoaded', function() {
        cargarProvincias();
    });

    // Escuchar cambios en la provincia para cargar las localidades
    document.getElementById('provincia').addEventListener('change', cargarLocalidades);

