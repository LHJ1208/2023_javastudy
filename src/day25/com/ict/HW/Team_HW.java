package day25.com.ict.HW;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Team_HW extends JFrame {
	JPanel jp1, jp2, jp3, sp1;
	JTextField id, name, phone, address, com, jtf;
	GridLayout gl1;
	JButton add, delete, update, search, clear, all;
	JComboBox jcb1;
	JTable jtb;
	JScrollPane jsp;
	JLabel jl1, jl2, jl3, jl4, jl5;

	public Team_HW() {
		super("표");

		JLabel jl = new JLabel("Address Book");
		jl.setHorizontalAlignment(JLabel.CENTER);

		jp1 = new JPanel(new FlowLayout());
		BoxLayout bo = new BoxLayout(jp1, BoxLayout.PAGE_AXIS);
		jp1.setLayout(bo);

		JPanel jid = new JPanel();
		jl1 = new JLabel("ID : ");
		id = new JTextField(15);
		jid.add(jl1);
		jid.add(id);

		JPanel jname = new JPanel();
		jl2 = new JLabel("이름 : ");
		name = new JTextField(15);
		jname.add(jl2);
		jname.add(name);

		JPanel jphone = new JPanel();
		jl3 = new JLabel("전화 : ");
		phone = new JTextField(15);
		jphone.add(jl3);
		jphone.add(phone);

		JPanel jadd = new JPanel();
		jl4 = new JLabel("주소 : ");
		address = new JTextField(15);
		jadd.add(jl4);
		jadd.add(address);

		JPanel jcom = new JPanel();
		jl5 = new JLabel("회사 : ");
		com = new JTextField(15);
		jcom.add(jl5);
		jcom.add(com);

		jp1.add(jid);
		jp1.add(jname);
		jp1.add(jphone);
		jp1.add(jadd);
		jp1.add(jcom);

		jp2 = new JPanel();

		add = new JButton("추가");
		delete = new JButton("삭제");
		update = new JButton("수정");
		search = new JButton("검색");
		clear = new JButton("지우기");
		all = new JButton("전체보기");

		String[] arr = { "이름", "ID", "전화", "주소", "회사" };
		jcb1 = new JComboBox<String>(arr);

		jtf = new JTextField(15);

		jp2.add(add);
		jp2.add(delete);
		jp2.add(update);
		jp2.add(jcb1);
		jp2.add(jtf);
		jp2.add(search);
		jp2.add(clear);
		jp2.add(all);

		jtb = new JTable(15, 5);
		jsp = new JScrollPane(jtb);

		TeamTable table = new TeamTable();
		JTable jtable = new JTable(table);
		JScrollPane jsp = new JScrollPane(jtable);

		sp1 = new JPanel();
		sp1.add(jp1);
		sp1.add(jsp);

		add(jl, BorderLayout.NORTH);
		add(sp1, BorderLayout.CENTER);
		add(jp2, BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Team_HW();
	}
}
