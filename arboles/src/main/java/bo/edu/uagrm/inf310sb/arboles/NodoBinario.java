package bo.edu.uagrm.inf310sb.arboles;

import com.sun.corba.se.spi.orbutil.fsm.Guard;

public class NodoBinario<K, V> {
	private K clave;
	private V valor;
	private NodoBinario<K, V> hijoIzquierdo;
	private NodoBinario<K, V> hijoDerecho;
	
	public NodoBinario() {
		this.clave = null;
		this.valor = null;
	}

	public NodoBinario(K clave, V valor) {
		this.clave = clave;
		this.valor = valor;
	}

	public K getClave() {
		return clave;
	}

	public void setClave(K clave) {
		this.clave = clave;
	}

	public V getValor() {
		return valor;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

	public NodoBinario<K, V> getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public void setHijoIzquierdo(NodoBinario<K, V> hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	public NodoBinario<K, V> getHijoDerecho() {
		return hijoDerecho;
	}

	public void setHijoDerecho(NodoBinario<K, V> hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}
	
	public boolean esVacioSuHijoIzquierdo() {
		return NodoBinario.esNodoVacio(this.getHijoIzquierdo());
	}
	
	public boolean esVacioSuHijoDerecho() {
		return NodoBinario.esNodoVacio(this.getHijoDerecho());
	}
	
	public boolean esHoja() {
		return this.esVacioSuHijoIzquierdo() && this.esVacioSuHijoDerecho();
	}
	
	public static boolean esNodoVacio(NodoBinario<?, ?> nodo) {
		return nodo == null;
	}
	
	public static NodoBinario<?, ?> nodoVacio(){
		return null;
	}
	
	public boolean esNodoCompleto() {
		return !this.esVacioSuHijoIzquierdo() && !this.esVacioSuHijoDerecho();
	}

	public static boolean esNodoBalanceado(NodoBinario<?, ?> nodoActual) {
		int alturaIzquierda = 0, alturaDerecha = 0;
		NodoBinario<?, ?> guadarNodo = nodoActual;
		while(!esNodoVacio(nodoActual)) {
			if(!nodoActual.esVacioSuHijoIzquierdo()) {
				alturaIzquierda++;
			}
			nodoActual=nodoActual.getHijoIzquierdo();
		}
		while(!esNodoVacio(guadarNodo)) {
			if(!guadarNodo.esVacioSuHijoDerecho()) {
				alturaDerecha++;
			}
			guadarNodo=guadarNodo.getHijoIzquierdo();
		}
		if(alturaIzquierda>alturaDerecha) {
			return (alturaIzquierda-alturaDerecha)<2;
		}else if(alturaIzquierda<alturaDerecha){
			return(alturaDerecha-alturaIzquierda)<2;
		}else {
			return true;
		}
	}
	
	@Override
	public String toString() {
		return (String) clave;
	}
	
}
