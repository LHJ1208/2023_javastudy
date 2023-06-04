package day25.com.ict.HW;

import javax.swing.AbstractAction;
import javax.swing.table.AbstractTableModel;

public class TeamTable extends AbstractTableModel {

	String[] name = { "ID", "Name", "Phone", "Address", "Company" };
	String[][] data = { { "100", "dada", "010-111-2225", "seoul", "cj" },
			{ "101", "jeeho", "010-111-2225", "seoul", "asianaidt" },
			{ "102", "min", "010-111-2225", "seoul", "asianaidt" }, { "103", "song", "010-111-2225", "seoul", "cj" },
			{ "104", "tommy", "010-900-2245", "la", "samsung" }, { "105", "billy", "010-133-2300", "tokyo", "hyundai" },
			{ "106", "jane", "010-623-2235", "busan", "lg" }, { "107", "mel", "010-155-5211", "tokyo", "lg" },
			{ "108", "bruce", "010-721-7800", "busan", "cj" }, { "109", "neil", "010-451-3888", "seoul", "samsung" },
			{ "110", "mat", "010-112-2095", "la", "hyundai" }, { "111", "bong", "010-354-2332", "london", "asianaidt" },
			{ "112", "jin", "010-622-8360", "osaka", "cj" }, { "113", "jaja", "666666", "busan", "12asdasdsad" }, };

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return name.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return name[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (columnIndex != 0) {
			data[rowIndex][columnIndex] = (String) aValue;
		}
	}

}
