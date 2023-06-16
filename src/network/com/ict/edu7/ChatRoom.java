package network.com.ict.edu7;

import java.util.ArrayList;

public class ChatRoom {
// 방 참여자들이 저장되어 있는 곳 - 방 나가기 또는 접속 해제 시 여기서 삭제되어야 한다.
//	마지막 사람이 나가면 방은 삭제하자.

	private ArrayList<CopyClient> j_list;
	private String title; // 방 제목

	public ChatRoom(String title) {
		this.title = title;
		j_list = new ArrayList<>();
	}

	// 방 제목을 반환하는 기능(ChatServer 에서 호출)
	public String getTitle() {
		return title;
	}

	// 현재 방에 참여자들의 수를 반환 - 방 나갈 때 마지막 사람일 경우 방을 삭제
	public int getJoinCount() {
		return j_list.size();
	}

	// 방 참여
	public void join(CopyClient cc) {
		j_list.add(cc);

		// 방 참여자에게 메세지 전달 (대기실에 있는 사람에게는 전달 안 됨)
		Protocol p = new Protocol();
		p.setCmd(4);
		p.setMsg(" ☆★○● " + cc.getNickName() + " 님 입장 ●○★☆ ");
		p.setNames(getJoinUsers());
		sendMsg(p);
	}

	// 방 참여 명단 반환 (방 나가기 하면 명단 갱신 필요)
	public String[] getJoinUsers() {
		String[] arr = new String[j_list.size()];
		int i = 0;
		for (CopyClient k : j_list) {
			arr[i++] = k.getNickName();
		}

		return arr;
	}

	// 채팅 기능
	public void sendMsg(Protocol p) {
		for (CopyClient k : j_list) {
			try {
				k.getOut().writeObject(p);
				k.getOut().flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 방 나가기
	public void getOut(CopyClient target) {
		j_list.remove(target);

		Protocol p = new Protocol();
		p.setCmd(1);
		p.setMsg(" ☆★○● " + target.getNickName() + " 님 퇴장 ●○★☆ ");
		sendMsg(p);
	}
}
