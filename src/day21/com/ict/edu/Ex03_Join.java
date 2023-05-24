package day21.com.ict.edu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex03_Join extends JFrame {
	JFrame parent;
	JPanel jp;
	JButton jb;

	public Ex03_Join(JFrame parent) {
		super("회원가입");

		this.parent = parent;

		jp = new JPanel();
		jb = new JButton("뒤로가기");

		jp.add(new JLabel("회원가입 창입니다."));
		jp.add(jb);

		add(jp);

		// pack();
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(false);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parent.setVisible(true);
			}
		});
	}
}
