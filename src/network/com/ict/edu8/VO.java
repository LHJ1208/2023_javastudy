package network.com.ict.edu8;

import java.awt.Color;
import java.io.Serializable;

public class VO implements Serializable {
	// 0 : 종료
	// 1 : 채팅
	// 2 : 그림 그리기

	private int cmd;
	private String msg;

	private int x, y, wh;
	private Color color;

	public int getCmd() {
		return cmd;
	}

	public String getMsg() {
		return msg;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWh() {
		return wh;
	}

	public Color getColor() {
		return color;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWh(int wh) {
		this.wh = wh;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
