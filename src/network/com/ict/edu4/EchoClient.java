package network.com.ict.edu4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

//day35 230614
public class EchoClient extends JFrame implements Runnable {
	JPanel jp;
	JTextArea jta;
	JScrollPane jsp;
	JTextField jtf;
	JButton jb;

	Socket s = null;

	OutputStreamWriter osw = null;
	BufferedWriter bw = null;

	InputStreamReader isr = null;
	BufferedReader br = null;

	public EchoClient() {
		super("에코 클라이언트");
		jp = new JPanel();
		jta = new JTextArea(20, 1);
		jta.setLineWrap(true);
		jta.setEditable(false);
		jta.setFont(new Font("굴림", Font.PLAIN, 20));
		jta.setBackground(Color.LIGHT_GRAY);
		jta.setForeground(Color.WHITE);
		jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jtf = new JTextField(35);
		jb = new JButton("보내기");

		jp.add(jtf);
		jp.add(jb);
		add(jsp, "Center");
		add(jp, "South");

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		jtf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connet();
				sendMsg();
				closeAll();
			}
		});

		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connet();
				sendMsg();
				closeAll();
			}
		});
	}

	public void connet() {
		try {
			s = new Socket("192.168.0.8", 7778);
			osw = new OutputStreamWriter(s.getOutputStream());
			bw = new BufferedWriter(osw);

			isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);

			new Thread(this).start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	// 보내기
	public void sendMsg() {
		if (bw != null) {
			try {
				String msg = jtf.getText().trim();
				if (msg.length() > 0) {
					msg += System.lineSeparator();
					bw.write(msg);
					bw.flush();
				}
				jtf.setText("");
				jtf.requestFocus();
			} catch (Exception e) {
				e.printStackTrace();
			}
			closeO();
		}
	}

	// 받기

	@Override
	public void run() {
		while (true) {
			if (br != null) {
				try {
					String msg = br.readLine();
					if (msg.length() > 0 && msg != null) {
						jta.append(msg + '\n');
						if (msg.equals("exit")) {
							closed();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			closeI();
		}
	}

	private void closed() {
		try {
//			s.close();
			closeAll();
			System.out.println("프로그램 종료");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EchoClient();
	}

	private void closeI() {
		try {
			if (br != null) {
				br.close();
				br = null;
			}
			if (isr != null) {
				isr.close();
				isr = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeO() {
		try {
			if (bw != null) {
				bw.close();
				bw = null;
			}
			if (osw != null) {
				osw.close();
				osw = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeIO() {
		closeI();
		closeO();
	}

	private void closeAll() {
		closeIO();
		try {
			if (s != null) {
				s.close();
				s = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
