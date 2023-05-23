package day06.com.ict.edu2;

import java.util.Scanner;

public class Ex01_Scanner {
	public static void main(String[] args) {
		//Scanner class : 키보드에 입력된 정보를 받아서 처리하는 클래스
		
		//System.out => 표준 출력 장치 (모니터)
		//System.in => 표준 입력 장치 (키보드)
		
		//java.lang에 속한 것은 import하지 않아도 자유롭게 사용 가능
		//java.lang 패키지 외에 존재하는 클래스는 import를 해야 사용할 수 있다
		//Scanner은 java.util에 있음
		
		//import 방법
		//Ctrl + Space Bar 
		//Ctrl + Shift + O (자동 import)
		
		//해당 클래스 뒤에 커서를 놓고 Shift + F2를 누르면 해당 클래스 API 설명서가 나타난다.
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 : ");
		
		//.next() : 입력한 내용을 String으로 처리하는 메서드
		String name = scan.next();
		System.out.println("내 이름은 " + name);
		
		System.out.print("나이 : ");
		
		//.next() : 입력한 내용을 String으로 처리하는 메서드
		String age = scan.next();
		System.out.println("내 나이는 " + (age + 1));
		
		System.out.print("나이 : ");
		
		//.nextInt() : 입력한 내용을 int로 처리하는 메서드
		int age2 = scan.nextInt(); //문자를 입력하면 오류
		System.out.println("내 나이는 " + (age2 + 1));
		
		System.out.print("키 : ");
		//.nextDouble() : 입력한 내용을 double으로 처리하는 메서드(문자를 입력하면 오류)
		double ke = scan.nextDouble();
		System.out.println("받은 내용 : " + ke);
		
		//.nextBoolean() : 입력한 내용을 boolean 으로 처리하는 메서드 (숫자 및 다른 문자 입력하면 오류)
		System.out.println("당신은 휴먼입니까?\n(true/false)");
		boolean human = scan.nextBoolean();
		if(human) System.out.println("사람입니다.");
		else System.out.println("사람이 아닙니다.");
		
		//.nextChar() 는 존재하지 않는다.
		
		scan.close();
	}
}
