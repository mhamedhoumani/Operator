package EspaceMateriels;



import java.awt.BorderLayout;
import java.sql.ResultSet;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import acceuil.ConnexionBD;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("unused")
public class Docs extends JFrame {
	
	String goglee;
	String strSeleccionado;
	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://10.199.5.207:3306/monprojet?user=ve&passwod=";  //  @jve:decl-index=0:
	private String nomDriver="com.mysql.jdbc.Driver";  //  @jve:decl-index=0:
	
	ConnexionBD con;
	
	
	
	private MatteBorder border = null;
	private JPanel jContentPane = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JTextField jTextField6 = null;

	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel20 = null;
	private JLabel jLabel21 = null;
	private JLabel jLabel22 = null;
	
	private JTextField jTextField15 = null;
	private JButton jButton_parir24 = null; 
	private JButton jButton_ouvririr24 = null;
	private JButton jButton_supprimerir24 = null;
	private JButton jButton_ok = null;

	public TableauMateriel parant=null;
	JTextArea jtaRutaImagen;
	/**
	 * This is the default constructor
	 */
	public Docs(TableauMateriel pere,int code) {
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
	String s,s1;
public void chargerMateriel(int cod)throws Exception{
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
			s = curseur.getString(2);
			s1 = curseur.getString(3);

			
			i++;
		}
		}
		catch(Exception ex){
			
		}
		}


