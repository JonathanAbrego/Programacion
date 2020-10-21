/**
 * Clase Decifrar es para mostrar el mensaje decifrado que se nos proporciono 
 *como actividad numero dos de la practica numero 6
 * 
 * @author Abrego Alvarez Jonathan
 * @version 1.0
 * @fecha 10 de octubre de 2011
 */
public class DecifraMensaje{
    private String entrada;
    private String salida;
    
    //Constructor por default
    public DecifraMensaje(){
    }
    /**
     *Constructor de copia 
     *@param entrada--mensaje codificado
     *@param salida--mensaje desifrado
     */
    public DecifraMensaje(String entrada,String salida){
	this.entrada=entrada;
	this.salida=salida;
    }
    
    //Metodos
    public void entrada(){

	System.out.println("\n \t Fkti ce thp kcp bkyth” cx ixgkxthp thp behjpa”ixce wxyp ñ wthtsthp st kc axcpyt st Shpvecti$P Wkbp ta rxtae it at wxoe xcsxuthtcjt”paqehejpse feh api akcpi$Ap rehjp lxsp st ap wxthqpt qkhae st ta”it qkhae st iki fpshti $ Ap wxhxtcjt ako it tcrhtife ieqht ap htiqpapsxop becjpdp$");
    }

    public void salida(){

	System.out.println("\n \t Pues no era una mujer, ni siquiera era mortal sino hija y heredera de linaje de Dragones.A huma el cielo se hizo indiferente,alborotado por las lunas.La corta vida de al hierbae burla de el, se burle de sus padres. La hiriente luz se encrespo sobre las resbaladiza montaña");
    }

    /**
     *Metodo equals para comparar si la cadena de entrdad no es igual al de salida 
     *
     */
    public boolean equals(){
	return salida==entrada;
    }

}