package day27.com.ict.HW;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

//메뉴 : 메뉴바, 메뉴, 메뉴아이템
//메뉴바에 메뉴를 붙인다. 메뉴에 메뉴아이템을 붙인다.
//메뉴아이템 -> 메뉴 -> 메뉴바 -> 프레임
//메뉴바는 프레임에 붙인다. (setJMenuBar)

public class HW0601_Notepad_LHJ extends JFrame {
	JTextArea jta;
	JScrollPane jsp;
	JMenuBar jmb;
	JMenu m_file, m_form, font_form, m_help;
	JMenuItem i_newFile, i_openFile, i_saveFile, i_saveFileOhterName, i_exitFile, i_item1, i_item2, i_item3, i_help,
			i_info;

	String pathFile = null;
	String nameFile = null;

	String originContents = "";
	boolean difference = false;

	String nameNewFile = "제목 없음";
	String subTitle = " - Simple 메모장";

	Image notepad_ico = null;

	public HW0601_Notepad_LHJ() {
		setTitle(nameNewFile + subTitle);

//		notepad_ico = Toolkit.getDefaultToolkit().getImage("src/images/notepad13.png");
//		setIconImage(notepad_ico);
//		setTitle(nameNewFile + subTitle);

		nameFile = nameNewFile;

		jta = new JTextArea();
		jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);

		// 메뉴바, 메뉴, 메뉴 아이템 순으로 생성
		jmb = new JMenuBar();
		m_file = new JMenu("파 일");
		m_form = new JMenu("서 식");
		font_form = new JMenu("글자 서식");
		m_help = new JMenu("도움말");

		i_newFile = new JMenuItem("새로 만들기");
		i_openFile = new JMenuItem("열 기 ...");
		i_saveFile = new JMenuItem("저장하기");
		i_saveFileOhterName = new JMenuItem("다른 이름으로 저장하기 ...");
		i_exitFile = new JMenuItem("끝 내 기");
		i_item1 = new JMenuItem("돋움, 기울기, 30");
		i_item2 = new JMenuItem("궁서, 굵 게, 40");
		i_item3 = new JMenuItem("굴림, 기 본, 20");
		i_help = new JMenuItem("도 움 말");
		i_info = new JMenuItem("메모장 정보");

		// 아이템을 메뉴에 붙인다.
		m_file.add(i_newFile);
		m_file.add(i_openFile);
		m_file.addSeparator();
		m_file.add(i_saveFile);
		m_file.add(i_saveFileOhterName);
		m_file.addSeparator();
		m_file.add(i_exitFile);

		m_form.add(font_form);
		font_form.add(i_item1);
		font_form.add(i_item2);
		font_form.add(i_item3);

		m_help.add(i_help);
		m_help.add(i_info);

		// 메뉴를 메뉴바에 붙인다.
		jmb.add(m_file);
		jmb.add(m_form);
		jmb.add(m_help);

