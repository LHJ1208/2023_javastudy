package day12com.ict.edu;

import java.util.Scanner;

public class Ex09_main {
	public static void main(String[] args) {

		// 5명의 이름, 국어, 영어, 수학을 입력 받아서
		// 총점, 평균, 학점, 순위를 구하고
		// 순위 기준 오름차순 정렬해서 출력하자

		Scanner scan = new Scanner(System.in);

		// 임시저장 변수
		int tmpNum = 0;

		int su = 5; // 학생수

		// Ex09_Constructore로 만들어진 객체만 저장하는 배열 (객체형 배열 = 참조자료형 배열)
		Ex09_Constructor[] arr = new Ex09_Constructor[su];

		for (int i = 0; i < arr.length; i++) {
			String name = "";
			int kor = 0;
			int eng = 0;
			int math = 0;

			System.out.print("이름 : ");
			name = scan.next();

			System.out.print("국어 : ");
			kor = scan.nextInt();

			System.out.print("영어 : ");
			eng = scan.nextInt();

			System.out.print("수학 : ");
			math = scan.nextInt();

			System.out.println();

			Ex09_Constructor person = new Ex09_Constructor(name, kor, eng, math);

			arr[i] = person;
		}

		// 순위 구하기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;
				if (arr[i].getSum() < arr[j].getSum()) {
					tmpNum = arr[i].getRank() + 1;
					arr[i].setRank(tmpNum);
				}
			}
		}

		// 순위 기준 오름차순 정렬하기
		Ex09_Constructor tmp = new Ex09_Constructor(); // 임시 저장 변수

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].getRank() > arr[j].getRank()) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		// 출력하기
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점\t순위");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].getName() + "\t");
			System.out.print(arr[i].getKor() + "\t");
			System.out.print(arr[i].getEng() + "\t");
			System.out.print(arr[i].getMath() + "\t");
			System.out.print(arr[i].getSum() + "\t");
			System.out.print(arr[i].getAvg() + "\t");
			System.out.print(arr[i].getHak() + "\t");
			System.out.println(arr[i].getRank());
		}
		
		scan.close();
	}
}
