/**
 * Clase Punto: Representa un punto como lugar geom&eacute;trico definido por dos coordenadas (x,y) en un
 * plano cartesiano.
 * 
 * @author Amparo Gaona.
 * 
 */ 

public class Punto{
  private double x;
  private double y;
  
  /**
   * Construye un punto en el origen de coordenadas.
   */ 
  public Punto(){  
    x=y=0.0;
  }
  
  /**
   * Construye un punto con coordenadas X e Y especificadas.
   * @param xIni Real que representa la coordenada X del punto en el plano.
   * @param yIni Real que representa la coordenada Y del punto en el plano.
   */ 
  public Punto(double xIni,double yIni){
    x=xIni;
    y=yIni;
  }
  
  /**
   * Construye un punto con coordenadas a partir de otro dado.
   * @param p Un objeto de la clase Punto que se clonar&aacute;.
   */ 
  public Punto(Punto p){
    x=p.x;
    y=p.y;
  }
  
  /**
   * Obtiene la coordenada X del punto en el plano.
   * @return Un real que representa la coordenada X del punto en el plano.
   */ 
  public double obtenerX(){
    return x;
  }
  
  /**
   * Obtiene la coordenada Y del punto en el plano.
   * @return Un real que representa la coordenada Y del punto en el plano.
   */
  public double obtenerY(){
    return y;
  }
  
  /**
   * Asigna la coordenada X del punto en el plano.
   * @param nuevaX Un real que representa la coordenada X del punto en el plano.
   */
  public void asignarX(double nuevaX){
    x=nuevaX;
  }
  
   /**
   * Asigna la coordenada Y del punto en el plano.
   * @param nuevaY Un real que representa la coordenada Y del punto en el plano.
   */
  public void asignarY(double nuevaY){
    y=nuevaY;
  }
  
   /**
   * Asigna las coordenadas X, Y del punto en el plano.
   * @param x1 Un real que representa la coordenada X del punto en el plano.
   * @param y1 Un real que representa la coordenada Y del punto en el plano.
   */
  public void asignarPunto(double x1, double y1){
    x=x1;
    x=y1;
  }
  
   /**
   * Asigna las coordenadas X, Y del punto en el plano a partir de otro punto en el plano.
   * @param p Un objeto de la clase Punto del cual se obtendran sus coordenadas para ser asignadas.
   */
  public void asignarPunto(Punto p){
    x=p.obtenerX();
    y=p.obtenerY();
  }
  
   /**
   * Desplaza un punto un numero de veces especificadas sobre cada coordenada.
   * @param deltaX Un real que representa el desplazamiento de la coordenada X del punto en el plano.
   * @param deltaY Un real que representa el desplazamiento de la coordenada Y del punto en el plano.
   */
  public void desplazar(int deltaX, int deltaY){
    x+=deltaX;
    y+=deltaY;
  }
  
  /**
   * Verifica si los 3 puntos estan alineados.
   * @param p1 Un objeto de clase punto que representa un punto en el plano.
   * @param p2 Un objeto de clase punto que representa un punto en el plano.
   * @return Verdadero so los puntos estan alineados y falso en otro caso.
   */ 
  public boolean estanAlineados(Punto p1, Punto p2){
    return (y - p1.y)*(p2.x - p1.x) == (p2.y - p1.y)*(x-p1.x);
  }
   
  /**
   * Determina la distancia entre dos puntos en el plano.
   * @param p Un objeto de la clase Punto que representa un punto en el plano.
   * @return Un real que representa la distancia entre los dos puntos.
   */ 
  public double distancia(Punto p){
    return Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
  }
  
  /**
   * Verifica si dos puntos son iguales.
   * @param p Un objeto que se comparar&aacute; para ver si es igual al objeto que invoca al m&eacute;todo.
   * @return Verdadero si son iguales, falso en otro caso.
   */ 
  public boolean equals(Object p){
    Punto punto = (Punto)p;
    return x==punto.obtenerX() && y==punto.obtenerY();
  }
  
  /**
   * Representaci&oacuten de un punto como cadena.
   * @return Una cadena que representa la punto con coordenadas X e Y de la siguiente manera: (X,Y).
   */ 
  public String toString(){
    return "(" + x +"," + y + ")";
  }
  
}