/**
 * Clase Datos: Almacena en un arreglo enteros generados aleatoriamente, para
 * despu&eacute;s recorrerlo con ayuda de un iterador. Los enteros almacenados
 * en el arreglo son generados con ayuda d ela clase Random de java.util.
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 */ 

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Datos{
    
    private int[] datos; // Arreglo donde se guardaran los datos enteros
    private int ultimoDato; //Representa la posicion siguiente al ultimo dato almacenado en el arreglo.

    /**
     * Crea un objeto de Datos por default, donde hay capacidad para almacenar 100 elementos
     */
    
    public Datos(){
	datos = new int[100]; // Crea un arreglo para alamcenar 100 elementos
	ultimoDato = 0; //En este momento no tenemos ningun elemento en el arreglo.
    }
    
    /**
     * Crea un objeto Datos a partir de un archivo, interpreta las cantidades como tipo entero
     * @param nombreArchivo Cadena que representa el nombre del archivo a interpretar valores
     * El nombre del archivo debe venir en forma de ruta relativa
     */

    public Datos(String nombreArchivo){
	Scanner archivo;
	datos = new int[100];
	ultimoDato=0;
	try{
	    archivo =  new Scanner(new File(nombreArchivo));
	    while(archivo.hasNext() && ultimoDato<100){
		datos[ultimoDato]=archivo.nextInt();
		//Se puede usar useDelimiter(String delimitador)
	    }
	} catch(Exception e){
	    System.out.println("Un error con el archivo.");
	}
    }
    
    /**
     * Crea un objeto Dato a partir de otro objeto del mismo tipo
     * @param datosClon El objeto de tipo Dato a copiar
     */

    public Datos(Datos datosClon){
	datos = datosClon.datos; // Hace una referencia al arreglo del objeto pasado como parametro.
	ultimoDato = datosClon.ultimoDato; // Copia el numero de elementos del objeto parametro
    }
    
    /**
     * Lleva una cuenta del numero de datos que lleva el programa
     */

    public int numeroDeDatos(){
	return ultimoDato; // Numero de elementos almacenados en el arreglo de enteros aleatorios
    }
    
    /**
     * Imprime en pantalla un dato a partir de su posici&oacute;n
     * @param pos Entero que representa la posicion de la cantidad en el arreglo
     */ 

    public int obtenerEn(int pos){
	return datos[pos];
    }

    /**
     * Inserta una cantidad nueva en el arreglo
     */
    
    public void insertar(){
	Random numero = new Random(); // Esto ayuda a generar un numero aleatorio.
	datos[ultimoDato]= numero.nextInt(101); //Genera un numero aleatorio del 1 al 100
	ultimoDato++; // Aumenta el numero de datos en el arreglo
    }

    /**
     * Borra una la &uacute;ltima cantidad del arreglo
     */
    
    public void borrar(){
	datos[ultimoDato]=-1;
	ultimoDato--; // Disminuye el numero de datos en el areglo
    }

    /**
     * Obtiene la moda de un arreglo
     * La moda es la cantidad que se repite m&aacute;s veces dentro de una lista de cifras
     * @param arr El arreglo al cual se le va a obtener la moda
     */

    public void moda(int[] arr){
	int maximaVeces=0; //Contador que lleva una cuenta de las veces que se repite una cifra
	int moda=0;//Entero que indica la moda de la lista de cifras
	for(int i=0; i<arr.length; i++){
	    int vecesRep=0;
	    for(int j=0; j<arr.length; j++){
		if(arr[i]==arr[j]){
		    vecesRep++;
		}
		if(vecesRep>maximaVeces){
		    moda=arr[i];
		    maximaVeces=vecesRep;
		}
	    }
	}
	System.out.println("La moda es "+moda+" y se repitió "+maximaVeces+" veces");    
    }

    /**
     * Obtiene el promedio de 100 cantidades contenidas dentro de un archivo
     * @param nombreArchivo Cadena que representa el nombre del archivo al cual se le va a obtener el promedio
     * Debe de ser una ruta relativa
     * @return El promedio de las cantidades
     */

    public double promedio(String nombreArchivo){
	Scanner archivo; // Nuevo objeto clase Scanner, como en la creacion de un objeto tipo Dato a partir de un archivo
	datos = new int[100];
	ultimoDato=0;
	try{
	    archivo =  new Scanner(new File(nombreArchivo));
	    while(archivo.hasNext() && ultimoDato<100){
		datos[ultimoDato]=archivo.nextInt();
		ultimoDato++;
		//Se puede usar useDelimiter(String delimitador)
	    }
	} catch(Exception e){
	    System.out.println("Un error con el archivo.");
	}
	double promedio=0; //Variable que guarda el promedio de las cantidades
	for(int a=0; a<datos.length; a++){
	    promedio+=(double)datos[a];
	}
	promedio/=100;
	return promedio;
    }

    /**
     * Prueba del correcto funcionamiento de la clase Datos
     */

    public static void main(String arg[]){
	Datos d=new Datos();
	int[] arr=new int[100];
	Random r=new Random();
	int b;
	for(int a=0; a<arr.length; a++){
	    arr[a]=(int)(r.nextDouble()*10.0);
	}
	d.moda(arr);
	System.out.println("El promedio de las cantidades contenidas en el archivo indicado es " + d.promedio("EjemploDatos.txt"));
    }
}