package day20.com.ict.edu3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex01_Menu extends JFrame implements ActionListener, ItemListener {
	JPanel jp1, jp2, jp3, jp4, jp5;

	JRadioButton jrb1, jrb2, jrb3, jrb4, jrb5, jrb6, jrb7, jrb8, jrb9, jrb10;
	ButtonGroup bg1, bg2, bg3;

	JButton jb1, jb2;
	JTextField jtf;

	static final int PRICE_COMBO = 15000;
	static final int PRICE_POTATO = 20000;
	static final int PRICE_BULGOGI = 30000;

	static final int PRICE_PARPRIKA = 500;
	static final int PRICE_CHEESE = 1000;
	static final int PRICE_PEPPERONI = 1500;
	static final int PRICE_BACON = 2000;

	static final double MULTIPLY_RATE_SMALL = 0.8;
	static final double MULTIPLY_RATE_MEDIUM = 1.0;
	static final double MULTIPLY_RATE_LARGE = 1.2;

	int[] pricePizza = { PRICE_COMBO, PRICE_POTATO, PRICE_BULGOGI };
	int[] priceTopping = { PRICE_PARPRIKA, PRICE_CHEESE, PRICE_PEPPERONI, PRICE_BACON };
	double[] priceMultiplySize = { MULTIPLY_RATE_SMALL, MULTIPLY_RATE_MEDIUM, MULTIPLY_RATE_LARGE };

	double price = (PRICE_COMBO + PRICE_PARPRIKA) * MULTIPLY_RATE_MEDIUM; // 초기값

	public Ex01_Menu() {
		super("피자 주문판");

		jp1 = new JPanel();
		jp1.add(new JLabel("자바 피자에 오신 것을 환영합니다."));

		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3, 1));
		jp2.setBorder(BorderFactory.createTitledBorder("종류"));

		bg1 = new ButtonGroup();

		jrb1 = new JRadioButton("콤보(15,000)", true);
		jrb2 = new JRadioButton("포테이토(20,000)");
		jrb3 = new JRadioButton("불고기(30,000)");

		bg1.add(jrb1);
		bg1.add(jrb2);
		bg1.add(jrb3);

		jp2.add(jrb1);
		jp2.add(jrb2);
		jp2.add(jrb3);

		jp3 = new JPanel(new GridLayout(4, 1));
		jp3.setBorder(BorderFactory.createTitledBorder("추가 토핑"));

		bg2 = new ButtonGroup();

		jrb4 = new JRadioButton("피망(500)", true);
		jrb5 = new JRadioButton("치즈(1,000)");
		jrb6 = new JRadioButton("페퍼로니(1,500)");
		jrb7 = new JRadioButton("베이컨(2,000)");

		bg2.add(jrb4);
		bg2.add(jrb5);
		bg2.add(jrb6);
		bg2.add(jrb7);

		jp3.add(jrb4);
		jp3.add(jrb5);
		jp3.add(jrb6);
		jp3.add(jrb7);

		jp4 = new JPanel();
		jp4.setLayout(new GridLayout(3, 1));
		jp4.setBorder(BorderFactory.createTitledBorder("사이즈"));

		bg3 = new ButtonGroup();

		jrb8 = new JRadioButton("Small(80%)");
		jrb9 = new JRadioButton("Medium(100%)", true);
		jrb10 = new JRadioButton("Large(120%)");

		bg3.add(jrb8);
		bg3.add(jrb9);
		bg3.add(jrb10);

		jp4.add(jrb8);
		jp4.add(jrb9);
		jp4.add(jrb10);

		jp5 = new JPanel();
		jb1 = new JButton("주문");
		jb2 = new JButton("취소");
		jtf = new JTextField(10);
		jtf.setEditable(false);

		jp5.add(jb1);
		jp5.add(jb2);
		jp5.add(jtf);

		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.WEST);
		add(jp3, BorderLayout.CENTER);
		add(jp4, BorderLayout.EAST);
		add(jp5, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jrb1.addItemListener(this);
		jrb2.addItemListener(this);
		jrb3.addItemListener(this);
		jrb4.addItemListener(this);
		jrb5.addItemListener(this);
		jrb6.addItemListener(this);
		jrb7.addItemListener(this);
		jrb8.addItemListener(this);
		jrb9.addItemListener(this);
		jrb10.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton) e.getSource();

		if (obj == jb1) {

//			price = 0;
//
//			if (jrb1.isSelected())
//				price += PRICE_COMBO;
//			else if (jrb2.isSelected())
//				price += PRICE_POTATO;
//			else if (jrb3.isSelected())
//				price += PRICE_BULGOGI;
//
//			if (jrb4.isSelected())
//				price += PRICE_PARPRIKA;
//			else if (jrb5.isSelected())
//				price += PRICE_CHEESE;
//			else if (jrb6.isSelected())
//				price += PRICE_PEPPERONI;
//			else if (jrb7.isSelected())
//				price += PRICE_BACON;
//
//			if (jrb8.isSelected())
//				price *= MULTIPLY_RATE_SMALL;
//			else if (jrb9.isSelected())
//				price *= MULTIPLY_RATE_MEDIUM;
//			else if (jrb10.isSelected())
//				price *= MULTIPLY_RATE_LARGE;

			jtf.setText((int) price + " 원");
		} else if (obj == jb2) {
			jrb1.setSelected(true);
			jrb4.setSelected(true);
			jrb9.setSelected(true);
			price = (PRICE_COMBO + PRICE_PARPRIKA) * MULTIPLY_RATE_MEDIUM;
			jtf.setText("");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// bg1에 존재하는 요소들을 배열(?)로 만든다.
		Enumeration<AbstractButton> list1 = bg1.getElements();

		int i = 0;
		while (list1.hasMoreElements()) {
			// bg1의 요소를 꺼내서 JRadioButton으로 형변환
			AbstractButton abstractButton = (AbstractButton) list1.nextElement();
			JRadioButton jb = (JRadioButton) abstractButton;
			if (jb.isSelected()) {
				price = pricePizza[i];
				break;
			}
			i++;
		}

		Enumeration<AbstractButton> list2 = bg2.getElements();
		i = 0;
		while (list2.hasMoreElements()) {
			// bg2의 요소를 꺼내서 JRadioButton으로 형변환
			AbstractButton abstractButton = (AbstractButton) list2.nextElement();
			JRadioButton jb = (JRadioButton) abstractButton;
			if (jb.isSelected()) {
				price += priceTopping[i];
				break;
			}
			i++;
		}

		Enumeration<AbstractButton> list3 = bg3.getElements();
		i = 0;
		while (list3.hasMoreElements()) {
			// bg3의 요소를 꺼내서 JRadioButton으로 형변환
			AbstractButton abstractButton = (AbstractButton) list3.nextElement();
			JRadioButton jb = (JRadioButton) abstractButton;
			if (jb.isSelected()) {
				price *= priceMultiplySize[i];
				break;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		new Ex01_Menu();
	}
}
