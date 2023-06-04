package day25.com.ict.HW;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class HW0530_LHJ extends JFrame {
	JPanel p_North, p_NorthLeft, p_NorthRight, p_South;

	JLabel l_custid, l_name, l_address, l_phone;
	JTextField tf_custid, tf_name, tf_address, tf_phone;

	JTextArea jta;
	JScrollPane jsp;

	JButton b_showAll, b_insert, b_delete, b_search, b_load, b_update;

	public HW0530_LHJ() {
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
	}

	public static void main(String[] args) {
		new HW0530_LHJ();
	}
}
