package day23.com.ict.edu;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex05_Dialog extends JFrame {
	JButton jb1, jb2, jb3, jb4, jb5, jb6;

	public Ex05_Dialog() {
		super("다이얼로그");
		setLayout(new FlowLayout());

		jb1 = new JButton("메세지");
		jb2 = new JButton("확인");
		jb3 = new JButton("입력");
		jb4 = new JButton("옵션");
		jb5 = new JButton("파일열기");
		jb6 = new JButton("파일저장");

		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);
		add(jb5);
		add(jb6);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메세지 다이얼로그 : 사용자에게 정보를 알리는 역할만 한다.(js(자바스크립트에서는 alert())
				// JOptionPane.showMessageDialog(paenetComponet, message);
				// JOptionPane.showMessageDialog(Ex05_Dialog.this, "방가방가");
				// JOptionPane.showMessageDialog(getParent(), "방가방가");

				// JOptionPane.showMessageDialog(paenetComponet, message, title, messageType);
				// messageType : ERROR_MESSAGE, INFORMATION(기본), WARNING_MESSAGE,
				// QUESTION_MESSAGE, PLAIN_MESSAGE(없음)
				JOptionPane.showMessageDialog(getParent(), "방가방가", "MESSAGE 창", JOptionPane.WARNING_MESSAGE);
			}
		});

		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 확인 다이얼로그 : 정보를 알리고 사용자의 반응의 결과를 가져온다. (확인,예(0), 아니오(1), 취소(2)) (js(자바스크립트에서는
				// confirm())
				// JOptionPane.showConfirmDialog(paenetComponet, message);
				// int res = JOptionPane.showConfirmDialog(getParent(), "정말 삭제할까요?");
				// System.out.println(res);

				// JOptionPane.showConfirmDialog(paenetComponet, message, title, optionType);
				// optionType : YES_NO_CANCEL_OPTION(예, 아니오, 취소), YES_NO_OPTION(예, 아니오),
				// optionType : OK_CANCEL_OPTION(확인, 취소)
				JOptionPane.showConfirmDialog(getParent(), "정말 삭제할까요?", "확인창", JOptionPane.YES_NO_OPTION);
			}
		});

		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력 다이얼로그 : 사용자에게 정보를 받는 다이얼로그 (js(자바스크립트에서는 prompt()) (거의 사용 안 함)
				// String msg = JOptionPane.showInputDialog(parentComponet, message);
				// String msg = JOptionPane.showInputDialog(getParent(), "나이 : ");

				// String msg = JOptionPane.showInputDialog(parentComponet, message, 초기값);
				String msg = JOptionPane.showInputDialog(getParent(), "나이 : ", 17);
				System.out.println(msg);
			}
		});

		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 옵션 다이얼로그 : 사용자 다이얼로그(사용자가 만드는 다이얼로그)
				// JOptionPane.showInputDialog(parentComponet, message, title, optionType,
				// messageType, null, null, null);
				String[] Options = { "A", "B", "C", "가", "나", "다" };

				int res = JOptionPane.showOptionDialog(getParent(), "내가 만든 다이얼로그", "옵션 다이얼로그",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, Options, "가");
				System.out.println(res);
			}
		});

		jb5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일 열기 다이얼로그
				FileDialog fd = new FileDialog((JFrame) getParent(), "파일열기^^", FileDialog.LOAD);
				fd.setVisible(true);
				//위치 경로 얻기
				String msg = fd.getDirectory() + fd.getFile();
				System.out.println(msg);
			}
		});

		jb6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일 저장 다이얼로그
				FileDialog fd = new FileDialog((JFrame) getParent(), "파일저장^^", FileDialog.SAVE);
				fd.setVisible(true);
				//위치 경로 얻기
				String msg = fd.getDirectory() + fd.getFile();
				System.out.println(msg);
			}
		});
	}

	public static void main(String[] args) {
		new Ex05_Dialog();
	}
}
