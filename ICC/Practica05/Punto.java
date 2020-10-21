/**
 * Esta clase se usa para poder ya sea poder compara 2 punto con determinadas coordenadas, y hecho esto poder saber su distancia 
 * si estan alineados o si asi lo deseamos poder dezplazar alguno para hacer algo mas 
 *@author:Abrego Alvarez Jonathan
 *@version: 1.0 
 *@fecha: 27 de septiembre de 2010
 */

import java.lang.Math;

public class Punto{

    //Atributos
    private double x;
    private double y;
    
    //Constructor por default; es un constructor sin parametros
    public Punto(){
	x=y=0.0;
    }
    
    //Constructor de copia
    public Punto(double xIni, double yIni){
	x=xIni;
	y=yIni;
    }

    /**
     *Regresar la coordenada x del punto
     *@return double-la coordenada x
     */
    public double obtenerX(){
	return x;
    }

     /**
     *Regresar la coordenada y del punto
     *@return double-la coordenada y
     */

    public double obtenerY(){
	return y;
    }
    
    
    /**
     *Asignar el valor de x a un punto
     *@param nuevaX-nuevo valor para la coordenadaX
     */
    public void asignarX(double nuevaX){
	x=nuevaX;
    }
    
     /**
     *Asignar el valor de y a un punto
     *@param nuevaY-nuevo valor para la cooredenadaY
     */
    public void asignarY(double nuevaY){
	y=nuevaY;
    }

     /**
     *Permite desplazar un punto
     *@param deltaX- desplazamiento en el eje de las x
     *@param deltaY- desplazamiento en el eje de las y
     */

    public void desplazar(int deltaX, int deltaY){
	x+=deltaX;
	y+=deltaY;
    }
    
    
     /**
     *Determinar si 2 puntos estan alineado 
     *@param p1,p2 punto que se quiere determinar  si estan alineados
     *@return boolean- true si estan alineados y false si no es asi
     */
    public boolean estanAlineados(Punto p1,Punto p2){
	return (y-p1.y)*(p2.x-p1.x)==(p2.y-p1.y)*(x-p1.x);
    }
    
    /**
     *Determina la distancia entre 2 puntos 
     *@param p-punto respecto al que se quiere determinar la distancia
     *@return double -distancia entre los puntos
     */
    public double distancia(Punto p){
	return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
    }
    
    /**
     *Determina si 2 puntos son iguales 
     *@param p-punto contra el cual se va a comprar
     *@return boolean- true son iguales  y false en otro caso
     */
    //Metodo equals
    public boolean equals(Object p){
	Punto punto =(Punto)p;
	return x==punto.obtenerX() && y==punto.obtenerY();
    }
     /**
     *Metodo para convertir un Punto a cadena de caracteres
     *@return String--el punto en forma de cadena
     */
    //Metodo toString    
    public String toString(){
	return "(" + x + ","+ y +")";
    }
    
    public static void main(String arg[]){
	Punto a = new Punto(3.0, 4.0);
	Punto b = new Punto();
	System.out.println(a.distancia(b));
    }
}

     
    
        
    
    
    
