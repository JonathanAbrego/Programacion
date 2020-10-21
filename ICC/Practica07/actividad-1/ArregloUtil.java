/**
 * Clase ArregloUtil: Muestra ejemplos de acciones sobre arreglos, tales como redimensionarlos,
 * unirlos, intercambiar elementos dentro de uno, imprimirlos, crear subarreglos y contar las
 * cadenas que hay en un arreglo
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 */

import java.util.StringTokenizer; // Clase que sirve para contar cadenas en un objeto de tipo String

public class ArregloUtil{

    public ArregloUtil(){ // Clase por default y unica
    }

    /**
     * Redimensiona un arreglo para tener menor o mayor espacio
     * @param arreglo Arreglo a redimensionar
     * @param nuevoTamano Entero que representa la nueva dimensi&oacute;n del arreglo
     */

    public static void redimensionarArreglo(int[] arreglo, int nuevoTamano){
	int[] auxiliar = new int[nuevoTamano]; // Se crea un arreglo temporal, que tendra el tamaño requerido del arreglo
	if(nuevoTamano >= arreglo.length){ // Posibilidades del arreglo cuando la nueva dimension es mayor al actual
	    for(int a=0; a<arreglo.length; a++){
		auxiliar[a]=arreglo[a];
	    }
	} else { // Acciones a realizar cuando la nueva dimension es menor al actual
	    for(int a=0; a<nuevoTamano; a++){
		auxiliar[a]=arreglo[a];
	    }
	} arreglo = auxiliar; // Aqui es donde el arreglo se redimensiona, tomando los valores del arreglo temporal
	for(int a=0; a<arreglo.length; a++){
	    System.out.println(arreglo[a]); // Imprimir el arreglo ya redimensionado
	}
    }

    /**
     * Une arreglos, dependiendo de los par&aacute;metros dados
     * Ejemplo de m&eacute;todos sobrecargados
     * @param arreglo1 Arreglo que se pretende unir con otro
     * @param arreglo2 El segundo arreglo a unir
     * @return union El resultado de la union de los dos arreglos
     */

    public static int[] unirArreglos(int[] arreglo1, int[] arreglo2){
	int union[] = new int[arreglo1.length + arreglo2.length]; // Se define la dimension de la union de los arreglos
	for(int x=0; x<arreglo1.length; x++){
       	    union[x] = arreglo1[x]; // Se pasan primero los elementos del primer arreglo
	    for(int y = arreglo1.length; y<union.length; y++){
		union[y] = arreglo2[y-arreglo1.length]; // Se trasladan ya los elementos del segundo arreglo
            }
	} for(int a=0; a<union.length; a++){
	    System.out.println(union[a]); // Se imprime en pantalla la union resultante
	} return union;
    }

 
    /**
     * Une un arreglo consigo mismo
     * @param arreglo El arreglo a unir con sus mismos elementos
     * @return El arreglo resultante de la uni&oacute;n de un arreglo consigo mismo
     */

    public static int[] unirArreglos(int[] arreglo){
	int[] auxiliar = arreglo; // Se crea un arreglo auxiliar identico al introducido como parametro
	int[] union = new int[arreglo.length + auxiliar.length]; // La union tendra dos veces la dimension del arreglo del parametro
	for(int x=0; x<arreglo.length; x++){
       	    union[x] = arreglo[x];
	    for(int y = arreglo.length; y<union.length; y++){
	    	 union[y] = auxiliar[y-arreglo.length];
            }
	}
	for(int a=0; a<union.length; a++){
	    System.out.println(union[a]);
	} return union;
    }

    /**
     * Intercambia dos elementos dentro de un arreglo
     * @param arreglo El arreglo cuyos elementos queremos intercambiar
     * @param a Representa la posicion de un elemento del arreglo
     * @param b Posicion de un segundo elemento de un arreglo
     * Los elementos de las posiciones a y b del arreglo se intercambiar&aacute;n entre ellos
     */

    public static void intercambiaElementos(int[] arreglo,int a,int b){
	int auxiliar; // Se crea una variable auxiliar para almacenar un elemento a intercambiar
	auxiliar = arreglo[a]; // Uno de los elementos se va a la variable auxiliar
	arreglo[a]=arreglo[b]; // El elemento anterior toma el valor del otro
	arreglo[b]=auxiliar; // El segundo elemento toma el valor guardado en el auxiliar
    }

    /**
     * Crear subarreglos de un arreglo dado, dados unos l&iacute;mites
     * @param arreglo Arreglo del cual se crea el subarreglo
     * @param a Valor que representa un elemento l&iacute;mite del subarreglo
     * @param b Valor representativo del otro l&iacute;mite de un subarreglo
     * @return auxiliar Subarreglo resultante
     */

