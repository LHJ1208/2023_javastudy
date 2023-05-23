package day02.com.ict.edu;
class Ex05 {
	public static void main(String[] args) {
//국어,영어,수학 입력을 받아서 총점,평균을 구하자!
//평균을 구할 때 형변환이 필요하다!
		int kor = 90;
		int eng = 80;
		int math = 80;

		//총점
		//int sum = 90 + 80 + 80;
		//데이터값을 직접 쓰지 말고 변수를 만들어서 쓰자! 그렇지 않으면 나중에 피곤해진다.
		int sum = kor + eng + math;

		//평균
		int avg = sum / 3 ; //소수점이 없음
		//소수점은 있지만 소수점 밑에 값이 날라감 ㅠㅠ
		double avg2 = sum / 3; //83.00
		//int / int => int => 소수점이 없음
		//얘도 소수점 밑에 값 날라감  //83.00
		double avg3 = (double)(sum/3);

		//소수점 가진 평균 //83.33
		double avg4 = (double)sum / 3;
		double avg5 = sum / 3.0;

		//형변환을 활용한 공식!
		double avg6 = (int)(avg5 * 100) / 100.0; //83.33

		//**실패 사례
		//83.33000000000001 <- 뒤에 1 조심!
		//double 자료형의 가수 부분의 범위를 넘어서 계산하면 오차가 발생한다!
		//double avg6 = avg5 - (avg5 * 100 - (int)(avg5 * 100)) / 100;

		//83.33333333330033 결과값 오류!
		//double avg7 = avg5 - ((long)(avg5 * Math.pow(10,12)) / Math.pow(10,10) - (long)(avg5 * Math.pow(10,10)) / Math.pow(10,8)) / 100;	

		System.out.println(sum);
		System.out.println(avg);
		System.out.println(avg2);
		System.out.println(avg3);
		System.out.println(avg4);
		System.out.println(avg5);
		System.out.println(avg6);

		//1472를 원 단위 절삭해서 1470으로 만들어 보자!
		int num1 = 1472;
		int num2 = (num1/10) * 10;

		System.out.println(num2);
	}
}