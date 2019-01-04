/**Programa que dados dos numero,
 * haga uso de ellos para resolver
 * una funcion matematica especifica
 *@author:Abrego Alvarez Jonathan
 *@version: 1.0 
 *@fecha: 8 de septiembre de 2010
 */

//Para importar y poder usa Scanner   
import java.util.Scanner;
public class Funcion{
    public static void main(String[]args){
	Scanner entrada= new Scanner(System.in);
	//La indicasion dada hacia el usuario,para un mejor funcionamiento del programa
	System.out.println("\nIntroduce 2 numeros enteros, en el caso de ”b” introduce porfavor un numero positivo ya que no existen las raices negativas");
	//Declaracion de variables
	double a;
	double b;
	//Aqui se van introducir los valores que el usuario quiere para ”a” y ”b”
	System.out.print("Introduce el valor de a: ");
	a=entrada.nextDouble();
	System.out.print("Introduce el valor de b: ");
	b=entrada.nextDouble();
	// Esto es el resultado de la division de ”a” cuadrada y ”b” cuadrada
	System.out.print("("+ Math.pow(a,2)/Math.pow(b,2)+" + ");
	//Este es el resultado de la raiz cuadrada del valor dado a ”b” entre 3* por el valor de ”a”
	System.out.print( Math.sqrt(b)/(3*a)+" - ");
	//El siguiente es el resultado de la multiplicacion de 6 por el valor de ”b”
	System.out.print(6*b+")/ " );
	//Por ultimo tenemos la diferencia de la multiplicacion 19*por el valor de ”a” y 4 por el valor de ”b” 
	System.out.println((19*a)-(4*b)+ " =");
	//Por ultimo tenemos el resultado de toda la operacion completa
	System.out.println("    Resultado de la operacion es:  "+ ((Math.pow(a,2)/Math.pow(b,2))+( Math.sqrt(b)/(3*a))-(6*b))/((19*a)-(4*a)));
	System.out.println();
    }
}
