package network.com.ict.edu4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//day35 230614
public class EchoServer implements Runnable {
	ServerSocket ss = null;
	Socket s = null;

	InputStreamReader isr = null;
	BufferedReader br = null;

	OutputStreamWriter osw = null;
	BufferedWriter bw = null;

	public EchoServer() {
		try {
			ss = new ServerSocket(7778);
			System.out.println("서버 대기중 ...");

			new Thread(this).start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				s = ss.accept();
//				String ip = s.getInetAddress().getHostAddress();

				isr = new InputStreamReader(s.getInputStream());
				br = new BufferedReader(isr);

				String msg = br.readLine();

				osw = new OutputStreamWriter(s.getOutputStream());
				bw = new BufferedWriter(osw);
				// BufferedWriter 사용시 System.lineSeparator() 사용해야 된다.
				// Java에는 운영체제 별 개행문자에 대응하기 위해 필요한 메서드를 제공하고 있다.
				// 그것은 바로 System.lineSeparator이다.
				msg += System.lineSeparator();
				bw.write(msg);
				bw.flush();

				if (msg.equals("exit")) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeExceptSS();
			}
		}

		closeAll();
	}

	public static void main(String[] args) {
		new EchoServer();
	}

	private void closeAll() {
		try {
			if (bw != null) {
				bw.close();
				bw = null;
			}
			if (osw != null) {
				osw.close();
				osw = null;
			}
			if (br != null) {
				br.close();
				br = null;
			}
			if (isr != null) {
				isr.close();
				isr = null;
			}
			if (s != null) {
				s.close();
				s = null;
			}
			if (ss != null) {
				ss.close();
				ss = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeExceptSS() {
		try {
			if (bw != null) {
				bw.close();
				bw = null;
			}
			if (osw != null) {
				osw.close();
				osw = null;
			}
			if (br != null) {
				br.close();
				br = null;
			}
			if (isr != null) {
				isr.close();
				isr = null;
			}
			if (s != null) {
				s.close();
				s = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
