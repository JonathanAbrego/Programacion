/**
 * Clase TableroDeRobot: es una extension de la clase Tablero, simula un tablero cuadrado de una dimensi&oacute;n fija.
 * Es un tablero tipo cuadriculado, es decir se puede guardar informaci&oacute;n en cada casilla.
 * Cada casilla esta definida por una n&uacute;mero entero rengl&oacute;n y otro n&uacute;mero entero  columna. Para
 * referirse a una casilla se necesita dar una pareja (rengl&oacute;n, columna).Adem&aacute,s de que en el tablero 
 * se podra colocar un robot el cual podra moverse hacia ariba,abajo, derecha o izquierda; seg&uacute;n el usuario la opci&oacute;n
 * que eliga
 * <BR><BR>
 * En particular, este tablero puede almacenar enteros. La nomenclatura usada es la siguiente:
 * <BR> 0 -> Si la casilla es vacia.
 * <BR> 2, 3, 4,9 y 13 -> Si la casilla esta ocupada.
 * <BR><BR> Le sugerimos usar los n&uacute;meros de la siguiente forma:
 * <BR>2 -> Si desea colocar una especie de  energ&iacute;a para el robot.
 * <BR>3 -> Si se refiere a un obst&aacute;culo
 * <BR>4 -> Si quiere colocar una especie de trampa.
 * <BR>9 -> Si desea colocar la casilla especial que debe encontrar el robot.
 * <BR>13-> Representara al robot el cual se movera en el tablero, adem&aacute;s en este caso solo  se podra colocar uno .
 * <BR>Se puede colocar cualquier otro n&uacute;mero en las casillas, pero procure dar su interpretaci&oacute;n en 
 * el problema que lo utiliza.
 * 
 * <BR><BR>Para crear un tablero de una cierta dimencion (digamos 10) se realiza lo siguiente:
 *
 * <BR>Tablero tablero = new Tablero(10, true);
 *
 * <BR><BR>Lo cual crea un arreglo de 10x10 casillas, es decir 100 espacios determinados por un rengl&oacute;n
 * y una columna. Y coloca en la primera y ultima columna y en el primer y ultimo rengl&oacute;n un n&uacute;mero 5
 * que es lo mismo que una pared alrededor del tablero.
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */
import java.util.Scanner;
public class TableroDeRobot extends Tablero{
    
    /**
     *Constructor que copia los mismas partes del contructor de la super clase
     *@param dimension Determinara la dimension del tablero
     *@param conPared Determina si el tablero estara sercado por una pared
     */
    public TableroDeRobot(int dimension,boolean conPared){
	super(dimension,conPared);
    }
       
    /**
     *Coloca en el tabero un obstaculo el cual sera representado por el numero 3
     *@param ren Determina el renglon en el cual estara 
     *@param colum Determina la columna en la cual se hayara
     */
    public void colocaObstaculo(int ren, int colum){
	colocarEn(ren,colum,3);
    }

    /**
     *Coloca en el tabero una  trampa la cual sera representado por el numero 4
     *@param ren Determina el renglon en el cual estara 
     *@param colum Determina la columna en la cual se hayara
     */
    public void colocarTrampa(int ren,int colum){
	colocarEn(ren,colum,4);
    }
    
    /**
     *Coloca en el tabero una capsula de energia la  cual sera representado por el numero 2
     *@param ren Determina el renglon en el cual estara 
     *@param colum Determina la columna en la cual se hayara
     */
    public void colocarEnergia(int ren,int colum){
	colocarEn(ren,colum,2);
    }
    
    /**
     *Coloca en el tabero la casilla especial que sera representado por el numero 9
     *@param ren Determina el renglon en el cual estara 
     *@param colum Determina la columna en la cual se hayara
     */
    public void colocarCasillaEspecial(int ren, int colum){
	colocarEn(ren,colum,9);
    }
    
