/**
 * Clase UsaConjunto: Crea objetos de la clase Conjunto aplica m&eacute;todos de la misma clase sobre los objetos creados
 *
 * @author Abrego Alvarez Jonathan
 * @author Mart&iacute;nez Anaya Luis Angel
 * @version 1.0
 *
 */

public class UsaConjunto{

    public static void main(String arg[]){
	int[] elem1 = new int[20];
	int[] elem2 = new int[25];
	int valor=1;
	Conjunto conjunto1 = new Conjunto(elem1);
	Conjunto conjunto2 = new Conjunto(elem2);
	System.out.println("Conjunto 1:\n"+conjunto1+"\nCardinalidad del conjunto anterior: "+
			   conjunto1.obtenerCardinalidad());
	for(int a=0; a<elem1.length; a++){
	    conjunto1.insertar(valor);
	    valor++;
	}
	System.out.println("Se insertan elementos en el conjunto:\n"+conjunto1+"\nLa cardinalidad ahora es de "+
			   conjunto1.obtenerCardinalidad());
	conjunto1.eliminar(15);
	System.out.println("Se elimina 15 del conjunto y queda de la siguiente manera:\n"+conjunto1+
			   "\nCon cardinalidad "+conjunto1.obtenerCardinalidad());
	System.out.println("Se crea un subconjunto:");
	System.out.println(conjunto1.subconjunto(7));
	System.out.println("¿El número 16 pertenece al conjunto 1?\n"+conjunto1.pertenece(16)+
			   "\n¿El número 83 pertenece al conjunto 1?\n"+conjunto1.pertenece(83));
	valor=1;
	for(int a=0; a<elem2.length; a++){
	    conjunto2.insertar(valor);
	    valor++;
	}
	System.out.println("Teniendo un conjunto 2:\n"+conjunto2+"\nDe cardinalidad "+conjunto2.obtenerCardinalidad()+
			   "\nIntersección de conjuntos 1 y 2:\n"+conjunto1.interseccion(conjunto2)+
			   "\nUnión de los mismos dos conjuntos:\n"+conjunto1.union(conjunto2)+
			   "\nEl segundo conjunto menos el primero:\n"+conjunto2.diferencia(conjunto1)+
			   "\n¿El segundo conjunto está vacío?\n"+conjunto2.esVacio());
    }
}