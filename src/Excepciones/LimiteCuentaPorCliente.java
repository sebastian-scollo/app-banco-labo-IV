package Excepciones;

public class LimiteCuentaPorCliente extends Exception {
 /**
	 * 
	 */
	private static final long serialVersionUID = 3684316307727001183L;

public LimiteCuentaPorCliente(String mensaje) {
	 super(mensaje);
 }
}
