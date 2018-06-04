package acceuil;
import EspaceMateriels.*;
//import EspaceDocuments.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Dimension;

@SuppressWarnings("unused")
public class EspaceChoix extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton = null;

	private MatteBorder border = null;

	private JButton jButton2 = null;

	private JButton jButton3 = null;
	
	private JButton jButton4 = null;
	
	private JLabel jLabel = null;

	/**
	 * This is the default constructor
	 */
	public EspaceChoix() {
		super();
		initialize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(455, 309);
		this.setContentPane(getJContentPane());
		this.setLocation(new Point(300, 300));
		this.setTitle("Espace de choix");
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
			jLabel = new JLabel();
			/*jLabel.setBounds(new Rectangle(32, 29, 188, 37));
			jLabel.setText("cilquer sur oui pour continuer");*/
			jContentPane = new JPanel();
		
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/inwi23.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(125, 70, 172, 35));
			jButton.setText("Tests IREG");
			//jButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jButton.setForeground(new Color(72,0,90));
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println(" "); 
					ESPACEDESMATERIELS();// TODO Auto-generated Event stub mouseClicked()
					fermer();
				}
			});
		}
		return jButton;
	}
	public void fermer(){
		dispose();
	}
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(125, 115, 172, 35));
			jButton3.setText("Ouvertures roaming");
			//jButton3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jButton3.setForeground(new Color(72,0,90));
			jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println(" ");
					ESPACEDOUVERTURE();// TODO Auto-generated Event stub mouseClicked()
					fermer();
				}
			});
		}
		return jButton3;
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(125, 160, 172, 35));
			jButton4.setText("Anomalies et problèmes");
			jButton4.setForeground(new Color(72,0,90));
			jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println(" ");
					ESPACEANOMALIE();// TODO Auto-generated Event stub mouseClicked()
					fermer();
				}
			});
		}
		return jButton4;
	}
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(125, 205, 172, 35));
			jButton2.setText("Quitter");
			jButton2.setForeground(new Color(72,0,90));
			jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println(" ");
					quitter();// TODO Auto-generated Event stub mouseClicked()
				}
			});
		}
		return jButton2;
	}
	public void quitter(){
		System.exit(0);
	}
	public void ESPACEDESMATERIELS(){
		TableauMateriel obj =new TableauMateriel();
		obj.setVisible(true);
	}
	public void ESPACEDOUVERTURE(){
		Douverture obj =new Douverture();
		obj.setVisible(true);
	}
	
	public void ESPACEANOMALIE(){
		Anomalies obj =new Anomalies();
		obj.setVisible(true);
	}
	

}  //  @jve:decl-index=0:visual-constraint="58,10"
