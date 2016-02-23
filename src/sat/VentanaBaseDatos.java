package sat;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




public class VentanaBaseDatos extends JFrame{
//defino el marco general de esta ventana
	
	 public VentanaBaseDatos() {
			setSize(780,550);  
			//Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
	    	//setIconImage(icon);
			setTitle("Consultar base datos");
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			
			PanelBD p = new PanelBD();
			add(p);
		}
	/*class FrameListener extends WindowAdapter
		{
		   public void windowClosing(WindowEvent e)
		  {
		   System.out.println("Cerrando la conexión...");
		   VentanaBaseDatos.conexion.cerrarConexion();
		    System.exit(0);
		  }*/

}
		class PanelBD extends JPanel implements ActionListener, ChangeListener, ItemListener{
			//Defino los elementos que va a tener el panel
			//botones que indican a las distintas tablas que se acceden
			private JRadioButton detallesbt,delegacionesbt,departamentosbt , usuariosbt,personalsistemasbt ,tipoincidenciabt, principalbt;
			private ButtonGroup bg;
			JComboBox filtrocb;
			JButton selectbt,selectbt2;
			JTextField filtrotf;
			
			public static String usuario = "root";
			public static String pwd = "root";
			public static String bd = "sat";
			public static basedatos.ConexionBaseDatos conexion = null;
			// Connection conexion = DriverManager.getConnection(bd, usuario, pwd);
			
			public PanelBD()  {
				//coloco los elementos del panel
				setLayout(null);
				setBackground(new Color(192,192,192));
				
		        bg=new ButtonGroup();
		        principalbt=new JRadioButton("principal");
		        principalbt.setBounds(10,20,150,30);
		        principalbt.addChangeListener(this);        
		        add(principalbt);
		        bg.add(principalbt);
		        
		        detallesbt=new JRadioButton("detalles");
		        detallesbt.setBounds(10,70,150,30);
		        detallesbt.addChangeListener(this);
		        add(detallesbt);
		        bg.add(detallesbt);

		        departamentosbt=new JRadioButton("departamentos");
		        departamentosbt.setBounds(10,120,150,30);
		        departamentosbt.addChangeListener(this);        
		        add(departamentosbt);
		        bg.add(departamentosbt);
		        
		        usuariosbt=new JRadioButton("usuarios");
		        usuariosbt.setBounds(10,170,150,30);
		        usuariosbt.addChangeListener(this);        
		        add(usuariosbt);
		        bg.add(usuariosbt);
		        
		        personalsistemasbt=new JRadioButton("personalsistemas");
		        personalsistemasbt.setBounds(10,220,150,30);
		        personalsistemasbt.addChangeListener(this);        
		        add(personalsistemasbt);
		        bg.add(personalsistemasbt);
		        
		        tipoincidenciabt=new JRadioButton("tipoincidencia");
		        tipoincidenciabt.setBounds(10,270,150,30);
		        tipoincidenciabt.addChangeListener(this);        
		        add(tipoincidenciabt);
		        bg.add(tipoincidenciabt);
		        
		        delegacionesbt=new JRadioButton("delegaciones");
		        delegacionesbt.setBounds(10,320,150,30);
		        delegacionesbt.addChangeListener(this);        
		        add(delegacionesbt);
		        bg.add(delegacionesbt);
		        
		    	filtrocb=new JComboBox();
		    	filtrocb.setBounds(200,20,180,20);
		    	add(filtrocb);
		    	filtrocb.addItem("fecha (aaaammdd)");
		    	filtrocb.addItem("usuario (apellido)");
		    	filtrocb.addItem("delegacion (ciudad)");		        
		    	filtrocb.addItemListener(this);
		    	
		    	filtrotf = new JTextField();
		    	filtrotf.setBounds(200,60,180,20);
		    	add(filtrotf);
		    		    	
		    	selectbt = new JButton("seleccionar con filtro");
		    	selectbt.setBounds(400,20,280,60);
		    	selectbt.addActionListener(this);
		    	add(selectbt);
		    	selectbt2 = new JButton("seleccionar sin filtro");
		    	selectbt2.setBounds(400,130,280,200);
		    	selectbt2.addActionListener(this);
		    	add(selectbt2);
		    	
			}
			//funcionalidad de los radiobutton
			 public void stateChanged1(ChangeEvent e) {
				 String filtro;
			        if (principalbt.isSelected()) {
			            filtro = "principal";
			        }
			        if (detallesbt.isSelected()) {
			        	filtro = "detalles";
			        }
			        if (departamentosbt.isSelected()) {
			        	filtro = "departamento";
			        }     
			        if (usuariosbt.isSelected()) {
			        	filtro = "usuario";
			        }
			        if (personalsistemasbt.isSelected()) {
			        	filtro = "personalsistemas";
			        }
			        if (tipoincidenciabt.isSelected()) {
			        	filtro = "tipoincidencia";
			        }
			        if (delegacionesbt.isSelected()) {
			        	filtro = "delegación";
			        }
			           
			    }
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String valorParaWhere;
				if (filtrocb.getSelectedItem()=="fecha"){
					valorParaWhere ="FechaLlamada";
				}
				if (filtrocb.getSelectedItem()=="usuario"){
					valorParaWhere ="apellido+' '+nombre";
				}
				if (filtrocb.getSelectedItem()=="delegacion"){
					valorParaWhere ="delegacion";
				}
				// TODO Auto-generated method stub
				
			}
			
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void actionPerformed(ActionEvent e) {
			/*	Object botonPulsado = e.getSource();
				if(botonPulsado == selectbt){
					//para tomar el elemento del combobox método: getSelectedItem()
				}
				
				if(botonPulsado == selectbt2){
	           	 	BaseDatos.listar(this); //crear este método
				}*/
				
			}
			public static void main(String[] args) {
				
				VentanaBaseDatos ventana = new VentanaBaseDatos();		
				ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventana.setVisible(true);

			}

			
		}
