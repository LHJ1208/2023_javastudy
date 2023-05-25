package day22.com.ict.edu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//Canvas를 내부 클래스로 만들기
public class Ex02_Canvas extends JFrame {
	TestCanvas testCanvas;

	public Ex02_Canvas() {
		super("Canvas");

		testCanvas = new TestCanvas();

		add(testCanvas);

		// pack();
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
	}

	// 내부클래스 : Canvas도 컨테이너
	private class TestCanvas extends Canvas {
		@Override
		public void paint(Graphics g) {
			// Canvas 배경색 지정
			setBackground(Color.LIGHT_GRAY);

			// Canvas => 도화지, g => 붓

			// 붓의 색깔 지정
			g.setColor(Color.YELLOW);

			// 선 그리기 : drawLine(시작위치, 끝위치)
			g.drawLine(10, 10, 110, 10);
			g.drawLine(10, 10, 10, 110);
			g.drawLine(110, 10, 110, 110);
			g.drawLine(10, 110, 110, 110);

			g.setColor(Color.RED);
			g.drawLine(10, 10, 110, 110);
			g.drawLine(110, 10, 10, 110);

			// 사각형 : drawRect(시작위치, 너비, 높이)
			g.setColor(Color.WHITE);
			g.drawRect(120, 10, 100, 100);
			g.drawRect(130, 20, 80, 80);
			g.drawRect(140, 30, 60, 60);
			g.drawRect(150, 40, 40, 40);
			g.drawRect(160, 50, 20, 20);

			// 채워진 사각형 : fillRect(시작위치, 너비, 높이)
			g.setColor(Color.YELLOW);
			g.fillRect(230, 10, 100, 100);
			g.setColor(Color.RED);
			g.fillRect(240, 20, 80, 80);
			g.setColor(Color.BLUE);
			g.fillRect(250, 30, 60, 60);

			// 둥근 모서리 사각형 : drawRoundRect(시작위치, 너비, 높이, 호 너비, 호 높이)
			// 둥근 모서리 채워진 사각형 : fillRoundRect(시작위치, 너비, 높이, 호 너비, 호 높이)
			g.drawRoundRect(340, 10, 100, 100, 10, 10);
			g.setColor(Color.RED);
			g.fillRoundRect(350, 20, 80, 80, 10, 10);
			g.setColor(Color.WHITE);
			g.drawRoundRect(360, 30, 60, 60, 10, 10);
			g.setColor(Color.BLACK);
			g.fillRoundRect(370, 40, 40, 40, 100, 100);

			// 원 : drawOval(시작위치, 너비, 높이)
			// 채워진 원 : fillOval(시작위치, 너비, 높이)
			// 색 지정 : Color(0~255(R), 0~255(G), 0~255(B))
			g.setColor(new Color(0, 0, 0));
			g.drawOval(10, 120, 100, 100);
			g.setColor(new Color(255, 255, 255));
			g.fillOval(20, 130, 80, 80);

			// 글자 : drawString("글자", 시작위치(글자 및 부분))
			g.drawString("대한민국", 120, 170);

			// 그려지는 글자는 시작위치가 좌측 하단 기준!
			g.setColor(new Color(0, 0, 0));
			g.drawLine(0, 170, 200, 170);
			g.drawLine(120, 0, 120, 300);

			g.setColor(new Color(255, 255, 0));

			// new Font("글꼴", style, size);
			// style, bold, italic, plain(= 기본);
			g.setFont(new Font("궁서", Font.PLAIN, 100));
			g.drawString("Lemon", 220, 170);

			// 이미지
			Image image = Toolkit.getDefaultToolkit().getImage("src/images/java1.png");

			g.drawImage(image, 10, 230, this); // 원래크기

			g.drawImage(image, 120, 230, 100, 100, this); // 크기 조절

			try {
				BufferedImage image2 = ImageIO.read(new File("src/images/java2.png"));
				g.drawImage(image2, 240, 230, 100, 100, this); // 크기 조절
				g.drawImage(image2, 350, 230, 100, 100, new Color(255, 255, 0, 123), this); // 배경 색깔 투명도 설정해서 넣기
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Image image3 = new ImageIcon("src/images/java3.png").getImage();
			g.drawImage(image3, 460, 230, 100, 100, new Color(0, 100, 0, 50), this);

//			printFillRoundRect(g, 10, 230, 10, 10, 100, 100, 100, 100, 8, 4);
//			printFillRoundRect(g, 60, 230, 10, 10, 100, 100, 10, 10, 8, 4);
//			printFillRoundRect(g, 60, 280, 10, 10, 100, 100, 100, 100, 8, 4);
//			printFillRoundRect(g, 10, 280, 10, 10, 100, 100, 10, 10, 8, 4);			
//
//			for (int i = 0; i < 23; i++) {
//				g.drawImage(image, 10 + 40 * i, 400, this); //원래크기
//			}
//			for (int i = 0; i < 23; i++) {
//				g.drawImage(image, 25 + 40 * i, 425, this); //원래크기
//			}
//			for (int i = 0; i < 23; i++) {
//				g.drawImage(image, 40 + 40 * i, 450, this); //원래크기
//			}
		}

		// 응용 연습
		void printFillRoundRect(Graphics g, int startX, int startY, int xGap, int yGap, int width, int height,
				int arcWidth, int arcHeight, int xRepeat, int yRepeat) {
			int color = 0;

			for (int i = 0; i < yRepeat; i++) {
				for (int j = 0; j < xRepeat; j++) {
					for (int j2 = 0; (width - j2 * 2 * xGap > 0) && (height - j2 * 2 * yGap > 0); j2++) {
						int x = startX + j * (height + xGap) + j2 * xGap;
						int y = startY + i * (width + yGap) + j2 * yGap;
						int myWidth = width - j2 * 2 * xGap;
						int myHeight = height - j2 * 2 * yGap;

						if (color == 0) {
							color = 1;
							g.setColor(Color.BLACK);
						} else {
							color = 0;
							g.setColor(Color.WHITE);
						}
						g.fillRoundRect(x, y, myWidth, myHeight, arcWidth, arcHeight);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Ex02_Canvas();
	}
}
