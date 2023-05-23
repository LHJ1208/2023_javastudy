package day03.com.ict.edu2;

public class Test05 {
	public static void main(String[] args) {
		int su = 3781;
		int unit = 10; //0이면 div 에러남
		
		int num1; //일의 자리
		int num2; //십의 자리
		int num3; //백의 자리
		int num4; //천의 자리
		
		//2안
		int res = 0; //나머지
		
		num4 = su / (unit * unit * unit);
		res = su % (unit * unit * unit);
		
		num3 = res / (unit * unit);
		res = res % (unit * unit);
		
		num2 = res / unit;
		num1 = res % unit;
		
		//1안
		//int temp = su;
		
		//num1 = temp % unit;
		//temp /= unit;
		
		//num2 = temp % unit;
		//temp /= unit;
		
		//num3 = temp % unit;
		//temp /= unit;

		//num4 = temp % unit;
		//temp /= unit;
		
		// 결과
		// 천의 자리 : 3
		// 백의 자리 : 7
		// 십의 자리 : 8
		// 일의 자리 : 1
		
		System.out.println("결과");
		System.out.println("천의 자리 : " + num4);
		System.out.println("백의 자리 : " + num3);
		System.out.println("십의 자리 : " + num2);
		System.out.println("일의 자리 : " + num1);
	}
}
