package mx.unam.ciencias.edd;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>Clase genérica para listas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de
 * la lista, eliminar elementos de la lista, comprobar si un
 * elemento está o no en la lista, y otras operaciones básicas.</p>
 *
 * <p>Las instancias de la clase Lista implementan la interfaz
 * {@link Iterator}, por lo que el recorrerlas es muy sencillo:</p>
 *
<pre>
    for (String s : l)
        System.out.println(s);
</pre>
 *
 * <p>Además, se le puede pedir a una lista una instancia de {@link
 * IteradorLista} para recorrerla en ambas direcciones.</p>
 */
public class Lista<T> implements Iterable<T> {

    /* Clase Nodo privada para uso interno de la clase Lista. */
    private class Nodo<T> {
        public T elemento;
        public Nodo<T> anterior;
        public Nodo<T> siguiente;

        public Nodo(T elemento) {
            this.elemento = elemento;
        }
    }

    /* Clase Iterador privada para iteradores. */
    private class Iterador<T> implements IteradorLista<T> {

        /* La clase utiliza internamente un nodo como iterador. */
        private Lista<T>.Nodo<T> iterador;
        /* La lista a iterar. */
        private Lista<T> lista;
        /* Estamos o no al inicio. */
        private boolean ultimo;

        /* El constructor recibe un nodo para inicializar el
         * iterador. Generalmente será la cabeza de la lista. */
        public Iterador(Lista<T> lista) {
	    this.lista=lista;
	    this.iterador=lista.cabeza;
	    ultimo=false;
        }

        /* Existe un siguiente elemento, si el iterador no es
         * nulo. */
        public boolean hasNext() {
	    return  (iterador != null);
        }

        /* Regresa el elemento del iterador, a menos que sea nulo,
         * en cuyo caso lanza la excepción
         * NoSuchElementException. */
        public T next() {
	    if(iterador==null)
		throw new NoSuchElementException("No hay elemento");
	    T res=iterador.elemento;
	    iterador=iterador.siguiente;
	    if(iterador==null)
		ultimo=true;
	    return res;
        }

        /* Existe un elemento anterior, si el iterador no es
         * nulo. */
        public boolean hasPrevious() {
	    if(iterador!=null && iterador.anterior!=null)
		return true;
	    if(lista.rabo==null)
		return false;
	    return ultimo;
	}

        /* Regresa el elemento del iterador. */
        public T previous() {
	    boolean ult=ultimo;//checar que la variable ultimo sea verdadero
	    ultimo=false;
	    if(iterador != null && iterador.anterior != null){
		iterador=iterador.anterior;
		return iterador.elemento;//
	    }
	    if(lista.rabo != null && ult){
		iterador=lista.rabo;
		return iterador.elemento;			
	    }else
		throw new NoSuchElementException("No hay elemento");
        }

        /* No implementamos el método remove(); sencillamente
         * lanzamos la excepción UnsupportedOperationException. */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void start() {
	    iterador=lista.cabeza;
	    ultimo=false;
        }

        public void end() {
	    iterador=null;		
	    ultimo=true;
        }
    }

