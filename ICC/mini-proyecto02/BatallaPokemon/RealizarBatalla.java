/**
 * Clase RaelizarBatalla permite llevara acabao una batalla Pokemon
 * 
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Scanner;

public class RealizarBatalla{

    private BatallaUsando2Pokemon b = new BatallaUsando2Pokemon();
    private Entrenador e1,e2;//Atributo de tipo Entrenador para poder crear los 2 entrenadores requeridos para la batalla
    private String nombre, apellido, ciudadDeOrigen, genero, equipo;//Cadenas que representaran los datos ingresados para poder crear al entrenador
    private int edad, x;//Permite 
    private Scanner teclado = new Scanner(System.in);

    public RealizarBatalla(){ }

    /**
     * Almacena los datos ingresados por el usuario que emplee el programa y para 
     * asi poder crear a un entrenador. Al finalizar el ingreso  de los datos pertinentes 
     * se imprime un mensaje donde indicara que el usuario ya es un entrenador Pokemon
     */
    public void crearEntrenador(){
	int x;
	System.out.println("¡Bienvenido a POKEMON!");
	System.out.println("Para ser reconocido como un entrenador Pokemon primero nos debe de brindar unos datos "+
			   "\nFAVOR DE ESCRIBIR LOS ESPACIOS CON GUIÓN BAJO");
	System.out.println("Escriba su nombre:");
	nombre=teclado.next();
	System.out.println("Escriba su apellido:");
	apellido=teclado.next();
	System.out.println("Nombre de clan:");
	equipo=teclado.next();
	System.out.println("¿De qué ciudad proviene?");
	ciudadDeOrigen=teclado.next();
	System.out.println("¿Cuántos años tiene?");
	edad=teclado.nextInt();
	System.out.println("¿Es usted Hombre (Escriba 1) o Mujer (Escriba 2)?");
	x=teclado.nextInt();
	Entrenador entrenador = new Entrenador(nombre,apellido,ciudadDeOrigen,equipo,edad,x);
	e1 = entrenador;
	System.out.println("Felicidades "+e1.obtenerNombre()+", ya eres un Entrenador Pokemon");
    }

    /**
     * Permite crear a los 2 entrenadores que pelearan en duelo, tomando los datos que ingrese cada uno 
     * a razon del metodo crearEntrenador.
     * <BR>Hecho lo anterior se le pide a cada entrenador que eliga los pokemones que desea para poder realizar la 
     * batalla y estos seran guardada en alguna libre del cinturon de Pokebolas con el que cuenta cada entrenador 
     */   
    public void modoBatalla(){
	crearEntrenador();
	e2=e1;
	System.out.println();
	System.out.println("-------> SEGUNDO JUGADOR <-------");
	System.out.println();
	crearEntrenador();
	Entrenador temporal = new Entrenador(e1);
	e1=e2;
	e2=temporal;
	System.out.println();
	System.out.println(e1.obtenerNombre()+", es turno de que escogas tus Pokemon");
	e1.asignacionDePokemones();
	System.out.println();
	System.out.println("Ahora es tu turno de escoger Pokemon, "+e2.obtenerNombre());
	e2.asignacionDePokemones();
	menuPrincipal();
    }

    /**
     * Permite la elecci&oacute;n del Pokemon con el cual se  dese&eacute; pelear 
     * para cada entrenador 
     *@param e1 Entrenador para mostrar el nombre del primer entrenador 
     *@param e2 Enrtrenador para mostrar el nombre del segundo entrenador
     */ 
    public void batalla(Entrenador e1, Entrenador e2){
	System.out.println(e1.obtenerNombre()+", escoge un Pokemon para luchar");
	e1.seleccionarPokemon();
	e1.pokeBatalla = e1.p1;
	System.out.println(e2.obtenerNombre()+", escoge un Pokemon para luchar");
	e2.seleccionarPokemon();
	e2.pokeBatalla = e2.p1;
	b.accionBatalla(e1, e1.pokeBatalla, e2, e2.pokeBatalla);
    }
    
    /**
     * Muestra un menu para el/los usuario(s) antes de la pelea para que si asi se desea pueda  
     * visualizarse los datos o ficha tecnica de cada entrenador mostrando los dato que ingreso, si lo prefiere
     * para ver los pokemones con los que cuenta cada uno &oacute; si bien lo prefieren iniciar la batalla 
     * omitiendo lo anterior 
     */
    public void menuPrincipal(){
	System.out.println("\nMENÚ PRINCIPAL\n(1) Ficha de registro de "+ e1.obtenerNombre()+"\n(2) Ficha de registro de "+
			   e2.obtenerNombre()+"\n(3) Información de Pokemones pertenecientes a "+e1.obtenerNombre()+
			   "\n(4) Información de Pokemones pertenecientes a "+e2.obtenerNombre()+"\n(5) ¡A PELEAR YA!");
	int decisionMenu;
	decisionMenu = teclado.nextInt();
	switch(decisionMenu){
	case 1:
	    System.out.println(e1);
	    menuPrincipal();
	    break;
	case 2:
	    System.out.println(e2);
	    menuPrincipal();
	    break;
	case 3:
	    e1.menuInformacionPokemones();
	    menuPrincipal();
	    break;
	case 4:
	    e2.menuInformacionPokemones();
	    menuPrincipal();
	    break;
	default:
	    batalla(e1,e2);
	    break;
	}
    }

    //Metodo main para probar los metodos
    public static void main(String arg[]){
	RealizarBatalla rb = new RealizarBatalla();
	rb.modoBatalla();
    }
}