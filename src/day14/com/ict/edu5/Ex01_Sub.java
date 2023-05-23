package day14.com.ict.edu5;

public class Ex01_Sub extends Ex01_Super {
	int weight = 35;

	// 정보 은닉 가능
	// 과제 JAVA annotation 알아보고 제출
	@Override
	public void sound() {
		System.out.println("음악소리");
	}

	public void hobby() {
		System.out.println("잠자기");
	}
}
