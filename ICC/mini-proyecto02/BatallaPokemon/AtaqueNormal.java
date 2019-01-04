/**
 * Clase AtaqueNormal:Define las caracteristicas que tendra un ataquenormal, cuando el pokemon haga uso de est&eacute;
 * El da&ntile;o que puede ocasionar varia de acuerdo a nivel que tenga el pokemon
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */

public class AtaqueNormal extends Ataque{

    private int contadorNivel;//Entero que se usa para que se pueda emplear de manera adecuada cuando un Pokemon aumente de nivel

    /**
     * Crea un ataque Pokemon, donde se señala mediante una cadena que tipo de ataque es que eneste
     * caso es un ataque norma que solo causara un da&ntilde;o de 10 al Pokemon rival
     *
     */
    public AtaqueNormal(){
	nombreAtaque = "Ataque Normal";
	dano=10;
    }

    /**
     * Crea un ataque Pokemon, donde el nombre variara segun el Pokemon que ejecute un ataque de tipo normal, adem&aacute;s 
     * de que se menciona el da&ntilde;o ocasionado 
     *
     */
    public AtaqueNormal(String nombreA, String desc, String pokeDebil){
	nombreAtaque = nombreA;
	descripcionAtaque = desc;
	tipoPokeMasDano = pokeDebil;
	dano=10;
    }

    /**
     * 
     * Metodo que se emplea regresar las caracteristicas del metodo atacar de la super clase que regresa el nombre del ataque usado,
     * el daño causado, el nombre o apodo de el Pokemon y sus puntos de vida despues del ataque
     *
     */
    public void atacar(Pokemon t){
   	super.atacar(t);
    }
}