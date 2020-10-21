/**
 * Clase AtaqueParalizador: Define las acciones principales que debe tomar el ataque de un Pokemon.
 * El ataque paralizador de un Pokemon a direfencia de otros no causa da&ntilde;o alguno a otro Pokemon, pero tiene  como caracteristica 
 * que paraliza al rival durante 3 turnos haciendole imposible que ataque hasta el termino de estos turnos.
 * 
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
public class AtaqueParalizador extends Ataque{

    private byte tiempoParalizacion;//byte es empleado para verificar el tiempo o turnos que un pokemon estara bajo los efectos de este tipo de ataque
    private byte contadorParalizacion;//es usado para poder contar los turnos que permanece inmovil el rival

    /**
     *Crea un ataqueParalizador, todos los ataques comenzar&aacute;n con un valor por default, sin importar el tipo que sea
     *<BR>Este tipo de ataques no causa da&ntilde;o directo a los puntos de vida del enemigo, si no mas bien lo inmobiliza durante 3 turnos
     *
     */
    public AtaqueParalizador(){
	nombreAtaque = "Ataque Paralizador";
	dano=0;
	contadorAtaque=3;
	tiempoParalizacion=3;
	contadorParalizacion=3;
    }

    /**
     *Crea un ataqueParalizador, todos los ataques comenzar&aacute;n con un valor por default, sin importar el tipo que sea
     *<BR>Este tipo de ataques no causa da&ntilde;o directo a los puntos de vida del enemigo, si no mas bien lo inmobiliza durante 3 turnos
     *
     */
    public AtaqueParalizador(String nombreA, String desc, String pokeDebil){
	nombreAtaque = nombreA;
	descripcionAtaque = desc;
	tipoPokeMasDano=pokeDebil;
	dano=0;
	contadorAtaque=3;
	tiempoParalizacion=3;
	contadorParalizacion=3;
	contadorNivel=0;
    }

    /**
     *Es un metodo usado para poder modificar el nombre de el ataque, adem&aacute; que muestra todo lo que es propio de un ataque
     *<BR>Este tipo de ataque no es como los otros este no cambia el da&ntilde;o puesto que no es propio de el
     *@param t Pokemon que es usado para poder obtener de el el nombre de su ataque empleado 
     */
    public void atacar(Pokemon t){
   	super.atacar(t);
	t.contadorAtaqueParalizador=contadorAtaque;
	super.subirNivelAtaque();
    }
}