/**
 * Clase Kraigean es una clase que ereda algunas de la caracteristicas de  
 * la clase Pokemon  
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Random;

public class Kraigean extends Pokemon{

    private String nombreAttack;//Cadena que representara el nombre del ataque para este tipo de pokemon

    /**
     * Crea un pokemon de con los datos propios de un Pokemon de esta clase
     * donde estan definidos todas sus caracteristicas por default
     *
     */
    public Kraigean(){
	nombre="Kraigean";
	apodo="Kraigean";
	tipo="Planta";
	personalidad="Sombría";
	tamano="Pequeño";
	color="Fucsia";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	tipoPokeDano = "Psíquico";
	nombreAtaqueNormal="Golpe Macabro";
	nombreAtaqueContinuo="Lanza-semilla";
	nombreAtaqueSomnifero="Bomba Dormilona";
	nombreAtaqueParalizador="Tai-Chi Estupefacto";
	descripcionAtaqueN=obtenerNombre()+" golpea al rival!!!";
	descripcionAtaqueC=obtenerNombre()+" le lanza de sus semillas al rival!!!";
	descripcionAtaqueS=obtenerNombre()+" lanza una semilla-bomba que libera un gas adormecedor!!!";
	descripcionAtaqueP=obtenerNombre()+" envía espinas al contrario que lo dejan paralizado!!!";
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
    public Kraigean(String name){
	nombre="Kraigean";
	apodo=name;
	tipo="Planta";
	personalidad="Sombría";
	tamano="Pequeño";
	color="Fucsia";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	nombreAtaqueNormal="Golpe Macabro";
	nombreAtaqueContinuo="Lanza-semilla";
	nombreAtaqueSomnifero="Bomba Dormilona";
	nombreAtaqueParalizador="Tai-Chi Estupefacto";
	descripcionAtaqueN=obtenerNombre()+" golpea al rival!!!";
	descripcionAtaqueC=obtenerNombre()+" le lanza de sus semillas al rival!!!";
	descripcionAtaqueS=obtenerNombre()+" lanza una semilla-bomba que libera un gas adormecedor!!!";
	descripcionAtaqueP=obtenerNombre()+" envía espinas al contrario que lo dejan paralizado!!!";
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
    }

    /**
     * Crea un pokemon recibiendo como parametro un objeto de la clase Kraigen el cual tendra las mismas 
     * caracteristicas de la clase Kraigen
     * @param t Kraigen se usa para obtener la caracteristicas propias de un Pokemon Kraigen
     */    
    public Kraigean(Kraigean t){
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