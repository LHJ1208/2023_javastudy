package day05.com.ict.edu;

public class Ex04_while {
	public static void main(String[] args) {
		// while문 : for 문과 같은 반복문

		// 형식1)

		// 초기식;
		// while(조건식) {
		// 조건식이 참이면 실행할 문장;
		// 조건식이 참이면 실행할 문장;
		// 증감식;
		// }
		// ** while 문의 끝을 만나면 조건식으로 간다.

		// 형식2)

		// 초기식;
		// while(true) {
		// if(빠져나갈 조건) {
		// break;
		// }
		// 조건식이 참이면 실행할 문장;
		// 조건식이 참이면 실행할 문장;
		// 증감식;
		// }

		// 1 ~ 10 까지 출력
		int i = 1;
		while (i < 11) {
			System.out.println("i = " + i);
			i++;
		}
		System.out.println("============");

		i = 1;
		while (true) {
			if (i > 10) {
				break;
			}
			System.out.println("i = " + i);
			i++;
		}

		// 0~10까지 짝수 출력
		i = 0;
		while (i < 11) {
			if (i % 2 == 0) {
				System.out.println("i = " + i);
			}
			i++;
		}
		System.out.println("============");

		// 구구단 중 7단 출력
		i = 1;
		while (i < 10) {
			System.out.println("7 x " + i + " = " + (7 * i));
			i++;
		}
		System.out.println("============");

		// 1~10 누적합 (합계 구하기)
		int sum = 0;
		i = 1;
		while (i < 11) {
			sum = sum + i;
			i++;
		}
		System.out.println("합계 : " + sum);
		System.out.println("============");

		// 0 0 0 0
		// 0 0 0 0
		// 0 0 0 0
		// 0 0 0 0

		i = 1;
		while (i < 5) {
			System.out.println(" 0 0 0 0");
			i++;
		}
		System.out.println("============");

		i = 0;
		int j = 0;
		int input = 4; //0을 몇 번 출력하고 싶은지
		while (i < input) {
			j = 0;
			while (j < input) {
				System.out.print(" 0");
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println("============");

		//강사님 방법 응용
		i = 1;
		input = 4; //0을 몇 개 찍고 줄을 바꿀지
		while (i < input * input + 1) { // i < 17
			System.out.print(" 0");
			if (i % input == 0) { //0을 4번 출력했을 때마다 줄을 바꿔줌
				System.out.println();
			}
			i++;
		}
		System.out.println("============");
	}
}
