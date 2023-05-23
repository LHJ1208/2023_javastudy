package day04.com.ict.edu;

public class Ex02_oper {
	public static void main(String[] args) {
		// 중첩 삼항 연산자 : 삼항 연산자가 중첩되는 것
		// ex) 자료형 변수이름 = (조건식1) ? ((조건식2) ? 조건식2가 참일 때: 조건식2가 거짓일 때) : 조건식1이 거짓일 때;
		// ex) 자료형 변수이름 = (조건식1) ? 조건식1이 참일 때 : ((조건식2) ? 조건식2가 참일 때: 조건식2가 거짓일 때);

		// int k1이 90 이상이면 "A학점", 80 이상이면 "B학점", 나머지는 "F학점"
		int myGrade = 88;
		int cutOffA = 90;
		int cutOffB = 80;

		String str = myGrade >= cutOffA ? "A학점" : myGrade >= cutOffB ? "B학점" : "F학점";
		System.out.println("학점 : " + str);

		// char k2 가 대문자인지, 소문자인지, 기타문자인지 판별하자
		char k2 = 'A';

		boolean upperCase;
		boolean lowerCase;

		upperCase = k2 >= 'A' && k2 <= 'Z';
		// upperCase = !(k2 < 'A' || k2 > 'Z');
		lowerCase = k2 >= 'a' && k2 <= 'z';
		// lowerCase = !(k2 < 'a' || k2 > 'z');

		String str2 = upperCase ? "대문자" : lowerCase ? "소문자" : "기타문자";
		System.out.println("문자 : " + str2);

		// int k3이 1 또는 3이면 남자, 2 또는 4이면 여자
		// 1 또는 2이면 1900년대 태어남, 3 또는 4이면 2000년대 태어남, 나머지는 외국인

		int k3 = 5;

		str = (k3 == 1 || k3 == 3) ? (k3 == 1) ? "1990년대 태어난 남자" : "2000년대 태어난 남자"
				: (k3 == 2 || k3 == 4) ? (k3 == 2) ? "1900년대 태어난 여자" : "2000년대 태어난 여자" : "외국인";
		System.out.println("결과 : " + str);
	}
}
