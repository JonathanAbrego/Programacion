/**Programa que dado un numero,
 * entero positivo o negativo, muestre
 * la tabla de multiplicar de este hasta
 * el numero 10.
 *@author:Abrego Alvarez Jonathan
 *@version: 1.0 
 *@fecha: 8 de septiembre de 2010
 */
//Lo emplee para poder hacer uso de Scanner
import java.util.Scanner;
public class Multiplicacion{
    public static void main(String[]args){
	Scanner entrada= new Scanner(System.in);
	System.out.println("Hola, este progrma tiene la intencion de mostrar en la pantalla la tabla de multiplicar de el numero que determines. ¿Que numero quieres que sea ese?");
	//Declaracion de variables
        int num;
	int n;
	//En este paso se va a ingresar e imprimir el numero que el usuario eliga
	System.out.print("Introduce un numero entero del cual desees sacar su tabla de multiplicar hasta el 10: ");
	num=entrada.nextInt();
	System.out.println("El numero que elgiste fue "+ num);
	/**Este paso es un ciclo de repticion en el cual la variable ”n” que esta al principio determina desde donde va a empezar el ciclo de repeticion,por
	 * ejemplo en este caso empezara desde 0 y como se puede ver la condicion al lado de ”while” dice que esta finalizara cuando ”n” sea menor que 11 
	 * lo que esta debajo de eso es las sentencias que realizara dicho ciclo, de repeticion que en este caso sera la multiplicacion de un numero ”n” por
	 * por el numero que decida el usuario que en este caso llamaremos como variable num siendo eso un igual de num*n*,por ultimo tenemos n++ que determ         *  ina el incremento que tendra n durante el proceso, que en esta ocasion fue de 1 */
	n=0;
	    while (n<11){
		System.out.println("            "+num +" * "+ n + " = "+(num*n));
		n++;
	   }
    }
}