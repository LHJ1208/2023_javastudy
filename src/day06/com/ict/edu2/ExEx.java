package day06.com.ict.edu2;

import java.util.Scanner;
//import java.util.regex.Pattern;

public class ExEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner("abc\t\n\t\tdef");
//		Pattern p = Pattern.compile("(?s).*");
				
		String str;
		
		str = scan.nextLine();		
		System.out.println(str);
		
		str = scan.nextLine();		
		System.out.println(str);
		
//		str = scan.next();		
//		System.out.println(str);
//
//		str = scan.next();		
//		System.out.println(str);
		
		scan.close();
	}
}
