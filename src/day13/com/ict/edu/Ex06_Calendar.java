package day13.com.ict.edu;

import java.util.Calendar;

public class Ex06_Calendar {
	public static void main(String[] args) {
		// Calendar 클래스 : new 예약어를 사용하지 않고 getInstance()를 사용하면 현재 PC 날짜와 시간으로 설정됨
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		System.out.println(now.getTime());
		System.out.println(now.getTimeZone());
		System.out.println();

		System.out.println(now.get(now.YEAR) + "년");
		System.out.println(now.get(now.MONTH) + 1 + "월");
		System.out.println(now.get(now.DATE) + "일");
		System.out.println(now.get(now.DAY_OF_MONTH) + "일");
		System.out.println(now.get(now.HOUR) + "시");
		System.out.println(now.get(now.HOUR_OF_DAY) + "시");
		System.out.println(now.get(now.MINUTE) + "분");
		System.out.println(now.get(now.SECOND) + "초");

		// AM = 0, PM = 1 구하기
		// System.out.print((now.get(now.AM_PM) == 0 ? "오전 " : "오후 "));

		int res = now.get(now.AM_PM);
		if (res == 0) {
			System.out.println("AM " + now.get(now.HOUR) + "시");
		} else {
			System.out.println("PM " + now.get(now.HOUR) + "시");
		}

		// 요일 (1(일요일) ... 7(토요일))
		res = now.get(now.DAY_OF_WEEK);

		String str = "";
		switch (res) {
		case 1:
			str = "일요일";
			break;
		case 2:
			str = "월요일";
			break;
		case 3:
			str = "화요일";
			break;
		case 4:
			str = "수요일";
			break;
		case 5:
			str = "목요일";
			break;
		case 6:
			str = "금요일";
			break;
		case 7:
			str = "토요일";
			break;
		default:
			str = "???";
		}
		System.out.println(str);
		System.out.println();

		// 날짜 변경(month는 0부터)
		now.set(2023, 3, 25);
		System.out.println(now.getTime());

		now.add(now.DATE, 13);
		System.out.println(now.getTime());
	}
}
