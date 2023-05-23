package day02.com.ict.edu;
class Ex06 {
	public static void main(String[] args) {
		//String : 문자열을 처리하기 위해서 만든 클래스
		//기본자료형이 아니다.
		//클래스를 자료형으로 사용하므로 참조자료형이다.
		//기본자료형처럼 사용 가능하다.
		//반드시 ""(쌍따옴표) 사용
		//String 변수이름 = "데이터";

		String name = "홍길동";
		int age = 17;
		System.out.println(name);

		//+연산을 할 수 있으며 결과는 무조건 String 이다.
		//실제 덧셈 연산을 하지 않고 문자와 연결하는 연결자 역할을 한다
		name = "1000";
		age = 1000;
		System.out.println(name + 50); //100050
		System.out.println(age + 50); //1050

		int su1 = 20;
		int su2 = 4;
		System.out.println(su1 + su2); //24
		System.out.println("결과 : " + su1 + su2); //결과 : 204

		//해결책
		//println으로 출력할 값에 대한 변수를 새로 선언하는 것을 추천!
		int su3 = su1 + su2; 
		System.out.println("결과 : " + su3);

		System.out.println("결과 : " + (su1 + su2));
	}
}

//내일은 연산자를 배운다. (시프트, 비트 연산자 제외)