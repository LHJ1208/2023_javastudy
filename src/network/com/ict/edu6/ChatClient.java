package network.com.ict.edu6;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

//day35 230614
public class ChatClient extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField tf_inputChat;

	private JTextArea ta_chatArea;

	private CardLayout cl_cardLayout;

	String nickName = null;
	private JTextField tf_nickname;

	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient frame = new ChatClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// JLabel img = new JLabel("");
	// img.setHorizontalAlignment(SwingConstants.CENTER);
	// img.setIcon(new ImageIcon(CharClient.class.getResource("/images/talk.png")));
	// card1.add(img, BorderLayout.CENTER);

	/**
	 * Create the frame.
	 */
	public ChatClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		cl_cardLayout = new CardLayout();

		JPanel p_cardLayout = new JPanel();
		contentPane.add(p_cardLayout, BorderLayout.CENTER);
		p_cardLayout.setLayout(cl_cardLayout);

		JPanel p_first = new JPanel();
		p_cardLayout.add("first", p_first);
		p_first.setLayout(new BorderLayout(0, 0));

		JPanel first_center = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Image backImg = new ImageIcon("src/images/talk.png").getImage();
				g.drawImage(backImg, 0, 0, this);
				setPreferredSize(new Dimension(backImg.getWidth(null), backImg.getHeight(null)));
				pack();
				setLocationRelativeTo(null);
			}
		};
		p_first.add(first_center, BorderLayout.CENTER);

		JPanel p_first_south = new JPanel();
		p_first.add(p_first_south, BorderLayout.SOUTH);
		p_first_south.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel p_nickname = new JPanel();
		p_first_south.add(p_nickname);
		p_nickname.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel l_nickname = new JLabel("닉네임 :");
		p_nickname.add(l_nickname);

		tf_nickname = new JTextField();
		tf_nickname.setColumns(10);
		p_nickname.add(tf_nickname);

		JPanel p_join = new JPanel();
		FlowLayout fl_p_join = (FlowLayout) p_join.getLayout();
		fl_p_join.setAlignment(FlowLayout.RIGHT);
		p_first_south.add(p_join);

		JButton b_join = new JButton("입장하기");
		b_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = tf_nickname.getText().trim();
				if (input.length() > 0) {
					nickName = input;

					// 서버 접속
					if (connnected()) {
						try {
							// 닉네임 보내기
							Protocol p = new Protocol();
							p.setCmd(1);
							p.setMsg(nickName);
							out.writeObject(p);
							cl_cardLayout.last(p_cardLayout);
//					cl_cardLayout.show(contentPane, "last");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "닉네임을 입력하시오.");
				}
			}
		});
		p_join.add(b_join);

		JPanel p_second = new JPanel();
		p_cardLayout.add("last", p_second);
		p_second.setLayout(new BorderLayout(0, 0));

		ta_chatArea = new JTextArea();
		ta_chatArea.setLineWrap(true);
		ta_chatArea.setEditable(false);

		JScrollPane sp_chatArea = new JScrollPane(ta_chatArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		sp_chatArea.setViewportView(ta_chatArea);
		p_second.add(sp_chatArea, BorderLayout.CENTER);

		JPanel p_inputChat = new JPanel();
		p_second.add(p_inputChat, BorderLayout.SOUTH);
		p_inputChat.setLayout(new BorderLayout(0, 0));

		tf_inputChat = new JTextField();
		p_inputChat.add(tf_inputChat);

		JButton b_inputChat = new JButton("보내기");
		b_inputChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p_inputChat.add(b_inputChat, BorderLayout.EAST);

		addWindowListener(new WindowAdapter() {
			// 창 종료 했을 때
			@Override
			public void windowClosing(WindowEvent e) {
				if (s != null) {
					try {
						Protocol p = new Protocol();
						p.setCmd(0);
						out.writeObject(p);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					closed();
				}
			}
		});

		tf_inputChat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		b_inputChat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
	}

	private void sendMessage() {
		String msg = tf_inputChat.getText().trim();
		if (msg.length() > 0) {
			try {
				// 메세지 보내기
				Protocol p = new Protocol();
				p.setCmd(2);
				p.setMsg(msg);
				out.writeObject(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		tf_inputChat.setText("");
		tf_inputChat.requestFocus();
	}

	private boolean connnected() {
		boolean value = true;

		try {
			s = new Socket("192.168.0.8", 7778);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			new Thread(this).start();
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private void closed() {
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
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		esc: while (true) {
			try {
				Object obj = in.readObject();
				if (obj != null) {
					Protocol p = (Protocol) obj;
					switch (p.getCmd()) {
					case 0: // 접속종료
					{
						out.writeObject(p);
						break esc;
					}
					case 2: // 메세지 일반채팅
					{
						ta_chatArea.append(p.getMsg() + '\n');
						ta_chatArea.setCaretPosition(ta_chatArea.getText().length());
						break;
					}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		closed();
	}
}
