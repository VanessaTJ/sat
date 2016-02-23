package VentanaPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import VentanaPrincipal.Principal;
import sat.VentanaBaseDatos;
import sat.VentanaIncidencia;

public class VentanaPrincipal extends JFrame implements ActionListener{

		public static String usuario = "root";
		public static String pwd = "root";
		public static String bd = "sat";
		public static basedatos.ConexionBaseDatos conexion = null;
		public static JButton incidencia, baseDatos;
		static ResultSet filas = null;
		 
	 public VentanaPrincipal() {
	    	
	    	//Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
		    //setIconImage(icon);
		    setSize(900,525); 
		    setTitle("Gestión Sat");
		    setLayout(null);
		    setLocationRelativeTo(null);
	        Panel p = new Panel(); 
	        setBackground(new Color(192,192,192));
			add(p); 

		incidencia = new JButton("Gestión incidencias");
		incidencia.setBounds(250,150,150,50);
		incidencia.addActionListener(this);
		add(incidencia);
		
		baseDatos = new JButton("Base Datos");
		baseDatos.setBounds(450,150,130,50);
		baseDatos.addActionListener(this);
		add(baseDatos);}
		 
		
		/*Metodo de llamada de tiempo en milisegundos
		 * 
		 * */
		@Override
		public void actionPerformed(ActionEvent e) {
			Object boton = e.getSource();
			
			if (boton == incidencia){
				conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
				VentanaIncidencia ventanainc = new VentanaIncidencia();
				ventanainc.setVisible(true);	
			}
			
			if (boton == baseDatos){
				conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
				VentanaBaseDatos ventanabase = new VentanaBaseDatos();
				ventanabase.setVisible(true);
			}
			
			
			
		}
			
			// TODO Auto-generated method stub
			public static String crearUsuario(){
				return usuario;}

	 }
	
	
	
	
	
	
	
	
	
	

