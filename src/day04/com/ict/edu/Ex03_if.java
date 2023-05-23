package day04.com.ict.edu;

public class Ex03_if {
	public static void main(String[] args) {
		//단순 if문 : 조건식이 참일 때만 실행, 거짓이면 if문 무시
		//형식)
		//if(조건식) {
		//조건식이 참일 때 실행할 문장;
		// ...
		//조건식이 참일 때 실행할 문장;
		//}
		//단, 실행문장이 한 줄이면 {} 블록을 생략할 수 있다.
		
		//형식)
		//if(조건식) 조건식이 참일 때 실행할 문장;
		
		//if(조건식)
		//조건식이 참일 때 실행할 문장;
		
		//int k1이 60 이상이면 합격
		int k1 = 50;
		String res= "초기값";
		
		if(k1 >= 60) {
			res = "합격";
		}
		
		if(k1 < 60)
			res = "불합격";
		
		System.out.println("결과 : " + res);
		
		//int k2 가 홀수인지 짝수인지 판별하자.
		int k2 = 43;
		
		res = "짝수";
		
		if(k2 % 2 == 1) { //k2 % 2 != 0
			res = "홀수";
		}
		
		System.out.println("결과 : " + res);
		
		// char k3가 대문자인지, 아닌지 판별하자
		char k3 = 'a';
		res = "대문자X";
		
		//!(k3 < 'A' || k3 > 'Z')
		if (k3 >= 'A' && k3 <= 'Z') {
			res = "대문자";
		}		
		System.out.println("결과 : " + res);
		
//		근무시간이 8시간까지 시간당 9,620이고
//		8시간을 초과한 시간 만큼은 1.5배 지급한다.
//		현재 근무한 시간이 10이다.
//		얼마를 받아야 하는가?
		
		int workTime = 10;
		int wageHour = 9620;
		int overTime = 8;
		double overWage = 1.5;

		int myWage = workTime * wageHour; //초과수당 못 받는 경우로 초기화
		
		if(workTime > 8) {
			myWage = overTime * wageHour + (int)((workTime - overTime) * wageHour * overWage);
		}
		
		System.out.println("내 돈 : " + myWage + "원");
		
		
		//교수님 답안
		int time = 10;
		int limit = 8;
		int dan = 9620;
		int pay = time * dan;
		
		if(time > limit) {
			pay = (limit * dan) + (int)((time - limit) * dan * 1.5);
		}		
		System.out.println("결과 : " + pay + "원");		
	}
}