    /* Primer elemento de la lista. */
    private Nodo<T> cabeza;
    /* Último elemento de la lista. */
    private Nodo<T> rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
     * Regresa la longitud de la lista.
     * @return la longitud de la lista, el número de elementos que
     * contiene.
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no
     * tiene elementos, el elemento a agregar será el primero y
     * último.
     * @param elemento el elemento a agregar.
     */
    public void agregaFinal(T elemento) {
	if(longitud == 0){
	    cabeza = rabo = new Nodo<T>(elemento);	    
	}else{
	    Nodo<T> f=new Nodo<T>(elemento);
	    rabo.siguiente=f;
	    f.anterior=rabo;
	    rabo=f;	
	    }
	longitud++;
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no
     * tiene elementos, el elemento a agregar será el primero y
     * último.
     * @param elemento el elemento a agregar.
     */
    public void agregaInicio(T elemento) {
	if(longitud == 0){
	    cabeza = rabo = new Nodo<T>(elemento);
	}else{
	    Nodo<T>i=new Nodo<T>(elemento);
	    cabeza.anterior=i;
	    i.siguiente=cabeza;
	    cabeza=i;
	}
	longitud++;
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está
     * contenido en la lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */
    public void elimina(T elemento) {
	Nodo<T>n= buscaNodo(cabeza,elemento);
	if(n==null)
	    return;
	if(cabeza == rabo){
	    cabeza=rabo=null;
	}else if(n == cabeza){
	    cabeza = cabeza.siguiente;
	    cabeza.anterior = null;
	}else if(n == rabo){
	    rabo=rabo.anterior;
	    rabo.siguiente=null;
	}else{
	    n.anterior.siguiente=n.siguiente;
	    n.siguiente.anterior=n.anterior;
	}
	longitud--;
    } 

    private Nodo<T> buscaNodo(Nodo<T> nodo, T elemento){
	if(nodo == null)
	    return null;
	if(elemento.equals(nodo.elemento))
	    return nodo;
	return buscaNodo(nodo.siguiente,elemento);
    }
    
    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaPrimero() {
       if(longitud <= 0)
	    throw new NoSuchElementException("Lista vacia");
	Nodo<T> n=cabeza;
	if(longitud > 0)
	    longitud--;
	if(longitud==0)
	    return n.elemento;
        cabeza=cabeza.siguiente;
	return n.elemento;
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaUltimo() {
	if(longitud <= 0 )
	    throw new NoSuchElementException("Lista vacia");
	Nodo<T>t1=rabo;
	if(longitud > 0)
	    longitud--;
	if(longitud==0)
	    return t1.elemento;
	rabo=rabo.anterior;
	return t1.elemento;
    }
        
    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la
     * lista.
     * @return <tt>true</tt> si <tt>elemento</tt> está en la lista,
     *         <tt>false</tt> en otro caso.
     */
    public boolean contiene(T elemento) {
        for(int i=0; i < longitud;i++)
	    if(get(i).equals(elemento))
		return true;
	return false;
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar
     *         el método.
     */
    public Lista<T> reversa() {
	Lista<T> lis = new Lista<T>();
	T elem=null;
	for(int i=0;i < longitud ;i++){
	    elem=get(i);
	    lis.agregaInicio(elem);
	}
	return lis;
	// Aquí va su código.
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos
     * elementos que la lista que manda llamar el método, en el
     * mismo orden.
     * @return una copiad de la lista.
     */
    public Lista<T> copia() {
	Lista<T> lis = new Lista<T>();
	int k=longitud-1;
	while(k >= 0){
	    lis.agregaInicio(get(k));
	    k--;
	}
	return lis;
    }

    /**
     * Limpia la lista de elementos. El llamar este método es
     * equivalente a eliminar todos los elementos de la lista.
     */
    public void limpia() {
        cabeza=rabo=null;
	longitud=0;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getPrimero() {
	if(longitud <= 0 )
	    throw new NoSuchElementException("Lista vacia");
	return get(0);
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el último elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getUltimo() {
	if(longitud <= 0 )
	    throw new NoSuchElementException("Lista vacia");
	else
	    return get(longitud-1);
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista, si
     *         <em>i</em> es mayor o igual que cero y menor que el
     *         número de elementos en la lista.
     * @throws ExcepcionIndiceInvalido si el índice recibido es
     *         menor que cero, o mayor que el número de elementos en
     *         la lista menos uno.
     */
    public T get(int i) {
        if(i < 0 || i >= longitud)
	    throw new ExcepcionIndiceInvalido("El indice indicado esta fuera de rango ");
	int j=0;
	Nodo<T>n=cabeza;
	while(j++ < i)
	    n=n.siguiente;
	return n.elemento;
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si
     *         el elemento no está contenido en la lista.
     */
    public int indiceDe(T elemento) {
        for(int i=0; i < longitud; i++)
	    if(get(i).equals(elemento))
		return i;
	return -1;
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param o el objeto con el que hay que comparar.
     * @return <tt>true</tt> si la lista es igual al objeto
     *         recibido; <tt>false</tt> en otro caso.
     */
    public boolean equals(Object o) {
	if(o == null)
		return false;
	if(getClass() != o.getClass())
		return false;
	@SuppressWarnings("unchecked") Lista <T> otra=(Lista<T>)o;
	Nodo<T> t1=cabeza;
	Nodo<T> t2=otra.cabeza;
	while(t1 != null && t2 != null){
		if(!t1.elemento.equals(t2.elemento))
			return false;
		t1=t1.siguiente;
		t2=t2.siguiente;
	}
	if(t1 !=null || t2 != null)
		return false;
	return true;
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    public String toString() {
	String l = "[";
     	if(longitud <= 0)
	    return null;
	int i=0;
	while(i < longitud-1){
	    l+=get(i);
	    l+=", ";
	    i++;
	}
	l+= get(longitud-1) + "]";
	return l;
    }

    /**
     * Regresa un iterador para recorrer la lista.
     * @return un iterador para recorrer la lista.
     */
    public Iterator<T> iterator() {
        return iteradorLista();
    }

    /**
     * Regresa un iterador para recorrer la lista en ambas
     * direcciones.
     * @return un iterador para recorrer la lista en ambas
     * direcciones.
     */
    public IteradorLista<T> iteradorLista() {
        return new Iterador<T>(this);
    }
    
     /**                                                                                                                                         
     * Regresa una copia de la lista recibida, pero ordenada. La                                                                                
     * lista recibida tiene que contener nada más elementos que                                                                                 
     * implementan la interfaz {@link Comparable}. * @param l la lista que se ordenará.                                                         
     * @return una copia de la lista recibida, pero ordenada.                                                                                   
     */ public static <E extends Comparable<E>> Lista<E> mergeSort(Lista<E> l) {
	if(l.longitud==0||l.longitud==1) return l.copia();
        Lista<E> li = new Lista<E>();
        Lista<E> ld = new Lista<E>();
        Lista<E>.Nodo<E> t = l.cabeza;
        for(int i=0 ; i<l.longitud/2; i++){
            li.agregaFinal(t.elemento);
            t=t.siguiente;
        }
        for(int i = l.longitud/2;i<l.longitud;i++){
            ld.agregaFinal(t.elemento);
            t=t.siguiente;
        }
        li = mergeSort(li);
        ld = mergeSort(ld);
        return mezcla(li,ld);
    }
    
    private static <T extends Comparable<T>> Lista<T> mezcla(Lista<T> li, Lista<T> ld){
        Lista<T> l = new Lista<T>();
        Lista<T>.Nodo<T> ni = li.cabeza;
        Lista<T>.Nodo<T> nd = ld.cabeza;
        while(ni!=null&&nd!=null){
            if(ni.elemento.compareTo(nd.elemento)<0){
                l.agregaFinal(ni.elemento);
                ni = ni.siguiente;
            }else{
                l.agregaFinal(nd.elemento);
                nd = nd.siguiente;
            }
        }
        while(ni!=null){
            l.agregaFinal(ni.elemento);
            ni = ni.siguiente;
        }
        while(nd!=null){
            l.agregaFinal(nd.elemento);
            nd = nd.siguiente;
        }
        return l;
    }
    
}

