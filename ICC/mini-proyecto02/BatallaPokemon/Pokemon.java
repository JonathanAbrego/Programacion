/**
 * La clase Pokemon determina las caracteristicas principales que tendra un Pokemon, en esta se definiran el nombre, su tipo
 * y los puntos de vida que tendran(estos seran los mismo para todos los Pokemones en general, es decir; ningun Pokemon podra
 * iniciar ninguna batalla con m&aacute;s de 100 puntos de vida que son los que estan por default),el genero del Pokemon se 
 * definira de manera aleatoria y por &uacute;ltimo permite darle un apodo si asi se desea a nuestro Pokemon
 * 
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Scanner;
import java.util.Random;

public class Pokemon{


    protected String nombre;//Cadena que representa el nombre del entrenador 
    protected String tipo;//Cadena que indca el tipo que es el pokemon 
    protected byte nivel;//Byte que indicara el nivel que tiene el Pokemon

    protected String apodo;//Cadena que representara el apodo dado al Pokemon
    protected int puntosVida;//Entero que indica la cantidad de Puntos de vida del Pokemon

    protected String personalidad;//Cadena que indicara el tipo de personalidad que tiene un Pokemon
    protected String tamano;//Cadena que indicara el tamaño de un Pokemon
    protected String genero;//Cadena que mostrara que genero es el Pokemon
    protected String color;//Cadena que indicara el color que tiene un Pokemon

    public boolean estaDormido;//Boleano que verificara si el Pokemon se encuentra dormido 
    public boolean estaParalizado;//Boleano que verificara si el Pokemon ha sido paralizado
    protected String nombreAtaqueNormal;//Cadena 
    protected String nombreAtaqueContinuo;//Cadena
    protected String nombreAtaqueSomnifero;//Cadena
    protected String nombreAtaqueParalizador;//Cadena
    protected String descripcionAtaqueN;//Cadena que representa la descripcion del ataque normal
    protected String tipoPokeDano;//Cadena que reprsenta el tipo al que pertenece el Pokemon
    protected String descripcionAtaqueC;//Cadena que representa la descripcion del ataque continuo
    protected String descripcionAtaqueS;//Cadena que representa la descripcion del ataque somnifero
    protected String descripcionAtaqueP;//Cadena que representa la descripcion del ataque paralizador
    public int contadorAtaqueContinuo;//Entero que verifica las veces que se repetira el ataque 
    public int contadorAtaqueSomnifero;//Entero que cuenta las veces que un Pokemon esta dormido
    public int contadorAtaqueParalizador;//Entero que cuenta los turnos que estara paralizado el Pokemon

    /**
     * Crea un pokemon con las caracteristicas necesarias donde se inicializan sus valores 
     * y sus estados , es decir que no esta dormido ni paralizado, adem&aacute;s el genero 
     * se determina de forma aleatoria 
     */  
    public Pokemon(){
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "masculino"; }
	else{ genero = "femenino"; }
	nivel = 1;
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
	contadorAtaqueContinuo=0;
	contadorAtaqueSomnifero=0;
	contadorAtaqueParalizador=0;
    }

      /**
     * Obtiene el nombre del Pokemon
     * @return el nombre del pokemon
     */
    public String obtenerNombre(){
	return nombre;
    }
    
    /**
     * Obtiene el apodo dado a el Pokemon
     * @return el apodo del pokemon
     */
    public String obtenerApodo(){
	return apodo;
    }
    
    /**
     * Obetiene a que tipo pertenece el pokemon
     * @return el tipo que es el pokemon
     */
    public String obtenerTipo(){
	return tipo;
    }

    /**
     * Obtiene el color de pokemon
     * @return el color que tiene el pokemn
     */
    public String obtenerColor(){
	return color;
    }

    /**
     * Obtien el nivel actual del pokemon
     * @return el nivel que tiene el pokemon
     */
    public byte obtenerNivel(){
	return nivel;
    }

    /**
     * Obtiene la personalidad del Pokemon
     * @return la personalidad del Pokemon
     */
    public String obtenerPersonalidad(){
	return personalidad;
    }

    /**
     * Obtiene el tamaño que tiene el Pokemon
     * @return el tamaño del pokemon
     */
    public String obtenerTamano(){
	return tamano;
    }

    /**
     * Obtiene el genero del pokemon 
     * @return el genero del pokemon
     */
    public String obtenerGenero(){
	return genero;
    }
    
    /**
     * Obtien lops puntos de vida del pokemn
     * @return los puntos de vida 
     */
    public int obtenerPuntosVida(){
	return puntosVida;
    }
    
    /**
     * Obtiene el apodo dado por el entrenado  al pokemon
     * @return el nuevo apodo del pokemon
     */
    public void cambiarApodo(){
	Scanner nuevoApodo = new Scanner(System.in);
	apodo = nuevoApodo.next();
    }
    
    /**
     * Obtiene los datos generales del pokemon
     * @return  en forma de cadena y de una manera mas adecuada los datos del pokemon 
     */
   
    public String toString(){
	return "___________________________________________\n\n\t"+apodo+"\n\n  "+nombre+", Pokemon de tipo "+tipo+
	    "\n  Color: "+color+"\n  Nivel "+nivel+"\n  Es un Pokemon "+personalidad+"\n  Tamaño: "+tamano+"\n  Género "
	    +genero+"\n\n  ATAQUES:\n  Normal: "+nombreAtaqueNormal+"\n  Continuo: "+nombreAtaqueContinuo+"\n  Somnífero: "
	    +nombreAtaqueSomnifero+"\n  Paralizador: "+nombreAtaqueParalizador+
	    "\n___________________________________________";
    }
} 

