package network.com.ict.edu3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

//day35 230614
public class EchoClient implements Runnable {
	Socket s = null;

	OutputStream out = null;
	BufferedOutputStream bos = null;

	InputStream in = null;
	BufferedInputStream bis = null;

	Scanner scan = new Scanner(System.in);

	public EchoClient() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			try {
//				System.out.print("주소 입력 : "); // 8
//				String num = scan.next();
				System.out.print("데이터 입력 : ");
				String msg = scan.next();

//				s = new Socket("192.168.0." + num, 7778);
				s = new Socket("192.168.0.8", 7778);

				// 출력
				out = s.getOutputStream();
				bos = new BufferedOutputStream(out);
				bos.write(msg.getBytes());
				bos.flush();

				in = s.getInputStream();
				bis = new BufferedInputStream(in);
				byte[] b = new byte[1024];
				bis.read(b);

				String str = new String(b).trim();
				if (str.equals("exit")) {
					break;
				}
				System.out.println("서버에서 받은 내용 : " + str);
			} catch (Exception e) {
			} finally {
				closeAll();
			}
		}
	}

	public static void main(String[] args) {
		new EchoClient();
	}

	private void closeAll() {
		try {
			if (s != null) {
				s.close();
				s = null;
			}
			if (bis != null) {
				bis.close();
				bis = null;
			}
			if (in != null) {
				in.close();
				in = null;
			}
			if (bos != null) {
				bos.close();
				bos = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
