package day19.com.ict.edu;

public class Ex02_Cat extends Thread {
//	@Override
//	public void start() {
//		for (int i = 0; i < 20; i++) {
//			System.out.println(i + ": 애~옹~" + Thread.currentThread().getName());
//		}
//	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": 애~옹~" + Thread.currentThread().getName());
		}
	}
}
