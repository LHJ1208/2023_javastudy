package day09.com.ict.edu;

public class Ex05_Array {
	public static void main(String[] args) {
		String[] name = { "홍", "김", "이", "박", "고" };
		int[] kor = { 80, 90, 80, 70, 100 };
		int[] eng = { 85, 95, 75, 85, 95 };
		int[] math = { 100, 95, 90, 100, 100 };

		int[] sum = new int[name.length];
		double[] avg = new double[name.length];
		String[] grade = new String[name.length];
		int[] rank = { 1, 1, 1, 1, 1 };
		

		// for문 이용해서 반복처리한다.
		for (int i = 0; i < name.length; i++) {
			rank[i] = 1;

			sum[i] = kor[i] + eng[i] + math[i];

			avg[i] = (sum[i] * 10 / 3) / 10.0;

			if (avg[i] >= 90) {
				grade[i] = "A";
			} else if (avg[i] >= 80) {
				grade[i] = "B";
			} else if (avg[i] >= 70) {
				grade[i] = "C";
			} else {
				grade[i] = "F";
			}
			
			//순위, 정렬 못 함
		}
		
		//순위를 구하자
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum.length; j++) {
				if(i == j) continue;
				if(sum[i] < sum[j]) {
					rank[i]++;
				}
			}
		}
		
		//출력
		System.out.println("이름\t총점\t평균\t학점\t순위");
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i] + "\t");
			System.out.print(sum[i] + "\t");
			System.out.print(avg[i] + "\t");
			System.out.print(grade[i] + "\t");
			System.out.println(rank[i]);
		}
	}
}
