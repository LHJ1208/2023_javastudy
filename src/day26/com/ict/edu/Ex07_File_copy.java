package day26.com.ict.edu;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex07_File_copy extends JFrame {
	JPanel p_load, p_save;
	JLabel l_load, l_save;
	JTextField tf_load, tf_save;
	JButton b_copy;

	int numColumn = 15;

	public Ex07_File_copy() {
		super("복사하기");
		setLayout(new GridLayout(2, 1));

		p_load = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l_load = new JLabel("원본위치 : ");
		tf_load = new JTextField(numColumn);
		p_load.add(l_load);
		p_load.add(tf_load);

		p_save = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l_save = new JLabel("사본위치 : ");
		tf_save = new JTextField(numColumn);
		b_copy = new JButton("복사하기");
		p_save.add(l_save);
		p_save.add(tf_save);
		p_save.add(b_copy);

		add(p_load);
		add(p_save);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		// 원본파일 : LOAD
		tf_load.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileDialog fd_load = new FileDialog((Frame) getParent(), "불러오기", FileDialog.LOAD);
				fd_load.setVisible(true);
				String filePath = fd_load.getDirectory() + fd_load.getFile();

				if (!(filePath.equals("nullnull"))) {
					tf_load.setText(filePath);
				}
			}
		});

		// 사본파일 : SAVE
		tf_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileDialog fd_save = new FileDialog((Frame) getParent(), "저장하기", FileDialog.SAVE);
				fd_save.setVisible(true);
				String filePath = fd_save.getDirectory() + fd_save.getFile();

				if (!(filePath.equals("nullnull"))) {
					tf_save.setText(filePath);
				}
			}
		});

		b_copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String loadPath = tf_load.getText();
				String savePath = tf_save.getText();

				// 파일은 무조건 바이트 스트림 처리하자
				copyFile(loadPath, savePath);

				tf_load.setText("");
				tf_save.setText("");
			}
		});
	}

	static public void copyFile(String sourcePath, String targetPath) {
		String sourceStr = sourcePath.trim();
		String targetStr = targetPath.trim();

		if (!(sourceStr.isEmpty() || targetStr.isEmpty())) {
			File sourceFile = new File(sourceStr);
			File targetFile = new File(targetStr);

			FileInputStream fis = null;
			BufferedInputStream bis = null;
			FileOutputStream fos = null;
			BufferedOutputStream bos = null;
			try {
				fis = new FileInputStream(sourceFile);
				bis = new BufferedInputStream(fis);
				fos = new FileOutputStream(targetFile);
				bos = new BufferedOutputStream(fos);

//				byte[] contents = new byte[(int) sourceFile.length()];
//				bis.read(contents);
//				bos.write(contents);

				int ch = 0;
				while ((ch = bis.read()) != -1) {
					bos.write(ch);
				}
				bos.flush();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			} finally {
				try {
					bos.close();
					fos.close();
					bis.close();
					fis.close();
				} catch (Exception e2) {
				}
			}
		}
	}

	public static void main(String[] args) {
		new Ex07_File_copy();
	}
}
