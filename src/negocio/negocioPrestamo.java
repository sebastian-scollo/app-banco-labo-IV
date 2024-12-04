package negocio;

import java.util.List;

import entidades.Prestamo;

public interface negocioPrestamo {
	public boolean solicitarPrestamo(Prestamo prestamo);
	public List<Prestamo> obtenerPrestamosPorEstado(String estado);
	public Prestamo obtenerPorId(int IDPrestamo);
	public boolean actualizarEstado(Prestamo prestamo);
}
