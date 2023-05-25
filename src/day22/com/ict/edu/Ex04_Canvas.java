package day22.com.ict.edu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ex04_Canvas extends Canvas {
	private Image image;

	@Override
	public void paint(Graphics g) {
		setBackground(Color.LIGHT_GRAY);

		g.drawImage(image, getWidth() / 2 - 200, getHeight() / 2 - 200, 400, 400, this);
	}

	public void setImage(String src) {
		image = Toolkit.getDefaultToolkit().getImage(src);
		repaint();
	}
}
