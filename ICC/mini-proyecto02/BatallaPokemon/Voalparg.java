/**
 * Clase Voalparg es una clase que ereda algunas de la caracteristicas de  
 * la clase Pokemon  
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Random;

public class Voalparg extends Pokemon{

    private String nombreAttack;//Cadena que representara el nombre del ataque para este tipo de pokemon

    /**
     * Crea un pokemon de con los datos propios de un Pokemon de esta clase
     * donde estan definidos todas sus caracteristicas por default
     *
     */
    public Voalparg(){
	nombre="Voalparg";
	apodo="Voalparg";
	tipo="Metal";
	personalidad="Frío y distante";
	tamano="Grande";
	color="Rojo";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	tipoPokeDano = "Eléctrico";
	nombreAtaqueNormal="Azotón De Fierros";
	nombreAtaqueContinuo="Frenesí Metálico";
	nombreAtaqueSomnifero="la Dormilona";
	nombreAtaqueParalizador="Azotón Dioro";
	descripcionAtaqueN=obtenerNombre()+" le pega unos buenos fierrazos al contrario!!!";
	descripcionAtaqueC=obtenerNombre()+" suelta unos derechazos al rival a ratos!!!";
	descripcionAtaqueS=obtenerNombre()+" se la aplica al rival!!!";
	descripcionAtaqueP=obtenerNombre()+" deja paralizado al rival por el gran azote que le hizo dar!!!";
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
    public Voalparg(String name){
	nombre="Voalparg";
	apodo=name;
	tipo="Metal";
	personalidad="Frío y distante";
	tamano="Grande";
	color="Rojo";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	nombreAtaqueNormal="Azotón De Fierros";
	nombreAtaqueContinuo="Frenesí Metálico";
	nombreAtaqueSomnifero="la Dormilona";
	nombreAtaqueParalizador="Azotón Dioro";
	descripcionAtaqueN=obtenerNombre()+" le pega unos buenos fierrazos al contrario!!!";
	descripcionAtaqueC=obtenerNombre()+" suelta unos derechazos al rival a ratos!!!";
	descripcionAtaqueS=obtenerNombre()+" se la aplica al rival!!!";
	descripcionAtaqueP=obtenerNombre()+" deja paralizado al rival por el gran azote que le hizo dar!!!";
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
    }

    /**
     * Crea un pokemon recibiendo como parametro un objeto de la clase Voalparg el cual tendra las mismas 
     * caracteristicas de la clase Voalparg
     * @param t Canek se usa para obtener la caracteristicas propias de un Pokemon Voalparg
     */    
    public Voalparg(Voalparg t){
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