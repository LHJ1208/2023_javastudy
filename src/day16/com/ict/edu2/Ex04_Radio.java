package day16.com.ict.edu2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex04_Radio extends JFrame {
	public Ex04_Radio() {
		super("라디오 버튼");

		JPanel jp = new JPanel();

		JRadioButton jrb1 = new JRadioButton();
		jrb1.setText("야구");
		jrb1.setSelected(true);

		JRadioButton jrb2 = new JRadioButton("축구", true); // setText //setSelected
		JRadioButton jrb3 = new JRadioButton("농구"); // setText
		JRadioButton jrb4 = new JRadioButton("배구"); // setText

		// 라디오 버튼은 체크박스와 다르게 여러개 중 하나만 선택되어야 한다.
		// 그러기 위해서 반드시 라디오 버튼을 ButtonGroup에 넣어라

		ButtonGroup bg = new ButtonGroup();
		// 하나만 선택하기 위한 기능적 컨테이너
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);

		// 보이기 위한 시각적 컨테이너
		jp.add(jrb1);
		jp.add(jrb2);
		jp.add(jrb3);
		jp.add(jrb4);

		add(jp);

		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(ds.width / 2 - 250, ds.height / 2 - 300, 500, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
	}

	public static void main(String[] args) {
		new Ex04_Radio();
	}
}
