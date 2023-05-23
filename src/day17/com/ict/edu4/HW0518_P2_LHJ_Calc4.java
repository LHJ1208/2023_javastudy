package day17.com.ict.edu4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;

public class HW0518_P2_LHJ_Calc4 extends JFrame {
	public HW0518_P2_LHJ_Calc4() {
		super("계산기");

		JPanel np = new JPanel();

		JTextField jtf = new JTextField(25);

		np.add(jtf);

		JPanel cp = new JPanel(new GridLayout(5, 3));
		//JPanel cp = new JPanel(new GridLayout(5, 3, 10, 10));

		JPanel[] jpArr = new JPanel[15];
		for (int i = 0; i < jpArr.length; i++) {
			jpArr[i] = new JPanel(new GridLayout());
		}

		JButton[] jbArr = new JButton[jpArr.length];
		for (int i = 0; i < jbArr.length; i++) {
			jbArr[i] = new JButton();
		}
		for (int i = 0; i < 9; i++) {
			jbArr[i].setText(Integer.toString(i + 1));
		}

		jbArr[9].setText("0");
		jbArr[10].setText("+");
		jbArr[11].setText("-");
		jbArr[12].setText("×");
		jbArr[13].setText("÷");
		jbArr[14].setText("=");

		for (int i = 0; i < jbArr.length; i++) {
			jpArr[i].add(jbArr[i]);
			jpArr[i].setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		}

		for (int i = 0; i < jpArr.length; i++) {
			cp.add(jpArr[i]);
		}

		cp.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

		add(np, BorderLayout.NORTH);

		add(cp, BorderLayout.CENTER);

		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(ds.width / 2 - 150, ds.height / 2 - 150, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// setResizable(false);
	}

	public static void main(String[] args) {
		new HW0518_P2_LHJ_Calc4();
	}
}
