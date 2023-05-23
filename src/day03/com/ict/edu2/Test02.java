package day03.com.ict.edu2;

public class Test02 {
	public static void main(String[] args) {
		// 2시간 40분 30초는 몇 초 일까요?
		int hour = 2; //시
		int min = 40; //분
		int sec = 30; //초
		int unit = 60;
		
		int totSec;
		
		totSec = hour * unit * unit + min * unit + sec;
		System.out.println(hour + "시간");
		System.out.println(min + "분");
		System.out.println(sec + "초");
		System.out.println("=");
		System.out.println(totSec + "초");
	}
}
