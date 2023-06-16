package network.com.ict.edu7;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChatClient_WB extends JFrame {
	private CardLayout cardLayout;

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public ChatClient_WB() {
		setSize(new Dimension(450, 550));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel p_cardLayout = new JPanel();
		contentPane.add(p_cardLayout, BorderLayout.CENTER);
		cardLayout = new CardLayout();
		p_cardLayout.setLayout(cardLayout);

		JPanel p_card1 = new ChatClient_card1_WB();
		p_cardLayout.add("card1", p_card1);

		JPanel p_card2 = new ChatClient_card2_WB();
		p_cardLayout.add("card2", p_card2);

		JPanel p_card3 = new ChatClient_card3_WB();
		p_cardLayout.add("card3", p_card3);
	}

}