    /**
     *Coloca en el tabero un Robot el cual sera representado por el numero 13
     *@param robotin para determinar la posicion inicial de nuestro robot
     */
    public void colocarRobot(Robot robotin){
	colocarEn(robotin.obtenerX(),robotin.obtenerY(),13);
    }

    /**
     * Modifica la posici&oacute;n del Robot haciendolo ir un renglon hac&iacute;a abajo
     * manteniendo la misma columan para as&iacute; representar que se esta moviendo hacia abajo
     */
    public void moverHaciaAbajo(Robot robotin){
	colocarEn(robotin.modificarX(1),robotin.obtenerY(),13);
    }
     
    /**
     * Modifica la posici&oacute;n del Robot haciendolo avanzar una columna a la derecha, pero
     * manteniendo su mismo renglon para as&iacute; representar que se esta moviendo hacia su derecha
     */
    public void moverHaciaLaDerecha(Robot robotin){
      	colocarEn(robotin.obtenerX(),robotin.modificarY(1),13);
    }
    
    /**
     * Modifica la posici&oacute;n del Robot haciendolo retroceder un renglon, pero
     * manteniendo la misma columan para as&iacute; representar que se esta moviendo hacia arriba
     */
    public void moverHaciaArriba(Robot robotin){
	colocarEn(robotin.modificarX(-1),robotin.obtenerY(),13);
    }	
    
    /**
     * Modifica la posici&oacute;n del Robot haciendolo retroceder una columna 
     * pero manteniendo el  mismo renglon para as&iacute; representar que se esta moviendo hacia la izquierda
     */
    public void moverHaciaLaIzquierda(Robot robotin){
       	colocarEn(robotin.obtenerX(),robotin.modificarY(-1),13);
    }	
    
 
    /**
     * Permite rellenar el tablero con obtaculos, trampas, capsulas de energia
     * y una casilla especial
     *
     */
    public void rellenarTablero(){
    	colocarObstaculo(0,1);
	colocarObstaculo(2,1);
	colocarObstaculo(3,2);
	colocarObstaculo(1,3);
	colocarEnergia(2,3);
	colocarEnergia(3,1);
	colocarEnergia(0,3);
	colocarEnergia(3,0);
	colocarEnergia(1,1);
	colocarTrampa(1,2);
	colocarTrampa(3,3);
	colocarTrampa(2,0);
	colocarTrampa(0,2);
	colocarTrampa(1,0);
	colocarCasillaEspecial(0,0);
    }
    
    /**
     *Verifica si la casilla a donde se movio el robot es un obstaculo
     *se le resta 1 por consultarla
     *@param robotin que ayuda para la poscion del robot al moverse
     */
    public void verificaSiEsObstaculo(Robot robotin){
	if((robotin.obtenerX()==0 && robotin.obtenerY()==1)||(robotin.obtenerX()==2 && robotin.obtenerY()==1)||
	   (robotin.obtenerX()==3 && robotin.obtenerY()==2)||(robotin.obtenerX()==1 && robotin.obtenerY()==3)){
	    System.out.println("Lo siento es un obstaculo y no puedes pasar por aqui");
	   
	}
    } 

    /**
     *Verifica si la casilla a donde se movio el robot es una capsula 
     *de energia de ser asi se le sumaran 2 a sus puntos de vida 
     *puesto que como se le resta 1 por visitarla pero gana 1 de los que ya tenia,
     * entonces para que gane uno mas de lo que tenia se le dan 2
     *@param robotin que ayuda para la poscion del robot al moverse
     */
    public void verificaSiCaeEnEnergia(Robot robotin){
    	if((robotin.obtenerX()==2 && robotin.obtenerY()==3)||(robotin.obtenerX()==3 && robotin.obtenerY()==1)||
	   (robotin.obtenerX()==0 && robotin.obtenerY()==3)||(robotin.obtenerX()==3 && robotin.obtenerY()==0)||(robotin.obtenerX()==1 && robotin.obtenerY()==1)){
	     robotin.puntosDeVida+=2;
	    System.out.println("En hora buena haz encontrado una capsula de energia ganas 1 punto mas de vida");
	}
    }
    
