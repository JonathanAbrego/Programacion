/**
 * Clase DirectorioTelefonico: Simula un directorio telef&oacute;nico mediante el cual se pueden "guardar" los datos de
 * una persona, dependiendo de la categor&iacute;a en la que se quiera guardar al contacto.
 * Hay tres categor&iacute;as:
 * <BR> Amigos
 * <BR> Familia
 * <BR> Trabajo
 * Los contactos de categorizan en una de las tres anteriores opciones para poder ser mostrados propiamente cuando el
 * usuario lo requiera.
 * El directorio telef&oacute;nico puede almacenar hasta un total de cien contactos.
 * EL programa permite al usuario:
 * <BR> Crear contactos
 * <BR> Consultar informaci&oacute;n del contacto
 * <BR> Eliminar contactos
 *
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */

import java.util.Scanner;

public class DirectorioTelefonico{
    
    Persona[] directorio; // Arreglo de la clase Personas que permite guardar informacion de contactos
    Scanner teclado = new Scanner(System.in);

    /**
     * Crea un nuevo directorio telef&oacute;nico
     * Solamente se puede crear un tipo de directorio, por lo tanto s&oacute;lo est&aacute; el constructor por default,
     * donde el m&aacute;ximo de contactos capaz de guardar es de cien
     */
    
    public DirectorioTelefonico(){
	directorio = new Persona[100];
    }

    /**
     * Guarda un contacto en el directorio
     * Si el directorio est&aacute; lleno, le indica al usuario que no puede almacenar m&aacute;s contactos y le pide que 
     * elimine a alguno que tiene guardado para poder guardar uno nuevo
     * @param p Contacto que se va a guardar en el directorio telef&oacute;nico
     */

    public void guardarContacto(Persona p){
	if(directorio[100]!=null){
	    System.out.println("\nEL directorio está lleno, debes eliminar un contacto para poder guardar uno nuevo");}
	else{
	    for(int a=0; a<directorio.length; a++){
		if(directorio[a]==null){
		    directorio[a]=p;
		    break;
		} else { continue; }
	    }
	    System.out.println("\nContacto guardado");
	    menuPrincipal();
	}
    }

    /**
     * Despliega una serie de opciones que permiten al usuario:
     * <BR> Crear un nuevo contacto en el directorio
     * <BR> Ver los contactos que tiene almacenados en el directorio
     */

    public void menuPrincipal(){
	System.out.println("\n(1) Crear un nuevo contacto\n(2) Consultar directorio\n(3) Salir");
	int decision = teclado.nextInt();
	switch(decision){
	case 1:
	    menuCreacionContacto();
	    break;
	case 2:
	    if(directorio[0]==null){ 
		System.out.println("\nNo tienes contactos");
		menuPrincipal();
	    }
	    else{ menuContactos(); }
	    break;
	default:
	    System.out.println("\nHasta luego\n");
	    break;
	}
    }

    /**
     * Despliega opciones que permite al usuario consultar la informaci&oacute;n almacenada que se tiene de un contacto
     * previamente creado
     * Una vez mostrada la informaci&oacute;n de un contacto, despliega otra serie de opciones que permiten al usuario:
     * <BR> Eliminar al contacto que est&aacute; consultando
     * <BR> Proseguir al men&uacute; principal
     */

    public void menuContactos(){
	for(int a=0; a<directorio.length; a++){
	    if(directorio[a]==null){continue;}
	    else{System.out.println("("+(a+1)+") "+directorio[a].obtenerNombre());}
	}
	int decision = teclado.nextInt();
	System.out.print("\n"+directorio[decision-1]+"\n\n(1) Eliminar contacto\n(2) Menú principal\n");
	int decision2 = teclado.nextInt();
	switch(decision2){
	case 1:
	    System.out.println("\nSe ha borrado a "+directorio[decision-1].obtenerNombre());
	    directorio[decision-1]=null;
	    menuPrincipal();
	    break;
	case 2:
	    menuPrincipal();
	    break;
	}
    }
    
    /**
     * Crea un nuevo contacto a partir de seleccionar una categor&iacute;a donde se pretende clasificarlo
     * El usuario es capaz de categorizar al nuevo contacto entre:
     * <BR> Amigos
     * <BR> Familia
     * <BR> Trabajo
     * Dependiendo de la categor&iacute;a en la que se guarda al contacto, se le piden al usuario que introduzca
     * informaci&oacute;n necesaria para el correcto almacenamiento del contacto
     */

    public void menuCreacionContacto(){
	String nombre, telefono;
	System.out.println("\nSeleccione en qué categoría le gustaría crear el nuevo contacto\n(1) Amigos\n(2) Familia"+
			   "\n(3) Trabajo");
	int decision = teclado.nextInt();
	switch(decision){
	case 1:
	    System.out.println("\nEscriba el nombre del amigo");
	    nombre = teclado.next();
	    System.out.println("\nEscriba el teléfono");
	    telefono = teclado.next();
	    System.out.println("\nEscriba el apodo del amigo");
	    String apodo = teclado.next();
	    Amigo a = new Amigo(nombre,telefono,apodo);
	    guardarContacto(a);
	    break;
	case 2:
	    System.out.println("\nEscriba el nombre de su familiar");
	    nombre = teclado.next();
	    System.out.println("\nEscriba el teléfono");
	    telefono = teclado.next();
	    System.out.println("\nEscriba el parentesco que tiene con el familiar");
	    String parentezco = teclado.next();
	    Familiar f = new Familiar(nombre,telefono,parentezco);
	    guardarContacto(f);
	    break;
	case 3:
	    System.out.println("\nEscriba el nombre de su contacto de trabajo");
	    nombre = teclado.next();
	    System.out.println("\nEscriba el teléfono del contacto");
	    telefono = teclado.next();
	    System.out.println("\nEscriba la extensión");
	    byte extension = (byte) teclado.nextInt();
	    System.out.println("\nEscriba el nombre de la compañía para la que trabaja el contacto");
	    String compania = teclado.next();
	    Cliente c = new Cliente(nombre,telefono,extension,compania);
	    guardarContacto(c);
	    break;
	default:
	    break;
	}
    }

    public static void main(String arg[]){
	DirectorioTelefonico direc = new DirectorioTelefonico();
	direc.menuPrincipal();
    }
}