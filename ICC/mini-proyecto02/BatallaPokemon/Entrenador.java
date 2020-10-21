/**
 * La clase Entrenador define las caracteristicas nencesarias para poder crear un entrenador con los datos m&aacute;s que se necesiten
 * una de las cosas que se pueden destacar es que ademas de la informaci&oacute;n basica que son nombre,edad,ciudad de origen,etc, en esta clase 
 * se hace cargo de la asignaci&oacute;n de Pokemones, el guardado de estos en las Pokebola que son escenciales para poder realizar la batalla 
 * 
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 * @see Pokebola
 * @see Pokemon
 *
 */
import java.util.Scanner;

public class Entrenador{

    private String nombre;//Cadena que representara el nombre del entrenador
    private String apellido;//Cadena que representara el apellido del entrenador
    private String ciudadDeOrigen;//Cadena que representara la ciudad de origen del entrenador
    private String equipo;//Cadena que representa al equipo que pertence el entrenador
    private int edad,x;//Entero para la edad del entrenado 
    private int numPoke=0;//Entero inicializado en cero que representa la cantidad de Pokemones que tiene el entrenador
    private Scanner scan = new Scanner(System.in);
    private String genero;//Cadena que representa el genero del entrenador, ya sea hombre o mujer 
    public int numPokemones=1;
    public int pokemonesPosibles=0;
    public Pokebola[] cinturon;//Un arreglo unidimensional que hara alucion a un cinturon de Pokebolas
    public Pokemon p1;//Un objeto de la clase Pokemon
    public Pokemon pokeBatalla;//Objeto de la clase Pokemon para ayudar en sus propiedades con las que cuenta la clase

     /**
     * Crea un entrenador por default con nombre, apellido, ciudad de origen, equipo al que pertenece y  edad,  todos estos predefinidos  
     * y genero que tiene, adem&aacute;s que el arreglo que representa el cinturon cuenta con 
     * el maximo de Pokebolas posibles que son 6
     *
     */
    public Entrenador(){
	nombre="Ash";
	apellido="Ketchup";
	ciudadDeOrigen="Pueblo_Paleta";
	equipo = "Pokepoke";
	edad=10;
	genero="Masculino";
	cinturon=new Pokebola[6];
	cinturon[0]=new Pokebola();
	cinturon[1]=new Pokebola();
	cinturon[2]=new Pokebola();
	cinturon[3]=new Pokebola();
	cinturon[4]=new Pokebola();
	cinturon[5]=new Pokebola();
    }

/**
     * Crea un entrenador donde las caracteristicas propias de un entrenador que son nombr, apellido,cuidad de origen,
     * edad, equipo y genero aun no han sido representadas como desea el usuario, lo que se hace aqui es solo 
     * indicar el tipo al que pertenece cada una, por ejemplo el nombre es de tipo cadena, la edad de tipo entero, 
     * en este caso cambia genero se hace alucion mediante un entero,puesto que si selecciona el usuario 1 o 2 ya se 
     * imprimira en forma de cadena el genero que eligio el usuario, adema&acute;s en este caso el entreandor contara con un
     *cintur&oacute;n de 6 Pokeboklas     *@param name String para representar el  nombre del entrenador en forma de cadena 
     *@param lastName String para representar el  apellido entrenador en forma de cadena 
     *@param city String para representar el ciudad de origen del entrenador en forma de cadena 
     *@param team String para representar el al equipo que pertenece el entrenador en forma de cadena 
     *@param age int para representar la edad del entrenador 
     *@param genre int para poder determinar la elecci&oacute;n y asi saber si es hombre o mujer 
     */
    public Entrenador(String name, String lastName, String city, String team, int age, int genre){
	nombre=name;
	apellido=lastName;
	ciudadDeOrigen=city;
	edad=age;
	equipo=team;
	if(genre==1){ genero="Masculino"; }
	else{ genero="Femenino"; }
	cinturon=new Pokebola[6];
	cinturon[0]=new Pokebola();
	cinturon[1]=new Pokebola();
	cinturon[2]=new Pokebola();
	cinturon[3]=new Pokebola();
	cinturon[4]=new Pokebola();
	cinturon[5]=new Pokebola();
    }

    /**
     * Toma un objeto de la clase Entrenador como parametro y asi poder 
     * crear un objeto de copia con las mismas caracteristicas ya mencionadas
     *@para t Entrenador para poder obeter todas la caracteristicas propias de un entrenador
     */

    public Entrenador(Entrenador e){
	nombre=e.nombre;
	apellido=e.apellido;
	ciudadDeOrigen=e.ciudadDeOrigen;
	edad=e.edad;
	equipo=e.equipo;
	genero=e.genero;
	cinturon=new Pokebola[6];
	cinturon[0]=new Pokebola();
	cinturon[1]=new Pokebola();
	cinturon[2]=new Pokebola();
	cinturon[3]=new Pokebola();
	cinturon[4]=new Pokebola();
	cinturon[5]=new Pokebola();	
    }

