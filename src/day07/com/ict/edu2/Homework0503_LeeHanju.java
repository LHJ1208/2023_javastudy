package day07.com.ict.edu2;

import java.util.Scanner;

public class Homework0503_LeeHanju {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//전체 횟수, 짝수 횟수, 짝수가 나온 퍼센트 구하기 (소수점 첫째자리까지 구하자)
		
		int inputNum = 0;
		String printStr = "";
		
		int totalCount = 0; //전체 횟수 저장하는 변수
		int evenCount = 0; //짝수가 나온 횟수 저장하는 변수
		double evenRate = 0.0; //짝수가 나온 확률(퍼센트)
		
		pro1 :
		while (true) {
			totalCount++;
			
			System.out.print("\n숫자 입력 : ");
			inputNum = scan.nextInt();

			printStr = "";
			if (inputNum % 2 == 0) {
				printStr = "짝수";
				evenCount++;
			} else {
				printStr = "홀수";
			}
			System.out.println(inputNum + "는 " + printStr + "입니다.");
			
			pro2:
			while(true) {
			System.out.print("\n계속할까요? (1.yes 2.no) >> ");
			int s1 = scan.nextInt();
				switch (s1) {
				case 1: 
					break pro2;
				case 2: 
					break pro1;
				default:
					//올바른 입력값이 나올 때까지 반복!
				}
			}
		}

		
//		boolean loop1 = true; //홀짝 숫자 입력 프로그램 반복문
//		boolean loop2 = true; //프로그램 계속 수행 묻는 반복문
		
//		loop1 = true; //초기식
//		while (loop1) { //조건식
//			totalCount++;
//			
//			System.out.print("\n숫자 입력 : ");
//			inputNum = scan.nextInt();
//
//			printStr = "";
//			if (inputNum % 2 == 0) {
//				printStr = "짝수";
//				evenCount++;
//			} else {
//				printStr = "홀수";
//			}
//			System.out.println(inputNum + "는 " + printStr + "입니다.");
//			
//			loop2 = true; //초기식
//			while(loop2) { //조건식
//			System.out.print("\n계속할까요? (1.yes 2.no) >> ");
//			inputNum = scan.nextInt();
//				switch (inputNum) {
//				case 2: 
//					loop1 = false;
//				case 1: 
//					loop2 = false;
//					break;
//				default:
//					//올바른 입력값이 나올 때까지 반복!
//				}
//			}
//		}
		
		evenRate = (int)(evenCount * 1000 / totalCount) / 10.0;

		System.out.println();
		System.out.println("전체 횟수 : " + totalCount);
		System.out.println("짝수 횟수 : " + evenCount);
		System.out.println("짝수 확률 : " + evenRate + "%");
		
		scan.close();
	}
}
