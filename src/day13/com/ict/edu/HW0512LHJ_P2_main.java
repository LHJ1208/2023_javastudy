package day13.com.ict.edu;

import java.util.Scanner;
import java.util.Random;

public class HW0512LHJ_P2_main {

	public static void main(String[] args) {
		// 키보드로 입력 받기 위해 Scanner 객체 생성
		Scanner scan = new Scanner(System.in);

		// 난수를 만들기 위해 Random 객체 생성
		Random random = new Random();

		// 출력할 문자열을 저장하는 변수
		String printStr = "";

		// 입력받은 값을 저장하는 변수
		String inputStr = "";
		boolean inputHighLow = true;

		// 컴퓨터의 높음낮음을 저장하는 변수
		boolean comHighLow = true;
		String comStr = "";

		// 높음낮음 승패 결과를 저장하는 변수
		boolean result = true;

		int totalCount = 0; // 게임을 한 총 횟수
		int winCount = 0; // 게임을 이긴 횟수
		double winRate = 0.0; // 승률을 저장하는 변수

		esc: while (true) {
			while (true) {
				System.out.println("\n High 높음\tLow 낮음");
				System.out.print(" 입력 : ");
				inputStr = scan.next();

				System.out.println();

				switch (inputStr) {
				case "HIGH":
				case "High":
				case "high":
				case "높음":
					inputStr = "High";
					inputHighLow = true;
					break;
				case "LOW":
				case "Low":
				case "low":
				case "낮음":
					inputStr = "Low";
					inputHighLow = false;
					break;

				default:
					continue;
				}

				break;
			}

			// 0~1의 난수 생성
			comHighLow = random.nextBoolean();

			if (comHighLow) {
				comStr = "High";
			} else {
				comStr = "Low";
			}

			// 가위바위보 결과 계산
			if (inputHighLow == comHighLow)
				result = true;
			else
				result = false;

			totalCount++;
			System.out.println(" " + totalCount + "번째 승부");
			System.out.print(" 나: " + inputStr);
			System.out.print(" vs ");
			System.out.print("컴퓨터: " + comStr);
			System.out.print("\n\n\t ");

			if (result) {
				printStr = "승 리";
				winCount++;
			} else {
				printStr = "패 배";
			}
			System.out.println(printStr);

			while (true) {
				System.out.print("\n 계속할까요? (y/n) ");
				inputStr = scan.next();
				if (inputStr.equalsIgnoreCase("y"))
					break;
				else if (inputStr.equalsIgnoreCase("n"))
					break esc;
			}
		}

		System.out.println("\n 게임 횟수 : " + totalCount);
		System.out.println(" 승리 횟수 : " + winCount);

		winRate = (winCount * 1000 / totalCount) / 10.0;
		System.out.println(" 승률 (%) : " + winRate);
		
		scan.close();
	}
}
