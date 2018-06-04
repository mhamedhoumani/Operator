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
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.ImageIcon;



@SuppressWarnings("unused")
public class Ajouter_Materiel extends JFrame {

	private static final String UNUSED = "unused";
	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JTextField jTextField = null;

	private JLabel jLabel1 = null;

	private JTextField jTextField1 = null;
	 public Statement           sta=null;
	 int k=0;

	TableauMateriel parant;
	
	  public ResultSet           re=null;
	  public  DefaultTableModel tableModel;

	private JButton jButton = null;

	public JButton jButton1 = null;

	private JButton jButton2 = null;

	private JLabel jLabel3 = null;

	private JTextField jTextField3 = null;

	//@SuppressWarnings(UNUSED)
	private JTextField jTextField4 = null;

	//@SuppressWarnings(UNUSED)
	private JLabel jLabel5 = null;
	private MatteBorder border = null;

	//@SuppressWarnings(UNUSED)
	private JTextField jTextField5 = null;

	/**
	 * This is the default constructor
	 */
	public Ajouter_Materiel() {
		super();
		initialize();
		
	}
	public Ajouter_Materiel(TableauMateriel pere) {
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
		this.setSize(402, 291);
		this.setContentPane(getJContentPane());
		this.setTitle("Ajouter un Operateur");
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
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(18, 140, 89, 25));
			jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel3.setForeground(new Color(72,0,90));
			jLabel3.setText("Tap Code");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(18, 100, 89, 25));
			jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel1.setForeground(new Color(72,0,90));
			jLabel1.setText("Opérateur");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(18, 60, 89, 35));
			jLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel.setForeground(new Color(72,0,90));
			jLabel.setText("Pays");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/Ajout_prof.gif")));
			jContentPane.setBorder(border);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(120, 62, 150, 20));
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(120, 101, 150, 20));
		}
		return jTextField1;
	}
	
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(120, 141, 150, 20));
		}
		return jTextField3;
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
			jButton.setBounds(new Rectangle(290, 140, 100, 24));
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

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(290, 60, 100, 24));
			jButton1.setText("Ajouter");
			jButton1.setIcon(new ImageIcon(getClass().getResource("/add1.png")));
			jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					try {
						maine();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} if(k==1)
						{JOptionPane.showMessageDialog(null, "Cet opérateur existe déjà!");
					dispose();}
					else {ajouter();
					aj();
					fermer();
					}
					}
			});
		}
		return jButton1;
	}
	
	
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(290, 100, 100, 24));
			jButton2.setIcon(new ImageIcon(getClass().getResource("/vider.png")));
			jButton2.setText("Vider");
			jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println(" "); 
					vider();// TODO Auto-generated Event stub mouseClicked()
				}
			});
		}
		return jButton2;
	}
	public void maine() throws Exception{
	    Connection conn = getConnection();
	    Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_UPDATABLE);

	    st = conn.createStatement();
	    String s2=jTextField.getText();
	    String s3=jTextField1.getText();
	    
	
	    ResultSet rs = st.executeQuery("SELECT NomPays,NomOperateur FROM materiels ");
	    
	    while (rs.next()) {
	    
	    	if (rs.getString("NomPays").equals(s2) &&   rs.getString("NomOperateur").equals(s3))
	    	{
	    	 k=1;
	    	  
	      } else {
	      }
	    }

	    rs.close();
	    st.close();
	    conn.close();
	    

	  }
	//@SuppressWarnings(UNUSED)
	public  void aj()
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
	         dos.writeUTF(s2);
	         dos.writeUTF(s3);
	         dos.writeInt(3);

	 
	         
	 via.close();        

	 
	        }
	 
	      }catch (Exception e) {//JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
	    	  }

	}
	

	

	String s2,s3;
	public void ajouter()  {
		
		ConnexionBD con;
		 s2=jTextField.getText();
		
	     String s4=jTextField3.getText();
		 s3=jTextField1.getText();
		String req1="ALTER TABLE materiels AUTO_INCREMENT=1";
		String req="insert into materiels (NomPays,NomOperateur,TapCode) values('"+s2+"','"+s3+"','"+s4+"')";
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
		jTextField.setText(" ");
		jTextField1.setText(" ");
		jTextField3.setText(" ");
		
	}
		
		private static Connection getConnection() throws Exception {
		    Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";

		    return DriverManager.getConnection(url, "ve", "");
		  }
	public void fermer(){
		
		dispose();
	}

} 
