package network.com.ict.edu7;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient2_card3 extends JPanel {
	private JButton btn_out;
	private JList list_join;
	private JButton btn_chat;
	private JTextField tf_chat;

	/**
	 * Create the panel.
	 */
	public ChatClient2_card3() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		tf_chat = new JTextField();
		panel_2.add(tf_chat, BorderLayout.CENTER);
		tf_chat.setColumns(10);

		btn_chat = new JButton("보내기");
		panel_2.add(btn_chat, BorderLayout.EAST);

		JTextArea ta_chat = new JTextArea();
		ta_chat.setEditable(false);
		ta_chat.setLineWrap(true);
		JScrollPane jspChat = new JScrollPane(ta_chat, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(jspChat, BorderLayout.CENTER);

		JPanel p_east = new JPanel();
		add(p_east, BorderLayout.EAST);
		p_east.setLayout(new BorderLayout(0, 0));

		JLabel lb_join = new JLabel(" [참여자]");
		p_east.add(lb_join, BorderLayout.NORTH);

		list_join = new JList();
//		list_join.setFont(new Font("굴림", Font.BOLD, 20));
		JScrollPane jspJoin = new JScrollPane();
		jspJoin.setViewportView(list_join);
		p_east.add(jspJoin);

		btn_out = new JButton("방 나가기");
		p_east.add(btn_out, BorderLayout.SOUTH);

	}

	public JButton getBtn_out() {
		return btn_out;
	}

	public JList getList_join() {
		return list_join;
	}

	public JButton getBtn_chat() {
		return btn_chat;
	}

	public JTextField getTf_chat() {
		return tf_chat;
	}
}
