package acceuil;

import javax.swing.*;

import java.awt.*;

import javax.swing.border.*;

import java.sql.ResultSet;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;

@SuppressWarnings("unused")
public class administration extends JFrame {

	private static final long serialVersionUID = 1L;

	ConnexionBD con;
	private String url="jdbc:mysql://127.0.0.1:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	private JPanel jContentPane = null;
	
	private MatteBorder border = null;  //  @jve:decl-index=0:

	private JLabel jLabellogin = null;

	private JLabel jLabelpass = null;

	private JTextField jTextFieldlogin = null;

	private JPasswordField jPasswordFieldpass = null;

	private JToggleButton jToggleButton = null;

	private JLabel jLabelPHOTO = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	public administration() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}

	public administration(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public administration(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public administration(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * This method initializes jTextFieldlogin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldlogin() {
		if (jTextFieldlogin == null) {
			jTextFieldlogin = new JTextField();
			jTextFieldlogin.setBounds(new Rectangle(113, 116, 150, 20));
		}
		return jTextFieldlogin;
	}

	/**
	 * This method initializes jPasswordFieldpass	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldpass() {
		if (jPasswordFieldpass == null) {
			jPasswordFieldpass = new JPasswordField();
			jPasswordFieldpass.setBounds(new Rectangle(113, 152, 150, 20));
		}
		return jPasswordFieldpass;
	}

	/**
	 * This method initializes jToggleButton	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton() {
		if (jToggleButton == null) {
			jToggleButton = new JToggleButton();
			jToggleButton.setBounds(new Rectangle(168, 195, 95, 24));
			jToggleButton.setText("Se connecter");
			jToggleButton.addMouseListener(new java.awt.event.MouseAdapter() {
				@SuppressWarnings("deprecation")
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(connection(jTextFieldlogin.getText(),jPasswordFieldpass.getText())){
						new EspaceChoix().setVisible(true);
						fermer();
					}else{
						jLabel1.setText("Données incorectes !");
					}
				}
			});
		}
		return jToggleButton;
	}
/**
 * 
 * 
 */
	public boolean connection(String login,String pass){
		boolean exist=false;
		String query="SELECT * from administration" +
				" where login ='"+login+"' and pass='"+pass+"'";
		// TODO Auto-generated method stu
		con=new ConnexionBD(url,nomDriver);
		ResultSet curseur = null;
		//chercher les noms des groupe pour les inserer dans le choix de groupe
		curseur = con.rechercher(query);
		try{
			if(curseur.next())
				exist =  true;

		}catch(Exception ex){
			
		}
		
		return exist;
			
	}
	public void fermer(){
		dispose();
		jTextFieldlogin.setText(" ");
		jPasswordFieldpass.setText(" ");
	}
	/**
	 * @param args
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws UnsupportedLookAndFeelException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException  {
		// TODO Auto-generated method stub
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				administration thisClass = new administration();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(455, 309);
		this.setResizable(false);
		this.setLocation(new Point(400, 300));
		this.setContentPane(getJContentPane());
		this.setTitle("Gestionnaire des tests IREG et des ouvertures roaming");
		setIconImage(new ImageIcon(this.getClass().getResource("/LOGOS.jpg")).getImage());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(290, 191, 176, 35));
			jLabel1.setText("");
			jLabel = new JLabel();
			jLabelPHOTO = new JLabel();
			jLabelPHOTO.setBounds(new Rectangle(274, 0, 172, 56));
			jLabelPHOTO.setText("");
			jLabelpass = new JLabel();
			jLabelpass.setBounds(new Rectangle(9, 151, 101, 16));
			jLabelpass.setFont(new Font("Garamond", Font.BOLD, 14));
			jLabelpass.setText("Mot de passe");
			jLabellogin = new JLabel();
			jLabellogin.setBounds(new Rectangle(52, 117, 43, 18));
			jLabellogin.setFont(new Font("Garamond", Font.BOLD, 14));
			jLabellogin.setText("Login");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/inwi5.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(jLabellogin, null);
			jContentPane.add(jLabelpass, null);
			jContentPane.add(getJTextFieldlogin(), null);
			jContentPane.add(getJPasswordFieldpass(), null);
			jContentPane.add(getJToggleButton(), null);
			jContentPane.add(jLabelPHOTO, null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
