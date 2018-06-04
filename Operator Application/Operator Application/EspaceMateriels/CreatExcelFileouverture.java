package EspaceMateriels;

import  java.io.*;  
import  java.sql.*;
//8import javax.*;
import javax.swing.JFileChooser;
//8import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class CreatExcelFileouverture {

	@SuppressWarnings({ "unused", "deprecation" })
	public CreatExcelFileouverture(Douverture pere){

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
rowhead.createCell((short) 4).setCellValue("ouverture24i");
rowhead.createCell((short) 5).setCellValue("ouverture35i");
rowhead.createCell((short) 6).setCellValue("ouverture32i");
rowhead.createCell((short) 7).setCellValue("ouverture24o");
rowhead.createCell((short) 8).setCellValue("ouverture35o");
rowhead.createCell((short) 9).setCellValue("ouverture32o");




Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://10.199.5.207:3306/monprojet", "ve", "");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("Select ireg,NomPays,NomOperateur,TapCode,ouverture24i,ouverture35i,ouverture32i,ouverture24o,ouverture35o,ouverture32o from materiels");
int i=1;
while(rs.next()){
HSSFRow row=   sheet.createRow((short)i);
row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("ireg")));
row.createCell((short) 1).setCellValue(rs.getString("NomPays"));
row.createCell((short) 2).setCellValue(rs.getString("NomOperateur"));
row.createCell((short) 3).setCellValue(rs.getString("TapCode"));
row.createCell((short) 4).setCellValue(rs.getString("ouverture24i"));
row.createCell((short) 5).setCellValue(rs.getString("ouverture35i"));
row.createCell((short) 6).setCellValue(rs.getString("ouverture32i"));
row.createCell((short) 7).setCellValue(rs.getString("ouverture24o"));
row.createCell((short) 8).setCellValue(rs.getString("ouverture35o"));
row.createCell((short) 9).setCellValue(rs.getString("ouverture32o"));


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