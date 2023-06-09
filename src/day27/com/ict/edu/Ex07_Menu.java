package day27.com.ict.edu;

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

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

//메뉴 : 메뉴바, 메뉴, 메뉴아이템
//메뉴바에 메뉴를 붙인다. 메뉴에 메뉴아이템을 붙인다.
//메뉴아이템 -> 메뉴 -> 메뉴바 -> 프레임
//메뉴바는 프레임에 붙인다. (setJMenuBar)

//*** 개인적으로 수정하던 코드 ***//

public class Ex07_Menu extends JFrame {
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

	public Ex07_Menu() {
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

		i_newFile = new JMenuItem("새파일");
		i_openFile = new JMenuItem("열 기");
		i_saveFile = new JMenuItem("저장하기");
		i_saveFileOhterName = new JMenuItem("다른 이름으로 저장하기");
		i_exitFile = new JMenuItem("종 료");
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
				// 메모장 안에 글자 존재 여부 확인
				int size = jta.getText().length();
				if (size > 0) {
					// 현재 파일이 제목이 있을 경우 예외 처리 필요
					int res = JOptionPane.showOptionDialog(getParent(), "변경 내용을 제목 없음에 저장하시겠습니까?", "간단 메모장",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
					if (res == 0) {
						// 실제 저장하는 코드
					} else if (res == 1) {
						jta.setText("");
						// font 등 세팅 초기화
						// 현재 파일이 제목이 있을 경우 예외 처리 필요
					}

//					else if(res == 2) {
//						//취소 누를 시 아무것도 안 함
//					}
				} else {
					// font 등 세팅 초기화
				}

			}
		});

		i_openFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일 열기 다이얼로그
				FileDialog fd = new FileDialog((JFrame) getParent(), "불러오기", FileDialog.LOAD);
				fd.setVisible(true);

				String tmpPath = fd.getDirectory() + fd.getFile();
				String input = null;
				if ((input = loadTextFile(tmpPath)) != null) {
					pathFile = tmpPath;
					nameFile = fd.getFile();
					originContents = input;
					setTitle(nameFile + subTitle);
					jta.setText(input);
				}
			}
		});

		i_saveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일 저장 다이얼로그
				if (pathFile == null) {
					FileDialog fd = new FileDialog((JFrame) getParent(), "저장하기", FileDialog.SAVE);
					fd.setVisible(true);

					String tmpPath = fd.getDirectory() + fd.getFile();
					String curContents = jta.getText();
					if (saveTextFile(tmpPath, curContents)) {
						pathFile = tmpPath;
						nameFile = fd.getFile();
						originContents = curContents;
						setTitle(nameFile + subTitle);
					}
				} else {
					saveTextFile(pathFile, jta.getText());
				}
			}
		});

		i_saveFileOhterName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일 저장 다이얼로그
				FileDialog fd = new FileDialog((JFrame) getParent(), "저장하기", FileDialog.SAVE);
				fd.setVisible(true);
				String tmpPath = fd.getDirectory() + fd.getFile();
				String curContents = jta.getText();
				if (saveTextFile(tmpPath, curContents)) {
					pathFile = tmpPath;
					nameFile = fd.getFile();
					originContents = curContents;
					setTitle(nameFile + subTitle);
				}
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
			public void keyPressed(KeyEvent e) {
				if (!originContents.equals(jta.getText())) {
					setTitle("*" + nameFile + subTitle);
					difference = true;
				} else {
					setTitle(nameFile + subTitle);
					difference = false;
				}
			}
		});
	}

	static public String loadTextFile(String path) {
		String result = null;

		String pathTrim = path.trim();

		if (pathTrim.length() > 0) {
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
			} finally {
				try {
					br.close();
					fr.close();
				} catch (Exception e2) {
				}
			}
		}

		return result;
	}

	static public boolean saveTextFile(String path, String contents) {
		boolean result = true;

		String pathTrim = path.trim();

		if (pathTrim.length() > 0) {
			File file = new File(pathTrim);
			FileWriter fw = null;
			BufferedWriter bw = null;

			try {
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				bw.write(contents);
			} catch (Exception e) {
			} finally {
				try {
					bw.close();
					fw.close();
				} catch (Exception e2) {
				}
			}

		} else {
			result = false;
		}

		return result;
	}

	public static void main(String[] args) {
//		setDefaultLookAndFeelDecorated(true);

		new Ex07_Menu();
	}
}
