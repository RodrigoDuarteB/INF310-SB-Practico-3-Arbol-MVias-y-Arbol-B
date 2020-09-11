package bo.edu.uagrm.inf310sb.arboles;

import java.util.List;

public interface IArbolBusqueda<K extends Comparable<K>, V> {
	void insertar(K clave, V valor) throws ExcepcionClaveYaExiste; 	//inserta un nuevo nodo en el arbol, si no existe
	V eliminar(K clave) throws ExcepcionClaveNoExiste;	//elimina un nodo del arbol, y lo devuelve
	V buscar(K clave);	//busca un nodo, y lo devuelve
	boolean contiene(K clave);	//verifica si el nodo existe
	int size();	//cantidad de nodos
	int altura();	//altura del arbol
	void vaciar();	//vacia el arbol
	boolean esArbolVacio();	//verifica si el arbol es vacio
	int nivel();	//devuelve el nivel 
	//recorridos
	List<K> recorridoEnInOrden();
	List<K> recorridoEnPreOrden();
	List<K> recorridoEnPostOrden();
	List<K> recorridoPorNiveles();
}
