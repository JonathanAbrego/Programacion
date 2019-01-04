/**
 * Clase CirculoDinamico: Representa un circulo al cual se le puede cambiar el radio.
 * @author Alejandro Sanchez Avilesç
 * @version 1.0
 * 
 */ 
public class CirculoDinamico extends Circulo{
  
  private int radioDina; // Radio dinamico del circulo.
  
  /**
   * Crea un circulo con radio y centro especificados.
   * @param centro Un objeto de la clase Punto que representa el centro del circulo.
   * @param Un entero que presenta el radio del circulo.
   */ 
  public CirculoDinamico(Punto centro, int radio){
    super(centro, radio);
    radioDina = radio;
    
  }
  
  /**
   * Aumenta el radio del circulo tantas unidades como las indicadas.
   * @param aumento Un entero que representa el n&uacute;mero de unidades que se aumentar&aacute; al radio.
   */ 
  public void aumentarRadio(int aumento){
    radioDina+=aumento;
  }
  
   /**
   * Reduce el radio del circulo tantas unidades como las indicadas.
   * @param decremento Un entero que representa el n&uacute;mero de unidades que se reducen al radio.
   */ 
  public void disminuirRadio(int decremento){
    radioDina-=decremento;
  }
  
  /**
   * Despliega un ventana que dibuja el circulo graficamente.
   */
  public void verCirculo(){
    DibujarCirculo dib = new DibujarCirculo(new Circulo(obtenerCentro(), radioDina));
    dib.mostrarVentana();
  }
  /**
   * Prueba los metodos de la clase.
   */ 
  public static void main(String arg[]){
    Punto p = new Punto(3,2);
    CirculoDinamico c = new CirculoDinamico(p,4);
    c.verCirculo();
    c.aumentarRadio(10);
    c.verCirculo();
    c.disminuirRadio(5);
    c.verCirculo();
    c.disminuirRadio(10);
    c.verCirculo();
  }
}