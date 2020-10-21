/**
 * Clase Persona: Esta clase tiene el objetivo de representar a una persona que es guardada
 * en un directorio telef&oacute;nico con su nombre y telef&pacute;no.
 * 
 * @author Alejandro S&aacute;nchez Aviles
 * @version 1.0
 */ 
public class Persona{
  
  private String nombre; // El nombre de la persona con apellidos 
  private String telefono; // El telefono de la persona, ya sea celular o local.
  
  /**
   * Crea una persona a partir de su nombre y su telef&oacute;no.
   * @param nombre Una cadena que representa al nombre de la persona con todo y apellidos.
   * @param telefono Cadena que representa al telef&oacute;no de una persona, ya sea celular (13 digitos) o
   * local (8 digitos). Si no es un telef&oacute;no valido le coloca: 00000000.
   * <BR>Uso:
   * <BR><BR>
   * <BR> Persona per = new Persona("Pedro Lopez Cortina", "12345678");
   * <BR>
   * <BR> Crea una persona llamada Pedro Lopez Cortina con telef&oacute;no 12345678.
   */ 
  public Persona(String nombre, String telefono){
    this.nombre = nombre;
    telefonoValido(telefono);
  }
  
  /**
   * Obtiene el nombre de la persona que se guarda en un directorio.
   * @return Una cadena que representa al nombre de la persona incluye apellidos.
   */ 
  public String obtenerNombre(){
    return nombre;
  }

  /**
   * Obtiene el telef&oacute;no de la persona que se guardar&aacute; en un directorio.
   * @return Una cadena que representa al telef&oacute;no de la persona. Ya sea de 8 o 13 digitos.
   */ 
  public String obtenerTelefono(){
    return telefono;
  }
  
  /**
   * Coloca o modifica el telef&oacute;no de una persona que se guardar&aacute; en un directorio.
   * @param telefono Una cadena que representa al telef&oacute;no de una persona, ya sea celular (13 digitos) o
   * local (8 digitos).
   */ 
  public void colocarTelefono(String telefono){
    telefonoValido(telefono);
  }
  
  /**
   * Coloca o modifica el nombre de una persona que se guardar&aacute; en un directorio.
   * @param nombre Una cadena que representa el nombre de la persona incluyendo apellidos.
   */ 
  public void colocarNombre(String nombre){
    this.nombre = nombre;
  }
  
  /**
   * Metodos auxiliar: Verifica que el telef&oacute;no que se da como par&aacute;metro sea correcto, es decir:
   * <BR> sea un n&uacute;mero formado por 8 digitos cualesquiera,
   * <BR> sea un n&uacute;mero formado por 13 digitos y comience con 04455 o
   * <BR> sea un n&uacute;mero formado por 13 digitos y comience con 045.
   * <BR><BR> Si no es alguno de los anteriores coloca 00000000 al telef&oacute;no de la persona.
   * @param tel Una cadena que representa al telef&oacute;no de una persona.
   */ 
  private void telefonoValido(String tel){
    if(tel.length() == 8){
      telefono = tel;
    }else if(tel.length() == 13
               && (tel.substring(0,5).equals("04455") || tel.substring(0,3).equals("045"))){
      telefono = tel;
    }else{  
      telefono = "00000000";
    }
  }
  
  /**
   * Regresa verdadero de la persona es igual a la dada como par&aacute;metro.
   * @param persona Un objeto de la clase Persona que tiene nombre y telef&oacute;no.
   * @return Verdadero (true) si son iguales, falso (false) en otro caso.
   */ 
  public boolean equals(Persona persona){
    return persona.telefono.equals(telefono) && persona.nombre.equals(nombre);
  }
  
  /**
   * Regresa la representaci&oacute;n en cadena de una persona.
   * <BR>Uso:
   * <BR><BR>
   * <BR>Persona per = new Persona("Pedro Lopez Cortina", "12345678");
   * <BR>System.out.println(per);
   * <BR><BR>Se imprime: 
   * <BR>Nombre: Pedro Lopez Cortina
   * <BR>Telef&oacute;no: 12345678
   * @return Una cadena que representa a una persona de un directorio.
   */ 
  public String toString(){
    return "Nombre: " + nombre + "\nTeléfono: " + telefono;
  }
  
}