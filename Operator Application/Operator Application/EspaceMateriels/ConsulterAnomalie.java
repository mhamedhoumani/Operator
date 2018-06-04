package EspaceMateriels;

import java.awt.BorderLayout;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

import acceuil.ConnexionBD;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("unused")
public class ConsulterAnomalie extends JFrame {

	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	private MatteBorder border = null;
	private JPanel jContentPane = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel22 = null;
	private JLabel jLabel33 = null;
	private JLabel jLabel44 = null;
	private JLabel jLabel55 = null;
	private JLabel jLabel66 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;

	private JTextArea jTextArea7 = null;

	private JButton jButton_ok = null;
	public Anomalies parant=null;
	
	/**
	 * This is the default constructor
	 */
	public ConsulterAnomalie(Anomalies pere,int code) {
		super();
		initialize();
		this.parant=pere;
		try{
		chargerMateriel(code);
		}catch(Exception ex){
			
		}
		
	}
	/**
	 * 
	 * 
	 */
public void chargerMateriel(int cod)throws Exception{
	ConnexionBD con;
	String req="select ireg,NomPays,NomOperateur,detection,statut,remarque from materiels where ireg='"+cod+"' ";
		con=new ConnexionBD(url,nomDriver);
		ResultSet curseur = null;
		curseur = con.rechercher(req);
		try{
		int i=0;
		while(curseur.next()){
			jLabel11.setText(curseur.getString(1));
			jLabel22.setText(curseur.getString(2));
			jLabel33.setText(curseur.getString(3));
			jLabel44.setText(curseur.getString(4));
			jLabel55.setText(curseur.getString(5));
		
			//jTextField2.setText(curseur.getString(2));
			//jTextField3.setText(curseur.getString(3));
			//jTextField4.setText(curseur.getString(4));
			//jTextField5.setText(curseur.getString(5));
			//jTextField6.setText(curseur.getString(6));
			jTextArea7.setText(curseur.getString(6));
			i++;
		}
		}
		catch(Exception ex){
			
		}
		}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("AJOUTER DES ANOMALIES");
		this.setResizable(false);
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
			}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(30, 237, 130, 16));
			jLabel7.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel7.setForeground(new Color(72,0,90));
			jLabel7.setText("Remarques");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(30, 197, 130, 16));
			jLabel6.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel6.setForeground(new Color(72,0,90));
			jLabel6.setText("Statut");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(30, 157, 180, 16));
			jLabel5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel5.setForeground(new Color(72,0,90));
			jLabel5.setText("Détection du problème");
			/*jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(70, 154, 130, 16));
			jLabel4.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel4.setForeground(new Color(72,0,90));
			jLabel4.setText("TapCode");*/
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(30, 117, 130, 16));
			jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel3.setForeground(new Color(72,0,90));
			jLabel3.setText("Opérateur");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(30, 77, 130, 16));
			jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel2.setForeground(new Color(72,0,90));
			jLabel2.setText("Pays");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(30, 37, 130, 16));
			jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel1.setForeground(new Color(72,0,90));
			jLabel1.setText("Ireg");
			jLabel55 = new JLabel();
			jLabel55.setBounds(new Rectangle(200, 194, 168, 20));
			jLabel44 = new JLabel();
			jLabel44.setBounds(new Rectangle(200, 154, 168, 20));
			jLabel33 = new JLabel();
			jLabel33.setBounds(new Rectangle(200, 114, 168, 20));
			jLabel22 = new JLabel();
			jLabel22.setBounds(new Rectangle(200, 74, 168, 20));
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(200, 34, 168, 20));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/consult33.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(jLabel22, null);
			jContentPane.add(jLabel33, null);
			jContentPane.add(jLabel44, null);
			jContentPane.add(jLabel55, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(getJTextArea7(), null);
			jContentPane.add(getJButton_ok(), null);
			
		}
		return jContentPane;
	}
	/**
	 * This method initializes jTextField_code	
	 * 	
	 * @return javax.swing.JTextField	
	 */

	
	private JTextArea getJTextArea7() {
		if (jTextArea7 == null) {
			jTextArea7 = new JTextArea();
			jTextArea7.setBounds(new Rectangle(200, 234, 200, 120));
			jTextArea7.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextArea7.setBackground(Color.white);
			jTextArea7.setEditable(true);
		}
		return jTextArea7;
	}
	
	
	
	/**
	 * This method initializes jButton_ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_ok() {
		if (jButton_ok == null) {
			jButton_ok = new JButton();
			jButton_ok.setBounds(new Rectangle(200, 420, 106, 21));
			jButton_ok.setIcon(new ImageIcon(getClass().getResource("/cancel.png")));
			jButton_ok.setText("Annuler");
			jButton_ok.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
			        	fermer();
				}
			});
		}
		return jButton_ok;
	}
	

	public void fermer(){
		dispose();
	}

	}

