import java.lang.Object;
/**
 * Clase Tablero: Simula un tablero cuadrado de una dimensi&oacute;n fija o definida por el
 * usuario. Es un tablero tipo cuadriculado, es decir se puede guardar informaci&oacute;n en cada casilla.
 * Cada casilla esta definida por una n&uacute;mero entero rengl&oacute;n y otro n&uacute;mero entero  columna. Para
 * referirse a una casilla se necesita dar una pareja (rengl&oacute;n, columna).
 * <BR><BR>
 * En particular, este tablero puede almacenar enteros. La nomenglatura usada es la siguiente:
 * <BR> 0 -> Si la casilla es vacia.
 * <BR> 1, 2, 3, 4 o 5 -> Si la casilla esta ocupada.
 * <BR><BR> Le sugerimos usar los n&uacute;meros de la siguiente forma:
 * <BR>1 y 2 -> Cuando sea un elemento cualquiera.
 * <BR>3 -> Si se refiere a un obst&aacute;culo
 * <BR>4 -> Si quiere colocar una especie de trampa.
 * <BR>5 -> Si desea que tenga un l&iacute;mite o sea pared.
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
 *
 * @author Alejandro S&aacute;nchez Aviles
 * @version 2.0
 * 
 */ 

public class Tablero{
  
  //Arreglo doble o bidimensional para almacenar los elementos
  protected int tablero[][];
  
  /**
   * Construye un tablero de dimensi&oacute;n 3, es decir de 9 casillas. Todas ellas vac&iacute;as.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(false);
   * <BR><BR> Crea un tablero con 9 casillas y sin pared alrededor.
   * @param conPared Si es verdadero coloca una pared alrededor del tablero (5). Si es falso crea un tablero com&uacute;n.
   * 
   */
  public Tablero(boolean conPared){
    this(3,conPared);
  }
  
  /**
   * Construye un tablero de una cierta dimensi&oacute;n.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(5, true);
   * <BR><BR> Crea un tablero con 25 casillas con pared alrededor.
   * @param conPared Si es verdadero coloca una pared alrededor del tablero (5). Si es falso crea un tablero com&uacute;n.
   * @param dimension Entero que representa la dimensi&oacute;n para el tablero.
   * 
   */
  public Tablero(int dimension, boolean conPared){
    if(conPared){
      tablero = new int[dimension+1][dimension+1];
      for(int i=0; i<tablero.length; i++){
        colocarEn(0,i, 5);
        colocarEn(tablero.length-1, i, 5);
      }
      for(int i=1; i<tablero.length-1; i++){
        colocarEn(i,0, 5);
        colocarEn(i,tablero.length-1, 5);
      }
      
    }else{
      tablero = new int[dimension][dimension];
    }
  }
  
  /**
   * Construye un tablero exactamente igual al dado como par&aacute;metro.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(5,true);
   * <BR> Tablero table2 = new Tablero(table);
   * <BR><BR> Crea un tablero con 25 casillas identico a table.
   * @param t Tablero del cual se requiere una copia exacta.
   * 
   */
  public Tablero(Tablero t){
    tablero = t.tablero;
  }
  
  /**
   * Coloca un elemento en la casilla dada que es determinada por un rengl&oacute;n y una columna
   * en el tablero.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(5, false);
   * <BR> table.colocarEn(2,3,7);
   * <BR><BR> Coloca un n&uacute;mero 7 en la casilla (2,3) del tablero.
   * @param ren Entero que representa el rengl&oacute;n de la casilla. Este debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @param colum Entero que representa a la columna de la casilla. Esta debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @param elemento Entero que se colocar&aacute; en la casilla especificada.
   */
  public void colocarEn(int ren, int colum, int elemento){
    if(obtenerDe(ren,colum)!=5){
      tablero[ren][colum] = elemento;  
    }
  }
  
  /**
   * Elimina un elemento en la casilla dada que es determinada por un rengl&oacute;n y una columna, 
   * dejandola vac&iacute;a en el tablero.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(5, false);
   * <BR> table.quitarDe(2,3);
   * <BR><BR> Coloca un n&uacute;mero 0 en la casilla (2,3) del tablero, es decir la deja vac&iacute;a.
   * @param ren Entero que representa el rengl&oacute;n de la casilla. Este debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @param colum Entero que representa a la columna de la casilla. Esta debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   */
  public void quitarDe(int ren, int colum){
    if(obtenerDe(ren,colum)!=5){
      colocarEn(ren, colum, 0);
    }
  }
  
