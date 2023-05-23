package day20.com.ict.edu;

//동기화 처리할 때 현재 실행중인 스레드를 강제로 대기 상태로 변경시키는 메서드 wait()
//	한번 wait()된 스레드를 풀어주지 않으면 그대로 대기상태로 끝난다.
//	wait()된 스레드를 풀어주는 예약어가 notify(), notifyAll() 이다.

public class Ex03_noti_wait {
	public static void main(String[] args) {
		System.out.println("main : " + Thread.currentThread().getName());

		Ex03_Runnable test = new Ex03_Runnable();

		new Thread(test, "dog").start();
		new Thread(test, "cat").start();
		new Thread(test, "tiger").start();
		new Thread(test, "lion").start();

		System.out.println("main : " + Thread.currentThread().getName());
	}
}
