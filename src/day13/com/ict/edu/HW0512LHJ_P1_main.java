package day13.com.ict.edu;

import java.util.Scanner;
import java.util.Random;

public class HW0512LHJ_P1_main {

	// p1과 p2의 가위바위보 결과를 계산하는 메서드
	// 결과값 : p1이 이기면 1, p1이 비기면 0, p1이 지면 -1을 반환한다.
	// ※ p1, p2가 "가위", "바위", "보" 이외의 값이 들어왔을 때에 대한 예외처리 구현 필요
	public static int rockPaperScissors(String p1, String p2) {
		int result = 0;

		switch (p1) {
		case "가위":
			switch (p2) {
			case "가위":
				result = 0;
				break;
			case "바위":
				result = -1;
				break;
			case "보":
				result = 1;
				break;
			}
			break;
		case "바위":
			switch (p2) {
			case "가위":
				result = 1;
				break;
			case "바위":
				result = 0;
				break;
			case "보":
				result = -1;
				break;
			}
			break;
		case "보":
			switch (p2) {
			case "가위":
				result = -1;
				break;
			case "바위":
				result = 1;
				break;
			case "보":
				result = 0;
				break;
			}
			break;
		}

		return result;
	}

	// 가위바위보 문자열을 해당 이모지로 반환한다.
	public static String toEmoji(String inputStr) {
		String result = "";

		switch (inputStr) {
		case "가위":
			result = "✌";
			break;
		case "바위":
			result = "✊";
			break;
		case "보":
			result = "✋";
			break;
		}

		return result;
	}

	public static void main(String[] args) {
		// 키보드로 입력 받기 위해 Scanner 객체 생성
		Scanner scan = new Scanner(System.in);

		// 난수를 만들기 위해 Random 객체 생성
		Random random = new Random();

		// 출력할 문자열을 저장하는 변수
		String printStr = "";

		// 입력받은 문자열을 저장하는 변수
		String inputStr = "";

		// 컴퓨터의 가위바위보를 저장하는 변수
		int comNum = 0;
		String comStr = "";

		// 가위바위보 승패 결과를 저장하는 변수
		int result = 0;

		int totalCount = 0; // 게임을 한 총 횟수
		int winCount = 0; // 게임을 이긴 횟수
		double winRate = 0.0; // 승률을 저장하는 변수

		esc: while (true) {
			while (true) {
				System.out.println("\n ✌ 가위\t ✊ 바위\t ✋ 보");
				System.out.print(" 입력 : ");
				inputStr = scan.next();

				System.out.println();

				switch (inputStr) {
				case "가위":
				case "바위":
				case "보":
					break;

				default:
					continue;
				}

				break;
			}

			// 0~2의 난수 생성
			comNum = (int) (random.nextDouble() * 3);

			switch (comNum) {
			case 0:
				comStr = "가위";
				break;

			case 1:
				comStr = "바위";
				break;

			case 2:
				comStr = "보";
				break;
			default:
				comStr = "???";
			}

			// 가위바위보 결과 계산
			result = rockPaperScissors(inputStr, comStr);

			totalCount++;
			System.out.println(" " + totalCount + "번째 승부");
			printStr = " 나: " + inputStr + toEmoji(inputStr);
			System.out.printf("%-9s", printStr);
			System.out.print("vs");
			printStr = "컴퓨터: " + comStr + toEmoji(comStr);
			System.out.printf("%10s", printStr);
			System.out.print("\n\n\t ");

			switch (result) {
			case -1:
				printStr = "패 배";
				break;
			case 0:
				printStr = "무 승 부";
				break;
			case 1:
				printStr = "승 리";
				winCount++;
				break;
			default:
				System.out.println("Error");
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
