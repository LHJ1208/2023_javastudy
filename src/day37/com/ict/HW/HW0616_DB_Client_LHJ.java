package day37.com.ict.HW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HW0616_DB_Client_LHJ extends JFrame implements Runnable {
	private static final int port = 7777;
	private static final String strIP = "8";

	JPanel p_North, p_NorthLeft, p_NorthRight, p_South;

	JLabel l_custid, l_name, l_address, l_phone;
	JTextField tf_custid, tf_name, tf_address, tf_phone;

	JTextArea jta;
	JScrollPane jsp;

	JButton b_showAll, b_insert, b_delete, b_search, b_load, b_update;

	// 접속
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;

	public HW0616_DB_Client_LHJ() {
		super("DB 연동 정보");

		p_North = new JPanel(new GridLayout(1, 2));
		p_NorthLeft = new JPanel(new GridLayout(4, 1));
		p_NorthRight = new JPanel(new GridLayout(4, 1));

		p_North.add(p_NorthLeft);
		p_North.add(p_NorthRight);

		l_custid = new JLabel("CUSTID :");
		l_name = new JLabel("NAME :");
		l_address = new JLabel("ADDRESS :");
		l_phone = new JLabel("PHONE :");

		l_custid.setHorizontalAlignment(JLabel.CENTER);
		l_name.setHorizontalAlignment(JLabel.CENTER);
		l_address.setHorizontalAlignment(JLabel.CENTER);
		l_phone.setHorizontalAlignment(JLabel.CENTER);

		p_NorthLeft.add(l_custid);
		p_NorthLeft.add(l_name);
		p_NorthLeft.add(l_address);
		p_NorthLeft.add(l_phone);

		tf_custid = new JTextField();
		tf_name = new JTextField();
		tf_address = new JTextField();
		tf_phone = new JTextField();

		p_NorthRight.add(tf_custid);
		p_NorthRight.add(tf_name);
		p_NorthRight.add(tf_address);
		p_NorthRight.add(tf_phone);

		jta = new JTextArea();
		jta.setLineWrap(true);
		jta.setEditable(false);

		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		p_South = new JPanel();

		b_showAll = new JButton("전체보기");
		b_insert = new JButton("삽입");
		b_delete = new JButton("삭제");
		b_search = new JButton("검색");
		b_load = new JButton("불러오기");
		b_update = new JButton("고치기");

		b_update.setEnabled(false);

		p_South.add(b_showAll);
		p_South.add(b_insert);
		p_South.add(b_delete);
		p_South.add(b_search);
		p_South.add(b_load);
		p_South.add(b_update);

		add(p_North, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(p_South, BorderLayout.SOUTH);

		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		connected();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (s != null) {
					try {
						HW0616_DB_Protocol p = new HW0616_DB_Protocol();
						p.setCmd(0);
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

		b_showAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writeObject(new HW0616_DB_Protocol(100));
			}
		});
		b_insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (custidCheck()) {
					writeObject(new HW0616_DB_Protocol(200, makeVO()));
				}
			}
		});

		b_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (custidCheck()) {
					writeObject(new HW0616_DB_Protocol(300, tf_custid.getText()));
				}
			}
		});

		b_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (custidCheck()) {
					writeObject(new HW0616_DB_Protocol(400, tf_custid.getText()));
				}
			}
		});

		b_load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText("");
				if (custidCheck()) {
					writeObject(new HW0616_DB_Protocol(500, tf_custid.getText()));
				}
			}
		});

		b_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (custidCheck()) {
					writeObject(new HW0616_DB_Protocol(600, makeVO()));
				}
			}
		});

		tf_custid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String custid = tf_custid.getText();
				if (custid != null && custid.length() > 0) {
					try {
						Integer.parseInt(custid);
						b_update.setEnabled(true);
					} catch (Exception exception) {
						b_update.setEnabled(false);
					}
				} else {
					b_update.setEnabled(false);
				}
			}
		});
	}

	public boolean writeObject(HW0616_DB_Protocol p) {
		if (p != null && out != null) {
			try {
				out.writeObject(p);
				out.flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean custidCheck() {
		String custid = tf_custid.getText();

		if (checkCustIDLength(custid)) {
			if (checkCustIDInt(custid)) {
				return true;
			}
		}
		return false;
	}

	public void setInit() {
		b_update.setEnabled(false);
		tf_custid.setText("");
		tf_name.setText("");
		tf_address.setText("");
		tf_phone.setText("");
		jta.setText("");
	}

	public HW0616_DB_VO_LHJ makeVO() {
		HW0616_DB_VO_LHJ result = new HW0616_DB_VO_LHJ(tf_custid.getText());
		result.setName(tf_name.getText());
		result.setAddress(tf_address.getText());
		result.setPhone(tf_phone.getText());
		return result;
	}

	public void prnJta(HW0616_DB_VO_LHJ target) {
		jta.append("\t" + target.getCustid() + "\t");
		jta.append(target.getName() + "\t");
		jta.append(target.getAddress() + "\t\t");
		jta.append(target.getPhone() + "\n");
	}

	public void prnJta(HW0616_DB_VO_LHJ target, boolean columnPrint) {
		if (columnPrint) {
			jta.append("\tcustid\tname\taddress\t\tphone\n");
		}
		prnJta(target);
	}

	public void reactionShowAll(HW0616_DB_Protocol p) {
		List<HW0616_DB_VO_LHJ> list = p.getDataList();

		jta.setText("");
		jta.append("\n\t\t\tShow ALL\n\n");
		jta.append("\tcustid\tname\taddress\t\tphone\n");
		if (list != null) {
			for (HW0616_DB_VO_LHJ k : list) {
				prnJta(k);
			}
		}
	}

	public void reactionInsert(HW0616_DB_Protocol p) {
		int result = p.getResult();

		if (result > 0) {
			HW0616_DB_VO_LHJ vo = p.getDataOne();
			setInit();
			prnJta(vo, true);
			JOptionPane.showMessageDialog(getParent(), "custid : " + vo.getCustid() + " 삽입 성공", "SQL 실행 성공",
					JOptionPane.PLAIN_MESSAGE);
		} else if (result == -1) {
			JOptionPane.showMessageDialog(getParent(), "해당 custid가 이미 존재합니다.", "SQL 실행 실패",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void reactionDelete(HW0616_DB_Protocol p) {
		int result = p.getResult();

		if (result > 0) {
			setInit();
			JOptionPane.showMessageDialog(getParent(), "custid : " + p.getDataOne().getCustid() + " 삭제 성공", "SQL 실행 성공",
					JOptionPane.PLAIN_MESSAGE);
		} else if (result == -1) {
			JOptionPane.showMessageDialog(getParent(), "해당 custid가 존재하지 않습니다.", "SQL 실행 실패",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void reactionSearch(HW0616_DB_Protocol p) {
		HW0616_DB_VO_LHJ vo = p.getDataOne();

		setInit();
		jta.append("\tcustid\tname\taddress\t\tphone\n");
		if (vo != null) {
			prnJta(vo);
			JOptionPane.showMessageDialog(getParent(), "custid : " + vo.getCustid() + " 검색 성공", "SQL 실행 성공",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(getParent(), "해당 custid를 찾을 수 없음", "SQL 실행 성공", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void reactionLoad(HW0616_DB_Protocol p) {
		HW0616_DB_VO_LHJ vo = p.getDataOne();

		if (vo != null) {
			tf_name.setText(vo.getName());
			tf_address.setText(vo.getAddress());
			tf_phone.setText(vo.getPhone());
			JOptionPane.showMessageDialog(getParent(), "custid : " + vo.getCustid() + " 불러오기 성공", "SQL 실행 성공",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(getParent(), "해당 custid를 찾을 수 없음", "SQL 실행 성공", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void reactionUpdate(HW0616_DB_Protocol p) {
		int result = p.getResult();

		if (result > 0) {
			HW0616_DB_VO_LHJ vo = p.getDataOne();
			setInit();
			prnJta(vo, true);
			JOptionPane.showMessageDialog(getParent(), "custid : " + vo.getCustid() + " 수정 성공", "SQL 실행 성공",
					JOptionPane.PLAIN_MESSAGE);
		} else if (result == -1) {
			JOptionPane.showMessageDialog(getParent(), "해당 custid를 찾을 수 없음.", "SQL 실행 실패", JOptionPane.WARNING_MESSAGE);
		}
	}

	public boolean checkCustIDLength(String custid) {
		if (custid != null) {
			if (custid.length() > 0) {
				return true;
			}
		}
		JOptionPane.showMessageDialog(getParent(), "custid를 입력하시오.", "SQL 실행 실패", JOptionPane.WARNING_MESSAGE);

		return false;
	}

	public boolean checkCustIDInt(String custid) {
		boolean result = true;
		try {
			Integer.parseInt(custid);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			JOptionPane.showMessageDialog(getParent(), "custid에 숫자를 입력하시오.", "SQL 실행 실패", JOptionPane.WARNING_MESSAGE);
		}
		return result;
	}

	@Override
	public void run() {
		esc: while (true) {
			try {
				Object obj = in.readObject();
				if (obj != null) {
					HW0616_DB_Protocol p = (HW0616_DB_Protocol) obj;

					switch (p.getCmd()) {
					case 0: // 종료
						break esc;
					case 100: // 전체보기
						reactionShowAll(p);
						break;
					case 200: // 삽입
						reactionInsert(p);
						break;
					case 300: // 삭제
						reactionDelete(p);
						break;
					case 400: // 검색
						reactionSearch(p);
						break;
					case 500: // 불러오기
						reactionLoad(p);
						break;
					case 600: // 고치기
						reactionUpdate(p);
						break;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		closed();
	}

	public void connected() {
		try {
			s = new Socket("192.168.0." + strIP, port);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			new Thread(this).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closed() {
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new HW0616_DB_Client_LHJ();
			}
		});
	}
}
