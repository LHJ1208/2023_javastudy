package day22.com.ict.edu;

import javax.swing.JFrame;

public class Ex05_Main extends JFrame {
	Ex05_Canvas canvas = new Ex05_Canvas();
	
	public Ex05_Main() {
		super("원 찍기");
		
		add(canvas);
		
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new Ex05_Main();
	}
}
