package day22.com.ict.edu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Ex05_Canvas extends Canvas {
	private int x = 50, y = 50, diameter = 50;	
	
	@Override
	public void paint(Graphics g) {
		int r1 = (int)(Math.random() * 256);
		int r2 = (int)(Math.random() * 256);
		int r3 = (int)(Math.random() * 256);
		
		g.setColor(new Color(r1, r2, r3));
		g.fillOval(x, y, diameter, diameter);
	}
	
	public void setXY(int x, int y, int diameter) {
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		
		repaint();
	}
}
