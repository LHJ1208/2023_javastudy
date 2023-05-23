package day06.com.ict.edu2;

import java.util.Scanner;

public class Ex02_Scanner2 {
	public static void main(String[] args) {
		//키보드 입력 정보를 받아서 일 처리하자
		Scanner scan = new Scanner(System.in);
		int inputNum;
		String printStr;
		
		//키보드에서 받은 숫자가 홀수, 짝수 인지 판별하자.
		System.out.print("숫자 입력 : ");
		inputNum = scan.nextInt();
		
		if(inputNum % 2 == 0) printStr = "짝수";
		else printStr = "홀수";
		
		System.out.println(inputNum + "은(는) " + printStr + " 입니다.");
		
		//총점을 입력 받아서 60점 이상이면 합격, 미만이면 불합격
		System.out.print("총점 입력: ");
		inputNum = scan.nextInt();
		if(inputNum < 60) printStr = "불합격";
		else printStr = "합격";
		
		System.out.println("당신의 점수는 " + inputNum + "점 입니다.");
		System.out.println("당신은 " + printStr + " 입니다.");
		
		scan.close();
	}
}
