package day03.com.ict.edu2;

public class Test01 {
	public static void main(String[] args) {
		// 이름이 홍길동인 사람의 점수가
		// 국어 90, 영어 80, 수학 80 점이다.
		// 총점과 평균을 구하자
		// 화면 출력은 이름, 총점, 평균만 출력하자
		// (단, 평균은 소수점 첫째자리까지 구하자)
		
		//입력벙보 : 원하는 정보를 얻기 위한 정보 (재료)
		String name = "홍길동";
		int kor = 90;
		int eng = 80;
		int math = 80;
		
		int sum;
		double avg;
		
		//총점, 평균 구하기
		sum = kor + eng + math;
		//avg = ((int)((double)sum / 3 * 10) / 10.0) ;
		avg = (double)(sum / 3);
		avg = (int)(avg * 10) / 10.0;
		
		System.out.println("이름 : " + name);		
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
	}
}
