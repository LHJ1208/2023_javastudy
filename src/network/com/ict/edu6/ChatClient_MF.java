package network.com.ict.edu6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class ChatClient_MF extends JFrame {
	
	private CardLayout cardLayout;

	private JPanel contentPane;
	JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient_MF frame = new ChatClient_MF();
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
	public ChatClient_MF() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		cardLayout = new CardLayout();
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(cardLayout);

		JPanel panel_1 = new ChatClient_P1(this);
		panel.add("card1", panel_1);

		JPanel panel_2 = new ChatClient_P2();
		panel.add("card2", panel_2);

		pack();
	}

	void cardNext() {
		cardLayout.next(panel);
	}
}
