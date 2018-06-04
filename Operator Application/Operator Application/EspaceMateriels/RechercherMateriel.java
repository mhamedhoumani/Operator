package EspaceMateriels;
import java.awt.*;
import acceuil.*;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;

import javax.swing.JList;


@SuppressWarnings("unused")
public class RechercherMateriel extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private MatteBorder border = null;
	private int choix;
	public TableauMateriel para=null;
	
	static DefaultTableModel tableModel;
	ConnexionBD con;
	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";

	private JButton jButtonRechercher = null;
	
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JRadioButton jRadioButton3 = null;
	private JRadioButton jRadioButton4 = null;
	
	Checkbox NomPays,NomOperateur,Testeur;    //,Modele;

	private JLabel jLabel = null;
	TableauMateriel tad=null;

	/**
	 * This is the default constructor
	 */
	public RechercherMateriel(TableauMateriel pere) {
		super();
		initialize();
		this.para=pere;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 327);
		this.setContentPane(getJContentPane());
		this.setTitle("Rechercher un pays et operateur");
	
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
		this.setTitle("Rechecher un opérateur");
	
		};
        
   private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setForeground(new Color(34, 10, 226));
			jRadioButton1.setFont(new Font("Times New Roman", Font.BOLD, 13));
			jRadioButton1.setBounds(new Rectangle(80, 60, 120, 21));
			jRadioButton1.setText("Nom de Pays");
			jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					actualiser(1);
				}
			});
		}
		return jRadioButton1;
	}
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setForeground(new Color(34, 10, 226));
			jRadioButton2.setFont(new Font("Times New Roman", Font.BOLD, 13));
			jRadioButton2.setBounds(new Rectangle(80, 100, 120, 21));
			jRadioButton2.setText("  Nom");
			jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					actualiser(2);
				}
			});
		}
		return jRadioButton2;
	}


	private JRadioButton getJRadioButton3() {
		if (jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton();
			jRadioButton3.setForeground(new Color(34, 10, 226));
			jRadioButton3.setFont(new Font("Times New Roman", Font.BOLD, 13));
			jRadioButton3.setBounds(new Rectangle(80, 140, 120, 21));
			jRadioButton3.setText(" Testeur");
			jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					actualiser(3);	
				}
			});
		}
		return jRadioButton3;
	}
	
	private JRadioButton getJRadioButton4() {
		if (jRadioButton4 == null) {
			jRadioButton4 = new JRadioButton();
			jRadioButton4.setForeground(new Color(34, 10, 226));
			jRadioButton4.setFont(new Font("Times New Roman", Font.BOLD, 13));
			jRadioButton4.setBounds(new Rectangle(80, 180, 120, 21));
			jRadioButton4.setText("Tap Code");
			jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					actualiser(4);	
				}
			});
		}
		return jRadioButton4;
	}
	
	
	
	private JButton getJButtonRechercher() {
		if (jButtonRechercher == null) {
			jButtonRechercher = new JButton();
			jButtonRechercher.setEnabled(true);
			jButtonRechercher.setIcon(new ImageIcon(getClass().getResource("/ok.png")));
			jButtonRechercher.setBounds(new Rectangle(88, 226, 101, 19));
			jButtonRechercher.setText("Valider");
			jButtonRechercher.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				
					if(choix==1){
					rechercherpays();	
					fermer();
				}
				if(choix==2){
					recherchernom();
					fermer();
				}
				if(choix==3){
					recherchertesteur();
			         fermer();
				}
				if(choix==4){
					recherchertapcode();
			         fermer();
				}
			
				}
			});
		}
		return jButtonRechercher;
	}
	public void fermer(){
		dispose();
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(55, 25, 193, 16));
			jLabel.setText("Rechercher un opérateur par son:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/test.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJRadioButton1(), null);
			jContentPane.add(getJRadioButton2(), null);
			jContentPane.add(getJRadioButton3(), null);
			jContentPane.add(getJRadioButton4(), null);
			jContentPane.add(getJButtonRechercher(), null);
	

		}
		return jContentPane;
	}
	public void actualiser(int x){
		getJButtonRechercher().setEnabled(true);
	if(x==1){
			jRadioButton4.setSelected(false);
			jRadioButton3.setSelected(false);
			jRadioButton2.setSelected(false);
			choix=1;
	}
			
	if(x==2){
			jRadioButton1.setSelected(false);
			jRadioButton3.setSelected(false);
			jRadioButton4.setSelected(false);
			choix=2;
	}
	if(x==3){
			
			jRadioButton1.setSelected(false);
			jRadioButton2.setSelected(false);
			jRadioButton4.setSelected(false);
			choix=3;
			}
	if(x==4){	
		jRadioButton1.setSelected(false);
		jRadioButton2.setSelected(false);
		jRadioButton3.setSelected(false);
		choix=4;
		}
	}
	
	
	public void rechercherpays(){
		String pays = JOptionPane.showInputDialog(null,"Entrez le nom de l'opérateur","Recherche par nom pays",JOptionPane.QUESTION_MESSAGE);
		para.Chercherpays(pays);
	}
	
	public void recherchernom(){
		String nom= JOptionPane.showInputDialog(null,"Entrez le nom du Pays","Recherche par nom opérateur",JOptionPane.QUESTION_MESSAGE);
		para.Cherchernom(nom);
		
	}
	
		public void recherchertesteur(){
		String testeur = JOptionPane.showInputDialog(null,"Entrez le nom du testeur","Recherche par testeur",JOptionPane.QUESTION_MESSAGE);
		para.Cherchertesteur(testeur);
	}
		public void recherchertapcode(){
			String tapcode= JOptionPane.showInputDialog(null,"Entrez le nom du TapCode","Recherche par TapCode",JOptionPane.QUESTION_MESSAGE);
			para.Cherchertapcode(tapcode);
			
		}
}

 //  @jve:decl-index=0:visual-constraint="10,10"
