document.getElementById("btnSimularPrestamo").addEventListener("click", function () {
    const monto = parseFloat(document.getElementById("monto").value);
    const cuotas = parseInt(document.getElementById("cuotas").value);

    let tna;
    if (cuotas >= 1 && cuotas <= 12) {
        tna = 0.40; // TNA 40%
    } else if (cuotas >= 13 && cuotas <= 24) {
        tna = 0.45; // TNA 45%
    } else if (cuotas >= 25 && cuotas <= 36) {
        tna = 0.50; // TNA 50%
    } else if (cuotas >= 37 && cuotas <= 48) {
        tna = 0.55; // TNA 55%
    } else {
        alert("Plazo no válido");
        return;
    }

    // Cálculo del importe total a pagar (interés simple)
    const importeTotal = monto * (1 + (tna * cuotas / 12));

    // Cálculo del importe por cuota
    const importePorCuota = importeTotal / cuotas;

    // Mostrar resultados en la ventana modal
    document.getElementById("simularMonto").textContent = monto.toFixed(2);
    document.getElementById("simularCuotas").textContent = cuotas;
    document.getElementById("simularInteres").textContent = (tna * 100).toFixed(2);
    document.getElementById("simularTotal").textContent = importeTotal.toFixed(2);
    document.getElementById("simularPorCuota").textContent = importePorCuota.toFixed(2);

    // Mostrar el modal
    const modal = new bootstrap.Modal(document.getElementById("simularPrestamoModal"));
    modal.show();
});

document.getElementById("btnSolicitarPrestamo").addEventListener("click", function () {
    const monto = parseFloat(document.getElementById("monto").value);
    const cuotas = parseInt(document.getElementById("cuotas").value);
    const cuentaSeleccionada = document.getElementById("cuenta").value; // Obtener la cuenta seleccionada
    //const probando = document.getElementById("cuenta").value;
    //console.log("Cuenta seleccionada:", cuentaSeleccionada);
    // Validación si no se ha seleccionado una cuenta
    if (!cuentaSeleccionada) {
        alert("Debe seleccionar una cuenta para el depósito");
        return;
    }

    let tna;
    if (cuotas >= 1 && cuotas <= 12) {
        tna = 0.40; // TNA 40%
    } else if (cuotas >= 13 && cuotas <= 24) {
        tna = 0.45; // TNA 45%
    } else if (cuotas >= 25 && cuotas <= 36) {
        tna = 0.50; // TNA 50%
    } else if (cuotas >= 37 && cuotas <= 48) {
        tna = 0.55; // TNA 55%
    } else {
        alert("Plazo no válido");
        return;
    }

    // Cálculo del importe total a pagar (interés simple)
    const importeTotal = monto * (1 + (tna * cuotas / 12));

    // Cálculo del importe por cuota
    const importePorCuota = importeTotal / cuotas;

    // Mostrar los resultados en el modal
    document.getElementById("confirmarMonto").textContent = monto.toFixed(2);
    document.getElementById("confirmarCuotas").textContent = cuotas;
    document.getElementById("confirmarInteres").textContent = (tna * 100).toFixed(2);
    document.getElementById("confirmarTotal").textContent = importeTotal.toFixed(2);
    document.getElementById("confirmarPorCuota").textContent = importePorCuota.toFixed(2);

    // Mostrar la cuenta seleccionada en el modal
    const cuentaOption = document.querySelector(`#cuenta option[value="${cuentaSeleccionada}"]`);
    const cuentaCBU = cuentaOption ? cuentaOption.textContent : "Cuenta no válida";
    document.getElementById("confirmarCuenta").textContent = cuentaCBU;

    // Mostrar el modal
    const modal = new bootstrap.Modal(document.getElementById("confirmarPrestamoModal"));
    modal.show();

    // Acción del botón Confirmar
    document.getElementById("btnConfirmar").addEventListener("click", function () {
        // Crear un formulario oculto para enviar los datos al servlet
        const form = document.createElement("form");
        form.method = "POST";
        form.action = "ServletSolicitudPrestamo"; // Ruta de tu servlet

        // Crear inputs ocultos con los datos
        const inputs = [
            { name: "monto", value: monto },
            { name: "cuotas", value: cuotas },
            { name: "tna", value: tna },
            { name: "importeTotal", value: importeTotal },
            { name: "importePorCuota", value: importePorCuota },
            { name: "cuenta", value: cuentaSeleccionada },
            { name: "accion", value: "confirmar" }
        ];

        inputs.forEach(inputData => {
            const input = document.createElement("input");
            input.type = "hidden";
            input.name = inputData.name;
            input.value = inputData.value;
            form.appendChild(input);
        });

        // Añadir el formulario al documento y enviarlo
        document.body.appendChild(form);
        form.submit();
    });
});
