package day06.com.ict.edu2;

import java.util.Scanner;

public class Ex03_Scanner3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputNum = 0;
		String inputStr = "";
		String printStr = "";

		// 근무시간이 8시간까지는 시간당 9620원 이고
		// 8시간을 초과한 시간 만큼은 1.5배를 지급한다.
		// 현재 근무한 시간이 10이다.
		// 얼마를 받아야 하는가?
		int workTime = 0; // 현재 근무한 시간
		int wagePerHour = 9620; // 시급
		int extraBasis = 8; // 초과근무 기준
		double extraRate = 1.5; // 초과근무시 추가급여율
		int myWage = 0; // 내 총급여

		System.out.print("근무시간 : ");
		inputNum = scan.nextInt();
		workTime = inputNum;

		if (workTime > extraBasis) {
			myWage = extraBasis * wagePerHour + (int) ((workTime - extraBasis) * wagePerHour * extraRate);
		} else {
			myWage = workTime * wagePerHour;
		}

		System.out.println("근무시간 : " + workTime + "시간");
		System.out.println("총급여 : " + myWage + "원");

		System.out.println();
		System.out.println("=====");
		System.out.println();

		// menu가 1이면 카페모카 3500, 2이면 카페라떼 4000,
		// 3이면 아메리카노 3000, 4이면 과일 쥬스 3500이다.
		// 친구와 함께 2잔을 10000 내고 먹었다.
		// 선택한 메뉴와 잔돈을 출력하자 (단, 부가세 10%는 포함)
		// (친구와 같은 음료을 먹어야 한다.)
		System.out.print("메뉴선택 \n1.카페모카(3500)\n2.카페라떼(4000)" + "\n3.아메리카노(3000)\n4.과일쥬스(3500)\n>>>>>>>>>  ");

		int orderMenu = 0; // 주문한 메뉴
		String menuName = ""; // 주문한 메뉴 이름

		int price1 = 3500; // 카페모카 가격
		int price2 = 4000; // 카페라떼 가격
		int price3 = 3000; // 아메리카노 가격
		int price4 = 3500; // 과일주스 가격

		String name1 = "카페모카";
		String name2 = "카페라떼";
		String name3 = "아메리카노";
		String name4 = "과일쥬스";

		int countCup = 0; // 주문한 잔 수
		int inputMoney = 0; // 지불한 돈
		double surtax = 0.1; // 부가세

		int priceMenu = 0; // 주문한 메뉴 단가
		int priceOrder = 0; // 주문 총가격(부가세 포함)
		int change = 0; // 잔돈

		inputNum = scan.nextInt();
		orderMenu = inputNum;
		System.out.print("몇 잔을 주문하십니까? ");
		inputNum = scan.nextInt();
		countCup = inputNum;
		System.out.print("지불한 돈은 얼마입니까? ");
		inputNum = scan.nextInt();
		inputMoney = inputNum;

		// 주문한 메뉴에 따라 단가, 이름 설정
		switch (orderMenu) {
		case 1:
			priceMenu = price1;
			menuName = name1;
			break;
		case 2:
			priceMenu = price2;
			menuName = name2;
			break;
		case 3:
			priceMenu = price3;
			menuName = name3;
			break;
		case 4:
			priceMenu = price4;
			menuName = name4;
			break;
		default:
			priceMenu = 0;
			menuName = "선택 없음";
		}

		if (priceMenu == 0) {
			priceOrder = 0;
		} else {
			priceOrder = (int) (priceMenu * countCup * (1 + surtax));
			change = inputMoney - priceOrder;
		}

		System.out.println("메뉴 : " + menuName);
		System.out.println("가격 : " + priceOrder + "원");
		System.out.println("잔돈 : " + change + "원");

		System.out.println();
		System.out.println("=====");
		System.out.println();

		// 나라를 입력하면 수도가 출력되게 하자
		// 한국 = 서울, 중국 = 베이징, 일본 = 도쿄, 미국 = 워싱턴, 이외에는 데이터 없음
		// switch case 문 사용
		System.out.print("나라이름 : ");

		String capitalName1 = "서울";
		String capitalName2 = "베이징";
		String capitalName3 = "도쿄";
		String capitalName4 = "워싱턴";
		String capitalName5 = "한양";

		inputStr = scan.next();

		switch (inputStr) {
		case "KOR":
		case "Korea":
		case "SouthKorea":
		case "대한민국":
		case "남한":
		case "한국":
			printStr = capitalName1;
			break;
		case "중국":
			printStr = capitalName2;
			break;
		case "일본":
			printStr = capitalName3;
			break;
		case "도쿄":
			printStr = capitalName4;
			break;
		case "조선":
			printStr = capitalName5;
			break;
		default:
			printStr = "데이터 없음";
		}

		System.out.println(inputStr + "의 수도는 " + printStr + "입니다.");

		scan.close();
	}
}
