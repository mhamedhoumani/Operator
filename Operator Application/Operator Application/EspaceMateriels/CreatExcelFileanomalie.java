package EspaceMateriels;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreatExcelFileanomalie {

	@SuppressWarnings({ "unused", "deprecation" })
	public CreatExcelFileanomalie(Anomalies pere){

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
rowhead.createCell((short) 0).setCellValue("Num");
rowhead.createCell((short) 1).setCellValue("Anomalydescription");
rowhead.createCell((short) 2).setCellValue("Servicetype");
rowhead.createCell((short) 3).setCellValue("Operator");
rowhead.createCell((short) 4).setCellValue("Action");
rowhead.createCell((short) 5).setCellValue("Responsability");
rowhead.createCell((short) 6).setCellValue("Date");
rowhead.createCell((short) 7).setCellValue("Statuts");
rowhead.createCell((short) 8).setCellValue("Remark");
rowhead.createCell((short) 9).setCellValue("Level");




Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://10.199.5.207:3306/monprojet", "ve", "");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("Select * from anomalies");
int i=1;
while(rs.next()){
HSSFRow row=   sheet.createRow((short)i);
row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("Num")));
row.createCell((short) 1).setCellValue(rs.getString("Anomalydescription"));
row.createCell((short) 2).setCellValue(rs.getString("Servicetype"));
row.createCell((short) 3).setCellValue(rs.getString("Operator"));
row.createCell((short) 4).setCellValue(rs.getString("Action"));
row.createCell((short) 5).setCellValue(rs.getString("Responsability"));
row.createCell((short) 6).setCellValue(rs.getString("Date"));
row.createCell((short) 7).setCellValue(rs.getString("Status"));
row.createCell((short) 8).setCellValue(rs.getString("Remark"));
row.createCell((short) 9).setCellValue(rs.getString("Level"));

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
