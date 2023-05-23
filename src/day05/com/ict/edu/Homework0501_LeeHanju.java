package day05.com.ict.edu;

public class Homework0501_LeeHanju {
	public static void main(String[] args) {
		// 1. if~ else문
		// 농구공 5개씩 한 박스에 들어간다.
		// 40개면 8상자, 26개면 6개이다.
		// int k1 = 127개이다.
		// 몇 상자가 필요한가요?
		int k1 = 127; //입력받은 값
		int ballNum = k1; //농구공 개수
		int boxSize = 5; //한 박스에 들어가는 농구공 개수
		int boxNum = ballNum / boxSize; //공을 담는데 필요한 박스 개수
		
		if (ballNum % boxSize > 0) {
			boxNum = boxNum + 1;
		}

		System.out.println("공 : " + boxNum + "개");
		System.out.println("박스 : " + boxNum + "개");
		System.out.println("============");

		// 2. for 문으로 플기
		// 0 0 0 0
		// 0 0 0 0
		// 0 0 0 0
		// 0 0 0 0
		int size = 4; //size가 4일 때 0 4글자씩 4줄 출력
		for (int i = 1; i < size * size + 1; i++) {
			System.out.print("0 ");
			if (i % 4 == 0) {
				System.out.println();
			}
		}
		System.out.println("============");

		// 3. 이중 for 문으로 풀기
		// 1 0 0 0
		// 0 1 0 0
		// 0 0 1 0
		// 0 0 0 1
		size = 4; //size가 4일 때 4글자씩 4줄 출력
		for (int i = 0; i < size; i++) {
			
			//i행에서 글자를 size 번 출력하는 FOR문
			for (int j = 0; j < size; j++) {
				if(i == j) { //i행 j열에서 1 출력(i == j)
					System.out.print("1 ");
				}
				else { //i행 j열 에서 0 출력(i != j)
					System.out.print("0 ");
				}
			}
			
			//i행의 j열까지 출력하고 FOR문에서 나온 후에 줄바꿈을 해줌
			System.out.println();
		}
		System.out.println("============");

		// (for문 활용)
		// 4. 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때,
		// 몇까지 더해야 총합이 100이상이 되는지 구하시오.
		int sum = 0; //총합을 저장할 변수
		int num = 1;
		int condition = 100; //총합이 condition 이상이면 반복문을 끝냄
		
		for (num = 1; sum < condition; num++) {
			if (num % 2 == 0) {
				sum = sum + ((-1) * num);
			} else {
				sum = sum + num;
			}
		}		
		//1. num = 1로 시작
		//2. 조건식 비교(sum < condition)
		
		//2-참-1. 조건식 비교가 참이면 구현부 실행
		//2-참-2. if문 조건식 비교(num % 2) == 0 //num이 짝수이면 true, 홀수이면 false
		//2-참-2-참. num이 짝수이면 (-1) * num 음수값을 sum에 더 함.
		//2-참-2-거짓. num이 홀수이면 num 양수값 그대로 sum에 더 함.
		//2-참-3. FOR문의 끝을 만남
		//2-참-4. 증감식 실행 num++ num 값이 1 증가함.
		// -> 2로 이동
		
		//2-거짓-1. FOR문을 실행하지 않고 빠져나옴
		
		//2 조건식 비교에서 거짓으로 
		//2-거짓-1에서 FOR문을 빠져나왔을 때 
		//그전에 2-참-4에서 증감식을 만나 num이 1 증가한 상태이므로
		//num 값을 1 줄여줌
		num--;
		//※틀리기 쉬운 부분!!! 실수하기 쉬운 부분!!!
		
		System.out.println(num + "번째 수를 더한 합계 = " + sum);
		System.out.println("============");

		// (for문 활용)
		// 5. 별 찍기
		// *
		// **
		// ***
		// ****
		size = 4; //size가 4일때 별 4개까지 출력
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("============");

		// 6. 별찍기
		//    *
		//   **
		//  ***
		// ****
		size = 4; //size가 4일때 별 4개까지 출력
		for (int i = 1; i < size + 1; i++) {
			for (int j = 0; j < size - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("============");
		
		//6번 문제 다른 풀이
		size = 4; //size가 4일때 별 4개까지 출력
		for (int i = 1; i < size + 1; i++) {
			for (int j = 0; j < size; j++) {
				if(j < size - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("============");
	}
}
