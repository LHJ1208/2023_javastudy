package day03.com.ict.edu2;

public class Test03 {
	public static void main(String[] args) {
		// 3989초는 몇 시간, 몇 분, 몇 초 인가?
		int hour; // 시
		int min; // 분
		int sec; // 초
		int unit = 60; // 0이면 div 에러남

		int totSec = 3989;

		// 2안
		int res = 0; // 나머지
		hour = totSec / (unit * unit);
		res = totSec % (unit * unit);
		min = res / unit;
		sec = res % unit;

		// 1안
		// int temp = totSec;

		// sec = temp % unit;
		// temp /= unit;

		// min = temp % unit;
		// temp /= unit;

		// hour = temp;

		System.out.println(totSec + "초");
		System.out.println("=");
		System.out.println(hour + "시간");
		System.out.println(min + "분");
		System.out.println(sec + "초");
	}
}
