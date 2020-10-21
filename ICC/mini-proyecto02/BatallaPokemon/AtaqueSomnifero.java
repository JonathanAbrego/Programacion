/**
 * Clase AtaqueSomnifero: Define las caracteristicas principales que debe tomar el ataque de un Pokemon.
 * Est&eacute; ataque de no causa algun da&ntilde;o pero lo que lo diferencia de los otros tipos de ataques es  
 * permite que cuando un Pokemon lo use en batalla pueda dormir a su rival durnate 3 turnos continuos
 * Cada ataque es diferente en un Pokemon, por lo cual es nombrado de diferente manera, para poder diferenciarlos entre sí.
 * 
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */

public class AtaqueSomnifero extends Ataque{

    private byte contadorSomnifero;//Byte que es empelado para ayudar a determinar los turno que estara dormido el Pokemon 

   /**
     *Crea un ataqueSomniferoParalizador, todos los ataques comenzar&aacute;n con un valor por default, sin importar el tipo que sea
     *<BR>Este tipo de ataques no causa da&ntilde;o directo a los puntos de vida del enemigo, si no mas bien duerme al Pokemon durante 3 turnos
     *
     */
    public AtaqueSomnifero(){
	nombreAtaque = "Ataque Somnífero";
	dano=0;
	contadorAtaque=3;
	contadorSomnifero=3;
    }

    /**
     *Crea un ataqueSomnifero, en este caso en nombre del ataque sera de acuerdo al pokemon que lo este empleando
     *<BR>Este tipo de ataques no causa da&ntilde;o directo a los puntos de vida del enemigo, si no mas bien lo duerme al rival durante 3 turnos
     *@param nombreA String 
     *@param desc String
     */ 
    public AtaqueSomnifero(String nombreA, String desc, String pokeDebil){
	nombreAtaque = nombreA;
	descripcionAtaque = desc;
	tipoPokeMasDano = pokeDebil;
	dano=0;
	contadorAtaque=3;
	contadorSomnifero=3;
	contadorNivel=0;
    }

    /**
     * Metodo que obtiene las caracteristicas de el metodo atacar que se haya en la super clase Ataque y que en est&aacute;
     * caso el metodo se esta empleando en un objeto de la clase Pokemon
     *
     * @param t Pokemon para contar las veces que re repetira el ataque 
     */
    public void atacar(Pokemon t){
   	super.atacar(t);
	t.contadorAtaqueSomnifero=contadorAtaque;
	super.subirNivelAtaque();
    }
}