  /**
   * Obtiene el elemento que se encuentra en la  casilla dada que es determinada por un rengl&oacute;n y una columna
   * en el tablero.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(5, false);
   * <BR> table.colocarEn(2,3,7);
   * <BR> int casilla = table.obtenerDe(2,3);
   * <BR><BR> La variable casilla es igual a 7, ya que es el elemento alamacenado en la casilla (2,3).
   * @param ren Entero que representa el rengl&oacute;n de la casilla. Este debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @param colum Entero que representa a la columna de la casilla. Esta debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @return Un entero que representa el elemento almacenado en la casilla indicada.
   */
  public int obtenerDe(int ren, int colum){
    return tablero[ren][colum];
  }
  
  /**
   * Verifica que en el rengl&oacute;n y columna no se haya almacenado un elemento, es decir este ocupada o libre.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(5, false);
   * <BR> table.colocarEn(2,3,7);
   * <BR> if(table.casillaOcupada(2,3)) System.out.println("Ocupada");
   * <BR> else System.out.println("Vac&iacute;a");
   * <BR><BR> Lo cual imprimir&aacute; en pantalla "Ocupada" ya que en la casilla (2,7) hay un 7, y no esta vac&iacute;a.
   * @param ren Entero que representa el rengl&oacute;n de la casilla. Este debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @param colum Entero que representa a la columna de la casilla. Esta debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @return Verdadero (true) si la casilla esta ocupada, es decir no contiene un 0. Falso (false) en otro caso.
   */
  public boolean casillaOcupada(int ren, int colum){
    return !(tablero[ren][colum]==0);
  }
  
  /**
   * Verifica que en el rengl&oacute;n y columna este almacenado un 5, que indica que se trata de una pared en el
   * tablero.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(5, false);
   * <BR> table.colocarEn(2,3,7);
   * <BR> if(table.esPared(2,3)) System.out.println("Es pared");
   * <BR> else System.out.println("No es pared");
   * <BR><BR> Lo cual imprimir&aacute; en pantalla "No es pared" ya que en la casilla (2,7) no contiene un 5.
   * @param ren Entero que representa el rengl&oacute;n de la casilla. Este debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @param colum Entero que representa a la columna de la casilla. Esta debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @return Verdadero (true) si la casilla contiene un 5 o es pared.. Falso (false) en otro caso.
   */
  public boolean esPared(int ren, int colum){
    return tablero[ren][colum]==5;
  }
  
  /**
   * Coloca un obst&aacute;culo (3) en el rengl&oacute;n y columna especificados en el tablero.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(5, false);
   * <BR> table.colocarObstaculo(2,3);
   * <BR><BR> Coloca un obst&aacute;culo en la casilla (2,3), es decir un n&uacute;mero 3 en el tablero.
   * @param ren Entero que representa el rengl&oacute;n de la casilla. Este debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @param colum Entero que representa a la columna de la casilla. Esta debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   */
  public void colocarObstaculo(int ren, int colum){
    if(obtenerDe(ren,colum)!=5){
      colocarEn(ren, colum, 3);
    }
  }
  
  /**
   * Coloca una trampa (4) en el rengl&oacute;n y columna especificados en el tablero.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(5, false);
   * <BR> table.colocarTrampa(2,3);
   * <BR><BR> Coloca una trampa en la casilla (2,3), es decir un n&uacute;mero 4 en el tablero.
   * @param ren Entero que representa el rengl&oacute;n de la casilla. Este debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   * @param colum Entero que representa a la columna de la casilla. Esta debe estar en el rango [0,N-1].
   * Con N la dimensi&oacute;n del tablero.
   */
  public void colocarTrampa(int ren, int colum){
    if(obtenerDe(ren,colum)!=5){
      colocarEn(ren, colum, 4);
    }
  }
  
  /**
   * Convierte a una cadena al tablero.
   * <BR><BR>Uso:
   * <BR> Tablero table = new Tablero(2, false);
   * <BR> table.colocarTrampa(0,1);
   * <BR> System.out.println(table);
   * <BR><BR> El resultado en pantalla ser&aacute;:
   * <PRE>
   *     |0| |1|
   * |0|  0   4
   * |1|  0   0 
   * </PRE>
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
   * Metodo main para probar todos los m&eacute;todos de la clase Tablero.
   */
  public static void main(String arg[]){
    Tablero t = new Tablero(8,true);
    t.colocarTrampa(2,3);
    System.out.println(t);
  }
}
