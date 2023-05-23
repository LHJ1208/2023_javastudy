package day04.com.ict.edu;

public class Ex01_oper {
	public static void main(String[] args) {
		// 삼항 연산자 : 조건식 => 조건이 참일 때와 거짓일 때를 구분해서 실행한다.
		// 형식) 자료형 변수이름 = (조건식) ? 조건식이 참일 때 실행할 문장 : 조건식이 거짓일 때 실행할 문장
		// ex) int i = 10 > 20 ? 15 : 25; //25 //조건식이 false이므로 i = 25

		// **주의사항) 변수, 참일 때 실행결과, 거짓일 때 실행결과 모두 같은 자료형이여야 한다.
		// (대입연산자가 성립해야한다)
		// ex) 변수(double), 참일 때 결과(int), 거짓일 때 결과(char) 가능!
		// double num = false ? 15 : 'a'; //97.0

		// 조건식에는 boolean(true, false), 비교연산자, 논리연산자 가 들어갈 수 있다.

//		String str = true ? "강아지" : "고양이";
		String str = "강아지";
		System.out.println("결과 : " + str);

		// int avg = 80;
		double avg = 59.99999999999999; // 가수부가 16자리를 넘으면 제대로 된 결과가 안 나옴
		int cutOff = 60; // cut-off line, cut-off point
		str = avg >= cutOff ? "합격" : "불합격";
		System.out.println("결과 : " + str);

		char c1 = 'k';
		str = (c1 >= 'a' && c1 <= 'z') ? "소문자" : "소문자X";
		//str = (c1 < 'a' || c1 > 'z') ? "소문자X" : "소문자";
		System.out.println("결과 : " + str);
		
		// 1 또는 3이면 남자 아니면 여자 라고 가정해보자
		int gender = 1;
		str = (gender == 1 || gender == 3) ? "남자" : "여자";
		System.out.println("결과 : " + str);
		
		gender = 4;		
		str = (gender % 2 == 1) ? "남자" : "여자";
		//str = (gender % 2 != 0) ? "남자" : "여자";
		System.out.println("결과 : " + str);
		
		//3의 배수인지 아닌지 알아보자
		int su1 = 157;
		str = (su1 % 3 == 0) ? "3의 배수" : "3의 배수X";
		//str = (su1 % 3 != 0) ? "3의 배수X" : "3의 배수";
		System.out.println("결과 : " + str);
	}
}
