package EspaceMateriels;
import acceuil.*;

import java.*;
import javax.swing.border.*;

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
public class Anomalies extends JFrame {

	private static final long serialVersionUID = 1L;

	
	private JScrollPane jScrollPane = null;
	
	private JTable jTable = null;
	static Object[][] data = {};
	static String[] columnNames = {"N°","Anomaly description","Service type","Operator","Action","Responsability","Date","Status","Remark","Level"};  //,"DateDajout"," Modele"};
	public  DefaultTableModel tableModel;
	
	private JPanel jContentPane = null;


	private JButton jButton_supprimer = null;

	private JButton jButton_ajouter = null;
	private MatteBorder border = null; 
	public Anomalies parent=null;
	
	private JButton jButton_precedent = null;
	private JButton jButton_actualiser = null;
	private JButton jButton_modifier = null;
	private JButton jButton_importer = null;


	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	ConnexionBD con;

	
	
	
	/**
	 * This is the default constructor
	 */
	public Anomalies() {

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
			jTable.setRowHeight(30);
			jTable.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
			jTable.setDefaultRenderer(Object.class, new MonCellRendereranomalie());
			JTableHeader header = jTable.getTableHeader();
			header.setFont(new Font("Dialog", Font.BOLD, 12));
			/*setForeground(header.getForeground());
			setBackground(header.getBackground());*/
			//jTable.setSelectionBackground(new Color(72,0,90));
			//jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			TableColumn column = jTable.getColumnModel().getColumn(0); 
			column.setPreferredWidth(5); 
			TableColumn column1 = jTable.getColumnModel().getColumn(1); 
			column1.setPreferredWidth(130);
			TableColumn column2 = jTable.getColumnModel().getColumn(2); 
			column2.setPreferredWidth(90);
			TableColumn column3 = jTable.getColumnModel().getColumn(3); 
			column3.setPreferredWidth(20);
			TableColumn column4 = jTable.getColumnModel().getColumn(4); 
			column4.setPreferredWidth(150);
			TableColumn column5 = jTable.getColumnModel().getColumn(5); 
			column5.setPreferredWidth(40);
			TableColumn column6 = jTable.getColumnModel().getColumn(6); 
			column6.setPreferredWidth(20);
			TableColumn column7 = jTable.getColumnModel().getColumn(7); 
			column7.setPreferredWidth(10);
			TableColumn column8 = jTable.getColumnModel().getColumn(8); 
			column8.setPreferredWidth(150);
			TableColumn column9 = jTable.getColumnModel().getColumn(9); 
			column9.setPreferredWidth(15);
		}
		return jTable;
	}
	


	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1230, 680);
		this.setContentPane(getJContentPane());
		this.setTitle("ANOMALIES ET PROBLEMES");
		setIconImage(new ImageIcon(this.getClass().getResource("/LOGOS.jpg")).getImage());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
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
		String req="select * from anomalies";
		try{
			//			Ouverture de la connexion 
			con=new ConnexionBD(url,nomDriver);
			
			ResultSet curseur = null;
			
			curseur = con.rechercher(req);
			
			int i=0;
			while(curseur.next()){
				Object[] res={curseur.getString(1).toString(),curseur.getString(2).toString(),curseur.getString(3).toString(),curseur.getString(4).toString(),curseur.getString(5).toString(),curseur.getString(6).toString(),curseur.getString(7).toString(),curseur.getString(8).toString(),curseur.getString(9).toString(),curseur.getString(10).toString()};
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
			jContentPane.add(getJScrollPane(), null);
			jContentPane.setLayout(null);
			jContentPane.add(getJButton_actualiser(), null);
			jContentPane.add(getJButton_precedent(), null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/fond60.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(getJButton_modifier(), null);
			jContentPane.add(getJButton_supprimer(), null);
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
			jButton_actualiser.setBounds(new Rectangle(1103, 320, 116, 24));
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
			jButton_precedent.setBounds(new Rectangle(1103, 370, 116, 24));
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
			jButton_importer.setBounds(new Rectangle(1103, 420, 116, 24));
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
		new CreatExcelFileanomalie(this).setVisible(true);
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
	 */	private JButton getJButton_ajouter() {
			if (jButton_ajouter == null) {
				jButton_ajouter = new JButton();
				jButton_ajouter.setBounds(new Rectangle(1103, 170, 116, 24));
				//jButton_modifier.setFont(new Font("Times New Roman", Font.BOLD, 12));
				jButton_ajouter.setIcon(new ImageIcon(getClass().getResource("/add1.png")));
				jButton_ajouter.setEnabled(true);
				jButton_ajouter.setText("Ajouter");
				jButton_ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
					
						ajouter();
					}
				});
		}	return jButton_ajouter;
		}
	 
	 public void ajouter(){
			
			new Ajouter_Anomalies(this).setVisible(true);
		
		}
	        

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(1, 100, 1099, 550));
			jScrollPane.setViewportView(getJTable());
			jScrollPane.setForeground(new Color(255, 102, 153));
		}
		return jScrollPane;
	}
	private JButton getJButton_supprimer() {
		if (jButton_supprimer == null) {
			jButton_supprimer = new JButton();
			//jButton_supprimer.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jButton_supprimer.setIcon(new ImageIcon(getClass().getResource("/remove.png")));
			jButton_supprimer.setBounds(new Rectangle(1103, 220, 116, 24));
			jButton_supprimer.setText("Supprimer");
			jButton_supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(jButton_supprimer.isEnabled()){
						if(jTable.getSelectedRow()!=-1){
							int bouton = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment supprimer l'opérateur en cours?","Attention",JOptionPane.OK_CANCEL_OPTION);
					        if(bouton==JOptionPane.YES_OPTION){
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
		
		String req="delete from anomalies  where Num="+Integer.parseInt(cod)+"";
		String req1="update anomalies set Num=Num-1 where Num > "+Integer.parseInt(cod)+"";
		System.out.println(req);
		//Ouverture de la connexion 
		con=new ConnexionBD(url,nomDriver);
		//Execution de requete
		con.supprime(req);
		con.supprime(req1);

	}
	
	
	private JButton getJButton_modifier() {
		if (jButton_modifier == null) {
			jButton_modifier = new JButton();
			jButton_modifier.setBounds(new Rectangle(1103, 270, 116, 24));
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
	        //	this.setEnabled(false);
	        	new ModifierAnomalies(this,code).setVisible(true);
			}


	public  void precedente(){
		dispose();
	
	}
		
}

