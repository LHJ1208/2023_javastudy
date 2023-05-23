package day07.com.ict.edu2;

import java.util.Scanner;

public class Homework0503_LeeHanju2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 전체 횟수, 짝수 횟수, 짝수가 나온 퍼센트 구하기 (소수점 첫째자리까지 구하자)

		String inputStr = ""; //입력받은 문자열을 저장하는 변수
		int inputNum = 0; //입력받은 숫자(정수)를 저장하는 변수
		String printStr = ""; //출력할 문자열을 저장하는 변수

		// Yes를 나타내는 문자열들을 합쳐놓은 문자열 (구분자 ' ' 공백문자)
		String strYes = "1 y yes 네 ㄴ 예 ㅇ 계속 다음 ㄱㄱ ㅇㅇ";
		
		// No를 나타내는 문자열들을 합쳐놓은 문자열 (구분자 ' ' 공백문자)
		String strNo = "2 n no stop exit escape esc 아니 아니오 아니요 그만 정지 중지 나가기 나가 끝 끝내 끝내기 ㄴㄴ";
		
		String[] arrStrYes = strYes.split(" "); //Yes를 나타내는 문자열들의 배열
		String[] arrStrNo = strNo.split(" "); //No를 나타내는 문자열들의 배열
		
		int totalCount = 0; // 전체 횟수 저장하는 변수
		int evenCount = 0; // 짝수가 나온 횟수 저장하는 변수
		double evenRate = 0.0; // 짝수가 나온 확률(퍼센트)
		int totalSum = 0; // 숫자들의 합계
		double totalAvg = 0.0; // 숫자들의 평균
		
		String tmpStr =""; //임시로 사용되는 문자열 변수
		
		pro1: while (true) { //label pro1
			totalCount++;

			//숫자가 정수로 입력될 때까지 반복한다
			while(true) {
				System.out.print("\n숫자 입력 : ");
				
				//키보드로 입력된 값이 int인지 검사한다
				if (scan.hasNextInt()) {
					inputNum = scan.nextInt();
					break;
				} else if (scan.hasNext()) { //키보드로 입력된 문자열 값이 있는지 검사한다
					tmpStr = "";
					
					//enter이 여러번 입력된 경우를 위한 예외처리문
					while(true) { 
						tmpStr = scan.nextLine();
						//tmpStr의 값이 유효한 문자열 값이 아니면 nextLine을 계속 실행한다.
						//유효한 문자열을 nextLine으로 받게 되면 tmpStr.length가 0이 아니므로 반복문을 빠져나간다.
						if(tmpStr.length() != 0) {
							break;
						}
					}

					System.out.println("\n숫자(정수)를 입력하시오.");
				}
			}

			printStr = "";
			if (inputNum % 2 == 0) {
				printStr = "짝수";
				evenCount++;
			} else {
				printStr = "홀수";
			}
			totalSum = totalSum + inputNum;

			System.out.println(inputNum + "는 " + printStr + "입니다.");

			//입력값으로 Yes 또는 No가 입력될 때까지 질문을 반복한다.
			pro2: while (true) { //label pro2
				System.out.print("\n계속할까요? (1.yes 2.no) >> ");
				inputStr = scan.next();

				//입력값이 Yes를 나타내는 문자열인지 확인하는 반복문
				for(int i = 0; i < arrStrYes.length; i++) {
					if(inputStr.equalsIgnoreCase(arrStrYes[i])) {
						break pro2; //label pro2를 빠져나감
					}
				}
				
				//입력값이 No를 나타내는 문자열인지 확인하는 반복문
				for(int i = 0; i < arrStrNo.length; i++) {
					if(inputStr.equalsIgnoreCase(arrStrNo[i])) {
						break pro1; //label pro1을 빠져나감
					}
				}
			}
		}

		evenRate = (int) (evenCount * 1000 / totalCount) / 10.0;

		System.out.println();
		System.out.println("전체 횟수 : " + totalCount);
		System.out.println("짝수 횟수 : " + evenCount);
		System.out.println("짝수 확률 : " + evenRate + "%");

		// 평균은 소수점 첫째자리까지 저장함
		totalAvg = (totalSum * 10 / totalCount) / 10.0;
		System.out.println("숫자 합계 : " + totalSum);
		System.out.println("숫자 평균 : " + totalAvg);

		scan.close();
	}
}
