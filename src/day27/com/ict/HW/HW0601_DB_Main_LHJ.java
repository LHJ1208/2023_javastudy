package day27.com.ict.HW;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HW0601_DB_Main_LHJ extends JFrame {
	JPanel p_North, p_NorthLeft, p_NorthRight, p_South;

	JLabel l_custid, l_name, l_address, l_phone;
	JTextField tf_custid, tf_name, tf_address, tf_phone;

	JTextArea jta;
	JScrollPane jsp;

	JButton b_showAll, b_insert, b_delete, b_search, b_load, b_update;

	public HW0601_DB_Main_LHJ() {
		super("DB 연동 정보");

		p_North = new JPanel(new GridLayout(1, 2));
		p_NorthLeft = new JPanel(new GridLayout(4, 1));
		p_NorthRight = new JPanel(new GridLayout(4, 1));

		p_North.add(p_NorthLeft);
		p_North.add(p_NorthRight);

		l_custid = new JLabel("CUSTID :");
		l_name = new JLabel("NAME :");
		l_address = new JLabel("ADDRESS :");
		l_phone = new JLabel("PHONE :");

		l_custid.setHorizontalAlignment(JLabel.CENTER);
		l_name.setHorizontalAlignment(JLabel.CENTER);
		l_address.setHorizontalAlignment(JLabel.CENTER);
		l_phone.setHorizontalAlignment(JLabel.CENTER);

		p_NorthLeft.add(l_custid);
		p_NorthLeft.add(l_name);
		p_NorthLeft.add(l_address);
		p_NorthLeft.add(l_phone);

		tf_custid = new JTextField();
		tf_name = new JTextField();
		tf_address = new JTextField();
		tf_phone = new JTextField();

		p_NorthRight.add(tf_custid);
		p_NorthRight.add(tf_name);
		p_NorthRight.add(tf_address);
		p_NorthRight.add(tf_phone);

		jta = new JTextArea();
		jta.setLineWrap(true);
		jta.setEditable(false);

		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		p_South = new JPanel();

		b_showAll = new JButton("전체보기");
		b_insert = new JButton("삽입");
		b_delete = new JButton("삭제");
		b_search = new JButton("검색");
		b_load = new JButton("불러오기");
		b_update = new JButton("고치기");

		b_update.setEnabled(false);

		p_South.add(b_showAll);
		p_South.add(b_insert);
		p_South.add(b_delete);
		p_South.add(b_search);
		p_South.add(b_load);
		p_South.add(b_update);

		add(p_North, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(p_South, BorderLayout.SOUTH);

		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		b_showAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionShowAll();
			}
		});
		b_insert.addActionListener(new ActionListener() {
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
				actionSearch();
			}
		});

		b_load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionLoad();
			}
		});

		b_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionUpdate();
			}
		});

		tf_custid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String custid = tf_custid.getText();
				if (custid != null && custid.length() > 0) {
					try {
						Integer.parseInt(custid);
						b_update.setEnabled(true);
					} catch (Exception exception) {
						b_update.setEnabled(false);
					}
				} else {
					b_update.setEnabled(false);
				}
			}
		});
	}

	public boolean actionShowAll() {
		boolean result = false;

		ArrayList<HW0601_DB_VO_LHJ> list = HW0601_DB_DAO_LHJ.getInstance().getSelectAll();

		jta.setText("");
		jta.append("custid\tname\t\taddress\t\tphone\n");
		if (list != null) {
			for (HW0601_DB_VO_LHJ k : list) {
				jta.append(k.getCustid() + "\t");
				jta.append(k.getName() + "\t\t");
				jta.append(k.getAddress() + "\t\t");
				jta.append(k.getPhone() + "\n");
			}
			result = true;
		}

		return result;
	}

	public boolean actionInsert() {
		boolean result = false;

		String custid = tf_custid.getText();
		String name = tf_name.getText();
		String address = tf_address.getText();
		String phone = tf_phone.getText();

		if (checkCustIDLength(custid)) {
			if (checkCustIDInt(custid)) {
				if (!HW0601_DB_DAO_LHJ.getInstance().isExist(custid)) {
					HW0601_DB_VO_LHJ tmpVO = new HW0601_DB_VO_LHJ(custid);
					if (name.length() > 0) {
						tmpVO.setName(name);
					}
					if (address.length() > 0) {
						tmpVO.setAddress(address);
					}
					if (phone.length() > 0) {
						tmpVO.setPhone(phone);
					}

					if (HW0601_DB_DAO_LHJ.getInstance().getInsert(tmpVO) > 0) {
						JOptionPane.showMessageDialog(getParent(), "custid : " + custid + " 삽입 성공", "SQL 실행 성공",
								JOptionPane.PLAIN_MESSAGE);
						tf_custid.setText("");
						tf_name.setText("");
						tf_address.setText("");
						tf_phone.setText("");
						jta.setText("");
						jta.append("custid\tname\t\taddress\t\tphone\n");
						jta.append(custid + "\t");
						jta.append((name.length() > 0 ? name : "null") + "\t\t");
						jta.append((address.length() > 0 ? address : "null") + "\t\t");
						jta.append((phone.length() > 0 ? phone : "null") + "\n");
						b_update.setEnabled(false);
						result = true;
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "해당 custid가 이미 존재합니다.", "SQL 실행 실패",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}

		return result;
	}

	public boolean actionDelete() {
		boolean result = false;

		String custid = tf_custid.getText();

		if (checkCustIDLength(custid)) {
			if (checkCustIDInt(custid)) {
				if (HW0601_DB_DAO_LHJ.getInstance().isExist(custid)) {
					if (HW0601_DB_DAO_LHJ.getInstance().getDelete(custid) > 0) {
						JOptionPane.showMessageDialog(getParent(), "custid : " + custid + " 삭제 성공", "SQL 실행 성공",
								JOptionPane.PLAIN_MESSAGE);
						tf_custid.setText("");
						tf_name.setText("");
						tf_address.setText("");
						tf_phone.setText("");
						jta.setText("");
						b_update.setEnabled(false);
						result = true;
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "해당 custid가 존재하지 않습니다.", "SQL 실행 실패",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}

		return result;
	}

	public boolean actionSearch() {
		boolean result = false;

		String custid = tf_custid.getText();

		jta.setText("");
		if (custid.length() > 0) {
			if (checkCustIDInt(custid)) {
				HW0601_DB_VO_LHJ tmpVO = HW0601_DB_DAO_LHJ.getInstance().getSelectOne(custid);

				jta.append("custid\tname\t\taddress\t\tphone\n");
				if (tmpVO != null) {
					JOptionPane.showMessageDialog(getParent(), "custid : " + custid + " 검색 성공", "SQL 실행 성공",
							JOptionPane.PLAIN_MESSAGE);
					jta.append(tmpVO.getCustid() + "\t");
					jta.append(tmpVO.getName() + "\t\t");
					jta.append(tmpVO.getAddress() + "\t\t");
					jta.append(tmpVO.getPhone() + "\n");
					tf_custid.setText("");
					tf_name.setText("");
					tf_address.setText("");
					tf_phone.setText("");
					b_update.setEnabled(false);
					result = true;
				} else {
					JOptionPane.showMessageDialog(getParent(), "해당 custid를 찾을 수 없음", "SQL 실행 성공",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		}

		return result;
	}

	public boolean actionLoad() {
		boolean result = false;

		String custid = tf_custid.getText();

		jta.setText("");
		if (custid.length() > 0) {
			if (checkCustIDInt(custid)) {
				HW0601_DB_VO_LHJ tmpVO = HW0601_DB_DAO_LHJ.getInstance().getSelectOne(custid);

				if (tmpVO != null) {
					tf_name.setText(tmpVO.getName());
					tf_address.setText(tmpVO.getAddress());
					tf_phone.setText(tmpVO.getPhone());
					result = true;
					JOptionPane.showMessageDialog(getParent(), "custid : " + custid + " 불러오기 성공", "SQL 실행 성공",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(getParent(), "해당 custid를 찾을 수 없음", "SQL 실행 성공",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		}

		return result;
	}

	public boolean actionUpdate() {
		boolean result = false;

		String custid = tf_custid.getText();
		String name = tf_name.getText();
		String address = tf_address.getText();
		String phone = tf_phone.getText();

		if (checkCustIDLength(custid)) {
			if (checkCustIDInt(custid)) {
				if (HW0601_DB_DAO_LHJ.getInstance().isExist(custid)) {
					HW0601_DB_VO_LHJ tmpVO = new HW0601_DB_VO_LHJ(custid);
					if (name.length() > 0) {
						tmpVO.setName(name);
					}
					if (address.length() > 0) {
						tmpVO.setAddress(address);
					}
					if (phone.length() > 0) {
						tmpVO.setPhone(phone);
					}

					if (HW0601_DB_DAO_LHJ.getInstance().getUpdate(tmpVO) > 0) {
						JOptionPane.showMessageDialog(getParent(), "custid : " + custid + " 수정 성공", "SQL 실행 성공",
								JOptionPane.PLAIN_MESSAGE);
						tf_custid.setText("");
						tf_name.setText("");
						tf_address.setText("");
						tf_phone.setText("");
						jta.setText("");
						jta.append("custid\tname\t\taddress\t\tphone\n");
						jta.append(custid + "\t");
						jta.append((name.length() > 0 ? name : "null") + "\t\t");
						jta.append((address.length() > 0 ? address : "null") + "\t\t");
						jta.append((phone.length() > 0 ? phone : "null") + "\n");
						b_update.setEnabled(false);
						result = true;
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "해당 custid를 찾을 수 없음.", "SQL 실행 실패",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}

		return result;
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
		new HW0601_DB_Main_LHJ();
	}
}
