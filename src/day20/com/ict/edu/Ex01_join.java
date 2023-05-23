package day20.com.ict.edu;

//join() : 현재 스레드는 join()를 호출한 스레드가 끝날 때까지
//	대기상태에 빠져있다가 join()를 호출한 스레드가 끝나면 다시 실행한다.
//	즉 join()를 호출한 스레드가 끝나야 실행할 수 있다.

public class Ex01_join {
	public static void main(String[] args) {
		System.out.println("main : " + Thread.currentThread().getName());

		Ex01_Runnable test = new Ex01_Runnable();
		Thread dog = new Thread(test, "dog");
		Thread cat = new Thread(test, "cat");
//		dog.setDaemon(true);
//		cat.setDaemon(true);
		dog.start();
		cat.start();

		try {
			dog.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("main : " + Thread.currentThread().getName());
	}
}
