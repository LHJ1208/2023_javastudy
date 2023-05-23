package day12com.ict.edu;

import java.util.Scanner;

public class Ex04_main {
	public static void main(String[] args) {
		// 5명의 이름, 국어, 영어, 수학을 입력 받아서
		// 총점, 평균, 학점, 순위를 구하고
		// 순위 기준 오름차순 정렬해서 출력하자

		Scanner scan = new Scanner(System.in);

		// 임시저장 변수
		String tmpStr = "";
		int tmpNum = 0;
		double tmpNum2 = 0.0;

		int su = 5; // 학생수

		// Ex04_get_sete로 만들어진 객체만 저장하는 배열 (객체형 배열 = 참조자료형 배열)
		Ex04_get_set[] arr = new Ex04_get_set[su];

		for (int i = 0; i < arr.length; i++) {
			Ex04_get_set person = new Ex04_get_set();

			System.out.print("이름 : ");
			tmpStr = scan.next();
			person.setName(tmpStr);

			System.out.print("국어 : ");
			tmpNum = scan.nextInt();
			person.setKor(tmpNum);

			System.out.print("영어 : ");
			tmpNum = scan.nextInt();
			person.setEng(tmpNum);

			System.out.print("수학 : ");
			tmpNum = scan.nextInt();
			person.setMath(tmpNum);

			System.out.println();

			tmpNum = person.getKor() + person.getEng() + person.getMath();
			person.setSum(tmpNum);

			tmpNum2 = (tmpNum * 10 / 3) / 10.0;
			person.setAvg(tmpNum2);

			if (tmpNum2 >= 90) {
				tmpStr = "A";
				person.setHak(tmpStr);
			} else if (tmpNum2 >= 80) {
				tmpStr = "B";
				person.setHak(tmpStr);
			} else if (tmpNum2 >= 70) {
				tmpStr = "C";
				person.setHak(tmpStr);
			} else {
				tmpStr = "F";
				person.setHak(tmpStr);
			}

			person.setRank(1);

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
		Ex04_get_set tmp = new Ex04_get_set(); // 임시 저장 변수

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
