package network.com.ict.edu2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) {
		Socket s = null;
		OutputStream out = null;
		InputStream in = null;

		try {
			s = new Socket("192.168.0.64", 7777);
			System.out.println("클라이언트 연결 성공");

			// 입출력 스트림
			out = s.getOutputStream();
			in = s.getInputStream();

			// 메세지 전송
			String msg = "안녕하세요!  Hello!";
			out.write(msg.getBytes());
			out.flush();

			// 서버에서 전송된 데이터 수신
			byte[] buff = new byte[100];
			in.read(buff);
			String recive_msg = new String(buff).trim();
			System.out.println("에코메세지 : " + recive_msg);
		} catch (Exception e) {
		} finally {
			try {
				if (s != null) {
					s.close();
					s = null;
				}
				if (in != null) {
					in.close();
					in = null;
				}
				if (out != null) {
					out.close();
					out = null;
				}
			} catch (Exception e2) {
			}
		}
	}
}
