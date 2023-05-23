package day16.com.ict.edu;

//Local 내부클래스
public class Ex06_Local_InnerClass {
	String name = "둘리";

	public Ex06_Local_InnerClass() {
		System.out.println("외부생성자 : " + this);
	}

	public void sound() {
		String str = "호이~호이~";
		System.out.println(str);
	}

	public void play() {
		int age = 24;

		// 내부클래스
		class Inner02 {
			String addr = "서울 용산구";

			public Inner02() {
				System.out.println("내부생성자 : " + this);
			}

			public void prn() {
				System.out.println(name);
				System.out.println(age);
				System.out.println(addr);
			} // 내부클래스 메서드 끝

		} // 내부클래스 끝

		Inner02 iner2 = new Inner02();
		iner2.prn();

	} // 외부클래스 멤버메서드 끝
}
