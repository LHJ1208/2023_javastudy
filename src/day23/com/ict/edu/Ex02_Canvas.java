package day23.com.ict.edu;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex02_Canvas extends JFrame {
	// 다른 클래스에서는 내부 클래스를 별도로 생성할 수 없다.
	// 내부 클래스 포함하고 있는 클래스에서는 내부클래스를 생성할 수 있다.
	CanvasTest canvas;

	JPanel jp;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;

	String[] items = { "5", "10", "15", "20", "25", "30" };

	JComboBox<String> jcom;

	public Ex02_Canvas() {
		super("그림판 ver0.01");

		canvas = new CanvasTest();

		jp = new JPanel();

		jb1 = new JButton(" ");
		jb2 = new JButton(" ");
		jb3 = new JButton(" ");
		jb4 = new JButton(" ");
		jb5 = new JButton(" ");
		jb6 = new JButton(" ");
		jb7 = new JButton("Clear");

		jb1.setBackground(Color.RED);
		jb2.setBackground(Color.GREEN);
		jb3.setBackground(Color.BLUE);
		jb4.setBackground(Color.CYAN);
		jb5.setBackground(Color.MAGENTA);
		jb6.setBackground(Color.YELLOW);

		jcom = new JComboBox<>(items);

		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		jp.add(jb5);
		jp.add(jb6);
		jp.add(jcom);
		jp.add(jb7);

		add(jp, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);

		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.RED);
			}
		});
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.GREEN);
			}
		});
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.BLUE);
			}
		});
		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.CYAN);
			}
		});
		jb5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.MAGENTA);
			}
		});
		jb6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.YELLOW);
			}
		});

		jcom.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == e.SELECTED) {
					int width = Integer.parseInt((String) e.getItem());
					canvas.setWidth(width);
				}
			}
		});

		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				canvas.setXY(e.getX(), e.getY());
				canvas.repaint();
			}
		});

		jb7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setXY(-5, -5);
				jcom.setSelectedIndex(0);
				canvas.setWidth(5);
				canvas.removeNotify(); // 삭제
				canvas.addNotify(); // 다시 그릴 수 있게
			}
		});
	}

	// 내부 클래스
	private class CanvasTest extends Canvas {
		private int x = -5, y = -5, width = 5;
		private Color color = Color.BLACK;

		@Override
		public void paint(Graphics g) {
			g.setColor(color);
			g.fillOval(x - width / 2, y - width / 2, width, width);
		}

		@Override
		public void update(Graphics g) {
			paint(g);
		}

		public void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public void setColor(Color color) {
			this.color = color;
		}
	}

	public static void main(String[] args) {
		new Ex02_Canvas();
	}
}
