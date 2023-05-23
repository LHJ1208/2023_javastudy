package day15.com.ict.edu2;

public abstract class Ex01_abstract {
	// 추상 클래스와 추상 메서드

	// 추상 메서드 : 메서드에서 body(몸통, 블록, {}, 실제 실행할 내용을 기록하는 부분)를 가지고 있지 않은 메서드
	// 반드시 abstract 예약어를 붙여야 한다.

	// 추상 클래스 : 일반 클래스가 가지는 멤버필드, 멤버메서드, 생성자를 가질 수 있다.
	// 추상 클래스는 하나 이상의 추상 메서드를 가지고 있다. (추상 메서드 가지고 있지 않을거면 굳이 abstract 써서 욕 먹는다)
	// 반드시 abstract 예약어를 붙여야 한다.

	// 일반 메서드
	public void play() {
		System.out.println("놀자");
	}

	public String sound() {
		return "코 고는 소리";
	}

	// 추상 메서드
	public abstract void hobby();
}
