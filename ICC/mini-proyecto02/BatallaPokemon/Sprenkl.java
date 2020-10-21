/**
 * Clase Sprenkl es una clase que ereda algunas de la caracteristicas de  
 * la clase Pokemon  
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Random;

public class Sprenkl extends Pokemon{

    private String nombreAttack;//Cadena que representara el nombre del ataque para este tipo de pokemon

    /**
     * Crea un pokemon de con los datos propios de un Pokemon de esta clase
     * donde estan definidos todas sus caracteristicas por default
     *
     */
    public Sprenkl(){
	nombre="Sprenkl";
	apodo="Sprenkl";
	tipo="Agua";
	personalidad="Alegre";
	tamano="Mediano";
	color="Azul";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	tipoPokeDano = "Tierra";
	nombreAtaqueNormal="Chorrillo";
	nombreAtaqueContinuo="Escupitajo";
	nombreAtaqueSomnifero="Baño Termal";
	nombreAtaqueParalizador="Golpe Acuático Chingón";
	descripcionAtaqueN="Con el nombre del ataque ya te habrás imaginado lo que sucedió";
	descripcionAtaqueC=obtenerNombre()+" decide jugar a lo Bianchi!!!";
	descripcionAtaqueS=obtenerNombre()+" baña con agua al contrario, lo dejó dormido!!!";
	descripcionAtaqueP="A webo que si!!! Qué golpe tan chingón le soltó "+obtenerNombre()+" al rival!!!";
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
    public Sprenkl(String name){
	nombre="Sprenkl";
	apodo=name;
	tipo="Agua";
	personalidad="Alegre";
	tamano="Mediano";
	color="Azul";
	Random aleatorio = new Random();
	int x = aleatorio.nextInt(2);
	if(x==0){ genero = "Masculino"; }
	else{ genero = "Femenino"; }
	nivel = 1;
	nombreAtaqueNormal="Chorrillo";
	nombreAtaqueContinuo="Escupitajo";
	nombreAtaqueSomnifero="Baño Termal";
	nombreAtaqueParalizador="Golpe Acuático Chingón";
	descripcionAtaqueN="Con el nombre del ataque ya te habrás imaginado lo que sucedió";
	descripcionAtaqueC=obtenerNombre()+" decide jugar a lo Bianchi!!!";
	descripcionAtaqueS=obtenerNombre()+" baña con agua al contrario, lo dejó dormido!!!";
	descripcionAtaqueP="A webo que si!!! Qué golpe tan chingón le soltó "+obtenerNombre()+" al rival!!!";
	puntosVida = 100;
	estaDormido=false;
	estaParalizado=false;
    }

    /**
     * Crea un pokemon recibiendo como parametro un objeto de la clase Sprenkl el cual tendra las mismas 
     * caracteristicas de la clase Sprenkl
     * @param t Sprenkl se usa para obtener la caracteristicas propias de un Pokemon Sprenkl
     */    
    public Sprenkl(Sprenkl t){
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