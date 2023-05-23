package day09.com.ict.edu;

import java.util.Scanner;

public class Ex12_Array {
	public static void main(String[] args) {
		//과제 2
		//1) 키보드로 학생 수 받기
		//2) 키보드로 번호, 국어, 영어, 수학 입력 받기
		//3) 총점, 평균, 학점 구하기, 순위(초기값 지정)
		//4) 순위 구하기
		//5) 순위 기준 오름차순 정렬
		//6) 출력
		
		//Ex06_Array 참고
		
		Scanner scan = new Scanner(System.in);
		
		int inputNum = 0; //Scanner로 입력 받은 정수
		
		int numOfStu = 0; //학생수를 저장할 변수
		
		int [][] stuArr; //학생들의 정보를 저장할 변수
		
		//stuArr[?][0] => 번호
		//stuArr[?][1] => 국어
		//stuArr[?][2] => 영어
		//stuArr[?][3] => 수학
		//stuArr[?][4] => 총점
		//stuArr[?][5] => 평균(소수점 버림, 정수값만 저장)
		//stuArr[?][6] => 학점(char 변수값 프로모션 하여서 저장)
		//stuArr[?][7] => 순위
		
		//1) 키보드로 학생 수 받기
		System.out.print("학생 수 : ");
		inputNum = scan.nextInt();
		numOfStu = inputNum;
		
		//입력 받은 학생 수에 따라 배열 생성
		stuArr = new int[numOfStu][];

		System.out.println();
		for (int i = 0; i < numOfStu; i++) {
			//**중요 for문 안에 객체 만드는 패턴
			//for문 실행될 때마다 한사람의 정보를 담을 수 있는 배열을 만들자.
			int[] p = new int[8];
			
			//2) 키보드로 번호, 국어, 영어, 수학 입력 받기
			System.out.print("번호 : ");
			inputNum = scan.nextInt();
//			stuArr[i][0] = inputNum;
			p[0] = inputNum;
			System.out.print("국어 : ");
			inputNum = scan.nextInt();
//			stuArr[i][1] = inputNum;
			p[1] = inputNum;
			System.out.print("영어 : ");
			inputNum = scan.nextInt();
//			stuArr[i][2] = inputNum;
			p[2] = inputNum;
			System.out.print("수학 : ");
			inputNum = scan.nextInt();
//			stuArr[i][3] = inputNum;
			p[3] = inputNum;
			
			System.out.println();
			
			//3) 총점, 평균, 학점 구하기, 순위(초기값 지정)
//			stuArr[i][4] = stuArr[i][1] + stuArr[i][2] + stuArr[i][3];
//			stuArr[i][5] = stuArr[i][4] / 3; //소수점 버림, 정수값만 저장
			p[4] = p[1] + p[2] + p[3];
			p[5] = p[4] / 3;
			
			if(p[5] >= 90) {
				p[6] = 'A';
			} else if(p[5] >= 80) {
				p[6] = 'B';
			} else if(p[5] >= 70) {
				p[6] = 'C';
			} else {
				p[6] = 'F';
			}
			
			p[7] = 1;
			
			//**중요 다차원배열에 넣자
			stuArr[i] = p;
			
//			if(stuArr[i][5] >= 90) {
//				stuArr[i][6] = 'A';
//			} else if(stuArr[i][5] >= 80) {
//				stuArr[i][6] = 'B';
//			} else if(stuArr[i][5] >= 70) {
//				stuArr[i][6] = 'C';
//			} else {
//				stuArr[i][6] = 'F';
//			}
			
//			stuArr[i][7] = 1; //순위 값 1로 초기화		
		}
		
		//4) 순위 구하기
		for (int i = 0; i < numOfStu; i++) {
			
			for (int j = 0; j < numOfStu; j++) {
				//총점을 비교해서 stuArr[i]의 총점이 stuArr[j]의 총점보다 작으면 i의 순위를 하나 증가시킨다
				if(stuArr[i][4] < stuArr[j][4]) stuArr[i][7]++;
			}
		}	
		
		//5)순위 기준 오름차순 정렬
		int[] tmp; //순위를 비교하고 바꿀 때 쓸 임시 변수
		
		for (int i = 0; i < stuArr.length - 1; i++) {
			for (int j = i + 1; j < stuArr.length; j++) {
				//순위를 비교해서 stuArr[i]의 순위가 stuArr[j]의 순위보다 크면 i,j의 순서를 바꾼다.
				if(stuArr[i][7] > stuArr[j][7]) { 
					tmp = stuArr[i];
					stuArr[i] = stuArr[j];
					stuArr[j] = tmp;
				}
			}
		}
		
		//6) 출력
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균\t학점\t순위");
		
		for (int i = 0; i < stuArr.length; i++) {
			for (int j = 0; j < stuArr[i].length; j++) {
				//학점을 출력할 때는 배열에 저장되어 있는 int 값을 char로 형변환하여 출력한다
				if(j == 6) System.out.print((char)stuArr[i][j] + "\t");
				else System.out.print(stuArr[i][j] + "\t");
			}
			System.out.println();
		}
		
		scan.close();
	}
}
