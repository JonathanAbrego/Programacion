/**
 * Clase Amigo: Esta es una extensi&oacute;n de la clase Persona que tiene el objetivo de representar a un amigo que se guarda
 * en un directorio telef&oacute;nico con su nombre, apodo y telef&pacute;no.
 * 
 * @author Alejandro S&aacute;nchez Aviles
 * @version 1.0
 */ 


public class Amigo extends Persona{
  private String apodo; // Representa el apode del amigo en el directorio.
  
  
  /**
   * Crea una persona del tipo amigo a partir de su nombre, apodo y su telef&oacute;no.
   * @param nombre Una cadena que representa al nombre de la persona con todo y apellidos.
   * @param telefono Cadena que representa al telef&oacute;no de una persona, ya sea celular (13 digitos) o
   * local (8 digitos). Si no es un telef&oacute;no valido le coloca: 00000000.
   * @param apodo Una cadena que representa al sobre nombre o apodo de una persona en el directorio.
   * <BR>Uso:
   * <BR><BR>
   * <BR> Amigo per = new Amigo("Pedro Lopez Cortina", "12345678", "lopez");
   * <BR>
   * <BR> Crea una persona llamada Pedro Lopez Cortina con telef&oacute;no 12345678 y apodo lopez.
   */ 
  public Amigo(String nombre, String telefono, String apodo){
    // Super debe ser lo primera instruccion de lo contrario se usario el constructor por defecto
    // y  veces eso no lo queremos.
    super(nombre, telefono);
    this.apodo = apodo;
  }
  
  /**
   * Obtiene el apodo de la persona que se guarda en un directorio.
   * @return Una cadena que representa al apodo de la persona.
   */ 
  public String obtenerApodo(){
    return apodo;
  }
  
  /**
   * Coloca o modifica el apodo de una persona que se guardar&aacute; en un directorio.
   * @param apodo Una cadena que representa el apodo de la persona.
   */ 
  public void colocarApodo(String apodo){
    this.apodo = apodo;
  }
  
  /**
   * Regresa la representaci&oacute;n en cadena de una persona.
   * <BR>Uso:
   * <BR><BR>
   * <BR>Amigo per = new Amigo("Pedro Lopez Cortina", "12345678", "lopez");
   * <BR>System.out.println(per);
   * <BR><BR>Se imprime: 
   * <BR>Nombre: Pedro Lopez Cortina
   * <BR>Telef&oacute;no: 12345678
   * <BR>Apodo: lopez
   * @return Una cadena que representa a una persona de un directorio.
   */ 
  public String toString(){
    //return "Nombre: " + nombre + "\nTeléfono: " + telefono + "\nApodo: " + apodo;
    return "Nombre: " + obtenerNombre() + "\nTeléfono: " + obtenerTelefono() + "\nApodo: " + apodo;
  }
  
  //El metodo equalsn no se sobrescribe ya que para que dos amigos dean iguales basta que tengan nombre y telefono igual.
  
  /**
   * Prueba los m&eacute;todos de la clase Amigo.
   */ 
  public static void main(String arg[]){
    Amigo a = new Amigo("Francisco Perez", "0459768877112", "pancho");
    System.out.println(a);
  }

}