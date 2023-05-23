package day02.com.ict.edu;
class Ex03 {
	public static void main(String[] args) {
		//정수 : 소수점이 없는 숫자
		//실수 : 소수점이 있는 숫자
		//정수 < 실수 **무조건 실수가 크다
		//정수 long(8byte) < 실수 float(4byte)

		//정수 : byte < short < int < long
		//기본은 int 이다.

		//실수 : float < double
		//기본은 double 이다.

		//1. byte : -128 ~ 127 (256 = 2^8)
		//error: incompatible types: possible lossy conversion from int to byte
		//byte su1 = 125 + 5;

		byte su1 = 125;
		System.out.println(su1);

		//error: incompatible types: possible lossy conversion from int to byte
		//su1 = su1 + 5;
		//System.out.println(su1);

		//2. short : -32768 ~ 32767 (65536 = 2^16)
		short su2 = 125;
		System.out.println(su2);

		//숫자에서 큰 자료형과 작은 자료형이 계산을 하면 결과는 큰 자료형을 갖는다.

		//3. int : 정수의 기본
		int su3 = 125;
		System.out.println(su3);

		//4. long : int보다 더 넓은 범위를 가지고 있음
		//기본적으로 숫자 뒤에 L 또는 (소문자)l 을 붙인다. (생략 가능)

		long su4 = 125L;
		System.out.println(su4);

		//작은 자료형과 큰 자료형을 계산하면 결과는 큰 자료형으로 변경된다.
		//작은 자료형은 큰 자료형에 저장할 수 있다.
		//프로모션 : 더 큰 자료형에게 저장할 수 있다.
		long su5 = 125;
		System.out.println(su5);

		char c1 = 'A';
		int su6 = c1;
		System.out.println(su6);

		//error: incompatible types: possible lossy conversion from int to char
		//int su7 = 97;
		//char c2 = su7;

		//실수 : float < double
		//기본은 double

		//float : 숫자 뒤에 F나 f를 붙인다. (생략 불가능)
		float su7 = 13.3f;
		System.out.println(su7);

		//error: incompatible types: possible lossy conversion from double to float
		//su7 = 13.3;
		//System.out.println(su7);

		double su8 = 15.3;
		System.out.println(su8);

		//su8 = su8 + su7; //28.600000190734864
		su8 = su7; //13.300000190734863
		System.out.println(su8);

		//char를 double, int를 double 저장 (프로모션)
		char ch3 = 'a';
		int su9 = 37;

		double su10 = ch3;
		System.out.println(su10);

		su10 = su9;
		System.out.println(su10);
	}
}