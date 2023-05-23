package day09.com.ict.edu;

import java.util.Scanner;

public class Ex06_Array {
	public static void main(String[] args) {
		//1) 학급 인원수 입력 받기		
		//2) 이름 국어, 영어, 수학 점수 입력 받기
		//3) 총점, 평균, 학점, 순위 구하기

		Scanner scan = new Scanner(System.in);
		
		int inputNum = 0; //Scanner로 입력 받은 정수
		String inputStr = ""; //Scanner로 입력 받은 문자열
		
		int numberOfPeople = 0; //학급 인원수를 저장할 변수
		
		//배열 선언
		String[] nameArr; //학생의 이름을 저장할 변수
		int[] korArr; //학생의 국어 점수를 저장할 변수
		int[] engArr; //학생의 영어 점수를 저장할 변수
		int[] mathArr; //학생의 수학 점수를 저장할 변수
		int[] sumArr; //학생의 총점을 저장할 변수
		double[] avgArr; //학생의 평균을 저장할 변수(소수점 첫째자리까지 저장)
		String[] gradeArr; //학생의 학점을 저장할 변수
		int[] rankArr; //학생의 순위를 저장할 변수
		
		//1) 학급 인원수 입력 받기
		System.out.print("학급 인원수 : ");
		inputNum = scan.nextInt();
		numberOfPeople = inputNum;
		
		//입력 받은 학급 인원수에 따라 배열 생성
		nameArr = new String[numberOfPeople];
		korArr = new int[numberOfPeople];
		engArr = new int[numberOfPeople];
		mathArr = new int[numberOfPeople];
		sumArr = new int[numberOfPeople];
		avgArr = new double[numberOfPeople];
		gradeArr = new String[numberOfPeople];
		rankArr = new int[numberOfPeople];

		System.out.println();
		for (int i = 0; i < numberOfPeople; i++) {
			//2) 이름 국어, 영어, 수학 점수 입력 받기
			System.out.print("이름 : ");
			inputStr = scan.next();
			nameArr[i] = inputStr;
			System.out.print("국어 : ");
			inputNum = scan.nextInt();
			korArr[i] = inputNum;
			System.out.print("영어 : ");
			inputNum = scan.nextInt();
			engArr[i] = inputNum;
			System.out.print("수학 : ");
			inputNum = scan.nextInt();
			mathArr[i] = inputNum;
			
			System.out.println();
			
			//3-1) 총점, 평균, 학점 구하기
			sumArr[i] = korArr[i] + engArr[i] + mathArr[i];
			avgArr[i] = (sumArr[i] * 10 / 3) / 10.0; //소수점 첫째자리까지 저장
			
			if(avgArr[i] >= 90) {
				gradeArr[i] = "A";
			} else if(avgArr[i] >= 80) {
				gradeArr[i] = "B";
			} else if(avgArr[i] >= 70) {
				gradeArr[i] = "C";
			} else {
				gradeArr[i] = "F";
			}			
		}
		
		//3-2) 순위 구하기
		for (int i = 0; i < numberOfPeople; i++) {
			rankArr[i] = 1; //순위 값 1로 초기화
			
			for (int j = 0; j < numberOfPeople; j++) {
				if(i == j) continue;
				if(sumArr[i] < sumArr[j]) rankArr[i]++;
			}
		}		

		System.out.println("===========================================================");
		
		System.out.print("이름\t");
		System.out.print("국어\t");
		System.out.print("영어\t");
		System.out.print("수학\t");
		System.out.print("총점\t");
		System.out.print("평균\t");
		System.out.print("학점\t");
		System.out.println("순위");
		
		//학급 인원의 정보 출력
		for (int i = 0; i < numberOfPeople; i++) {
			System.out.print(nameArr[i] + "\t");
			System.out.print(korArr[i] + "\t");
			System.out.print(engArr[i] + "\t");
			System.out.print(mathArr[i] + "\t");
			System.out.print(sumArr[i] + "\t");
			System.out.print(avgArr[i] + "\t");
			System.out.print(gradeArr[i] + "\t");
			System.out.println(rankArr[i]);
		}
		

		
		//추가사항) 순위 오름차순 출력해보기
		System.out.println("===========================================================");
		
		System.out.print("이름\t");
		System.out.print("국어\t");
		System.out.print("영어\t");
		System.out.print("수학\t");
		System.out.print("총점\t");
		System.out.print("평균\t");
		System.out.print("학점\t");
		System.out.println("순위");	
		
		for (int i = 0; i < numberOfPeople; i++) {
			for (int j = 0; j < numberOfPeople; j++) {
				if(rankArr[j] == i + 1) {
					System.out.print(nameArr[j] + "\t");
					System.out.print(korArr[j] + "\t");
					System.out.print(engArr[j] + "\t");
					System.out.print(mathArr[j] + "\t");
					System.out.print(sumArr[j] + "\t");
					System.out.print(avgArr[j] + "\t");
					System.out.print(gradeArr[j] + "\t");
					System.out.println(rankArr[j]);
				}
			}
		}
		
		System.out.println("===========================================================");
		
		scan.close();
	}
}
