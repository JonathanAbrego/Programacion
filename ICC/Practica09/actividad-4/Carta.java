/**
 *Clase Carta representa una carta la cual tendra en la parte trasera un identificador general para todas las  carta, 
 *es decir que todas las cartas tendran un reverso igua, mientras que lo que variara de ellas sera su frente 
 *el cual sera un carcater diferente para cada una, aunque depede de para que se usen las cartas, por ejemplo
 *si son usadas para un juego de memorama tendra que haber 2 objetos de la clase carta con un identificador o frente igual
 *@author Abrego Alvarez Jonathan
 *@aurhor Mart&iacute;nez Anaya Luis Angel
 *@version 1.2
 */
import java.io.PrintStream;

public class Carta{
 
    private char frontal;//Variable de tipo char que representara el frente de la carta 
    private String identificador;  //Variable de tipo String que representara el reverso de la carta
    
    /**
     * Constructor que copia los atributos de la clase 
     * @param frontal que representara el frente de la carta
     * @param identificador que representara la parte treasera de la carta 
     */
    public Carta(char frontal,String identificador){
	this.frontal=frontal;
	this.identificador = identificador;
	
  }

    /**
     *Constructor de copia que crea un objeto con las mismas caracteristicas de la clase 
     *@param carta que es el objeto que copia exactamente los mismos parametros  de la clase original
     *
     */
    public Carta(Carta carta){
	this.frontal=carta.frontal;
	this.identificador=carta.identificador;
    }
  
    /**
     *Muestra el identificador o la parte trasera de la carta con su repectivo caracter 
     *@return El caracter trasero de la carta
     *
     */
    public String identificador(){
	return identificador;
    }
  
    /**
     *Muestra el frente de la carta con su repectivo valor
     *@return El caracter frontal de la carta
     *
     */
    public char obtenerFrontal(){
	return frontal;
    }
   
    /**
     *Regresa la carta de una manera mas formal tratando de simular 
     *una carta mas parecida a las que conocemos en la vida real
     *@return La carta con su margenes o limites
     */
    public String aCadena(){
	String cadenaCarta="[";
	
	return cadenaCarta+="]"; 
    } 
    
}
