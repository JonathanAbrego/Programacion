import java.io.PrintStream;

public class Carta{
 
    private char frontal;
    private String identificador;  
    
    public Carta(char frontal,String identificador){
	this.frontal=frontal;
	this.identificador = identificador;
	
  }

    public Carta(Carta carta){
	this.frontal=carta.frontal;
	this.identificador=carta.identificador;
    }
  
    public String identificador(){
	return identificador;
    }
  
 
  public char obtenerFrontal(){
    return frontal;
  }
   
  public String aCadena(){
    String cadenaCarta="[";
  
    return cadenaCarta+="]"; 
  } 
  
}
