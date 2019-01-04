/**
 * Clase CartaMayor: Permite al usuario jugar una partida del juego Carta Mayor contra la computadora.
 * La ejecuci&oacute;n del juego va de la siguiente forma:
 * <BR> Se tiene una baraja inglesa con las cartas revueltas
 * <BR> Se le es asignada una carta al usuario, la cual es la primera
 * <BR> La computadora escoge una carta al azar
 * <BR> Se determina al ganador de la partida comparando los valores de las cartas escogidas
 * Cabe destacar que la forma en que las formas que se imprimen las cartas es la siguiente:
 * <BR> [X-Y]
 * Donde X representa un valor en la carta, los cuales pueden ser 2,3,4,5,6,7,8,9,10,J,Q,K,A
 * Y representa el tipo de la carta, los cuales pueden ser:
 * <BR> P - Picas
 * <BR> T - Tréboles
 * <BR> C - Corazones
 * <BR> D - Diamantes
 *
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */

import java.util.Random;

public class CartaMayor extends BarajaInglesa{

    Carta cartaEscogida; // carta que representa la carta que fue asignada al usuario
    Carta cartaComputadora; // carta que representa la carta que ha escogido la computadora en una partida
    int valorCartaUsuario; // entero que representa el valor real de la carta que tiene el usuario
    int valorCartaComputadora; // entero que representa el valor real de la carta que tiene la computadora
    Random aleatorio = new Random();

    public CartaMayor(){
    }

    /**
     * Determina la carta que le es asignada al usuario en una partida de Carta Mayor
     * La carta asignada al usuario siempre es la primera que aparece en pantalla
     */

    public void obtenerCartaUsuario(){
	System.out.println("Tu carta es "+obtenerCarta(1));
	cartaEscogida = carta[0];
    }

    /**
     * Determina la carta que le es asignada a la computadora en una partida de Carta Mayor
     */

    public void obtenerCartaComputadora(){
	int x = aleatorio.nextInt(52);
	System.out.println("La carta que ha escogido la computadora es "+obtenerCarta(x));
	cartaComputadora = carta[x-1];
    }

    /**
     * Determina el valor real de la carta del usuario en una partida de Carta Mayor
     * @param c Carta a la cual se le va a determinar el valor
     */

    public void determinarValorCartaUsuario(Carta c){
	if(c.identificador()=="2"){ valorCartaUsuario=2; }
	else if(c.identificador()=="3"){ valorCartaUsuario=3; }
	else if(c.identificador()=="4"){ valorCartaUsuario=4; }
	else if(c.identificador()=="5"){ valorCartaUsuario=5; }
	else if(c.identificador()=="6"){ valorCartaUsuario=6; }
	else if(c.identificador()=="7"){ valorCartaUsuario=7; }
	else if(c.identificador()=="8"){ valorCartaUsuario=8; }
	else if(c.identificador()=="9"){ valorCartaUsuario=9; }
	else if(c.identificador()=="10"){ valorCartaUsuario=10; }
	else if(c.identificador()=="J"){ valorCartaUsuario=11; }
	else if(c.identificador()=="Q"){ valorCartaUsuario=12; }
 	else if(c.identificador()=="K"){ valorCartaUsuario=13; }
	else if(c.identificador()=="A"){ valorCartaUsuario=14; }
    }

    /**
     * Determina el valor real de la carta que le fue asignada a la computadora en una partida de Carta Mayor
     * @param c Carta a la cual se le va a determinar el valor
     */

    public void determinarValorCartaComputadora(Carta c){
	if(c.identificador()=="2"){ valorCartaComputadora=2; }
	else if(c.identificador()=="3"){ valorCartaComputadora=3; }
	else if(c.identificador()=="4"){ valorCartaComputadora=4; }
	else if(c.identificador()=="5"){ valorCartaComputadora=5; }
	else if(c.identificador()=="6"){ valorCartaComputadora=6; }
	else if(c.identificador()=="7"){ valorCartaComputadora=7; }
	else if(c.identificador()=="8"){ valorCartaComputadora=8; }
	else if(c.identificador()=="9"){ valorCartaComputadora=9; }
	else if(c.identificador()=="10"){ valorCartaComputadora=10; }
	else if(c.identificador()=="J"){ valorCartaComputadora=11; }
	else if(c.identificador()=="Q"){ valorCartaComputadora=12; }
 	else if(c.identificador()=="K"){ valorCartaComputadora=13; }
	else if(c.identificador()=="A"){ valorCartaComputadora=14; }
    }

    /**
     * Determina al ganador en una partida de Carta Mayor bas&aacute;ndose en el valor de la carta
     * <BR> Si el valor de la carta asignada a la computadora es mayor que el de la carta asignada al usuario, la computadora gana el juego
     * <BR> Si el valor de la carta asignada al usuario es mayor que el de la carta asignada a la computadora, el usuario gana el juego
     * <BR> Si los valores son los mismos, hay empate
     */

    public void determinarGanador(){
	determinarValorCartaUsuario(cartaEscogida);
	determinarValorCartaComputadora(cartaComputadora);
	if(valorCartaUsuario<valorCartaComputadora){
	    System.out.println("La computadora ha ganado");
	} else if(valorCartaUsuario>valorCartaComputadora){
	    System.out.println("Has ganado");
	} else { System.out.println("Empate"); }
    }

    public static void main(String arg[]){
	CartaMayor carMay = new CartaMayor();
	carMay.asignaCartas();
	carMay.revolverBaraja();
	carMay.imprimirBaraja();
	carMay.obtenerCartaUsuario();
	carMay.obtenerCartaComputadora();
	carMay.determinarGanador();
    }
}