package day17.com.ict.edu;

import java.util.InputMismatchException;
import java.util.Scanner;

// 다중 catch : 예외가 한가지가 아니라 여러 가지가 발생할 경우 사용
// 주의 사항 : Exception을 사용할 경우 반드시 가장 아래 catch문에 사용
// 형식 :
//	try {
//		예외 발생 가능한 문장들;
//		예외가 발생되면 아래 문장들을 무시하고 catch문으로 이동한다.
//		예외 발생 가능한 문장들;
//		예외 발생 가능한 문장들;
//	} catch(발생한 예외객체 e) {
//		예외 발생시 처리하는 문장;
//	} catch(발생한 예외객체 e) {
//		예외 발생시 처리하는 문장;
//	}
public class Ex02_Exception {
	public static void main(String[] args) {
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);

				int su1 = 50;

				System.out.println("정수 입력 : ");
				int su2 = scan.nextInt();

				System.out.println("정답 : " + su1 / su2);
				break;

			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하시오.");
			} catch (ArithmeticException e) {
				System.out.println("0으로는 나눌 수 없습니다.");
			}
		}

		// Scanner을 반복문 밖에서 생성하는 경우
		Scanner scan2 = new Scanner(System.in);
		while (true) {
			try {
				int su1 = 50;

				System.out.println("정수 입력 : ");
				int su2 = scan2.nextInt();

				System.out.println("정답 : " + su1 / su2);
				break;

			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하시오.");
				scan2.nextLine();
			} catch (ArithmeticException e) {
				System.out.println("0으로는 나눌 수 없습니다.");
			}
		}
		// System.out.println("수고하셨습니다.");
	}
}
