/**
 * Clase Ataque: Define las acciones principales que debe tomar el ataque de un Pokemon.
 * El ataque de un Pokemon causa un da&ntilde;o a otro Pokemon, al igual tiene un nivel, el cual es importante, ya que 
 * el nivel de un ataque determina la cantidad de da&ntilde;o que causa el ataque.
 * Cada ataque es diferente en un Pokemon, por lo cual es nombrado de diferente manera, para poder diferenciarlos entre sí.
 * 
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */

public class Ataque{

    protected String nombreAtaque;//Cadena que representa el nombre del ataque del Pokemon
    protected byte dano;//Entero que representa la cantidad de daño que causa el ataque, bajando los puntos de vida de un Pokemon durante una batalla
    protected byte nivelAtaque;//Entero que representa el nivel de cierto ataque de un Pokemon
    protected String descripcionAtaque;//Da una cadena describiendo el taque empleado
    protected int contadorNivel;//Entero que determina el nivel del Pokemon
    protected byte contadorAtaque;//Ayuda a contar las veces que se realiza un ataque continuo
    protected String tipoPokeMasDano;//Cadena que dice cuando aun Pokemon le afecta mas el daño del contrario debido a su tipo

    /**
     * Crea un ataque Pokemon, todos los ataques comenzar&aacute;n con un valor por default, sin importar el tipo que sea
     * <BR>El da&ntilde;o inicial (de nivel 1) es de 10, lo cual le causa un descenso de 10 puntos en los puntos de vida de 
     * un Pokemon.
     * <BR>El nivel por el que comienza un ataque siempre es de 1.
     */

    public Ataque(){
	dano=10;
	nivelAtaque=1;
    }

    /**
     * Obtiene la cantidad de da&ntilde;o que causa un ataque Pokemon
     * @return La cantidad de da&ntilde;o del ataque
     */

    public byte obtenerDano(){
	return dano;
    }

    /**
     * Obtiene el nombre de un ataque Pokemon
     * @return El nombre por el que se conoce al ataque
     */

    public String obtenerNombreAtaque(){
	return nombreAtaque;
    }

    /**
     *Obtiene la descripcion del ataque que emplea un Pokemon
     *@return descripcion del atque;
     */
    public String obtenerDescripcionAtaque(){
	return descripcionAtaque;
    }

    /**
     * Permite que un Pokemon pueda atacar a otro durante una batalla, descendiendo los puntos de vida de la v&iacute;ctima
     * Pokemon.
     * <BR> Indica en pantalla al usuario el nombre del ataque el cual se hace sobre otro Pokemon.
     * <BR> Ejecuta el ataque y a continuaci&oacute;n muestra en pantalla los puntos de vida restantes del Pokemon afectado.
     * @param t Pokemon sobre el cual el ataque se va a ejecutar
     */

    public void atacar(Pokemon t){
	if(t.obtenerTipo()==tipoPokeMasDano){
	    dano*=2;
	    System.out.println("El ataque se hace más fuerte contra este tipo de Pokemon");
	}
	System.out.println("Has ejecutado "+obtenerNombreAtaque()+"\nEl ataque le causa un daño de "+obtenerDano()+" a "+
			   t.obtenerApodo()+":\n"+obtenerDescripcionAtaque());
	t.puntosVida-=dano;
	contadorNivel++;
	System.out.println("Los puntos de vida restantes de "+t.obtenerApodo()+" son " +t.obtenerPuntosVida());
    }

    /**
     * Permite que un Pokemon eleve su nivel de atque al cumplir ciertas condiciones 
     * y por lo tanto al subir su nivel de ataque, aumenta su nivel de da&ntilde;o que 
     * ocasiona hacia otro Pokemon
     *
     */
    public void subirNivelAtaque(){
	if(contadorNivel==5){
	    nivelAtaque++;
	    System.out.println("El ataque "+obtenerNombreAtaque()+" ha subido de nivel");
	    contadorNivel=0;
	    dano+=5;
	} else {
	    nivelAtaque=nivelAtaque;
	}
    }
}