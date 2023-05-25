package day22.com.ict.edu;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex04_Main extends JFrame {
	JPanel jp;
	ButtonGroup bg;
	JRadioButton jrb1, jrb2;

	Ex04_Canvas canvas;

	public Ex04_Main() {
		super("라디오 버튼을 이용한 그림 선택");

		canvas = new Ex04_Canvas();

		jp = new JPanel();

		bg = new ButtonGroup();

		jrb1 = new JRadioButton("그림1");
		jrb2 = new JRadioButton("그림2");

		bg.add(jrb1);
		bg.add(jrb2);

		jp.add(jrb1);
		jp.add(jrb2);

		add(jp, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);

		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		jrb1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == e.SELECTED) {
					canvas.setImage("src/images/java1.png");
				}
			}
		});

		jrb2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == e.SELECTED) {
					canvas.setImage("src/images/java2.png");
				}
			}
		});
	}

	public static void main(String[] args) {
		new Ex04_Main();
	}
}
