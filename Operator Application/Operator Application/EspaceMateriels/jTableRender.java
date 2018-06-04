package EspaceMateriels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Définir l'affichage dans un JTable
 * @author Fobec 2010
 */
@SuppressWarnings("serial")
public class jTableRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      
        
        
        Object o = table.getValueAt(row,column);
        
        if(column==5 || column == 6 || column==7 || column == 8 || column==9 || column == 4){
       
	if (o != null && component instanceof JLabel) {
        	
            JLabel label = (JLabel) component;
            if (label.getText().contains("OnGoing")) {
                component.setForeground(new Color(255,153,0));
                component.setFont(new Font("Dialog", Font.BOLD, 12));
            }
            
            else if (label.getText().contains("Test Closed")) {
               component.setForeground(Color.RED);
                component.setFont(new Font("Dialog", Font.BOLD, 12));
            }
            else if (label.getText().contains("-") || label.getText().contains("/") ) {
                component.setForeground(new Color(0,128,0));
                component.setFont(new Font("Dialog", Font.BOLD, 12));
            }
            else {Color clr = Color.BLACK;
            component.setForeground(clr);
            }
        }}
	else {component.setForeground(Color.BLACK);  }

		return component;
		
    }    

}