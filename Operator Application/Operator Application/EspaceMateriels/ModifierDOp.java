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
public class ModifierDOp extends JFrame {

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
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JButton jButton_ok = null;
	private JButton jButton = null;
	public TableauMateriel parant=null;
	
	/**
	 * This is the default constructor
	 */
	public ModifierDOp(TableauMateriel pere,int code) {
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
	String req="select ireg,NomPays,NomOperateur,Ss7,Simcard,Testeur from materiels where ireg='"+cod+"' ";
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
		this.setSize(410, 348);
		this.setContentPane(getJContentPane());
		this.setTitle("IREG Inbound");
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
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(72, 198, 115, 16));
			jLabel5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel5.setForeground(new Color(72,0,90));
			jLabel5.setText("Testeur");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(72, 158, 115, 16));
			jLabel4.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel4.setForeground(new Color(72,0,90));
			jLabel4.setText("Simcard");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(72, 118, 90, 16));
			jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel3.setForeground(new Color(72,0,90));
			jLabel3.setText("SS7&GRX");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(72, 78, 150, 16));
			jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel2.setForeground(new Color(72,0,90));
			jLabel2.setText("Nom opérateur");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(72, 44, 90, 16));
			jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel1.setForeground(new Color(72,0,90));
			jLabel1.setText("Nom pays");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(180, 77, 168, 20));
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(180, 43, 168, 20));
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
			jTextField2.setBounds(new Rectangle(173, 115, 125, 20));
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
			jTextField3.setBounds(new Rectangle(173, 155, 125, 20));
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
			jTextField4.setBounds(new Rectangle(173, 195, 125, 20));
			jTextField4.setFont(new Font("Garamond", Font.PLAIN, 14));
			jTextField4.setBackground(Color.white);
			jTextField4.setEditable(true);
		}
		return jTextField4;
	}
	
	
	
	
	private JButton getJButton_ok() {
		if (jButton_ok == null) {
			jButton_ok = new JButton();
			jButton_ok.setBounds(new Rectangle(90, 251, 106, 21));
			jButton_ok.setIcon(new ImageIcon(getClass().getResource("/ok.png")));
			jButton_ok.setText("Ajouter");
			jButton_ok.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					modifier();
			        	fermer();
						parant.charger();			        
						}
			});
		}
		return jButton_ok;
	}
	
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Annuler");
			jButton.setBounds(new Rectangle(210, 251, 106, 21));
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
		String ss7=getJTextField2().getText();
		String sim=getJTextField3().getText();		
		String tes=getJTextField4().getText();
		String req="update materiels set "+"Ss7='"+ss7+"',Simcard='"+sim+"',Testeur='"+tes+"'"+" where ireg="+Integer.parseInt(jLabel10.getText())+"";
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

