/**
 * Clase CirculoColores: Representa circulos de de un radio fijo y de diferentes coleres, adecuerdo a lo permitido
 * en la ventana que lo despliega.
 * @author Alejandro Sanchez Avilesç
 * @version 1.0
 * 
 */ 
public class CirculoColores extends Circulo{
  private byte colorCirculo;
 
  /**
   * Crea un circulo con un radio, color y centro especificado.
   * @param centro Un objeto de la clase Punto que representa el centro del circulo.
   * @param radio Un entero que representa el readio del circulo.
   * @param Un entero que representa un color. De acuerdo a lo siguiente:
   * <BR><BR>1 -> Rojo<BR> 
   * 2 -> Azul<BR>
   * 3 -> Gris<BR>
   * 4 -> Verde<BR>
   * Con cualquier otro valor es negro.
   */ 
  public CirculoColores(Punto centro, int radio, byte color){
    super(centro, radio);
    colorCirculo=color;
    
  }
  
  /**
   * Cambia el color del circulo.
   * @param Un entero que representa un color.
   */ 
  public void cambiarColor(byte color){  
    colorCirculo = color;
  }
  
  /**
   * Despliega un ventana que dibuja el circulo graficamente.
   */ 
  public void verCirculo(){
    DibujarCirculo dib = new DibujarCirculo(this);
    dib.colocarColor(colorCirculo);
    dib.mostrarVentana();
    
  }
  
  /**
   * Metodo main para probar que todo esta bien.
   */ 
  public static void main(String arg[]){
    Punto p = new Punto(3,2);
    CirculoColores c = new CirculoColores(p,4,(byte)4);
    c.verCirculo();
    c.cambiarColor((byte)2);
    c.verCirculo();
  }  
}