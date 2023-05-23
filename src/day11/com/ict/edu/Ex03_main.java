package day11.com.ict.edu;

public class Ex03_main {
	public static void main(String[] args) {
		Ex03_method t1 = new Ex03_method();

		System.out.println("=== 메서드 실행하기 전 ===");
		System.out.println("총점 : " + t1.sum);
		System.out.println("평균 : " + t1.avg);
		System.out.println("학점 : " + t1.hak);

		System.out.println("=== 메서드 실행 ===");
//		t1.getSum();
//		t1.getAvg();
//		t1.getHak();
//
//		System.out.println("총점 : " + t1.sum);
//		System.out.println("평균 : " + t1.avg);
//		System.out.println("학점 : " + t1.hak);

		int k1 = t1.getSum();
		double k2 = t1.getAvg();
		String k3 = t1.getHak();

		System.out.println("총점 : " + k1);
		System.out.println("평균 : " + k2);
		System.out.println("학점 : " + k3);

		System.out.println("================");
	}
}
