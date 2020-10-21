     /**
      *UsaCalculadora pretende interactuar con el usuario, mostrando las opciones con las que cuenta dicho programa, para que asi el usuario
      *pueda elegir propiamente cual opcion se adecua a su problema
      *@author Abrego Alvarez Jonathan
      *@version 1.2
      *@fecha 17 de septiembre de 2011
      */
import java.util.Scanner;
import java.lang.Math;
public class UsaCalculadora {
    public static void main(String arg[]){
	
	//Declaracion de variables
	int opcion;
	int respuesta;
	int i;
	double memoriaA,memoriaB;
 		
	//Este es un menu con las distintas opciones que cuenta la calculadora, para que asi el usuario pueda elegir mas facilmente la operacion a realizar
	System.out.println("Por favor introduzca un numero para indicar la opcion deseada");
	System.out.println("Bienvenido, elije la opcion, para que asi puedas hacer la operacion deseada");
	System.out.println("1.Hacer un suma ");
	System.out.println("2.Realizar una resta");
	System.out.println("3.Hacer una multiplicacion");
	System.out.println("4.Sacar la raiz cuadrada de un numero");
	System.out.println("5.Hacer una division");
	System.out.println("6.Obtener la potencia de un numero");
        Scanner dato=new Scanner(System.in);
	
	//Indicacion para que el usuario introdusca la operacion deseada
	System.out.println("Por favor introduzca un numero para indicar la opcion deseada ");
	
	//Lee la opcion ingresada por el usuario
	opcion=dato.nextInt();
	Calculadora c1=new Calculadora();
	//switch tiene la misma funcion que el if, solo que permite poner las condiciones de manera mas elegante
	switch(opcion){
	case 1: c1.suma();break;
	case 2: c1.resta();break;
	case 3: c1.multiplicacion();break;
	case 4: c1.raiz();break;
	case 5: c1.division();break;
	case 6: c1.potencia();break;
	}
	
	//Un ciclo de repeticion para que el usuario siga haciendo operaciones si asi lo desea
	for(i=0;i!=100;i++){	
	    /** El programa pregunta si desea continuar haciendo una operacion, si decide hacerlo entonces pulsa 0 como respuesta de afirmacion en relacion a             * la respuesta, pero si no decide seguir dentro del prgrama basta con que pulse un numero diferente a cero
	      */ 
	    System.out.println("¿Deseas volver hacer una operacion nuevamente? ");
	    System.out.println("1.-Si");
	    System.out.println("2.No");
	    respuesta=dato.nextInt();
	    
	    if(respuesta==1){
		System.out.println("Vuelve a indicar la operacion deseada");
		System.out.println("1.-Suma");
		System.out.println("2.-Resta");
		System.out.println("3.-Multiplicacion");
		System.out.println("4.-Raiz Cuadrada");
		System.out.println("5.-Division");
		System.out.println("6.-Potencia de un numero");
		System.out.println("Indica la operacion: ");
		opcion=dato.nextInt();
		Calculadora usa=new Calculadora();
		switch(opcion){
		case 1: c1.suma();break;
		case 2: c1.resta();break;
		case 3: c1.multiplicacion();break;
		case 4: c1.raiz();break;
		case 5: c1.division();break;
		case 6: c1.potencia();break;
		}
		
	    }else{
		//En caso de que no desee seguir con el programa esta sentencia marca el fin del programa como del ciclo for, garcias a la ayuda de break
		System.out.println ("Hasta luego ");break;
	    }
	}
    }//fin del main
}//fin de la clase
    
 