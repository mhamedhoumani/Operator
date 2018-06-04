
package EspaceMateriels;

import java.awt.*;
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

import EspaceMateriels.TableauMateriel;

@SuppressWarnings("unused")
public class ConsulterMateriel extends JFrame {

	private static final long serialVersionUID = 1L;
	public TableauMateriel parant=null;
	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	private MatteBorder border = null;
	private JPanel jContentPane = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13= null;
	private JLabel jLabel14= null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JButton jButton_ok = null;

	/**
	 * This is the default constructor
	 */
	public ConsulterMateriel(TableauMateriel EE,int code) {
		super();
		initialize();
	
		this.parant=EE;
		try{
		chargMateriel(code);
		//parant.setEnabled(false);
		}catch(Exception ex){
			
		}
		}
	/**
	 * 
	 * 
	 */
	public void chargMateriel(int cod)throws Exception{
		ConnexionBD con;
		String req="select ireg,NomPays,NomOperateur,TapCode from materiels where ireg='"+cod+"' ";
			con=new ConnexionBD(url,nomDriver);
			ResultSet curseur = null;
			curseur = con.rechercher(req);
			try{
			int i=0;
			while(curseur.next()){
                 jLabel11.setText(curseur.getString(1));
				 jLabel12.setText(curseur.getString(2));
				 jLabel13.setText(curseur.getString(3));
				 jLabel14.setText(curseur.getString(4));
				// jLabel15.setText(curseur.getString(5));
				// jLabel16.setText(curseur.getString(6));
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
		this.setSize(402, 291);
		this.setContentPane(getJContentPane());
		this.setTitle("Consultation");
		setIconImage(new ImageIcon(this.getClass().getResource("/LOGOS.jpg")).getImage());
		this.setResizable(false);

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
			jLabel11 = new JLabel();
	
			jLabel11.setBackground(Color.white);
			jLabel11.setBounds(new Rectangle(167, 38, 79, 20));
			jLabel11.setFont(new Font("Garamond", Font.PLAIN, 14));
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(165, 78, 168, 20));
			jLabel12.setFont(new Font("Garamond", Font.PLAIN, 14));
			jLabel12.setBackground(Color.white);
			jLabel13 = new JLabel();
			jLabel13.setBounds(new Rectangle(165, 118, 168, 20));
			jLabel13.setFont(new Font("Garamond", Font.PLAIN, 14));
			jLabel13.setBackground(Color.white);
			jLabel14= new JLabel();
			jLabel14.setBounds(new Rectangle(165, 158, 123, 20));
			jLabel14.setFont(new Font("Garamond", Font.PLAIN, 14));
			jLabel14.setBackground(Color.white);
			/*jLabel15= new JLabel();
			jLabel15.setBounds(new Rectangle(145, 141, 127, 20));
			jLabel15.setFont(new Font("Garamond", Font.PLAIN, 14));
			jLabel15.setBackground(Color.white);
			jLabel16= new JLabel();
			jLabel16.setBounds(new Rectangle(145, 184, 127, 20));
			jLabel16.setFont(new Font("Garamond", Font.PLAIN, 14));
			jLabel16.setBackground(Color.white);
			
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(51, 186, 55, 16));
			jLabel5.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel5.setForeground(new Color(72,0,90));
			jLabel5.setText("Modele");*/
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(37, 144, 83, 16));
			jLabel4.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel4.setForeground(new Color(72,0,90));
			//jLabel4.setText("DateD'ajout");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(60, 160, 70, 16));
			jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel3.setForeground(new Color(72,0,90));
			jLabel3.setText("Tap Code");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(60, 120, 70, 16));
			jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel2.setForeground(new Color(72,0,90));
			jLabel2.setText("Opérateur");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(60, 80, 70, 16));
			jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel1.setForeground(new Color(72,0,90));
			jLabel1.setText("Pays");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(60, 40, 70, 16));
			jLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel.setForeground(new Color(72,0,90));
			jLabel.setText("Ireg");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/consult33.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(jLabel11, null);
			jContentPane.add(jLabel12, null);
			jContentPane.add(jLabel13, null);
			jContentPane.add(jLabel14, null);
			jContentPane.add(jLabel14, null);
			/*jContentPane.add(jLabel15, null);
			jContentPane.add(jLabel16, null);*/
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			/*jContentPane.add(jLabel5, null);*/
		
			jContentPane.add(getJButton_ok(), null);
			jContentPane.add(jLabel11, null);
		}
		return jContentPane;
	}
	
	private JButton getJButton_ok() {
		if (jButton_ok == null) {
			jButton_ok = new JButton();
			jButton_ok.setBounds(new Rectangle(160, 210, 106, 21));
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
	