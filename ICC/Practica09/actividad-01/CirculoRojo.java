/**
 * Clase CirculoRojo: Representa un circulo rojo de radio fijo, siendo una extencion de la clase Circulo, que se imprime en una ventana 
 * para que pueda vizualizarse de una manera m&aacute;s adecuada
 * @author Abrego Alvarez Jonathan
 * @author Martinez Anaya Luis Angel
 * @version 1.0
 * @fecha 8 de noviembre de 2011
 */ 
public class CirculoRojo extends Circulo{
    private byte colorCirculo;
    
    /**
     * Crea un circulo de color rojo,con radio y centro especificado.
     * @param centro Un objeto de la clase Punto que representa el centro del circulo.
     * @param radio Un entero que representa el readio del circulo.
     */ 
    public CirculoRojo(Punto centro,int radio){
	super(centro,radio);
	colorCirculo=1;
    }

    /**
     * Despliega un ventana que dibuja el circulo graficamente, para as&iacute; porder visualizarlo.
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
	Punto p = new Punto(5,3);
	CirculoRojo c = new CirculoRojo(p,4);
	c.verCirculo();

  }
}