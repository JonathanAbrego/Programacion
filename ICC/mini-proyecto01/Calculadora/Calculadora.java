/**
 *Calculadora en ella estan todos los metodos para asi poder, llamarlos en calculadora, en este se muestran las caracteristicas de cada uno
 *de los metodos hayados dentro del cuerpo de la clase Calculadora
 *@author Jonathan Abrego Alvarez
 *@version 1.0
 *@fecha 14 de spetiembre
 */
//Importar los metodos 
import java.util.Scanner;
import java.lang.Math;

    public class Calculadora{
	
	//Declaracion de variables
	private double memoriaA,memoriaB;
	private double v1,v2 ;
	private double result;
	private double p;
	private int resp;
	final double pi=3.141592654;
	final double exp=2.718281828;

	//Este lo utilice para asi guardar el resultado de la operacion hecha y ya depende del usuario en donde guardar su resultado obtenido
	public void memorias(){
	    //Inicializacion de las variables
	    memoriaA=0;
	    memoriaB=0;
	    Scanner val=new Scanner(System.in);
	    //Pregunta en donde desea guardar el valor
	    System.out.println("Elige el lugar de destino de tu resultado memoria: ");
	    //selecciona en cual memoria desea guardar el resultado
	    System.out.println("1.A");
	    System.out.println("2.B");
	    //lee le entrada del teclado
	    this.resp=val.nextInt();
	    //Se ejecuta si presiona 1 y lo guarda en A
	    if(resp==1){
		//Indica donde se guardo el valor si se pulso 1
		System.out.println("Tu resultado de ha guardado en la memoria A");
		//Aqui dice que memoria es igual al resultado
		memoriaA=result;
	    }else{
		//Indica donde se guardo el valor si no se utiliza la memoria A
		System.out.println("Se guardo en B");
		//indica que memoria vale ahora el resultado
		memoriaB=result;
	    }
	}
	
	//Metodo suma en donde se hayan todas las caracteristicas para poder realizar dicho metodo
	public void suma(){
	    System.out.println("Haz elegido la opcion numero 1, por lo tanto deseas hacer una suma");
	    Scanner val=new Scanner(System.in);
	    //pregunta al usuario si desea emplear constantes durante la operacion ya sea pi o exp
	    System.out.println("¿Deseas alguna constante ya sea pi ó exp?");
	    System.out.println("1.SI");
	    System.out.println("2.NO");
	    this.resp=val.nextInt();
	    //SI el usuario desea usar constantes entonces se ejecuta este if y su contenido
	    if(resp==1){
		//Pregunta sobre cual constante desea usar 
		System.out.println("¿Cual deseas usar?");
		System.out.println("1.pi");
		System.out.println("2.exp");
		this.resp=val.nextInt();
		//Si el usuario presiona 1 entonces se ejecuta la opcion pi
		if(resp==1){
		    v1=pi;
		    //Indica  que la constante ya esta definido,por lo tanto solo basta ingresar el valor con el cual desea sumar
		    System.out.println("Como elegiste pi, su valor ya esta definido que es: "+pi);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    //Introduce el valor faltante
		    this.v2=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("La suma es "+ (result=v1+v2));
		    Calculadora mem=new Calculadora();
		    //llama al metodo de memorias para poder guardar el resultado
		    mem.memorias();
		}else{
		    //Se ejecuta si el usuario decide usar exp
		    v1=exp;
		    System.out.println("Como elegiste exp, su valor ya esta definido que es: "+exp);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    //Ingresa el valor que falta para poder realizar la operacion
		    this.v2=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("La suma es "+ (result=v1+v2));
		    //Para poder llamar el motodo de memorias y poder guardar el resultado
		    Calculadora mem=new Calculadora();
		    mem.memorias();
		}
		
	    }else{
		//Se ejecuta si el usuario pretende ingresar sus valores 
		System.out.println("Por favor introduce los numero que deseas sumar");
		//Ingresa el primer valor y pulsa enter
		this.v1=val.nextDouble();
		//Ingresa el segundo valor 
		this.v2=val.nextDouble();
		//Muestra el resultado de la suma 
		System.out.println("El resultado de la suma es: "+ (result=v1+v2) );
		Calculadora mem=new Calculadora();
		//Para poder llamar el metodo de memorias y poder guardar el resultado
		mem.memorias();
	    }
	}
	    
	//Metodo resta en donde se hayan todas las caracteristicas para poder realizar dicho metodo
       	public void resta(){
	    System.out.println("Haz elegido la opcion numero 2, por lo tanto deseas hacer una resta");
	    Scanner val=new Scanner(System.in);
	    //pregunta al usuario si desea emplear constantes durante la operacion ya sea pi o exp
	    System.out.println("¿Deseas alguna constante ya sea pi ó exp?");
	    System.out.println("1.SI");
	    System.out.println("2.NO");
	    this.resp=val.nextInt();
	    //SI el usuario desea usar constantes entonces se ejecuta este if y su contenido
	    if(resp==1){
		//Pregunta sobre cual constante desea usar 
		System.out.println("¿Cual deseas usar?");
		System.out.println("1.pi");
		System.out.println("2.exp");
		this.resp=val.nextInt();
		//Si el usuario presiona 1 entonces se ejecuta la opcion pi
		if(resp==1){
		    v1=pi;
		    //Indica  que la constante ya esta definido,por lo tanto solo basta ingresar el valor con el cual desea restar
		    System.out.println("Como elegiste pi, su valor ya esta definido que es: "+pi);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    //Introduce el valor falante para realizar la operacion
		    this.v2=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("La resta es "+ (result=v1-v2));
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
		}else{
		    //Se ejecuta si el usuario pretende usar exp
		    v1=exp;
		    //Indica que la contsante ya esta definida, por lo tanto solo basta ingresar el valor faltante
		    System.out.println("Como elegiste exp, su valor ya esta definido que es: "+exp);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    //Inserta el numero
		    this.v2=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("La resta es "+ (result=v1-v2));
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
		}
		
	    }else{
		//Se ejecuta si el usuario pretende usar sus propios valores
		System.out.println("Por favor introduce los numero que deseas restar");
		//introducir el primer numero 
		this.v1=val.nextDouble();
		//introducir el numero a restar
		this.v2=val.nextDouble();
		//muestra el resultado de la operacion
		System.out.println("El resultado de la resta es: "+ (result=v1-v2) );
		Calculadora mem=new Calculadora();
		//llama al metodo memoria para guardar el resultado
		mem.memorias();
	    }
	}
	//Metodo multiplicacion en donde se hayan todas las caracteristicas para poder realizar dicho metodo	
	public void multiplicacion(){
	    System.out.println("Haz elegido la opcion numero 3, por lo tanto deseas hacer una multiplicacion");
	    Scanner val=new Scanner(System.in);
	    System.out.println("Por favor introduce los numero que deseas multiplicar");
	    //pregunta al usuario si desea emplear constantes durante la operacion ya sea pi o exp
	    System.out.println("¿Deseas alguna constante ya sea pi ó exp?");
	    System.out.println("1.SI");
	    System.out.println("2.NO");
	    this.resp=val.nextInt();
	    //SI el usuario desea usar constantes entonces se ejecuta este if y su contenido
	    if(resp==1){
		//Pregunta sobre cual constante desea usar 
		System.out.println("¿Cual deseas usar?");
		System.out.println("1.pi");
		System.out.println("2.exp");
		this.resp=val.nextInt();
		//Si el usuario presiona 1 entonces se ejecuta la opcion pi
		if(resp==1){
		    v1=pi;
		    //Indica  que la constante ya esta definido,por lo tanto solo basta ingresar el valor con el cual desea multiplicar
		    System.out.println("Como elegiste pi, su valor ya esta definido que es: "+pi);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    //Introduce el valor faltante
		    this.v2=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("La multiplicacion es "+ (result=v1*v2));
		    //llama al metodo memoria para poder guardar el resultado
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
		}else{
		    //Se ejecuta si el usuario decide usar exp y ademas dice que un valor ya esta ucupado por exp
		    v1=exp;
		    System.out.println("Como elegiste exp, su valor ya esta definido que es: "+exp);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    this.v2=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("La multiplicacion es "+ (result=v1*v2));
		    //llama al metodo memoria para poder guardar el resultado
		    Calculadora mem=new Calculadora();
		    //llama al metodo memorias para poder guardar el resultado obtenido
		    mem.memorias();	
		}	
	    }else{
		//Se ejecuta si el usuario pretende ingresar sus valores 
		this.v1=val.nextDouble();
		this.v2=val.nextDouble();
		//Muestra el resultado de la operacion
		System.out.println("El resultado de la multiplicacion es: "+ (result=v1*v2) );
		//llama al metodo memoria para poder guardar el resultado
		Calculadora mem=new Calculadora();
		mem.memorias();
	    }
	}

	//Metodo raiz en donde se hayan todas las caracteristicas para poder realizar dicho metodo
	public void raiz(){
	    System.out.println("Haz elegido la opcion numero 4, por lo tanto deseas obtener la raiz cuadrada de un numero");
	    Scanner val=new Scanner(System.in);
	    System.out.println("Por favor introduce el numero del cual deseas sacar su raiz cuadrada");
	    //pregunta al usuario si desea emplear constantes durante la operacion ya sea pi o exp
	    System.out.println("¿Deseas alguna constante ya sea pi ó exp?");
	    System.out.println("1.SI");
	    System.out.println("2.NO");
	    this.resp=val.nextInt();
	    //SI el usuario desea usar constantes entonces se ejecuta este if y su contenido
	    if(resp==1){
		//Pregunta sobre cual constante desea usar 
		System.out.println("¿Cual deseas usar?");
		System.out.println("1.pi");
		System.out.println("2.exp");
		this.resp=val.nextInt();
		//Si el usuario presiona 1 entonces se ejecuta la opcion pi
		if(resp==1){
		    //Dice que pi ya ocupa el primer valor dentro de la operacion
		    v1=pi;
		    //Indica  que la constante ya esta definido,por lo tanto solo basta ingresar el valor con el cual desea sacar su raiz cuadrada
		    System.out.println("Como elegiste pi, su valor ya esta definido que es: "+pi);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    System.out.println("La raiz cuadrada de tu numero es "+ (result=Math.sqrt(v1)));
		    //llama al metodo memoria para poder guardar el resultado
		    Calculadora mem=new Calculadora();
		    //Llama al metodo memorias para poder guardar el resultado
		    mem.memorias();
		}else{
		    //Se ejecuta si el usuario decide usar exp ademas de mencionar que exp ya es una valor dentro de la operacion
		    v1=exp;
		    System.out.println("Como elegiste exp, su valor ya esta definido que es: "+exp);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    //Muestra el resultado de la operacion
		    System.out.println("La raiz cuadrada de tu numero es "+ (result=Math.sqrt(v1)));
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
		}
		
	    }else{
		//Se ejecuta si el usuario pretende ingresar sus valores 
		this.v1=val.nextDouble();
		//Si el valor es igual a cero el programa vuelve a pedir que lo introdusca porque no es valido
		if(v1<0){
		    System.out.println("Lo siento pero no existen las raices negativas,por favor ingresa otra vez el numero");
		    this.v1=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("La raiz cuadrada de tu numero es "+ (result=Math.sqrt(v1)));
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
		}else{
		    //Muestra el resultado de la operacion
		    System.out.println("La raiz cuadrada de tu numero es "+(result=Math.sqrt(v1)));
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
		}
	    }
	}

	//Metodo division en donde se hayan todas las caracteristicas para poder realizar dicho metodo
	public void division(){
	    System.out.println("Haz elegido la opcion numero 5, por lo tanto deseas hacer una division");
	    //llama al metodo memoria para poder guardar el resultado
	    Scanner val=new Scanner(System.in);
	    //pregunta al usuario si desea emplear constantes durante la operacion ya sea pi o exp
	    System.out.println("¿Deseas alguna constante ya sea pi ó exp?");
	    System.out.println("1.SI");
	    System.out.println("2.NO");
	    this.resp=val.nextInt();
	    //SI el usuario desea usar constantes entonces se ejecuta este if y su contenido
	    if(resp==1){
		//Pregunta sobre cual constante desea usar 
		System.out.println("¿Cual deseas usar?");
		System.out.println("1.pi");
		System.out.println("2.exp");
		this.resp=val.nextInt();
		//Si el usuario presiona 1 entonces se ejecuta la opcion pi
		if(resp==1){
		    //Menciona que pi ya es un valor que se ejecutara en la operacion
		    v1=pi;
		    //Indica  que la constante ya esta definido,por lo tanto solo basta ingresar el valor con el cual desea dividir
		    System.out.println("Como elegiste pi, su valor ya esta definido que es: "+pi);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    //Introduce el valor faltante
		    this.v2=val.nextDouble();
		    //Si el valor introducido es igual a cero pide que lo vuelva a ingresar puesto que no es valido en una division
		    if(v2==0){
			System.out.println("Lo siento pero dividir cualquier cosa entre cero es un error, por favor introduce un numero valido");
			this.v2=val.nextDouble();
			//Muestra el resultado de la operacion
			System.out.println("Bien hecho ahora si es posible poder realizar la operacion, por lo tanto el resultado de la division es: "+ (v1/v2));
			Calculadora mem=new Calculadora();
			//llama al metodo memoria para poder guardar el resultado
			mem.memorias();
		    }else{
			//Muestra el resultado de la operacion
			System.out.println("El resultado de la division es: "+ (result=v1/v2) );
			//llama al metodo memoria para poder guardar el resultado
			Calculadora mem=new Calculadora();
			mem.memorias();
		    }
		}else{
		    //Se ejecuta si el usuario decide usar exp y que el primer valor de la operacion esta ocupado por exp
		    v1=exp;
		    System.out.println("Como elegiste exp, su valor ya esta definido que es: "+exp);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    this.v2=val.nextDouble();
		    //Si el valro es igual a cero pide que lo vuelva a ingresar
		    if(v2==0){
			       System.out.println("Lo siento pero dividir cualquier cosa entre cero es un error, por favor introduce un numero valido");
			       this.v2=val.nextDouble();
			       //Muestra el resultado de la operacion
			       System.out.println("Bien hecho ahora si es posible poder realizar la operacion, por lo tanto el resultado de la division es: "+ (v1/v2));
			       Calculadora mem=new Calculadora();
			       //llama al metodo memoria para poder guardar el resultado
			       mem.memorias();
		    }else{
			//Muestra el resultado de la operacion
			System.out.println("El resultado de la division es: "+ (result=v1/v2) );
			//llama al metodo memoria para poder guardar el resultado
			Calculadora mem=new Calculadora();
			mem.memorias();
		    }
		}
		
	    }else{
		//Si el usuario quiere introducir sus propios valores 
		System.out.println("Por favor introduce el los numero que deseas dividir, teniendo en cuenta que el primero valor sera tomado  como en numerador y el segundo que introduscas sera el denominador");
		//Introduce el primer valor
		this.v1=val.nextDouble();
		//Introduce el segundo valor
		this.v2=val.nextDouble();
		//Si el segundo valor es igual a cero pide que lo vuelva a ingresar
		if(v2==0){
		    //Indica que no es valido en numero ingresado para esta operacion
		    System.out.println("Lo siento pero dividir cualquier cosa entre cero es un error, por favor introduce un numero valido");
		    this.v2=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("Bien hecho ahora si es posible poder realizar la operacion, por lo tanto el resultado de la division es: "+ (v1/v2));
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
		}else{
		    //Muestra el resultado de la operacion
		    System.out.println("El resultado de la division es: "+ (result= v1/v2) );
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
		    
		}
	    }
	}
	
	//Metodo suma en donde se hayan todas las caracteristicas para poder realizar dicho metodo
	public void potencia(){
	    //Indica la opcion elegida
	    System.out.println("Haz elegido la opcion numero 6, por lo tanto deseas obtener la potencia de un numero");
	    Scanner val=new Scanner(System.in);
	    //pregunta al usuario si desea emplear constantes durante la operacion ya sea pi o exp
	    System.out.println("¿Deseas alguna constante ya sea pi ó exp?");
	    System.out.println("1.SI");
	    System.out.println("2.NO");
	    this.resp=val.nextInt();
	    //SI el usuario desea usar constantes entonces se ejecuta este if y su contenido
	    if(resp==1){
		//Pregunta sobre cual constante desea usar 
		System.out.println("¿Cual deseas usar?");
		System.out.println("1.pi");
		System.out.println("2.exp");
		//Si el usuario presiona 1 entonces se ejecuta la opcion pi
		this.resp=val.nextInt();
		if(resp==1){
		    //Dice que uno de los valores vale pi
		    v1=pi;
		    //Indica  que la constante ya esta definido,por lo tanto solo basta ingresar el valor que representara el exponente
		    System.out.println("Como elegiste pi, su valor ya esta definido que es: "+pi);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    //Introduce el valor faltante
		    this.v2=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("La potebcia de tu numero es "+ (result=Math.pow(v1,p)));
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
		}else{
		    //Se ejecuta si el usuario decide usar exp
		    v1=exp;
		    System.out.println("Como elegiste exp, su valor ya esta definido que es: "+exp);
		    System.out.println("Ingreasa otro valor, para poder realizar la operacion ");
		    //Lee el numero ingresado por el usuario
		    this.v2=val.nextDouble();
		    //Muestra el resultado de la operacion
		    System.out.println("La potencia de tu numeroa es "+(result= Math.pow(v1,p)));
		    Calculadora mem=new Calculadora();
		    //llama al metodo memoria para poder guardar el resultado
		    mem.memorias();
			}
		
	    }else{
		//Se ejecuta si el usuario pretende introducir sus valores
		System.out.println("Por favor introduce el numero del cual deseas sacar su potencia");
		//Lee el valor ingresado por el usuario
		this.v1=val.nextDouble();
		//Indica al usuario que el sugundo valor sera el exponente del numero anterior
		System.out.println("Ahora meciona a que exponente quieres elevar el numero anterior");
		//Lee el valor ingresado
		this.p=val.nextDouble();
		//Muestra el resultado de la operacion
		System.out.println("La la potencia de tu numero es "+ (result=Math.pow(v1,p)));
		Calculadora mem=new Calculadora();
		//llama al metodo memoria para poder guardar el resultado
		mem.memorias();
	    }
	}
    }

