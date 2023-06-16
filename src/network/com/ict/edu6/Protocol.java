package network.com.ict.edu6;

import java.io.Serializable;

//객체 직렬화
public class Protocol implements Serializable {
	// 통신 규약(규칙)
	// cmd => 0 : 접속종료
	// cmd => 1 : 닉네임 받기
	// cmd => 2 : 메세지

	int cmd;
	String msg;

	public int getCmd() {
		return cmd;
	}

	public String getMsg() {
		return msg;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
