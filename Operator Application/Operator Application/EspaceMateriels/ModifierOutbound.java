package EspaceMateriels;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
public class ModifierOutbound extends JFrame {

	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	private MatteBorder border = null;
	private JPanel jContentPane = null;
	private JLabel jLabel10 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
	private JTextField jTextField2 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	private JTextField jTextField7 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	
	private JButton jButton_ok = null;
	private JButton jButton = null;
	public TableauMateriel parant=null;
	
	/**
	 * This is the default constructor
	 */
	public ModifierOutbound(TableauMateriel pere,int code) {
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
	int k=0;
public void chargerMateriel(int cod)throws Exception{
	ConnexionBD con;
	String req="select ireg,NomPays,NomOperateur,Start24o,End24o,Start35o,End35o,Start32o,End32o from materiels where ireg='"+cod+"' ";
		con=new ConnexionBD(url,nomDriver);
		ResultSet curseur = null;
		curseur = con.rechercher(req);
		try{
		int i=0;
		while(curseur.next()){
			jLabel10.setText(curseur.getString(1));
			jLabel11.setText(curseur.getString(2));
			jLabel12.setText(curseur.getString(3));
			jTextField2.setText(curseur.getString(4));
			jTextField3.setText(curseur.getString(5));
			jTextField4.setText(curseur.getString(6));
			jTextField5.setText(curseur.getString(7));
			jTextField6.setText(curseur.getString(8));
			jTextField7.setText(curseur.getString(9));
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
		this.setSize(410, 379);
		this.setContentPane(getJContentPane());
		this.setTitle("IREG Outbound");
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
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(60, 238, 90, 16));
			jLabel8.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel8.setForeground(new Color(72,0,90));
			jLabel8.setText("IR32 O-End");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(60, 213, 90, 16));
			jLabel7.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel7.setForeground(new Color(72,0,90));
			jLabel7.setText("IR32 O-Start");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(60, 188, 90, 16));
			jLabel6.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel6.setForeground(new Color(72,0,90));
			jLabel6.setText("IR35 O-End");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(60, 163, 90, 16));
			jLabel5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel5.setForeground(new Color(72,0,90));
			jLabel5.setText("IR35 O-Start");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(60, 138, 115, 16));
			jLabel4.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel4.setForeground(new Color(72,0,90));
			jLabel4.setText("IR24 O-End");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(60, 113, 90, 16));
			jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel3.setForeground(new Color(72,0,90));
			jLabel3.setText("IR24 O-Start");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(60, 68, 150, 16));
			jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel2.setForeground(new Color(72,0,90));
			jLabel2.setText("Nom opérateur");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(60, 34, 100, 16));
			jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel1.setForeground(new Color(72,0,90));
			jLabel1.setText("Nom pays");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(168, 67, 168, 20));
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(168, 33, 168, 20));
			jLabel10 = new JLabel();
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/ajmod.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.add(getJTextField4(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel10, null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(jLabel12, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(getJTextField5(), null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(getJTextField7(), null);
			jContentPane.add(getJButton_ok(), null);
			jContentPane.add(getJButton(), null);
			
		}
		return jContentPane;
	}
	/**
	 * This method initializes jTextField_code	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(162, 110, 125, 20));
			jTextField2.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField2.setBackground(Color.white);
			jTextField2.setEditable(true);
		}
		return jTextField2;
	}
	/**
	 * This method initializes jTextField_prenom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	
	

	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(162, 135, 125, 20));
			jTextField3.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField3.setBackground(Color.white);
			jTextField3.setEditable(true);
		}
		return jTextField3;
	}
	/**
	 * This method initializes jTextField_mobile	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new Rectangle(162, 160, 125, 20));
			jTextField4.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField4.setBackground(Color.white);
			jTextField4.setEditable(true);
		}
		return jTextField4;
	}
	/**
	 * This method initializes jTextArea_adresse	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setBounds(new Rectangle(162, 185, 125, 20));
			jTextField5.setEditable(true);
			jTextField5.setFont(new Font("Garamond", Font.PLAIN, 14));
		}
		return jTextField5;
	}
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setBounds(new Rectangle(162, 210, 125, 20));
			jTextField6.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField6.setBackground(Color.white);
			jTextField6.setEditable(true);
		}
		return jTextField6;
	}
	
	
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(162, 235, 125, 20));
			jTextField7.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField7.setBackground(Color.white);
			jTextField7.setEditable(true);
		}
		return jTextField7;
	}
	
	
	
	
	/**
	 * This method initializes jButton_ok	
	 * 	
	 * @return javax.swing.JButton	
	 * 
	 * 
	 */
	
	
public void m(){
		
		if((s0.isEmpty() && (getJTextField2().getText().contains("/") || getJTextField2().getText().contains("-") ) ))
		{
			modifier7();
		}
		if((s0.contains("OnGoing") || s0.isEmpty()) && (getJTextField3().getText().contains("/") || getJTextField3().getText().contains("-") ))
		{
			modifier2();
		}
		if(s1.isEmpty() && (getJTextField4().getText().contains("/") || getJTextField4().getText().contains("-") ) )
		{
			modifier3();
		}
		if((s1.contains("OnGoing") || s1.isEmpty()) && (getJTextField5().getText().contains("/") || getJTextField5().getText().contains("-") ))
		{
			modifier4();
		}
		if(s2.isEmpty() && (getJTextField6().getText().contains("/")  || getJTextField6().getText().contains("-") ) )
		{
			modifier5();
		}
		if((s2.contains("OnGoing") || s2.isEmpty()) && (getJTextField7().getText().contains("/") || getJTextField7().getText().contains("-") ) )
		{
			modifier6();
		}
			
	}

	String s0,s1,s2;
	  public void maine2()throws Exception{
			ConnexionBD con;
			int i2 = 0;
			String req="select ireg,ouverture24o,ouverture35o,ouverture32o from materiels  where ireg="+Integer.parseInt(jLabel10.getText())+" + "+i2+"     ";
				con=new ConnexionBD(url,nomDriver);
				ResultSet curseur = null;
				curseur = con.rechercher(req);
				try{
				int i=0;
				while(curseur.next()){
					jLabel10.setText(curseur.getString(1));
		s0=curseur.getString(2);
		s1=curseur.getString(3);
		s2=curseur.getString(4);
		System.out.println(s0);
	
					i++;
				}}
				catch(Exception ex){
					
				}
	  }
	
	private JButton getJButton_ok() {
		if (jButton_ok == null) {
			jButton_ok = new JButton();
			jButton_ok.setBounds(new Rectangle(90, 281, 106, 21));
			jButton_ok.setIcon(new ImageIcon(getClass().getResource("/ok.png")));
			jButton_ok.setText("Ajouter");
			jButton_ok.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					try {
						maine2();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				m();
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
			jButton.setBounds(new Rectangle(210, 281, 106, 21));
			jButton.setIcon(new ImageIcon(getClass().getResource("/cancel.png")));
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println(" ");
					fermer();
						// TODO Auto-generated Event stub mouseClicked()
				}
			});

		}
		return jButton;
	}
	
	
	public void modifier(){
		ConnexionBD conn;
		String s24o=getJTextField2().getText();
		String e24o=getJTextField3().getText();		
		String s35o=getJTextField4().getText();
		String e35o=getJTextField5().getText();
		String s32o=getJTextField6().getText();
		String e32o=getJTextField7().getText();
		String req="update materiels set "+"Start24o='"+s24o+"',End24o='"+e24o+"',Start35o='"+s35o+"',End35o='"+e35o+"',Start32o='"+s32o+"',End32o='"+e32o+"'"+" where ireg="+Integer.parseInt(jLabel10.getText())+"";
		try{
			conn=new ConnexionBD(url,nomDriver);
			conn.modifier(req);
			parant.setEnabled(true);
			}
			catch(Exception ex){
			}
			
		}

	  private static Connection getConnection() throws Exception {
	    Class.forName("com.mysql.jdbc.Driver");
	    String url = "jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";

	    return DriverManager.getConnection(url, "ve", "");
	  }

	
	 
	  public void modifier7(){
			ConnexionBD conn;

			String req="update materiels set ouverture24o='OnGoing'   where ireg="+Integer.parseInt(jLabel10.getText())+"";
			try{
				conn=new ConnexionBD(url,nomDriver);
				conn.modifier(req);
				parant.setEnabled(true);
				}
				catch(Exception ex){
				}
			}
	
	
	  public void modifier2(){
			ConnexionBD conn;

			String req="update materiels set ouverture24o='Test Closed'  where ireg="+Integer.parseInt(jLabel10.getText())+"";
			try{
				conn=new ConnexionBD(url,nomDriver);
				conn.modifier(req);
				parant.setEnabled(true);
				}
				catch(Exception ex){
				}
			}
	  public void modifier3(){
			ConnexionBD conn;

			String req="update materiels set ouverture35o='OnGoing'   where ireg="+Integer.parseInt(jLabel10.getText())+"";
			try{
				conn=new ConnexionBD(url,nomDriver);
				conn.modifier(req);
				parant.setEnabled(true);
				}
				catch(Exception ex){
				}
			}

	  
	  public void modifier4(){
			ConnexionBD conn;

			String req="update materiels set ouverture35o='Test Closed'  where ireg="+Integer.parseInt(jLabel10.getText())+"";
			try{
				conn=new ConnexionBD(url,nomDriver);
				conn.modifier(req);
				parant.setEnabled(true);
				}
				catch(Exception ex){
				}
			}
	  public void modifier5(){
			ConnexionBD conn;

			String req="update materiels set ouverture32o='OnGoing'   where ireg="+Integer.parseInt(jLabel10.getText())+"";
			try{
				conn=new ConnexionBD(url,nomDriver);
				conn.modifier(req);
				parant.setEnabled(true);
				}
				catch(Exception ex){
				}
			}
	 
	  public void modifier6(){
			ConnexionBD conn;

			String req="update materiels set ouverture32o='Test Closed'  where ireg="+Integer.parseInt(jLabel10.getText())+"";
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