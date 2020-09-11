package bo.edu.uagrm.inf310sb.UI;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import bo.edu.uagrm.inf310sb.arboles.ArbolBinarioBusqueda;
import bo.edu.uagrm.inf310sb.arboles.ArbolMViasBusqueda;
import bo.edu.uagrm.inf310sb.arboles.ExcepcionClaveNoExiste;
import bo.edu.uagrm.inf310sb.arboles.ExcepcionClaveYaExiste;
import bo.edu.uagrm.inf310sb.arboles.ExcepcionOrdenInvalido;
import bo.edu.uagrm.inf310sb.arboles.IArbolBusqueda;
import bo.edu.uagrm.inf310sb.arboles.NodoBinario;
import bo.edu.uagrm.inf310sb.arboles.NodoMVias;

public class TestArbol {
	
	public static void main(String[] args) throws ExcepcionClaveYaExiste, ExcepcionOrdenInvalido, ExcepcionClaveNoExiste{
		IArbolBusqueda<Integer, String> arbol1 = new ArbolMViasBusqueda<>(4);
		
		//PRACTICO 3
		//1. Implemente el método insertar de un árbol m-vias de búsqueda
		try {
			arbol1.insertar(50, "Cincuenta");
			arbol1.insertar(45, "Cuarenta y Cinco");
			arbol1.insertar(47, "Cuarenta y Siete");
			arbol1.insertar(62, "Sesenta y Dos");
			arbol1.insertar(53, "Cincuenta y Tres");
			arbol1.insertar(40, "Cuarenta");
			arbol1.insertar(67, "Sesenta y Siete");
			arbol1.insertar(46, "Cuarenta y Seis");
			arbol1.insertar(52, "Cincuenta y Dos");
			arbol1.insertar(51, "Cincuenta y Uno");
			arbol1.insertar(48, "Cuarenta y Ocho");
		} catch (ExcepcionClaveYaExiste e) {
			System.out.println(e);
		}

		System.out.println();
		
		//2. Implemente el método eliminar de un árbol m-vias de búsqueda
		try {
			System.out.println("2. Eliminar: "+((ArbolMViasBusqueda)arbol1).eliminar(53));
		}catch(ExcepcionClaveNoExiste e) {
			System.out.println(e);
		}
		
		//6. Implemente un método recursivo que retorne la cantidad nodos con datos vacíos en un árbol m-vias de búsqueda
		System.out.println("6. Cantidad de nodos con datos vacios: "+((ArbolMViasBusqueda)arbol1).nodosConDatosVacios());
		
		//9. Implemente un método que retorne verdadero si solo hay hojas en el último nivel de un árbol m-vias de búsqueda. 
		//   Falso en caso contrario.
		System.out.println("9. Solo hay hojas en el ultima nivel: "+((ArbolMViasBusqueda)arbol1).soloHojasEnUltimoNivel());
		
		//10. Implemente un método que retorne verdadero si un árbol m-vias esta balanceado según las reglas de un árbol B. Falso en caso contrario.
		System.out.println("10. Si un árbol m-vias esta balanceado según las reglas de un árbol B: "+((ArbolMViasBusqueda)arbol1).estaBalanceado());
		
		//12. Para un árbol m-vias implemente un método que retorne la cantidad de nodos que tienen todos sus hijos distintos de vacío 
		//      luego del nivel N (La excepción a la regla son las hojas).
		System.out.println("12. Cantidad de nodos con todos los hijos luego del nivel: "+((ArbolMViasBusqueda)arbol1).nodosConHijosLlenosLuegoDelNivel(-1));

	}

}
