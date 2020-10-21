/**
 * Clase Tachamon es una clase que hereda algunas de la caracteristicas de  
 * la clase Pokemon  
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Random;

public class Tachamon extends Pokemon{

    private String nombreAttack;//Cadena que representara el nombre del ataque para este tipo de pokemon

    /**
     * Crea un pokemon de con los datos propios de un Pokemon de esta clase
     * donde estan definidos todas sus caracteristicas por default
     *
     */
    public Tachamon(){
	nombre="Tachamón";
	apodo="Tachamón";
	tipo="Psíquico";
	personalidad="Hiperactivo";
	tamano="Grande";
	color="Varios";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "masculino"; }
	else{ genero = "femenino"; }
	nivel = 1;
	tipoPokeDano = "Metal";
	nombreAtaqueNormal="Carga Verde";
	nombreAtaqueContinuo="Golpes De Adicto";
	nombreAtaqueSomnifero="Viaje Cósmico";
	nombreAtaqueParalizador="Tacha Concentrada";
	descripcionAtaqueN=obtenerNombre()+" le suelta un golpazo forrado de hierba al rival!!!";
	descripcionAtaqueC=obtenerNombre()+" da una serie de golpes al rival que lo dejan traumado!!!";
	descripcionAtaqueS="PAZ hermano!!!";
	descripcionAtaqueP=obtenerNombre()+" obliga que el rival se tome una pastilla!!!";
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
    public Tachamon(String name){
	nombre="Tachamón";
	apodo=name;
	tipo="Psíquico";
	personalidad="Hiperactivo";
	tamano="Grande";
	color="Varios";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "masculino"; }
	else{ genero = "femenino"; }
	nivel = 1;
	nombreAtaqueNormal="Carga Verde";
	nombreAtaqueContinuo="Golpes De Adicto";
	nombreAtaqueSomnifero="Viaje Cósmico";
	nombreAtaqueParalizador="Tacha Concentrada";
	descripcionAtaqueN=obtenerNombre()+" le suelta un golpazo forrado de hierba al rival!!!";
	descripcionAtaqueC=obtenerNombre()+" da una serie de golpes al rival que lo dejan traumado!!!";
	descripcionAtaqueS="PAZ hermano!!!";
	descripcionAtaqueP=obtenerNombre()+" obliga que el rival se tome una pastilla!!!";
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
    }

    /**
     * Crea un pokemon recibiendo como parametro un objeto de la clase Pokemon el cual Tendra las mismas 
     * caracteristicas de la clase Tachamon
     * @param t Tachamon que se usa para obtener la caracteristicas propias de un Pokemon Tachamon
     */
    public Tachamon(Tachamon t){
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