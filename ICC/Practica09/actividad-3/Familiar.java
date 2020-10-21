/**
 * Clase Familiar: Esta es una extensi&oacute;n de la clase Persona que tiene el objetivo de representar a un familiar que se guarda
 * en un directorio telef&oacute;nico con su nombre, parentesco y telef&pacute;no.
 * 
 * @author Alejandro S&aacute;nchez Aviles
 * @version 1.0
 */ 
public class Familiar extends Persona{
  private String parentesco;// Cadena que representa el parentesco de una persona.
  
  /**
   * Crea una persona del tipo familar a partir de su nombre, parentesco y su telef&oacute;no.
   * @param nombre Una cadena que representa al nombre de la persona con todo y apellidos.
   * @param telefono Cadena que representa al telef&oacute;no de una persona, ya sea celular (13 digitos) o
   * local (8 digitos). Si no es un telef&oacute;no valido le coloca: 00000000.
   * @param parentesco Una cadena que representa al parentesco de una persona en el directorio.
   * <BR>Uso:
   * <BR><BR>
   * <BR> Familiar per = new Familiar("Pedro Lopez Cortina", "12345678", "Hermano");
   * <BR>
   * <BR> Crea una persona llamada Pedro Lopez Cortina con telef&oacute;no 12345678 y es hermano.
   */ 
  public Familiar(String nombre, String telefono, String parentesco){
    super(nombre, telefono);
    this.parentesco = parentesco;
  }

  /**
   * Obtiene el parentesco de la persona que se guarda en un directorio.
   * @return Una cadena que representa al parentesco de la persona.
   */ 
  public String obtenerParentesco(){
    return parentesco;
  }
  
  /**
   * Coloca o modifica el parentesco de una persona que se guardar&aacute; en un directorio.
   * @param apodo Una cadena que representa el parentesco de la persona.
   */ 
  public void colocarParentesco(String parentesco){
    this.parentesco = parentesco;
  }
  
  /**
   * Regresa la representaci&oacute;n en cadena de una persona.
   * <BR>Uso:
   * <BR><BR>
   * <BR>Familiar per = new Familiar("Pedro Lopez Cortina", "12345678", "Hermano");
   * <BR>System.out.println(per);
   * <BR><BR>Se imprime: 
   * <BR>Nombre: Pedro Lopez Cortina
   * <BR>Telef&oacute;no: 12345678
   * <BR>Parentesco: Hermano
   * @return Una cadena que representa a una persona de un directorio.
   */ 
  public String toString(){  
    return "Nombre: " + obtenerNombre() + "\nTeléfono: " + obtenerTelefono() + "\nParentesco: " + parentesco;
  }

}