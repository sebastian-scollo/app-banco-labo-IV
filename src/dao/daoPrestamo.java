package dao;

import java.util.List;

import entidades.Prestamo;

public interface daoPrestamo {
	public boolean solicitarPrestamo(Prestamo prestamo);
	public List<Prestamo> obtenerPorEstado(String estado);
	public Prestamo obtenerPorId(int IDPrestamo);
	public boolean actualizarEstado(Prestamo prestamo);
}
