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
public class ModifierDouverture extends JFrame {

	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	private MatteBorder border = null;
	private JPanel jContentPane = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel22 = null;
	private JLabel jLabel33 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	private JTextField jTextField7 = null;
	private JTextField jTextField8 = null;
	private JTextField jTextField9 = null;
	private JTextField jTextField10 = null;
	private JButton jButton_ok = null;
	private JButton jButton= null;
	public Douverture parant=null;
	
	/**
	 * This is the default constructor
	 */
	public ModifierDouverture(Douverture pere,int code) {
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
	String req="select ireg,NomPays,NomOperateur,TapCode,ouverture24i,ouverture35i,ouverture32i,ouverture24o,ouverture35o,ouverture32o from materiels where ireg='"+cod+"' ";
		con=new ConnexionBD(url,nomDriver);
		ResultSet curseur = null;
		curseur = con.rechercher(req);
		try{
		int i=0;
		while(curseur.next()){
			jLabel11.setText(curseur.getString(1));
			jLabel22.setText(curseur.getString(2));
			jLabel33.setText(curseur.getString(3));
			jTextField5.setText(curseur.getString(5));
			jTextField6.setText(curseur.getString(6));
			jTextField7.setText(curseur.getString(7));
			jTextField8.setText(curseur.getString(8));
			jTextField9.setText(curseur.getString(9));
			jTextField10.setText(curseur.getString(10));
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
		this.setTitle("DATES D'OUVERTURE");
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
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(70, 357, 130, 16));
			jLabel10.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel10.setForeground(new Color(72,0,90));
			jLabel10.setText("Date ouverture 32o");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(70, 317, 130, 16));
			jLabel9.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel9.setForeground(new Color(72,0,90));
			jLabel9.setText("Date ouverture 25o");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(70, 277, 130, 16));
			jLabel8.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel8.setForeground(new Color(72,0,90));
			jLabel8.setText("Date ouverture 24o");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(70, 237, 130, 16));
			jLabel7.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel7.setForeground(new Color(72,0,90));
			jLabel7.setText("Date ouverture 32i");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(70, 197, 130, 16));
			jLabel6.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel6.setForeground(new Color(72,0,90));
			jLabel6.setText("Date ouverture 35i");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(70, 157, 130, 16));
			jLabel5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel5.setForeground(new Color(72,0,90));
			jLabel5.setText("Date ouverture 24i");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(70, 117, 130, 16));
			jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel3.setForeground(new Color(72,0,90));
			jLabel3.setText("Opérateur");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(70, 77, 130, 16));
			jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel2.setForeground(new Color(72,0,90));
			jLabel2.setText("Pays");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(70, 37, 130, 16));
			jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel1.setForeground(new Color(72,0,90));
			jLabel1.setText("Ireg");
			jContentPane = new JPanel();
			jLabel33 = new JLabel();
			jLabel33.setBounds(new Rectangle(200, 115, 168, 20));
			jContentPane = new JPanel();
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
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(jLabel10, null);
			jContentPane.add(getJTextField5(), null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(getJTextField7(), null);
			jContentPane.add(getJTextField8(), null);
			jContentPane.add(getJTextField9(), null);
			jContentPane.add(getJTextField10(), null);
			jContentPane.add(getJButton_ok(), null);
			jContentPane.add(getJButton(), null);
			
		}
		return jContentPane;
	}
	
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setBounds(new Rectangle(200, 154, 168, 20));
			jTextField5.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField5.setBackground(Color.white);
			jTextField5.setEditable(true);
		}
		return jTextField5;
	}
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setBounds(new Rectangle(200, 194, 168, 20));
			jTextField6.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField6.setBackground(Color.white);
			jTextField6.setEditable(true);
		}
		return jTextField6;
	}
	
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(200, 234, 168, 20));
			jTextField7.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField7.setBackground(Color.white);
			jTextField7.setEditable(true);
		}
		return jTextField7;
	}
	
	private JTextField getJTextField8() {
		if (jTextField8 == null) {
			jTextField8 = new JTextField();
			jTextField8.setBounds(new Rectangle(200, 274, 168, 20));
			jTextField8.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField8.setBackground(Color.white);
			jTextField8.setEditable(true);
		}
		return jTextField8;
	}
	
	private JTextField getJTextField9() {
		if (jTextField9 == null) {
			jTextField9 = new JTextField();
			jTextField9.setBounds(new Rectangle(200, 314, 168, 20));
			jTextField9.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField9.setBackground(Color.white);
			jTextField9.setEditable(true);
		}
		return jTextField9;
	}
	
	private JTextField getJTextField10() {
		if (jTextField10 == null) {
			jTextField10 = new JTextField();
			jTextField10.setBounds(new Rectangle(200, 354, 168, 20));
			jTextField10.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField10.setBackground(Color.white);
			jTextField10.setEditable(true);
		}
		return jTextField10;
	}
	
	
	
	
	
	/**
	 * This method initializes jButton_ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_ok() {
		if (jButton_ok == null) {
			jButton_ok = new JButton();
			jButton_ok.setBounds(new Rectangle(150, 420, 106, 21));
			jButton_ok.setIcon(new ImageIcon(getClass().getResource("/ok.png")));
			jButton_ok.setText("Ajouter");
			jButton_ok.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				modifier();
			        	fermer();
						parant.charger();}
				
			});
		}
		return jButton_ok;
	}
	
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Annuler");
			jButton.setBounds(new Rectangle(270, 420, 106, 21));
			jButton.setIcon(new ImageIcon(getClass().getResource("/cancel.png")));
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println(" ");
					fermer();
				}
			});

		}
		return jButton;
	}
	
	
	
	
	public void modifier(){
		ConnexionBD conn;
		String dov24i=getJTextField5().getText();
		String dov35i=getJTextField6().getText();
		String dov32i=getJTextField7().getText();
		String dov24o=getJTextField8().getText();
		String dov35o=getJTextField9().getText();
		String dov32o=getJTextField10().getText();
		String req="update materiels set " +"ouverture24i='"+dov24i+"',ouverture35i='"+dov35i+"',ouverture32i='"+dov32i+"',ouverture24o='"+dov24o+"',ouverture35o='"+dov35o+"',ouverture32o='"+dov32o+"'"+" where ireg="+Integer.parseInt(jLabel11.getText())+"";
		try{
			conn=new ConnexionBD(url,nomDriver);
			conn.modifier(req);
			parant.setEnabled(true);
			}
			catch(Exception ex){
			}
		}

	public void fermer(){
		dispose();
	}

	}

