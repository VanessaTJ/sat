package sat;

import java.sql.ResultSet;
import java.sql.SQLException;
import VentanaPrincipal.VentanaPrincipal;
import sat.VentanaIncidencia;

public class Incidencias {
	 static ResultSet filas = null;
	
	public static void menuIDDelegaciones(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT Dirección FROM delegacion");
		try {
			while(filas.next()){
				PanelNuevo.iddelegcb.addItem(filas.getString("Dirección"));
				
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	
	public static void menuIDDepartamento(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT nomDepartamento FROM departamento");
		try {
			while(filas.next()){
				PanelNuevo.iddepartcb.addItem(filas.getString("nomDepartamento"));
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	
	public static void menuIncidencias(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT NombreIncidencia FROM tipoincidencia");
		try {
			while(filas.next()){
				PanelNuevo.tipoincidenciacb.addItem(filas.getString("NombreIncidencia"));
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	
	public static void menuUsuariosSat(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT nombre FROM personalsistemas");
		try {
			while(filas.next()){
				PanelNuevo.personalSatcb.addItem(filas.getString("nombre"));
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	
	public static void menuUsuarios(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT Nombre FROM usuario");
		try {
			while(filas.next()){
				PanelNuevo.nombreRegiscb.addItem(filas.getString("Nombre"));
			}
		
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	//filtrar qué incidencias quieres ver y mostrarlas en la tabla
	public static ResultSet consultar(String idGrupo,PanelNuevo paneles){
		ResultSet datos;
		String capturado = PanelNuevo.filtrotf.getText();
		String cidGrupo, cidAcademia, cidOficial,chorario;
		datos = VentanaPrincipal.conexion.getQuery("SELECT p.idprincipal, u.Nombre, p.FechaApertura, d.descripcion"+ 
				"FROM  principal p JOIN (usuario u , detalles d) ON u.idUsuario = p.IdUsuario and d.incidencia = p.idprincipal"+
				"WHERE p.FechaApertura LIKE '%"+capturado+"%' OR u.Nombre LIKE '%"+capturado+"%';");
				
		try {
		      while(datos.next()){
		    	  cidGrupo = datos.getString("idprincipal"); 
		    	  cidAcademia = datos.getString("Nombre");
		    	  cidOficial = datos.getString("FechaApertura");
		    	  chorario = datos.getString("descripcion");

		    	  paneles.getModelo().addRow( new Object[] {cidGrupo, cidAcademia, cidOficial,chorario});
		 }}
		      catch (SQLException e) { e.printStackTrace();
			   }
	
		return datos;}
		
	

	/*
	 * if (boton == añadirRegisbu){
	 * INSERT INTO  usuario (idUsuario, nombre,telefono, email, delegacion, departamento) VALUES
	 * (0, , , , )
	 * 
	 * }
	 * 
	 * */
	
}
