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
public class ModifierAnomalies extends JFrame {

	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	private MatteBorder border = null;
	private JPanel jContentPane = null;
	private JLabel jLabel11 = null;
	private JTextArea jTextArea2 = null;
	private JTextArea jTextArea3 = null;
	private JTextField jTextField4 = null;
	private JTextArea jTextArea5 = null;
	private JTextField jTextField6 = null;
	private JTextField jTextField7 = null;
	private JTextField jTextField8 = null;
	private JTextArea jTextArea9 = null;
	private JTextField jTextField10 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JButton jButton_ok = null;
	private JButton jButton = null;
	public Anomalies parant=null;
	
	/**
	 * This is the default constructor
	 */
	public ModifierAnomalies(Anomalies pere,int code) {
		super();
		initialize();
		this.parant=pere;
		try{
		chargerAnomalies(code);
		}catch(Exception ex){
			
		}
		
	}
	/**
	 * 
	 * 
	 */
public void chargerAnomalies(int cod)throws Exception{
	ConnexionBD con;
	String req="select Num,Anomalydescription,Servicetype,Operator,Action,Responsability,Date,Status,Remark,Level from anomalies where Num='"+cod+"' ";
		con=new ConnexionBD(url,nomDriver);
		ResultSet curseur = null;
		curseur = con.rechercher(req);
		try{
		int i=0;
		while(curseur.next()){
			jLabel11.setText(curseur.getString(1));
			jTextArea2.setText(curseur.getString(2));
			jTextArea3.setText(curseur.getString(3));
			jTextField4.setText(curseur.getString(4));
			jTextArea5.setText(curseur.getString(5));
			jTextField6.setText(curseur.getString(6));
			jTextField7.setText(curseur.getString(7));
			jTextField8.setText(curseur.getString(8));
			jTextArea9.setText(curseur.getString(9));
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
		this.setSize(600, 600);
		this.setContentPane(getJContentPane());
		this.setTitle("Modification");
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
			jLabel10.setBounds(new Rectangle(30, 445, 120, 24));
			jLabel10.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel10.setForeground(new Color(72,0,90));
			jLabel10.setText("Level");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(30, 360, 120, 24));
			jLabel9.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel9.setForeground(new Color(72,0,90));
			jLabel9.setText("Remark");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(30, 335, 120, 24));
			jLabel8.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel8.setForeground(new Color(72,0,90));
			jLabel8.setText("Status");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(30, 310, 120, 24));
			jLabel7.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel7.setForeground(new Color(72,0,90));
			jLabel7.setText("Date");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(30, 285, 120, 24));
			jLabel6.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel6.setForeground(new Color(72,0,90));
			jLabel6.setText("Responsability");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(30, 200, 120, 24));
			jLabel5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel5.setForeground(new Color(72,0,90));
			jLabel5.setText("Action");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(30, 175, 120, 24));
			jLabel4.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel4.setForeground(new Color(72,0,90));
			jLabel4.setText("Operator");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(30, 110, 120, 24));
			jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel3.setForeground(new Color(72,0,90));
			jLabel3.setText("Service type");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(30, 25, 150, 24));
			jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel2.setForeground(new Color(72,0,90));
			jLabel2.setText("Anomaly description");
//			jLabel1 = new JLabel();
			/*jLabel1.setBounds(new Rectangle(20, 25, 89, 25));
			jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel1.setForeground(new Color(72,0,90));
			jLabel1.setText("N°");*/
			jLabel11 = new JLabel();
			/*jLabel11.setBounds(new Rectangle(145, 40, 168, 16));
			jLabel11.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel11.setForeground(new Color(72,0,90));*/
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/ajmod.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(getJTextArea2(), null);
			jContentPane.add(getJTextArea3(), null);
			jContentPane.add(getJTextField4(), null);
			jContentPane.add(getJTextArea5(), null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(getJTextField7(), null);
			jContentPane.add(getJTextField8(), null);
			jContentPane.add(getJTextArea9(), null);
			jContentPane.add(getJTextField10(), null);
	//		jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(jLabel10, null);
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
	
	private JTextArea getJTextArea2() {
		if (jTextArea2 == null) {
			jTextArea2 = new JTextArea();
			jTextArea2.setBounds(new Rectangle(160, 25, 260, 80));
			jTextArea2.setLineWrap(true);
			jTextArea2.setWrapStyleWord(true);
		}
		return jTextArea2;
	}
	
	private JTextArea getJTextArea3() {
		if (jTextArea3 == null) {
			jTextArea3 = new JTextArea();
			jTextArea3.setBounds(new Rectangle(160, 110, 240, 60));
			jTextArea3.setLineWrap(true);
			jTextArea3.setWrapStyleWord(true);
		}
		return jTextArea3;
	}

	
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new Rectangle(160, 175, 180, 20));
		}
		return jTextField4;
	}

	
	private JTextArea getJTextArea5() {
		if (jTextArea5 == null) {
			jTextArea5 = new JTextArea();
			jTextArea5.setBounds(new Rectangle(160, 200, 260, 80));
			jTextArea5.setLineWrap(true);
			jTextArea5.setWrapStyleWord(true);
		}
		return jTextArea5;
	}
	
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setBounds(new Rectangle(160, 285, 180, 20));
		}
		return jTextField6;
	}
	
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(160, 310, 180, 20));
		}
		return jTextField7;
	}
	
	private JTextField getJTextField8() {
		if (jTextField8 == null) {
			jTextField8 = new JTextField();
			jTextField8.setBounds(new Rectangle(160, 335, 180, 20));
		}
		return jTextField8;
	}
	
	private JTextArea getJTextArea9() {
		if (jTextArea9 == null) {
			jTextArea9 = new JTextArea();
			jTextArea9.setBounds(new Rectangle(160, 360, 260, 80));
			jTextArea9.setLineWrap(true);
			//jTextArea9.setWrapStyleWord(true);
		}
		return jTextArea9;
	}
	
	private JTextField getJTextField10() {
		if (jTextField10 == null) {
			jTextField10 = new JTextField();
			jTextField10.setBounds(new Rectangle(160, 445, 180, 20));
		}
		return jTextField10;
	}
	
	
	
	
	/**
	 * This method initializes jButton_ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Annuler");
			jButton.setBounds(new Rectangle(280, 500, 106, 21));
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
	
	private JButton getJButton_ok() {
		if (jButton_ok == null) {
			jButton_ok = new JButton();
			jButton_ok.setBounds(new Rectangle(160, 500, 106, 21));
			jButton_ok.setIcon(new ImageIcon(getClass().getResource("/edit.png")));
			jButton_ok.setText("Modifier");
			jButton_ok.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				modifier();
			        	fermer();
						parant.charger();			        }
				
			});
		}
		return jButton_ok;
	}
	
	public void modifier(){
		ConnexionBD conn;
		String and=getJTextArea2().getText();
		String set=getJTextArea3().getText();		
		String ope=getJTextField4().getText();
		String act=getJTextArea5().getText();
		String res=getJTextField6().getText();
		String dat=getJTextField7().getText();
		String sta=getJTextField8().getText();
		String rem=getJTextArea9().getText();
		String lev=getJTextField10().getText();
		String req="update anomalies set " +"Anomalydescription='"+and+"',Servicetype='"+set+"',Operator='"+ope+"',Action='"+act+"',Responsability='"+res+"',Date='"+dat+"',Status='"+sta+"',Remark='"+rem+"',Level='"+lev+"'"+" where Num="+Integer.parseInt(jLabel11.getText())+"";
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

