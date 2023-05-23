package day12com.ict.edu;

import java.util.Scanner;

public class HW0511T3_main {
	public static void main(String[] args) {

		// 키보드로 입력받기 위해 Scanner 객체 생성
		Scanner scan = new Scanner(System.in);

		// 임시 저장 변수
		String tmpStr = "";
		int tmpNum = 0;

		int inputMoney = 0; // 받은 돈
		int change = 0; // 잔돈

		// 음료수에 대한 정보들을 저장할 배열 선언
		HW0511T3_drink[] arr;

		int kindOfDrink = 4; // 음료수 종류 개수

		// 참조자료형 배열 생성
		arr = new HW0511T3_drink[kindOfDrink];

		// 음료수 초기값
		String[] nameArr = { "커피음료", "이온음료", "탄산음료", "과일음료" };
		int[] priceArr = { 1000, 1500, 1200, 1800 };
		int[] countArr = { 3, 4, 2, 1 };

		// 음료수 초기값을 클래스에 넣기
		for (int i = 0; i < kindOfDrink; i++) {
			HW0511T3_drink one = new HW0511T3_drink(nameArr[i], priceArr[i], countArr[i]);
			arr[i] = one;
		}

		// 음료들의 최소금액을 구하자.
		int minPrice = arr[0].getPrice();
		for (int i = 1; i < kindOfDrink; i++) {
			tmpNum = arr[i].getPrice();
			if (minPrice > tmpNum)
				minPrice = tmpNum;
		}

		// 초기 금액 투입
		System.out.print("\n금액을 투입하세요 >>> ");
		inputMoney = scan.nextInt();
		System.out.println();

		esc: while (true) {
			// 음료들의 최소금액보다 현재금액이 적으면 잔돈 반환
			if (inputMoney < minPrice) {
				change = inputMoney;
				break;
			}

			while (true) {
				System.out.println("=================== 메뉴 ===================");

				System.out.print("종류\t");
				for (int i = 0; i < kindOfDrink; i++) {
					tmpStr = arr[i].getName();
					System.out.print(tmpStr + "\t");
				}
				System.out.println("반환");

				System.out.print("가격\t");
				for (int i = 0; i < kindOfDrink; i++) {
					tmpNum = arr[i].getPrice();
					System.out.print(tmpNum + "\t");
				}
				System.out.println();

				System.out.print("구매가능\t");
				for (int i = 0; i < kindOfDrink; i++) {
					tmpStr = "";
					tmpNum = arr[i].getPrice();

					if (arr[i].isEmpty())
						tmpStr += "품절";
					else if (arr[i].canBuy(inputMoney))
						tmpStr += "O";
					else
						tmpStr += "X";

					System.out.print(tmpStr + "\t");
				}
				System.out.println();

				System.out.println("현재 금액 : " + inputMoney);

				System.out.print("선택하세요 >> ");
				tmpStr = scan.next();
				System.out.println();

				// 입력받은 문자열이 "반환"이면
				if (tmpStr.equals("반환")) {
					change = inputMoney;
					break esc;
				}

				for (int i = 0; i < kindOfDrink; i++) {
					tmpNum = arr[i].getPrice();
					// 입력받은 문자열이 음료수 이름과 같고
					// 음료수가 비어있지 않고
					// 음료수 가격이 현재금액 이하이면 if문 수행
					if (arr[i].isEqualsName(tmpStr) && !arr[i].isEmpty() && arr[i].canBuy(inputMoney)) {
						inputMoney = inputMoney - tmpNum; // 현재금액에서 음료수 가격 빼기
						arr[i].setCount(arr[i].getCount() - 1); // 음료수 재고 하나 감소
						// System.out.println(tmpStr + " 하나 나옴");
						tmpNum = arr[i].getCount();
						// System.out.println("자판기 안에 " + tmpStr + " " + tmpNum + "개 남음");
						// System.out.println("자판기 안에 " + inputMoney + "원 남음\n");
						continue esc;

					}
				}
			}
		}

		System.out.println("\n잔돈 : " + change + "원");
	}
}
