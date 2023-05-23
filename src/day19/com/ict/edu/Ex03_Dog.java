package day19.com.ict.edu;

public class Ex03_Dog implements Runnable {
	@Override
	public void run() {
		int i = 0;
		while (true) {
			System.out.println(++i + ". 멍~~뭉~~" + Thread.currentThread().getName());
		}
	}
}
