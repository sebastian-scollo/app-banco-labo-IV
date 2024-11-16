package dao;

import java.util.ArrayList;

import entidades.TipoCuenta;

public interface daoTipoCuenta {
	public ArrayList<TipoCuenta> obtenerTiposCuentas();
	public String obtenerOpcionesDDL();
}
