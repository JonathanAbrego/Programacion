/**Programa que dada una cantidad 
 * de productos con precio, los muestre
 * en forma ordenada con su precio normal y 
 * su precio con iva.
 *@author:Abrego Alvarez Jonathan
 *@version: 1.0 
 *@fecha: 8 de septiembre de 2010
 */
public class Productos{
    public static void main(String arg[]){

	//Declaracion de variables, que las declare de la siguiente forma para poder visualizar de mejor manera cada una 
	int cocaCola= 5;
	int galletas= 8;
	int cereal= 23;
	int carroJug= 250;
	int pelotaPlastico= 10;
        int balonFut= 600;
        int kiloTort= 11;
        int tenisP= 1200;
        int arroz= 20;
        int chocolate= 11;   
        double iva= .16;

	/*Listado de precios, donde la pimera columna es el producto, la segunda su precio sin iva y la tercera es el precion con iva,donde se multiplico el         * precio del producto por el iva que valia .16 o 16%,obteniendo asi el iva correspondiente de cada producto y despues se lo sumabamos al precio del         * producto para asi obtener el precion con iva */
	System.out.println();
	System.out.println("     ____________________________________________");
	System.out.println("     |     PRODUCTO     |  PRECIO | PRECIO + IVA|" );
	System.out.println("     |    Coca-Cola     |    "+cocaCola+"    |     "+((cocaCola*.16)+cocaCola)+"     |");
	System.out.println("     |     Galletas     |    "+galletas+"    |     "+((galletas*.16)+galletas)+"    |");
	System.out.println("     |     Cereal       |    "+cereal+"   |     "+((cereal*.16)+cereal)+"   |");
	System.out.println("     | Carro de Juguete |   "+carroJug+"   |     "+((carroJug*.16)+carroJug)+"   |");
	System.out.println("     |Pelota de Plastico|    "+pelotaPlastico+"   |     "+((pelotaPlastico*.16)+pelotaPlastico)+"    |");
	System.out.println("     |      Balon       |   "+balonFut+"   |     "+((balonFut*.16)+balonFut)+"   |");
	System.out.println("     | Kilo de tortilla |    "+kiloTort+"   |     "+((kiloTort*.16)+kiloTort)+"   |");
	System.out.println("     |   Tenis Puma     |   "+tenisP+"  |    "+((tenisP*.16)+tenisP)+"   |");
	System.out.println("     |      Arroz       |    "+arroz+"   |     "+((arroz*.16)+arroz)+"    |");
	System.out.println("     |    Chocolate     |    "+chocolate+"   |    "+((chocolate*.16)+chocolate)+"    |");
	System.out.println( );
        }
}


