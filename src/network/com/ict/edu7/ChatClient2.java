package network.com.ict.edu7;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatClient2 extends JFrame implements Runnable {
	private static final String strIP = "8";

	private CardLayout cardLayout;

	private JPanel contentPane, p_cardLayout;
	private ChatClient2_card1 p_card1;
	private ChatClient2_card2 p_card2;
	private ChatClient2_card3 p_card3;

	private JButton login_bt, memo_bt, join_bt, mkRoom_bt, exit_bt, send_bt, out_bt;
	private JList user_list, room_list, join_list;

	private JTextArea jta;
	private JTextField msg_tf, nickname_tf;

	private Socket s = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChatClient2 frame = new ChatClient2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ChatClient2() {
		super("멀티 채팅");

		setSize(new Dimension(450, 550));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		cardLayout = new CardLayout();
		p_cardLayout = new JPanel();
		p_cardLayout.setBorder(new EmptyBorder(10, 10, 10, 10));
		p_cardLayout.setLayout(cardLayout);
		contentPane.add(p_cardLayout, BorderLayout.CENTER);

		p_card1 = new ChatClient2_card1();
		p_cardLayout.add("card1", p_card1);

		login_bt = p_card1.getBtn_signIn();
		nickname_tf = p_card1.getTf_nickname();

		p_card2 = new ChatClient2_card2();
		p_cardLayout.add("card2", p_card2);

		memo_bt = p_card2.getBtn_send();
		join_bt = p_card2.getBtn_join();
		mkRoom_bt = p_card2.getBtn_mkRoom();
		exit_bt = p_card2.getBtn_exit();
		user_list = p_card2.getList_user();
		room_list = p_card2.getList_room();

		p_card3 = new ChatClient2_card3();
		p_cardLayout.add("card3", p_card3);

		out_bt = p_card3.getBtn_out();
		join_list = p_card3.getList_join();
		send_bt = p_card3.getBtn_chat();
		msg_tf = p_card3.getTf_chat();

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

						cardLayout.show(p_cardLayout, "card3");
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

						cardLayout.show(p_cardLayout, "card3");
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

					cardLayout.show(p_cardLayout, "card2");
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
					cardLayout.show(p_cardLayout, "card2");
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
				new ChatClient2();
			}
		});
	}
}
