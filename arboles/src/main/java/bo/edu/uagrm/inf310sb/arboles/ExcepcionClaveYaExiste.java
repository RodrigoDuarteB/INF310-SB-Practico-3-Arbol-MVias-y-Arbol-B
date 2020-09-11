package bo.edu.uagrm.inf310sb.arboles;

public class ExcepcionClaveYaExiste extends Exception {
	public ExcepcionClaveYaExiste() {
		super("La clave ya existe en el árbol");
	}
	
	public ExcepcionClaveYaExiste(String mensaje) {
		super(mensaje);
	}
}
