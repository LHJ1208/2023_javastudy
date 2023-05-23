package day07.com.ict.edu2;

import java.util.Scanner;

public class Ex01_Scanner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//전체 횟수, 짝수 횟수, 짝수가 나온 퍼센트 구하기 (소수점 첫째자리까지 구하자)
		
		int totalCount = 0; //전체 횟수 저장하는 변수
		int evenCount = 0; //짝수가 나온 횟수 저장하는 변수
		double evenRate = 0.0; //짝수가 나온 확률(퍼센트)
		
		while (true) {
			totalCount++;
			
			System.out.print("\n숫자 입력 : ");
			int su = scan.nextInt();

			String str = "";
			if (su % 2 == 0) {
				str = "짝수";
				evenCount++;
			} else {
				str = "홀수";
			}
			System.out.println(su + "는 " + str + "입니다.");
			
			System.out.print("\n계속할까요? (1.yes 2.no) >> ");
			int s1 = scan.nextInt();
			if(s1 == 2) break;
		}
		
		evenRate = 100.0 * evenCount / totalCount ;

		System.out.println();
		System.out.println("전체 횟수 : " + totalCount);
		System.out.println("짝수 횟수 : " + evenCount);
		System.out.println("짝수 확률 : " + (int)(evenRate*10) / 10.0 + "%");
		
		scan.close();
	}
}
