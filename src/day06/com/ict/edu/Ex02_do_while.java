package day06.com.ict.edu;

public class Ex02_do_while {
	public static void main(String[] args) {
		//do ~ while문 :
		//	while 문과 같은 반복문
		//	단, 먼저 실행 후 조건식 비교
		
		//형식)
		//초기식;
		//do {
		//	실행문;
		//	증감식;
		//} while(조건식);
		
		//0 ~ 10까지 출력
		int i = 0; //초기식
		do {
			System.out.println(i);
			i++; //증감식
		} while(i < 11); //조건식
		
		System.out.println("============");
		
		//0 ~ 10까지 홀수 출력
		i = 0; //초기식
		do {
			if(i % 2 == 1) { //if문 조건식
			System.out.println(i);
			}
			i++; //증감식
		} while(i < 10); //do while문 조건식
		
		System.out.println("============");
		
		//7단 출력
		int num = 7;
		i = 1; //초기식
		do {
			System.out.println("7 x " + i + " = " + (num*i));
			i++; //증감식
		} while(i < 10); //조건식
		
		System.out.println("============");
		
		//0 ~ 10 홀수의 누적합
		int sum = 0;
		i = 0; //초기식
		do {
			if(i % 2 == 1) { //if문 조건식
				sum = sum + i;
			}
			i++; //증감식
		} while(i < 11); //do while문 조건식
		System.out.println("합계 : " + sum);
		
		System.out.println("============");
	}
}
