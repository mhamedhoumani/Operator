package EspaceMateriels;
import acceuil.*;
//import EspaceDocuments.TablDoc;
import EspaceMateriels.ModifierMateriel;
import EspaceMateriels.ModifierInbound;
import EspaceMateriels.ModifierOutbound;
import EspaceMateriels.ModifierDOp;
import java.*;
import javax.swing.border.*;

import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.sql.ResultSet;
import java.awt.Component;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.BorderLayout;

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
public class TableauMateriel extends JFrame {

	private static final long serialVersionUID = 1L;

	
	private JScrollPane jScrollPane = null;
	
	private JTable jTable = null;
	static Object[][] data = {};
	static String[]columnNames = {"Ireg","Pays","Opérateurs","Tap Code"};
	public  DefaultTableModel tableModel;
	
	private JPanel jContentPane = null;

	private JButton jButton_ajouter = null;

	private JButton jButton_supprimer = null;

	private JButton jButton_modifier = null;

	
	private MatteBorder border = null; 
	private TableauMateriel parant=null;
	public TableauMateriel parent=null;
	
	private JButton jButton_importer = null;
	private JButton jButton_precedent = null;
	private JButton jButton_actualiser = null;
	private JButton jButton_inbound = null;
	private JButton jButton_outbound = null;
	private JButton jButton_dop = null;


	private JButton jButton_rechercher = null;
	private JButton jButtonConsulter = null;
	private JButton jButton_document = null;

	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	ConnexionBD con;

