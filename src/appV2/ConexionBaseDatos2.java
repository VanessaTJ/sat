package appV2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBaseDatos2 {

 static final String URL = "jdbc:mysql://localhost/";
public static Object conexion;
 private Connection conn = null;
 
 //-----------------------------------------------------------------------------------
  
 public ConexionBaseDatos2(String bd,
		 				  String usuario,
		 				  String pwd) {
  try{
     Class.forName("com.mysql.jdbc.Driver");
     this.conn = DriverManager.getConnection(URL + bd, usuario, pwd);
     if(conn != null)
     {
       System.out.println("Conexi�n a la base de datos " + URL + bd + " OK");
     }
   }
   catch(SQLException ex)
   {
      System.out.println("No se pudo conectar a la base de datos" + URL + bd);
   }
   catch(ClassNotFoundException ex)
   {
      System.out.println(ex);
   }
 }
 
  //-----------------------------------------------------------------------------------
 
 /** Consultas (executeQuery())*/
 public ResultSet getQuery(String query){
    Statement sentenciaSql = null; //para crear el objeto que te permite hacer la sentencia
    ResultSet datos = null; //recoge los datos de la select
    
    
    try{
      sentenciaSql = conn.createStatement();//crear un objeto de tipo Statement para la conexion a la bd
      datos = sentenciaSql.executeQuery(query); //ejecuto la sentencia y se lo paso a datos
    }
    catch(SQLException e)
    {
      e.printStackTrace();
    }
    return datos;
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 /**Insertar, Modificar, Borrar (executeUpdate())*/
 public boolean setQuery(String query){
    Statement sentenciaSql = null;
    boolean resultado = false; //lo utilizamos para saber si se ha podido ejecutar 
    try{   
      sentenciaSql = conn.createStatement();
      int filas = sentenciaSql.executeUpdate(query);
      if(filas != 0) resultado = true;
      System.out.println("se han insertado/borrado "+filas+" fila/s.");// Encontr� una fila
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return resultado;
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 /**Cerrar la base de datos*/
 public void cerrarConexion(){
	 try {
		conn.close();
	} catch (SQLException e) {
//		e.printStackTrace();
	      System.out.println("No se pudo establecer la conexi�n: " + URL);
	} catch (NullPointerException e) {
//		e.printStackTrace();
	      System.out.println("No se pudo establecer la conexi�n: " + URL);
	}
 } 
}
