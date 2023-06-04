package day26.com.ict.team;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Team0531_ReadFrame extends JFrame {
	JPanel p_north;
	
	JLabel l_filepath;
	JTextField tf_filepath;
	JButton b_open;
	
	JTextArea jta;
	JScrollPane jsp;
	
	public Team0531_ReadFrame() {
		super("불러오기");
		
		p_north = new JPanel();
		
		l_filepath = new JLabel("파일 경로 : ");
		tf_filepath = new JTextField(20);
		b_open = new JButton("열기");
		
		p_north.add(l_filepath);
		p_north.add(tf_filepath);
		p_north.add(b_open);
		
		jta = new JTextArea(30, 40);
		jta.setLineWrap(true);
		jta.setEditable(false);
		
		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(p_north, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b_open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String strPath = tf_filepath.getText();
				if(strPath.length() > 0) {
					String tmp = Team0531_ReadTextFile.readTextFile(strPath);
					if(tmp != null) {
						jta.setText(tmp);
					}
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new Team0531_ReadFrame();
	}
}
