package day19.com.ict.edu;

public class Ex04_Dog implements Runnable {
	@Override
	public void run() {
		int i = 0;
		while (true) {
			// 3초간 대기 상태
			try {
				Thread.sleep(1000 * 3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(++i + ". 멍~~~뭉~~~");
		}
	}
}
