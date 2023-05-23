package day19.com.ict.edu;

public class Ex03_Cat implements Runnable {
	@Override
	public void run() {
		int i = 0;
		while (true) {
			System.out.println(++i + ". 애~~옹~~" + Thread.currentThread().getName());
		}
	}
}
