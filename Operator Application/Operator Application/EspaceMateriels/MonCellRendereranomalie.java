package EspaceMateriels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MonCellRendereranomalie extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);
		if (column == 7){
		cell.setForeground(Color.red); 
		cell.setFont(new Font("Dialog", Font.BOLD, 12));}
		else{
			cell.setForeground(Color.black);}
		return cell;
		
	}
	
}