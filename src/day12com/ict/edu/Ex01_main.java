package day12com.ict.edu;

import java.util.Scanner;

public class Ex01_main {
	public static void main(String[] args) {
		Ex01_method coffee = new Ex01_method();
		coffee.name = "커피음료";// "롯데 레쓰비 마일드 커피 175ml";
		coffee.price = 1000;

		Ex01_method ion = new Ex01_method();
		ion.name = "이온음료";// "동아오츠카 포카리스웨트 240ml";
		ion.price = 1500;

		Ex01_method cola = new Ex01_method();
		cola.name = "탄산음료";// "롯데칠성음료 펩시제로슈거 라임향 355ml";
		cola.price = 1200;

		Ex01_method juice = new Ex01_method();
		juice.name = "과일음료";// "델몬트 스퀴즈사과 240ml";
		juice.price = 1800;

//		Ex01_method [] arr = new Ex01_method[4];
//		arr[0] = coffee;
//		arr[1] = ion;
//		arr[2] = cola;
//		arr[3] = juice;

		Ex01_method[] arr = { coffee, ion, cola, juice };

		System.out.println("=== 메뉴 ===");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("\n음료 : " + arr[i].name);
			System.out.println("가격 : " + arr[i].price);
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
			if (arr[i].price < input) {
				System.out.print("O\t");
			} else {
				System.out.print("X\t");
			}
		}

		System.out.println();
		System.out.println("선택하세요 >> ");
		String drink = scan.next();

		int output = 0;
		switch (drink) {
		case "커피":
			output = input - arr[0].price;
			break;
		case "이온":
			output = input - arr[1].price;
			break;
		case "탄산":
			output = input - arr[2].price;
			break;
		case "과일":
			output = input - arr[3].price;
			break;
		default:
			System.out.println("잘못 선택하셨습니다.");
			output = input;
		}
		
		System.out.println("잔돈 : " + output);
		
		scan.close();
	}
}
