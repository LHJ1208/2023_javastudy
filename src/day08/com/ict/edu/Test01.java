package day08.com.ict.edu;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String inputStr = "";
		String name = "";
		String nameStar = "";
		String phoneNum = "";
		String phoneNumStar = "";
		
		
		int strLength = 0;
		
		int tmpIndex1 = 0;
		int tmpIndex2 = 0;
		
		char tmpCh = ' ';
		
		System.out.print("이름을 입력하시오. ");
		inputStr = scan.next();
		name = inputStr;
		
//		tmpStr = "";
//		strLength = name.length();
//		starLength = strLength - 2;
//		for(int i = 0; i < starLength; i++) {
//			tmpStr = tmpStr + "*";
//		}
//		
//		nameStar = nameStar + name.charAt(0);
//		nameStar = nameStar.concat(tmpStr);
//		nameStar = nameStar + name.charAt(strLength-1);
		
		//강사님 방법
		nameStar = "";
		strLength = name.length();
		for(int i = 0; i < strLength; i++) {
			tmpCh = name.charAt(i);
			if(i == 0 || i == strLength -1) {
				nameStar += tmpCh;
			}
			else {
				nameStar += '*';
			}
		}

		System.out.println("이름 : " + name);
		System.out.println("이름 : " + nameStar);
		
		System.out.println("======");

		System.out.println("전화번호를 입력하시오. ");
		inputStr = scan.next();
		
		phoneNum = inputStr;
		strLength = phoneNum.length();	
		tmpIndex1 = phoneNum.lastIndexOf('-');
		
		phoneNumStar = "";
		for(int i = 0; i < strLength; i++) {
			tmpCh = phoneNum.charAt(i);
			if(i >= 0 && i <= tmpIndex1) {
				phoneNumStar += tmpCh;
			}
			else {
				phoneNumStar += "*";
			}
		}

		System.out.println("전화번호 : " + phoneNum);
		System.out.println("전화번호 : " + phoneNumStar);
		
		System.out.println("======");

		System.out.println("전화번호를 입력하시오. ");
		inputStr = scan.next();
		
		phoneNum = inputStr;		
		strLength = phoneNum.length();	
		tmpIndex1 = phoneNum.indexOf('-');
		tmpIndex2 = phoneNum.lastIndexOf('-');
		
		phoneNumStar = "";
		for(int i = 0; i < strLength; i++) {
			tmpCh = phoneNum.charAt(i);
			if(i >= tmpIndex1 + 1 && i <= tmpIndex2 - 1) {
				phoneNumStar += "*";
			}
			else {
				phoneNumStar += tmpCh;
			}
		}

		System.out.println("전화번호 : " + phoneNum);
		System.out.println("전화번호 : " + phoneNumStar);
		
		scan.close();
	}
}
