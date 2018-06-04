package EspaceMateriels;
import acceuil.*;
//import EspaceDocuments.TablDoc;
import EspaceMateriels.ModifierDouverture;
//import EspaceMateriels.ModifierInbound;
//import EspaceMateriels.ModifierOutbound;
//import EspaceMateriels.ModifierDOp;
import java.*;
import javax.swing.border.*;

import java.sql.ResultSet;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.BorderLayout;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JButton;







import acceuil.*;



@SuppressWarnings("unused")
public class Douverture extends JFrame {

	private static final long serialVersionUID = 1L;

	
	private JScrollPane jScrollPane = null;
	
	private JTable jTable = null;
	static Object[][] data = {};
	static String[] columnNames = {"Ireg","Pays","Opérateurs","Tap Code","Ouverture 24","Ouverture 35","Ouverture 32","Ouverture 24","Ouverture 35","Ouverture 32"};  //,"DateDajout"," Modele"};
	public  DefaultTableModel tableModel;

	private JPanel jContentPane = null;
	private JButton jButton_modifier = null;

	
	private MatteBorder border = null; 
	public Douverture parent=null;
	
	private JButton jButton_precedent = null;
	private JButton jButton_actualiser = null;
	private JButton jButton_importer = null;
	private JButton jButton_rechercher = null;
	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	ConnexionBD con;

	/**
	 * This is the default constructor
	 */
	public Douverture() {
		super();
		initialize();
		}

	
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			tableModel = new DefaultTableModel(data, columnNames);
			jTable = new JTable(tableModel){
				private static final long serialVersionUID = 2485117672771964339L;
	                public boolean isCellEditable ( int row, int column )
	                {
	                    return false;
	                }
			};
			jTable.setRowHeight(20);
			jTable.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
			jTable.setDefaultRenderer(Object.class, new jTableRender());
			JTableHeader header = jTable.getTableHeader();
			header.setFont(new Font("Dialog", Font.BOLD, 12));
			
