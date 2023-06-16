package network.com.ict.edu7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChatClient2_card1 extends JPanel {
	private JTextField tf_nickname;
	private JButton btn_signIn;

	/**
	 * Create the panel.
	 */
	public ChatClient2_card1() {
		setLayout(new BorderLayout(0, 0));

		JPanel p_center = new JPanel();
		add(p_center, BorderLayout.CENTER);
		p_center.setLayout(new BorderLayout(0, 0));

		JLabel img = new JLabel("");
		img.setHorizontalAlignment(SwingConstants.CENTER);
		img.setIcon(new ImageIcon(ChatClient.class.getResource("/images/chat.png")));
		p_center.add(img, BorderLayout.CENTER);

		JPanel p_south = new JPanel();
		add(p_south, BorderLayout.SOUTH);
		p_south.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel p_south_1 = new JPanel();
		FlowLayout fl_p_south_1 = (FlowLayout) p_south_1.getLayout();
		fl_p_south_1.setAlignment(FlowLayout.RIGHT);
		p_south.add(p_south_1);

		JLabel la_nickname = new JLabel("닉네임");
		p_south_1.add(la_nickname);

		tf_nickname = new JTextField();
		p_south_1.add(tf_nickname);
		tf_nickname.setColumns(10);

		JPanel p_south_2 = new JPanel();
		FlowLayout fl_p_south_2 = (FlowLayout) p_south_2.getLayout();
		fl_p_south_2.setAlignment(FlowLayout.RIGHT);
		p_south.add(p_south_2);

		btn_signIn = new JButton("입장하기");
		p_south_2.add(btn_signIn);

	}

	public JTextField getTf_nickname() {
		return tf_nickname;
	}

	public JButton getBtn_signIn() {
		return btn_signIn;
	}
}
