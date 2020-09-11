package bo.edu.uagrm.inf310sb.arboles;

public class AVL<K extends Comparable<K>, V> extends ArbolBinarioBusqueda<K, V> {
	
	private static final byte DIFERENCIA_MAXIMA = 1;
	
	@Override
	public void insertar(K clave, V valor) throws ExcepcionClaveYaExiste {
		this.raiz = this.insertar(this.raiz, clave, valor);
	}

	private NodoBinario<K, V> insertar(NodoBinario<K, V> nodoActual, K clave, V valor) throws ExcepcionClaveYaExiste {
		if(NodoBinario.esNodoVacio(nodoActual)) {
			NodoBinario<K, V> nuevoNodo = new NodoBinario<>(clave, valor);
			return nuevoNodo;
		}else {
			K claveActual = nodoActual.getClave();
			if(clave.compareTo(claveActual)>0) {
				NodoBinario<K, V> supuestoNuevoHijoDerecho = this.insertar(nodoActual.getHijoDerecho(), clave, valor);
				nodoActual.setHijoDerecho(supuestoNuevoHijoDerecho);
				return this.balancear(nodoActual);
			}
			if(clave.compareTo(claveActual)<0) {
				NodoBinario<K, V> supuestoNuevoHijoIzquierdo = this.insertar(nodoActual.getHijoIzquierdo(), clave, valor);
				nodoActual.setHijoIzquierdo(supuestoNuevoHijoIzquierdo);
				return this.balancear(nodoActual);
			}
			throw new ExcepcionClaveYaExiste();
		}
	}
	
	private NodoBinario<K, V> balancear(NodoBinario<K, V> nodoActual) {
		int alturaRamaIzquierda = this.altura(nodoActual.getHijoIzquierdo());
		int alturaRamaDerecha = this.altura(nodoActual.getHijoDerecho());
		int diferenciaEnAltura = alturaRamaIzquierda-alturaRamaDerecha;
		if(diferenciaEnAltura>this.DIFERENCIA_MAXIMA) { //hay problema en la rama izquierda
			NodoBinario<K, V> hijoIzquierdo = nodoActual.getHijoIzquierdo();
			alturaRamaIzquierda = this.altura(hijoIzquierdo.getHijoIzquierdo());
			alturaRamaDerecha = this.altura(hijoIzquierdo.getHijoDerecho());
			if(alturaRamaDerecha>alturaRamaIzquierda) { // rotacion doble
				return rotacionDobleADerecha(nodoActual);
			}else { //rotacion simple
				return rotacionSimpleADerecha(nodoActual);
			}
		}else if(diferenciaEnAltura<-this.DIFERENCIA_MAXIMA) { //hay problema en la rama derecha
			
		}
		//no hay problemas
		return nodoActual;
	}

	private NodoBinario<K, V> rotacionSimpleADerecha(NodoBinario<K, V> nodoActual) {
		NodoBinario<K, V> nodoARetornar = nodoActual.getHijoIzquierdo();
		nodoActual.setHijoIzquierdo(nodoARetornar.getHijoDerecho());
		nodoARetornar.setHijoDerecho(nodoActual);
		return nodoARetornar;
	}

	private NodoBinario<K, V> rotacionDobleADerecha(NodoBinario<K, V> nodoActual) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
