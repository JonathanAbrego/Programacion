/**
 * Clase Conjunto se usa para poder realizar las acciones basicas de los conjutno ya sea 
 * la union, la intesercci&oacute;n, ver si ciertos elementos son subconjutnos del conujnto 
 * insertar, eliminar un elemento del conjunto, si un elemento pertence al conjunto entre otras m&aacute;s
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
public class Conjunto{
    
    boolean elementos[];//es un arreglo unidimensional de bytes
    byte cardinalidad;
    
    /**
     *Crea un arreglo por default con un largo de 100 
     *y de cardinalidad cero
     *
     */
    public Conjunto(){
	elementos=new boolean[100];
	cardinalidad=0;
    }
    
    /**
     *Crea una copia del objeto mismo con las mismas caracter&iacute;sticas 
     *@param x de tipo Conjutno que obtendra los mismos atributos que la clase
     *
     */
    public Conjunto(Conjunto x){
	elementos=x.elementos;
	cardinalidad=x.cardinalidad;
    }
    
    /**
     *Crea un Conjunto el cual si es mayor que 100 no se puede crear puesto que tendra como caracter&iacute,stica de poder 
     *guardar a lo mucho 100 elemento,pero si es menor que esta se podra creear el Conjunto y la cardinalidad por lo tanto 
     *ya no sera igual a cero 
     *@param elem es un arreglo unidimensional que determinara el largo del "conjunto"
     */
    public Conjunto(int[] elem){
	cardinalidad=0;
	if(elem.length>100){
	    System.out.println("No se puede crear el conjunto");
	}
	else{ 
	    elementos=new boolean[100];
	    for(int i=0; i<elem.length; i++){
		if(elem[i]>0 && elem[i]<=100){
		    insertar(elem[i]);
		    cardinalidad++;
		}
	    }
	}
    }
    
    /**
     *Obtiene la cardinalida del conjunto 
     *@retunr la cardinalida del conjunto
     */
    
    public byte obtenerCardinalidad(){
	return cardinalidad;
    }
    

    /**
     * 
     *Obtiene el elemento 
     *@param elemento el elemento requerido 
     *@return el elemento
     */
    public int obtenerElemento(int elem){
	if(elementos[elem-1]){
	    return elem;
	} else {
	    return -5;
	}
    }
    
    /**
     *Permite insertar un elemento dentro del conjunto creado
     *@param elem representara el elemento que se insertara en el conjunto
     */    
    public void insertar(int elem){
	if(elem>0 && elem <= 100){
	    if(!(elementos[elem-1])){
		elementos[elem-1]=true;
		cardinalidad++;
	    }
	} else { 
	    System.out.println("Elemento no valido");
	}
    }
    
    /**
     *Permite eliminar  un elemento que se halle dentro del conunto creado,haciendo esto que su cardinalidad dismunya
     *@param elem representara el elemento que se borrara o eliminara del conjunto
     */    
    public void eliminar(int elem){
	if(elem>0&&elem<=100){
	    if(elementos[elem-1]){
		elementos[elem-1]=false;
		cardinalidad--;
	    }
	} else { System.out.println("El elemento esta fuera de rango y no fue eliminado"); }
    }
    
    /**
     * Permite que determinando el tama&ntilde;o del subconjunto deseado 
     * extraer un subconjunto del Conjutno creado, teniendo encuenta que si el tama&ntilde;o
     * del subconjunto que queremos no exeda al tama&ntilde;o del Conjutno mismo, ya que de 
     * ser as&iacute; no se podria creear el subconjutno
     * @param tama&ntilde;o que representara tama&ntilde;o de el subconjutno deseado
     * @return el subconjutno
     */
    public Conjunto subconjunto(int tamano){
	int contador=0;
	Conjunto sub = new Conjunto();
	if(tamano>0 && tamano<=cardinalidad){
	    for(int i=0; i<100; i++){
		if(elementos[i]){
		    sub.insertar(i+1);
		    contador++;
		    if(contador==tamano){ break; }
		    else{ continue; }
		} else { continue; }
	    }
	} else { System.out.println("No puedes hacer el subconjunto"); }
	System.out.println("La cardinalidad del subconjunto es "+sub.obtenerCardinalidad());
	return sub;	   
    }
    
    /**
     * Dado un entero saber si se encuentra dentro del Conjunto
     *@param elemento de tipo entero es el elemento que queremos saber si esta dentro de Conjunto
     *@return si el elemento que damos est&aacute; o pertenece al Conjunto
     */
    public boolean pertenece(int elemento){
	if(elementos[elemento-1]){
	    return true;
	} else { return false; }
    } 
    
     /**
     * Para determianr la interseccion de dos conjutnos diferentes 
     *@param c de tipo Conjutno que ayudara para poder ver la interseccion de dos conjuntos 
     *@retunr los elementos que estan dentro de la interseccion
     */
    public Conjunto interseccion(Conjunto c){
	Conjunto d = new Conjunto();
	for(int i=0; i<d.elementos.length; i++){
	    if(elementos[i]&& c.elementos[i]){
		d.insertar(i+1);
	    } else { continue; }
	} return  d;
    }
    
    /**
     *Ayuda a determinar la union de dos conjutnos 
     *@param c-Conjunto que se para poder realizar la union
     *@retunr la union de 2 conjuntos 
     */
    public Conjunto union(Conjunto c){
	Conjunto d = new Conjunto();
	for(int i=0; i<d.elementos.length; i++){
	    if(elementos[i] || c.elementos[i]){
		d.insertar(i+1);
	    }
	} return d;
    }
    
    /**
     * Ayuda a determinar la diferencia de dos conjuntos 
     *@param c-conjunto para asi poder creear un nuevo conjunto y asi poder hace uso de la diferencia 
     *@retunr los elementos del Conjuntoe no se encuentra en otro Conjunto
     */
    public Conjunto diferencia(Conjunto c){
	Conjunto d = new Conjunto();
	for(int i=0; i<100; i++){
	    if(elementos[i] && !c.elementos[i]){
		d.insertar(i+1);
	    }
	} return d;
    }
    
    /**
     *Ayuda a determinar cuando un conjunto cuanta con cero elementos 
     *@return regresa si el conjunto es vacio o no lo es 
     */
    public boolean esVacio(){
	if(cardinalidad==0){
	    return true;
	} else { return false; }
    }
    
    /**
     *Convierte a forma de cadena todo el conjunto para poder 
     *vizualizarlo de manera m&aacute;s adecuada
     *@return regresa el conjutno de forma mas formal
     */
    public String toString(){
	String conj="";
	if(cardinalidad==0){
	    conj = "{ }";
	} else {
	    for(int a=1; a<=elementos.length; a++){
		if(elementos[a-1]){
		    conj+= "|"+obtenerElemento(a)+"| ";
		} else { conj+="";}
	    }
	} return conj;
    }
}
