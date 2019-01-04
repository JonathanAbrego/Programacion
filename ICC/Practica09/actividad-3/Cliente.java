/**
 * Clase Cliente: Esta es una extensi&oacute;n de la clase Persona que tiene el objetivo de representar a un cliente que se guarda
 * en un directorio telef&oacute;nico con su nombre, compa&ntilde;ia y telef&pacute;no con extensi&oacute;n.
 * 
 * @author Alejandro S&aacute;nchez Aviles
 * @version 1.0
 */ 
public class Cliente extends Persona{

  private String compania; // nombre de la compania del cliente
  private byte extension; // Extension del telefono del cliente
  
  
  /**
   * Crea una persona del tipo cliente a partir de su nombre, compa&ntilde;ia y su telef&oacute;no con extesi&oacute;n.
   * @param nombre Una cadena que representa al nombre de la persona con todo y apellidos.
   * @param telefono Cadena que representa al telef&oacute;no de una persona, ya sea celular (13 digitos) o
   * local (8 digitos). Si no es un telef&oacute;no valido le coloca: 00000000.
   * @param extension Un n&uaucte;mero entero que representa la extesi&oacute;n telef&oacute;nica de la persona.
   * @param compania Un cadena que representa el nombre de la compa&ntilde;ia de la persona.
   * <BR>Uso:
   * <BR><BR>
   * <BR> Cliente per = new Cliente("Pedro Lopez Cortina", "12345678", 12, "Coca Cola");
   * <BR>
   * <BR> Crea una persona llamada Pedro Lopez Cortina con telef&oacute;no 12345678 y extensi&oacute;n 12 y compa&ntilde;ia Coca Cola.
   */ 
  public Cliente(String nombre, String telefono, byte extension, String compania){
    super(nombre, telefono);
    this.compania = compania;
    this.extension = extension;
  }

  /**
   * Obtiene la compa&ntilde;ia de la persona que se guarda en un directorio.
   * @return Una cadena que representa al nombre de la compa&ntilde;ia de la persona.
   */ 
  public String obtenerCompania(){
    return compania;
  }
  
  /**
   * Coloca o modifica la compa&ntilde;ia de una persona que se guardar&aacute; en un directorio.
   * @param compania Una cadena que representa la compa&ntilde;ia de la persona.
   */ 
  public void colocarCompania(String compania){
    this.compania = compania;
  }
  
  /**
   * Obtiene la extensi&oacute;n de la persona que se guarda en un directorio.
   * @return Un entero que representa la extesi&oacute;n de la persona.
   */ 
  public byte obtenerExtension(){
    return extension;
  }
  
  /**
   * Coloca o modifica a extensi&oacute;n de una persona que se guardar&aacute; en un directorio.
   * @param extension Un entero que representa a extensi&oacute;n de la persona.
   */ 
  public void colocarExtension(byte extension){
    this.extension = extension;
  }
  
   /**
   * Regresa la representaci&oacute;n en cadena de una persona.
   * <BR>Uso:
   * <BR><BR>
   * <BR>Cliente per = new Cliente("Pedro Lopez Cortina", "12345678", 12, "Coca Cola");
   * <BR>System.out.println(per);
   * <BR><BR>Se imprime: 
   * <BR>Nombre: Pedro Lopez Cortina
   * <BR>Telef&oacute;no: 12345678 con extensi&oacute;n 12
   * <BR>Compa&ntilde;ia: Coca Cola
   * @return Una cadena que representa a una persona de un directorio.
   */ 
  public String toString(){
    return "Nombre: " + obtenerNombre() + "\nTeléfono: " + obtenerTelefono() 
      + "con extensión " + extension + "\nCompania: " + compania;
  }
  
}