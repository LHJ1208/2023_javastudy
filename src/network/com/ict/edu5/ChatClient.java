package network.com.ict.edu5;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

//day35 230614
public class ChatClient extends JFrame implements Runnable {
	JPanel jp;
	JTextArea jta;
	JScrollPane jsp;
	JTextField jtf;
	JButton jb;

	Socket s = null;

	BufferedReader in;
	PrintWriter out;

	public ChatClient() {
		super("멀티채팅 ver 0.1");
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
//		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		connected();

		// 종료
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 서버에 exit 메세지 보내기
			}
		});

		jtf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
	}

	// 서버에 접속
	private void connected() {
		try {
			s = new Socket("192.168.0.41", 7778);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(), true);
			new Thread(this).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendMessage() {
//		if (out != null) {
			String msg = jtf.getText().trim();
			out.println(msg);
			jtf.setText("");
			jtf.requestFocus();
//		}
	}

	private void closed() {
		try {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			if (s != null) {
				s.close();
			}
			System.out.println("프로그램 종료");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
				try {
					String msg = in.readLine();
					if (msg.equals("~~bye")) {
						break;
					} else {
						jta.append(msg + '\n');
						// 문자열 출력 후 화면을 가장 하단을 이동하자.
						jta.setCaretPosition(jta.getText().length());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		closed();
	}

	public static void main(String[] args) {
		// AWT에서 관리하는 특별한 스레드 처리방식
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ChatClient cc = new ChatClient();
				cc.setVisible(true);
			}
		});
	}
}
