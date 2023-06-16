package network.com.ict.edu5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//day35 230614
public class CopyClient extends Thread {
	Socket s;
	ChatServer server;

	BufferedReader in;
	PrintWriter out;
	String ip;

	public CopyClient(Socket s, ChatServer server) {
		this.s = s;
		this.server = server;

		try {
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(), true);
			ip = s.getInetAddress().getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			if (in != null) {
				try {
					String msg = in.readLine();
					if (msg != null && msg.length() > 0) {
						if (msg.equals("exit")) {
							// 원격에 있는 실제 클라이언트에게 종료 메세지 보냄
							out.println("~~bye");
							break;
						}
						server.sendMsg(ip + " : " + msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		closeAll();
	}

	private void closeAll() {
		try {
			if (out != null) {
				out.close();
				out = null;
			}
			if (in != null) {
				in.close();
				in = null;
			}
			if (s != null) {
				s.close();
				s = null;
			}

			// server에 있는 list에 현재 객체 삭제
			server.sendMsg(ip + " 님 퇴장");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
