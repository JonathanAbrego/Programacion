public class Robot{
    private String nombre, marca;
    private int serie;
    private boolean dormido;
    public Robot(String nombre,String marca,int serie){
	this.nombre=nombre;
	this.marca= marca;
	this.serie=serie;
	dormido=false;
    }
    public void repetirMensaje(String mensaje){
	if(dormido){
	    System.out.println("Estoy dormido zzzzz....");
	}else {
	    System.out.println("Repito "+ mensaje);
	}
    }

    public void misDatos(){
	if(dormido){
	    System.out.println("Estoy dormido zzzzz....");
	}else{
	    System.out.println("Mi nombre es "+ nombre);
	    System.out.println("Mi numero de serie es "+ serie);
	    System.out.println("Marca "+marca);
	}
    }  
        public int opElem(char op,int num1,int num2){
	if(dormido){
	    System.out.println("Estoy dormido zzzzzz....");
	}else{
	    if(op == '+') return(num1+num2);
	    if(op == '-') return(num1-num2);
	    if(op == '*') return(num1*num2);
	}
	return 0;
    }
   public void dormido(){
	dormido=true;
    }
    public void despertar(){
	dormido=false;
    }
    public static void main(String arg[]){
	Robot rb=new Robot ("Argumento","Sony",24);
	rb.misDatos();
	rb.repetirMensaje("Hola Mundo");
	rb.dormido();
	
    }
}
