package day03.com.ict.edu2;

public class Test04 {
	public static void main(String[] args) {
		// 카페모카가 6,500원 이다.
		// 친구와 둘이서 15,000원을 내고 각각 카페모카를 1잔 주문했다.
		// 잔돈은 얼마인가? (단, 부가세 10%포함)
		
		//입력 정보
		String name = "카페모카";
		int price = 6500;
		int number = 2;
		int inputMoney = 15000;
		double surtax = 0.1;
		int change;
		
		//부가세를 구하기 위해서 총금액을 구하자
		//int total = price * number;
		
		//둘 중 하나만 사용
		//int vat = total / 10; //vat == vat2
		//int vat2 = (int) (total * 0.1);
		//change = inputMoney - (total + vat);
		
		change = inputMoney - (int)(price * number * (1 + surtax));
		
		System.out.println(name + " " + price + "원을");
		System.out.println("친구와 " + number + "잔 주문하였다.");
		System.out.println("우리는 " + inputMoney + "원을 지불하였고");
		System.out.println(change + "원을 거슬러 받았다.");
		System.out.println("(부가세 " + surtax * 100 + "% 포함 계산)");
	}
}
