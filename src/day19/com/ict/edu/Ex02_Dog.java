package day19.com.ict.edu;

public class Ex02_Dog extends Thread {
//	@Override
//	public void start() {
//		for (int i = 0; i < 20; i++) {
//			System.out.println(i + ": 멍~뭉~" + Thread.currentThread().getName());
//		}
//	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": 멍~뭉~" + Thread.currentThread().getName());
		}
	}
}
