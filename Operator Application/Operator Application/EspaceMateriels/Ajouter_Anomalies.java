package EspaceMateriels;
import EspaceMateriels.*;
import java.*;
import acceuil.*;

import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.border.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;


@SuppressWarnings("unused")
public class Ajouter_Anomalies extends JFrame {

	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	
	private JLabel jLabel1 = null;
	private JTextArea jTextArea1 = null;
	 public Statement sta=null;
	 int k=0;
	 Anomalies parant;
	private JLabel jLabel2 = null;
	private JTextArea jTextArea2 = null;
	
	private JLabel jLabel3 = null;
	private JTextField jTextField3 = null;
	
	private JLabel jLabel4 = null;
	private JTextArea jTextArea4 = null;
	
	private JLabel jLabel5 = null;
	private JTextField jTextField5 = null;
	
	private JLabel jLabel6 = null;
	private JTextField jTextField6 = null;
	
	private JLabel jLabel7 = null;
	private JTextField jTextField7 = null;
	
	private JLabel jLabel8 = null;
	private JTextArea jTextArea8 = null;
	
	private JLabel jLabel9 = null;
	private JTextField jTextField9 = null;
	
	  public ResultSet re=null;
	  public  DefaultTableModel tableModel;

	private JButton jButton = null;

	public JButton jButton1 = null;

	private JButton jButton2 = null;

	private MatteBorder border = null;


	/**
	 * This is the default constructor
	 */
	public Ajouter_Anomalies() {
		super();
		initialize();
		
	}
	public Ajouter_Anomalies(Anomalies pere) {
		super();
		this.parant=pere;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initialize();
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 600);
		this.setContentPane(getJContentPane());
		this.setTitle("Ajouter une Anomalie");
		this.setResizable(false);
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
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(30, 445, 120, 24));
			jLabel9.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel9.setForeground(new Color(72,0,90));
			jLabel9.setText("Level");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(30, 360, 120, 24));
			jLabel8.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel8.setForeground(new Color(72,0,90));
			jLabel8.setText("Remark");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(30, 335, 120, 24));
			jLabel7.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel7.setForeground(new Color(72,0,90));
			jLabel7.setText("Status");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(30, 310, 120, 24));
			jLabel6.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel6.setForeground(new Color(72,0,90));
			jLabel6.setText("Date");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(30, 285, 120, 24));
			jLabel5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel5.setForeground(new Color(72,0,90));
			jLabel5.setText("Responsability");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(30, 200, 120, 24));
			jLabel4.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel4.setForeground(new Color(72,0,90));
			jLabel4.setText("Action");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(30, 175, 120, 24));
			jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel3.setForeground(new Color(72,0,90));
			jLabel3.setText("Operator");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(30, 110, 120, 24));
			jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel2.setForeground(new Color(72,0,90));
			jLabel2.setText("Service type");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(30, 25, 150, 24));
			jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel1.setForeground(new Color(72,0,90));
			jLabel1.setText("Anomaly description");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextArea1(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJTextArea2(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getJTextArea4(), null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(getJTextField5(), null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(getJTextField7(), null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(getJTextArea8(), null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(getJTextField9(), null);
			
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton2(), null);
	
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/ajmod.jpg")));
			jContentPane.setBorder(border);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */

	private JTextArea getJTextArea1() {
		if (jTextArea1 == null) {
			jTextArea1 = new JTextArea();
			jTextArea1.setBounds(new Rectangle(160, 25, 260, 80));
		}
		return jTextArea1;
	}
	
	private JTextArea getJTextArea2() {
		if (jTextArea2 == null) {
			jTextArea2 = new JTextArea();
			jTextArea2.setBounds(new Rectangle(160, 110, 240, 60));
		}
		return jTextArea2;
	}

	
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(160, 175, 180, 20));
		}
		return jTextField3;
	}

	
	private JTextArea getJTextArea4() {
		if (jTextArea4 == null) {
			jTextArea4 = new JTextArea();
			jTextArea4.setBounds(new Rectangle(160, 200, 260, 80));
		}
		return jTextArea4;
	}
	
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setBounds(new Rectangle(160, 285, 180, 20));
		}
		return jTextField5;
	}
	
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setBounds(new Rectangle(160, 310, 180, 20));
		}
		return jTextField6;
	}
	
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(160, 335, 180, 20));
		}
		return jTextField7;
	}
	
	private JTextArea getJTextArea8() {
		if (jTextArea8 == null) {
			jTextArea8 = new JTextArea();
			jTextArea8.setBounds(new Rectangle(160, 360, 260, 80));
		}
		return jTextArea8;
	}
	
	private JTextField getJTextField9() {
		if (jTextField9 == null) {
			jTextField9 = new JTextField();
			jTextField9.setBounds(new Rectangle(160, 445, 180, 20));
		}
		return jTextField9;
	}
	

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Annuler");
			jButton.setBounds(new Rectangle(380, 500, 100, 24));
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

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(160, 500, 100, 24));
			jButton1.setText("Ajouter");
			jButton1.setIcon(new ImageIcon(getClass().getResource("/add1.png")));
			jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					ajouter(); fermer();
				}
			});
		}
		return jButton1;
	}
	
	
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(270, 500, 100, 24));
			jButton2.setText("Vider");
			jButton2.setIcon(new ImageIcon(getClass().getResource("/vider.png")));
			jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println(" "); 
					vider();
				}
			});
		}
		return jButton2;
	}
	
	public void ajouter()  {
		
		ConnexionBD con;
		String s2=jTextArea1.getText();
		String s3=jTextArea2.getText();
		String s4=jTextField3.getText();
		String s5=jTextArea4.getText();
		String s6=jTextField5.getText();
		String s7=jTextField6.getText();
		String s8=jTextField7.getText();
		String s9=jTextArea8.getText();
		String s10=jTextField9.getText();

		String req1="ALTER TABLE Anomalies AUTO_INCREMENT=1";
		String req="insert into Anomalies (Anomalydescription,Servicetype,Operator,Action,Responsability,Date,Status,Remark,Level) values('"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"')";
		try{
		con=new ConnexionBD(url,nomDriver);
		con.ajouter(req1);
		con.ajouter(req);
		parant.charger();
		}
		
		catch(Exception ex){
		}
	}

	
	public void vider(){
		jTextArea1.setText("");
		jTextArea2.setText("");
		jTextField3.setText("");
		jTextArea4.setText("");
		jTextField5.setText("");
		jTextField6.setText("");
		jTextField7.setText("");
		jTextArea8.setText("");
		jTextField9.setText("");
		
	}


//		  @SuppressWarnings("unused")
		private static Connection getConnection() throws Exception {
		    Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";

		    return DriverManager.getConnection(url, "ve", "");
		  }
	public void fermer(){
		
		dispose();
	}


}  //  @jve:decl-index=0:visual-constraint="22,24"

