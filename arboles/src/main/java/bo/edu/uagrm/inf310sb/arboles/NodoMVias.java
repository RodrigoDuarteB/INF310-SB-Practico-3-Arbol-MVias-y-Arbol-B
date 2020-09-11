package bo.edu.uagrm.inf310sb.arboles;

import java.util.LinkedList;
import java.util.List;

public class NodoMVias<K extends Comparable<K>, V> {
	private List<K> listaDeClaves;
	private List<V> listaDeValores;
	private List<NodoMVias<K, V>> listaDeHijos;
	
	public NodoMVias(int orden) {
		listaDeClaves = new LinkedList<>();
		listaDeValores = new LinkedList<>();
		listaDeHijos = new LinkedList<>();
		for (int i = 0; i < orden-1; i++) {
			listaDeClaves.add((K)NodoMVias.datoVacio());
			listaDeValores.add((V)NodoMVias.datoVacio());
			listaDeHijos.add(NodoMVias.nodoVacio());
		}
		listaDeHijos.add(NodoMVias.nodoVacio());
	}
	
	public NodoMVias(int orden, K primerClave, V primerValor) {
		this(orden);
		this.listaDeClaves.set(0, primerClave);
		this.listaDeValores.set(0, primerValor);
	}
	
	public static NodoMVias nodoVacio(){
		return null;
	}
	
	public static Object datoVacio() {
		return null;
	}
	
	public K getClave(int posicion) {
		return this.listaDeClaves.get(posicion);
	}
	
	public V getValor(int posicion) {
		return this.listaDeValores.get(posicion);
	}
	
	public void setClave(int posicion, K clave) {
		this.listaDeClaves.set(posicion, clave);
	}
	
	public void setValor(int posicion, V valor) {
		this.listaDeValores.set(posicion, valor);
	}
	
	public NodoMVias<K, V> getHijo(int posicion){
		return this.listaDeHijos.get(posicion);
	}
	
	public void setHijo(int posicion, NodoMVias<K, V> nodo){
		this.listaDeHijos.set(posicion, nodo);
	}
	
	public static boolean esNodoVacio(NodoMVias nodo) {
		return nodo == NodoMVias.nodoVacio();
	}
	
	public boolean esDatoVacio(int posicion) {
		return this.listaDeClaves.get(posicion) == NodoMVias.datoVacio();
	}
	
	public boolean esHijoVacio(int posicion) {
		return this.listaDeHijos.get(posicion) == NodoMVias.nodoVacio();
	}
	
	public boolean esHoja() {
		for(int i=0; i<this.listaDeHijos.size(); i++) {
			if(!this.esHijoVacio(i)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean estaLleno() {
		for(K clave : this.listaDeClaves) {
			if(clave == NodoMVias.datoVacio()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean estaVacio() {
		for(K clave : this.listaDeClaves) {
			if(clave != NodoMVias.datoVacio()) {
				return false;
			}
		}
		return true;
	}
	
	public int cantidadDeDatosNoVacios() {
		int c=0;
		for(int i=0; i<this.listaDeClaves.size(); i++) {
			if(!this.esDatoVacio(i)) {
				c++;
			}
		}
		return c;
	}
	
	public int cantidadDeHijosVacios() {
		int c=0;
		for(int i=0; i<this.listaDeHijos.size(); i++) {
			if(this.esHijoVacio(i)) {
				c++;
			}
		}
		return c;
	}
	
	public int cantidadDeHijosNoVacios() {
		int c=0;
		for(int i=0; i<this.listaDeHijos.size(); i++) {
			if(!this.esHijoVacio(i)) {
				c++;
			}
		}
		return c;
	}

	public boolean existeClave(K clave) {
		for(int i=0; i<this.cantidadDeDatosNoVacios() && clave.compareTo(this.listaDeClaves.get(i)) >= 0; i++) {
			if(clave.compareTo(this.listaDeClaves.get(i)) == 0) {
				return true;
			}
		}
		return false;
	}

	public void eliminarDato(int posicion) {
		int datosNoVacios=this.cantidadDeDatosNoVacios();
		for(int i=posicion+1; i<datosNoVacios; i++) {
			this.listaDeClaves.set(i-1, this.listaDeClaves.get(i));
			this.listaDeValores.set(i-1, this.listaDeValores.get(i));
		}
		this.listaDeClaves.set(datosNoVacios-1, (K) NodoMVias.datoVacio());
		this.listaDeValores.set(datosNoVacios-1, (V) NodoMVias.datoVacio());
	}

	public boolean hayHijosAdelante(int posicion) {
		posicion++;
		while(posicion<this.cantidadDeDatosNoVacios()) {
			if(this.getHijo(posicion) != NodoMVias.nodoVacio()) {
				return true;
			}else {
				posicion++;
			}
		}
		return false;
	}	
	
}
