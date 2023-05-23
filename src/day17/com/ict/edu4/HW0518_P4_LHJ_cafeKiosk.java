package day17.com.ict.edu4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class HW0518_P4_LHJ_cafeKiosk extends JFrame {
	public HW0518_P4_LHJ_cafeKiosk() {
		super("카페 주문");

		JPanel np = new JPanel(new GridLayout(3, 1));

		JPanel np1 = new JPanel();

		np1.add(new JLabel("원하는 음료 선택하세요"));

		JPanel np2 = new JPanel();

		JRadioButton jrb1 = new JRadioButton("아메리카노(3000)");
		JRadioButton jrb2 = new JRadioButton("카페모카(4000)");
		JRadioButton jrb3 = new JRadioButton("카페라떼(3500)");
		JRadioButton jrb4 = new JRadioButton("과일쥬스(3000)");

		ButtonGroup bg = new ButtonGroup();

		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);

		np2.add(jrb1);
		np2.add(jrb2);
		np2.add(jrb3);
		np2.add(jrb4);

		JPanel np3 = new JPanel();

		JTextField jtf1 = new JTextField(10);
		JTextField jtf2 = new JTextField(10);

		np3.add(new JLabel("수량 : "));
		np3.add(jtf1);
		np3.add(new JLabel("입금액 : "));
		np3.add(jtf2);

		np.add(np1);
		np.add(np2);
		np.add(np3);

		JTextArea jta = new JTextArea();
		jta.setLineWrap(true); // 자동줄바꿈

		// JTextArea 옆에 스크롤바 생성
		JScrollPane jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// JTextArea 내용을 편집 불가능하게 만들자
		jta.setEditable(false);

		JPanel sp = new JPanel();

		JButton jb1 = new JButton("계 산");
		JButton jb2 = new JButton("종 료");
		JButton jb3 = new JButton("취 소");

		sp.add(jb1);
		sp.add(jb2);
		sp.add(jb3);

		add(np, BorderLayout.NORTH);

		add(jsp, BorderLayout.CENTER);

		add(sp, BorderLayout.SOUTH);

		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(ds.width / 2 - 250, ds.height / 2 - 250, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// setResizable(false);
	}

	public static void main(String[] args) {
		new HW0518_P4_LHJ_cafeKiosk();
	}
}
