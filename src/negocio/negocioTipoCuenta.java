package negocio;

import java.util.ArrayList;

import entidades.TipoCuenta;

public interface negocioTipoCuenta {
	public ArrayList<TipoCuenta> obtenerTiposCuentas();
	public String obtenerOpcionesDDL();
}
