package day09.com.ict.edu;

public class Ex10_Array {
	public static void main(String[] args) {
		// 가변 길이
		int [][] su = new int[3][];
		
		//오류!		
		//int[][] su2 = new int[][];
		//int[][] su3 = new int[][4];
		
		//초기값을 고정길이방식으로 주면 안 됨(오류발생);
//		su[0][0] = 10;
//		su[0][1] = 20;
//		
//		su[1][0] = 100;
//		su[1][1] = 200;
//		
//		su[2][0] = 1000;
//		su[2][1] = 2000;
		
		//가변길이는 무조건 1차원 배열을 만들어서 넣어야 한다.
		int[] k1 = {10, 20, 30};
		int[] k2 = {100, 200};
		int[] k3 = {1000, 2000, 3000, 4000};
		
		//위에서 만든 배열을 다차원 배열에 넣어라
		su[0] = k1;
		su[1] = k2;
		su[2] = k3;

		//출력
		for (int i = 0; i < su.length; i++) {
			for (int j = 0; j < su[i].length; j++) {
				System.out.print(su[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("==========");
		
		//선언, 생성, 저장 한번에
		String[][] str = {{"java", "자바", "JAVA"}, {"JSP"}, {"HTML", "CSS"}};
		
		//출력
		for(int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				System.out.print(str[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("==========");
	}
}
