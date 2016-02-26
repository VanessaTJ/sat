package appV2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



public class VentanaIncidencia extends JFrame{

	
	public VentanaIncidencia() {
		 
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/ucsIcon.gif"));
		setIconImage(icon);
		setSize(1200,720); 
		setTitle("Gestión SAT");
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(new Color(192,192,192));
		setVisible(true);

		PanelNuevo PanelNuevo = new PanelNuevo();
		add(PanelNuevo);
		
	}


	static class PanelNuevo extends JPanel implements ActionListener {

		private JTable tblincidencias = null;
		DefaultTableModel modelo = null;
		JScrollPane scrollArea;
		
		public JLabel idinclb,iddetlb,usuariolb,teleflb,emaillb,deleglb, tipolb, resueltalb,descripcionlb;
		public JTextField mastx,idinctx,iddettx,usuariotx,teleftx,emailtx;
		public static JComboBox delegcb;
		public JComboBox tipocb;
		public JComboBox resueltacb;
		public JButton masbu, modificarbu,insertarbt;
		public JTextArea mensajeSalida, descriptext;
		
		public PanelNuevo(){
			setLayout(null);
			setSize(1180,720);
			setBackground(new Color(192,192,192));
			setVisible(true);
			
	    	/**
	         * Creacion del panel scroll con tabla de llamadas
	         */ 
	   scrollArea = new JScrollPane();
	   String[] columnas = {"idIncid","idDetalle", "Fecha", "Usuario", "Teléfono", "email", "Delegación","Tipo","Resuelta", "Descripción"};
	   tblincidencias = new JTable();
	   modelo = new DefaultTableModel();
	   tblincidencias.setBackground(new Color(224,224,224));
	   scrollArea.setViewportView(tblincidencias);
	   scrollArea.setBounds(10,10,945,300); 
	   modelo.setColumnIdentifiers(columnas);
	   scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	   tblincidencias.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	   tblincidencias.setFillsViewportHeight(true);        
	        
	   tblincidencias.setModel(modelo);
	   TableColumn col1 = tblincidencias.getColumn("idIncid");
	   col1.setPreferredWidth(20);
	   TableColumn col2 = tblincidencias.getColumn("idDetalle");
	   col2.setPreferredWidth(20);
	   TableColumn col3 = tblincidencias.getColumn("Fecha");
	   col3.setPreferredWidth(50);
	   TableColumn col4 = tblincidencias.getColumn("Usuario");
	   col4.setPreferredWidth(80);
	   TableColumn col5 = tblincidencias.getColumn("Teléfono");
	   col5.setPreferredWidth(40);
	   TableColumn col6 = tblincidencias.getColumn("email");
	   col6.setPreferredWidth(80);
	   TableColumn col7 = tblincidencias.getColumn("Delegación");
	   col7.setPreferredWidth(80);
	   TableColumn col8 = tblincidencias.getColumn("Tipo");
	   col8.setPreferredWidth(50);
	   TableColumn col9 = tblincidencias.getColumn("Resuelta");
	   col9.setPreferredWidth(10);
	   TableColumn col10 = tblincidencias.getColumn("Descripción");
	   col10.setPreferredWidth(200);
	     
	   add(scrollArea);
	   
		mastx = new JTextField();
		mastx.setBounds(960,60,50,20);
		add(mastx);

		masbu = new JButton("+");
		masbu.setBounds(960,100,50,20);
		masbu.setBackground(new Color(100,224,224));
		masbu.addActionListener(this);
		add(masbu);

		idinclb = new JLabel ("NumInc");
		idinclb.setBounds(10,360,40,20);
		add(idinclb);

		idinctx = new JTextField();
		idinctx.setBounds(10,400,40,20);
		add(idinctx);

		iddetlb = new JLabel ("NumDetalle");
		iddetlb.setBounds(60,360,40, 20);
		add(iddetlb);

		iddettx = new JTextField();
		iddettx.setBounds(60,400,40,20);
		add(iddettx);
			
		usuariolb = new JLabel ("Usuario");
		usuariolb.setBounds(100,360, 200, 20);
		add(usuariolb);

		usuariotx = new JTextField();
		usuariotx.setBounds(100,400,200,20);
		add(usuariotx);	

		teleflb = new JLabel ("Teléfono");
		teleflb.setBounds(300,360, 100, 20);
		add(teleflb);

		teleftx = new JTextField();
		teleftx.setBounds(300,400,100,20);
		add(teleftx);
	
		emaillb = new JLabel ("Email");
		emaillb.setBounds(440,360, 150, 20);
		add(emaillb);

		emailtx = new JTextField();
		emailtx.setBounds(440,400,150,20);
		add(emailtx);

		deleglb = new JLabel ("Delegación");
		deleglb.setBounds(600,360, 120, 20);
		add(deleglb);

		delegcb = new JComboBox ();
		delegcb.setBounds(600,400,120,20);
		/*try {
			cargarComboDeleg();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		//Incidencias.menuIDDelegaciones();
		add(delegcb);
	
		tipolb = new JLabel ("Tipo");
		tipolb.setBounds(740,360, 80, 20); 
		add(tipolb);

		tipocb = new JComboBox();
		tipocb.setBounds(740,400,80,20);
		Incidencias.menuIncidencias();
		add(tipocb);
		
		resueltalb=new JLabel("resuelta");
		resueltalb.setBounds(850,360,80,20); 
		add(resueltalb);
		
		resueltacb = new JComboBox();
		resueltacb.setBounds(850,400,80,20);
		resueltacb.addItem("SI");
		resueltacb.addItem("NO");
		add(resueltacb);

		
		descripcionlb= new JLabel("Descripción");
		descripcionlb.setBounds(10,430,100,40);
		add(descripcionlb);

		descriptext = new JTextArea();
		descriptext.setBackground(new Color(224,224,224));
		descriptext.setBounds(10,470,500,100); 
		add(descriptext);
					
		modificarbu = new JButton("Modificar");
		modificarbu.setBounds(300,650,120,20);
		modificarbu.setBackground(new Color(100,224,224));
		add(modificarbu);
		modificarbu.addActionListener(this);
    	
		insertarbt = new JButton("Insertar");
		insertarbt.setBounds(465,650,120,20);
		insertarbt.setBackground(new Color(100,224,224));
		insertarbt.addActionListener(this);
    	add(insertarbt);			

		mensajeSalida = new JTextArea();
		mensajeSalida.setBackground(new Color(224,224,224));
		mensajeSalida.setBounds(520,470,320,20); 
		add(mensajeSalida);

	} 
		void cargarComboDeleg() throws SQLException {
			 String usuario = "root";
			 String pwd = "root";
			 String bd = "jdbc:mysql://localhost/nowedb";
			 
			 Connection conexion = DriverManager.getConnection(bd, usuario, pwd);
			 Statement sentenciaSql = conexion.createStatement();
		     ResultSet filas = sentenciaSql.executeQuery("Select dirección From delegacion");
		     try {
					while(filas.next()){
						delegcb.addItem(filas.getString("dirección"));
					}
				} catch (SQLException ex) {
				
					ex.printStackTrace();
				}   		
		 }
		/*
		public static void cargarComboDeleg() throws SQLException(){
			filas = VentanaPrincipal.conexion.getQuery("SELECT dirección FROM delegacion");
			try {
				while(filas.next()){
					PanelNuevo.iddelegcb.addItem(filas.getString("Dirección"));
					
				}
			}
			catch (SQLException e) {e.printStackTrace();
			}
		}
		
		*
		*
		*
		*
		*
		*
		* if (botonPulsado==masbu) {
	            	 /*para mostrar sólo los 50 últimos resultados de la base de datos
	            	  * int final DEFECTO50 =50;
	            	 if (mastx==""){"SELECT * FROM principal ORDER BY idprincipal DESC LIMIT" + DEFECTO50}
	            	 else 
	            	 "SELECT * FROM principal ORDER BY idprincipal DESC LIMIT" + (int)mastx
	            	 
	             
	            	 textareaconsulta.setText(Articulo.consultaArticulo());}
	            	 
	            	 
	            	 
	            	 
	            	 
	            	 
	            	 
	            	 
	       public static String insertar(int idIncid,	String idDetalle,	String fecha,	String usuario,	int telefono, String email, 
	String delegacion, String tipo, String resuelta, String descripcion){
		
		boolean ok = false;
		String resultado = null;
		try {
				ok = ConexionBaseDatos2.conexion.setQuery("INSERT INTO principal(idIncid, idDetalle, fecha, usuario, telefono, email, delegacion, tipo,	resuelta, descripcion)"
						+ "	 VALUES (" + idIncid + ","+ idDetalle+",'"+ fecha + "','"+ usuario	+"',"+ telefono +",'"+ email+"','"+ delegacion +
						"','" + resuelta +"','"+"'descripcion')");
				if(ok){
					
				JOptionPane.showMessageDialog(null, "Se insertó el registro ");	}
				else
					
				JOptionPane.showMessageDialog(null, "No se insertó el registro ");
					
			} 
		catch(Exception e){ e.printStackTrace(); }
		return resultado;}
		
	            	 */
		
		//creo las acciones
		 public void actionPerformed(ActionEvent e) {
	         	Object botonPulsado = e.getSource();
	         	
	            
		 }}}

		
	
		
	 