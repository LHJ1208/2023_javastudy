package day13.com.ict.edu;

import java.util.Random;

public class HW0512T3_LHJ_ball {
	// 게임에 사용되는 볼 개수
	public static final int BALL_NUM = 3; // BALL_BOUND 보다 같거나 작아야한다.

	// 게임에 사용되는 볼 값 범위 // 0 ~ BALL_BOUND 까지
	public static final int BALL_BOUND = 9;

	// compareBall에 쓰이는 strike ball 상수값
	public static final int VAL_STRIKE = 100; // BALL_NUM x VAL_BALL 보다 큰 값이여야 한다.
	public static final int VAL_BALL = 1;

	private int[] ball = new int[BALL_NUM];

	// 기본생성자
	public HW0512T3_LHJ_ball() {
		Random random = new Random();

		// BALL_BOUND 범위 내에서 중복되는 숫자가 없게 BALL_NUM 개의 숫자를 ball 배열에 넣는다
		for (int i = 0; i < ball.length; i++) {
			ball[i] = random.nextInt(BALL_BOUND);

			// 이전에 저장한 숫자 중에 현재 가진 숫자와 같은 것이 있는지 확인하는 반복문
			for (int j = 0; j < i; j++) {
				if (ball[i] == ball[j]) {
					i--;
					break;
				}
			}
		}
	}

	// 생성자
	public HW0512T3_LHJ_ball(int[] ball) {
		this.ball = ball;
	}

	public void setBall(int[] ball) {
		this.ball = ball;
	}

	public int[] getBall() {
		return ball;
	}

	// ball 배열의 길이를 반환한다
	public int getBallLength() {
		return ball.length;
	}

	// ball 배열과 input 배열을 비교하여 스트라이크와 볼의 개수를 구한다.
	// 스트라이크 하나마다 결과값에 상수값(VAL_STRIKE)을 더한다.
	// 볼 하나마다 결과값에 상수값(VAL_BALL)을 더한다.
	public int compareBall(int[] input) {
		int result = 0;
		int length = input.length;
		if (length != ball.length) {
			return -1;
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (ball[i] == input[j])
					if (i == j)
						result += VAL_STRIKE;
					else
						result += VAL_BALL;
			}
		}

		return result;
	}
}
