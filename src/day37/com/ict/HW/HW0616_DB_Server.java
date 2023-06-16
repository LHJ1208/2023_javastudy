package day37.com.ict.HW;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class HW0616_DB_Server implements Runnable {
	private static final int port = 7777;

	ServerSocket ss;
	Socket s = null;

	ObjectInputStream in;
	ObjectOutputStream out;

	public HW0616_DB_Server() {
		try {
			ss = new ServerSocket(port);
			System.out.println("서버 대기중 ...");
			new Thread(this).start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			closedAll();
		}
	}

	@Override
	public void run() {
		while (true) {
			if (s == null) {
				try {
					s = ss.accept();
					in = new ObjectInputStream(s.getInputStream());
					out = new ObjectOutputStream(s.getOutputStream());

					esc: while (true) {
						try {
							Object obj = in.readObject();
							if (obj != null) {
								HW0616_DB_Protocol p = (HW0616_DB_Protocol) obj;

								switch (p.getCmd()) {
								case 0: // 종료
									out.writeObject(p);
									out.flush();
									break esc;
								case 100: { // 전체보기
									List<HW0616_DB_VO_LHJ> list = HW0616_DB_DAO_LHJ.getSelectAll();
									p.setDataList(list);
									break;
								}
								case 200: // 삽입
									if (!HW0616_DB_DAO_LHJ.isExist(p.getDataOne().getCustid())) {
										p.setResult(HW0616_DB_DAO_LHJ.getInsert(p.getDataOne()));
										p.setDataOne(HW0616_DB_DAO_LHJ.getSelectOne(p.getDataOne().getCustid()));
									} else {
										p.setResult(-1);
									}
									break;
								case 300: // 삭제
									if (HW0616_DB_DAO_LHJ.isExist(p.getDataOne().getCustid())) {
										p.setResult(HW0616_DB_DAO_LHJ.getDelete(p.getDataOne()));
									} else {
										p.setResult(-1);
									}
									break;
								case 400: // 검색
									p.setDataOne(HW0616_DB_DAO_LHJ.getSelectOne(p.getDataOne().getCustid()));
									break;
								case 500: // 불러오기
									p.setDataOne(HW0616_DB_DAO_LHJ.getSelectOne(p.getDataOne().getCustid()));
									break;
								case 600: // 고치기
									if (HW0616_DB_DAO_LHJ.isExist(p.getDataOne().getCustid())) {
										p.setResult(HW0616_DB_DAO_LHJ.getUpdate(p.getDataOne()));
									} else {
										p.setResult(-1);
									}
									break;
								}
								out.writeObject(p);
								out.flush();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} // esc label

				} catch (Exception e) {
					e.printStackTrace();
				}

				closed();
			}
		}
	}

	private void closed() {
		try {
			if (out != null) {
				out.close();
				out = null;
			}
			if (in != null) {
				in.close();
				in = null;
			}
			if (s != null) {
				s.close();
				s = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closedAll() {
		try {
			if (out != null) {
				out.close();
				out = null;
			}
			if (in != null) {
				in.close();
				in = null;
			}
			if (s != null) {
				s.close();
				s = null;
			}
			if (ss != null) {
				ss.close();
				ss = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new HW0616_DB_Server();
	}
}