	/**
	 * This is the default constructor
	 */
	public TableauMateriel() {
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
			JTableHeader header = jTable.getTableHeader();
			header.setFont(new Font("Dialog", Font.BOLD, 12));
			
			//jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			TableColumn column = jTable.getColumnModel().getColumn(0); 
			column.setMinWidth(0);
			column.setMaxWidth(0);
			column.setPreferredWidth(0);
			TableColumn column1 = jTable.getColumnModel().getColumn(1); 
			column1.setPreferredWidth(158); 
			TableColumn column2 = jTable.getColumnModel().getColumn(2); 
			column2.setPreferredWidth(158); 
			TableColumn column3 = jTable.getColumnModel().getColumn(3); 
			column3.setPreferredWidth(150); 
			
		
		}
		return jTable;
	}

	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(614, 468);
		this.setContentPane(getJContentPane());
		this.setTitle(" LISTES DES OPERATEURS");
		
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
				Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString()};
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
			jContentPane.add(getJButton_ajouter(), null);
			jContentPane.add(getJButton_supprimer(), null);
			jContentPane.add(getJButton_modifier(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButton_rechercher(), null);
			jContentPane.setLayout(null);
			jContentPane.add(getJButton_actualiser(), null);
			jContentPane.add(getJButton_precedent(), null);
			jContentPane.add(getJButton_importer(), null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/fond7.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(getJButton_inbound(), null);
			jContentPane.add(getJButton_outbound(), null);
			jContentPane.add(getJButton_dop(), null);
			jContentPane.add(getJButtonConsulter(), null);
			jContentPane.add(getJButton_document(), null);
		}
		return jContentPane;
	}
	
	
	
	
	 
		private JButton getJButton_document() {
			if (jButton_document == null) {
				jButton_document = new JButton();
				jButton_document.setIcon(new ImageIcon(getClass().getResource("/file.gif")));
				jButton_document.setBounds(new Rectangle(486, 70, 116, 24));
				jButton_document.setText("Documents");
				jButton_document.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							if(jButton_document.isEnabled()){
						
								
								if(jTable.getSelectedRow()!=-1){
									
									
									document(Integer.parseInt((String)tableModel.getValueAt(jTable.getSelectedRow(), 0)));
									
								}else{
									JOptionPane.showMessageDialog(null, "Aucun opérateur n'a été séléctionné !");
								}
								
							}
							
						}
					});
				}
				return jButton_document;
		}		
		
		 public void document(int code){
		        	new Docs(this,code).setVisible(true);
				}

	/**
	 * This method initializes jButton_ajouter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_ajouter() {
		if (jButton_ajouter == null) {
			jButton_ajouter = new JButton();
			jButton_ajouter.setBounds(new Rectangle(486, 110, 116, 24));
			jButton_ajouter.setIcon(new ImageIcon(getClass().getResource("/add1.png")));
			jButton_ajouter.setText("Ajouter");
			jButton_ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					ajouter();
			
				}
			});
		}
		return jButton_ajouter;
	}
	

	public void ajouter(){
	
		new Ajouter_Materiel(this).setVisible(true);
	
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
			jButton_actualiser.setBounds(new Rectangle(486, 310, 116, 24));
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
			jButton_precedent.setBounds(new Rectangle(486, 350, 116, 24));
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
			//jButton_precedent.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButton_importer.setIcon(new ImageIcon(getClass().getResource("/save.png")));
			jButton_importer.setBounds(new Rectangle(486, 390, 116, 24));
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
		new CreatExcelFiletableau(this).setVisible(true);
	}
	
	public void EspaceChoix(){
		EspaceChoix obj =new EspaceChoix();
		obj.setVisible(true);
	}	
	public void fermer(){
		dispose();
	}

	
	private JButton getJButton_supprimer() {
		if (jButton_supprimer == null) {
			jButton_supprimer = new JButton();
			jButton_supprimer.setBounds(new Rectangle(486, 230, 116, 24));
			//jButton_supprimer.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButton_supprimer.setIcon(new ImageIcon(getClass().getResource("/remove.png")));
			jButton_supprimer.setText("Supprimer");

			jButton_supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(jButton_supprimer.isEnabled()){
						if(jTable.getSelectedRow()!=-1){
							int bouton = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment supprimer l'opérateur en cours?","Attention",JOptionPane.OK_CANCEL_OPTION);
					        if(bouton==JOptionPane.YES_OPTION){
					        	select((String)tableModel.getValueAt(jTable.getSelectedRow(), 0));
					        	Sup();
					        	supprimer((String)tableModel.getValueAt(jTable.getSelectedRow(), 0));
					     
					        	charger();

					        }
						}else{
							JOptionPane.showMessageDialog(null, "Rien à supprimer !");
						}
						
					}
					
				}
			});
		}
		return jButton_supprimer;
	}
	public void supprimer(String cod){
		
		String req="delete from materiels  where ireg="+Integer.parseInt(cod)+"";
		String req1="update materiels set ireg=ireg-1 where ireg > "+Integer.parseInt(cod)+"";
		System.out.println(req);
		//Ouverture de la connexion 
		con=new ConnexionBD(url,nomDriver);
		//Execution de requete
		con.supprime(req);
		con.supprime(req1);

	}
	String s,s1;
	
	public void select(String cod){
		
		ResultSet curseur = null;
			String req="select  ireg,NomPays,NomOperateur from materiels where ireg="+Integer.parseInt(cod)+"";
			System.out.println(req);
			//Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			//Execution de requete
			curseur=con.rechercher(req);
	

	try{
		int i=0;
		while(curseur.next()){

			    s = curseur.getString(2);
			    s1=curseur.getString(3);
			System.out.println(s);
			System.out.println(s1);
			i++;
		} 
		}
	
		catch(Exception ex){
			
		}
		
	
}


public  void Sup()
	{
	  
	      int in;
	      byte[] byteArray;
	      File archivo ;
	      String direccionArchivo;
	      String IP = "10.199.5.207";
	      int i=0;
	      try
	      {
	     
	          Socket via = new Socket(IP, 1234);
	          if(via.isConnected())
	          {
	  
	        String x="  ";
	         
	            DataOutputStream dos = new DataOutputStream(via.getOutputStream());
	            dos.writeUTF(x);
	         dos.writeUTF(s);
	      dos.writeUTF(s1);
	          dos.writeInt(1);

	 
	         
	 via.close();        
	
	 
	        }
	 
	      }catch (Exception e) {//JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
	    	  }

	}
	/**
	 * This method initializes jButton_modifier	
	 * 	
	 * @return javax.swing.JButton	
	 */	private JButton getJButton_modifier() {
			if (jButton_modifier == null) {
				jButton_modifier = new JButton();
				jButton_modifier.setBounds(new Rectangle(486, 190, 116, 24));
				//jButton_modifier.setFont(new Font("Times New Roman", Font.BOLD, 12));
				jButton_modifier.setIcon(new ImageIcon(getClass().getResource("/edit.png")));
				jButton_modifier.setEnabled(true);
				jButton_modifier.setText("Modifier");
				jButton_modifier.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						if(jButton_modifier.isEnabled()){
							
							if(jTable.getSelectedRow()!=-1){
								
								modifier(Integer.parseInt((String)tableModel.getValueAt(jTable.getSelectedRow(), 0)));
						        
							}else{
								JOptionPane.showMessageDialog(null, "Aucun opérateur n'a été séléctionné !");
							}
							
						}
						
					}
				});
		}	return jButton_modifier;
		}
	 
	        public void modifier(int code){
	        	new ModifierMateriel(this,code).setVisible(true);
			}
	        
	        public void modifieri(int code){
		        	new ModifierInbound(this,code).setVisible(true);
				}
	        
	        public void modifiero(int code){
		        	new ModifierOutbound(this,code).setVisible(true);
				}
	        
	        public void modifierd(int code){
		        	new ModifierDOp(this,code).setVisible(true);
				}
	      
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(0, 70, 471, 295));
			jScrollPane.setViewportView(getJTable());
			jScrollPane.setForeground(new Color(255, 102, 153));
		}
		return jScrollPane;
	}
	private JButton getJButtonConsulter() {
		if (jButtonConsulter == null) {
			jButtonConsulter = new JButton();
			//jButtonConsulter.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButtonConsulter.setIcon(new ImageIcon(getClass().getResource("/commande.png")));
			jButtonConsulter.setBounds(new Rectangle(486, 270, 116, 24));
			jButtonConsulter.setText("Consulter");
			jButtonConsulter.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(jButtonConsulter.isEnabled()){
				
						
						if(jTable.getSelectedRow()!=-1){
							
							
							consulter(Integer.parseInt((String)tableModel.getValueAt(jTable.getSelectedRow(), 0)));
							
						}else{
							JOptionPane.showMessageDialog(null, "Aucun opérateur n'a été séléctionné !");
						}
						
					}
					
				}
			});
		}
		return jButtonConsulter;
		
	}
	public void consulter(int code){
		//this.setEnabled(false);
		new ConsulterMateriel(this,code).setVisible(true);
	}
	
	
	

	private JButton getJButton_inbound() {
		if (jButton_inbound == null) {
			jButton_inbound = new JButton();
			/*jButton_inbound.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButton_inbound.setIcon(new ImageIcon(getClass().getResource("/commande.gif")));*/
			jButton_inbound.setBounds(new Rectangle(230, 390, 118, 24));
			jButton_inbound.setText("Test Inbound");
			jButton_inbound.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(jButton_inbound.isEnabled()){
						
						if(jTable.getSelectedRow()!=-1){
							
							modifieri(Integer.parseInt((String)tableModel.getValueAt(jTable.getSelectedRow(), 0)));
					        
						}else{
							JOptionPane.showMessageDialog(null, "Aucun opérateur n'a été séléctionné !");
						}
						
					}
					
				}
			});
		}
		return jButton_inbound;
		
	}	
	

	
	private JButton getJButton_outbound() {
		if (jButton_outbound == null) {
			jButton_outbound = new JButton();
			/*jButton_inbound.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButton_inbound.setIcon(new ImageIcon(getClass().getResource("/commande.gif")));*/
			jButton_outbound.setBounds(new Rectangle(355, 390, 118, 24));
			jButton_outbound.setText("Test Outbound");
			jButton_outbound.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(jButton_outbound.isEnabled()){
						
						if(jTable.getSelectedRow()!=-1){
							
							modifiero(Integer.parseInt((String)tableModel.getValueAt(jTable.getSelectedRow(), 0)));
					        
						}else{
							JOptionPane.showMessageDialog(null, "Aucun opérateur n'a été séléctionné !");
						}
						
					}
					
				}
			});
		}
		return jButton_outbound;
		
	}
	
	
	private JButton getJButton_dop() {
		if (jButton_dop == null) {
			jButton_dop = new JButton();
			/*jButton_inbound.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButton_inbound.setIcon(new ImageIcon(getClass().getResource("/commande.gif")));*/
			jButton_dop.setBounds(new Rectangle(105, 390, 118, 24));
			jButton_dop.setText("Detail de test");
			jButton_dop.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(jButton_dop.isEnabled()){
						
						if(jTable.getSelectedRow()!=-1){
							
							modifierd(Integer.parseInt((String)tableModel.getValueAt(jTable.getSelectedRow(), 0)));
					        
						}else{
							JOptionPane.showMessageDialog(null, "Aucun opérateur n'a été séléctionné !");
						}
						
					}
					
				}
			});
		}
		return jButton_dop;
		
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
			jButton_rechercher.setBounds(new Rectangle(486, 150, 116, 24));
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
		RechercherMateriel rech =new RechercherMateriel(this);
		rech.setVisible(true);
	}


	public  void precedente(){
		dispose();
	
	}
	
	//********************
	
	public void Cherchertapcode(String tapcode){
		//Vider la table des resultats
		int compt=tableModel.getRowCount();
		for(int j=0;j<compt;j++){tableModel.removeRow(0);}
	
//		Creation de la requete
		String req="select  ireg,NomPays,NomOperateur,TapCode from materiels where TapCode like '%"+tapcode+"%'";
		try{
//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			//chercher les materiels
			curseur = con.rechercher(req);
			int i=0;
			while(curseur.next())
			{
			Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString()};
			tableModel.insertRow(i,res);
		    
			i++;
			}
		}catch(Exception e){
			
		}}
	/**
	 * /Recherch par code
	 */
	public void Cherchertesteur(String testeur){
		//Vider la table des resultats
		int compt=tableModel.getRowCount();
		for(int j=0;j<compt;j++){tableModel.removeRow(0);}
	
//		Creation de la requete
		String req="select  ireg,NomPays,NomOperateur,TapCode from materiels where Testeur like '%"+testeur+"%'";
		try{
//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			//chercher les materiels
			curseur = con.rechercher(req);
			int i=0;
			while(curseur.next())
			{
			Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString()};
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
		String req="select  ireg,NomPays,NomOperateur,TapCode from materiels where NomPays like '%"+pays+"%'";
		try{
//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			//chercher les materiels
			curseur = con.rechercher(req);
			int i=0;
			while(curseur.next())
			{
			Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString()};
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
		String req="select  ireg,NomPays,NomOperateur,TapCode from materiels where NomOperateur like '%"+operateur+"%'";
		try{
//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			//chercher les materiels
			curseur = con.rechercher(req);
			int i=0;
			while(curseur.next())
			{
			Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString()};
			tableModel.insertRow(i,res);
		   // parant.charger();
			i++;
			}
		}catch(Exception e){
			
		}
		
	}
}  //  @jve:decl-index=0:visual-constraint="25,10"
