/**
 * Clase Zazabraz es una clase que ereda algunas de la caracteristicas de  
 * la clase Pokemon  
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Random;

public class Zazabraz extends Pokemon{

    private String nombreAttack;//Cadena que representara el nombre del ataque para este tipo de pokemon

    /**
     * Crea un pokemon de con los datos propios de un Pokemon de esta clase
     * donde estan definidos todas sus caracteristicas por default
     *
     */
    public Zazabraz(){
	nombre="Zázabraz";
	apodo="Zázabraz";
	tipo="Tierra";
	personalidad="bastante tranquilo";
	tamano="Mediano";
	color="Negro";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	tipoPokeDano = "Agua";
	nombreAtaqueNormal="Golpe De Rocas";
	nombreAtaqueContinuo="Piedras Chingaquedito";
	nombreAtaqueSomnifero="Roca Lunar";
	nombreAtaqueParalizador="Sumida Mortal";
	descripcionAtaqueN=obtenerNombre()+" golpea como roca al contrario!!!";
	descripcionAtaqueC=obtenerNombre()+" le lanza piedras continuamente al rival!!!";
	descripcionAtaqueS=obtenerNombre()+" baja una piedra desde el cielo!!!";
	descripcionAtaqueP=obtenerNombre()+" se la sume al contrario!!!";
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
    }
    
    /**
     * Crea un pokemon de con los datos propios de un Pokemon de esta clase
     * donde estan definidos todas sus caracteristicas por default, con excepsi&oacute;n 
     * de el apodo que en este caso sera definido si lo desea por el entrenador
     * @param name String cadena que representara el nuevo apodo del Pokemon
     */
    public Zazabraz(String name){
	nombre="Zazabraz";
	apodo=name;
	tipo="Tierra";
	personalidad="Tranquilo pero si se le incita a pelear se pone muy bravo";
	tamano="Mediano";
	color="Negro";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	nombreAtaqueNormal="Golpe de Rocas";
	nombreAtaqueContinuo="Piedras Chingaquedito";
	nombreAtaqueSomnifero="Roca Lunar";
	nombreAtaqueParalizador="Sumida Mortal";
	descripcionAtaqueN=obtenerNombre()+" golpea como roca al contrario!!!";
	descripcionAtaqueC=obtenerNombre()+" le lanza piedras continuamente al rival!!!";
	descripcionAtaqueS=obtenerNombre()+" baja una piedra desde el cielo!!!";
	descripcionAtaqueP=obtenerNombre()+" se la sume al contrario!!!";
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
    }

    /**
     * Crea un pokemon recibiendo como parametro un objeto de la clase Zazabraz el cual tendra las mismas 
     * caracteristicas de la clase Zazabraz
     * @param t Zazabraz se usa para obtener la caracteristicas propias de un Pokemon Zazabraz
     */    
    public Zazabraz(Zazabraz t){
	nombre=t.nombre;
	apodo=t.apodo;
	tipo=t.tipo;
	personalidad=t.personalidad;
	tamano=t.tamano;
	color=t.color;
	genero=t.genero;
	nivel = 1;
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
  }
}