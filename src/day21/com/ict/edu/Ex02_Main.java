package day21.com.ict.edu;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex02_Main extends JFrame {
	JPanel pg1;
	CardLayout cardLayout;

	public Ex02_Main() {
		super("카드레이아웃2");

		cardLayout = new CardLayout();
		pg1 = new JPanel(cardLayout);

		Ex02_LogIn login = new Ex02_LogIn(cardLayout, pg1);
		Ex02_Join join = new Ex02_Join(this);
		Ex02_LogIn_OK loginOK = new Ex02_LogIn_OK(this);

		pg1.add("login", login);
		pg1.add("join", join);
		pg1.add("loginOK", loginOK);

		add(pg1);

		// pack();
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
	}

	public static void main(String[] args) {
		new Ex02_Main();
	}
}
