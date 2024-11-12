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
    
 //// Función para cargar las provincias
    function cargarProvincias() {
        fetch('ObtenerProvinciasServlet')  // Llamada al servlet de provincias
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
            fetch('ObtenerLocalidadesServlet?provinciaID=' + provinciaId)  // Llamada al servlet de localidades
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

