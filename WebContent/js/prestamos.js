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