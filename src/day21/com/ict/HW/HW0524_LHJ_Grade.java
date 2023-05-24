package day21.com.ict.HW;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class HW0524_LHJ_Grade extends JPanel {
	JPanel jp1, jp2, jp3;

	JTextField name, kor, eng, math;

	JTextArea jta;

	JButton jb1, jb2, jb3;

	CalcActionListener calcActionListener;

	public HW0524_LHJ_Grade() {
		super(new BorderLayout());

		calcActionListener = new CalcActionListener();

		jp1 = new JPanel();
		name = new JTextField(10);
		jp1.add(new JLabel("이름: "));
		jp1.add(name);

		jp2 = new JPanel();
		kor = new JTextField(10);
		eng = new JTextField(10);
		math = new JTextField(10);

		jp2.add(new JLabel("국어 : "));
		jp2.add(kor);
		jp2.add(new JLabel("영어 : "));
		jp2.add(eng);
		jp2.add(new JLabel("수학 : "));
		jp2.add(math);

		jta = new JTextArea(20, 50);
		jta.setLineWrap(true);
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		jp3 = new JPanel();
		jb1 = new JButton("계산");
		jb2 = new JButton("종료");
		jb3 = new JButton("초기화");

		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);

		JPanel jp4 = new JPanel();
		jp4.setLayout(new BorderLayout());

		jp4.add(jp2, BorderLayout.NORTH);
		jp4.add(jsp, BorderLayout.CENTER);
		jp4.add(jp3, BorderLayout.SOUTH);

		add(jp1, BorderLayout.NORTH);
		add(jp4, BorderLayout.CENTER);

		name.addActionListener(calcActionListener);
		kor.addActionListener(calcActionListener);
		eng.addActionListener(calcActionListener);
		math.addActionListener(calcActionListener);

		jb1.addActionListener(calcActionListener);

		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				kor.setText("");
				eng.setText("");
				math.setText("");
				jta.setText("");
			}
		});
	}

	public class CalcActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String prnStr = "";
			double korNum = 0.0;
			double engNum = 0.0;
			double mathNum = 0.0;
			double sum = 0.0;
			double avg = 0.0;

			int i = 0;
			try {
				korNum = Double.parseDouble(kor.getText());
				i++;
				engNum = Double.parseDouble(eng.getText());
				i++;
				mathNum = Double.parseDouble(math.getText());
				i++;
			} catch (Exception e1) {
				prnStr = "성적(숫자)을 입력하세요.\n\n";
				switch (i) {
				case 0:
					kor.setText("");
					kor.requestFocus();
					break;
				case 1:
					eng.setText("");
					eng.requestFocus();
					break;
				case 2:
					math.setText("");
					math.requestFocus();
					break;
				}
			}

			if (prnStr.length() < 1) {
				sum = korNum + engNum + mathNum;
				avg = sum / 3;
				prnStr += "이름 : " + name.getText();
				prnStr += "\n총점 : " + (int) (sum);
				prnStr += "\n평균 : " + (int) (avg * 10) / 10.0;

				prnStr += "\n학점 : ";
				if (avg >= 90) {
					prnStr += "A";
				} else if (avg >= 80) {
					prnStr += "B";
				} else if (avg >= 70) {
					prnStr += "C";
				} else {
					prnStr += "F";
				}
				prnStr += "학점\n\n";

				name.setText("");
				kor.setText("");
				eng.setText("");
				math.setText("");

				name.requestFocus();
			}

			jta.append(prnStr);
		}
	}
}
