package day13.com.ict.edu;

import java.util.Scanner;

public class HW0512T3_LHJ_main {

	// 입력 받은 문자열이 범위 내의 숫자인지 판별한다
	public static boolean isInBoundary(String input, int minBoundary, int maxBoundary) {
		boolean result = false;

		for (int i = minBoundary; i <= maxBoundary; i++) {
			if (input.equals(Integer.toString(i))) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// 게임에 사용되는 볼 개수
		int ballNum = HW0512T3_LHJ_ball.BALL_NUM; // ballBound 보다 같거나 작아야한다.
		// 게임에 사용되는 볼 값 범위
		int ballBound = HW0512T3_LHJ_ball.BALL_BOUND;

		// compareBall에 쓰이는 strike ball 상수값
		int valStrike = HW0512T3_LHJ_ball.VAL_STRIKE; // ballNum x valBall 보다 큰 값이여야 한다.
		int valBall = HW0512T3_LHJ_ball.VAL_BALL;

		// 게임을 포기가 가능해지는 턴
		final int GIVE_UP = 10;

		// 키보드로 입력 받기 위해 Scanner 객체 생성
		Scanner scan = new Scanner(System.in);

		// 사용자로부터 입력받은 값을 저장하는 변수
		String inputStr = "";
		int tmpNum = 0;
		int[] playerNumArr = new int[ballNum];

		// 출력할 값을 저장하는 변수
		String printStr = "";

		// 컴퓨터 플레이어 숫자를 저장하는 변수
		int[] computerNumArr = new int[ballNum];

		int turnCount = 0; // turn을 진행한 총 횟수
		boolean clearGame = false; // 게임 성공 여부

		int inputStyle = 0; // 볼 입력 방식 정하는 변수
		boolean loop = true; // 반복할지 저장하는 변수

		HW0512T3_LHJ_ball computer;

		System.out.println(" 숫 자    야 구 게 임");
		System.out.println(" Number Baseball Game");

		computer = new HW0512T3_LHJ_ball(); // 컴퓨터 측 볼 초기화

		computerNumArr = computer.getBall(); // 플레이어가 맞춰야할 정답 내용

		while (true) {
			System.out.println("\n 공을 어떻게 입력받을까요?\n");
			System.out.println(" 방법 1");
			System.out.println(" 1번째 공 : 3");
			System.out.println(" 2번째 공 : 6");
			System.out.println(" 3번째 공 : 9\n");

			System.out.println(" 방법 2");
			System.out.println(" 공 3개 입력 : 3 6 9\n");

			System.out.print(" 원하는 방법 >> ");
			inputStr = scan.next();

			// 입력값이 1 또는 2가 아니면 다시 입력받는다.
			if (inputStr.equals("1")) {
				inputStyle = 1;
				break;
			} else if (inputStr.equals("2")) {
				inputStyle = 2;
				break;
			}

		}

		System.out.println(" 숫 자    야 구 게 임");
		System.out.println(" Number Baseball Game");

		turnCount = 0;
		esc: while (true) {
			// 10회차부터는 게임을 계속할건지 말건지 묻는다
			if (turnCount >= GIVE_UP) {
				while (true) {
					System.out.print("\n 계속할까요? (y/n) ");
					inputStr = scan.next();
					// 입력값이 y 또는 n 이 아니면 다시 입력받는다.
					if (inputStr.equalsIgnoreCase("y") || isInBoundary(inputStr, 0, 9)) { // 변경사항) 0~9를 입력받아도 계속 수행하게
																							// 구현하였다
						break;
					} else if (inputStr.equalsIgnoreCase("n")) {
						clearGame = false; // 게임포기를 기록한다
						break esc;
					}
				}
			}
			System.out.println();

			turnCount++;
			// 게임 화면 출력 //생략해도 되는 부분
			HW0512T3_LHJ_print.printScreen(turnCount);
			System.out.println();

			// 사용자로부터 숫자 3개를 입력 받는다
			switch (inputStyle) {
			case 1: {
				for (int i = 0; i < ballNum; i++) {
					System.out.print(" " + (i + 1) + "번째 공 : ");
					tmpNum = scan.nextInt();

					playerNumArr[i] = tmpNum;
					// 0~9 외에 숫자를 입력하면 다시 입력 받는다
					if (tmpNum >= 0 && tmpNum <= ballBound) {
					} else {
						i--;
						continue;
					}
				}
				break;
			}
			case 2: {
				loop = true;
				while (loop) {
					System.out.print(" 공 " + ballNum + "개 입력 : ");

					loop = false;
					for (int i = 0; i < ballNum; i++) {
						tmpNum = scan.nextInt();

						playerNumArr[i] = tmpNum;
						// 0~9 외에 숫자를 입력하면 다시 입력 받는다
						if (playerNumArr[i] >= 0 && playerNumArr[i] <= ballBound) {
						} else {
							loop = true;
						}
					}
				}
				break;
			}
			default:
				System.out.println("inputStyle Error");
			}

			System.out.println();
			System.out.println(" 컴퓨터(타자)");
			for (int i = 0; i < ballNum; i++) {
				System.out.print(" ?");
			}

			// 컴퓨터의 ball값을 출력해서 볼 수 있다 //정답을 볼 수 있다
//			System.out.println();
//			for (int i = 0; i < ballNum; i++) {
//				System.out.print(" " + computerNumArr[i]);
//			}

			// 플레이어의 ball값을 콘솔에 출력한다
			System.out.println("\n\n 플레이어(투수)");
			for (int i = 0; i < ballNum; i++) {
				System.out.print(" " + playerNumArr[i]);
			}
			System.out.println();

			// 컴퓨터와 플레이어의 볼값을 비교한다
			tmpNum = computer.compareBall(playerNumArr);

			// tmpNum값에 따라 스트라이크와 볼, 아웃을 판단한다
			if (tmpNum == 0) {
				printStr = "0 스트라이크 0 볼";
			} else if (tmpNum == valStrike * ballNum) {
				printStr = "삼진 아웃!";
				clearGame = true; // 게임 승리를 기록한다
			} else {
				printStr = (tmpNum / valStrike) + " 스트라이크 " + ((tmpNum % valStrike) / valBall) + " 볼";
			}

			printStr = "\n " + turnCount + "번 타자 : " + printStr;
			System.out.println(printStr);

			if (clearGame) {
				break;
			}
		}

		System.out.println("\n 전체 횟수 : " + turnCount);
		System.out.println("\n 컴퓨터(타자)");
		for (

				int i = 0; i < ballNum; i++) {
			System.out.print(" " + computerNumArr[i]);
		}

		if (clearGame)
			printStr = "  승 리";
		else
			printStr = "  패 배";

		printStr = "\n\n 플레이어(투수)\n" + printStr;
		System.out.println(printStr);
	}
}
