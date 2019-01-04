/**
 * Clase Tezclah es una clase que ereda algunas de la caracteristicas de  
 * la clase Pokemon  
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Random;

public class Tezclah extends Pokemon{

    private String nombreAttack;//Cadena que representara el nombre del ataque para este tipo de pokemon

    /**
     * Crea un pokemon de con los datos propios de un Pokemon de esta clase
     * donde estan definidos todas sus caracteristicas por default
     *
     */
    public Tezclah(){
	nombre="Tezclah";
	apodo="Tezclah";
	tipo="Fuego";
	personalidad="Serio pero bastante ingenioso";
	tamano="Pequeño";
	color="Naranja";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	tipoPokeDano = "Agua";
	nombreAtaqueNormal="Chispazo";
	nombreAtaqueContinuo="Furia Caliente";
	nombreAtaqueSomnifero="Golpe Candente";
	nombreAtaqueParalizador="Ataque Horny";
	descripcionAtaqueN=obtenerNombre()+" le suelta la chispa al rival!!!";
	descripcionAtaqueC=obtenerNombre()+" pega unos buenos flamazos al contrario, ay nanita, se sigue achicharrando!!!";
	descripcionAtaqueS="Hace calor o es cosa mía? El rival se ha quedado dormido!!!";
	descripcionAtaqueP=obtenerNombre()+" anda horny, yo cerraría los ojos, no quiero ver lo que le está haciendo al "+
	    "rival, que se ha quedado paralizado!!!";
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
    public Tezclah(String name){
	nombre="Tezclah";
	apodo=name;
	tipo="Fuego";
	personalidad="Serio pero bastante ingenioso";
	tamano="Pequeño";
	color="Naranja";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	nombreAtaqueNormal="Chispazo";
	nombreAtaqueContinuo="Furia Caliente";
	nombreAtaqueSomnifero="Golpe Caliente";
	nombreAtaqueParalizador="Ataque Horny";
	descripcionAtaqueN=obtenerNombre()+" le suelta la chispa al rival!!!";
	descripcionAtaqueC=obtenerNombre()+" pega unos buenos flamazos al contrario, ay nanita, se sigue achicharrando!!!";
	descripcionAtaqueS="Hace calor o es cosa mía? El rival se ha quedado dormido!!!";
	descripcionAtaqueP=obtenerNombre()+" anda horny, yo cerraría los ojos, no quiero ver lo que le está haciendo al "+
	    "rival, que se ha quedado paralizado!!!";
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
    }

    /**
     * Crea un pokemon recibiendo como parametro un objeto de la clase Tezclah el cual tendra las mismas 
     * caracteristicas de la clase Tezclah
     * @param t Tezclah se usa para obtener la caracteristicas propias de un Pokemon Tezclah
     */    
    public Tezclah(Tezclah t){
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