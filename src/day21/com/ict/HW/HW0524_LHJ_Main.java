package day21.com.ict.HW;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HW0524_LHJ_Main extends JFrame {
	CardLayout cardLayout;
	JPanel pg, jp;

	HW0524_LHJ_Calc calcPanel;
	HW0524_LHJ_Grade gradePanel;
	HW0524_LHJ_Country countryPanel;

	JButton calc, grade, country, exit;

	public HW0524_LHJ_Main() {
		super("계산기");

		cardLayout = new CardLayout();
		pg = new JPanel(cardLayout);

		jp = new JPanel();

		calc = new JButton("계산기");
		grade = new JButton("성적 계산");
		country = new JButton("수도 검색");
		exit = new JButton("종료");

		jp.add(calc);
		jp.add(grade);
		jp.add(country);
		jp.add(exit);

		calcPanel = new HW0524_LHJ_Calc();
		gradePanel = new HW0524_LHJ_Grade();
		countryPanel = new HW0524_LHJ_Country();

		pg.add("calc", calcPanel);
		pg.add("grade", gradePanel);
		pg.add("country", countryPanel);

		add(pg, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);

		pack();
		// setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		calc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("계산기");
				cardLayout.show(pg, "calc");
			}
		});

		grade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("성적 계산");
				cardLayout.show(pg, "grade");
			}
		});

		country.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("수도 검색");
				cardLayout.show(pg, "country");
			}
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public static void main(String[] args) {
		new HW0524_LHJ_Main();
	}
}
