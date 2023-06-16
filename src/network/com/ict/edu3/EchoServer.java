package network.com.ict.edu3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//day35 230614
public class EchoServer implements Runnable {
	ServerSocket ss = null;
	Socket s = null;

	InputStream in = null;
	BufferedInputStream bis = null;

	OutputStream out = null;
	BufferedOutputStream bos = null;

	public EchoServer() {
		try {
			ss = new ServerSocket(7778);
			System.out.println("서버 대기중 ...");

			new Thread(this).start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				s = ss.accept();
//				String ip = s.getInetAddress().getHostAddress();

				in = s.getInputStream();
				bis = new BufferedInputStream(in);
				byte[] b = new byte[1024];
				bis.read(b);

				String msg = new String(b).trim();

				out = s.getOutputStream();
				bos = new BufferedOutputStream(out);
				bos.write(msg.getBytes());
				bos.flush();

			} catch (Exception e) {
			} finally {
				closeExceptSS();
			}
		}
	}

	public static void main(String[] args) {
		new EchoServer();
	}

	private void closeAll() {
		try {
			if (bos != null) {
				bos.close();
				bos = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
			if (bis != null) {
				bis.close();
				bis = null;
			}
			if (in != null) {
				in.close();
				in = null;
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
			if (bos != null) {
				bos.close();
				bos = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
			if (bis != null) {
				bis.close();
				bis = null;
			}
			if (in != null) {
				in.close();
				in = null;
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
