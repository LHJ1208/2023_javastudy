package day04.com.ict.edu;

public class Ex05_multi_if {
	public static void main(String[] args) {
		// 다중 if문
		// 형식
		// if(조건식1) {
		// 조건식1이 참일 때 실행할 문장;
		// ...
		// 조건식1이 참일 때 실행할 문장;
		// } else if(조건식2) {
		// 조건식 1은 거짓이면서 조건식2가 참일 때 실행할 문장;
		// ...
		// 조건식 1은 거짓이면서 조건식2가 참일 때 실행할 문장;
		// } else if(조건식3) {
		// 조건식 1, 2가 거짓이면서 조건식3이 참일 때 실행할 문장;
		// ...
		// 조건식 1, 2가 거짓이면서 조건식3이 참일 때 실행할 문장;
		// } else {
		// 조건식 1,2,3 모두 거짓인 경우 실행할 문장;
		// ...
		// 조건식 1,2,3 모두 거짓인 경우 실행할 문장;
		// }

		//int k1의 점수가 90 이상이면 A학점, 80 이상이면 B학점, 70 이상이면 C학점, 나머지 F학점
		int k1 = 50;
		String str = "";
		
		if(k1 >= 90) str = "A학점";
		else if(k1 >= 80) str = "B학점";
		else if(k1 >= 70) str = "C학점";
		else str = "F학점";
		
		System.out.println("학점 : " + str);
		
		//char k2가 대문자인지, 소문자인지, 숫자인지, 기타문자인지 판별하자
		char k2 = '1';
		str = "";

		boolean upperCase = k2 >= 'A' && k2 <= 'Z';
		boolean lowerCase = k2 >= 'a' && k2 <= 'z';
		boolean numCase = k2 >= '0' && k2 <= '9';
		
		if(upperCase) str = "대문자";
		else if(lowerCase) str = "소문자";
		else if(numCase) str = "숫자";
		else str = "기타문자";
		
		System.out.println(str);
		
		//char k3이 A, a이면 아프리카, B,b이면 브라질, C,c이면 캐나다, 나머지는 한국
		char k3 = 'A';
		str = "";
		
		boolean africa = k3 == 'A' || k3 == 'a';
		boolean brazil = k3 == 'B' || k3 == 'b';
		boolean canada = k3 == 'C' || k3 == 'c';
		
		if(africa) str = "아프리카";
		else if(brazil) str = "브라질";
		else if(canada) str = "캐나다";
		else  str = "한국";
		
		System.out.println(str);		
		
		//menu가 1이면 카페모카 3500, 2이면 카페라떼 4000, 3이면 아메리카노 3000,
		//4이면 과일주스 3500이다. 친구와 같은 메뉴 2잔을 10000을 내고 먹었다.
		//잔돈은 얼마인가? (부가세 10% 포함), 친구와 같은 음료만 선택 가능
		
		int menu = 3; //주문한 메뉴
		
		int price1 = 3500; //카페모카 가격
		int price2 = 4000; //카페라떼 가격
		int price3 = 3000; //아메리카노 가격
		int price4 = 3500; //과일주스 가격
		
		int count = 2; //주문한 잔 수
		int inputMoney = 10000; //지불한 돈
		double surtax = 0.1; //부가세
		
		int priceMenu = 0; //주문한 메뉴 단가
		int priceOrder = 0; //주문 총가격(부가세 포함)
		int change = inputMoney; //잔돈
		str = "";
		
		if(menu == 1) {
			str = "카페모카";
			priceMenu = price1;
		}
		else if(menu == 2) {
			str = "카페라떼";
			priceMenu = price2;
		}
		else if(menu == 3) {
			str = "아메리카노";
			priceMenu = price3;
		}
		else if(menu == 4) {
			str = "수박주스";
			priceMenu = price4;
		}
		else {
			str = "선택메뉴 없음";
			priceMenu = 0;
			System.out.println("주문 오류!");
		}
		
		priceOrder = (int)(priceMenu * count * (1 + surtax));
		change = inputMoney - priceOrder;
		
		System.out.println("선택메뉴 : " + str);
		System.out.println("가격 : " + priceOrder + "원");
		System.out.println("잔돈 : " + change + "원");
		
		System.out.println(Math.pow(4, 3));
	}
}