    /**
     *Verifica si la casilla a donde se movio el robot es una trampa de ser asi se le restaran 3 a sus puntos de vida 
     *puesto que como se le resta 1 por visitarla, cumple la condicion de restarle 4
     *@param robotin que ayuda para la poscion del robot al moverse
     */
    public void verificaSiCaeEnTrampa(Robot robotin){
	if((robotin.obtenerX()==1 && robotin.obtenerY()==2)||(robotin.obtenerX()==3 && robotin.obtenerY()==3)||
	   (robotin.obtenerX()==2 && robotin.obtenerY()==0)||(robotin.obtenerX()==0 && robotin.obtenerY()==2)||(robotin.obtenerX()==1 && robotin.obtenerY()==0)){
	    robotin.puntosDeVida-=3;
	    System.out.println("Lo siento haz caido en una trampa, por lo tanto pierdes 4 putnos");
	}

    }

    /**
     *Determina la opciones que se le mostraran al usuario, y asi pueda 
     *elegir hacia donde mover su robot que se haya en el tablero
     *<BR>Solo cuenta con 4 opciones; cada una con un indice ya sea 1,2,3,4
     */	  
    public void opciones(){
	System.out.println("(1)Mover el robot hacia arriba");
	System.out.println("(2)Mover el robot hacia abajo");
	System.out.println("(3)Mover el robot hacia la derecha");
	System.out.println("(4)Mover el robot hacia la izquierda");
	
	System.out.println("Si te topas con una trampa reducira tu vida 4 puntos, con una Capsula de energia aumentaras un punto tu vida ,con un obstaculo tendras que ir por otro lado y si llegas a encontrar un la casilla especial con un numero 9 habras ganado");
	
    }
    
    /**
     * Metodo que es usado para leer la opcion del usuario desde el teclado,
     * ya que segun el numero del 1 al 4 que ingrese el usuario, adem&aacute;s de que ya con introducir 
     *la opcion e ir a la casilla pierde 1 punto de vida 
     * es la orden que seguira el robot por decir un ejemplo
     *<BR>
     *<BR>Si el usuario ingresa el numero 1.
     *<BR> El robot se movera hacia arriba como esta establecido en las opciones permitidas para el usuario
     *
     */
    public void eligeDireccion(Robot robotin){
        int opcion;
      	System.out.println("Los puntos de vida de "+robotin.nombre+ " son: "+robotin.puntosDeVida);
        Scanner entrada=new Scanner(System.in);
	System.out.println("Ingresa el numero (que se encuentra a la izquierda) de la opcion que desees");
	opcion=entrada.nextInt();
      	switch(opcion){
	case 1:moverHaciaArriba(robotin);
	    robotin.puntosDeVida-=1;
	    break;
	case 2:moverHaciaAbajo(robotin);
	    robotin.puntosDeVida-=1;
	    break;
	case 3:moverHaciaLaDerecha(robotin);
	    robotin.puntosDeVida-=1;
	    break;
	case 4:moverHaciaLaIzquierda(robotin);
	    robotin.puntosDeVida-=1;
	    break;
	}
    }
    
    /**
     * Verifica si la casilla que encontramos tiene el signo especial 
     * de ser asi se mostrara el mensaje y habremos ganado
     *
     */
    public void verificaCasilla(Robot robotin){
       	if(robotin.obtenerX()==0 && robotin.obtenerY()==0){
	    System.out.println("Haz encontrado la casilla especial, marcada por un 9 por lo tanto haz ganado");
	    System.exit(1);
	}
    }
   
    /**
     * Limpia el tablero cada vez que se hace un movimiento para asi 
     * dejar en cero la casilla que ocupada el robotn
     *
     */
    public void limpiarTablero(){
	for(int i=0;i<4;i++){
	    for(int j=0;j<4;j++){
		if(tablero[i][j]==13){
		    tablero[i][j]=0;	
		}
	    }
	}
    }
}