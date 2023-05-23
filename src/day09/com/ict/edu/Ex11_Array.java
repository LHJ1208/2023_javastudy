package day09.com.ict.edu;

public class Ex11_Array {
	public static void main(String[] args) {
		//과제 1
		//1)순위를 구하자
		//2)순위 기준 오름차순 정렬
		//3)출력
		
		int[][] arr = new int[5][5];
		
		//번호, 총점, 평균, 학점, 순위
		int[] p1 = {1, 270, 90, 'A', 1};
		int[] p2 = {2, 210, 70, 'C', 1};
		int[] p3 = {3, 180, 60, 'F', 1};
		int[] p4 = {4, 300, 100, 'A', 1};
		int[] p5 = {5, 285, 95, 'A', 1};
		
		//int 2차원 배열에 1차원 배열(p1~p5) 데이터 넣기
		arr[0] = p1;
		arr[1] = p2;
		arr[2] = p3;
		arr[3] = p4;
		arr[4] = p5;
		
		//arr[?][0] => 번호
		//arr[?][1] => 총점
		//arr[?][2] => 평균
		//arr[?][3] => 학점
		//arr[?][4] => 순위

		//순위 구하기 Ex04_Array, Ex05_Array, Ex06_Array 참고
		
		//1)순위를 구하자		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				//총점을 비교해서 arr[i]의 총점이 arr[j]의 총점보다 작으면 i의 순위를 하나 증가시킨다
				if(arr[i][1] < arr[j][1]) { 
					arr[i][4]++;
				}
			}
		}
		
		//오름차순 정렬하기 Ex03_Array 참고
		
		//2)순위 기준 오름차순 정렬
		int[] tmp; //순위를 비교할 때 쓸 임시 변수
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				//순위를 비교해서 arr[i]의 순위가 arr[j]의 순위보다 크면 i,j의 순서를 바꾼다.
				if(arr[i][4] > arr[j][4]) { 
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		//3)출력
		System.out.println("번호\t총점\t평균\t학점\t순위");
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(j == 3) System.out.print((char)arr[i][j] + "\t");
				else System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
