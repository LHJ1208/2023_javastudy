package day07.com.ict.edu;

public class Exam01_LHJ {
	public static void main(String[] args) {
		// 1
		String name = "홍길동";
		int kor = 95;
		int eng = 85;
		int math = 85;
		int total = 0;
		double avg = 0.0;
		total = kor + eng + math;
		avg = (int) (total * 10 / 3) / 10.0;
		System.out.println(name + ", " + total + ", " + avg);

		// 2
		int time = 3989;
		int hour = 0;
		int min = 0;
		int sec = 0;
		sec = time % 60;
		min = time / 60;
		hour = time / (60 * 60);
		System.out.println(hour);
		System.out.println(min);
		System.out.println(sec);

		// 3
		int price = 8500;
		int money = 20000;
		int change = 0;
		change = money - (int) (price * 2 * 1.1);
		System.out.println(change);

		// 4
		int k1 = 10;
		System.out.println((k1 % 2 != 0) ? "홀수" : "짝수");

		// 5
		char k2 = 'A';
		if (k2 < 'A' || k2 > 'Z') {
			System.out.println("대문자 아님");
		} else {
			System.out.println("대문자");
		}

		// 6
		int cutExtra = 8;
		int extraTime = 0;
		double extraWage = 0.0;

		int workTime = 10;
		int hourWage = 9620;
		int myWage = 0;

		extraTime = workTime - cutExtra;

		if (extraTime > 0) {
			extraWage = extraTime * hourWage * 1.5;
			myWage = (int) (cutExtra * hourWage + extraWage);
		} else {
			myWage = workTime * hourWage;
		}

		System.out.println(myWage);
	}
}
