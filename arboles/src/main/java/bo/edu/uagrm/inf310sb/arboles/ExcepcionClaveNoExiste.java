package bo.edu.uagrm.inf310sb.arboles;

public class ExcepcionClaveNoExiste extends Exception {
	public ExcepcionClaveNoExiste() {
		super("La clave no existe en el árbol");
	}
	
	public ExcepcionClaveNoExiste(String mensaje) {
		super(mensaje);
	}
}
