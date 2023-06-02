package day23.com.ict.edu;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex04_Race extends JFrame {
	JPanel jp;
	JButton jb;

	Image[] imageArr;

	CanvasTest canvas;

	public Ex04_Race() {
		super("경주하기");

		canvas = new CanvasTest();

		jp = new JPanel();
		jb = new JButton("Start");
		jp.add(jb);

		add(jp, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);

		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						while (canvas.getX(0) < canvas.getWidth() - 140) {
							canvas.setX(0, canvas.getX(0) + (int) (Math.random() * 10));
							try {
								Thread.sleep(40);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							canvas.repaint();
						}
						System.out.print(Thread.currentThread().getName() + "\n");
					}
				}, "First").start();

				new Thread(new Runnable() {
					@Override
					public void run() {
						while (canvas.getX(1) < canvas.getWidth() - 140) {
							canvas.setX(1, canvas.getX(1) + (int) (Math.random() * 10));
							try {
								Thread.sleep(40);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							canvas.repaint();
						}
						System.out.print(Thread.currentThread().getName() + "\n");
					}
				}, "Second").start();

				new Thread(new Runnable() {
					@Override
					public void run() {
						while (canvas.getX(2) < canvas.getWidth() - 140) {
							canvas.setX(2, canvas.getX(2) + (int) (Math.random() * 10));
							try {
								Thread.sleep(40);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							canvas.repaint();
						}
						System.out.print(Thread.currentThread().getName() + "\n");
					}
				}, "Third").start();

				new Thread(new Runnable() {
					@Override
					public void run() {
						while (canvas.getX(3) < canvas.getWidth() - 140) {
							canvas.setX(3, canvas.getX(3) + (int) (Math.random() * 10));
							try {
								Thread.sleep(40);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							canvas.repaint();
						}
						System.out.print(Thread.currentThread().getName() + "\n");
					}
				}, "Forth").start();
			}
		});
	}

	private class CanvasTest extends Canvas {
		private int[] xArr = { 0, 0, 0, 0 };
		private int[] yArr = { 50, 210, 360, 520 };
		private int size = 100;

		public CanvasTest() {
			imageArr = new Image[4];

			imageArr[0] = Toolkit.getDefaultToolkit().getImage("src/images/java1.png");
			imageArr[1] = Toolkit.getDefaultToolkit().getImage("src/images/java2.png");
			imageArr[2] = Toolkit.getDefaultToolkit().getImage("src/images/java3.png");
			imageArr[3] = Toolkit.getDefaultToolkit().getImage("src/images/java4.gif");
		}

		@Override
		public void paint(Graphics g) {
			for (int i = 0; i < xArr.length; i++) {
				g.drawImage(imageArr[i], xArr[i], yArr[i], size, size, this);
			}
		}

		public int getX(int index) {
			return xArr[index];
		}

		public void setX(int index, int x) {
			xArr[index] = x;
		}
	}

	public static void main(String[] args) {
		new Ex04_Race();
	}
}
