package network.com.ict.edu7;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ChatClient extends JFrame implements Runnable {
	private static final String strIP = "8";

	private CardLayout cardLayout;

	private JPanel pg, login_p, wait_p, chat_p;
	private JLabel img;

	private JButton login_bt, memo_bt, join_bt, mkRoom_bt, exit_bt, send_bt, out_bt;
	private JList user_list, room_list, join_list;

	private JTextArea jta;
	private JTextField msg_tf, nickname_tf;

	// 접속
	private Socket s = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;

	public ChatClient() {
		super("멀티 채팅");

		cardLayout = new CardLayout();
		pg = new JPanel();
		pg.setBorder(new EmptyBorder(10, 10, 10, 10));
		pg.setLayout(cardLayout);

		// 첫번째 카드
		login_p = new JPanel(new BorderLayout());

		img = new JLabel();
		img.setHorizontalAlignment(SwingConstants.CENTER);
		img.setIcon(new ImageIcon(ChatClient.class.getResource("/images/chat.png")));

		JPanel jp1 = new JPanel(new GridLayout(2, 1));

		JPanel jp1_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp1_1.add(new JLabel("닉네임"));
		nickname_tf = new JTextField(10);
		jp1_1.add(nickname_tf);

		JPanel jp1_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		login_bt = new JButton("입장하기");
		jp1_2.add(login_bt);

		jp1.add(jp1_1);
		jp1.add(jp1_2);

		login_p.add(img, "Center");
		login_p.add(jp1, "South");

		// 두번째 카드
		wait_p = new JPanel(new BorderLayout());

		// 가운데 패널
		JPanel center_p = new JPanel(new BorderLayout());

		room_list = new JList();
		JScrollPane jspRoom = new JScrollPane();
		room_list.setFont(new Font("굴림", Font.BOLD, 20));
		jspRoom.setViewportView(room_list);

		center_p.add(new JLabel("방 제목"), "North");
		center_p.add(room_list, "Center");

		// 동쪽 패널
		JPanel east_p = new JPanel(new BorderLayout());
		// 크기 지정
		east_p.setPreferredSize(new Dimension(120, 300));

		user_list = new JList();
		JScrollPane jspUser = new JScrollPane();
		jspUser.setViewportView(user_list);

		JPanel east_south = new JPanel();
		east_south.setLayout(new GridLayout(4, 1, 0, 0));
		memo_bt = new JButton("쪽지보내기");
		join_bt = new JButton("방 참여");
		mkRoom_bt = new JButton("방 만들기");
		exit_bt = new JButton("종료");
		east_south.add(memo_bt);
		east_south.add(join_bt);
		east_south.add(mkRoom_bt);
		east_south.add(exit_bt);

		east_p.add(new JLabel(" [대기실] "), "North");
		east_p.add(jspUser, "Center");
		east_p.add(east_south, "South");

		wait_p.add(center_p, "Center");
		wait_p.add(east_p, "East");

		// 세번째 카드
		chat_p = new JPanel(new BorderLayout());

		JPanel ch_center = new JPanel(new BorderLayout());

		jta = new JTextArea();
		jta.setEditable(false);
		jta.setLineWrap(true);
		JScrollPane jspChat = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JPanel center_south = new JPanel(new BorderLayout());

		msg_tf = new JTextField();
		send_bt = new JButton("보내기");

		center_south.add(msg_tf, "Center");
		center_south.add(send_bt, "East");

		ch_center.add(jspChat, "Center");
		ch_center.add(center_south, "South");

		JPanel ch_east = new JPanel(new BorderLayout());
		ch_east.setPreferredSize(new Dimension(120, 300));

		join_list = new JList();
		JScrollPane jspJoin = new JScrollPane();
		jspJoin.setViewportView(join_list);

		out_bt = new JButton("방 나가기");

		ch_east.add(new JLabel(" [참여자] "), "North");
		ch_east.add(jspJoin, "Center");
		ch_east.add(out_bt, "South");

		chat_p.add(ch_center, "Center");
		chat_p.add(ch_east, "East");

		pg.add("login", login_p);
		pg.add("wait", wait_p);
		pg.add("chat", chat_p);

		// 첫 카드를 지정
		cardLayout.show(pg, "login");

		add(pg);
		setSize(450, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 창 닫기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (s != null) { // 접속된 상태
					Protocol p = new Protocol();
					p.setCmd(0);
					try {
						out.writeObject(p);
						out.flush();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					closed();
				}
			}
		});

		// 입장하기
		login_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actLogin();
			}
		});
		nickname_tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actLogin();
			}
		});

		exit_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Protocol p = new Protocol();
					p.setCmd(0);
					out.writeObject(p);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		memo_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 대기실 리스트에서 특정 사람 선택
				int c_index = user_list.getSelectedIndex();

				if (c_index >= 0) {
					try {
						String msg = JOptionPane.showInputDialog("내용을 입력하세요.");
						if (msg.length() <= 0 || msg == null) {
							JOptionPane.showMessageDialog(getParent(), "내용을 입력하세요.");
						} else {
							Protocol p = new Protocol();
							p.setCmd(6);
							p.setMsg(msg);

							p.setC_index(user_list.getSelectedIndex());
							out.writeObject(p);
							out.flush();
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});

		mkRoom_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// 사용자에게 방 제목을 받자
					String name = JOptionPane.showInputDialog(getParent(), "방 제목을 입력하세요.");
					if (name.length() <= 0 || name == null) {
						JOptionPane.showMessageDialog(getParent(), "방 제목을 입력하세요.");
					} else {
						Protocol p = new Protocol();
						p.setCmd(3);
						p.setMsg(name);

						out.writeObject(p);
						out.flush();

						cardLayout.show(pg, "chat");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		join_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int r_index = room_list.getSelectedIndex();

				if (r_index >= 0) {
					try {
						Protocol p = new Protocol();
						p.setCmd(4);
						p.setR_index(r_index);

						out.writeObject(p);
						out.flush();

						cardLayout.show(pg, "chat");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});

		send_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		msg_tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		out_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					jta.setText("");

					Protocol p = new Protocol();
					p.setCmd(5);

					out.writeObject(p);
					out.flush();

					cardLayout.show(pg, "wait");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}

	private boolean connected() {
		boolean value = true;
		try {
			s = new Socket("192.168.0." + strIP, 7779);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		esc: while (true) {
			try {
				Object obj = in.readObject();
				if (obj != null) {
					Protocol p = (Protocol) obj;
					switch (p.getCmd()) {
					case 0: { // 종료

						break esc;
					}
					case 1: { // 메세지 전달
						jta.append(p.getMsg() + '\n');
						jta.setCaretPosition(jta.getText().length());

						break;
					}
					case 2: { // 접속 및 갱신
						// 대기자 명단
						user_list.setListData(p.getNames());

						// ** 여기 수정 해보자! ** //
						join_list.setListData(p.getNames());

						// 방 목록
						room_list.setListData(p.getRooms());

						break;
					}
//					case 3: { // 방 만들기
//						
//						break;
//					}
					case 4: { // 방 참여
						join_list.setListData(p.getNames());
						jta.append(p.getMsg() + '\n');
						break;
					}
//					case 5: { // 방 나가기
//
//						break;
//					}
					case 6: { // 쪽지 보내기
						JOptionPane.showMessageDialog(getParent(), p.getMsg());
						break;
					}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 무한 루프 끝

		closed();
	}

	private void actLogin() {
		String name = nickname_tf.getText().trim();
		if (name.length() > 0) {
			// 서버 접속
			if (connected()) {
				try {
					// 닉네임 보내기
					Protocol p = new Protocol();
					p.setCmd(2);
					p.setMsg(name);
					out.writeObject(p);
					out.flush();
					cardLayout.show(pg, "wait");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(getParent(), "닉네임을 입력하세요.");
			nickname_tf.setText("");
			nickname_tf.requestFocus();
		}
	}

	private void sendMessage() {
		try {
			String msg = msg_tf.getText().trim();
			if (msg.length() > 0) {
				Protocol p = new Protocol();
				p.setCmd(1);
				p.setMsg(msg);
				out.writeObject(p);
				out.flush();
				msg_tf.setText("");
				msg_tf.requestFocus();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ChatClient();
			}
		});
	}
}