    public static int[] subarreglo(int[] arreglo,int a,int b){
	int auxiliar[] = new int[Math.abs(b-a)]; // Se crea un arreglo y se definen sus dimensiones
	if(a<b){ // Posibilidades de acciones de los valores enteros introducidos como parametros
	    for(int c=a; c<b; c++){
		auxiliar[c-a]=arreglo[c];
	    } 
	} else {
	    for(int c=b; c<a; c++){
		auxiliar[c-b]=arreglo[c];
	    }
	} for(int n=0; n<auxiliar.length; n++){
	    System.out.println(auxiliar[n]); // Se imprime en pantalla el subarreglo
	} return auxiliar;
    }

    /**
     * Imprime en pantalla los elementos de los que se compone un arreglo
     * Aplica para arreglos que usan valores de tipo int
     * @param arreglo El arreglo del cual se desea ver sus elementos
     */

    public static void imprimirArreglo(int[] arreglo){
	for(int x=0; x<arreglo.length; x++){
	    System.out.println(arreglo[x]);
	}
    }

    /**
     * Imprime elementos de un arreglo de clase String
     * @param arreglo Arreglo de tipo String del cual se desea saber sus elementos
     */

    public static void imprimirArreglo(String[] arreglo){
	for(int x=0; x<arreglo.length; x++){
	    System.out.println(arreglo[x]);
	}
    }

    /**
     * Cuenta las cadenas de un arreglo con una longitud determinada
     * @param arreglo El arreglo sobre el cual el m&eacute;todo va a trabajar
     * @param n La longitud de la cadena que se va a contar en cada uno de los elementos
     * @return Cantidad de elementos del arreglo que tienen la longitud n de cadena
     */

    public static int contarCadenas(String[] arreglo, int n){
	int a=0;
	int contador=0;
	for(a=0; a<arreglo.length; a++){
	    StringTokenizer st = new StringTokenizer(arreglo[a]); // Se crea un objeto de la clase StringTokenizer
	    int numCadenas = st.countTokens(); // Cuenta la longitud de cadena de un elemento de un arreglo
	    if(numCadenas == n){
		contador++; // Si la longitud de un elemento coincide con el requerido, el contador aumenta
	    }
	} System.out.println(contador); // Al terminar el proceso, el contador se muestra en pantalla
	return contador;
    }

    /**
     * Prueba de el correcto funcionamiento de la clase
     */

    public static void main(String arg[]){
	System.out.println("Demostración de la funcionalidad de los metodos de la actividad");
	System.out.println();
	int[] arreglo1 = new int[5];
	arreglo1[0]=1;
	arreglo1[1]=2;
	arreglo1[2]=3;
	arreglo1[3]=4;
	arreglo1[4]=5;
	System.out.println("Tenemos un arreglo inicial con 5 elementos");
	imprimirArreglo(arreglo1);
	System.out.println();
	System.out.println("Redimension del arreglo de 5 a 7 elementos:");
	redimensionarArreglo(arreglo1,7);
	System.out.println();
	System.out.println("Teniendo un segundo arreglo formado por 4 elementos:");
	int[] arreglo2 = new int[4];
	arreglo2[0]=6;
	arreglo2[1]=7;
	arreglo2[2]=8;
	arreglo2[3]=9;
	imprimirArreglo(arreglo2);
	System.out.println();
	System.out.println("La unión de los dos arreglos resulta en:");
	unirArreglos(arreglo1,arreglo2);
	System.out.println();
	System.out.println("Intercambio del segundo por el último elemento del primer arreglo:");
	intercambiaElementos(arreglo1,1,4);
	imprimirArreglo(arreglo1);
	System.out.println();
	System.out.println("Creacion de un subarreglo:");
	subarreglo(arreglo1,1,3);
	String[] arreglo3 = new String[7];
	arreglo3[0]="Coche";
	arreglo3[1]="Coche rojo";
	arreglo3[2]="Avion";
	arreglo3[3]="Bicicleta azul";
	arreglo3[4]="Monociclo";
	arreglo3[5]="Radio rojo viejo";
	arreglo3[6]="Television nueva";
	System.out.println();
	System.out.println("Teniendo otro arreglo, pero esta vez de cadenas:");
	imprimirArreglo(arreglo3);
	System.out.println();
	System.out.println("Se cuentan las cadenas cuya longitud es de 2:");
	contarCadenas(arreglo3,2);
    }
}