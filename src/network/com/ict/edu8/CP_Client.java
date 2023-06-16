package network.com.ict.edu8;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CP_Client extends Thread {
	Socket s;
	CM_Server server;

	ObjectInputStream in;
	ObjectOutputStream out;
	String ip;

	public CP_Client(Socket s, CM_Server server) {
		this.s = s;
		this.server = server;

		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
			ip = s.getInetAddress().getHostAddress();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		esc: while (true) {
			try {
				Object obj = in.readObject();
				if (obj != null) {
					VO vo = (VO) obj;

					switch (vo.getCmd()) {
					case 0: { // 종료
						out.writeObject(vo);
						out.flush();
						break esc;
					}
					case 1: { // 채팅
						vo.setMsg(ip + " : " + vo.getMsg());
						server.sendMsg(vo);
						break;
					}
					case 2: { // 그림 그리기
						server.picture(vo);
						break;
					}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 무한 반복

		// 현재 객체를 삭제
		server.removeClient(this);

		try {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
			if (s != null) {
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ObjectOutputStream getOut() {
		return out;
	}
}