		// 메뉴바를 프레임에 붙인다.
		setJMenuBar(jmb);
		add(jsp);

		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		// 새파일
		i_newFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (difference) {
					int choice = askSaveContents();
					if (choice == 0 || choice == 1) {
						jta.setText("");

						pathFile = null;
						nameFile = nameNewFile;

						originContents = "";
						difference = false;
						setTitle(nameFile + subTitle);
					}
				} else {
					jta.setText("");

					pathFile = null;
					nameFile = nameNewFile;

					originContents = "";
					difference = false;
					setTitle(nameFile + subTitle);
				}

			}
		});

		i_openFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean openEvenet = true;

				if (difference) {
					int choice = askSaveContents();
					if (choice < 0 || choice > 1) {
						openEvenet = false;
					}
				}

				if (openEvenet) {
					// 파일 열기 다이얼로그
					FileDialog fd = new FileDialog((JFrame) getParent(), "불러오기", FileDialog.LOAD);
					fd.setVisible(true);

					String tmpPath = fd.getDirectory() + fd.getFile();
					String input = null;
					if ((input = loadTextFile(tmpPath)) != null) {
						pathFile = tmpPath;
						nameFile = fd.getFile();
						originContents = input;
						difference = false;
						setTitle(nameFile + subTitle);
						jta.setText(input);
					}
				}
			}
		});

		i_saveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String curContents = jta.getText();

				if (pathFile == null) {
					// 파일 저장 다이얼로그
					useDialogForSave();
				} else {
					if (difference) {
						if (saveTextFile(pathFile, curContents)) {
							originContents = curContents;
							difference = false;
							setTitle(nameFile + subTitle);
						}
					}

				}
			}
		});

		i_saveFileOhterName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일 저장 다이얼로그
				useDialogForSave();
			}
		});

		i_exitFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				// 원래는 글자 존재가 있으면 저장할지 물어보고
				// 내용이 변경되지 않으면 그냥 종료
			}
		});

		i_item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 돋움, 기울기, 30
				// Font font = new Font(글꼴, 스타일, 사이즈)
				jta.setFont(new Font("돋움", Font.ITALIC, 30));
			}
		});

		i_item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 궁서, 굵게, 40
				// Font font = new Font(글꼴, 스타일, 사이즈)
				jta.setFont(new Font("궁서", Font.BOLD, 40));
			}
		});

		i_item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 굴림, 기본, 20
				// Font font = new Font(글꼴, 스타일, 사이즈)
				jta.setFont(new Font("굴림", Font.PLAIN, 20));
			}
		});

		i_help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메세지창 호출
				JOptionPane.showMessageDialog(getParent(), "도움말");
			}
		});

		i_info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메세지창 호출
				JOptionPane.showMessageDialog(getParent(), "간단 메모장 정보");
			}
		});

		jta.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (!originContents.equals(jta.getText())) {
					setTitle("*" + nameFile + subTitle);
					difference = true;
				} else if (pathFile == null) {
					if (jta.getText().length() > 0) {
						setTitle("*" + nameFile + subTitle);
						difference = true;
					} else {
						setTitle(nameFile + subTitle);
						difference = false;
					}
				} else {
					setTitle(nameFile + subTitle);
					difference = false;
				}
			}
		});
	}

	public int askSaveContents() {
		int result = -1;

		if (difference) {
			Color backColor = new Color(238, 238, 238);

			String msgText = "변경 내용을 ";
			if (pathFile == null) {
				msgText += nameFile;
			} else {
				msgText += pathFile;
			}
			msgText += "에 저장하시겠습니까?";

//			JTextPane msg = new JTextPane();
//			msg.setFont(new Font("본고딕", Font.PLAIN, 15));
//			msg.setForeground(Color.BLUE);
//			msg.setBackground(backColor);
//			msg.setText(msgText);

			String msg = msgText;

//			String[] options = { "저장(S)", "저장 안 함(N)", "취소" };
			String[] options = { "저장", "저장 안 함", "취소" };

			result = JOptionPane.showOptionDialog(getParent(), msg, "메모장", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, null);

			switch (result) {
			case 0: {
				String curContents = jta.getText();

				if (pathFile == null) {
					// 파일 저장 다이얼로그
					if (!useDialogForSave()) {
						result = -1;
						break;
					}
				} else {
					if (difference) {
						if (saveTextFile(pathFile, curContents)) {
							originContents = curContents;
							difference = false;
							setTitle(nameFile + subTitle);
						} else {
							result = -1;
						}
					}
				}
			}
			default: {
			}
			}
		}

		return result;
	}

	public boolean useDialogForSave() {
		boolean result = true;

		String curContents = jta.getText();

		FileDialog fd = new FileDialog((JFrame) getParent(), "저장하기", FileDialog.SAVE);
		fd.setVisible(true);

		String tmpPath = fd.getDirectory() + fd.getFile();

		if (saveTextFile(tmpPath, curContents)) {
			pathFile = tmpPath;
			nameFile = fd.getFile();
			originContents = curContents;
			difference = false;
			setTitle(nameFile + subTitle);
		} else {
			result = false;
		}

		return result;
	}

	static public String loadTextFile(String path) {
		String result = null;

		String pathTrim = path.trim();

		if (path == null || path.equals("null") || path.equals("nullnull")) {
		} else if (pathTrim.length() > 0) {
			File file = new File(pathTrim);
			FileReader fr = null;
			BufferedReader br = null;

			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				StringBuffer strBuf = new StringBuffer();

				String input = null;
				while ((input = br.readLine()) != null) {
					strBuf.append(input);
				}
				if (strBuf.length() > 0) {
					result = strBuf.toString();
				}
			} catch (Exception e) {
				result = null;
			} finally {
				try {
					if (br != null)
						br.close();
					if (br != null)
						fr.close();
				} catch (Exception e2) {
					result = null;
				}
			}
		}

		return result;
	}

	static public boolean saveTextFile(String path, String contents) {
		boolean result = true;

		String pathTrim = path.trim();

		if (path == null || contents == null || path.equals("null") || path.equals("nullnull")) {
			result = false;
		} else if (pathTrim.length() > 0) {
			File file = new File(pathTrim);
			FileWriter fw = null;
			BufferedWriter bw = null;

			try {
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				bw.write(contents);
				bw.flush();
			} catch (Exception e) {
				result = false;
			} finally {
				try {
					if (bw != null)
						bw.close();
					if (fw != null)
						fw.close();
				} catch (Exception e2) {
					result = false;
				}
			}

		} else {
			result = false;
		}

		return result;
	}

	public static void main(String[] args) {
//		setDefaultLookAndFeelDecorated(true);

		new HW0601_Notepad_LHJ();
	}
}
