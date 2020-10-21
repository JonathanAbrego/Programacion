/**
 *Clase UsaRobotEnTablero sirve para colocar en un tablero de 4x4 al robot 
 *el cual tiene 16 puntos de vida y conforme recorra una casilla puede perder 
 *1 punto solo por visitar la casilla y si llega a encontrarse una trampa perdera
 *4 puntos, y en dado caso de encontra una capsula de enegia ganara 1 punto por &uacute;ltimo 
 *si llegase a topar con un obtaculo no podra avanza y por lo tanto solo se le restara 1 punto 
 *@author Abrego Alvarez Jonathan
 *@author Mart&iacute;nez Anaya Luis Angel
 *@version 1.0
 */

public class UsarRobotEnTablero{

    public static void main(String arg[]){
	Robot robotin=new Robot();
	TableroDeRobot nuevo=new TableroDeRobot(4,false);
	robotin.misDatos();
	for(int i=0;i<=1;i++){
	    nuevo.colocarRobot(robotin);
	for(int j=0;j<=10;i++){
	    System.out.println(nuevo);
	    nuevo.limpiarTablero();
	    nuevo.opciones();
	    nuevo.eligeDireccion(robotin);
	    nuevo.verificaSiCaeEnEnergia(robotin);
	    nuevo.verificaSiCaeEnTrampa(robotin);
	    nuevo.verificaCasilla(robotin);
	    nuevo.verificaSiEsObstaculo(robotin);
	    if(robotin.puntosDeVida<=0){
		System.out.println("Te haz quedado sin vida");
	        System.out.println("Por lo tanto no se puede continuar, vuelve a intentarl, a continuacion te mostramos la forma como estaba rellenado el tablero, bye");
		nuevo.rellenarTablero();
		System.out.println(nuevo);
		break;
	    }

	}
	}
    }
}