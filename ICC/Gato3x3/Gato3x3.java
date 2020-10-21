/**
 *Esta clase tiene la intencion de simular el juego del gato 
 *en donde la opcion se basa en ingresar la tirada con coordenadas
 *@author Abrego Alvarez Jonathan;Login: jabregoa
 *@version 1.2
 *@fecha 18 oct 2011
 */

import java.util.Scanner;  
public class Gato3x3{
    Tablero gato3x3;
    
    
    public Gato3x3(){
	gato3x3=new Tablero(false);
    } 
 
    public void colocarBola(int ren, int colum){
	gato3x3.colocarEn(ren, colum, 1);
    }
    
    public void colocarTache(int ren, int colum){
	gato3x3.colocarEn(ren, colum, 2);
    }
    
    public boolean esBola(int ren, int colum){
	return gato3x3.obtenerDe(ren, colum)==1;
    }
    
    public boolean esTache(int ren, int colum){
	return gato3x3.obtenerDe(ren, colum)==2;
    }
    
    //Metodo privado que sirve de auxiliar al metodo mostrarGato. No debe usarse en otro caso.
    private String renglonGatoCadena(int ren){
	char gato=' ';
	String gatoCadena= "\t  ";
	if(gato3x3.obtenerDe(ren,0)==1){
	    gato='O';  
	}
	if(gato3x3.obtenerDe(ren,0)==2){
	    gato='X';
	}
	gatoCadena+=gato + " | ";
	gato=' ';
	if(gato3x3.obtenerDe(ren,1)==1){
	    gato='O';  
	}
	if(gato3x3.obtenerDe(ren,1)==2){
	    gato='X';
	}
	gatoCadena+=gato + " | ";
	gato=' ';
	if(gato3x3.obtenerDe(ren,2)==1){
	    gato='O';  
	}
	if(gato3x3.obtenerDe(ren,2)==2){
	    gato='X';
	}
	return gatoCadena+=gato;
    }
    
    //Se muestra el gato, esto lo hace de la manera clasica.
    public void mostrarGato(){
	System.out.println("\n\t|0|  |1|  |2|");
	System.out.println("\t    |   |    \n" + renglonGatoCadena(0)+"    |0|" +
                         "\n\t----+---+----" + "\n " + renglonGatoCadena(1)+"    |1|"+ 
          	         "\n\t----+---+----" + "\n " + renglonGatoCadena(2)+"    |2|"+
                         "\n\t    |   |    ");
    }
    
    public boolean verSiHayGato(int tiradaJugador){
	//tiradaJugador sirve para ver si tiro bola o tache, es decir ver que gato se forma.
	if(tiradaJugador==1){
	    return ((esBola(0,0)&& esBola(0,1)&& esBola(0,2)) //Horizontal
		    || (esBola(1,0)&& esBola(1,1)&& esBola(1,2)) //Horizontal
		    || (esBola(2,0)&& esBola(2,1)&& esBola(2,2)) //Horizontal
		    || (esBola(0,0)&& esBola(1,0)&& esBola(2,0)) //Vertical
		    || (esBola(0,1)&& esBola(1,1)&& esBola(2,1)) //Vertical
		    || (esBola(0,2)&& esBola(1,2)&& esBola(2,2)) //Vertical
		    || (esBola(0,0)&& esBola(1,1)&& esBola(2,2)) //Diagonal
		    || (esBola(0,2)&& esBola(1,1)&& esBola(2,0))); //Diagonal
	}else{
	    return ((esTache(0,0) && esTache(0,1) && esTache(0,2)) //Horizontal
		    || (esTache(1,0) && esTache(1,1) && esTache(1,2)) //Horizontal
		    || (esTache(2,0) && esTache(2,1) && esTache(2,2)) //Horizontal
		    || (esTache(0,0) && esTache(1,0) && esTache(2,0)) //Vertical
		    || (esTache(0,1) && esTache(1,1) && esTache(2,1)) //Vertical
		    || (esTache(0,2) && esTache(1,2) && esTache(2,2)) //Vertical
		    || (esTache(0,0) && esTache(1,1) && esTache(2,2)) //Diagonal
		    || (esTache(0,2) && esTache(1,1) && esTache(2,0))); //Diagonal 
	}
    }   
       