			//jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			TableColumn column = jTable.getColumnModel().getColumn(0); 
			column.setMinWidth(0);
			column.setMaxWidth(0);
			column.setPreferredWidth(0);
			TableColumn column1 = jTable.getColumnModel().getColumn(1); 
			column1.setPreferredWidth(117); 
			TableColumn column2 = jTable.getColumnModel().getColumn(2); 
			column2.setPreferredWidth(125); 
			TableColumn column3 = jTable.getColumnModel().getColumn(3); 
			column3.setPreferredWidth(96); 
			TableColumn column4 = jTable.getColumnModel().getColumn(4); 
			column4.setPreferredWidth(81); 
			TableColumn column5 = jTable.getColumnModel().getColumn(5); 
			column5.setPreferredWidth(80); 
			TableColumn column6 = jTable.getColumnModel().getColumn(6); 
			column6.setPreferredWidth(78); 
			TableColumn column7 = jTable.getColumnModel().getColumn(7); 
			column7.setPreferredWidth(75); 
			TableColumn column8 = jTable.getColumnModel().getColumn(8); 
			column8.setPreferredWidth(75); 
			TableColumn column9 = jTable.getColumnModel().getColumn(9); 
			column9.setPreferredWidth(73); 
			
			
			
		}
		return jTable;
	}

	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1130, 568);
		this.setContentPane(getJContentPane());
		this.setTitle("OUVERTURES ROAMING");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        setIconImage(new ImageIcon(this.getClass().getResource("/LOGOS.jpg")).getImage());
        if (frameSize.height > screenSize.height) 
        {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) 
        {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2,(screenSize.height - frameSize.height) / 2);
		
		
		
		//this.setLocation(200, 200);
		this.setResizable(false);
		this.charger();
	
	}
		
		
	public void charger(){

		int compt=tableModel.getRowCount();
		for(int j=0;j<compt;j++){tableModel.removeRow(0);}
		//		Creation de la requete
		String req="select * from materiels order by NomPays";
		try{
			//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			
			curseur = con.rechercher(req);
			
			int i=0;
			while(curseur.next()){
				Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString(),curseur.getString(20).toString(),curseur.getString(21).toString(),curseur.getString(22).toString(),curseur.getString(23).toString(),curseur.getString(24).toString(),curseur.getString(25).toString()};
				System.out.print(curseur.getString(1));
				tableModel.insertRow(i,res);
				i++;
			}
			}catch(Exception e){
			
			}
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton_modifier(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButton_rechercher(), null);
			jContentPane.setLayout(null);
			jContentPane.add(getJButton_actualiser(), null);
			jContentPane.add(getJButton_precedent(), null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/fond818.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(getJButton_importer(), null);
			
		}
		return jContentPane;
	}
	
	
	/**
	 * This method initializes jButton_supprimer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_actualiser() {
		if (jButton_actualiser == null) {
			jButton_actualiser = new JButton();
			//jButton_actualiser.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButton_actualiser.setIcon(new ImageIcon(getClass().getResource("/actualiser5.png")));
			jButton_actualiser.setBounds(new Rectangle(994, 260, 116, 24));
			jButton_actualiser.setText("Actualiser");
			jButton_actualiser.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println("  ");
					charger();
					// TODO Auto-generated Event stub mouseClicked()
				}
			});
		}
		return jButton_actualiser;
	}
	
	
	private JButton getJButton_precedent() {
		if (jButton_precedent == null) {
			jButton_precedent = new JButton();
			//jButton_precedent.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButton_precedent.setIcon(new ImageIcon(getClass().getResource("/precedent.png")));
			jButton_precedent.setBounds(new Rectangle(994, 310, 116, 24));
			jButton_precedent.setText("Précédent");
			jButton_precedent.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println("  ");
					EspaceChoix(); 		// TODO Auto-generated Event stub mouseClicked()
					fermer();
				}

				
			});
		}
		return jButton_precedent;
	}
	
	private JButton getJButton_importer() {
		if (jButton_importer == null) {
			jButton_importer = new JButton();
			jButton_importer.setIcon(new ImageIcon(getClass().getResource("/save.png")));
			jButton_importer.setBounds(new Rectangle(994, 360, 116, 24));
			jButton_importer.setText("Enregistrer");
			jButton_importer.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					enregistrer();
					
				}
			});
		}
		return jButton_importer;
	}
	
	public void enregistrer(){
		new CreatExcelFileouverture(this).setVisible(true);
	}
	
	
	public void EspaceChoix(){
		EspaceChoix obj =new EspaceChoix();
		obj.setVisible(true);
	}	
	public void fermer(){
		dispose();
	}
	
	
	/**
	 * This method initializes jButton_modifier	
	 * 	
	 * @return javax.swing.JButton	
	 */	private JButton getJButton_modifier() {
			if (jButton_modifier == null) {
				jButton_modifier = new JButton();
				jButton_modifier.setBounds(new Rectangle(994, 160, 116, 24));
				jButton_modifier.setIcon(new ImageIcon(getClass().getResource("/add1.png")));
				jButton_modifier.setEnabled(true);
				jButton_modifier.setText("Modifier");
				jButton_modifier.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						if(jButton_modifier.isEnabled()){
							
							if(jTable.getSelectedRow()!=-1){
								
								modifier(Integer.parseInt((String)tableModel.getValueAt(jTable.getSelectedRow(), 0)));
						        
							}else{
								JOptionPane.showMessageDialog(null, "Aucun materiel n'a été séléctionné !");
							}
							
						}
						
					}
				});
		}	return jButton_modifier;
		}
	 
	        public void modifier(int code){
	        //	this.setEnabled(false);
	        	new ModifierDouverture(this,code).setVisible(true);
			}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(5, 118, 980, 395));
			jScrollPane.setViewportView(getJTable());
			jScrollPane.setForeground(new Color(255, 102, 153));
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	

	/**
	 * This method initializes jButton_rechercher	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_rechercher() {
		if (jButton_rechercher == null) {
			jButton_rechercher = new JButton();
			//jButton_rechercher.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButton_rechercher.setIcon(new ImageIcon(getClass().getResource("/search.png")));
			jButton_rechercher.setBounds(new Rectangle(994, 210, 116, 24));
			jButton_rechercher.setText("Rechercher");
			jButton_rechercher.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println("  ");
					rech();
					// TODO Auto-generated Event stub mouseClicked()
				}
			});
		}
		return jButton_rechercher;
	}
	public void rech(){
		RechercherDouverture rech =new RechercherDouverture(this);
		rech.setVisible(true);
	}


	public  void precedente(){
		dispose();
	
	}
	
	//*************************
	public void Cherchertapcode(String tapcode){
		//Vider la table des resultats
		int compt=tableModel.getRowCount();
		for(int j=0;j<compt;j++){tableModel.removeRow(0);}
	
//		Creation de la requete
		String req="select  ireg,NomPays,NomOperateur,TapCode,ouverture24i,ouverture35i,ouverture32i,ouverture24o,ouverture35o,ouverture32o from materiels where TapCode like '%"+tapcode+"%'";
		try{
//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			//chercher les materiels
			curseur = con.rechercher(req);
			int i=0;
			while(curseur.next())
			{
			Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString(),curseur.getString(5).toString(),curseur.getString(6).toString(),curseur.getString(7).toString(),curseur.getString(8).toString(),curseur.getString(9).toString(),curseur.getString(10).toString()};
			tableModel.insertRow(i,res);
		    
			i++;
			}
		}catch(Exception e){
			
		}}
	
	

	public void Cherchertesteur(String testeur){
		//Vider la table des resultats
		int compt=tableModel.getRowCount();
		for(int j=0;j<compt;j++){tableModel.removeRow(0);}
	
//		Creation de la requete
		String req="select  ireg,NomPays,NomOperateur,TapCode,ouverture24i,ouverture35i,ouverture32i,ouverture24o,ouverture35o,ouverture32o from materiels where Testeur like '%"+testeur+"%'";
		try{
//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			//chercher les materiels
			curseur = con.rechercher(req);
			int i=0;
			while(curseur.next())
			{
			Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString(),curseur.getString(5).toString(),curseur.getString(6).toString(),curseur.getString(7).toString(),curseur.getString(8).toString(),curseur.getString(9).toString(),curseur.getString(10).toString()};
			tableModel.insertRow(i,res);
		    
			i++;
			}
		}catch(Exception e){
			
		}}
	/**
	 * /Recherch par nom
	 */
	public void Chercherpays(String pays){
		//Vider la table des resultats
		int compt=tableModel.getRowCount();
		for(int j=0;j<compt;j++){tableModel.removeRow(0);}
	
//		Creation de la requete
		String req="select  ireg,NomPays,NomOperateur,TapCode,ouverture24i,ouverture35i,ouverture32i,ouverture24o,ouverture35o,ouverture32o from materiels where NomPays like '%"+pays+"%'";
		try{
//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			//chercher les materiels
			curseur = con.rechercher(req);
			int i=0;
			while(curseur.next())
			{
			Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString(),curseur.getString(5).toString(),curseur.getString(6).toString(),curseur.getString(7).toString(),curseur.getString(8).toString(),curseur.getString(9).toString(),curseur.getString(10).toString()};
			tableModel.insertRow(i,res);
		    
			i++;
			}
		}catch(Exception e){
			
		}}
	public void Cherchernom(String operateur){
		//Vider la table des resultats
		int compt=tableModel.getRowCount();
		for(int j=0;j<compt;j++){tableModel.removeRow(0);}
	
//		Creation de la requete
		String req="select  ireg,NomPays,NomOperateur,TapCode,ouverture24i,ouverture35i,ouverture32i,ouverture24o,ouverture35o,ouverture32o from materiels where NomOperateur like '%"+operateur+"%'";
		try{
//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			//chercher les materiels
			curseur = con.rechercher(req);
			int i=0;
			while(curseur.next())
			{
			Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString(),curseur.getString(5).toString(),curseur.getString(6).toString(),curseur.getString(7).toString(),curseur.getString(8).toString(),curseur.getString(9).toString(),curseur.getString(10).toString()};
			tableModel.insertRow(i,res);
		   // parant.charger();
			i++;
			}
		}catch(Exception e){
			
		}
		
	}
}  //  @jve:decl-index=0:visual-constraint="25,10"
