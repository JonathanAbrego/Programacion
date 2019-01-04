/**
 * Clase BatallaUsando2Pokemon: Define las acciones principales que va a tener una batalla que sera de 2Pokemones vs. 2Pokemones.
 * 
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 * @see Entrenador
 * @see Pokemon
 */
import java.util.Scanner;

public class BatallaUsando2Pokemon{

    private Entrenador e1, e2;//Atributo de tipo Entrenador para poder crear los 2 entrenadores requeridos para la batalla
    private Pokemon pokeBatalla1, pokeBatalla2;//Atributo tipo Pokemon para poder realizar las 2 batallas requeridas
    private int turno;//Entero que representaran algunos datos del entrenador y tambien el turno que corresponde a cada entrenador 
    private int numeroPokebola=0;//Entero que se usa para ver poder seleccionar le numero de pokebola a elegir
    private int num2=0;//Entero que determina
    private Scanner teclado = new Scanner(System.in);    

    public BatallaUsando2Pokemon(){
    }
    /** 
     * Permite que ya despues de haber creado a los dos jugadores que y hecho la elecci&oacute;n del Pokemon 
     * elegir el tipo de ataque que realizara su Pokemon que se haya dentro del campo de batalla,
     * adem&aacute;s de que dentro de este tiene las caracteristicas pertinentes de cada ataque;
     *<PRE>
     *1--->Ataque Normal
     *2--->Ataque Continuo 
     *3--->Ataque Somnifero
     *4--->Ataque Paralizador
     *<PRE>
     */
    public void accionBatalla(Entrenador e1, Pokemon poke1, Entrenador e2, Pokemon poke2){
	System.out.println(e1.obtenerNombre()+" escoge el ataque para "+poke1.obtenerApodo()+"\n(1) Realizar "
			   +poke1.nombreAtaqueNormal+"\n(2) Realizar "+poke1.nombreAtaqueContinuo+"\n(3) Realizar "
			   +poke1.nombreAtaqueSomnifero+"\n(4) Realizar "+poke1.nombreAtaqueParalizador+
			   "\n(5) Cambiar de Pokemon");
	if(poke1.contadorAtaqueSomnifero!=0){
	    System.out.println(poke1.obtenerApodo()+": 'zZzZzZz'");
	    poke1.contadorAtaqueSomnifero--;
	}
	else if(poke1.contadorAtaqueParalizador!=0){
	    System.out.println("¡"+poke1.obtenerApodo()+" sigue paralizado!");
	    poke1.contadorAtaqueParalizador--;
	}
	else{ 
	    int numAtaque = teclado.nextInt();
	    switch(numAtaque){
	    case 1:
		if(poke1.contadorAtaqueContinuo!=0){
		    System.out.println(poke1.obtenerApodo()+" sigue recibiendo daño por el ataque continuo");
		    poke1.puntosVida-=10;
		    System.out.println("Puntos de vida de "+poke1.obtenerApodo()+": "+poke1.obtenerPuntosVida());
		    poke1.contadorAtaqueContinuo--;
		}
		AtaqueNormal normal = new AtaqueNormal(poke1.nombreAtaqueNormal, poke1.descripcionAtaqueN, 
						       poke1.tipoPokeDano);
		normal.atacar(poke2);
		break;
	    case 2:
		if(poke1.contadorAtaqueContinuo!=0){
		    System.out.println(poke1.obtenerApodo()+" sigue recibiendo daño por el ataque continuo");
		    poke1.puntosVida-=10;
		    System.out.println("Puntos de vida de "+poke1.obtenerApodo()+": "+poke1.obtenerPuntosVida());
		    poke1.contadorAtaqueContinuo--;
		}
		AtaqueContinuo continuo = new AtaqueContinuo(poke1.nombreAtaqueContinuo,poke1.descripcionAtaqueC,
							     poke1.tipoPokeDano);
		continuo.atacar(poke2);
		break;
	    case 3:
		if(poke1.contadorAtaqueContinuo!=0){
		    System.out.println(poke1.obtenerApodo()+" sigue recibiendo daño por el ataque continuo");
		    poke1.puntosVida-=10;
		    System.out.println("Puntos de vida de "+poke1.obtenerApodo()+": "+poke1.obtenerPuntosVida());
		    poke1.contadorAtaqueContinuo--;
		}
		AtaqueSomnifero somni = new AtaqueSomnifero(poke1.nombreAtaqueSomnifero,poke1.descripcionAtaqueS,
							    poke1.tipoPokeDano);
		somni.atacar(poke2);
		break;
	    case 4:
		if(poke1.contadorAtaqueContinuo!=0){
		    System.out.println(poke1.obtenerApodo()+" sigue recibiendo daño por el ataque continuo");
		    poke1.puntosVida-=10;
		    System.out.println("Puntos de vida de "+poke1.obtenerApodo()+": "+poke1.obtenerPuntosVida());
		    poke1.contadorAtaqueContinuo--;
		}
		AtaqueParalizador paraliza = new AtaqueParalizador(poke1.nombreAtaqueParalizador,poke1.descripcionAtaqueP,
								   poke1.tipoPokeDano);
		paraliza.atacar(poke2);
		break;
	    default:
		System.out.println("Se ha guardado a "+poke1.obtenerApodo());
		for(int n=0;n<e1.numPokemones;n++){
		    if(e1.cinturon[n].pokebolaOcupada==false){
			e1.cinturon[n].ocuparPokebola(poke1);
			poke1=null;
			e1.p1=null;
		    }
		}
		e1.seleccionarPokemon();
		poke1 = e1.p1;
		break;
	    }
	}
	if(poke2.puntosVida<=0){
	    e2.pokemonesPosibles--;
	    if(e2.pokemonesPosibles==0){ System.out.println(e2.obtenerNombre()+" ya no tiene más Pokemones" +
							    "\nAsí que "+e1.obtenerNombre()+" ha ganado"); }
	    else {
		e2.seleccionarPokemon();
		poke2=e2.p1;
		accionBatalla(e2,poke2,e1,poke1);
	    }
	}
	else if(poke1.puntosVida<=0){ 
	    e1.pokemonesPosibles--;
	    if(e1.pokemonesPosibles==0){ System.out.println(e1.obtenerNombre()+" ya no tiene más Pokemones" +
							    "\nAsí que "+e2.obtenerNombre()+" ha ganado"); }
	    else {
		e1.seleccionarPokemon();
		poke1=e1.p1;
		accionBatalla(e1,poke1,e2,poke2);
	    }
	}
	else{ accionBatalla(e2,poke2,e1,poke1); }
    }
}