package sat;

import java.sql.ResultSet;
import java.sql.SQLException;

/**Esta ventana da acceso a la base de datos para hacer consultas SELECT 
 * Desde cada botón se accede a una tabla, sin hacer filtros combinados
 * if comboboxfiltrar filas=todo  hacer SELECT * FROM tabla 
 * if comboboxfiltrar filas=fechainicio y textfield aaaammdd hacer SELECT * FROM tabla where fechainicio=aaaammdd
 * if comboboxfiltrar filas=persona y textfield apellido hacer SELECT * FROM tabla where apellido=''
 * if comboboxfiltrar filas=delegacion y textfield ciudad hacer SELECT * FROM tabla where delegacion='hacer un concat 
 * que contenga la ciudad %mmmmm%
 * 
 * */
public class BaseDatos {
	public static String usuario = "root";
	public static String pwd = "root";
	public static String bd = "sat";
	public static basedatos.ConexionBaseDatos conexion = null;
	
	public void tablasSinFiltro(String radiobox){
		ResultSet datos;
		datos = conexion.getQuery("SELECT * FROM "+ radiobox);
		if (radiobox == "usuario"){
		
		}
	}
	public void tablasConFiltro(String radiobox, String combo, String filtrotf){
		ResultSet datos;
		datos = conexion.getQuery("SELECT * FROM "+ radiobox +" WHERE "+ combo +"="+ filtrotf);
	}
	

	
	/*Adaptar este método a este caso
	public static String listar(PanelBD panel){
		ResultSet datos;
		String cidGrupo, cidAcademia, cidOficial,chorario,cfecInicio,cfecFin,caula,cidCurso, resultado ="";
		
		 datos = VentanaBaseDatos.conexion.getQuery("SELECT * FROM "+ filtro);
		 try {
		      while(datos.next()){
		    	  cidGrupo = datos.getString("idGrupo"); 
		    	  cidAcademia = datos.getString("idAcademia");
		    	  cidOficial = datos.getString("idOficial");
		    	  chorario = datos.getString("horario");
		    	  cfecInicio = datos.getString("fechaInicio");
		    	  cfecFin = datos.getString("fechaFin");
		    	  caula = datos.getString("aula");
		    	  cidCurso = datos.getString("idCurso");
		    	  
		    	  panel.getModelo().addRow( new Object[] {cidGrupo, cidAcademia, cidOficial,chorario,cfecInicio,cfecFin,caula,cidCurso});} 
		      
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
		return resultado;
	}*/
	 
}
