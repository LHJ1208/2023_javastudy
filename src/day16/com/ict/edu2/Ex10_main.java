package day16.com.ict.edu2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Ex10_main extends JFrame {
	public Ex10_main() {
		super("JTab_2");

		// JPanel을 상속한 클래스 객체 생성
		Ex10_Blue blue = new Ex10_Blue();
		Ex10_Cyan cyan = new Ex10_Cyan();
		Ex10_Green green = new Ex10_Green();

		// JPanel 들을 JTab에 넣기
		JTabbedPane jtab = new JTabbedPane();
		jtab.add("파랑2", blue);
		jtab.add("청록2", cyan);
		jtab.add("초록2", green);

		// Jtab을 JFrame에 넣자
		add(jtab);

		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(ds.width / 2 - 250, ds.height / 2 - 250, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
	}

	public static void main(String[] args) {
		new Ex10_main();
	}
}
