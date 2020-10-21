/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgModelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author abrego
 */
public class MuestraReservacion {
     pkgControl.Conexion objConecta;
     private Statement stmt;

     /**
      * Constructor por defecto
      */
     public MuestraReservacion(){
          objConecta = new pkgControl.Conexion();
     }
  
     /**
      * Metodo para consultar las reservacion que se hicieron
      * @return una cadena de cada tupla selecionada en la consulta
      * @throws SQLException 
      */
    public String verReservacion()throws SQLException{
        ResultSet rs =objConecta.buscaDatos("select id_reservacion, hora, fecha, clave,nombre from\n" +
                                           "(SELECT clave,Nombre,id_reservacion FROM Escuela\n" +
                                           "NATURAL JOIN \n" +
                                           "Realiza) as t1\n" +
                                            "natural join\n" +
                                            "reservacion");
        String nombre=" ";
        while(rs.next()){
                nombre+="<br>";
            nombre+="<table >";
            nombre+="<tr>";
            nombre+="<td>Reservacion:</td>";
            nombre+="<td>"+rs.getString(1)+"</td>";
            nombre+="</tr>";
            nombre+="<tr>";
            nombre+="<td>Hora:</td>";
            nombre+="<th>"+rs.getString(2)+"</th>";
            nombre+="</tr>";
            nombre+="<tr>";
            nombre+="<td>Fecha:</td>";
            nombre+="<th>"+rs.getString(3)+"</th>";
            nombre+="</tr>";
            nombre+="<td>Clave:</td>";
            nombre+="<th>"+rs.getString(4)+"</th>";
            nombre+="</tr>";
            nombre+="</tr>";
            nombre+="<td>Nombre:</td>";
            nombre+="<th>"+rs.getString(5)+"</th>";
            nombre+="</tr>";
            nombre+="</table>";
        }
        return nombre;
    }
    
    /**
     * Metodo usado para hacer una lista de los profesores 
     * que hay dentro del sistema de postgresql
     * @return la lista de profesores segun la consulta
     * @throws SQLException 
     */
    public String verProfesores()throws SQLException{
        ResultSet rs =objConecta.buscaDatos("select id_reservacion,profesor,nombre,apellido_paterno from lista_profesores\n" +
                                            "natural join \n" +
                                            "profesor\n" +
                                            "where lista_profesores.profesor=profesor.rfc_profesor\n" +
                                            "order by id_reservacion;");
        String nombre=" ";
        while(rs.next()){
        nombre+="<br>";
            nombre+="<br>";
            nombre+="<table >";
            nombre+="<tr>";
            nombre+="<td>Reservacion:</td>";
            nombre+="<td>"+rs.getString(1)+"</td>";
            nombre+="</tr>";
            nombre+="<tr>";
            nombre+="<td>CURP:</td>";
            nombre+="<th>"+rs.getString(2)+"</th>";
            nombre+="</tr>";
            nombre+="<tr>";
            nombre+="<td>Nombre:</td>";
            nombre+="<th>"+rs.getString(3)+"</th>";
            nombre+="</tr>";
            nombre+="<td>Apellido:</td>";
            nombre+="<th>"+rs.getString(4)+"</th>";
            nombre+="</tr>";
            nombre+="</table>";
        }
        return nombre;
    }
    
    /**
     * Metodo que sirve para listar los alumnos que hay dentro del 
     * sistema de postgresql
     * @return una cadena de la consulta realizada 
     * @throws SQLException 
     */
    public String verAlumnos()throws SQLException{
        ResultSet rs =objConecta.buscaDatos("select id_reservacion,curp,nombre,apellido_paterno \n" +
                                            "from lista_alumnos\n" +
                                            "natural join \n" +
                                            "alumno\n" +
                                            "where lista_alumnos.alumno=alumno.curp\n" +
                                            "order by id_reservacion");
        String nombre=" ";
        while(rs.next()){
            nombre+="<br>";
            nombre+="<table >";
            nombre+="<tr>";
            nombre+="<td>Reservacion:</td>";
            nombre+="<td>"+rs.getString(1)+"</td>";
            nombre+="</tr>";
            nombre+="<tr>";
            nombre+="<td>CURP:</td>";
            nombre+="<th>"+rs.getString(2)+"</th>";
            nombre+="</tr>";
            nombre+="<tr>";
            nombre+="<td>Nombre:</td>";
            nombre+="<th>"+rs.getString(3)+"</th>";
            nombre+="</tr>";
            nombre+="<td>Apellido:</td>";
            nombre+="<th>"+rs.getString(4)+"</th>";
            nombre+="</tr>";
            nombre+="</table>";
        }
        return nombre;
    }

    /**
     * Metodo para extraer el ultimo id insertado en 
     * las reservaciones
     * @return entero
     * @throws SQLException 
     */
    public int regresaID() throws SQLException{
         ResultSet rs=objConecta.buscaDatos("select count(id_reservacion)"
                                            +"from Reservacion");
         if(rs.next())
                return rs.getInt(1);
         return 0;    
     }
    
    /**
     * Metodos auxiliar para ingresar las zonas seleccionadas por 
     * el usuario
     * @param id_reservacion
     * @param id_zona
     * @return boolean si se puede ingresar las zonas
     */
     public boolean IngresaZonas(int id_reservacion,String id_zona){
         boolean r;
         String sql="INSERT INTO Zonas_visita(id_reservacion,id_zona) VALUES('"+id_reservacion+"','"+id_zona+"')";
           try {        
             r = objConecta.insertar(sql);
                return r;
           } catch (SQLException ex) {
             return true;
         }
     }
     
     /**
      * Metodo usado para desconectar las 
      * base 
      * @return boolean 
      */
     public boolean desco(){
         objConecta.desconectar();
         return true;
     }
}   
