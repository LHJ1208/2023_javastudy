package day07.com.ict.edu;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//문제2
		//이름, 국어, 영어, 수학를 입력 받아서 
		//총점, 평균, 학점을 구하고 
		//이름, 총점, 평균, 학점을 출력하는 코딩 
		//(평균은 소숫점 첫째자리까지 구하자)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scan.next();
		
		System.out.print("국어 : ");
		int kor = scan.nextInt();
				
		System.out.print("영어 : ");
		int eng = scan.nextInt();
				
		System.out.print("수학 : ");
		int math = scan.nextInt();
		
		//총점, 평균, 학점을 구하기
		int sum = kor + eng + math;
		double avg = (int)(sum / 3.0 * 10 ) / 10.0;
		
		String hak = "";
		
		if(avg >= 90) {
			hak = "A 학점";
		} else if(avg >=80) {
			hak = "B 학점";
		} else if(avg >= 70) {
			hak = "C 학점";
		} else {
			hak = "F 학점";
		}
		
		System.out.println("이 름 : " + name);
		System.out.println("총 점 : " + sum);
		System.out.println("평 균 : " + avg);
		System.out.println("학 점 : " + hak);
		
		scan.close();
	}
}
