package basura;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VentanaBaseDatos extends JFrame{
	 public VentanaBaseDatos() {
	    	
	    	//Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
		    //setIconImage(icon);
		    setSize(885,525); 
		    setTitle("Gestión Sat");
		    setLocationRelativeTo(null);
	        Panel2 p = new Panel2(); 
			add(p); 
			
		    }

	}

	@SuppressWarnings("serial")
	class Panel2 extends JPanel implements ActionListener{
		public static JButton principal, usuarios, delegaciones, departamentos, detalle;
		 
		 public Panel2(){
			 setLayout(null);
			 setSize(885,525);
			 setBackground(new Color(192,192,192));
			 
			 
		principal = new JButton("principal");
		principal.setBounds(150,50,130,50);
		add(principal);
		
		usuarios = new JButton("usuarios");
		usuarios.setBounds(150,120,130,50);
		add(usuarios);
		
		delegaciones = new JButton("delegaciones");
		delegaciones.setBounds(150,190,130,50);
		add(delegaciones);
		
		departamentos = new JButton("departamentos");
		departamentos.setBounds(150,260,130,50);
		add(departamentos);
		
		detalle = new JButton("detalle");
		detalle.setBounds(150,330,130,50);
		add(detalle);
		
		 }
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	 }
	
	
	
	
	
	
	
	


