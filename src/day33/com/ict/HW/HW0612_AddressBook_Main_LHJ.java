package day33.com.ict.HW;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import day17.com.ict.edu3.Ex01_JTable;

public class HW0612_AddressBook_Main_LHJ extends JFrame {
	Image java_image;

	JPanel p_North, p_Center, p_CenterLeft, p_South;
	JLabel l_frame;

	BoxLayout boxLayout;

	JPanel p_id, p_name, p_phone, p_address, p_company;
	JLabel l_ID, l_name, l_phone, l_address, l_company;
	JTextField tf_ID, tf_name, tf_phone, tf_address, tf_company;

//	String[][] table_data = { { "100", "dada", "010-111-2225", "seoul", "cj" },
//			{ "101", "jeego", "010-111-2225", "seoul", "asianaidt" },
//			{ "102", "min", "010-111-2225", "seoul", "asianaidt" }, { "103", "song", "010-111-2225", "seoul", "cj" },
//			{ "104", "tommy", "010-900-2245", "la", "samsung" }, { "105", "billy", "010-133-2300", "tokyo", "hyundai" },
//			{ "106", "jane", "010-623-2235", "pusan", "lg" }, { "107", "mel", "010-155-5211", "tokyo", "lg" },
//			{ "108", "bruce", "010-721-7800", "pusan", "cj" }, { "109", "neil", "010-451-3888", "seoul", "samsung" },
//			{ "110", "mat", "010-112-2095", "la", "hyundai" }, { "111", "bong", "010-354-2332", "london", "asianaidt" },
//			{ "112", "jin", "010-622-8360", "osaka", "cj" }, { "113", "jaja", "666666", "busan", "12asdasdsad" }, };
//	String[] table_columnName = { "ID", "Name", "Phone", "Address", "Company" };

	JTable table_DB;
	HW0612_AddressBook_Table_LHJ tableModel;

	JButton b_add, b_delete, b_update, b_search, b_clear, b_showAll;

	String[] comboItems = { "이름", "ID", "전화", "주소", "회사" };
	JComboBox<String> com_category = new JComboBox<>(comboItems);

	JTextField tf_search;

	JTextArea jta;
	JScrollPane jsp;

	int numCol = 15;

