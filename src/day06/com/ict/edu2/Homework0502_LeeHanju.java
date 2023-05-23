package day06.com.ict.edu2;

import java.util.Scanner;

public class Homework0502_LeeHanju {
	public static void main(String[] args) {
		// 숙제 0
		// Scanner class에서 next 메서드와 nextline 메서드 차이점 알아오기
		
		//next 메서드와 nextline 메서드의 차이점!
		
		//next 메서드는 Scanner에 입력된 값을
		//식별자(delimiter)[자바에서 정의되어 있는 whitespace]기준으로 나누고 토큰을 나누고 반환합니다.
		//정규표현식 "(?s).*" 을 토큰을 나누고 반환합니다.
		//whitespace 에는 '\t', '\n'등 의 문자들이 포함되어 있습니다.
		
		//nextline 메서드는 Scanner에 입력된 값을 한 줄씩(\n 개행문자 기준 한 줄) 나누고 값을 반환합니다.
		
		//ex) Scanner scan
		//입력된 내용\t입니다.\n
		//두번째줄입니다.\n
		
		//next() 메서드 사용
		//int str = scan.next(); //"입력된"
		//str = scan.next(); //"내용"
		//str = scan.next(); //"입니다."
		//str = scan.next(); //"두번째줄입니다."
		
		//nextline() 메서드 사용
		//str = scan.next(); //"입력된 내용\t입니다."
		//str = scan.next(); //"두번째줄입니다."
		
		//참조 사이트: 
		//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html
		
		
		//next 메서드 
		
		//public String next()
		//Finds and returns the next complete token from this scanner.
		//A complete token is preceded and followed by input that matches the delimiter pattern.
		//This method may block while waiting for input to scan,
		//even if a previous invocation of hasNext() returned true.
		
		//Returns:
		//the next token
		
		
		//public String nextLine()		
		//Advances this scanner past the current line and returns the input that was skipped.
		//This method returns the rest of the current line, excluding any line separator at the end.
		//The position is set to the beginning of the next line.
		//Since this method continues to search through the input looking for a line separator,
		//it may buffer all of the input searching for the line to skip if no line separators are present.

		//Returns:
		//the line that was skipped
		
		
		
		
		int inputInt = 0;
		double inputDouble = 0;
		String inputStr = "";
		String printStr = "";

		Scanner scan = new Scanner(System.in);

		//문제 1
//			원하는 회수를 입력 받고 
//			숫자를 입력 받아서 
//			입력 받은 숫자가 홀수 인지, 짝수인지 판별하는 코딩
		
		int repNum = 0; // 반복횟수

		System.out.println("☆ 홀짝 판별 프로그램 ☆\n");
		System.out.println("입력 받은 숫자를 홀수/짝수 판별합니다.");
		System.out.println("판별을 몇 번을 반복하겠습니까? (횟수 입력)");

		inputInt = scan.nextInt();

		repNum = inputInt; // 초기식
		while (repNum > 0) { // 조건식
			System.out.print("\n홀/짝을 판별한 숫자를 입력하시오 : ");
			inputInt = scan.nextInt();

			if (inputInt % 2 == 0)
				printStr = "짝수";
			else
				printStr = "홀수";

			System.out.println(inputInt + "은(는) " + printStr + "입니다.");

			repNum--; // 증감식
		}

		System.out.println();
		System.out.println("==========");
		System.out.println();

		//문제2
//			이름, 국어, 영어, 수학를 입력 받아서 
//			총점, 평균, 학점을 구하고 
//			이름, 총점, 평균, 학점을 출력하는 코딩 
//			(평균은 소숫점 첫째자리까지 구하자)
		
		String name = ""; // 이름
		int kor = 0; // 국어 점수
		int eng = 0; // 영어 점수
		int math = 0; // 수학 점수
		int total = 0; // 총점
		double avg = 0; // 평균
		String grade = ""; // 학점

		int cutNum = 0;

		String grade1 = "A";
		String grade2 = "B";
		String grade3 = "C";
		String grade4 = "F";

		System.out.println("☆ 성적 계산 프로그램 ☆");
		System.out.print("\n이름을 입력하시오 : ");
		inputStr = scan.next();
		name = inputStr;
		System.out.println("\n국어 점수를 입력하시오 : ");
		inputInt = scan.nextInt();
		kor = inputInt;
		System.out.println("\n영어 점수를 입력하시오 : ");
		inputInt = scan.nextInt();
		eng = inputInt;
		System.out.println("\n수학 점수를 입력하시오 : ");
		inputInt = scan.nextInt();
		math = inputInt;

		total = kor + eng + math;
		avg = (int) (total * 10 / 3.0) / 10.0;

		cutNum = (int) (avg / 10);
		switch (cutNum) {
		case 10:
		case 9:
			grade = grade1;
			break;
		case 8:
			grade = grade2;
			break;
		case 7:
			grade = grade3;
			break;
		default:
			grade = grade4;
		}

		System.out.println();
		System.out.println(name + "님의 성적");
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		System.out.println("학점 : " + grade);

		System.out.println();
		System.out.println("==========");
		System.out.println();

		//문제 3
//			첫번째 숫자 받기
//			두번째 숫자 받기
//			연산자 받기("1 => + \n 2 => - \n 3 => * \n 4 =>  / \n>>>>   ")
		
		double num1 = 0;
		double num2 = 0;
		String operator = "";
		double result = 0;
		boolean divErr = false;
		boolean operErr = false;

//			String oper1 = "1";
		String addition = "+";
//			String oper2 = "2";
		String subtraction = "-";
//			String oper3 = "3";
		String multiplication1 = "x";
//			String multiplication2 = "X";
//			String multiplication3 = "*";
//			String oper4 = "4";
		String division = "/";
//			String oper5 = "5";
		String modulo = "%";

		System.out.println("☆ 숫자 계산 프로그램 ☆");
		System.out.println("\n계산할 숫자 두 개와 계산에 사용할 연산자를 입력하게 됩니다.");
		System.out.print("\n첫번째 숫자를 입력하시오 : ");
		inputDouble = scan.nextDouble();
		num1 = inputDouble;
		System.out.print("\n두번째 숫자를 입력하시오 : ");
		inputDouble = scan.nextDouble();
		num2 = inputDouble;
		System.out.println("\n사용할 연산자 입력하시오.");
		System.out.print(" 1 => + \n 2 => - \n 3 => * \n 4 => / \n >>>> ");
		inputStr = scan.next();
		operator = inputStr;

		switch (operator) {
		// 덧셈 연산
		case "1":
		case "+":
			operator = addition;
			result = num1 + num2;
			break;
		// 뺄셈 연산
		case "2":
		case "-":
			operator = subtraction;
			result = num1 - num2;
			break;
		// 곱셈 연산
		case "3":
		case "x":
		case "X":
		case "*":
			operator = multiplication1;
			result = num1 * num2;
			break;
		// 나눗셈 연산
		case "4":
		case "/":
			operator = division;
			if (num2 == 0) {
				divErr = true;
			} else {
				result = num1 / num2;
			}
			break;
		// 나머지 연산
		case "5":
		case "%":
			operator = modulo;
			if (num2 == 0) {
				divErr = true;
			} else {
				result = num1 / num2;
			}
			break;
		default:
			operErr = true;
		}

		System.out.println();
		if (operErr) {
			System.out.println("계산 불가: 연산자 입력 오류");
		} else if (divErr) {
			System.out.println("계산 불가: 나눗셈 오류");
		} else {
			System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
		}
		
		scan.close();
	}
}