    /**
     * Obtien una especie de tarjeta de presentaci&oacute;n con los datos del entrenador 
     *
     *@return Los datos del entrenador de una manera mas adecuada 
     */
    public String toString(){
	return "_________________________________________ \n\n\t"+apellido+", "+nombre+"\n  "+edad+" años\n  Equipo "+
	    equipo+"\n  Proveniente de "+ciudadDeOrigen+"\n  Sexo "+genero+"\n\n Cuenta con "+
	    obtenerNumPokemonesEntrenador()+" pokemones:\n"+obtenerNombresPokemonesEntrenador()+
	    "_________________________________________";
    }

    /**
     * Obtiene la cantidad de Pokemones que tiene el entrenador y adem&aacute;s de esto 
     * permite guardar a los Pokemones en el cinturon, permitiendole al entrenador  
     * tener un maximo de 6 pokemones 
     *
     *@return El numero de Pokemones con el que cuenta el entrenador
     */
    public int obtenerNumPokemonesEntrenador(){
	int numeroPokemonesDeEntrenador=0;
	for(int a=0; a<cinturon.length; a++){
	    if(cinturon[a].pokebolaOcupada){ numeroPokemonesDeEntrenador++; }
	} return numeroPokemonesDeEntrenador;
    }


    /**
     * Obtiene el nombre o apodo de cada uno de los Pokemon con que cuenta   
     * un entrenador 
     *
     *@retun Los nombres o apodos de los Pokemones del entrenador 
     */
    public String obtenerNombresPokemonesEntrenador(){
	String nombresPokemones="";
	for(int a=0; a<cinturon.length; a++){
	    if(cinturon[a].pokebolaOcupada){ nombresPokemones+="  - "+cinturon[a].pokemonContenido.obtenerApodo()+" ("+
		    cinturon[a].pokemonContenido.obtenerNombre()+")"+"\n"; }
	} return nombresPokemones;
    }

    /**
     * Dependiendo de la cantidad de Pokemone que tiene un Entrenador mostrar en que ubicac&oacute;n
     * del cinturon esta del 1 al 6 que son el numero minimo y maximo de Pokemones que puede contener     *
     *
     */
    public void menuInformacionPokemones(){
	System.out.println();
	BatallaUsando2Pokemon b = new BatallaUsando2Pokemon();
	for(int x=0; x<cinturon.length; x++){
	    if(cinturon[x].pokebolaOcupada){ System.out.println("("+(x+1)+") "+cinturon[x].pokemonContenido.obtenerApodo());
		numPokemones=x; }
	    else{ }
	}
	int a = scan.nextInt();
	switch(a){
	case 1:
	    System.out.println(cinturon[0].pokemonContenido);
	    break;
	case 2:
	    System.out.println(cinturon[1].pokemonContenido);
	    break;
	case 3:
	    System.out.println(cinturon[2].pokemonContenido);
	    break;
	case 4:
	    System.out.println(cinturon[3].pokemonContenido);
	    break;
	case 5:
	    System.out.println(cinturon[4].pokemonContenido);
	    break;
	case 6:
	    System.out.println(cinturon[5].pokemonContenido);
	    break;
	default:
	    break;
	}   
    }

