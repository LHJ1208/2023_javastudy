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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//day35 230614
public class ChatClient_WB extends JFrame {

	private JPanel contentPane;
	private JTextField tf_inputChat;

	private CardLayout cl_cardLayout;

	String nickName = null;
	private JTextField tf_nickname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient_WB frame = new ChatClient_WB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// JLabel img = new Jabel("");
	// img.setHorizontalAlignment(SwingConstants.CENTER);
	// img.setIcon(newImageIcon(CharClient.class.getResource("/images/talk.png")));
	// card1.add(img, BorderLayout.CENTER);

	/**
	 * Create the frame.
	 */
	public ChatClient_WB() {
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
				if (tf_nickname.getText().length() > 0) {
					nickName = tf_nickname.getText();
					cl_cardLayout.last(p_cardLayout);
				} else {
					JOptionPane.showMessageDialog(getParent(), "닉네임을 입력하시오.");
				}
			}
		});
		p_join.add(b_join);

		JPanel p_second = new JPanel();
		p_cardLayout.add("last", p_second);
		p_second.setLayout(new BorderLayout(0, 0));

		JScrollPane sp_chatArea = new JScrollPane();
		p_second.add(sp_chatArea, BorderLayout.CENTER);

		JTextArea ta_chatArea = new JTextArea();
		sp_chatArea.setViewportView(ta_chatArea);

		JPanel p_inputChat = new JPanel();
		p_second.add(p_inputChat, BorderLayout.SOUTH);
		p_inputChat.setLayout(new BorderLayout(0, 0));

		tf_inputChat = new JTextField();
		p_inputChat.add(tf_inputChat);

		JButton b_inputChat = new JButton("보내기");
		b_inputChat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tf_nickname.getText().length() > 0) {
					nickName = tf_nickname.getText();
					cl_cardLayout.last(p_cardLayout);
				}
			}
		});
		p_inputChat.add(b_inputChat, BorderLayout.EAST);
	}

}
