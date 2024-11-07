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
