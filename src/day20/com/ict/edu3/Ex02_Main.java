package day20.com.ict.edu3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

//대한민국, 캐나다, 영국, 스위스의 수도가 각각 HashMap에 저장시키고
//원하는 나라가 key 값이 되어, 화면에서 나라를 물어보면 수도가
//출력되는 프로그램 작성
public class Ex02_Main extends JFrame {
	HashMap<String, String> map;
	Set<String> keys;

	JPanel jp;
	JTextField jtf;
	JButton jb1, jb2;
	JTextArea jta;
	JScrollPane jsp;

	public Ex02_Main() {
		super("수도 알아내기");

		map = new HashMap<>();
		map.put("대한민국", "서울");
		map.put("캐나다", "오타와");
		map.put("영국", "런던");
		map.put("스위스", "베른");

		keys = map.keySet();

		jp = new JPanel();

		jtf = new JTextField(15);
		jb1 = new JButton("확인");
		jb2 = new JButton("취소");

		jp.add(new JLabel("나라 입력 : "));
		jp.add(jtf);
		jp.add(jb1);
		jp.add(jb2);

		jta = new JTextArea(20, 50);

		jta.setLineWrap(true);
		jta.setEditable(false);

		jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		jtf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataPrn();
			}
		});
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataPrn();
			}
		});
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("");
				jta.setText("");

				// 커서 지정
				jtf.requestFocus();
			}
		});
	}

	// 중복된 코드가 있으므로 메서드로 만들자
	public void dataPrn() {
		if (jtf.getText().length() == 0) {
			jta.append("데이터를 입력하세요.\n");
			jta.requestFocus();
		} else {
			String str = jtf.getText().trim(); // trim 앞뒤 공백 제거
			if (keys.contains(str)) {
				String city = map.get(str);
				jta.append(str + "의 수도는 " + city + "입니다.\n");
			} else {
				jta.append("데이터에 없는 나라입니다.\n");
			}
		}

		jtf.setText("");
		jtf.requestFocus();
	}

	public static void main(String[] args) {
		new Ex02_Main();
	}
}
