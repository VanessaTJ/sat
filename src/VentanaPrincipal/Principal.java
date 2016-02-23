package VentanaPrincipal;

import javax.swing.JFrame;

import sat.VentanaBaseDatos;
import sat.VentanaIncidencia;
public class Principal {
	public static void main(String[] args) {

		VentanaPrincipal ventana = new VentanaPrincipal();		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		VentanaIncidencia ventanainc = new VentanaIncidencia();		
		ventanainc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanainc.setVisible(false);
		
		VentanaBaseDatos ventana2 = new VentanaBaseDatos();		
		ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana2.setVisible(false);
	}

}
