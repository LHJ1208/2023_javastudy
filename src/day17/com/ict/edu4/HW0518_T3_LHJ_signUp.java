package day17.com.ict.edu4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class HW0518_T3_LHJ_signUp extends JFrame {
	public HW0518_T3_LHJ_signUp() {
		super("회원가입");

		JPanel np = new JPanel(new GridLayout(6, 1));

		JPanel np1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JTextField jtf1 = new JTextField(10);
		JRadioButton jrb1 = new JRadioButton("남");
		JRadioButton jrb2 = new JRadioButton("여");

		ButtonGroup bg = new ButtonGroup();

		bg.add(jrb1);
		bg.add(jrb2);

		np1.add(new JLabel("이 름 : "));
		np1.add(jtf1);
		np1.add(new JLabel("성 별 : "));
		np1.add(jrb1);
		np1.add(jrb2);

		JPanel np2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf2 = new JTextField(10);

		np2.add(new JLabel("생년월일 : "));
		np2.add(jtf2);

		JPanel np3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf3 = new JTextField(15);

		np3.add(new JLabel("주     소 : "));
		np3.add(jtf3);

		JPanel np4 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		String[] items = { "부서", "개발부", "영업부" };

		JComboBox<String> jcom = new JComboBox<>(items);

		np4.add(new JLabel("부 서 명 : "));
		np4.add(jcom);

		JPanel np5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JCheckBox jcb1 = new JCheckBox("운동");
		JCheckBox jcb2 = new JCheckBox("영화");
		JCheckBox jcb3 = new JCheckBox("독서");
		JCheckBox jcb4 = new JCheckBox("컴퓨터");

		np5.add(new JLabel(" 취  미 : "));
		np5.add(jcb1);
		np5.add(jcb2);
		np5.add(jcb3);
		np5.add(jcb4);

		JPanel np6 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		np6.add(new JLabel(" 자 기 소 개"));

		np.add(np1);
		np.add(np2);
		np.add(np3);
		np.add(np4);
		np.add(np5);
		np.add(np6);

		JTextArea jta = new JTextArea();
		jta.setLineWrap(true); // 자동줄바꿈

		// JTextArea 옆에 스크롤바 생성
		JScrollPane jsp = new JScrollPane(jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// JTextArea 내용을 편집 불가능하게 만들자
		jta.setEditable(false);

		JPanel sp = new JPanel();

		JButton jb1 = new JButton("저 장");
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
		new HW0518_T3_LHJ_signUp();
	}
}
