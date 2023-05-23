package day02.com.ict.edu;
class Ex02 {
	public static void main(String[] args) {
		//문자 : 한 글자를 뜻한다.
		//숫자를 사용하는 방법과 ' '(홑따옴표)를 사용하는 방법
		//char 예약어를 사용
		//** 문자는 숫자로 저장된다

		//char 선언
		char c1;
		//char c2;

		//저장 **char에 저장되는 것은 숫자!
		c1 = 97; //97은 소문자 a
		//아스키 코드 표, 유니코드 표 참고
		//c2 = 98; //98은 소문자 b

		//c1 호출해서 출력하기
		System.out.println(c1);
		//System.out.println(c2);

		//error: incompatible types: possible lossy conversion from int to char
		//c1 = c1 - 32;

		//c1 = 65; //65는 대문자 A
		//System.out.println(c1);

		//선언과 저장을 한번에
		char c2 = 'a' - 32;

		char c3 = '0';

		char c4 = '국';

		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}
}