/**
 * La clase Pokebola contiene lo escencial para poder definir el funcionamiento de una Pokebola como la conocemos que escencialmente es poder
 * contener a un Pokemon, adem&aacute;s que puede mostrar el Pokemon que lo habita si es nesesario para poder ver si puede guardar o no a algun  
 * otro Pokemon
 * 
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 * @see Pokemon
 */

public class Pokebola{


    public Pokemon pokemonContenido;//Representa al Pokemon contenido dentro de una pokebola 
    public Pokemon pokemonLibre;//Para liberar un Pokemon
    public boolean pokebolaOcupada;//Mediante un booleano se determina si la pokebola puede ocuparse o no    

    /**
     * Crea una Pokebola con la caracteristica de que esta vacia 
     * y por lo tanto puede ocuparse
     *
     */
    public Pokebola(){
	pokemonContenido=null;
	pokebolaOcupada=false;
    }

    /**
     * Permite ocupar la Pokebola con un objeto de la clase Pokemon si la Pokebola esta vacia(false) permite 
     * guardar un Pokemon dentro de ella, asiendo esto que ahora la pokebola contenga un objeto de la clase Pokemon
     * y que ahora ya no permita guardar Pokemon alguno
     */
    public void ocuparPokebola(Pokemon p){
	if(pokebolaOcupada==true){
	} else {
	    pokemonContenido=p;
	    pokebolaOcupada=true;
	}
    }


    /**
     * Crea un mensaje para imprimir el Pokemon contenido en la Pokebola &oacute; si la Pokebola esta vacia
     *@return Si la pokebola esta ocupada muestra el apodo del pokemon contenido 
     *@return Si la pokebola esta vacia indica que no hay Pokemon alguno dentro de ella
     */
    public String toString(){
	if(pokebolaOcupada==true){ return "En esta pokebola vive "+pokemonContenido.obtenerApodo(); }
	else{ return "Aún no vive nadie en esta pokebola"; }
    }
}