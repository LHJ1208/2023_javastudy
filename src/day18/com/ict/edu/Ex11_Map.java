package day18.com.ict.edu;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Ex11_Map {
	public static void main(String[] args) {
		// 대한민국, 캐나다, 영국, 스위스의 수도가 각각 HashMap에 저장시키고
		// 원하는 나라가 key값이 되어, 화면에서 나라를 물어보면 수도가 출력되는 프로그램 작성

		// 키보드로 입력 받기위해 Scanner 객체 생성
		Scanner scan = new Scanner(System.in);

		// 키보드로 입력받은 값을 저장할 문자열 변수
		String inputStr = "";

		// 출력할 문자열을 저장하는 변수
		String printStr = "";

		// 프로그램을 반복할지 저장하는 변수
		boolean loop = true;

		// 나라이름과 수도를 저장할 HashMap 객체 생성
		HashMap<String, String> map = new HashMap<>();

		map.put("대한민국", "서울");
		map.put("캐나다", "오타와");
		map.put("영국", "런던");
		map.put("스위스", "베른");

		Set<String> keys = map.keySet();

		loop = true;
		while (loop) {
			System.out.print("\n나라 입력 : ");
			inputStr = scan.next();

			if (keys.contains(inputStr)) {
				printStr = map.get(inputStr);
				printStr = inputStr + "의 수도는 " + printStr + " 입니다.";
			} else {
				printStr = inputStr + "의 수도는 데이터에 없습니다.";
			}
			System.out.println();
			System.out.println(printStr);

			while (true) {
				System.out.print("\n계속 하시겠습니까? (y/n) >> ");
				inputStr = scan.next();
				if (inputStr.equalsIgnoreCase("y")) {
					break;
				} else if (inputStr.equalsIgnoreCase("n")) {
					loop = false;
					break;
				}
			}
		}
	}
}
