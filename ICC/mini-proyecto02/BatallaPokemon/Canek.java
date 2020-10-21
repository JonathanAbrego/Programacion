/**
 * Clase Canek es una clase que ereda algunas de la caracteristicas de  
 * la clase Pokemon  
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Random;

public class Canek extends Pokemon{

    private String nombreAttack;//Cadena que representara el nombre del ataque para este tipo de pokemon

    /**
     * Crea un pokemon de con los datos propios de un Pokemon de esta clase
     * donde estan definidos todas sus caracteristicas por default
     *
     */
    public Canek(){
	nombre="Canek";
	apodo="Canek";
	tipo="Eléctrico";
	personalidad="Activa";
	tamano="Mediano";
	color="Blanco";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	nombreAtaqueNormal="Madriza";
	nombreAtaqueContinuo="Toques Sónicos";
	nombreAtaqueSomnifero="Toque Aturdidor";
	nombreAtaqueParalizador="Rayo Siniestro";
	tipoPokeDano = "Agua";
	descripcionAtaqueN=obtenerNombre()+" reparte un golpe tan intenso que parece granadero en Tepito!!!";
	descripcionAtaqueC=obtenerNombre()+" lanza unos rayos tan intensos que dejan electrificado al rival!!!";
	descripcionAtaqueS=obtenerNombre()+" lanza un rayo que deja inconsciente al rival!!!";
	descripcionAtaqueP=obtenerNombre()+" lanza un rayo concentrado sobre el coxis del rival!!!";
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
    public Canek(String name){
	nombre="Canek";
	apodo=name;
	tipo="Eléctrico";
	personalidad="Activa";
	tamano="Mediano";
	color="Blanco";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	nombreAtaqueNormal="Madriza";
	nombreAtaqueContinuo="Toques Sónicos";
	nombreAtaqueSomnifero="Toque Aturdidor";
	nombreAtaqueParalizador="Rayo Siniestro";
	descripcionAtaqueN=obtenerNombre()+" reparte un golpe tan intenso que parece granadero en Tepito!!!";
	descripcionAtaqueC=obtenerNombre()+" lanza unos rayos tan intensos que dejan electrificado al rival!!!";
	descripcionAtaqueS=obtenerNombre()+" lanza un rayo que deja inconsciente al rival!!!";
	descripcionAtaqueP=obtenerNombre()+" lanza un rayo concentrado sobre el coxis del rival!!!";
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
    }

    /**
     * Crea un pokemon recibiendo como parametro un objeto de la clase Canek el cual tendra las mismas 
     * caracteristicas de la clase Canek
     * @param t Canek se usa para obtener la caracteristicas propias de un Pokemon Canek
     */  
    public Canek(Canek t){
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