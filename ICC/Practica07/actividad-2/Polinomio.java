/**
 * Clase Polinomio: Creaci&oacute;n de un polinomio desde un arreglo hecho con
 * n&uacute;meros aleatorios entre 0 y 20.
 * Se pueden crear polinomios de cualquier grado.
 * Para crearlos s&oacute;lo se tiene que escribir el n&uacute;mero de elementos * que queremos que el polinomio tenga y el programa lo construir&aacute;.
 * @author Mart&iacute;nez Anaya Luis Angel
 * @author Abrego Alvarez Jonathan
 * @version 1.0
 */

import java.util.Random;

public class Polinomio{

    //Atributos
    public int[] coeficientes; //Arreglo que representa los coeficientes del polinomio
    public int grado;//Variable que representa el grado del polinomio
    public int[] exp;//Arreglo que representan los exponentes de cada monomio que componen al polinomio

    /**
     * Crea un polinomio desde un arreglo ya definido donde todos los coeficientes toman el valor 2
     * Se determinan el grado y a los exponentes del polinomio
     */

    public Polinomio(){
	coeficientes = new int[6];//Se crea un arreglo para el polinomio default
	this.grado=coeficientes.length-1;//Se define el grado del polinomio
	for(int a=0; a<coeficientes.length; a++){
	    coeficientes[a]=2;
	}
	exp= new int[coeficientes.length]; //Se determina la longitud del arreglo de exponentes
	int b=grado;
	for(int a=0; a<coeficientes.length; a++){ //Se determinan los valores de exponentes
	    exp[a]=b;
	    b--;
	}
    }

    /**
     * Creaci&oacute;n de un polinomio desde un arreglo dado por n&uacute;meros aleatorios
     * Se determina el grado del polinomio de acuerdo a la longitud del arreglo menos uno
     * Se determina tambi&eacute;n  a los exponentes del polinomio
     * @param arr Arreglo que sirve como referencia para crear el polinomio
     */

    public Polinomio(int[] arr){
	coeficientes=new int[arr.length];
	coeficientes=arr;//Las variables de los coeficientes toman los valores del arreglo
	this.grado=coeficientes.length-1; //Se determina el grado del polinomio
	exp= new int[coeficientes.length];
	int b=grado;
	for(int a=0; a<coeficientes.length; a++){
	    exp[a]=b;
	    b--;
	}
    }

    /**
     * Crear un polinomio copia de otro polinomio definido anterormente
     * @param poli Polinomio a ser copiado
     */

    public Polinomio(Polinomio poli){
	coeficientes=poli.coeficientes;
	this.grado=poli.grado;
	exp=poli.exp;
    }

    /**
     * Permite realizar una suma entre dos polinomios, imprimiendo en pantalla el resultado
     * @param poli El segundo polinomio a sumar
     */

    public void sumaPolinomio(Polinomio poli){
	int[] suma;
	if(coeficientes.length<poli.coeficientes.length){ //Se determina la longitud que debe de tener el arreglo que guarda la suma
	    suma = new int[poli.coeficientes.length];
	} else {
	    suma = new int[coeficientes.length]; }
	for(int a=0; a<suma.length; a++){
	    poli.coeficientes[a]+=coeficientes[a];
	}
    }

    /**
     * Imprime en pantalla el polinomio sobre el cual se realiza el m&eacute;todo.
     */

    public void imprimirPolinomio(){
	for(int a=0; a<coeficientes.length; a++){ //De acuerdo al exponente la impresion del monomio va a variar
	    if(exp[a]==0){ System.out.print(coeficientes[a]); }
	    else if(exp[a]==1){ System.out.print(coeficientes[a]+"x+"); }
	    else { System.out.print(coeficientes[a]+"x^"+exp[a]+"+"); }
	}
	System.out.println();
    }
    
    /**
     * Multiplica por un escalar a todos los coeficientes del polinomio
     * @param factor El escalar por el cual se multiplica el polinomio
     */

    public void multiplicaPolinomio(int factor){
	for(int a=0; a<coeficientes.length; a++){
	    coeficientes[a]*=factor;
	}
    } 

    /**
     * Eval&uacute;a el polinomio en un numero real (de tipo double) e imprime en pantalla
     * el resultado
     * @param factor N&uacute;mero de tipo double por el cual se eval&uacute;a el polinomio
     * @return El resultado de la evaluaci&oacute;n
     */

    public int evaluarPolinomio(double factor){
	int total=0; // Se crea una variable para guardar el total de la evaluacion
	for(int a=0; a<coeficientes.length; a++){
	    double resultado = Math.pow(factor,(double)exp[a])*(double)coeficientes[a];
	    total+=resultado;
	} return total;
    }

    /**
     * Imprime en pantalla el grado del polinomio
     * @return El grado del polinomio
     */

    public int imprimirGrado(){
	return grado;
    } 

    /**
     * Prueba del correcto funcionamiento de la clase Polinomio
     */

   public static void main(String arg[]){
       int[] arreglo1= new int[6];
       Random aleatorio = new Random();
       int x;
       for(int a=0; a<arreglo1.length; a++){
	   for(int i=0; i<21; i++){
	       x=(int)(aleatorio.nextDouble()*10.0);
	       arreglo1[a]=x;
	   }
       }
       Polinomio c=new Polinomio(arreglo1);
       System.out.println("El siguiente polinomio tiene grado "+c.imprimirGrado()+":");
       c.imprimirPolinomio();
       System.out.println("Multiplicado por un escalar:");
       c.multiplicaPolinomio(4);
       c.imprimirPolinomio();
       System.out.println("Evaluacion del polinomio:");
       System.out.println(c.evaluarPolinomio(3));
       int[] arreglo2= new int[6];
       for(int a=0; a<arreglo2.length; a++){
	   for(int i=0; i<21; i++){
	       x=(int)(aleatorio.nextDouble()*10.0);
	       arreglo2[a]=x;
	   }
       }
       Polinomio d= new Polinomio(arreglo2);
       System.out.println("Sumado con un segundo polinomio:");
       d.imprimirPolinomio();
       System.out.println("El resultado de la suma de los dos polinomios es:");
       c.sumaPolinomio(d);
       d.imprimirPolinomio();
   }
}