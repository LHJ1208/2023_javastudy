package network.com.ict.edu6;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ChatClient_P2_WB extends JPanel {
	private JTextField tf_message;
	private JTextArea ta_chat;

	/**
	 * Create the panel.
	 */
	public ChatClient_P2_WB() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane sp_chat = new JScrollPane();
		sp_chat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(sp_chat, BorderLayout.CENTER);

		ta_chat = new JTextArea();
		sp_chat.setViewportView(ta_chat);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JButton btn_send = new JButton("보내기");
		panel.add(btn_send, BorderLayout.EAST);

		tf_message = new JTextField();
		panel.add(tf_message, BorderLayout.CENTER);
		tf_message.setColumns(10);

	}

}
