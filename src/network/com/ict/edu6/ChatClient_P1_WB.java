package network.com.ict.edu6;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatClient_P1_WB extends JPanel {
	private ChatClient_MF_WB parent;

	private JLabel centerImg;
	private JTextField tf_nickname;

	/**
	 * Create the panel.
	 */
	public ChatClient_P1_WB() {
	}

	public ChatClient_P1_WB(ChatClient_MF_WB parent) {
		this.parent = parent;

		setLayout(new BorderLayout(0, 0));

		centerImg = new JLabel("");
		centerImg.setHorizontalAlignment(SwingConstants.CENTER);
		centerImg.setIcon(new ImageIcon(ChatClient_P1_WB.class.getResource("/images/talk.png")));
		add(centerImg, BorderLayout.CENTER);

		JPanel p_south = new JPanel();
		add(p_south, BorderLayout.SOUTH);
		GridBagLayout gbl_p_south = new GridBagLayout();
		gbl_p_south.columnWidths = new int[] { 0, 0 };
		gbl_p_south.rowHeights = new int[] { 0, 0, 2 };
		gbl_p_south.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_p_south.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		p_south.setLayout(gbl_p_south);

		JPanel p_nickname = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p_nickname.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_p_nickname = new GridBagConstraints();
		gbc_p_nickname.fill = GridBagConstraints.BOTH;
		gbc_p_nickname.gridx = 0;
		gbc_p_nickname.gridy = 0;
		p_south.add(p_nickname, gbc_p_nickname);

		JLabel lb_nickname = new JLabel("닉네임");
		p_nickname.add(lb_nickname);

		tf_nickname = new JTextField();
		p_nickname.add(tf_nickname);
		tf_nickname.setColumns(10);

		JPanel p_join = new JPanel();
		FlowLayout fl_p_join = (FlowLayout) p_join.getLayout();
		fl_p_join.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_p_join = new GridBagConstraints();
		gbc_p_join.fill = GridBagConstraints.BOTH;
		gbc_p_join.gridx = 0;
		gbc_p_join.gridy = 1;
		p_south.add(p_join, gbc_p_join);

		JButton btn_join = new JButton("입장하기");
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p_join.add(btn_join);
	}

	public JTextField getTf_nickname() {
		return tf_nickname;
	}
}