	public HW0612_AddressBook_Main_LHJ() {
//		java_image = Toolkit.getDefaultToolkit().getImage("src/images/java_ico.png");
//		setIconImage(java_image);

		p_North = new JPanel();
		l_frame = new JLabel("Address Book");
		p_North.add(l_frame);

		p_Center = new JPanel(new FlowLayout());
		p_CenterLeft = new JPanel();
		boxLayout = new BoxLayout(p_CenterLeft, BoxLayout.PAGE_AXIS);
		p_CenterLeft.setLayout(boxLayout);

		p_id = new JPanel();
		l_ID = new JLabel("    I D :");
		tf_ID = new JTextField(numCol);
		p_id.add(l_ID);
		p_id.add(tf_ID);

		p_name = new JPanel();
		l_name = new JLabel("이름 :");
		tf_name = new JTextField(numCol);
		p_name.add(l_name);
		p_name.add(tf_name);

		p_phone = new JPanel();
		l_phone = new JLabel("전화 :");
		tf_phone = new JTextField(numCol);
		p_phone.add(l_phone);
		p_phone.add(tf_phone);

		p_address = new JPanel();
		l_address = new JLabel("주소 :");
		tf_address = new JTextField(numCol);
		p_address.add(l_address);
		p_address.add(tf_address);

		p_company = new JPanel();
		l_company = new JLabel("회사 :");
		tf_company = new JTextField(numCol);
		p_company.add(l_company);
		p_company.add(tf_company);

		p_CenterLeft.add(p_id);
		p_CenterLeft.add(p_name);
		p_CenterLeft.add(p_phone);
		p_CenterLeft.add(p_address);
		p_CenterLeft.add(p_company);

//		table_DB = new JTable(table_data, table_columnName);
		tableModel = new HW0612_AddressBook_Table_LHJ();
		table_DB = new JTable(tableModel);

		p_Center.add(p_CenterLeft);
		p_Center.add(new JScrollPane(table_DB));

		p_South = new JPanel();

		b_add = new JButton("추가");
		b_delete = new JButton("삭제");
		b_update = new JButton("수정");
		b_search = new JButton("검색");
		b_clear = new JButton("지우기");
		b_showAll = new JButton("전체보기");

		tf_search = new JTextField(15);

		p_South.add(b_add);
		p_South.add(b_delete);
		p_South.add(b_update);
		p_South.add(com_category);
		p_South.add(tf_search);
		p_South.add(b_search);
		p_South.add(b_clear);
		p_South.add(b_showAll);

		add(p_North, BorderLayout.NORTH);
		add(p_Center, BorderLayout.CENTER);
		add(p_South, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		b_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionInsert();
			}
		});

		b_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionDelete();
			}
		});

		b_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s_category = (String) com_category.getSelectedItem();
				if (s_category.equals("ID")) {
					actionSearchByCustID();
				} else if (s_category.equals("회사")) {
					if (tf_search.getText().length() > 0) {
						tableModel.setData(null);
						table_DB.updateUI();
					} else {
						actionShowAll();
					}
				} else {
					actionSearchByOthers(s_category);
				}
			}
		});

		b_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionUpdate();
			}
		});

		b_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableModel.setData(null);
				table_DB.updateUI();
			}
		});

		b_showAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionShowAll();
			}
		});
	}

	public void actionInsert() {
		String custid = tf_ID.getText();
		String name = tf_name.getText();
		String address = tf_address.getText();
		String phone = tf_phone.getText();

		if (checkCustIDLength(custid)) {
			if (checkCustIDInt(custid)) {
				if (!HW0612_DB_DAO_LHJ.isExist(custid)) {
					HW0612_DB_VO_LHJ tmpVO = new HW0612_DB_VO_LHJ(custid);
					tmpVO.setName(name);
					tmpVO.setAddress(address);
					tmpVO.setPhone(phone);

					if (HW0612_DB_DAO_LHJ.getInsert(tmpVO) > 0) {
						tf_ID.setText("");
						tf_name.setText("");
						tf_address.setText("");
						tf_phone.setText("");
						JOptionPane.showMessageDialog(getParent(), "custid : " + custid + " 추가 성공", "SQL 실행 성공",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "해당 custid가 이미 존재합니다.", "SQL 실행 실패",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}

	public void actionDelete() {
		String custid = tf_ID.getText();

		if (checkCustIDLength(custid)) {
			if (checkCustIDInt(custid)) {
				if (HW0612_DB_DAO_LHJ.isExist(custid)) {
					HW0612_DB_VO_LHJ tmpVO = new HW0612_DB_VO_LHJ(custid);
					if (HW0612_DB_DAO_LHJ.getDelete(tmpVO) > 0) {
						tf_ID.setText("");
						JOptionPane.showMessageDialog(getParent(), "custid : " + custid + " 삭제 성공", "SQL 실행 성공",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "해당 custid가 존재하지 않습니다.", "SQL 실행 실패",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}

	public boolean actionUpdate() {
		boolean result = false;

		String custid = tf_ID.getText();
		String name = tf_name.getText();
		String address = tf_address.getText();
		String phone = tf_phone.getText();

		if (checkCustIDLength(custid)) {
			if (checkCustIDInt(custid)) {
				if (HW0612_DB_DAO_LHJ.isExist(custid)) {
					HW0612_DB_VO_LHJ tmpVO = new HW0612_DB_VO_LHJ(custid);
					tmpVO.setName(name);
					tmpVO.setAddress(address);
					tmpVO.setPhone(phone);

					if (HW0612_DB_DAO_LHJ.getUpdate(tmpVO) > 0) {
						tf_ID.setText("");
						tf_name.setText("");
						tf_address.setText("");
						tf_phone.setText("");
						JOptionPane.showMessageDialog(getParent(), "custid : " + custid + " 수정 성공", "SQL 실행 성공",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "해당 custid를 찾을 수 없음.", "SQL 실행 실패",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}

		return result;
	}

	public void actionSearchByCustID() {
		String custid = tf_search.getText();

		if (custid.length() > 0) {
			if (checkCustIDInt(custid)) {
				HW0612_DB_VO_LHJ tmpVO = HW0612_DB_DAO_LHJ.getSelectOne(custid);

				if (tmpVO != null) {
					String[][] tempData = new String[1][tableModel.getColumnCount()];
					tempData[0][0] = tmpVO.getCustid();
					tempData[0][1] = tmpVO.getName();
					tempData[0][2] = tmpVO.getPhone();
					tempData[0][3] = tmpVO.getAddress();
					tempData[0][4] = null;

					tableModel.setData(tempData);
					table_DB.updateUI();

					tf_search.setText("");

				} else {
					tableModel.setData(null);
					table_DB.updateUI();

					tf_search.setText("");
				}
			}
		}
	}

	public void actionSearchByOthers(String s_category) {
		String searchWord = tf_search.getText();

		if (searchWord.length() > 0) {
			List<HW0612_DB_VO_LHJ> list = null;
			if (s_category.equals("이름")) {
				list = HW0612_DB_DAO_LHJ.getSelectByName(searchWord);
			} else if (s_category.equals("전화")) {
				list = HW0612_DB_DAO_LHJ.getSelectByPhone(searchWord);
			} else if (s_category.equals("주소")) {
				list = HW0612_DB_DAO_LHJ.getSelectByAddress(searchWord);
			}

			if (list != null) {
				String[][] tempList = new String[list.size()][tableModel.getColumnCount()];
				int i = 0;
				for (HW0612_DB_VO_LHJ k : list) {
					tempList[i][0] = k.getCustid();
					tempList[i][1] = k.getName();
					tempList[i][2] = k.getPhone();
					tempList[i][3] = k.getAddress();
					tempList[i][4] = null;
					i++;
				}
				tableModel.setData(tempList);
				table_DB.updateUI();

				tf_search.setText("");
			} else {
				tableModel.setData(null);
				table_DB.updateUI();

				tf_search.setText("");
			}
		}
	}

	public void actionShowAll() {
		List<HW0612_DB_VO_LHJ> list = HW0612_DB_DAO_LHJ.getSelectAll();

		if (list != null) {
			String[][] tempList = new String[list.size()][tableModel.getColumnCount()];
			int i = 0;
			for (HW0612_DB_VO_LHJ k : list) {
				tempList[i][0] = k.getCustid();
				tempList[i][1] = k.getName();
				tempList[i][2] = k.getPhone();
				tempList[i][3] = k.getAddress();
				tempList[i][4] = null;
				i++;
			}
			tableModel.setData(tempList);
			table_DB.updateUI();
		} else {
			tableModel.setData(null);
			table_DB.updateUI();
		}
	}

	public boolean checkCustIDLength(String custid) {
		if (custid != null) {
			if (custid.length() > 0) {
				return true;
			}
		}
		JOptionPane.showMessageDialog(getParent(), "custid를 입력하시오.", "SQL 실행 실패", JOptionPane.WARNING_MESSAGE);

		return false;
	}

	public boolean checkCustIDInt(String custid) {
		boolean result = true;
		try {
			Integer.parseInt(custid);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			JOptionPane.showMessageDialog(getParent(), "custid에 숫자를 입력하시오.", "SQL 실행 실패", JOptionPane.WARNING_MESSAGE);
		}
		return result;
	}

	public static void main(String[] args) {
		new HW0612_AddressBook_Main_LHJ();
	}
}
