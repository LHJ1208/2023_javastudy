package network.com.ict.edu2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Socket s = null;
		OutputStream out = null;
		InputStream in = null;

		while (true) {
			try {
				// 메세지 전송
				System.out.print("보낼 주소 : ");
				String num = scan.next();
				System.out.print("보낼 메시지 : ");
				String msg = scan.next();

				s = new Socket("192.168.0." + num, 7777);
				System.out.println("클라이언트 연결 성공");

				// 입출력 스트림
				out = s.getOutputStream();
				in = s.getInputStream();
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
}
