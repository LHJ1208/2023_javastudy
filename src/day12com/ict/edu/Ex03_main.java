package day12com.ict.edu;

import java.util.Scanner;

public class Ex03_main {
	public static void main(String[] args) {
		String tmpStr = "";
		int tmpNum = 0;
		
		Ex03_get_set coffee = new Ex03_get_set();
		coffee.setName("커피음료");
		coffee.setPrice(1000);

		Ex03_get_set ion = new Ex03_get_set();
		ion.setName("이온음료");
		ion.setPrice(1500);

		Ex03_get_set cola = new Ex03_get_set();
		cola.setName("탄산음료");
		cola.setPrice(1200);

		Ex03_get_set juice = new Ex03_get_set();
		juice.setName("과일음료");
		juice.setPrice(1800);

		Ex03_get_set[] arr = { coffee, ion, cola, juice };

		System.out.println("=== 메뉴 ===");
		for (int i = 0; i < arr.length; i++) {
			tmpStr = arr[i].getName();
			System.out.println("\n음료 : " + tmpStr);
			tmpNum = arr[i].getPrice();
			System.out.println("가격 : " + tmpNum);
		}

		Scanner scan = new Scanner(System.in);
		System.out.print("\n금액을 투입하세요 >>> ");
		int input = scan.nextInt();

		// 음료들의 최소금액을 구하자. (오름차순에서 맨 처음 최소값, 맨 끝이 최대값)

		int minPrice = 1000;

		if (input < minPrice) {
			System.out.println("금액이 부족합니다.");
			System.out.println("잔돈 : " + input);
		} else {
			System.out.println("\n커피\t이온\t콜라\t과일");
		}

		// 입력금액과 각 음료수의 가격을 비교
		for (int i = 0; i < arr.length; i++) {
			tmpNum = arr[i].getPrice();
			if (tmpNum < input) {
				System.out.print("O\t");
			} else {
				System.out.print("X\t");
			}
		}

		System.out.println("\n\n선택하세요 >> ");
		String drink = scan.next();

		int output = 0;
		switch (drink) {
		case "커피":
			tmpNum = arr[0].getPrice();
			output = input - tmpNum;
			break;
		case "이온":
			tmpNum = arr[1].getPrice();
			output = input - tmpNum;
			break;
		case "탄산":
			tmpNum = arr[2].getPrice();
			output = input - tmpNum;
			break;
		case "과일":
			tmpNum = arr[3].getPrice();
			output = input - tmpNum;
			break;
		default:
			System.out.println("\n잘못 선택하셨습니다.");
			output = input;
		}
		
		System.out.println("\n잔돈 : " + output);
		
		scan.close();
	}
}
