package appV2;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JFrame;

//para mostrar sólo los 50 últimos resultados de la base de datos
//SELECT * FROM principal ORDER BY idprincipal DESC LIMIT 50

public class Incidencias {
	 private static String usuario = "root";
	 private static String pwd = "root";
	 private static String bd = "sat";
	 static ConexionBaseDatos2 conexion = null;
	 static Scanner scanner = new Scanner(System.in);
	 
	 public static void main(String[] args) {
		 conexion = new ConexionBaseDatos2(bd, usuario, pwd);
		VentanaIncidencia ventana = new VentanaIncidencia();		
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	 /** <p>Atributos </p>
		 */
		private  int idprincipal;
		private String fechaApertura;

		private String horario;
		private Date fechaInicio;
		private Date fechaFin;
		private String aula;
		private int idCurso;

	
	public static void cargarComboDeleg(){
		ResultSet filas = null;
		filas = ((ConexionBaseDatos2) ConexionBaseDatos2.conexion).getQuery("SELECT Dirección FROM delegacion");
		try {
			while(filas.next()){
				PanelNuevo.delegcb.addItem(filas.getString("Dirección"));
				
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	/*
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
	public ResultSet consultar(PanelNuevo paneles){
		ResultSet datos;
		String capturado = PanelNuevo.filtrotf.getText();
		String cidprincipal, cNombre, cFechaApertura,cdescripcion;
		System.out.println(capturado);	
		datos = VentanaPrincipal.conexion.getQuery("SELECT p.idprincipal, u.Nombre, p.FechaApertura, p.descripcion "
				+ "FROM  principal p JOIN usuario u  ON u.idUsuario = p.IdUsuario "+
				"WHERE p.FechaApertura LIKE '%"+capturado+"%' OR u.Nombre LIKE '%"+capturado+"%';");
   			
		try {
		      while(datos.next()){
		    	  cidprincipal = datos.getString("p.idprincipal"); 
		    	  cNombre = datos.getString("u.Nombre");
		    	  cFechaApertura = datos.getString("p.FechaApertura");
		    	  cdescripcion = datos.getString("p.descripcion");
		    	 paneles.getModelo().addRow( new Object[] {cidprincipal, cNombre, cFechaApertura,cdescripcion});
		 }}
		      catch (SQLException e) { e.printStackTrace();
			   }
		return datos;}
		
	*/

}
