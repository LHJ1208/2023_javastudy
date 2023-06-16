package network.com.ict.edu7;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ChatClient2_card2 extends JPanel {
	private JButton btn_send;
	private JButton btn_join;
	private JButton btn_mkRoom;
	private JButton btn_exit;
	private JList list_user;
	private JList list_room;

	/**
	 * Create the panel.
	 */
	public ChatClient2_card2() {
		setLayout(new BorderLayout(0, 0));

		JPanel p_center = new JPanel();
		add(p_center, BorderLayout.CENTER);
		p_center.setLayout(new BorderLayout(0, 0));

		list_room = new JList();
		list_room.setFont(new Font("굴림", Font.BOLD, 20));
		JScrollPane jspRoom = new JScrollPane();
		jspRoom.setViewportView(list_room);
		p_center.add(jspRoom);

		JLabel lb_room = new JLabel(" 방 제목");
		p_center.add(lb_room, BorderLayout.NORTH);

		JPanel p_east = new JPanel();
		add(p_east, BorderLayout.EAST);
		p_east.setLayout(new BorderLayout(0, 0));

		list_user = new JList();
//		list_user.setFont(new Font("굴림", Font.BOLD, 20));
		JScrollPane jspUser = new JScrollPane();
		jspUser.setViewportView(list_user);
		p_east.add(jspUser, BorderLayout.CENTER);

		JPanel p_east_south = new JPanel();
		p_east.add(p_east_south, BorderLayout.SOUTH);
		p_east_south.setLayout(new GridLayout(4, 1, 0, 0));

		btn_send = new JButton("쪽지보내기");
		p_east_south.add(btn_send);

		btn_join = new JButton("방 참여");
		p_east_south.add(btn_join);

		btn_mkRoom = new JButton("방 만들기");
		p_east_south.add(btn_mkRoom);

		btn_exit = new JButton("종료");
		p_east_south.add(btn_exit);

		JLabel lb_wait = new JLabel(" [대기실]");
		p_east.add(lb_wait, BorderLayout.NORTH);

	}

	public JButton getBtn_send() {
		return btn_send;
	}

	public JButton getBtn_join() {
		return btn_join;
	}

	public JButton getBtn_mkRoom() {
		return btn_mkRoom;
	}

	public JButton getBtn_exit() {
		return btn_exit;
	}

	public JList getList_user() {
		return list_user;
	}

	public JList getList_room() {
		return list_room;
	}
}
