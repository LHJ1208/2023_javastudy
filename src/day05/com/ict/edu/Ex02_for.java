package day05.com.ict.edu;

public class Ex02_for {
	public static void main(String[] args) {
		// for문 : 정해진 규칙에 따라 실행문을 반복 처리한다.
		// 형식)
		// for(초기식; 조건식; 증감식) {
		// 조건식이 true일 때 실행할 문장;
		// 조건식이 true일 때 실행할 문자;
		// }

		// ** for문을 만나면 무조건 초기식으로 이동
		// 초기식은 조건식으로 이동
		// 조건식이 true이면 for문 실행, 거직이면 for문을 실행하지 않는다.
		// for문의 끝을 만나면 무조건 증감식으로 간다.

		// {}에서 만들어진 변수는 {} 밖을 벗어나면 사라진다.(사용불가)

		// 안녕하세요 를 열번 출력하기
		for (int i = 1; i < 11; i++) {
			System.out.println(i + " = 안녕하세요.");
		}
		System.out.println("============");

		// 위에 for문과 같은 내용이다.
//		{
//			int i = 1;
//			for ( ; i < 11 ; ) {
//				System.out.println(i + " = 안녕하세요.");
//				i++;
//			}
//		}

		// 0~10까지 출력
		for (int i = 0; i < 11; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("============");

		// 0~10까지 짝수만 출력
		for (int i = 0; i < 11; i = i + 2) {
			System.out.println(i);
		}

		// 좋지 않은 예(괜히 더 복잡한 경우)
//		for(int i = 0; i <= (10 / 2); i++) {
//			System.out.println(i * 2);
//		}

		// 0~10까지 홀수만 출력
//		for(int i = 1; i < 11; i = i + 2) {
//			System.out.println(i);
//		}

		System.out.println("============");

		for (int i = 0; i < 11; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("============");

		// 구구단 중 7단 출력
		int input = 7;
		for (int i = 1; i < 10; i++) {
			System.out.println(input + " x " + i + " = " + (input * i));
		}
		System.out.println("============");
		
		//1-10 누적합 (합계 구하기)
		
		//누적합
		//이전 저장변수 = 0;
		//이전 저장변수 = 이전 저장변수 + 현재값;
		
		//누적곱
		//이전 저장변수 = 1;
		//이전 저장변수 = 이전 저장변수 * 현재값;
				
		int sum = 0;
		for(int i = 1; i < 11; i++) {
			sum = sum + i;
//			System.out.print(sum + " ");
		}
//		System.out.println();
		System.out.println("합계 : " + sum);
		System.out.println("============");
			
		
		//0~10까지 짝수의 누적합
		int even = 0;
		for(int i = 0; i < 11; i++) {
			if(i % 2 == 0) {
				even = even + i;
			}
		}		
		System.out.println("합계 : " + even);
		System.out.println("============");
		
		//factorial 팩토리얼 구하기
		int mul = 1;
		for(int i = 7; i > 0; i--) {
			mul = mul * i;
		}
		System.out.println("7! = " + mul);
		System.out.println("============");
				
//		input = 7;
//		sum = 1;
//		int count;
//		for(count = 1; count < input; count++) {
//			System.out.print(count + " x ");
//			sum = sum * count;
//		}
//		sum = sum * count;
//		
//		System.out.println(count + " = ");
//		System.out.println(count + "! = " + sum);
//		System.out.println("============");
		
		//숙제 FOR문을 이용한 누적합
		// 1 + (-2) + 3 + (-4) + 5 + (-6) + 7 + (-8) + 9 + (-10)
	}
}
