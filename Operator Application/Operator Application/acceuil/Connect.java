package acceuil;

import EspaceMateriels.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;

import java.sql.ResultSet;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("unused")
public class Connect extends JFrame {

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

	private JLabel jLabelERREUR = null;

	private JLabel jLabel = null;

	public Connect() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}

	public Connect(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public Connect(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public Connect(String arg0, GraphicsConfiguration arg1) {
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
			jTextFieldlogin.setBounds(new Rectangle(113, 116, 184, 20));
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
			jPasswordFieldpass.setBounds(new Rectangle(114, 152, 186, 20));
			jPasswordFieldpass.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					System.out.println("keyPressed()"); // TODO Auto-generated Event stub keyPressed()
				}
			});
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
			jToggleButton.setBounds(new Rectangle(315, 200, 104, 27));
			jToggleButton.setFont(new Font("Garamond", Font.BOLD, 12));
			jToggleButton.setText("Se connecter");
			jToggleButton.addMouseListener(new java.awt.event.MouseAdapter() {
				@SuppressWarnings("deprecation")
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(connection(jTextFieldlogin.getText(),jPasswordFieldpass.getText())){
						new TableauMateriel().setVisible(true);
						fermer();
					}else{
						jLabelERREUR.setText("Données incorectes !");
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
		String query="SELECT   * from administration" +
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
	}
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Connect thisClass = new Connect();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}*/

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(456, 309);
		this.setResizable(false);
		this.setLocation(new Point(400, 300));
		this.setContentPane(getJContentPane());
		this.setTitle("Administration");
		setIconImage(new ImageIcon(this.getClass().getResource("/LOGOS.jpg")).getImage());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(14, 59, 268, 35));
			jLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
			jLabel.setForeground(new Color(0, 204, 0));
			jLabel.setText("Veuillez saisir votre Login et mot de passe");
			jLabelERREUR = new JLabel();
			jLabelERREUR.setBounds(new Rectangle(130, 177, 171, 39));
			jLabelERREUR.setFont(new Font("Times New Roman", Font.BOLD, 12));
			jLabelERREUR.setForeground(Color.red);
			jLabelERREUR.setText("");
			jLabelPHOTO = new JLabel();
			jLabelPHOTO.setBounds(new Rectangle(318, 82, 116, 89));
			jLabelPHOTO.setIcon(new ImageIcon(getClass().getResource("/connected.jpg")));
			jLabelPHOTO.setText("");
			jLabelpass = new JLabel();
			jLabelpass.setBounds(new Rectangle(9, 151, 87, 16));
			jLabelpass.setFont(new Font("Garamond", Font.BOLD, 14));
			jLabelpass.setText("Mot de passe");
			jLabellogin = new JLabel();
			jLabellogin.setBounds(new Rectangle(52, 117, 43, 18));
			jLabellogin.setFont(new Font("Garamond", Font.BOLD, 14));
			jLabellogin.setText("Login");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/login.gif")));
			jContentPane.setBorder(border);
			jContentPane.add(jLabellogin, null);
			jContentPane.add(jLabelpass, null);
			jContentPane.add(getJTextFieldlogin(), null);
			jContentPane.add(getJPasswordFieldpass(), null);
			jContentPane.add(getJToggleButton(), null);
			jContentPane.add(jLabelPHOTO, null);
			jContentPane.add(jLabelERREUR, null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
