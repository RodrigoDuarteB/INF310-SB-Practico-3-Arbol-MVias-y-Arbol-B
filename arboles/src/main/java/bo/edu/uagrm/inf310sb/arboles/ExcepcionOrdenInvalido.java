package bo.edu.uagrm.inf310sb.arboles;

public class ExcepcionOrdenInvalido extends Exception{
	
	public ExcepcionOrdenInvalido() {
		super("El orden debe ser mayor o igual a 3");
	}
	
	public ExcepcionOrdenInvalido(String mensaje) {
		super(mensaje);
	}
	
}
