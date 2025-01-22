package Evaluacion;

public class NoHayClientesParaAtender extends Exception {

	private static final long serialVersionUID = 1L;

	public NoHayClientesParaAtender() {
		super("No hay Clientes para atender");
	}
	
	public void printStackTrace() {
		System.err.println("No hay Clientes para atender");
	}
}
