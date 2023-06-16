package network.com.ict.edu7;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//day36 230615 
public class ChatServer implements Runnable {
	private ServerSocket ss;

	// 접속자(대기자)의 정보를 저장하는 곳
	private ArrayList<CopyClient> c_list;

	// 대화방을 저장하는 곳
	private ArrayList<ChatRoom> r_list;

	public ChatServer() {
		c_list = new ArrayList<>();
		r_list = new ArrayList<>();

		try {
			ss = new ServerSocket(7779);
			System.out.println("서버 대기중 ...");
			new Thread(this).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket s = ss.accept();
				CopyClient cc = new CopyClient(s, this);
				cc.start();
				c_list.add(cc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 대기실에 있는 모든 접속자에게 메세지 전달
	public void sendMsg(Protocol p) {
		for (CopyClient k : c_list) {
			try {
				k.getOut().writeObject(p);
				k.getOut().flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 방 목록에 방 추가
	public void addRoom(ChatRoom room) {
		r_list.add(room);

//		refresh();
	}

	// 방 객체 삭제
	public void romoveRoom(ChatRoom target) {
		r_list.remove(target);

		refresh();
	}

	// index 받아서 r_list로부터 방 객체 하나를 반환
	public ChatRoom getRoom(int index) {
		return r_list.get(index);
	}

	//
	public void addClient(CopyClient target) {
		c_list.add(target);
//		refresh();
	}

	// 현재 대기실에서 삭제
	public void removeClient(CopyClient target) {
		c_list.remove(target);

		// 목록 갱신
//		refresh();
	}

	// 대기실 목록 갱신(방목록, 대기실 명단)
	public void refresh() {
		Protocol p = new Protocol();
		p.setCmd(2);
		p.setNames(getUserName()); // 대기실 명단 갱신
		p.setRooms(getRoomName()); // 방 목록 갱신

		sendMsg(p);
	}

	public String[] getUserName() {
		String[] arr = new String[c_list.size()];

		int i = 0;

		for (CopyClient k : c_list) {
			arr[i++] = k.getNickName();
		}

		return arr;
	}

	public String[] getRoomName() {
		String[] arr = new String[r_list.size()];

		int i = 0;

		for (ChatRoom k : r_list) {
			arr[i++] = k.getTitle();
		}

		return arr;
	}

	public static void main(String[] args) {
		new ChatServer();
	}

	public ArrayList<CopyClient> getC_list() {
		return c_list;
	}
}
