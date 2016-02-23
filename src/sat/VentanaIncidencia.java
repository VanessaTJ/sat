package sat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import VentanaPrincipal.VentanaPrincipal;

public class VentanaIncidencia extends JFrame{


	public VentanaIncidencia() {
		 
		//Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
		//setIconImage(icon);
		setSize(900,725); 
		setTitle("Incidencia nueva");
		setLocationRelativeTo(null);
		setBackground(new Color(192,192,192));
		

		PanelNuevo PanelNuevo = new PanelNuevo();
		add(PanelNuevo);
		
	}

}

	class PanelNuevo extends JPanel implements ActionListener, ChangeListener, ItemListener {

		public static JLabel nuevousuariolb,nombrenuevolb,apellidonuevolb,telefnuevolb,emailnuevolb,
		iddepartlb,iddeleglbdelegacioneslb, resueltalb, personalSatRegislb, fechaFinRegislb,
		diaRegislb, mesRegislb,anyoRegislb,barraRegislb,barra2Regislb,duracionRegis, nombreregislb,
		apellidoregistlb, iddeleglb2, tipoIncidencialb, nuevoRigisLb,descripcionlb;
		public static JTextField nombrenuevocb,apellidonuevocb,telefnuevocb,emailnuevocb;
		public static JComboBox iddepartcb,iddelegcb,nombreRegiscb, apellidoRegiscb,
		tipoincidenciacb,resueltacb,personalSatcb,diaRegiscb,mesRegiscb,anyoRegiscb;;
		public static JButton añadirbu, añadirRegisbu, actualizarBd;
		public static JTextArea duracionRegisLl, detalletext;
		//para buscar incidencias que ya existen y queremos añadir detalles
		JComboBox filtrocb;
		JButton selectbt;
		static JTextField filtrotf;
		private JTable tblincidencias = null;
		DefaultTableModel modelo = null;
		JScrollPane scrollArea;
		
		public PanelNuevo(){
			setLayout(null);
			setSize(900,525);
			setBackground(new Color(192,192,192));
			setVisible(true);
			
			
		//////////////////////////////////////////////////////
		//////////////////NUEVO USUARIO////////////////////////
		//////////////////////////////////////////////////////
			
		
			
		nuevousuariolb = new JLabel ("USUARIO NUEVO");
		nuevousuariolb.setBounds(10,20,100,20);
		add(nuevousuariolb);

		nombrenuevolb = new JLabel ("usuario");
		nombrenuevolb.setBounds(10,60,100,20);
		add(nombrenuevolb);

		nombrenuevocb = new JTextField();
		nombrenuevocb.setBounds(140,60,235,20);
		add(nombrenuevocb);

		apellidonuevolb = new JLabel ("Apellidos");
		apellidonuevolb.setBounds(10,90, 100, 20);
		add(apellidonuevolb);

		apellidonuevocb = new JTextField();
		apellidonuevocb.setBounds(140,90,235,20);
		add(apellidonuevocb);

		telefnuevolb = new JLabel ("Telefono");
		telefnuevolb.setBounds(10,120, 100, 20);
		add(telefnuevolb);

		telefnuevocb = new JTextField();
		telefnuevocb.setBounds(140,120,235,20);
		add(telefnuevocb);

		emailnuevolb = new JLabel ("Email");
		emailnuevolb.setBounds(10,150, 100, 20);
		add(emailnuevolb);

		emailnuevocb = new JTextField();
		emailnuevocb.setBounds(140,150,235,20);
		add(emailnuevocb);

		iddepartlb = new JLabel ("Departamento");
		iddepartlb.setBounds(10,180, 100, 20);
		add(iddepartlb);

		iddepartcb = new JComboBox ();
		iddepartcb.setBounds(140,180,235,20);
		Incidencias.menuIDDepartamento();
		add(iddepartcb);

		iddeleglb2 = new JLabel ("Delegación");
		iddeleglb2.setBounds(10,210, 100, 20);
		add(iddeleglb2);

		iddelegcb = new JComboBox ();
		iddelegcb.setBounds(140,210,235,20);
		Incidencias.menuIDDelegaciones();
		add(iddelegcb);
		
		añadirbu = new JButton("AÑADIR");
		añadirbu.setBounds(140,245,80,20);
		añadirbu.setBackground(new Color(100,224,224));
		añadirbu.addActionListener(this);
		add(añadirbu);
		
		
		///////////////////////////////////////////////
		///////////////USUARIO REGISTRADO//////////////
		///////////////////////////////////////////////
		
		nuevoRigisLb = new JLabel ("USUARIO REGISTRADO");
		nuevoRigisLb.setBounds(450,20,150,20);
		add(nuevoRigisLb);
		
		nombreregislb = new JLabel ("usuario");
		nombreregislb.setBounds(450,60,100,20); 
		add(nombreregislb);

		nombreRegiscb = new JComboBox ();
		Incidencias.menuUsuarios();
		nombreRegiscb.setBounds(450+90,60,235,20); 
		add(nombreRegiscb);
		
		tipoIncidencialb = new JLabel ("tipo incidencia");
		tipoIncidencialb.setBounds(450,90, 100, 20); 
		add(tipoIncidencialb);

		tipoincidenciacb = new JComboBox();
		tipoincidenciacb.setBounds(450+90,90,235,20);
		Incidencias.menuIncidencias();
		add(tipoincidenciacb);
		
		resueltalb=new JLabel("resuelta");
		resueltalb.setBounds(450,120,800,20); 
		add(resueltalb);
		
		resueltacb = new JComboBox();
		resueltacb.setBounds(450+90,120,235,20);
		resueltacb.addItem("SI");
		resueltacb.addItem("NO");
		add(resueltacb);

		personalSatRegislb=new JLabel("personalSat"); 
		personalSatRegislb.setBounds(450,150,80,20);
		add(personalSatRegislb);
		
		personalSatcb = new JComboBox();
		personalSatcb.setBounds(450+90,150,235,20);
		Incidencias.menuUsuariosSat();
		add(personalSatcb); 
		

		/*personalSatRegislb=new JLabel("personalSat");
		personalSatRegislb.setBounds(450,180,80,20);
		add(personalSatRegislb);
		
		personalSatcb = new JComboBox();
		personalSatcb.setBounds(450+90,180,235,20);
		Incidencias.menuUsuariosSat();
		add(personalSatcb);*/

		
		//etiquetas y combobox de la fecha 
		
		fechaFinRegislb=new JLabel("FECHA FIN");
		fechaFinRegislb.setBounds(450,215,80,20);
		add(fechaFinRegislb);

		diaRegislb=new JLabel("dia");
		diaRegislb.setBounds(450,230,30,40);
		add(diaRegislb);
		
		barraRegislb=new JLabel("/");
		barraRegislb.setBounds(480,230,10,40);
		add(barraRegislb);
		
		mesRegislb=new JLabel("mes");
		mesRegislb.setBounds(495,230,30,40);
		add(mesRegislb);
		
		barra2Regislb=new JLabel("/");
		barra2Regislb.setBounds(535,230,10,40);
		add(barra2Regislb);
		
		anyoRegislb=new JLabel("año");
		anyoRegislb.setBounds(550,230,30,40);
		add(anyoRegislb);
		
		//combobox del dia
		diaRegiscb = new JComboBox();
		diaRegiscb.setBounds(450,265,40,20);
		add(diaRegiscb);
		for(int i = 1; i < 32; i++){
			diaRegiscb.addItem(i);}		
			diaRegiscb.addActionListener(this); 

		//comobox del mes
		mesRegiscb = new JComboBox();
		mesRegiscb.setBounds(495,265,40,20);
		add(mesRegiscb);
		for(int i = 1; i < 13; i++){
		mesRegiscb.addItem(i);}
		mesRegiscb.addActionListener(this); 

		//combobox del año
		anyoRegiscb = new JComboBox();
		anyoRegiscb.setBounds(540,265,60,20);
		add(anyoRegiscb);
		for(int i = 2016; i < 2021; i++){
			anyoRegiscb.addItem(i);}
		anyoRegiscb.addActionListener(this); 
		
		añadirRegisbu = new JButton("AÑADIR");
		añadirRegisbu.setBounds(450,300,80,20);
		añadirRegisbu.setBackground(new Color(100,224,224));
		add(añadirRegisbu);
		añadirRegisbu.addActionListener(this);
		
		
		duracionRegis= new JLabel("Duracion");
		duracionRegis.setBounds(20,555,100,40);
		add(duracionRegis);

		duracionRegisLl = new JTextArea();
		duracionRegisLl.setBackground(new Color(224,224,224));
		duracionRegisLl.setBounds(20,590,80,20); 
		add(duracionRegisLl);
		
		descripcionlb= new JLabel("Descripción");
		descripcionlb.setBounds(140,555,100,40);
		add(descripcionlb);

		detalletext = new JTextArea();
		detalletext.setBackground(new Color(224,224,224));
		detalletext.setBounds(140,590,450,80); 
		add(detalletext);
		
		
		//para añadir detalles a las incidencias
         
    	filtrocb=new JComboBox();
    	filtrocb.setBounds(20,400,180,20);
    	add(filtrocb);
    	filtrocb.addItem("fecha (aaaammdd)");
    	filtrocb.addItem("usuario (apellido)");
    	filtrocb.addItem("delegacion (ciudad)");		        
    	filtrocb.addItemListener(this);
    	
    	filtrotf = new JTextField();
    	filtrotf.setBounds(20,440,180,20);
    	add(filtrotf);
    		    	
    	selectbt = new JButton("seleccionar");
    	selectbt.setBounds(250,400,120,20);
    	selectbt.addActionListener(this);
    	add(selectbt);
    	
    	/**
         * Creacion del panel scroll con tabla de cursos
         */ 
    	scrollArea = new JScrollPane();
        String[] columnas = {"idprincipal","FechaApertura", "Nombre", "descripción"};
        tblincidencias = new JTable();
        modelo = new DefaultTableModel();
        tblincidencias.setBackground(new Color(224,224,224));
        scrollArea.setViewportView(tblincidencias);
        scrollArea.setBounds(450,400,370,160); 
        modelo.setColumnIdentifiers(columnas);
        scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tblincidencias.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblincidencias.setFillsViewportHeight(true);        
        
        tblincidencias.setModel(modelo);
        TableColumn col1 = tblincidencias.getColumn("idprincipal");
        col1.setPreferredWidth(30);
        TableColumn col2 = tblincidencias.getColumn("FechaApertura");
        col2.setPreferredWidth(100);
        TableColumn col3 = tblincidencias.getColumn("Nombre");
        col3.setPreferredWidth(100);
        TableColumn col4 = tblincidencias.getColumn("descripción");
        col4.setPreferredWidth(200);
        add(scrollArea);
        
        actualizarBd = new JButton("AÑADIR");
        actualizarBd.setBounds(600,400,80,20);
        actualizarBd.setBackground(new Color(100,224,224));
		add(actualizarBd);
		actualizarBd.addActionListener(this);
		
    	
		//al recoger los datos seleccionados de la fecha del combobox concatenarlos y pasarlos a un String
		//la fecha inicial pasarla a un String nada más recogerla

		//descripcionta = new JTextArea();
		//descripcionta.setBackground(new Color(224,224,224));
		//descripcionta.setBounds(140,440,520,20); 
		//add(descripcionta);
		
	} //fin del panel


		@Override
			public void actionPerformed(ActionEvent e){
			Object botonPulsado = e.getSource();
			
			
			if (botonPulsado == añadirbu){
				String nombrenuevo,apellidonuevo,telefnuevo,emailnuevo;
				
				nombrenuevo =nombrenuevocb.getText();
				apellidonuevo =apellidonuevocb.getText();
				telefnuevo =telefnuevocb.getText();
				emailnuevo =emailnuevocb.getText();
				int tlfnint = Integer.parseInt(telefnuevo);
				
				insertar(nombrenuevo,
						apellidonuevo,
						tlfnint,
						emailnuevo,						 
						(String)iddepartcb.getSelectedItem(),
						(String)iddelegcb.getSelectedItem());}
				
			////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////
			///ERROR A LA HORA DE INSERTAR MIRAR BIEN QUE PASA////
			///////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////
				
		if (botonPulsado == selectbt){
			PanelNuevo paneles = new PanelNuevo();
			consultar(paneles);
			
			}
		
		
		
		
			
			
			
		            	}//FIN DEL ACTION
	
		public ResultSet consultar(PanelNuevo paneles){
    		ResultSet datos;
    		String capturado = PanelNuevo.filtrotf.getText();
    		String cidGrupo, cidAcademia, cidOficial,chorario;
    		System.out.println(capturado);	
    		datos = VentanaPrincipal.conexion.getQuery("SELECT p.idprincipal, u.Nombre, p.FechaApertura, d.descripcion "
    				+ "FROM  principal p JOIN (usuario u , detalles d) ON u.idUsuario = p.IdUsuario and d.incidencia = p.idprincipal"+
    				"WHERE p.FechaApertura LIKE '%"+capturado+"%' OR u.Nombre LIKE '%"+capturado+"%';");
       			
    		try {
    		      while(datos.next()){
    		    	  cidGrupo = datos.getString("p.idprincipal"); 
    		    	  cidAcademia = datos.getString("u.Nombre");
    		    	  cidOficial = datos.getString("p.FechaApertura");
    		    	  chorario = datos.getString("d.descripcion");
    		    	 paneles.getModelo().addRow( new Object[] {cidGrupo, cidAcademia, cidOficial,chorario});
    		 }}
    		      catch (SQLException e) { e.printStackTrace();
    			   }
    		return datos;}
		
		////////////////////////////////////////////////////////////////
		////////////////////METODO INSERTAR///////////////////////////
		////////////////////////MODIFICAR/////////////////////////////
		//habra que poner el id sel usuario auto incrementa para a la hora de insertar lo pueda poner en nulo
		//hacer dos select antes para el deparetamento y la delegacion.
		
		public static String insertar(String nombre,
									String apellidos, 
									int telefono, 
									String email,
									String departamento,
									String delegacion){
			
	boolean ok;
	
	int a = 0,b = 0;
	
	String resultado = null;
	ResultSet datos1 = VentanaPrincipal.conexion.getQuery("SELECT iddepartamento FROM departamento WHERE nomDepartamento  = '"+departamento+"'");
	ResultSet datos2 = VentanaPrincipal.conexion.getQuery("SELECT idDelegacion FROM delegacion WHERE Dirección = '"+delegacion+"'");
	try {
		
		while(datos1.next())
			a = datos1.getInt("iddepartamento".toString());
		while(datos2.next())
			b = datos2.getInt("idDelegacion".toString());
		
		
		System.out.println(a);
		System.out.println(b);
		
		
	ok = VentanaPrincipal.conexion.setQuery("INSERT INTO usuario (IdUsuario,nombre,Telefono, Email,Departamento,Delegacion)"
		+ " VALUES (0,'"+nombre+"','" + telefono + "','"+email+ "',"+a+ ","+  b +")");
	if (ok) {
	 resultado = "Se insertó la incidencia correctamente";
	 System.out.println(resultado);}
	else {
	resultado = "No se pudo insertar la incidencia";	 
	System.out.println(resultado);}
	} 
	
	catch(Exception e){ e.printStackTrace(); }
	return resultado;
	
	}
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	 	public DefaultTableModel getModelo() {
	 		 return modelo;
	 	 	}

	 	 	public void setModelo(DefaultTableModel modelo) {
	 		 this.modelo = modelo;
	 	 	}	
		
	} 

	
		
			
				
			

		 	
				
			
			

		
	