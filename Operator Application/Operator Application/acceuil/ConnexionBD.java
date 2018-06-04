package acceuil;

import java.sql.*;

public class ConnexionBD {
	
	public Connection          con = null;
    public Statement           sta=null;
    public ResultSet           re=null;
    public ResultSetMetaData   metaBase;
    public ConnexionBD(String url, String NomDriver) {
        try {
            Class.forName(NomDriver);
            con = DriverManager.getConnection(url);
            System.out.println("Overture de la connection");
            sta = con.createStatement();
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Ne peut pas trouver les classes du conducteur de la base de données.");
            System.err.println(ex);
        }
        catch (SQLException ex) {
            System.err.println("pas de connection au base de de donnee.");
            System.err.println(ex);
        }
     }
    public ResultSet rechercher(String query){
    	try { 
    	re=sta.executeQuery(query);
    	System.out.println("Element trouvee ");
    		}
    	catch (SQLException ex) {
            System.err.println(ex);
         }
    	return re;
    	}    
    public void ajouter(String query){
    	try { 
    	sta.executeUpdate(query);
    	System.out.println("Element ajouter a la base");
    		}
    	catch (SQLException ex) {
            System.err.println(ex);
    	}      
    }   
    public void modifier(String query){
    	try { 
    	sta.executeUpdate(query);
    	System.out.println("Element Modifier");
    	}
    	catch (SQLException ex){
        System.err.println(ex);
    	}  	
    }   
    public void modifieri(String query){
    	try { 
    	sta.executeUpdate(query);
    	System.out.println("Element ModifierI");
    	}
    	catch (SQLException ex){
        System.err.println(ex);
    	}  	
    }   
    
    public void supprime(String query){
    	try { 
    	sta.executeUpdate(query);
    	System.out.println("Element suprimer");    	
    	}
    	catch (SQLException ex) {
         System.err.println(ex);
    	}  	
    }
    public void fermer(){
    	try {
			re.close();
		} catch (SQLException e) {
			System.out.println("Problème de fermeture de la Base de données");
		}
        System.out.println("Base de données Férmer");
    }
    
    
}