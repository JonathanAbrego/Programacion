/**
 * Clase AtaqueContinuo:Define las caracteristicas que tendra un ataque del tipo continuo, cuando el pokemon haga uso de est&eacute;
 * El da&ntile;o que puede ocasionar varia de acuerdo a nivel que tenga el pokemon
 *La caracteristica de un ataque continuo es que sigue da&ntilde;ando al pokemon enemigo durante 3 turnos.
 *
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
public class AtaqueContinuo extends Ataque{


    /**
     * Crea un ataqueContinuo Pokemon, todos los ataques comenzar&aacute;n con un valor por default, sin importar el tipo que sea
     * <BR>El da&ntilde;o inicial (de nivel 1) es de 10, lo cual le causa un descenso de 10 puntos en los puntos de vida de 
     * un Pokemon; este da&ntilde;ara al Pokemon contrario durante 3 turnos seguidos.
     * <BR>El nivel por el que comienza un ataque siempre es de 1.
     */
    public AtaqueContinuo(){
	nombreAtaque = "Ataque Continuo";
	dano=10;
	contadorAtaque=3;
    }
     /**
     * Crear el ataque continuio donde mostrara el nombre y su descripcion del ataque segun cual sea usado,
     * la descripcion sera de manera muy general donde solo variara el tipo
     * <BR>El da&ntilde;o se inicializa en 10, y este aumenta conforme lo hace el nivel. Adem&aacute;s de que
     * se inicializa siempre el nivel se inicializa en 1 
     *
     * @param desc String
     * @param nombreA String
     */    
    public AtaqueContinuo(String nombreA, String desc, String pokeDebil){
	nombreAtaque = nombreA;
	descripcionAtaque = desc;
	tipoPokeMasDano = pokeDebil;
	dano=10;
	contadorAtaque=3;
    }
    
    /**
     * Metodo que obtiene las caracteristicas de el metodo atacar que se haya en la super clase Ataque y que en est&aacute;
     * caso el metodo se esta empleando en un objeto de la clase Pokemon
     *
     * @param t Pokemon para contar las veces que re repetira el ataque 
     */
    public void atacar(Pokemon t){
   	super.atacar(t);
	super.subirNivelAtaque();
	t.contadorAtaqueContinuo=contadorAtaque;
    }
}