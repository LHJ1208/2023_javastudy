package day05.com.ict.edu;

public class Ex03_for2 {
	public static void main(String[] args) {
		//중첩 for 문 : for문 안에 또 다른 for문이 존재
		
		for(int i = 1; i < 4; i++) {
			System.out.println("실행문1 (위)");
			for(int j = 1; j < 6; j++) {
				System.out.println("i = " + i + ", j = " + j);
			} //안쪽 for문 끝
			System.out.println("실행문2 (아래)");
		} //바깥 for문 끝
		
		//시침과 분침 for문 예시 //시침,분침,초침
//		int min;
//		int hour;
//		for(min = 0, hour = 0 ; hour < 24; hour++) {
//			for(min = 0; min < 60; min = min + 20) {
//				System.out.println(hour + "시 " + min + "분");
//			}
//		}
		System.out.println("============");		
		
//		//구구단 출력
		for(int i = 2; i < 10; i++) {
			System.out.println();
			System.out.println(i + "단");
			for(int j = 1; j < 10; j++) {
				System.out.println(i+ " x " + j + " = " + (i * j));
			}
		}
		
		//구구단 출력
		//for(int i = 2; i < 10; i++) for(int j = 1; j < 10; j++) System.out.println(i+ " x " + j + " = " + (i * j));
		

		System.out.println("============");
		
		//구구단 출력 version2
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.print(i+ "x" + j + "=" + (i * j) + "\t");
			}
			System.out.println();
		}

		System.out.println("============");		
		
		//구구단 출력 version3
		for(int i = 1; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				System.out.print(j + "x" + i + "=" + (j * i) + "\t");
			}
			System.out.println();
		}
	}
}