    /**
     * Permite al entrenador elegir los Pokemones que desea para la batalla, para poder hacer esto 
     * se despliega un menu con los pokemones disponibles y el entrenador tiene que ingresar el entero 
     * que aparece al lado de cada Pokemon en el menu para poder seleccionarlo, al hacer una elecci&oacute;n se le 
     * permite al usuario darle un apodo si asi lo desea a su Pokemon elegido y adem&aacute;s de indicarle 
     * en que PoKebola se guardo el Pokemon
     *
     */
    public void asignacionDePokemones(){
	while(pokemonesPosibles<=5){
	    System.out.println();
	    System.out.println("Sala de Asignación de Pokemones \nIntroduzca el número correcto para realizar "+
			       "una de las siguientes acciones: \n(1) Ser dueño de un Canek \n(2) Ser dueño de un Kraigean "+
			       "\n(3) Ser dueño de un Sprenk \n(4) Ser dueño de un Tachamón \n(5) Ser dueño de un Tezclah "+
			       "\n(6) Ser dueño de un Voalparg \n(7) Ser dueño de un Zázabraz");
	    int a=scan.nextInt();
	    String b;
	    switch(a){
	    case 1:
		System.out.println("Escribe el nombre que quieres que tenga tu Canek");
		b = scan.next();
		Canek c = new Canek(b);
		guardaPokebola(c);
		System.out.println("Ahora "+c.obtenerApodo()+" vive en tu Pokebola no. "+x);
		pokemonesPosibles++;
		break;
	    case 2:
		System.out.println("Escribe el nombre que quieres que tenga tu Kraigean");
		b = scan.next();
		Kraigean k = new Kraigean(b);
		guardaPokebola(k);
		System.out.println("Ahora "+k.obtenerApodo()+" vive en tu Pokebola no. "+x);
		pokemonesPosibles++;
		break;
	    case 3:
		System.out.println("Escribe el nombre que quieres que tenga tu Sprenkl");
		b = scan.next();
		Sprenkl s = new Sprenkl(b);
		guardaPokebola(s);
		System.out.println("Ahora "+s.obtenerApodo()+" vive en tu Pokebola no. "+x);
		pokemonesPosibles++;
		break;
	    case 4:
		System.out.println("Escribe el nombre que quieres que tenga tu Tachamón");
		b = scan.next();
		Tachamon t = new Tachamon(b);
		guardaPokebola(t);
		System.out.println("Ahora "+t.obtenerApodo()+" vive en tu Pokebola no. "+x);
		pokemonesPosibles++;
		break;
	    case 5:
		System.out.println("Escribe el nombre que quieres que tenga tu Tezclah");
		b = scan.next();
		Tezclah h = new Tezclah(b);
		guardaPokebola(h);
		System.out.println("Ahora "+h.obtenerApodo()+" vive en tu Pokebola no. "+x);
		pokemonesPosibles++;
		break;
	    case 6:
		System.out.println("Escribe el nombre que quieres que tenga tu Voalparg");
		b = scan.next();
		Voalparg v = new Voalparg(b);
		guardaPokebola(v);
		System.out.println("Ahora "+v.obtenerApodo()+" vive en tu Pokebola no. "+x);
		pokemonesPosibles++;
		break;
	    default:
		System.out.println("Escribe el nombre que quieres que tenga tu Zázabraz");
		b = scan.next();
		Zazabraz z = new Zazabraz(b);
		guardaPokebola(z);
		System.out.println("Ahora "+z.obtenerApodo()+" vive en tu Pokebola no. "+x);
		pokemonesPosibles++;
		break;
	    }
	}
    }

    public void menuPokemonEscogido(){
	System.out.println();
	System.out.println("¿Estas listo? \n(1) ¡Ya! \n(2) ¡Espera! Aún no");
	int decision=scan.nextInt();
	switch(decision){
	case 1:
	    break;
	default:
	    asignacionDePokemones();
	    break;
	}
    }

    /**
     * Mediante este metodo se permite liberar a alg&uacute;n Pokemon que se halle 
     * en el cinturon del entrenador, para poder emplearlo en batalla
     *
     */
    public void liberarPokemon(Pokebola pb){
	if(pb.pokebolaOcupada==true){
	    pb.pokemonLibre=pb.pokemonContenido;
	    pb.pokemonContenido=null;
	    pb.pokebolaOcupada=false;
	    System.out.println("Se ha liberado a "+pb.pokemonLibre.obtenerApodo());
	    p1=pb.pokemonLibre;
	} else {
	    System.out.println("No hay Pokemon dentro de la pokebola");
	    seleccionarPokemon();
	}
    }

    public void seleccionarPokemon(){
	Entrenador e = new Entrenador ();
	System.out.println("Abre una Pokebola");
	for(int x=0; x<cinturon.length; x++){
	    if(cinturon[x].pokebolaOcupada){ System.out.println("("+(x+1)+")"+" Libera a "+
								cinturon[x].pokemonContenido.obtenerApodo()); 
		numPokemones=x; }
	    else{ }
	}
	int decision=scan.nextInt();
	switch(decision){
	case 1:
	    liberarPokemon(cinturon[0]);
	    break;
	case 2:
	    liberarPokemon(cinturon[1]);
	    break;
	case 3:
	    liberarPokemon(cinturon[2]);
	    break;
	case 4:
	    liberarPokemon(cinturon[3]);
	    break;
	case 5:
	    liberarPokemon(cinturon[4]);
	    break;
	default:
	    liberarPokemon(cinturon[5]);
	    break;
	}
    }

    /**
     * Permite indicarle al entrenador cuando ya ah alacanzado el numero maximo de Pokemones
     * que puede guardar en su cinturon, de no ser as&iacute; le permite al usuario seguir 
     * guardando Pokemones
     *
     */
    public void guardaPokebola(Pokemon p){
	if(numPoke==6){ System.out.println("Ya alcanzaste el máximo de pokemones a adquirir");
	} else {	
	    cinturon[numPoke].ocuparPokebola(p);
	    x=numPoke+1;
	    numPoke++;
	}

    }

    /**
     * Obtiene en nombre del entrenador del Entrenador
     * @return El nombre del entrenador 
     */
    public String obtenerNombre(){
	return nombre;
    }

    //Metodo main para probar la creacion de un entrnador
    public static void main(String arg[]){
	Entrenador e = new Entrenador("Juan","Pérez","DF","Margarita",23,1);
	e.asignacionDePokemones();
	System.out.println(e);
    }
}