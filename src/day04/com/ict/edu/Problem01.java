package day04.com.ict.edu;

public class Problem01 {
	public static void main(String[] args) {
//		근무시간이 8시간까지 시간당 9,620이고
//		8시간을 초과한 시간 만큼은 1.5배 지급한다.
//		현재 근무한 시간이 10이다.
//		얼마를 받아야 하는가?

		int workTime = 10;
		int wageHour = 9620;
		int overTime = 8;
		double overWage = 1.5;

		int myWage; // 내 급료

		myWage = workTime <= overTime ? workTime * wageHour
				: (int) (overTime * wageHour + (workTime - overTime) * wageHour * overWage);
		System.out.println("내 돈 : " + myWage + "원");

		// 교수님 답안
		int time = 10;
		int dan = 9620;

		int pay = (time > 8) ? (8 * dan) + (int) ((time - 8) * dan * 1.5) : time * dan;
		System.out.println("결과 : " + pay + "원");

		int num1 = 47;
		int num2 = 32;
		int res = num1 > num2 ? num1 : num2;
		System.out.println("큰 값 : " + res);

		res = num1 - num2 > 0 ? num1 : num2;
		System.out.println("큰 값 : " + res);

		int res2 = Math.max(num1, num2);
		System.out.println("큰 값 : " + res2);

		int num3 = 38;
		int res3 = num3 > 0 ? num3 : num3 * -1;
		System.out.println("결과 : " + res3);

		int res4 = Math.abs(num3);
		System.out.println("결과 : " + res4);
	}
}
