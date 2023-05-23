package day05.com.ict.edu;

public class Ex01_switch {
	public static void main(String[] args) {
		// switch ~ case : 다중 if ~ else 문과 비슷한 조건문 if문의 조건식은 boolean, 비교연산, 논리연산 즉 true,
		// false 일 때 사용 switch문 int, char, String 일 때 사용 (long, float, double 은 사용 불가)
		// 형식) switch(인자값 => int, char, String) {
		// case 조건값1 :
		// 인자값과 조건값1이 같을 때 수행할 문장; break;
		// case 조건값2 :
		// 인자값과 조건값2이 같을 때 수행할 문장;
		// 인자값과 조건값2가 같을 때 수행할 문장; break;
		// case 조건값3 :
		// 인자값과 조건값3이 같을 때 수행할 문장; break;
		// default : 조건값1,2,3 모두 같지 않을 때(나머지) 수행할 문장;
		// }

		// ** 주의사항 : break가 없으면 break를 만날 때까지 모든 실행문을 실행한다.
		// break의 역할은 실행중인 범위({ } 블록)를 벗어나는 역할을 한다. default는 생략 가능하다.

		// int k1이 1이면 카페모카, 2이면 카페라떼, 3이면 아메리카노, 4이면 과일쥬스를 출력하자.

		int k1 = 1;
		String str = "";

		switch (k1) {
		case 1: {
			str = "카페모카";
			break;
		}
		case 2:
			str = "카페라떼";
			break;
		case 3:
			str = "아메리카노";
			break;
		case 4:
			str = "과일쥬스";
			break;

		default:
			str += "메뉴 오류";
		}

		System.out.println("결과 : " + str);
		System.out.println("==================");

		// break가 없는 경우 : 다음 break를 만날 때까지 실행문을 모두 수행한다.
		int k2 = 2;
		switch (k2) {
		case 1: {
			str = "카페모카";
			System.out.println("결과 : " + str);
		}
		case 2:
			str = "카페라떼";
			System.out.println("결과 : " + str);
		case 3:
			str = "아메리카노";
			System.out.println("결과 : " + str);
		case 4:
			str = "과일쥬스";
			System.out.println("결과 : " + str);
		default:
			System.out.println("결과 : " + str);
		}

		System.out.println("==================");

		// char k3이 A, a, 1이면 아프리카, B, b, 2이면 브라질, C, c, 3이면 캐나다, 나머지 한국
		char k3 = 'C';

		switch (k3) {
		case '1':
		case 'A':
		case 'a':
			str = "아프리카";
			break;
		case '2':
		case 'B':
		case 'b':
			str = "브라질";
			break;
		case '3':
		case 'C':
		case 'c':
			str = "캐나다";
			break;
		default:
			str = "한국";
		}

		System.out.println("결과 : " + str);
		System.out.println("==================");

		// String k4가 한국이면 서울, 중국이면 베이징, 일본이면 도쿄를 출력하는 코딩

		String k4 = "일본";
		switch (k4) {
		case "한국":
			str = "서울";
			break;
		case "중국":
			str = "베이징";
			break;
		case "일본":
			str = "도쿄";
			break;
		default:
			str = "어느 나라?";
		}

		System.out.println("결과 : " + str);
		System.out.println("==================");

		// int k5가 3~5: 봄, 6~8: 여름, 9~11: 가을, 12,1,2: 겨울 출력하는 코딩

		int k5 = 12;
		switch (k5) {
		case 3:
		case 4:
		case 5:
			str = "봄";
			break;
		case 6:
		case 7:
		case 8:
			str = "여름";
			break;
		case 9:
		case 10:
		case 11:
			str = "가을";
			break;
		case 1:
		case 2:
		case 12:
			str = "겨울";
			break;
		default:
			str = "몇 월?";
		}

		System.out.println("결과 : " + str);
		System.out.println("==================");

		// switch에서 범위가 넓어지면 사용라지 말자 (if문 사용하자)
		// int k6의 점수가 90 이상이면 A학점, 80 이상이면 B학점, 70 이상이면 C학점, 나머지 F학점
		int k6 = 0;

//		switch(k6) {
//		case 100: case 99: *** case 90: str = "A학점"; break; 
//		case 89: *** case 80: str = "B학점"; break; 
//		case 79: *** case 70: str = "B학점"; break; 
//		default: str = "F학점"; break;		
//		}	

		k6 = 66;
		switch (k6 / 10) {
		case 10:
		case 9:
			str = "A학점";
			break;
		case 8:
			str = "B학점";
			break;
		case 7:
			str = "C학점";
			break;
		default:
			str = "F학점";
			break;
		}

		System.out.println("결과 : " + str);
		System.out.println("==================");
	}
}
