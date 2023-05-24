package day21.com.ict.HW;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class HW0524_LHJ_Calc extends JPanel {
	JPanel np, sp;
	JTextField jtf1;
	JTextField jtf2;

	JRadioButton jrb1;
	JRadioButton jrb2;
	JRadioButton jrb3;
	JRadioButton jrb4;

	ButtonGroup bg;

	JTextArea jta;

	JButton jb1;
	JButton jb2;
	JButton jb3;

	CalcActionListener calcActionListener;

	public HW0524_LHJ_Calc() {
		super(new BorderLayout());

		calcActionListener = new CalcActionListener();

		np = new JPanel();

		jtf1 = new JTextField(5);
		jtf2 = new JTextField(5);

		jrb1 = new JRadioButton("+");
		jrb2 = new JRadioButton("-");
		jrb3 = new JRadioButton("×");
		jrb4 = new JRadioButton("÷");

		bg = new ButtonGroup();

		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);

		np.add(new JLabel("수1 : "));
		np.add(jtf1);
		np.add(new JLabel("수2 : "));
		np.add(jtf2);
		np.add(new JLabel("연산자 : "));

		np.add(jrb1);
		np.add(jrb2);
		np.add(jrb3);
		np.add(jrb4);

		jta = new JTextArea(20, 50);
		jta.setLineWrap(true); // 자동줄바꿈

		// JTextArea 옆에 스크롤바 생성
		JScrollPane jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// JTextArea 내용을 편집 불가능하게 만들자
		jta.setEditable(false);

		sp = new JPanel();

		jb1 = new JButton("계산");
		jb2 = new JButton("종료");
		jb3 = new JButton("초기화");

		sp.add(jb1);
		sp.add(jb2);
		sp.add(jb3);

		add(np, BorderLayout.NORTH);

		add(jsp, BorderLayout.CENTER);

		add(sp, BorderLayout.SOUTH);

		jtf1.addActionListener(calcActionListener);
		jtf2.addActionListener(calcActionListener);

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
				jtf1.setText("");
				jtf2.setText("");
				bg.clearSelection();
				jta.setText("");
			}
		});
	}

	public class CalcActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String prnStr = "";
			double su1 = 0.0;
			double su2 = 0.0;

			int i = 0;
			try {
				su1 = Double.parseDouble(jtf1.getText());
				i++;
				su2 = Double.parseDouble(jtf2.getText());
				i++;
			} catch (Exception e1) {
				prnStr = "숫자를 입력하세요.";
				switch (i) {
				case 0:
					jtf1.setText("");
					jtf1.requestFocus();
					break;
				case 1:
					jtf2.setText("");
					jtf2.requestFocus();
					break;
				}
			}

			if (prnStr.length() < 1) {
				if (jrb1.isSelected()) {
					prnStr = su1 + " + " + su2 + " = " + (su1 + su2);
				} else if (jrb2.isSelected()) {
					prnStr = su1 + " - " + su2 + " = " + (su1 - su2);
				} else if (jrb3.isSelected()) {
					prnStr = su1 + " × " + su2 + " = " + (su1 * su2);
				} else if (jrb4.isSelected()) {
					if (su2 != 0) {
						prnStr = su1 + " ÷ " + su2 + " = " + (su1 / su2);
					} else {
						prnStr = "0으로 나눌 수 없습니다.";
					}
				} else {
					prnStr = "연산자를 선택하세요.";
					jrb1.requestFocus();
				}
			}

			prnStr += "\n";
			jta.append(prnStr);
		}
	}
}
