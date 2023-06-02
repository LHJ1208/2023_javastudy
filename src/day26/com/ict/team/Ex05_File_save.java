package day26.com.ict.team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Ex05_File_save extends JFrame {
	JPanel jp;
	JButton jb;
	JTextArea jta;
	JTextField jtf;
	JScrollPane jsp;
	JLabel jlb;
	public Ex05_File_save() {
		super("저장하기");
		jp = new JPanel();
		jlb = new JLabel("파일경로 : ");
		jb = new JButton("save");
		jtf = new JTextField(30);
		jp.add(jlb);
		jp.add(jtf);
		jp.add(jb);
		
		jta = new JTextArea(40,60);
		jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
				);
		
		add(jp,BorderLayout.NORTH);
		add(jsp,BorderLayout.CENTER);
		
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(ds.width/2-300, ds.height/2-300, 600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ex05_team.team(jtf.getText(), jta.getText());
			}
		});
		 jtf.addKeyListener(new KeyListener() {
	            @Override
	            public void keyTyped(KeyEvent e) {
	                // Not needed for this implementation
	            }

	            @Override
	            public void keyPressed(KeyEvent e) {
	                // Not needed for this implementation
	            }

	            @Override
	            public void keyReleased(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    Ex05_team.team(jtf.getText(), jta.getText());
	                }
	            }
	        });
	}
	
	
	
	public static void main(String[] args) {
		new Ex05_File_save();
	}
}
