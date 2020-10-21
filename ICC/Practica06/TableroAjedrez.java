/**
 *Clase Tablero Ajedrez hace la representacion de un tablero de ajedrez  en este caso vacio y sera 
 *representado que esta vacio por el numero cero, ademas de que cuenta con indices para poder ubicar 
 *la posicion de cada casilla 
 *@author Abrego Alvarez Jonathan
 *@version 1.2
 *@fecha 9 oct de 2011
 */

public class TableroAjedrez {
	
    //Atributos
    
    private int tablero[][];//Arreglo bidimensional
    
    /**
     * Construye un tablero de dimension 3, es decir de 3x3 casillas.
     */
    public TableroAjedrez(){
	tablero = new int[3][3];
    }
    
    /**
     * Construye un tablero de una cierta dimension dada.
     * @param dimension Entero que representa la dimension querida para el tablero.
     */
    public TableroAjedrez(int dimension){
	tablero=new int[dimension][dimension];
    }
    
    /**
     * Construye un tablero exactamente igual al dado como parametro.
     * @param t Tablero del cual se requiere una copia exacta.
     */
    public TableroAjedrez(TableroAjedrez t){
	tablero=t.tablero;
    }
    
    /**
     * Convierte a una cadena al tablero.
     * Debe usarse de la siguiente manera:
     * System.out.println("El tablero" + t);
     * Donde t es un objeto Tablero previamente creado.
     * @return Una cadena que representa a un objeto tablero.
     */
    public String toString(){
	String tableCadena="";
	for(int colum=0; colum<tablero[0].length; colum++){
	    tableCadena += "\t|" + colum + "|";
	}
	for(int ren=0; ren<tablero.length; ren++){
	    tableCadena+="\n|" + ren + "|";
	    for(int colum=0; colum<tablero[0].length; colum++){
		tableCadena+="\t" + tablero[ren][colum];
	    }
	}
	return tableCadena;
    }
     /**
      * Metodo main para probar todos los metodos de la clase Tablero
      */
    public static void main(String arg[]){
	TableroAjedrez t = new TableroAjedrez(8);
	System.out.println(t);
    }
}




	
	
	
