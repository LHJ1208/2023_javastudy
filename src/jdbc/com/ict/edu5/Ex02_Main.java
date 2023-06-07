package jdbc.com.ict.edu5;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Ex02_Main extends JFrame {
	JPanel jp1, jp2, jp3, jp4, jp5, jp6;
	JTextField jtf1, jtf2, jtf3, jtf4;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	JTextArea jta;
	JScrollPane jsp;

	public Ex02_Main() {
		super("DB 연동 정보");
		jp1 = new JPanel(new GridLayout(0, 2));
		jp2 = new JPanel(new GridLayout(0, 2));
		jp3 = new JPanel(new GridLayout(0, 2));
		jp4 = new JPanel(new GridLayout(0, 2));
		jp5 = new JPanel(new GridLayout(4, 0));
		jp6 = new JPanel();

		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();

		jb1 = new JButton("전체보기");
		jb2 = new JButton("삽입");
		jb3 = new JButton("삭제");
		jb4 = new JButton("검색");
		jb5 = new JButton("불러오기");
		jb6 = new JButton("고치기");
		jb6.setEnabled(false);

		jp1.add(new JLabel("* CUSTID  :  ", JLabel.CENTER));
		jp1.add(jtf1);

		jp2.add(new JLabel("NAME  :  ", JLabel.CENTER));
		jp2.add(jtf2);

		jp3.add(new JLabel("ADDRESS  :  ", JLabel.CENTER));
		jp3.add(jtf3);

		jp4.add(new JLabel("PHONE  :  ", JLabel.CENTER));
		jp4.add(jtf4);

		jp5.add(jp1);
		jp5.add(jp2);
		jp5.add(jp3);
		jp5.add(jp4);

		jta = new JTextArea();
		jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);
		jta.setEditable(false);

		jp6.add(jb1);
		jp6.add(jb2);
		jp6.add(jb3);
		jp6.add(jb4);
		jp6.add(jb5);
		jp6.add(jb6);

		add(jp5, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(jp6, BorderLayout.SOUTH);

		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jta.setFont(new Font("굴림", Font.PLAIN, 15));
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText("");
				ArrayList<Ex02_VO> list = Ex02_DAO.getInstance().getSelectAll();
				for (Ex02_VO k : list) {
					jta.append(k.getCustid() + "\t");
					jta.append(k.getName() + "\t");
					jta.append(k.getAddress() + "\t");
					jta.append(k.getPhone() + "\n");
				}
			}
		});

		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String custid = jtf1.getText().trim();
				String name = jtf2.getText().trim();
				String address = jtf3.getText().trim();
				String phone = jtf4.getText().trim();

				// custid가 null 이면 삽입불가
				if (custid.length() > 0) {
					// custid 중복이면 삽입불가
					boolean idchk = Ex02_DAO.getInstance().getIdChk(custid);

					// false 중복
					if (idchk) {
						jta.setText("");
						Ex02_VO vo = new Ex02_VO();
						vo.setCustid(custid);
						vo.setName(name);
						vo.setAddress(address);
						vo.setPhone(phone);
						int res = Ex02_DAO.getInstance().getInsert(vo);
						JOptionPane.showMessageDialog(getParent(), "삽입 성공");
					} else {
						JOptionPane.showMessageDialog(getParent(), "같은 custid가 존재합니다.");
					}

				} else {
					JOptionPane.showMessageDialog(getParent(), "custid를 써주세요");
				}
				jtf1.setText("");
			}
		});
	}

	public static void main(String[] args) {
		new Ex02_Main();
	}
}
