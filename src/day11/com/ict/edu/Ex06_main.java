package day11.com.ict.edu;

import java.util.Scanner;

public class Ex06_main {
	public static void main(String[] args) {
		// 5명의 이름, 국어, 영어, 수학을 입력 받아서
		// 총점, 평균, 학점을 구하고
		// 출력하자

		Scanner scan = new Scanner(System.in);

		Ex06_method c1 = new Ex06_method(); // 객체 생성

		int su = 5; // 학생수

		String[] nameArr = new String[su]; // 이름을 저장할 int 배열
		int[] korArr = new int[su]; // 국어점수를 저장할 int 배열
		int[] engArr = new int[su]; // 영어점수를 저장할 int 배열
		int[] mathArr = new int[su]; // 수학점수를 저장할 int 배열
		int[] sumArr = new int[su]; // 총점을 저장할 int 배열
		double[] avgArr = new double[su]; // 평균을 저장할 double 배열
		String[] gradeArr = new String[su]; // 학점을 저장할 String 배열

		// day09 Ex06_Array 참고
		// 입력 받기
		for (int i = 0; i < su; i++) {
			System.out.print("\n이름 : ");
			nameArr[i] = scan.next();

			System.out.print("국어 : ");
			korArr[i] = scan.nextInt();

			System.out.print("영어 : ");
			engArr[i] = scan.nextInt();

			System.out.print("수학 : ");
			mathArr[i] = scan.nextInt();
		}

		// 총점 구하기
		sumArr = c1.getSum(korArr, engArr, mathArr);

		// 평균 구하기
		avgArr = c1.getAvg(sumArr);

		// 학점 구하기
		gradeArr = c1.getGrade(avgArr);

//		for (int i = 0; i < su; i++) {
		// 총점 구하기
//			sumArr[i] = c1.getSum(korArr[i], engArr[i], mathArr[i]);
		// 평균 구하기
//			avgArr[i] = c1.getAvg(korArr[i], engArr[i], mathArr[i]);
		// 학점 구하기
//			gradeArr[i] = c1.getGrade(korArr[i], engArr[i], mathArr[i]);
//		}

		// 출력
		System.out.println("\n이름\t국어\t영어\t수학\t총점\t평균\t학점");
		for (int i = 0; i < su; i++) {
			System.out.print(nameArr[i] + "\t");
			System.out.print(korArr[i] + "\t");
			System.out.print(engArr[i] + "\t");
			System.out.print(mathArr[i] + "\t");
			System.out.print(sumArr[i] + "\t");
			System.out.print(avgArr[i] + "\t");
			System.out.println(gradeArr[i]);
		}
		
		scan.close();
	}

}
