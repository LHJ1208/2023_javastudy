package day33.com.ict.HW;

import javax.swing.table.AbstractTableModel;

//테이블을 만들기 위해서는 AbstractTableModel 상속받자
public class HW0612_AddressBook_Table_LHJ extends AbstractTableModel {

	// 1. 컬럼명(열의 대표적인 이름)을 배열로 만든다.
	private String[] table_columnName = { "ID", "Name", "Phone", "Address", "Company" };

//	String[][] data = { { "1", "aaaa", "a111", "12", "true" }, { "2", "bbbb", "b111", "15", "false" },
//			{ "3", "cccc", "c111", "18", "true" }, { "4", "dddd", "d111", "10", "false" } };

	private String[][] data = null;

	// 행의 수 = rows = 줄
	@Override
	public int getRowCount() {
		int result = 0;
		if (data != null) {
			result = data.length;
		}
		return result;
	}

	// 열의 수 = columns = 칸
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return table_columnName.length;
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		String result = null;

		if (data != null) {
			result = data[rowIndex][columnIndex];
		}
		return result;
	}

	// 컬럼명 붙이기
	@Override
	public String getColumnName(int column) {
		return table_columnName[column];
	}

	// 내용수정
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		if (columnIndex < 2)
		return false;

//		return true; // true -> 편집 가능
	}

	// 수정사항 반영하기
//	@Override
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		if (columnIndex > 1)
//			data[rowIndex][columnIndex] = (String) aValue;
//	}

	public String[][] getData() {
		return data;
	}

	public void setData(String[][] data) {
		this.data = data;
	}
}
