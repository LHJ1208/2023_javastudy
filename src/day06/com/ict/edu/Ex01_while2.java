package day06.com.ict.edu;

public class Ex01_while2 {
	public static void main(String[] args) {
		// 구구단 version1
		int i = 2; // 초기식
		while (i < 10) { // 조건식

			int j = 1; // 초기식
			while (j < 10) { // 조건식
				System.out.println(i + " x " + j + " = " + (i * j));
				j++;// 증감식
			}

			i++; // 증감식
		}
		
		System.out.println("======================================================================");

		// 구구단 version2
		i = 2; // 초기식
		while (i < 10) { // 조건식

			int j = 1; // 초기식
			while (j < 10) { // 조건식
				System.out.print(i + "x" + j + "=" + (i * j) + "\t");
				j++; // 증감식
			}
			// i*j=i*j 문자열을 9번 출력하고 줄바꿈 한 번을 해줌
			System.out.println();

			i++; // 증감식
		}
		
		System.out.println("======================================================================");

		// 구구단 version3
		i = 1; // 초기식
		while (i < 10) { // 조건식

			int j = 2; // 초기식
			while (j < 10) { // 조건식
				System.out.print(j + "x" + i + "=" + (j * i) + "\t");
				j++; // 증감식
			}
			// j*i=j*i 문자열을 9번 출력하고 줄바꿈 한 번을 해줌
			System.out.println();

			i++; // 증감식
		}
		
		System.out.println("======================================================================");

	}
}
