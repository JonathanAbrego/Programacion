/**
 * Clase Robot sirve para crear un objeto de la clase Robot con las caracter&iacute;sticas 
 * generales de un robot,aunque agregandole la caracteristica de tener puntos de vida
 * el cual se empleara en un Tablero de 4x4 para encontrar una casilla especial  
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */

import java.util.Random;
public class Robot{
    
    public String nombre;//Cadena que representara el nombre
    private String marca;//Cadena que representara la marca
    private int serie;//Entero que ayuda a determinar el numero de serie del robot
    public  int puntosDeVida;//Entero que sirve para determinar los puntos de vida del robot
    public int x;//Variable para determinar la posicion del robot
    public int y;//Variable para determinar la posicion del robot

    /**
     *Crea un robot con ciertas caracter&iacute;sticas predeterminadas 
     *como lo son sus puntos de vida, el nombre y la marca 
     *para genrar el n&uacute;mero de serie se hace de forma aleatoria 
     *por lo cual variara cada vez que se cree un nuevo robot
     *@param det TableroDeRobot lo usamos para que as&iacute; podamos emplear el robot en un tablero
     */
    public Robot(TableroDeRobot det){
	Random ran=new Random();
	int aux=ran.nextInt(1234);
	serie=aux;
	puntosDeVida=16;
	nombre="Robotin_2.0v";
	marca="CuackSony";
	
    }
    
    /**
     *Crea un robot con ciertas caracter&iacute;sticas predeterminadas 
     *como lo son sus puntos de vida, el nombre y la marca 
     *para genrar el n&uacute;mero de serie se hace de forma aleatoria 
     *por lo cual variara cada vez que se cree un nuevo robot
     */
      public Robot(){
	Random ran=new Random();
	int aux=ran.nextInt(1234);
	serie=aux;
	puntosDeVida=16;
	nombre="Robotin_2.0v";
	marca="CuackSony";
	x=2;
	y=2;
    }
    
    /**
     *Obtien el valor de X, que junto con el valor de Y representara la posicion del robot en el tablero
     *@return la posicion X
     */
    public int obtenerX(){

	return x;
    }
    
    /**
     *Obtien el valor de Y, que junto con el valor de X representara la posici&oacute;n del robot en el tablero
     *@return la posici&oacute;n Y
     */
    public int obtenerY(){

	return y;
    }
    
    /**
     *Obtiene el nombre del robot
     *@return El nombre que tiene el robot
     */
    public String obtenerNombre(){
	return nombre;
    }
    
    /**
     *Obtiene la marca del robot
     *@return La marca del robot
     */
    public String obtenerMarca(){
	return marca;
    }
    
    /**
     *Obtiene el n&uacute;mero de serie del robot, que se le dio de forma aleatoria
     *@return El n&uacute;mero de serie
     */
    public int obtenerNumSerie(){
	return serie;
    }
    
    /**
     *Obtiene los puntos de vida que tiene el Robot
     *@return Los puntos de vida 
     */
    public int obtenerPuntosDeVida(){
	return puntosDeVida;
    }
    
    /**
     * Modifica el valor de X que tiene el robot
     *@return El nuevo valor de X
     */
    public int modificarX(int dx){
	int aux=0;
	if(dx>0){
	    x=x+1;
	    aux+=x;
	    return aux;
	}
	x=x-1;
	aux+=x;
	return aux;
    }

    /**
     *Modifica el valor de Y que tiene el robot
     *@return El nuevo valor de Y
     */    
    public int modificarY(int dy){
	int aux=0;
	if(dy>0){
	    y=y+1;
	    aux+=y;
	    return aux;
	}
	y=y-1;
	aux+=y;
	return aux;
    }

    /**
     * Sirve para imprimir de una mejor manera los datos del robot,
     * ya sea el nombre, la marca, el n&uacute;mero de serie y 
     * hasta la posici&oacute;n actual en la que se haya 
     *
     */
    public void  misDatos(){
	    System.out.println("\nMi nombre es "+ nombre);
	    System.out.println("Mi numero de serie es "+ serie);
	    System.out.println("Marca "+marca);
	    System.out.println("Mis puntos de vida son: "+puntosDeVida);
	    System.out.println("Mi posicion actual es ("+x+","+y+")");
	    System.out.println("\t\\       /");
	    System.out.println("\t \\     / ");
	    System.out.println("\t  \\   / ");
	    System.out.println("\t*********  ");
	    System.out.println("\t*  | |  *");
	    System.out.println("\t*       *");
	    System.out.println("\t*       *");
	    System.out.println();
    }
  
}