    public void tira(){
	Gato3x3 g1=new Gato3x3();
   	Scanner entrada=new Scanner(System.in);
	int x;
	int y;
	System.out.println("\nJugador 1 ingresa el las coordenadas donde deseas tu tirada");
	System.out.println("Ingresa la coordenada x");
	x=entrada.nextInt();
	System.out.println("Ingresa la coordenada y");
	y=entrada.nextInt();
	System.out.println("Tiraste en el siguiente punto ("+x+","+y +")");
	g1.colocarTache(x,y);
	g1.mostrarGato();
	System.out.println("\nTurno del jugador 2");
	System.out.println("\nIngresa la coordenada x");
	x=entrada.nextInt();
	System.out.println("Ingresa la coordenada y");
	y=entrada.nextInt();
	System.out.println("Tiraste en el siguiente punto ("+x+","+y +")");
	g1.colocarBola(x,y);
	g1.mostrarGato();


	
	System.out.println("\nJugador 1 ingresa el las coordenadas donde deseas tu tirada");
	System.out.println("Ingresa la coordenada x");
	x=entrada.nextInt();
	System.out.println("Ingresa la coordenada y");
	y=entrada.nextInt();
	System.out.println("Tiraste en el siguiente punto ("+x+","+y +")");
	g1.colocarTache(x,y);
	g1.mostrarGato();
	System.out.println("\nTurno del jugador 2");
	System.out.println("\nIngresa la coordenada x");
	x=entrada.nextInt();
	System.out.println("Ingresa la coordenada y");
	y=entrada.nextInt();
	System.out.println("Tiraste en el siguiente punto ("+x+","+y +")");
	g1.colocarBola(x,y);
	g1.mostrarGato();

	System.out.println("\nJugador 1 ingresa el las coordenadas donde deseas tu tirada");
	System.out.println("Ingresa la coordenada x");
	x=entrada.nextInt();
	System.out.println("Ingresa la coordenada y");
	y=entrada.nextInt();
	System.out.println("Tiraste en el siguiente punto ("+x+","+y +")");
	g1.colocarTache(x,y);
	g1.mostrarGato();
	System.out.println("\nTurno del jugador 2");
	System.out.println("\nIngresa la coordenada x");
	x=entrada.nextInt();
	System.out.println("Ingresa la coordenada y");
	y=entrada.nextInt();
	System.out.println("Tiraste en el siguiente punto ("+x+","+y +")");
	g1.colocarBola(x,y);
	g1.mostrarGato();

	
	System.out.println("\nJugador 1 ingresa el las coordenadas donde deseas tu tirada");
	System.out.println("Ingresa la coordenada x");
	x=entrada.nextInt();
	System.out.println("Ingresa la coordenada y");
	y=entrada.nextInt();
	System.out.println("Tiraste en el siguiente punto ("+x+","+y +")");
	g1.colocarTache(x,y);
	g1.mostrarGato();
	System.out.println("\nTurno del jugador 2");
	System.out.println("\nIngresa la coordenada x");
	x=entrada.nextInt();
	System.out.println("Ingresa la coordenada y");
	y=entrada.nextInt();
	System.out.println("Tiraste en el siguiente punto ("+x+","+y +")");
	g1.colocarBola(x,y);
	g1.mostrarGato();

	
	System.out.println("\nJugador 1 ingresa el las coordenadas donde deseas tu tirada");
	System.out.println("Ingresa la coordenada x");
	x=entrada.nextInt();
	System.out.println("Ingresa la coordenada y");
	y=entrada.nextInt();
	System.out.println("Tiraste en el siguiente punto ("+x+","+y +")");
	g1.colocarTache(x,y);
	g1.mostrarGato();

    
    }
    
    public static void main(String arg[]){
	Gato3x3 gato = new Gato3x3();
	gato.mostrarGato();
	gato.tira();
	
	
    }
}