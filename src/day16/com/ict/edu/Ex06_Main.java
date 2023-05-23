package day16.com.ict.edu;

public class Ex06_Main {
	public static void main(String[] args) {
		// 내부클래스를 별도로 객체 생성할 수 없다. (static은 제외)
		// Inner02 test = new Inner02();

		// Member 내부클래스 만드는 방식으로도 사용불가
		Ex06_Local_InnerClass test = new Ex06_Local_InnerClass();

		// 사용불가
		// Ex06_Local_InnerClass.Inner02 exam = test.new Inner02();

		test.sound();
		System.out.println();

		// 메서드 안에 있으므로 메서드를 실행해야
		// 내부클래스를 생성할 수 있다.
		test.play();

		// 메서드가 끝나면 내부클래스도 사라진다.

	}
}
