package EspaceMateriels;

import java.awt.Image;
import java.awt.Toolkit;
import  java.io.*;  
import  java.sql.*;
import javax.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


@SuppressWarnings("unused")
public class CreatExcelFiletableau {

	@SuppressWarnings("deprecation")
	public CreatExcelFiletableau(TableauMateriel pere){

        File archivo = null;
	      String direccionArchivo = null;
	      FileOutputStream charger = null;
    	try{
	
	 JFileChooser selector = new JFileChooser();
     selector.setDialogTitle("Enregistrer sous");
     int resultado = selector.showSaveDialog(null);
   
	if (resultado == JFileChooser.APPROVE_OPTION)
     {
       
      charger = new FileOutputStream(selector.getSelectedFile().getPath()+".xls");
     }
//String filename="c:/ireg/data.xls" ;
HSSFWorkbook hwb=new HSSFWorkbook();
HSSFSheet sheet =  hwb.createSheet("new sheet");

HSSFRow rowhead=   sheet.createRow((short)0);
rowhead.createCell((short) 0).setCellValue("ireg");
rowhead.createCell((short) 1).setCellValue("NomPays");
rowhead.createCell((short) 2).setCellValue("NomOperateur");
rowhead.createCell((short) 3).setCellValue("TapCode");
rowhead.createCell((short) 4).setCellValue("SS7");
rowhead.createCell((short) 5).setCellValue("Simcard");
rowhead.createCell((short) 6).setCellValue("Testeur");
rowhead.createCell((short) 7).setCellValue("Start24i");
rowhead.createCell((short) 8).setCellValue("End24i");
rowhead.createCell((short) 9).setCellValue("Start35i");
rowhead.createCell((short) 10).setCellValue("End35i");
rowhead.createCell((short) 11).setCellValue("Start32i");
rowhead.createCell((short) 12).setCellValue("End32i");
rowhead.createCell((short) 13).setCellValue("Start24o");
rowhead.createCell((short) 14).setCellValue("End24o");
rowhead.createCell((short) 15).setCellValue("Start35o");

rowhead.createCell((short) 16).setCellValue("End35o");
rowhead.createCell((short) 17).setCellValue("Start32o");
rowhead.createCell((short) 18).setCellValue("End32o");

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://10.199.5.207:3306/monprojet", "ve", "");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("Select ireg,NomPays,NomOperateur,Tapcode,Ss7,Simcard,Testeur,Start24i,End24i,Start35i,End35i,Start32i,End32i,Start24o,End24o,Start35o,End35o,Start32o,End32o from materiels");
int i=1;
while(rs.next()){
HSSFRow row=   sheet.createRow((short)i);
row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("ireg")));
row.createCell((short) 1).setCellValue(rs.getString("NomPays"));
row.createCell((short) 2).setCellValue(rs.getString("NomOperateur"));
row.createCell((short) 3).setCellValue(rs.getString("TapCode"));
row.createCell((short) 4).setCellValue(rs.getString("Ss7"));
row.createCell((short) 5).setCellValue(rs.getString("Simcard"));
row.createCell((short) 6).setCellValue(rs.getString("Testeur"));
row.createCell((short) 7).setCellValue(rs.getString("Start24i"));
row.createCell((short) 8).setCellValue(rs.getString("End24i"));
row.createCell((short) 9).setCellValue(rs.getString("Start35i"));
row.createCell((short) 10).setCellValue(rs.getString("End35i"));
row.createCell((short) 11).setCellValue(rs.getString("Start32i"));
row.createCell((short) 12).setCellValue(rs.getString("End32i"));
row.createCell((short) 13).setCellValue(rs.getString("Start24o"));
row.createCell((short) 14).setCellValue(rs.getString("End24o"));
row.createCell((short) 15).setCellValue(rs.getString("Start35o"));
row.createCell((short) 16).setCellValue(rs.getString("End35o"));
row.createCell((short) 17).setCellValue(rs.getString("Start32o"));
row.createCell((short) 18).setCellValue(rs.getString("End32o"));


i++;
}
//FileOutputStream fileOut =  new FileOutputStream(filename);
hwb.write(charger);
charger.close();
System.out.println("Your excel file has been generated!");

} catch ( Exception ex ) {
    System.out.println(ex);

}
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}