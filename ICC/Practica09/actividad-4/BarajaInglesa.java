/**
 * Clase BarajaInglesa: Representa un conjunto de cartas las cuales tienen un valor y un tipo
 * Hay cuatro tipos de carta: picas, corazones, diamantes y tr&eacute;boles
 * Hay 13 valores dierentes en cada tipo de carta: desde el dos al 10, Joto, Reina, Rey y el As
 * Para cualquier tipo de Baraja Inglesa, las cartas no var&iacute;an, ni su entorno
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0 
 */

import java.util.Random;

public class BarajaInglesa{
    
    //Atributos
    public Carta[] carta =new Carta[52]; //Arreglo que define el numero de cartas con las que vamos a trabajar
    public String[] identificador={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};//Arreglo que define a los posibles valores de una carta
  	
    /**
     * Crea una carta con los valores por default, ya que una baraja inglesa no puede variar en nada
     */

    public BarajaInglesa(){
    }

    /**
     * Asigna los valores de cada una de las cartas, de acuerdo a su posici&oacute;n en el arreglo
     */
    
    public void asignaCartas(){
	int c=0; //Se crean 3 variables para asignar tipos de cartas un vez esntrando al ciclo for
	int d=0;
	int e=0;
	for(int a=0; a<carta.length; a++){
	    if(a>=0 && a<=12){
		carta[a]=new Carta('P',identificador[a]);//Se asignan las picas y sus valores
	    } else if(a>=13 && a<=25){
		carta[a]=new Carta('D',identificador[c]);//Se asignan los diamantes con valores
		c++;
	    } else if(a>=26 && a<=38){
		carta[a]=new Carta('C',identificador[d]);//Se asignan los corazones y valores
		d++;
	    } else if(a>=39 && a<=52){
		carta[a]=new Carta('T',identificador[e]);//Se asignan los treboles con valores
		e++;
	    }
	}
    }
    
    /**
     * Imprime todas las cartas de una baraja en un formato adecuado para que el usuario pueda 
     * entender cuales cartas son las que aparecen en pantalla
     */
    
    public void imprimirBaraja(){
	for(int a=0;a<carta.length;a++){
	    System.out.print("["+carta[a].identificador()+"-"+carta[a].obtenerFrontal()+"] ");
	}
	System.out.println();
    }
    
    /**
     * Revuelve las cartas contenidas en una baraja inglesa
     */
    
    public void revolverBaraja(){
	Carta auxiliar1,auxiliar2;//Variables auxiliares que sirven para el temporal almacenamiento de una carta
	for(int i=0; i<52; i++){
	    int x=(int)(Math.random()*52+0);//Se crea un n&uacute;mero aleatorio entre 0 y 52
	    auxiliar1=new Carta(carta[x]);//El valor de la carta del numero aleatorio se guarda en el auxiliar
	    int y=(int)(Math.random()*52+0);
	    auxiliar2=new Carta(carta[y]);
	    carta[x]=auxiliar2;//Las cartas se intercambian
	    carta[y]=auxiliar1;
	}
    }

    /**
     * Se obtiene una carta de acuerdo al n&uacute;mero de carta que ocupa
     * Las posiciones van de 1 a 52
     * @param numero El numero de la carta de la cual se va a obtener su informacion
     * @return una cadena que imprime en pantalla la carta escogida
     */

    public String obtenerCarta(int numero){
	return "["+carta[numero-1].identificador()+"-"+carta[numero-1].obtenerFrontal()+"]";
    }

    /**
     * Prueba del correcto funcionamiento de la clase BarajaInglesa
     */

    public static void main(String arg[]){
	BarajaInglesa c=new BarajaInglesa();
	c.asignaCartas();
	System.out.println();
	System.out.println("BARAJA INGLESA");
	System.out.println("P-picas   C-corazones   D-diamantes   T-treboles");
	System.out.println();
	c.imprimirBaraja();
	System.out.println();
	System.out.println("Seleccionemos una carta");
	System.out.println("La carta seleccionada es "+c.obtenerCarta(3));
	System.out.println();
	System.out.println("Revolvamos la baraja");
	System.out.println();
	c.revolverBaraja();
	c.imprimirBaraja();
	System.out.println();
    }
}