public void chargerDocs()throws Exception{
	ConnexionBD con;
	String req="select ireg,NomPays,NomOperateur,TapCode from materiels order by ireg";
		con=new ConnexionBD(url,nomDriver);
		ResultSet curseur = null;
		curseur = con.rechercher(req);
		try{
		int i=0;
		while(curseur.next()){
			jLabel11.setText(curseur.getString(1));
			jLabel12.setText(curseur.getString(2));
			jLabel13.setText(curseur.getString(3));
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
		this.setSize(500, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("DOCUMENTS");
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
			jLabel20 = new JLabel();
			jLabel20.setBounds(new Rectangle(110, 122, 180, 24));
			jLabel20.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel20.setForeground(new Color(72,0,90));
			jLabel20.setText("Ajouter fichier opérateur");
			jLabel21 = new JLabel();
			jLabel21.setBounds(new Rectangle(110, 152, 180, 24));
			jLabel21.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel21.setForeground(new Color(72,0,90));
			jLabel21.setText("Ouvrir fichier opérateur");
			jLabel22 = new JLabel();
			jLabel22.setBounds(new Rectangle(110, 182, 180, 24));
			jLabel22.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel22.setForeground(new Color(72,0,90));
			jLabel22.setText("Supprimer fichier opérateur");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(140, 82, 120, 16));
			jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel3.setForeground(new Color(72,0,90));
			jLabel3.setText("Opérateur");
			jLabel13 = new JLabel();
			jLabel13.setBounds(new Rectangle(255, 82, 168, 20));
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(140, 55, 120, 16));
			jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel2.setForeground(new Color(72,0,90));
			jLabel2.setText("Pays");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(255, 55, 168, 20));
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(140, 24, 120, 16));
			jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			jLabel1.setForeground(new Color(72,0,90));
			jLabel1.setText("Ireg");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(255, 24, 168, 20));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			border = new MatteBorder(new ImageIcon(getClass().getResource("/doc.jpg")));
			jContentPane.setBorder(border);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel12, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel13, null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(jLabel12, null);
			jContentPane.add(jLabel20, null);
			jContentPane.add(jLabel21, null);
			jContentPane.add(jLabel22, null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(getJButton_parir24(), null);
			jContentPane.add(getJButton_ouvririr24(), null);
			jContentPane.add(getJButton_supprimerir24(), null);
			jContentPane.add(getJButton_ok(), null);
		}
		return jContentPane;
	}

	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setEditable(true);
		}
		return jTextField6;
	}
	

	private JButton getJButton_ouvririr24() {
		if (jButton_ouvririr24 == null) {
			jButton_ouvririr24 = new JButton();
			jButton_ouvririr24.setBounds(new Rectangle(310, 152, 100, 24));
			jButton_ouvririr24.setIcon(new ImageIcon(getClass().getResource("/view.png")));
			jButton_ouvririr24.setText("Ouvrir");
			jButton_ouvririr24.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
			        ouvrir();
						parant.charger();			        
					}
			});
		}
		return jButton_ouvririr24;
	}
	
	

	private JButton getJButton_parir24() {
		if (jButton_parir24 == null) {
			jButton_parir24 = new JButton();
			jButton_parir24.setBounds(new Rectangle(310, 122, 100, 24));
			jButton_parir24.setText("Parcourir");
			jButton_parir24.setIcon(new ImageIcon(getClass().getResource("/par.gif")));
			jButton_parir24.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
						Cliente();
						parant.charger();			        
					}
			});
		}
		return jButton_parir24;
	}
	
	
	private JButton getJButton_supprimerir24() {
		if (jButton_supprimerir24 == null) {
			jButton_supprimerir24 = new JButton();
			jButton_supprimerir24.setBounds(new Rectangle(310, 182, 100, 24));
			jButton_supprimerir24.setText("Supprimer");
		
			jButton_supprimerir24.setIcon(new ImageIcon(getClass().getResource("/delete.png")));

			jButton_supprimerir24.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					supprimer3();
				
						}
						
					}		
			);
		}
		return jButton_supprimerir24;
	}
	
	
	private JButton getJButton_ok() {
		if (jButton_ok == null) {
			jButton_ok = new JButton();
			jButton_ok.setBounds(new Rectangle(310, 232, 100, 24));
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
	
	
	public  void supprimer3()
	{
	  
	      int in;
	      byte[] byteArray;
	      File archivo = null;

	      String IP = "10.199.5.20";
	      String nom=("\\IREG\\");
	String y = null;
	      Desktop d = Desktop.getDesktop();
	      try
	      {
	        String   gogle="//"+IP+nom+s+"/"+s1+"//"+s;
	          {

	            JFileChooser selector = new JFileChooser();		
	            selector.setApproveButtonText("Supprimer");
	            selector.removeActionListener(null);
          selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
          selector.setCurrentDirectory(new File("\\\\10.199.5.207\\ireg\\"+s+"\\"+s1+"\\")); 
	            int resultado = selector.showOpenDialog(null);
	            int bouton = 0;
				if (resultado == JFileChooser.APPROVE_OPTION)
					
	        	 bouton = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment supprimer ce fichier ?","Attention", JOptionPane.OK_CANCEL_OPTION);
		      
				  if(bouton==JOptionPane.YES_OPTION){
			            
	            
	            	try{
	            		
	                archivo = selector.getSelectedFile();
	               
	               archivo.delete();
	                direccionArchivo = archivo.getPath().toString();
	                String x=archivo.getName();
	              String nom1=("/IREG/");
		             gougle="//"+IP+nom1+s+"/"+s1+"/"+"\""+x+"\"";
	     System.out.println(gougle);
	           d.open(archivo);}
	                	 
				  	finally{}  } else{ supprimer3();
	            	       }}
	      
	            }catch (Exception e) {//JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
	    	  
	      }
}


	
	String direccionArchivo = null;
	String gogle1;
	String gougle;
	public  void ouvrir()
	{
	  
	      int in;
	      byte[] byteArray;
	      File archivo = null;

	      String IP = "10.199.5.207";
	      String nom=("\\IREG\\");
	
	      Desktop d = Desktop.getDesktop();

	      try
	      {
	        String   gogle="//"+IP+nom+s+"/"+s1+"//"+s;

	            JFileChooser selector = new JFileChooser();		
	            selector.setApproveButtonText("ouvrir");
	            selector.removeActionListener(null);
          selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
          selector.setCurrentDirectory(new File("\\\\10.199.5.207\\ireg\\"+s+"\\"+s1+"\\")); 
  //  System.out.println(g);
	            int resultado = selector.showOpenDialog(null);
	            if (resultado == JFileChooser.APPROVE_OPTION)
	            {
	            	try{
	                archivo = selector.getSelectedFile();
	                direccionArchivo=archivo.getCanonicalPath();
	                
	                String go=archivo.getName();
		       System.out.println( direccionArchivo);
		       String x2= direccionArchivo;
	                String x=archivo.getName();
	              String nom1=("\\IREG\\");
	             String f = "\\\\"+IP+nom1+s+"\\"+"\""+s1+"\""+"\\"+"\""+x+"\"";
	              ProcessBuilder pb = new ProcessBuilder("cmd", "/c", x2);
	              Process process = pb.start();
	   
	     System.out.println(x2);
	          d.open(archivo);
	                	 
	            	}finally{}  } else{ 

	        }
	 
	      }catch (Exception e) {
	      }
	   
}

    public  boolean Delete()  {
    	String fileName =jTextField15.getText();
        File file = new File(fileName);
        return file.delete();
    }
    
public void supprimerir24(){
		
	ConnexionBD con;
	String nom=getJTextField6().getText();
	
	nom="";
	
	String req="update materiels set "+"IR24='"+nom+"'"+" where ireg="+Integer.parseInt(jLabel11.getText())+"";
		System.out.println(req);
		//Ouverture de la connexion 
		con=new ConnexionBD(url,nomDriver);
		//Execution de requete
		con.supprime(req);
	}
	
	public  void Cliente()
	{
	  
	      int in;
	      byte[] byteArray;
	      File archivo = null;
	      String direccionArchivo = null;
	      String IP = "10.199.5.207";
	 
	      try
	      {
	         // IP = JOptionPane.showInputDialog(null,"Entrez Lip du pc distant","Cliente",JOptionPane.CANCEL_OPTION);
	          Socket via = new Socket(IP, 1234);
	          if(via.isConnected())
	          {
	            JOptionPane.showMessageDialog(null, "Connecté au Serveur: " + IP);
	        
	 
	            JFileChooser selector = new JFileChooser();
	            selector.setApproveButtonText("Envoyer");
	            int resultado = selector.showOpenDialog(null);
	            if (resultado == JFileChooser.APPROVE_OPTION)
	            {
	                archivo = selector.getSelectedFile();
	                direccionArchivo = archivo.getPath().toString();
	            } else{ 
	            	via.close();}
	 
	            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(direccionArchivo));
	            BufferedOutputStream bos = new BufferedOutputStream(via.getOutputStream());
	 
	            //Enviamos el nombre del archivo
	            DataOutputStream dos = new DataOutputStream(via.getOutputStream());
	            FileInputStream fis = new FileInputStream(archivo);
	            dos.writeUTF(archivo.getName());
	            
	            dos.writeUTF(s);
	            dos.writeUTF(s1);
	            dos.writeInt(3);
	          byte[] bytes = new byte[2097152];
	          while ((in = fis.read(bytes)) >0)
	            {
	                bos.write(bytes,0,in);
	            }
	       
	          fis.close();
	          dos.flush();
	            via.close();
	            bis.close();
	            bos.close();
	            
	            String oups=archivo.getName();
	            String nom=("/IREG/");
	            String gogle="//"+IP+nom+s+"/"+s1+"/"+"\""+oups+"\"";
	            jTextField6.setText(gogle); 
	           System.out.println(gogle);
	          String gogle1= "//"+IP+nom+s+"/"+s1+"/"+oups;
	        }
	 
	      }catch (Exception e) {
	      }
	   
	   }
	
	
	public void modifier(){
		ConnexionBD conn;
		
		String nom=getJTextField6().getText();
		
		String req="update materiels set " +"IR24='"+nom+"'"+" where ireg="+Integer.parseInt(jLabel11.getText())+"";
		
		
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