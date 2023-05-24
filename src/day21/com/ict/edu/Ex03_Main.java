package day21.com.ict.edu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import day18.com.ict.edu.Ex03;

public class Ex03_Main extends JFrame {
	Ex03_Join join;

	JPanel jp;

	JButton jb1, jb2;

	public Ex03_Main() {
		super("여러 창 사용하기");

		join = new Ex03_Join(Ex03_Main.this);

		jp = new JPanel();
		jb1 = new JButton("회원가입");
		jb2 = new JButton("로그인");

		jp.add(jb1);
		jp.add(jb2);

		add(jp);

		// pack();
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				// 익명 내부클래스에서는
				// this를 사용할 때 클래스.this를 사용해야 된다.
				join.setVisible(true);
			}
		});
//
//		jb2.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//		});
	}

	public static void main(String[] args) {
		new Ex03_Main();
	}
}
